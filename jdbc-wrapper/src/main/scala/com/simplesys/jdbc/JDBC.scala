package com.simplesys.jdbc

import java.io.{BufferedReader, IOException, InputStream}
import java.sql.{Clob, SQLException}
import java.time.LocalDateTime

import com.simplesys.common.Strings._
import com.simplesys.jdbc.control.{BasicClassBOColumn, Table}
import com.simplesys.log.Logging
import io.circe.Json
import io.circe.Json._
import com.simplesys.circe.Circe.InputStreamOpt

import scala.reflect.ClassTag

object JDBC extends Logging{
    val quoted = true

    implicit def tt[S <: Table[S]](table: S): Option[S] = Some(table)

    implicit def set2List[T](set: Set[T]): List[T] = set.toList

    implicit def basicClassBOColumn2Array[T: ClassTag](column: BasicClassBOColumn[T]): Array[T] = Array(column.default)

    implicit def arrayString2OptionJsonString(value: Array[String]): Option[Json] = if (value.length == 0) None else Some(fromString(value.head))
    implicit def arrayString2OptionString(value: Array[String]): Option[String] = if (value.length == 0) None else Some(value.head)

    implicit def arrayBigDecimal2JsonElement(value: Array[BigDecimal]): Option[Json] = if (value.length == 0) None else Some(fromString(value.head.toString()))

    implicit def arrayLocalDateTime2JsonElement(value: Array[LocalDateTime]): Option[Json] = if (value.length == 0) None else Some(fromString(value.head.asString()))

    implicit def arrayLong2JsonElement(value: Array[Long]): Option[Json] = if (value.length == 0) None else Some(fromLong(value.head))

    implicit def arrayInt2JsonElement(value: Array[Int]): Option[Json] = if (value.length == 0) None else Some(fromInt(value.head))

    implicit def arrayDouble2JsonElement(value: Array[Double]): Option[Json] = if (value.length == 0) None else fromDouble(value.head)

    implicit def arrayBoolean2JsonElement(value: Array[Boolean]): Option[Json] = if (value.length == 0) None else Some(fromBoolean(value.head))

    implicit def arrayInputStream2JsonElement(value: Array[InputStream]): Option[Json] = if (value.length == 0) None else Some(fromString(new InputStreamOpt(value.head).asString))

    //implicit def unwrapOpt[T: ClassTag](value: T): Option[T] = Option(value)
    implicit def seqBigDecimal2BigDecimal(value: Seq[BigDecimal]): BigDecimal = value.head
    implicit def jDouble2BigDecimal(value: java.lang.Double): BigDecimal = BigDecimal(value)

    //Необходим для подддержки DSL In
    implicit def unwrapIterable[T](value: Iterable[T]): T = value.head

    implicit def convertClob2String(clob: Clob): String = {
        try {
            clob match {
                case null => strEmpty
                case _ =>
                    val sb = new StringBuilder
                    val reader = clob.getCharacterStream

                    val br = new BufferedReader(reader)
                    var line = br.readLine()
                    while (line != null) {
                        sb append line
                        line = br.readLine()
                    }
                    br.close()
                    sb.toString()
            }
        }
        catch {
            case e: SQLException =>
                logger error e
                strEmpty
            case e: IOException =>
                logger error e
                strEmpty
        }
    }
}
