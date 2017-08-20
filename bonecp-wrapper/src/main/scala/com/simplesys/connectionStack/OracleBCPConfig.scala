package com.simplesys.connectionStack

import com.simplesys.bonecp.BoneCPConfig
import com.simplesys.common.Properties
import com.simplesys.xml.Elem

object OracleBCPConfig {
    def apply(xmlConfig: Elem) = new OracleBCPConfig(xmlConfig)
}

class OracleBCPConfig(xmlConfig: Elem) extends BoneCPConfig(xmlConfig) with ConnectionPool {

    JdbcUrl match {
        case null if ServiceName != "thin" =>
            JdbcUrl = s"jdbc:oracle:thin:@${Host}:${Port}/${ServiceName}"
        case _ =>
    }

    override def ReadTimeout:Int = {
        val driverProperties: Properties = proxy.getDriverProperties

        driverProperties("oracle.jdbc.ReadTimeout", "0").toInt
    }

    override def ReadTimeout_=(value: Int) {
        val driverProperties: Properties = proxy.getDriverProperties

        driverProperties("oracle.jdbc.ReadTimeout") = value.toString
        DriverProperties = driverProperties
    }

    logConfig
}
