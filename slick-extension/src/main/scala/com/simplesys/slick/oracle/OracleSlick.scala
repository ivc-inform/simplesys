package com.simplesys.slick.oracle

import com.typesafe.config.ConfigFactory
import slick.jdbc.{JdbcBackend, JdbcProfile}
import slick.basic.DatabaseConfig
import com.simplesys.common.Strings._

trait OracleSlick {
    //val databaseConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig[JdbcProfile]("slick", ConfigFactory.load())
    val databaseConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig[JdbcProfile]("slick", ConfigFactory.parseString(
        """slick {
          |    db {
          |      url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl"
          |      user = "temp"
          |      password = "temp"
          |  }
          |     driver = "slick.jdbc.OracleProfile$"
          |}""".stripMargin))
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
        }""".stripMargin.format(url.dblQuoted, user.dblQuoted, password.dblQuoted, driver.dblQuoted)))
}
