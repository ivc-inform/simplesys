package com.simplesys.hikari

import java.util.TimeZone

import com.simplesys.config.Config
import com.simplesys.db.pool.{PoolConfig, PoolDataSource}
import com.simplesys.log.Logging
import com.zaxxer.hikari.{HikariDataSource ⇒ JHikariDataSource}
import configs.syntax._

abstract class HikariDataSource(override val pathBasename: String) extends JHikariDataSource with PoolDataSource with Config with Logging {
    val settings: PoolConfig = config.get[PoolConfig](pathBasename).value

    logger trace s"settings: $settings"
    private val timeZone = TimeZone.getTimeZone(settings.timeZone)
    TimeZone setDefault timeZone
}
