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
import scenarios.ListGroups
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object ListGroupsTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new ListGroupsTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListGroupsTbl(alias = alias)    
    
    val objectName = "ListGroups"    
    val groupName = "scenarios"
}
 
class ListGroupsTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[ListGroupsTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_LISTGROUPS"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val caption_listGroup = StringColumnTable(name = "SCAPTION_LISTGROUP")    
    val code_listGroup = StringColumnTable(name = "SCODE_LISTGROUP")    
    val description_listGroupOption = StringOptionColumnTable(name = "SDESCRIPTION_LISTGROUP")    
    val id_listGroup = LongColumnTable(name = "IDID_LISTGROUP")    
    val parent_listGroupOption = LongOptionColumnTable(name = "IDPARENT_LISTGROUP")    
    
    // For select tuple: (caption_listGroup: String, code_listGroup: String, description_listGroupOption: Array[String], id_listGroup: Long, parent_listGroupOption: Array[Long])    
    
    type ColumnTypes =     TupleSS5[String, String, Array[String], Long, Array[Long]]    
     def allColumns = caption_listGroup ~ code_listGroup ~ description_listGroupOption ~ id_listGroup ~ parent_listGroupOption    
    
     def insert(values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(caption_listGroup, value _1) Insert(code_listGroup, value _2) Insert(description_listGroupOption, value _3) Insert(id_listGroup, value _4) Insert(parent_listGroupOption, value _5)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(caption_listGroup, value _1) Insert(code_listGroup, value _2) Insert(description_listGroupOption, value _3) Insert(id_listGroup, value _4) Insert(parent_listGroupOption, value _5)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(caption_listGroup, value _1) Insert(code_listGroup, value _2) Insert(description_listGroupOption, value _3) Insert(id_listGroup, value _4) Insert(parent_listGroupOption, value _5)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: ListGroups*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(caption_listGroup, value.caption_listGroup) Insert(code_listGroup, value.code_listGroup) Insert(description_listGroupOption, value.description_listGroup) Insert(id_listGroup, value.id_listGroup) Insert(parent_listGroupOption, value.parent_listGroup) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: ListGroups*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(caption_listGroup, value.caption_listGroup) Insert(code_listGroup, value.code_listGroup) Insert(description_listGroupOption, value.description_listGroup) Insert(id_listGroup, value.id_listGroup) Insert(parent_listGroupOption, value.parent_listGroup) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: ListGroups*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(caption_listGroup, value.caption_listGroup) Insert(code_listGroup, value.code_listGroup) Insert(description_listGroupOption, value.description_listGroup) Insert(id_listGroup, value.id_listGroup) Insert(parent_listGroupOption, value.parent_listGroup) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}