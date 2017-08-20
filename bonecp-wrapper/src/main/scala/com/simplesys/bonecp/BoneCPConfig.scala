package com.simplesys.bonecp

import com.jolbox.bonecp.{BoneCPConfig => JBoneCPConfig}
import hooks.ConnectionHook
import com.simplesys.common.Properties
import java.util.concurrent.TimeUnit
import javax.sql.DataSource
import com.simplesys.log.Logging
import com.simplesys.xml.Elem

object BoneCPConfig {
    def apply(proxy: JBoneCPConfig) = new BoneCPConfig(proxy)

    def apply() = new BoneCPConfig()

    def apply(xmlConfig: Elem) = new BoneCPConfig(xmlConfig)
}

class BoneCPConfig(protected[bonecp] val proxy: JBoneCPConfig) extends Logging {

    def this() = this(new JBoneCPConfig())

    def this(xmlConfig: Elem) = {
        this(new JBoneCPConfig())

        setXMLProperties(xmlConfig);

        logConfig
    }

    private def setProperty(_case: String, value: String) {
        _case match {
            case "acquireIncrement" => AcquireIncrement = value toInt
            case "acquireRetryAttempts" => AcquireRetryAttempts = value toInt
            case "acquireRetryDelayInMs" => AcquireRetryDelayInMs = value toInt
            case "closeConnectionWatch" => CloseConnectionWatch = value toBoolean
            case "closeConnectionWatchTimeoutInMs" => CloseConnectionWatchTimeoutInMs = value toInt
            case "configFile" => ConfigFile = value
            case "connectionHookClassName" => ConnectionHookClassName = value
            case "connectionTestStatement" => ConnectionTestStatement = value
            case "connectionTimeoutInMs" => ConnectionTimeoutInMs = value toLong
            case "defaultAutoCommit" => DefaultAutoCommit = value toBoolean
            case "defaultCatalog" => DefaultCatalog = value
            case "defaultReadOnly" => DefaultReadOnly = value toBoolean
            case "defaultTransactionIsolation" => DefaultTransactionIsolation = value
            case "derbySystemHome" => DerbySystemHome = value
            case "disableConnectionTracking" => DisableConnectionTracking = value toBoolean
            case "disableJMX" => DisableJMX = value toBoolean
            case "driverClass" => DriverClass = value
            case "externalAuth" => ExternalAuth = value toBoolean
            case "host" => Host = value
            case "idleConnectionTestPeriodInMinutes" => IdleConnectionTestPeriodInMinutes = value toLong
            case "idleConnectionTestPeriodInSeconds" => setIdleConnectionTestPeriodInSeconds(value toLong)
            case "idleMaxAgeInMinutes" => IdleMaxAgeInMinutes = value toLong
            case "idleMaxAgeInSeconds" => setIdleMaxAgeInSeconds(value toLong)
            case "initSQL" => InitSQL = value
            case "jdbcUrl" => JdbcUrl = value
            case "lazyInit" => LazyInit = value toBoolean
            case "logStatementsEnabled" => LogStatementsEnabled = value toBoolean
            case "maxConnectionAgeInSeconds" => MaxConnectionAgeInSeconds = value toLong
            case "maxConnectionsPerPartition" => MaxConnectionsPerPartition = value toInt
            case "minConnectionsPerPartition" => MinConnectionsPerPartition = value toInt
            case "partitionCount" => PartitionCount = value toInt
            case "password" => Password = value
            case "poolAvailabilityThreshold" => PoolAvailabilityThreshold = value toInt
            case "poolName" => PoolName = value
            case "port" => Port = value
            case "queryExecuteTimeLimitInMs" => QueryExecuteTimeLimitInMs = value toLong
            //case "releaseHelperThreads" => ReleaseHelperThreads = value toInt
            case "serviceName" => ServiceName = value
            case "fetchSize" => FetchSize = value.toInt
            case "readTimeout" => ReadTimeout = value.toInt
            case "serviceOrder" => ServiceOrder = value
            //case "statementReleaseHelperThreads" => StatementReleaseHelperThreads = value toInt
            case "statementsCacheSize" => StatementsCacheSize = value toInt
            case "statisticsEnabled" => StatisticsEnabled = value toBoolean
            case "transactionRecoveryEnabled" => TransactionRecoveryEnabled = value toBoolean
            case "username" => Username = value
            case _ => logger warn (s"Parameter: ${_case} not matched")
        }
    }

    //Отработка XML конфигурации
    private def setXMLProperties(xmlConfig: Elem) {
        xmlConfig \ "property" foreach {
            prop =>
                prop text match {
                    case "" =>
                    case value =>
                        setProperty((prop \ "@name").text, value)
                }
        }
    }

    def AcquireRetryDelay(timeUnit: TimeUnit) = proxy getAcquireRetryDelay timeUnit

    def CloseConnectionWatchTimeout(timeUnit: TimeUnit) = proxy getCloseConnectionWatchTimeout timeUnit

    def ConnectionTimeout(timeUnit: TimeUnit) = proxy getConnectionTimeout timeUnit

    def IdleConnectionTestPeriod(timeUnit: TimeUnit) = proxy getIdleConnectionTestPeriod timeUnit

    def IdleMaxAge(timeUnit: TimeUnit) = proxy getIdleMaxAge timeUnit

    def MaxConnectionAge(timeUnit: TimeUnit) = proxy getMaxConnectionAge timeUnit

    def QueryExecuteTimeLimit(timeUnit: TimeUnit) = proxy getQueryExecuteTimeLimit timeUnit

    def SameConfiguration(that: BoneCPConfig) = proxy hasSameConfiguration that

    def Sanitize = proxy sanitize

    def AcquireRetryDelay_=(acquireRetryDelay: Long, timeUnit: TimeUnit) {
        proxy setAcquireRetryDelay(acquireRetryDelay, timeUnit)
        logger trace (s"setAcquireRetryDelay: ${acquireRetryDelay}")
    }

    def CloseConnectionWatchTimeout_=(closeConnectionWatchTimeout: Long, timeUnit: TimeUnit) {
        proxy setCloseConnectionWatchTimeout(closeConnectionWatchTimeout, timeUnit)
        logger trace (s"setCloseConnectionWatchTimeout: ${closeConnectionWatchTimeout}")
    }

    def ConnectionTimeout_=(connectionTimeout: Long, timeUnit: TimeUnit) {
        proxy setConnectionTimeout(connectionTimeout, timeUnit)
        logger trace (s"setConnectionTimeout: ${connectionTimeout}")
    }

    def IdleConnectionTestPeriod_=(idleConnectionTestPeriod: Long, timeUnit: TimeUnit) {
        proxy setIdleConnectionTestPeriod(idleConnectionTestPeriod, timeUnit)
        logger trace (s"setIdleConnectionTestPeriod: ${idleConnectionTestPeriod}")
    }

    def IdleMaxAge_=(idleMaxAge: Long, timeUnit: TimeUnit) {
        proxy setIdleMaxAge(idleMaxAge, timeUnit)
        logger trace (s"setIdleMaxAge (idleMaxAge: ${idleMaxAge}, timeUnit: ${timeUnit})")
    }

    def MaxConnectionAge_=(maxConnectionAge: Long, timeUnit: TimeUnit) {
        proxy setMaxConnectionAge(maxConnectionAge, timeUnit)
        logger trace  (s"setMaxConnectionAge (maxConnectionAge: ${maxConnectionAge}, timeUnit: ${timeUnit})")
    }

    def QueryExecuteTimeLimit_=(queryExecuteTimeLimit: Long, timeUnit: TimeUnit) {
        proxy setQueryExecuteTimeLimit(queryExecuteTimeLimit, timeUnit)
        logger trace (s"setQueryExecuteTimeLimit (queryExecuteTimeLimit: ${queryExecuteTimeLimit}, timeUnit: ${timeUnit})")
    }

    def AcquireIncrement = proxy getAcquireIncrement

    def AcquireIncrement_=(acquireIncrement: Int) {
        proxy setAcquireIncrement acquireIncrement
        logger trace (s"setAcquireIncrement: ${acquireIncrement}")
    }

    def AcquireRetryAttempts: Int = proxy getAcquireRetryAttempts

    def AcquireRetryAttempts_=(acquireRetryAttempts: Int) {
        proxy setAcquireRetryAttempts acquireRetryAttempts
        logger trace (s"setAcquireRetryAttempts: ${acquireRetryAttempts}")
    }

    def AcquireRetryDelayInMs = proxy getAcquireRetryDelayInMs

    def AcquireRetryDelayInMs_=(acquireRetryDelayInMs: Long) {
        proxy setAcquireRetryDelayInMs acquireRetryDelayInMs
        logger trace (s"setAcquireRetryDelayInMs: ${acquireRetryDelayInMs}")
    }

    def ClassLoader = proxy getClassLoader

    def ClassLoader_=(classLoader: ClassLoader) {
        proxy setClassLoader classLoader
        logger trace (s"setClassLoader: ${classLoader}")
    }

    def CloseConnectionWatch = proxy isCloseConnectionWatch

    def CloseConnectionWatch_=(closeConnectionWatch: Boolean) {
        proxy setCloseConnectionWatch closeConnectionWatch
        logger trace (s"setCloseConnectionWatch: ${closeConnectionWatch}")
    }

    def CloseConnectionWatchTimeoutInMs = proxy getCloseConnectionWatchTimeoutInMs

    def CloseConnectionWatchTimeoutInMs_=(closeConnectionWatchTimeoutInMs: Long) {
        proxy setCloseConnectionWatchTimeoutInMs closeConnectionWatchTimeoutInMs
        logger trace (s"setCloseConnectionWatchTimeoutInMs: ${closeConnectionWatchTimeoutInMs}")
    }

    def ConfigFile = proxy getConfigFile

    def ConfigFile_=(configFile: String) {
        proxy setConfigFile configFile
        logger trace (s"setConfigFile: ${configFile}")
    }

    def ConnectionHook: ConnectionHook = proxy.getConnectionHook.asInstanceOf[ConnectionHook]

    def ConnectionHook_=(connectionHook: ConnectionHook) {
        proxy setConnectionHook connectionHook
        logger trace (s"setConnectionHook: ${connectionHook}")
    }

    def ConnectionHookClassName = proxy getConnectionHookClassName

    def ConnectionHookClassName_=(connectionHookClassName: String) {
        proxy setConnectionHookClassName connectionHookClassName
        logger trace (s"setConnectionHookClassName: ${connectionHookClassName}")
    }

    def ConnectionTestStatement = proxy getConnectionTestStatement

    def ConnectionTestStatement_=(connectionTestStatement: String) {
        proxy setConnectionTestStatement connectionTestStatement
        logger trace (s"setConnectionTestStatement: ${connectionTestStatement}")
    }

    def ConnectionTimeoutInMs = proxy getConnectionTimeoutInMs

    def ConnectionTimeoutInMs_=(connectionTimeoutInMs: Long) {
        proxy setConnectionTimeoutInMs connectionTimeoutInMs
        logger trace (s"setConnectionTimeoutInMs: ${connectionTimeoutInMs}")
    }

    def DatasourceBean = proxy getDatasourceBean

    def DatasourceBean_=(datasourceBean: DataSource) {
        proxy setDatasourceBean datasourceBean
        logger trace (s"setDatasourceBean: ${datasourceBean}")
    }

    def DefaultAutoCommit = {
        val res = proxy getDefaultAutoCommit

        res
    }

    def DefaultAutoCommit_=(defaultAutoCommit: Boolean) {
        proxy setDefaultAutoCommit defaultAutoCommit
        logger trace (s"setDefaultAutoCommit: ${defaultAutoCommit}")
    }

    def DefaultCatalog = proxy getDefaultCatalog

    def DefaultCatalog_=(defaultCatalog: String) {
        proxy setDefaultCatalog defaultCatalog
        logger trace (s"setDefaultCatalog: ${defaultCatalog}")
    }

    def DefaultReadOnly = proxy getDefaultReadOnly

    def DefaultReadOnly_=(defaultReadOnly: Boolean) {
        proxy setDefaultReadOnly defaultReadOnly
        logger trace (s"setDefaultReadOnly: ${defaultReadOnly}")
    }

    def DefaultTransactionIsolation = proxy getDefaultTransactionIsolation

    def DefaultTransactionIsolation_=(defaultTransactionIsolation: String) {
        proxy setDefaultTransactionIsolation defaultTransactionIsolation
        logger trace (s"setDefaultTransactionIsolation: ${defaultTransactionIsolation}")
    }

    private[this] var derbySystemHome: String = ""

    def DerbySystemHome = derbySystemHome

    def DerbySystemHome_=(value: String) {
        derbySystemHome = value
    }

    def DisableConnectionTracking = proxy isDisableConnectionTracking

    def DisableConnectionTracking_=(disableConnectionTracking: Boolean) {
        proxy setDisableConnectionTracking disableConnectionTracking
        logger trace (s"setDisableConnectionTracking: ${disableConnectionTracking}")
    }

    def DisableJMX = proxy isDisableJMX

    def DisableJMX_=(disableJMX: Boolean) {
        proxy setDisableJMX disableJMX
        logger trace (s"setDisableJMX: ${disableJMX}")
    }

    private[this] var driverClass: String = ""

    def DriverClass = driverClass

    def DriverClass_=(value: String) {
        driverClass = value
        logger trace (s"driverClass: ${driverClass}")
    }

    def DriverProperties: Properties = proxy getDriverProperties

    def DriverProperties_=(driverProperties: Properties) {
        proxy setDriverProperties driverProperties
        logger trace (s"setDriverProperties: ${driverProperties}")
    }

    def ExternalAuth = proxy isExternalAuth

    def ExternalAuth_=(externalAuth: Boolean) {
        proxy setExternalAuth externalAuth
        logger trace (s"setExternalAuth: ${externalAuth}")
    }

    private[this] var host: String = ""

    def Host = host

    def Host_=(value: String) {
        host = value
        logger trace (s"setHost: ${value}")
    }

    def IdleConnectionTestPeriodInMinutes = proxy getIdleConnectionTestPeriodInMinutes

    def IdleConnectionTestPeriodInMinutes_=(idleConnectionTestPeriodInMinutes: Long) {
        proxy setIdleConnectionTestPeriodInMinutes idleConnectionTestPeriodInMinutes
        logger trace (s"setIdleConnectionTestPeriodInMinutes: ${idleConnectionTestPeriodInMinutes}")
    }

    def setIdleConnectionTestPeriodInSeconds(idleConnectionTestPeriodInSeconds: Long) {
        proxy setIdleConnectionTestPeriodInSeconds idleConnectionTestPeriodInSeconds
        logger trace (s"setIdleConnectionTestPeriodInSeconds: ${idleConnectionTestPeriodInSeconds}")
    }

    def IdleMaxAgeInMinutes = proxy getIdleMaxAgeInMinutes

    def IdleMaxAgeInMinutes_=(idleMaxAgeInMinutes: Long) {
        proxy setIdleMaxAgeInMinutes idleMaxAgeInMinutes
        logger trace (s"setIdleMaxAgeInMinutes: ${idleMaxAgeInMinutes}")
    }

    def setIdleMaxAgeInSeconds(idleMaxAgeInSeconds: Long) {
        proxy setIdleMaxAgeInSeconds idleMaxAgeInSeconds
        logger trace (s"setIdleMaxAgeInSeconds: ${idleMaxAgeInSeconds}")
    }

    def InitSQL = proxy getInitSQL

    def InitSQL_=(initSQL: String) {
        proxy setInitSQL initSQL
        logger trace (s"setInitSQL: ${initSQL}")
    }

    def JdbcUrl = proxy getJdbcUrl

    def JdbcUrl_=(jdbcUrl: String) {
        proxy setJdbcUrl jdbcUrl
        logger trace (s"setJdbcUrl: ${jdbcUrl}")
    }

    def LazyInit = proxy isLazyInit

    def LazyInit_=(lazyInit: Boolean) {
        proxy setLazyInit lazyInit
        logger trace (s"setLazyInit: ${lazyInit}")
    }

    def LogStatementsEnabled = proxy isLogStatementsEnabled

    def LogStatementsEnabled_=(logStatementsEnabled: Boolean) {
        proxy setLogStatementsEnabled logStatementsEnabled
        logger trace (s"setLogStatementsEnabled: ${logStatementsEnabled}")
    }

    def MaxConnectionAgeInSeconds = proxy getMaxConnectionAgeInSeconds

    def MaxConnectionAgeInSeconds_=(maxConnectionAgeInSeconds: Long) {
        proxy setMaxConnectionAgeInSeconds maxConnectionAgeInSeconds
        logger trace (s"setMaxConnectionAgeInSeconds: ${maxConnectionAgeInSeconds}")
    }

    def MaxConnectionsPerPartition = proxy getMaxConnectionsPerPartition

    def MaxConnectionsPerPartition_=(maxConnectionsPerPartition: Int) {
        proxy setMaxConnectionsPerPartition maxConnectionsPerPartition
        logger trace (s"setMaxConnectionsPerPartition: ${maxConnectionsPerPartition}")
    }

    def MinConnectionsPerPartition = proxy getMinConnectionsPerPartition

    def MinConnectionsPerPartition_=(minConnectionsPerPartition: Int) {
        proxy setMinConnectionsPerPartition minConnectionsPerPartition
        logger trace (s"setMinConnectionsPerPartition: ${minConnectionsPerPartition}")
    }

    def PartitionCount = proxy getPartitionCount

    def PartitionCount_=(partitionCount: Int) {
        proxy setPartitionCount partitionCount
        logger trace (s"setPartitionCount: ${partitionCount}")
    }

    def Password = proxy getPassword

    def Password_=(password: String) {
        proxy setPassword password
        logger trace (s"setPassword: ${password}")
    }

    def PoolAvailabilityThreshold = proxy getPoolAvailabilityThreshold

    def PoolAvailabilityThreshold_=(poolAvailabilityThreshold: Int) {
        proxy setPoolAvailabilityThreshold poolAvailabilityThreshold
        logger trace (s"setPoolAvailabilityThreshold: ${poolAvailabilityThreshold}")
    }

    def PoolName = proxy getPoolName

    def PoolName_=(poolName: String) {
        proxy setPoolName poolName
        logger trace (s"setPoolName: ${poolName}")
    }

    private[this] var port: String = ""

    def Port = port

    def Port_=(value: String) {
        port = value
        logger trace (s"setPort: ${port}")
    }

    @throws(classOf[Exception])
    def Properties_=(properties: Properties) {
        proxy setProperties properties
        logger trace (s"setProperties: ${properties}")
    }

    def QueryExecuteTimeLimitInMs = proxy getQueryExecuteTimeLimitInMs

    def QueryExecuteTimeLimitInMs_=(queryExecuteTimeLimitInMs: Long) {
        proxy setQueryExecuteTimeLimitInMs queryExecuteTimeLimitInMs
        logger trace (s"setQueryExecuteTimeLimitInMs: ${queryExecuteTimeLimitInMs}")
    }

    /*def ReleaseHelperThreads = proxy getReleaseHelperThreads

    def ReleaseHelperThreads_=(releaseHelperThreads: Int) {
        proxy setReleaseHelperThreads releaseHelperThreads
        logger trace(s"setReleaseHelperThreads: ${releaseHelperThreads}")
    }*/

    private[this] var servicename: String = ""
    def ServiceName = servicename
    def ServiceName_=(value: String) {
        servicename = value
        logger trace (s"setServiceName: ${servicename}")
    }

    private[this] var fetchSize: Int = 10
    def FetchSize = fetchSize
    def FetchSize_=(value: Int) {
        fetchSize = value
        logger trace (s"setfetchSize: ${fetchSize}")
    }

    def ServiceOrder = proxy getServiceOrder
    def ServiceOrder_=(serviceOrder: String) {
        proxy setServiceOrder serviceOrder
        logger trace (s"setServiceOrder: ${serviceOrder}")
    }

    /*def StatementReleaseHelperThreads = proxy getStatementReleaseHelperThreads

    def StatementReleaseHelperThreads_=(statementReleaseHelperThreads: Int) {
        proxy setStatementReleaseHelperThreads statementReleaseHelperThreads
        logger trace(s"setStatementReleaseHelperThreads: ${statementReleaseHelperThreads}")
    }*/

    def StatementsCacheSize = proxy getStatementsCacheSize

    def StatementsCacheSize_=(statementsCacheSize: Int) {
        proxy setStatementsCacheSize statementsCacheSize
        logger trace (s"setStatementsCacheSize: ${statementsCacheSize}")
    }

    def StatisticsEnabled = proxy isStatisticsEnabled

    def StatisticsEnabled_=(statisticsEnabled: Boolean) {
        proxy setStatisticsEnabled statisticsEnabled
        logger trace (s"setStatisticsEnabled: ${statisticsEnabled}")
    }

    def TransactionRecoveryEnabled = proxy isTransactionRecoveryEnabled

    def TransactionRecoveryEnabled_=(transactionRecoveryEnabled: Boolean) {
        proxy setTransactionRecoveryEnabled transactionRecoveryEnabled
        logger trace (s"setTransactionRecoveryEnabled: ${transactionRecoveryEnabled}")
    }

    def Username = proxy getUsername

    def Username_=(username: String) {
        proxy setUsername username
        logger trace (s"setUsername: ${username}")
    }

    def ReadTimeout: Int = 0
    def ReadTimeout_=(value: Int) {}

    def logConfig {
        logger trace (s"//////////////////////////////// BoneCPConfig PoolName: ${PoolName}  /////////////////////////////////////")
        logger trace (s"AcquireIncrement: ${AcquireIncrement}")
        logger trace (s"AcquireRetryAttempts: ${AcquireRetryAttempts}")
        logger trace (s"AcquireRetryDelayInMs: ${AcquireRetryDelayInMs}")
        logger trace (s"CloseConnectionWatch: ${CloseConnectionWatch}")
        logger trace (s"CloseConnectionWatchTimeoutInMs: ${CloseConnectionWatchTimeoutInMs}")
        logger trace (s"ConfigFile: ${ConfigFile}")
        logger trace (s"ConnectionHookClassName: ${ConnectionHookClassName}")
        logger trace (s"ConnectionTestStatement: ${ConnectionTestStatement}")
        logger trace (s"ConnectionTimeoutInMs: ${ConnectionTimeoutInMs}")
        logger trace (s"DefaultAutoCommit: ${DefaultAutoCommit}")
        logger trace (s"DefaultCatalog: ${DefaultCatalog}")
        logger trace (s"DefaultReadOnly: ${DefaultReadOnly}")
        logger trace (s"DefaultTransactionIsolation: ${DefaultTransactionIsolation}")
        logger trace (s"DerbySystemHome: ${DerbySystemHome}")
        logger trace (s"DisableConnectionTracking: ${DisableConnectionTracking}")
        logger trace (s"DisableJMX: ${DisableJMX}")
        logger trace (s"ExternalAuth: ${ExternalAuth}")
        logger trace (s"Host: ${Host}")
        logger trace (s"IdleConnectionTestPeriodInMinutes: ${IdleConnectionTestPeriodInMinutes}")
        logger trace (s"IdleMaxAgeInMinutes: ${IdleMaxAgeInMinutes}")
        logger trace (s"InitSQL: ${InitSQL}")
        logger trace (s"JdbcUrl: ${JdbcUrl}")
        logger trace (s"LazyInit: ${LazyInit}")
        logger trace (s"LogStatementsEnabled: ${LogStatementsEnabled}")
        logger trace (s"MaxConnectionAgeInSeconds: ${MaxConnectionAgeInSeconds}")
        logger trace (s"MaxConnectionsPerPartition: ${MaxConnectionsPerPartition}")
        logger trace (s"MinConnectionsPerPartition: ${MinConnectionsPerPartition}")
        logger trace (s"PartitionCount: ${PartitionCount}")
        logger trace (s"Password: ${Password}")
        logger trace (s"PoolAvailabilityThreshold: ${PoolAvailabilityThreshold}")
        logger trace (s"PoolName: ${PoolName}")
        logger trace (s"Port: ${Port}")
        logger trace (s"QueryExecuteTimeLimitInMs: ${QueryExecuteTimeLimitInMs}")
        //logger trace(s"ReleaseHelperThreads: ${ReleaseHelperThreads}")
        logger trace (s"Servicename: ${ServiceName}")
        logger trace (s"ServiceOrder: ${ServiceOrder}")
        //logger trace(s"StatementReleaseHelperThreads: ${StatementReleaseHelperThreads}")
        logger trace (s"StatementsCacheSize: ${StatementsCacheSize}")
        logger trace (s"StatisticsEnabled: ${StatisticsEnabled}")
        logger trace (s"TransactionRecoveryEnabled: ${TransactionRecoveryEnabled}")
        logger trace (s"Username: ${Username}")
        logger trace (s"//////////////////////////////// END BoneCPConfig PoolName: ${PoolName}  /////////////////////////////////////")
    }
}
