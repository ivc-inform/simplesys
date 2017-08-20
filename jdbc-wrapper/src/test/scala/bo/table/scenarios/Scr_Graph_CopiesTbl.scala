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
import scenarios.Scr_Graph_Copies
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_Graph_CopiesTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesTbl(alias = alias)    
    
    val objectName = "Scr_Graph_Copies"    
    val groupName = "scenarios"
}
 
class Scr_Graph_CopiesTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_Graph_CopiesTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_GRAPH_COPIES"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val description_copyOption = StringOptionColumnTable(name = "SDESCRIPTION_COPY")    
    val id = LongColumnTable(name = "ID")    
    val id_scenario_ref = LongColumnTable(name = "IDID_SCENARIO_REF")    
    val version = LocalDateTimeColumnTable(name = "DTVERSION")    
    
    // For select tuple: (description_copyOption: Array[String], id: Long, id_scenario_ref: Long, version: LocalDateTime)    
    
    type ColumnTypes =     TupleSS4[Array[String], Long, Long, LocalDateTime]    
     def allColumns = description_copyOption ~ id ~ id_scenario_ref ~ version    
    
     def insert(values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(description_copyOption, value _1) Insert(id, value _2) Insert(id_scenario_ref, value _3) Insert(version, value _4)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(description_copyOption, value _1) Insert(id, value _2) Insert(id_scenario_ref, value _3) Insert(version, value _4)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(description_copyOption, value _1) Insert(id, value _2) Insert(id_scenario_ref, value _3) Insert(version, value _4)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_Graph_Copies*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(description_copyOption, value.description_copy) Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(version, value.version) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_Graph_Copies*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(description_copyOption, value.description_copy) Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(version, value.version) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Graph_Copies*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(description_copyOption, value.description_copy) Insert(id, value.id) Insert(id_scenario_ref, value.id_scenario_ref) Insert(version, value.version) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}