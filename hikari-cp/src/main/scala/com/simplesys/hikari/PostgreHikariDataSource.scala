package com.simplesys.hikari

import com.simplesys.sql.{PosgreSQLDialect, SQLDialect}
import com.zaxxer.hikari.HikariConfig

class PostgreHikariDataSource(override val pathBasename: String) extends HikariDataSource(pathBasename) {
    override def sqlDialect: SQLDialect = PosgreSQLDialect

    val pgConfig = new HikariConfig()
    pgConfig.setDataSourceClassName(settings.className.getOrElse("org.postgresql.ds.PGSimpleDataSource"))

    pgConfig.addDataSourceProperty("user", settings.databaseName.getOrElse("postgres"))
    pgConfig.addDataSourceProperty("password", settings.databaseName.getOrElse("postgres"))
    pgConfig.addDataSourceProperty("databaseName", settings.databaseName.getOrElse("postgres"))
    pgConfig.addDataSourceProperty("serverName", settings.url)
    pgConfig.addDataSourceProperty("portNumber", settings.port.getOrElse(5432))
    pgConfig.setUsername(settings.user)
    pgConfig.setPassword(settings.password)
    pgConfig.setConnectionTimeout(settings.maxConnectionReuseTime.getOrElse(30000))
    pgConfig.setAutoCommit(settings.autoCommit.getOrElse(true))
    pgConfig.setMinimumIdle(settings.initialSize)
    pgConfig.setMaximumPoolSize(settings.maxSize.getOrElse(20))

    setDataSourceProperties(pgConfig.getDataSourceProperties)
}
