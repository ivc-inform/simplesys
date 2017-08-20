package ru.simplesys.persistence.jooqwrapper

import org.jooq.DSLContext
import org.jooq.impl.DSL
import ru.simplesys.persistence.jooqwrapper.DialectHelper._
import com.simplesys.bonecp.BoneCPDataSource
import scalaz.Validation
import java.sql.Connection

object ControlStructs {
  def withSession[T](ds: BoneCPDataSource)(f: DSLContext => T): Validation[Throwable, T] = {
    Validation.fromTryCatch {
      val con = ds.getConnection
      try {
        val dsl = DSL.using(con, ds.getDriverClass)
        f(dsl)
      }
      finally {
        con.close()
      }
    }
  }

  def withSessionAccessToConnection[T](ds: BoneCPDataSource)(f: (DSLContext, Connection) => T): Validation[Throwable, T] = {
    Validation.fromTryCatch {
      val con = ds.getConnection
      try {
        val dsl = DSL.using(con, ds.getDriverClass)
        f(dsl, con)
      }
      finally {
        con.close()
      }
    }
  }

  def withTransaction[T](ds: BoneCPDataSource)(f: DSLContext => T): Validation[Throwable, T] = {
    Validation.fromTryCatch {
      val con = ds.getConnection
      val ac = con.getAutoCommit
      con.setAutoCommit(false)
      try {
        val dsl = DSL.using(con, ds.getDriverClass)
        val res = f(dsl)
        con.commit()
        con setAutoCommit ac
        res
      }
      catch {
        case e: Throwable =>
          con.rollback()
          con setAutoCommit ac
          throw e
      }
      finally {
        con.close()
      }
    }
  }
}