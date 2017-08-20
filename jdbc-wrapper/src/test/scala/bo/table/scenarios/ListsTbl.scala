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
import scenarios.Lists
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object ListsTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new ListsTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListsTbl(alias = alias)    
    
    val objectName = "Lists"    
    val groupName = "scenarios"
}
 
class ListsTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[ListsTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_LISTS"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val caption_list = StringColumnTable(name = "SCAPTION_LIST")    
    val code_list = StringColumnTable(name = "SCODE_LIST")    
    val description_listOption = StringOptionColumnTable(name = "SDESCRIPTION_LIST")    
    val id_list = LongColumnTable(name = "IDID_LIST")    
    val id_listGroup_refOption = LongOptionColumnTable(name = "IDID_LISTGROUP_REF")    
    val type_list = StringColumnTable(name = "STYPE_LIST")    
    
    // For select tuple: (caption_list: String, code_list: String, description_listOption: Array[String], id_list: Long, id_listGroup_refOption: Array[Long], type_list: String)    
    
    type ColumnTypes =     TupleSS6[String, String, Array[String], Long, Array[Long], String]    
     def allColumns = caption_list ~ code_list ~ description_listOption ~ id_list ~ id_listGroup_refOption ~ type_list    
    
     def insert(values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(caption_list, value _1) Insert(code_list, value _2) Insert(description_listOption, value _3) Insert(id_list, value _4) Insert(id_listGroup_refOption, value _5) Insert(type_list, value _6)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(caption_list, value _1) Insert(code_list, value _2) Insert(description_listOption, value _3) Insert(id_list, value _4) Insert(id_listGroup_refOption, value _5) Insert(type_list, value _6)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(caption_list, value _1) Insert(code_list, value _2) Insert(description_listOption, value _3) Insert(id_list, value _4) Insert(id_listGroup_refOption, value _5) Insert(type_list, value _6)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Lists*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(caption_list, value.caption_list) Insert(code_list, value.code_list) Insert(description_listOption, value.description_list) Insert(id_list, value.id_list) Insert(id_listGroup_refOption, value.id_listGroup_ref) Insert(type_list, value.type_list) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Lists*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(caption_list, value.caption_list) Insert(code_list, value.code_list) Insert(description_listOption, value.description_list) Insert(id_list, value.id_list) Insert(id_listGroup_refOption, value.id_listGroup_ref) Insert(type_list, value.type_list) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Lists*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(caption_list, value.caption_list) Insert(code_list, value.code_list) Insert(description_listOption, value.description_list) Insert(id_list, value.id_list) Insert(id_listGroup_refOption, value.id_listGroup_ref) Insert(type_list, value.type_list) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}