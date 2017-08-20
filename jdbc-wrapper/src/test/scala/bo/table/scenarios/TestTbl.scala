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
import scenarios.Test
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object TestTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new TestTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestTbl(alias = alias)    
    
    val objectName = "Test"    
    val groupName = "scenarios"
}
 
class TestTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[TestTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_TEST"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val active = BooleanColumnTable(name = "BACTIVE")    
    val address = StringColumnTable(name = "SADDRESS")    
    val captionTestOption = StringOptionColumnTable(name = "SCAPTIONTEST")    
    val codeTestOption = StringOptionColumnTable(name = "SCODETEST")    
    val createDateOption = LocalDateTimeOptionColumnTable(name = "DTCREATEDATE")    
    val descriptionTestOption = StringOptionColumnTable(name = "SDESCRIPTIONTEST")    
    val group = LongColumnTable(name = "IDGROUP")    
    val id = LongColumnTable(name = "ID")    
    val text = StringColumnTable(name = "STEXT")    
    val timestamp = LocalDateTimeColumnTable(name = "DTTIMESTAMP")    
    
    // For select tuple: (active: Boolean, address: String, captionTestOption: Array[String], codeTestOption: Array[String], createDateOption: Array[LocalDateTime], descriptionTestOption: Array[String], group: Long, id: Long, text: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]    
     def allColumns = active ~ address ~ captionTestOption ~ codeTestOption ~ createDateOption ~ descriptionTestOption ~ group ~ id ~ text ~ timestamp    
    
     def insert(values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(address, value _2) Insert(captionTestOption, value _3) Insert(codeTestOption, value _4) Insert(createDateOption, value _5) Insert(descriptionTestOption, value _6) Insert(group, value _7) Insert(id, value _8) Insert(text, value _9) Insert(timestamp, value _10)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(address, value _2) Insert(captionTestOption, value _3) Insert(codeTestOption, value _4) Insert(createDateOption, value _5) Insert(descriptionTestOption, value _6) Insert(group, value _7) Insert(id, value _8) Insert(text, value _9) Insert(timestamp, value _10)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(address, value _2) Insert(captionTestOption, value _3) Insert(codeTestOption, value _4) Insert(createDateOption, value _5) Insert(descriptionTestOption, value _6) Insert(group, value _7) Insert(id, value _8) Insert(text, value _9) Insert(timestamp, value _10)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Test*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(address, value.address) Insert(captionTestOption, value.captionTest) Insert(codeTestOption, value.codeTest) Insert(createDateOption, value.createDate) Insert(descriptionTestOption, value.descriptionTest) Insert(group, value.group) Insert(id, value.id) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Test*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(address, value.address) Insert(captionTestOption, value.captionTest) Insert(codeTestOption, value.codeTest) Insert(createDateOption, value.createDate) Insert(descriptionTestOption, value.descriptionTest) Insert(group, value.group) Insert(id, value.id) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Test*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(address, value.address) Insert(captionTestOption, value.captionTest) Insert(codeTestOption, value.codeTest) Insert(createDateOption, value.createDate) Insert(descriptionTestOption, value.descriptionTest) Insert(group, value.group) Insert(id, value.id) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}