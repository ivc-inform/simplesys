package com.simplesys.slick.oracle

import com.simplesys.common.Strings._
import com.typesafe.config.ConfigFactory
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait OracleSlick {
    val databaseConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig[JdbcProfile]("slick", ConfigFactory.load())
    val db = databaseConfig.db
    val profile = databaseConfig.profile
}

object OracleSlick {
    def getDataBaseConfig(url: String, user: String, password: String, driver: String = "slick.jdbc.OracleProfile$") = DatabaseConfig.forConfig[JdbcProfile]("slick", ConfigFactory.parseString(
        """slick {
            db {
              url = %s
              user = %s
              password = %s
          }
             driver = %s
        }""".format(url.dblQuoted, user.dblQuoted, password.dblQuoted, driver.dblQuoted)))
}
