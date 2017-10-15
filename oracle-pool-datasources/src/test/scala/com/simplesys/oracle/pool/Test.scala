package com.simplesys.oracle.pool

import org.scalatest.FunSuite

class Test extends FunSuite {
    test("connection") {
        val dataSource = new OraclePoolDataSource("oraclcePoolDataSource")
        val connection = dataSource.getConnection()


        // Create Oracle DatabaseMetaData object
        val meta = connection.getMetaData

        // gets driver info:
        println(s"JDBC driver version is ${meta.getDriverVersion}")
        println(s"sqlDialect is ${dataSource.sqlDialect}")

        println(s"AutoCommit: ${connection.getAutoCommit}")
    }
}
