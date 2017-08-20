package com.simplesys.bonecp

import com.jolbox.bonecp.{BoneCPDataSource => JBoneCPDataSource}
import java.sql.{ResultSet, Connection}
import com.simplesys.log.Logging
import com.simplesys.sql.{OracleDialect, SQLDialect}
import ch.qos.logback.core.db.dialect.PostgreSQLDialect
import doobie.util.transactor.DataSourceTransactor

import scalaz.concurrent.Task

object BoneCPDataSource {
    def apply(proxy: JBoneCPDataSource) = new BoneCPDataSource(proxy)
    def apply(config: BoneCPConfig) = new BoneCPDataSource(config)
}

class BoneCPDataSource(/*protected[bonecp]*/ val proxy: JBoneCPDataSource, val config: BoneCPConfig) extends Logging {

    def this(config: BoneCPConfig) = this(new JBoneCPDataSource(config), config)

    def Close() = proxy.close()

    val DoobieDataSourceTransactor: DataSourceTransactor[Task, JBoneCPDataSource] = DataSourceTransactor[Task](proxy)

    def Connection: Connection = {
        val connection = proxy.getConnection
        val dbMetaData = connection.getMetaData

        logger trace (s"ResultSet.HOLD_CURSORS_OVER_COMMIT = ${ResultSet.HOLD_CURSORS_OVER_COMMIT}")
        logger trace (s"ResultSet.CLOSE_CURSORS_AT_COMMIT = ${ResultSet.CLOSE_CURSORS_AT_COMMIT}")
        logger trace (s"Default cursor holdability: ${dbMetaData.getResultSetHoldability}")
        logger trace (s"Supports HOLD_CURSORS_OVER_COMMIT? ${dbMetaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT)}")
        logger trace (s"Supports CLOSE_CURSORS_AT_COMMIT? ${dbMetaData.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT)}")
        connection
    }

    def Config: BoneCPConfig = config
    def DriverClasss = proxy.getDriverClass

    private val Oracle = """(.*)ORACLE(.*)""".r
    private val Postgres = """(.*)POSTGRESQL(.*)""".r

    def SQLDialect: SQLDialect = {
        val jdbcDriver = proxy.getDriverClass
        import com.simplesys.sql._

        jdbcDriver.toUpperCase match {
            case Oracle(_, _) => OracleDialect
            case Postgres(_, _) => PosgreSQLDialect
            case _ => throw new RuntimeException(s"Unknown mapping JDBC driver '${jdbcDriver}' to SQL Dialect")
        }
    }
}
