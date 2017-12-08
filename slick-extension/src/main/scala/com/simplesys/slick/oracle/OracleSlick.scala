package com.simplesys.slick.oracle

import com.typesafe.config.ConfigFactory
import slick.jdbc.JdbcProfile
import slick.basic.DatabaseConfig

trait OracleSlick {
    val databaseConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forDriverClassName[JdbcProfile]("slick.jdbc.OracleProfile$", "slick", ConfigFactory.load())
    //val databaseConfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig[JdbcProfile]("slick", ConfigFactory.load())
    val db = databaseConfig.db
    val profile = databaseConfig.profile
}
