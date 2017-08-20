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
import scenarios.Scr_ScenarioClobConfig
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_ScenarioTblClobConfig {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblClobConfig(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioTblClobConfig(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}
 
class Scr_ScenarioTblClobConfig(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_ScenarioTblClobConfig]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_SCENARIO"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val id_scenario = LongColumnTable(name = "IDID_SCENARIO")    
    val clobConfigOption = ClobOptionColumnTable(name = "CLBCLOBCONFIG")    
    
    // For select tuple: (id_scenario: Long, clobConfigOption: Array[Clob])    
    
    type ColumnTypes =     TupleSS2[Long, Array[Clob]]    
     def allColumns = id_scenario ~ clobConfigOption    
    
     def insert(values: TupleSS2[Long, Array[Clob]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigOption, value _2)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS2[Long, Array[Clob]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigOption, value _2)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Clob]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value _1) Insert(clobConfigOption, value _2)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_ScenarioClobConfig*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigOption, value.clobConfig) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_ScenarioClobConfig*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigOption, value.clobConfig) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioClobConfig*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(id_scenario, value.id_scenario) Insert(clobConfigOption, value.clobConfig) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}