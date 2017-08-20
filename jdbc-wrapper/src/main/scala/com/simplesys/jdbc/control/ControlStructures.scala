package com.simplesys.jdbc.control

import java.io.{PrintWriter, StringWriter}
import java.sql._
import java.util.concurrent.TimeoutException

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.common.Strings._
import com.simplesys.control.ControlStructs._
import com.simplesys.jdbc.exception.{NoDataFoundException, TooManyRowsException}
import com.simplesys.log.Logging

import scala.annotation.tailrec
import scalaz.Validation.FlatMap._
import scalaz.Validation._
import scalaz._

case class ValidationResult(message: String, stackTrace: String)

object ValidationEx {
    def apply[T](_result: => Validation[Throwable, T]): ValidationEx[T] = new ValidationEx(_result)
    def getValidationException(e: Throwable): ValidationResult = {
        @tailrec
        def clauses(e: Throwable, res: String): String = {
            val t = e.getCause

            t match {
                case null => res
                case _ => clauses(t, res.newLine + t.toString)
            }
        }

        e match {
            case e: BatchUpdateException =>
                val res = new StringBuilder
                res append newLine + "----BatchUpdateException----".newLine
                res append ("SQLState:".space + e.getSQLState.newLine)
                res append ("Message:".space + e.getMessage.replace("Call getNextException to see the cause.", "").newLine)
                res append ("Cause:".space + e.getNextException.toString.newLine)
                res append ("Vendor:".space + e.getErrorCode.toString.newLine)
                res append ("Update counts: [")

                val updateCounts = e.getUpdateCounts.toList
                val cnt = updateCounts.length
                for (i <- 0 to cnt - 1)
                    res append (updateCounts(i).toString.spaces(2))
                res append "]"
                ValidationResult(e.getMessage, res.toString())

            case e: SQLException =>
                ValidationResult(e.getMessage, newLine + "SQLState:".space + e.getSQLState.newLine + "Error Code:".space + e.getErrorCode.toString.newLine + "Message:".space + e.getMessage.newLine + clauses(e, ""))

            case e: TimeoutException =>
                val stackTrace = new StringWriter()
                e.printStackTrace(new PrintWriter(stackTrace))
                ValidationResult(e.getMessage.replace("Futures timed out after", "Время ожидания") + space + "истекло.", stackTrace.toString)

            case e =>
                val stackTrace = new StringWriter()
                e.printStackTrace(new PrintWriter(stackTrace))
                ValidationResult(e.getMessage, stackTrace.toString)
        }
    }
}

class ValidationEx[T](_result: => Validation[Throwable, T]) {

    lazy val result: Validation[Throwable, T] = fromTryCatchNonFatal(_result).flatMap(s => s)

    def printException: Option[ValidationResult] = {
        result match {
            case Success(_) => None
            case Failure(e: Throwable) =>
                Some(ValidationEx.getValidationException(e))
        }
    }
}

case class ValidationNelEx[T](result: Validation[NonEmptyList[Throwable], T]) {
    def printException: Option[NonEmptyList[ValidationResult]] = {
        result match {
            case Success(_) => None
            case Failure(list) =>
                val res: NonEmptyList[ValidationResult] = list map {
                    _ match {
                        case e: Throwable =>
                            ValidationEx.getValidationException(e)
                    }
                }
                Some(res)
        }
    }
}

case class ValidationExIterator[T](connection: Connection, preparedStatement: PreparedStatement, result: ValidationEx[T])

object SessionStructures extends Logging {

    def tryCatch[T](a: => T): ValidationEx[T] = try {
        ValidationEx(Success(a))
    } catch {
        case e: Throwable =>
            ValidationEx(Failure(e))
    }

    def session[T](dataSource: BoneCPDataSource)(f: (Connection) => T): ValidationEx[T] = {
        tryCatch {
            val connection = dataSource.Connection
            try {
                f(connection)
            }
            finally {
                connection.close()
            }
        }
    }

    def transaction[T](dataSource: BoneCPDataSource)(f: (Connection) => T): ValidationEx[T] = {
        tryCatch {
            val connection = dataSource.Connection
            val autoCommit = connection.getAutoCommit
            connection setAutoCommit false
            try {
                val res = f(connection)
                connection.commit()
                connection setAutoCommit autoCommit
                res
            }
            catch {
                case e: BatchUpdateException =>
                    connection.rollback()
                    connection setAutoCommit autoCommit

                    logger error e
                    throw e
                case e: Throwable =>
                    connection.rollback()
                    connection setAutoCommit autoCommit

                    logger error e
                    throw e
            }
            finally {
                connection.close()
            }
        }
    }

    def transactionEx[T](dataSource: BoneCPDataSource)(f: (Connection) => (T, Boolean)): ValidationEx[T] = {
        tryCatch {
            val connection = dataSource.Connection
            val autoCommit = connection.getAutoCommit
            connection setAutoCommit false
            try {
                val res: (T, Boolean) = f(connection)
                if (res._2)
                    connection.commit()
                else
                    connection.rollback()
                connection setAutoCommit autoCommit
                res._1
            }
            catch {
                case e: BatchUpdateException =>
                    connection.rollback()
                    connection setAutoCommit autoCommit

                    logger error e
                    throw e
                case e: Throwable =>
                    connection.rollback()
                    connection setAutoCommit autoCommit

                    logger error e
                    throw e
            }
            finally {
                connection.close()
            }
        }
    }

    def prepareStatement[T](connection: Connection, sqlStr: String, fetchSize: Int = 0)(f: PreparedStatement => T): T = {
        val prepareStatement = connection prepareStatement sqlStr
        if (fetchSize != 0)
            prepareStatement setFetchSize fetchSize
        using(prepareStatement)(f)
    }

    def executeQuery[T](st: PreparedStatement)(f: ResultSet => T): List[T] =
        using(st executeQuery) {
            resultSet =>
                boolMapList(resultSet next) {
                    f(resultSet)
                }
        }

    def executeQuery4Iterator[T](st: PreparedStatement)(f: ResultSet => T): Iterator[T] = {
        new Iterator[T] {
            val resulTSet = st executeQuery

            override def next(): T = f(resulTSet)
            override def hasNext: Boolean = resulTSet.next
        }
    }

    def iteration[T](validationExIterator: ValidationExIterator[T])(f: (T) => Unit) = {
        try {
            validationExIterator.result.result match {
                case Success(iterator) =>
                    f(iterator)

                case Failure(e) =>

                    logger error e
                    throw e
            }
        } catch {
            case e: Throwable =>

                logger error e
                throw e

        } finally {
            validationExIterator.preparedStatement.close()
            validationExIterator.connection.close()
        }
    }

    def iterrator2Iterator[A, R](iter: Iterator[A])(f: A => R): Iterator[R] = {
        new Iterator[R] {
            override def hasNext: Boolean = iter.hasNext
            override def next(): R = f(iter.next())
        }
    }

    def executeOne[T](st: PreparedStatement)(f: ResultSet => T): T =
        using(st executeQuery) {
            resultSet =>
                if (resultSet next) {
                    val res = f(resultSet)
                    if (resultSet next)
                        throw new TooManyRowsException
                    res
                }
                else
                    throw new NoDataFoundException
        }
}

