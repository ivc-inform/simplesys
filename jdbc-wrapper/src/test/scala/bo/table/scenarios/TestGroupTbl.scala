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
import scenarios.TestGroup
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object TestGroupTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new TestGroupTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestGroupTbl(alias = alias)    
    
    val objectName = "TestGroup"    
    val groupName = "scenarios"
}
 
class TestGroupTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[TestGroupTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_TESTGROUP"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val active = BooleanColumnTable(name = "BACTIVE")    
    val captionGroupOption = StringOptionColumnTable(name = "SCAPTIONGROUP")    
    val codeGroup = StringColumnTable(name = "SCODEGROUP")    
    val descriptionGroupOption = StringOptionColumnTable(name = "SDESCRIPTIONGROUP")    
    val id = LongColumnTable(name = "ID")    
    val parentOption = LongOptionColumnTable(name = "IDPARENT")    
    val statusOption = LongOptionColumnTable(name = "NSTATUS")    
    
    // For select tuple: (active: Boolean, captionGroupOption: Array[String], codeGroup: String, descriptionGroupOption: Array[String], id: Long, parentOption: Array[Long], statusOption: Array[Long])    
    
    type ColumnTypes =     TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]    
     def allColumns = active ~ captionGroupOption ~ codeGroup ~ descriptionGroupOption ~ id ~ parentOption ~ statusOption    
    
     def insert(values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(id, value _5) Insert(parentOption, value _6) Insert(statusOption, value _7)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(id, value _5) Insert(parentOption, value _6) Insert(statusOption, value _7)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(id, value _5) Insert(parentOption, value _6) Insert(statusOption, value _7)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: TestGroup*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(id, value.id) Insert(parentOption, value.parent) Insert(statusOption, value.status) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: TestGroup*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(id, value.id) Insert(parentOption, value.parent) Insert(statusOption, value.status) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: TestGroup*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(id, value.id) Insert(parentOption, value.parent) Insert(statusOption, value.status) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}