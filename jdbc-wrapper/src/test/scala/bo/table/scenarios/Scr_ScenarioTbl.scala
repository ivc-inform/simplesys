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
import scenarios.Scr_Scenario
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_ScenarioTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTbl(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}
 
class Scr_ScenarioTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_ScenarioTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_SCENARIO"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val begin_scenarioOption = LocalDateTimeOptionColumnTable(name = "DTBEGIN_SCENARIO")    
    val caption_scenario = StringColumnTable(name = "SCAPTION_SCENARIO")    
    val code_scenario = StringColumnTable(name = "SCODE_SCENARIO")    
    val debug_modeOption = BooleanOptionColumnTable(name = "BDEBUG_MODE")    
    val description_scenarioOption = StringOptionColumnTable(name = "SDESCRIPTION_SCENARIO")    
    val end_scenarioOption = LocalDateTimeOptionColumnTable(name = "DTEND_SCENARIO")    
    val id_cmpgnOption = LongOptionColumnTable(name = "IDID_CMPGN")    
    val id_scenario = LongColumnTable(name = "IDID_SCENARIO")    
    val statusOption = LongOptionColumnTable(name = "NSTATUS")    
    val versionOption = LocalDateTimeOptionColumnTable(name = "DTVERSION")    
    
    // For select tuple: (begin_scenarioOption: Array[LocalDateTime], caption_scenario: String, code_scenario: String, debug_modeOption: Array[Boolean], description_scenarioOption: Array[String], end_scenarioOption: Array[LocalDateTime], id_cmpgnOption: Array[Long], id_scenario: Long, statusOption: Array[Long], versionOption: Array[LocalDateTime])    
    
    type ColumnTypes =     TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]    
     def allColumns = begin_scenarioOption ~ caption_scenario ~ code_scenario ~ debug_modeOption ~ description_scenarioOption ~ end_scenarioOption ~ id_cmpgnOption ~ id_scenario ~ statusOption ~ versionOption    
    
     def insert(values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value _1) Insert(caption_scenario, value _2) Insert(code_scenario, value _3) Insert(debug_modeOption, value _4) Insert(description_scenarioOption, value _5) Insert(end_scenarioOption, value _6) Insert(id_cmpgnOption, value _7) Insert(id_scenario, value _8) Insert(statusOption, value _9) Insert(versionOption, value _10)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value _1) Insert(caption_scenario, value _2) Insert(code_scenario, value _3) Insert(debug_modeOption, value _4) Insert(description_scenarioOption, value _5) Insert(end_scenarioOption, value _6) Insert(id_cmpgnOption, value _7) Insert(id_scenario, value _8) Insert(statusOption, value _9) Insert(versionOption, value _10)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value _1) Insert(caption_scenario, value _2) Insert(code_scenario, value _3) Insert(debug_modeOption, value _4) Insert(description_scenarioOption, value _5) Insert(end_scenarioOption, value _6) Insert(id_cmpgnOption, value _7) Insert(id_scenario, value _8) Insert(statusOption, value _9) Insert(versionOption, value _10)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_Scenario*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value.begin_scenario) Insert(caption_scenario, value.caption_scenario) Insert(code_scenario, value.code_scenario) Insert(debug_modeOption, value.debug_mode) Insert(description_scenarioOption, value.description_scenario) Insert(end_scenarioOption, value.end_scenario) Insert(id_cmpgnOption, value.id_cmpgn) Insert(id_scenario, value.id_scenario) Insert(statusOption, value.status) Insert(versionOption, value.version) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_Scenario*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value.begin_scenario) Insert(caption_scenario, value.caption_scenario) Insert(code_scenario, value.code_scenario) Insert(debug_modeOption, value.debug_mode) Insert(description_scenarioOption, value.description_scenario) Insert(end_scenarioOption, value.end_scenario) Insert(id_cmpgnOption, value.id_cmpgn) Insert(id_scenario, value.id_scenario) Insert(statusOption, value.status) Insert(versionOption, value.version) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Scenario*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(begin_scenarioOption, value.begin_scenario) Insert(caption_scenario, value.caption_scenario) Insert(code_scenario, value.code_scenario) Insert(debug_modeOption, value.debug_mode) Insert(description_scenarioOption, value.description_scenario) Insert(end_scenarioOption, value.end_scenario) Insert(id_cmpgnOption, value.id_cmpgn) Insert(id_scenario, value.id_scenario) Insert(statusOption, value.status) Insert(versionOption, value.version) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}