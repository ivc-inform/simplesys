// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenTables"

package ru.simplesys.defs.bo

package scenarios.table

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.jdbc.control.{ValidationEx, Table}
import com.simplesys.jdbc.control.table.Insert
import org.joda.time.{LocalDateTime, DateTime}
import java.sql.{Connection, PreparedStatement}
import com.simplesys.sql.SQLDialect
import com.simplesys.SQL.Gen.SQLAlias
import com.simplesys.common.Strings._
import scenarios.ScenarioTrace
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object ScenarioTraceTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioTraceTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioTraceTbl(alias = alias)    
    
    val objectName = "ScenarioTrace"    
    val groupName = "scenarios"
}
 
class ScenarioTraceTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[ScenarioTraceTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCENARIOTRACE"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val actionmessageOption = StringOptionColumnTable(name = "SACTIONMESSAGE")    
    val actionobjectOption = StringOptionColumnTable(name = "SACTIONOBJECT")    
    val actiontypeOption = StringOptionColumnTable(name = "SACTIONTYPE")    
    val address = StringColumnTable(name = "SADDRESS")    
    val bonusbaseOption = DoubleOptionColumnTable(name = "FBONUSBASE")    
    val bonusmessageOption = StringOptionColumnTable(name = "SBONUSMESSAGE")    
    val event = StringColumnTable(name = "SEVENT")    
    val id = LongColumnTable(name = "ID")    
    val idactionmessageOption = LongOptionColumnTable(name = "IDIDACTIONMESSAGE")    
    val idbonusmessageOption = LongOptionColumnTable(name = "IDIDBONUSMESSAGE")    
    val idmarketingmessageOption = LongOptionColumnTable(name = "IDIDMARKETINGMESSAGE")    
    val marketingmessageOption = StringOptionColumnTable(name = "SMARKETINGMESSAGE")    
    val parentstageOption = StringOptionColumnTable(name = "SPARENTSTAGE")    
    val scenario = StringColumnTable(name = "SSCENARIO")    
    val stage = StringColumnTable(name = "SSTAGE")    
    val timestamp = LocalDateTimeColumnTable(name = "DTTIMESTAMP")    
    
    // For select tuple: (actionmessageOption: Array[String], actionobjectOption: Array[String], actiontypeOption: Array[String], address: String, bonusbaseOption: Array[Double], bonusmessageOption: Array[String], event: String, id: Long, idactionmessageOption: Array[Long], idbonusmessageOption: Array[Long], idmarketingmessageOption: Array[Long], marketingmessageOption: Array[String], parentstageOption: Array[String], scenario: String, stage: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]    
     def allColumns = actionmessageOption ~ actionobjectOption ~ actiontypeOption ~ address ~ bonusbaseOption ~ bonusmessageOption ~ event ~ id ~ idactionmessageOption ~ idbonusmessageOption ~ idmarketingmessageOption ~ marketingmessageOption ~ parentstageOption ~ scenario ~ stage ~ timestamp    
    
     def insert(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(actionmessageOption, value _1) Insert(actionobjectOption, value _2) Insert(actiontypeOption, value _3) Insert(address, value _4) Insert(bonusbaseOption, value _5) Insert(bonusmessageOption, value _6) Insert(event, value _7) Insert(id, value _8) Insert(idactionmessageOption, value _9) Insert(idbonusmessageOption, value _10) Insert(idmarketingmessageOption, value _11) Insert(marketingmessageOption, value _12) Insert(parentstageOption, value _13) Insert(scenario, value _14) Insert(stage, value _15) Insert(timestamp, value _16)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(actionmessageOption, value _1) Insert(actionobjectOption, value _2) Insert(actiontypeOption, value _3) Insert(address, value _4) Insert(bonusbaseOption, value _5) Insert(bonusmessageOption, value _6) Insert(event, value _7) Insert(id, value _8) Insert(idactionmessageOption, value _9) Insert(idbonusmessageOption, value _10) Insert(idmarketingmessageOption, value _11) Insert(marketingmessageOption, value _12) Insert(parentstageOption, value _13) Insert(scenario, value _14) Insert(stage, value _15) Insert(timestamp, value _16)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(actionmessageOption, value _1) Insert(actionobjectOption, value _2) Insert(actiontypeOption, value _3) Insert(address, value _4) Insert(bonusbaseOption, value _5) Insert(bonusmessageOption, value _6) Insert(event, value _7) Insert(id, value _8) Insert(idactionmessageOption, value _9) Insert(idbonusmessageOption, value _10) Insert(idmarketingmessageOption, value _11) Insert(marketingmessageOption, value _12) Insert(parentstageOption, value _13) Insert(scenario, value _14) Insert(stage, value _15) Insert(timestamp, value _16)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: ScenarioTrace*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(actionmessageOption, value.actionmessage) Insert(actionobjectOption, value.actionobject) Insert(actiontypeOption, value.actiontype) Insert(address, value.address) Insert(bonusbaseOption, value.bonusbase) Insert(bonusmessageOption, value.bonusmessage) Insert(event, value.event) Insert(id, value.id) Insert(idactionmessageOption, value.idactionmessage) Insert(idbonusmessageOption, value.idbonusmessage) Insert(idmarketingmessageOption, value.idmarketingmessage) Insert(marketingmessageOption, value.marketingmessage) Insert(parentstageOption, value.parentstage) Insert(scenario, value.scenario) Insert(stage, value.stage) Insert(timestamp, value.timestamp) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: ScenarioTrace*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(actionmessageOption, value.actionmessage) Insert(actionobjectOption, value.actionobject) Insert(actiontypeOption, value.actiontype) Insert(address, value.address) Insert(bonusbaseOption, value.bonusbase) Insert(bonusmessageOption, value.bonusmessage) Insert(event, value.event) Insert(id, value.id) Insert(idactionmessageOption, value.idactionmessage) Insert(idbonusmessageOption, value.idbonusmessage) Insert(idmarketingmessageOption, value.idmarketingmessage) Insert(marketingmessageOption, value.marketingmessage) Insert(parentstageOption, value.parentstage) Insert(scenario, value.scenario) Insert(stage, value.stage) Insert(timestamp, value.timestamp) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: ScenarioTrace*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(actionmessageOption, value.actionmessage) Insert(actionobjectOption, value.actionobject) Insert(actiontypeOption, value.actiontype) Insert(address, value.address) Insert(bonusbaseOption, value.bonusbase) Insert(bonusmessageOption, value.bonusmessage) Insert(event, value.event) Insert(id, value.id) Insert(idactionmessageOption, value.idactionmessage) Insert(idbonusmessageOption, value.idbonusmessage) Insert(idmarketingmessageOption, value.idmarketingmessage) Insert(marketingmessageOption, value.marketingmessage) Insert(parentstageOption, value.parentstage) Insert(scenario, value.scenario) Insert(stage, value.stage) Insert(timestamp, value.timestamp) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}