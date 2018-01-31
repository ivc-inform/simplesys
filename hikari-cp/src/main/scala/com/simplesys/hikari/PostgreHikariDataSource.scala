package com.simplesys.hikari

import com.simplesys.sql.{PosgreSQLDialect, SQLDialect}
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.{HikariDataSource ⇒ JHikariDataSource}

class PostgreHikariDataSource(override val pathBasename: String) extends HikariDataSource(pathBasename) {
    override def sqlDialect: SQLDialect = PosgreSQLDialect

    val pgConfig = new HikariConfig()

    pgConfig.setJdbcUrl(settings.url)
    pgConfig.setUsername(settings.user)
    pgConfig.setPassword(settings.password)
    pgConfig.setConnectionTimeout(settings.maxConnectionReuseTime.getOrElse(30000))
    pgConfig.setAutoCommit(settings.autoCommit.getOrElse(true))
    pgConfig.setMinimumIdle(settings.initialSize)
    pgConfig.setMaximumPoolSize(settings.maxSize.getOrElse(20))

    setDataSource(new JHikariDataSource(pgConfig))
}
