package com.simplesys.bonecp

import org.scalatest.FunSuite
import com.simplesys.connectionStack.{BoneCPStack, OracleBCPConfig}
import com.simplesys.log.Logging
import java.sql.SQLException
import com.simplesys.control.ControlStructs._
import javax.sql.DataSource
import com.simplesys.xml.{Elem, XML}
import com.simplesys.common.URLBox

class TestSuite extends FunSuite with Logging with BoneCPStack {

    /*test("BoneCPConfig") {
        val boneCPConfig = OracleBCPConfig(<bonecp-config/>)

        val configFile: Elem = XML.load(URLBox.getResource("bonecp-default-config.xml"))
        XML.save("bonecp-default-config.xml", configFile, "UTF-8", true)
        boneCPConfig logConfig
    }*/

    test("BoneCPStack-Oracle") {
        val configName = "home"

        val connection1 = OracleDataSource(configName).getConnection
        val connection2 = OracleDataSource(configName).getConnection
        val connection3 = OracleDataSource(configName).getConnection
        val connection4 = OracleDataSource(configName).getConnection
        val connection5 = OracleDataSource(configName).getConnection
        val connection6 = OracleDataSource(configName).getConnection
        val connection7 = OracleDataSource(configName).getConnection
        val connection8 = OracleDataSource(configName).getConnection
        val connection9 = OracleDataSource(configName).getConnection
        val connection10 = OracleDataSource(configName).getConnection
        val connection11 = OracleDataSource(configName).getConnection
        val connection12 = OracleDataSource(configName).getConnection
    }

    test("Derby DB") {
        val conn = DerbyDataSource("DerbyTest"): DataSource
        using(conn createStatement()) {
            st =>
                try {
                    st executeUpdate "DROP TABLE STAFF"
                }
                catch {
                    case ex: SQLException =>
                }

                st.executeUpdate( """CREATE TABLE
                           STAFF
                           (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                            SURNAME VARCHAR(255) NOT NULL,
                            NAME VARCHAR(255),
                            PATRONYMIC VARCHAR(255),
                            EMAIL VARCHAR(255),
                            PHONE VARCHAR(255),
                            PRIMARY KEY (ID)
                           )""")

                val metadata = conn.getMetaData
                val tablesName = metadata.getTables(null, "%", "%", Array("TABLE"))
                while (tablesName.next())
                    logger trace(s"Exists table: ${}", tablesName.getString("TABLE_NAME"))
        }
    }

    test("H2 BD") {
        val connect = H2DataSource("H2Test").getConnection
        val connect1 = H2DataSource("H2Test").getConnection
    }

    test("DBPostgreSQLConnection") {
        val connect = PostgreSQLDataSource("postgreEnzo").getConnection
        val connect1 = DataSource("postgreEnzo").getConnection
        val connect2 = PostgreSQLDataSource("postgreEnzo").getConnection
    }
}