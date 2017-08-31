package com.simplesys.oracle.pool

import java.util.TimeZone

import com.simplesys.config.Config
import com.simplesys.db.pool.{PoolConfig, PoolDataSource}
import com.simplesys.log.Logging
import com.simplesys.sql.{OracleDialect, SQLDialect, UnknownDialect}
import configs.syntax._
import oracle.jdbc.OracleConnection
import oracle.ucp.jdbc
import oracle.ucp.jdbc.PoolDataSourceFactory

class OraclePoolDataSource(override val pathBasename: String) extends PoolDataSource with Config with Logging {

    val pds: jdbc.PoolDataSource = PoolDataSourceFactory.getPoolDataSource
    val settings: PoolConfig = config.get[PoolConfig](pathBasename).value

    logger trace s"settings: $settings"

    val timeZone = TimeZone.getTimeZone(settings.timeZone)
    TimeZone setDefault timeZone

    settings.className match {
        case Some(className) ⇒ pds setConnectionFactoryClassName className
        case None ⇒ pds setConnectionFactoryClassName "oracle.jdbc.pool.OracleDataSource"
    }

    pds setURL settings.url
    pds setUser settings.user
    pds setPassword settings.password
    pds setInitialPoolSize settings.initialSize

    settings.waitTimeout.foreach(pds.setConnectionWaitTimeout)
    logger trace s"connectionWaitTimeout : ${pds.getConnectionWaitTimeout}"
    settings.maxSize.foreach(pds.setMaxPoolSize)

    def getConnection(): OracleConnection = pds.getConnection().asInstanceOf[OracleConnection]
    def sqlDialect: SQLDialect = OracleDialect
}
