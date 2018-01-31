package com.simplesys.hikari

import com.simplesys.sql.{PosgreSQLDialect, SQLDialect}
import com.zaxxer.hikari.HikariConfig

class PostgreHikariDataSource(override val pathBasename: String) extends HikariDataSource(pathBasename) {
    override def sqlDialect: SQLDialect = PosgreSQLDialect

    val pgConfig = new HikariConfig()
    pgConfig.setDataSourceClassName(settings.className.getOrElse("org.postgresql.ds.PGSimpleDataSource"))
    pgConfig.setUsername(settings.user)
    pgConfig.setPassword(settings.password)
    pgConfig.addDataSourceProperty("databaseName", settings.databaseName.getOrElse("postgres"))
    pgConfig.addDataSourceProperty("serverName", settings.url)

    //this(pgConfig)
}
