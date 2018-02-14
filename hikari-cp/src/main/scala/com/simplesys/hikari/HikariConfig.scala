package com.simplesys.hikari

import java.util.TimeZone

import com.simplesys.config.Config
import com.simplesys.db.pool.{PoolConfig, PoolDataSource}
import com.simplesys.log.Logging
import com.zaxxer.hikari.{HikariDataSource ⇒ JHikariDataSource}
import configs.syntax._
import scalaz.concurrent.Task
import doobie.util.transactor.DataSourceTransactor

abstract class HikariDataSource(override val pathBasename: String) extends JHikariDataSource with PoolDataSource with Config with Logging {
    val settings: PoolConfig = config.get[PoolConfig](pathBasename).value

    val doobieDataSourceTransactor = DataSourceTransactor[Task](this)

    logger trace s"settings: $settings"
    private val timeZone = TimeZone.getTimeZone(settings.timeZone)
    TimeZone setDefault timeZone
}
