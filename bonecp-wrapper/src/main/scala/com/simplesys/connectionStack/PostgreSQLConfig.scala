package com.simplesys.connectionStack

import com.simplesys.bonecp.BoneCPConfig
import com.simplesys.xml.Elem

object PostgreSQLConfig {
    def apply(xmlConfig: Elem) = new PostgreSQLConfig(xmlConfig)
}

class PostgreSQLConfig(xmlConfig: Elem) extends BoneCPConfig(xmlConfig) with ConnectionPool {
    JdbcUrl match {
        case null =>
            JdbcUrl = s"jdbc:postgresql://${Host}:${Port}/${ServiceName}"
        case _ =>
    }

    logConfig
}