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
import scenarios.Scr_ScenarioJsonStorage_scenario
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_ScenarioTblJsonStorage_scenario {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblJsonStorage_scenario(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblJsonStorage_scenario(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}
 
class Scr_ScenarioTblJsonStorage_scenario(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_ScenarioTblJsonStorage_scenario]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_SCENARIO"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val id_scenario = LongColumnTable(name = "IDID_SCENARIO")    
    val jsonStorage_scenarioOption = JsonOptionColumnTable(name = "JSNJSONSTORAGE_SCENARIO")    
    
    // For select tuple: (id_scenario: Long, jsonStorage_scenarioOption: Array[Json])    
    
    type ColumnTypes =     TupleSS2[Long, Array[Json]]    
     def allColumns = id_scenario ~ jsonStorage_scenarioOption    
    
     def insert(values: TupleSS2[Long, Array[Json]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(jsonStorage_scenarioOption, value _2)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS2[Long, Array[Json]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(jsonStorage_scenarioOption, value _2)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Json]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(jsonStorage_scenarioOption, value _2)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_ScenarioJsonStorage_scenario*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_ScenarioJsonStorage_scenario*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioJsonStorage_scenario*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}