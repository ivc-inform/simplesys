package com.simplesys.hikari

import com.simplesys.sql.{OracleDialect, SQLDialect}
import oracle.jdbc.pool.OracleDataSource

class OracleHikariDataSource(override val pathBasename: String) extends HikariDataSource(pathBasename) {

    private val ods = new OracleDataSource()
    ods.setConnectionProperties(getProperties)
    ods.setURL(settings.url)
    ods.setUser(settings.user)
    ods.setPassword(settings.password)

    setDataSource(ods)
    settings.maxSize.foreach(setMaximumPoolSize(_))
    setMinimumIdle(settings.initialSize)

    override def getConnection() = super.getConnection()
    def sqlDialect: SQLDialect = OracleDialect
}
