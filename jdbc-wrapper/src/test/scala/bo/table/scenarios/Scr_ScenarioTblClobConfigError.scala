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
import scenarios.Scr_ScenarioClobConfigError
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_ScenarioTblClobConfigError {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblClobConfigError(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblClobConfigError(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}
 
class Scr_ScenarioTblClobConfigError(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_ScenarioTblClobConfigError]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_SCENARIO"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val id_scenario = LongColumnTable(name = "IDID_SCENARIO")    
    val clobConfigErrorOption = ClobOptionColumnTable(name = "CLBCLOBCONFIGERROR")    
    
    // For select tuple: (id_scenario: Long, clobConfigErrorOption: Array[Clob])    
    
    type ColumnTypes =     TupleSS2[Long, Array[Clob]]    
     def allColumns = id_scenario ~ clobConfigErrorOption    
    
     def insert(values: TupleSS2[Long, Array[Clob]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigErrorOption, value _2)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS2[Long, Array[Clob]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigErrorOption, value _2)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Clob]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigErrorOption, value _2)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_ScenarioClobConfigError*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigErrorOption, value.clobConfigError) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_ScenarioClobConfigError*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigErrorOption, value.clobConfigError) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioClobConfigError*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigErrorOption, value.clobConfigError) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}