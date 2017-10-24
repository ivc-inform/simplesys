package com.simplesys.hikari

import java.sql.Connection

import org.scalatest.FunSuite

class Test extends FunSuite {
    test("connection") {
        val dataSource = new OracleHikariDataSource("oraclcePoolDataSource")
        val connection: Connection = dataSource.getConnection()

        println(s"Is closed: ${connection.isClosed}")

        // Create Oracle DatabaseMetaData object
        val meta = connection.getMetaData

        // gets driver info:
        println(s"JDBC driver version is ${meta.getDriverVersion}")
        println(s"sqlDialect is ${dataSource.sqlDialect}")

        println(s"AutoCommit: ${connection.getAutoCommit}")

        connection.close()
        println(s"Is closed: ${connection.isClosed}")
    }
}
