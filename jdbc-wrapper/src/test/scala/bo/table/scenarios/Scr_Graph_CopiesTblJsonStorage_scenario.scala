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
import scenarios.Scr_Graph_CopiesJsonStorage_scenario
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_Graph_CopiesTblJsonStorage_scenario {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesTblJsonStorage_scenario(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesTblJsonStorage_scenario(alias = alias)    
    
    val objectName = "Scr_Graph_Copies"    
    val groupName = "scenarios"
}
 
class Scr_Graph_CopiesTblJsonStorage_scenario(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_Graph_CopiesTblJsonStorage_scenario]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_GRAPH_COPIES"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val id = LongColumnTable(name = "ID")    
    val id_scenario_ref = LongColumnTable(name = "IDID_SCENARIO_REF")    
    val jsonStorage_scenarioOption = JsonOptionColumnTable(name = "JSNJSONSTORAGE_SCENARIO")    
    
    // For select tuple: (id: Long, id_scenario_ref: Long, jsonStorage_scenarioOption: Array[Json])    
    
    type ColumnTypes =     TupleSS3[Long, Long, Array[Json]]    
     def allColumns = id ~ id_scenario_ref ~ jsonStorage_scenarioOption    
    
     def insert(values: TupleSS3[Long, Long, Array[Json]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id, value _1) Insert(id_scenario_ref, value _2) Insert(jsonStorage_scenarioOption, value _3)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS3[Long, Long, Array[Json]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id, value _1) Insert(id_scenario_ref, value _2) Insert(jsonStorage_scenarioOption, value _3)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Long, Long, Array[Json]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id, value _1) Insert(id_scenario_ref, value _2) Insert(jsonStorage_scenarioOption, value _3)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_Graph_CopiesJsonStorage_scenario*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_Graph_CopiesJsonStorage_scenario*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Graph_CopiesJsonStorage_scenario*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(jsonStorage_scenarioOption, value.jsonStorage_scenario) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}