package com.simplesys.slick

import javax.naming.InitialContext

import com.simplesys.slick.ConfigOps._
import com.typesafe.config.Config
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.JdbcProfile

object SlickDriver {
    def forDriverName(basePath:String, config: Config): JdbcProfile = DatabaseConfig.forConfig[JdbcProfile](basePath, config).profile
}

object SlickDatabase {
    def forConfig(basePath:String,  config: Config, slickConfiguration: SlickConfiguration): Database = {
        val jndiName = slickConfiguration.jndiName.map(Database.forName(_, None))
        val jndiDbName = slickConfiguration.jndiDbName.map(new InitialContext().lookup(_).asInstanceOf[Database])
        jndiName.orElse(jndiDbName).getOrElse(Database.forConfig(basePath, config))
    }
}

class SlickConfiguration(config: Config) {
    private val cfg = config.asConfig("slick")
    val jndiName: Option[String] = cfg.as[String]("jndiName").trim
    val jndiDbName: Option[String] = cfg.as[String]("jndiDbName")
    override def toString: String = s"SlickConfiguration($jndiName,$jndiDbName)"
}
