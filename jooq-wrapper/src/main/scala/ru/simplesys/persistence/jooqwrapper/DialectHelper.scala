package ru.simplesys.persistence.jooqwrapper

import org.jooq.SQLDialect

object DialectHelper {
  implicit def getJooqDialect(jdbcDriver: String): SQLDialect = {

    val Oracle = """(.*)ORACLE(.*)""".r
    val Postgres = """(.*)POSTGRESQL(.*)""".r

    jdbcDriver.toUpperCase match {
      case Oracle(_, _) => SQLDialect.ORACLE
      case Postgres(_, _) => SQLDialect.POSTGRES
      case _ => throw new RuntimeException(s"Unknown mapping JDBC driver '${jdbcDriver}' to SQL Dialect")
    }
  }
}