package com.simplesys.slick.oracle

import com.typesafe.config.ConfigFactory
import slick.jdbc.JdbcProfile
import slick.basic.DatabaseConfig

trait OracleSlick {
    val profile: JdbcProfile = DatabaseConfig.forDriverClassName[JdbcProfile]("slick.jdbc.OracleProfile$", "slick", ConfigFactory.load()).profile
}
