package com.simplesys.connectionStack

import collection.mutable
import com.simplesys.bonecp.{BoneCPConfigException, BoneCPDataSource, BoneCPConfig}
import com.simplesys.log.{Logger, Logging}
import com.simplesys.common.Strings._
import com.simplesys.xml.Elem
import com.simplesys.xml.Elem._
import xml.{XML, NodeSeq}
import com.simplesys.common.URLBox
import com.typesafe.config.impl.Misc._

object BoneCPStack {
    def apply() = new BoneCPStack {}
}

trait BoneCPStack {

    private lazy val _logger = Logger(this getClass)

    protected val hosonConfigFileName = "application.conf"
    protected val xmlConfigFileName = "bonecp-config-stack.xml"

    //Поддерево настроек возможных пуллов коннектов в XML - конфигурационном файле
    protected lazy val configBoneCPStackFromXML: Elem = {
        URLBox.getResource(xmlConfigFileName) match {
            case URLBox(Some(url), message) => XML load url
            case URLBox(None, message) => configEmpty
        }
    } \\ "bonecp-config-stack"

    private val stackCPDataSource = mutable.HashMap.empty[String, BoneCPDataSource]

    //Выдать нужное поддерево настроек (т.е. поддерево с соответствующим PoolName) в XML конфигурации
    private def getConfig(nameBCP: String): Elem = {

        var configBoneCPStack: Elem = configBoneCPStackFromHOCON(hosonConfigFileName, nameBCP)
        var boneCpConfigTag = "bonecp-config"

        if ((configBoneCPStack \ "bonecp-config").isEmpty)
            configBoneCPStack = configBoneCPStackFromXML

        _logger trace (s"bonecp-config: ${configBoneCPStack}")

        val res = for {cfg <- configBoneCPStack \ boneCpConfigTag
                       prop <- cfg \ "property"
                       name <- prop \ "@name" if (name.text == "poolName") && (prop.text.trim == nameBCP)}
        yield cfg

        _logger trace (s"bonecp-config: ${res}")
        res match {
            case NodeSeq.Empty => throw new BoneCPConfigException("Configuration for " + nameBCP.quoted + " not found.")
                res
            case any => any
        }
    }

    def DataSource(nameBCP: String): BoneCPDataSource = {
        stackCPDataSource.get(nameBCP) match {
            case Some(pool) => pool
            case None =>
                val config = BoneCPConfig(getConfig(nameBCP))
                val res = BoneCPDataSource(config)
                res setDriverClass config.DriverClass

                stackCPDataSource += (nameBCP -> res)
                res
        }
    }

    def OracleDataSource(nameBCP: String): BoneCPDataSource = {
        stackCPDataSource.get(nameBCP) match {
            case Some(pool) => pool
            case None =>
                val config = OracleBCPConfig(getConfig(nameBCP))
                val res = BoneCPDataSource(config)
                res setDriverClass config.DriverClass

                stackCPDataSource += (nameBCP -> res)
                res
        }
    }

    def DerbyDataSource(nameBCP: String): BoneCPDataSource = {
        stackCPDataSource.get(nameBCP) match {
            case Some(pool) => pool
            case None =>
                val config = DerbyBCPConfig(getConfig(nameBCP))
                val res = BoneCPDataSource(config)
                res setDriverClass config.DriverClass

                stackCPDataSource += (nameBCP -> res)
                res
        }
    }

    def H2DataSource(nameBCP: String): BoneCPDataSource = {
        stackCPDataSource.get(nameBCP) match {
            case Some(pool) => pool
            case None =>
                val config = H2BCPConfig(getConfig(nameBCP))
                val res = BoneCPDataSource(config)
                res setDriverClass config.DriverClass

                stackCPDataSource += (nameBCP -> res)
                res
        }
    }

    def PostgreSQLDataSource(nameBCP: String): BoneCPDataSource = {
        stackCPDataSource.get(nameBCP) match {
            case Some(pool) => pool
            case None =>
                val config = PostgreSQLConfig(getConfig(nameBCP))
                val res = BoneCPDataSource(config)
                res setDriverClass config.DriverClass

                stackCPDataSource += (nameBCP -> res)
                res
        }
    }

    def Close() {
        stackCPDataSource foreach {
            case (_, ds) => ds.Close()
        }
    }
}
