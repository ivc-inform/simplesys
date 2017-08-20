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
import scenarios.ScenarioStatistics
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object ScenarioStatisticsTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsTbl(alias = alias)    
    
    val objectName = "ScenarioStatistics"    
    val groupName = "scenarios"
}
 
class ScenarioStatisticsTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[ScenarioStatisticsTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCENARIOSTATISTICS"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val date = LocalDateTimeColumnTable(name = "DTDATE")    
    val in = LongColumnTable(name = "NIN")    
    val out = LongColumnTable(name = "NOUT")    
    val scenario = StringColumnTable(name = "SSCENARIO")    
    
    // For select tuple: (date: LocalDateTime, in: Long, out: Long, scenario: String)    
    
    type ColumnTypes =     TupleSS4[LocalDateTime, Long, Long, String]    
     def allColumns = date ~ in ~ out ~ scenario    
    
     def insert(values: TupleSS4[LocalDateTime, Long, Long, String]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(date, value _1) Insert(in, value _2) Insert(out, value _3) Insert(scenario, value _4)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS4[LocalDateTime, Long, Long, String]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(date, value _1) Insert(in, value _2) Insert(out, value _3) Insert(scenario, value _4)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[LocalDateTime, Long, Long, String]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(date, value _1) Insert(in, value _2) Insert(out, value _3) Insert(scenario, value _4)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: ScenarioStatistics*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(date, value.date) Insert(in, value.in) Insert(out, value.out) Insert(scenario, value.scenario) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: ScenarioStatistics*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(date, value.date) Insert(in, value.in) Insert(out, value.out) Insert(scenario, value.scenario) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: ScenarioStatistics*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(date, value.date) Insert(in, value.in) Insert(out, value.out) Insert(scenario, value.scenario) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}