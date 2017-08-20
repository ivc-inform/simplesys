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
import scenarios.ListElements
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object ListElementsTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new ListElementsTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListElementsTbl(alias = alias)    
    
    val objectName = "ListElements"    
    val groupName = "scenarios"
}
 
class ListElementsTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[ListElementsTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_LISTELEMENTS"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val element_list = StringColumnTable(name = "SELEMENT_LIST")    
    val id_list = LongColumnTable(name = "IDID_LIST")    
    val id_list_element = LongColumnTable(name = "IDID_LIST_ELEMENT")    
    
    // For select tuple: (element_list: String, id_list: Long, id_list_element: Long)    
    
    type ColumnTypes =     TupleSS3[String, Long, Long]    
     def allColumns = element_list ~ id_list ~ id_list_element    
    
     def insert(values: TupleSS3[String, Long, Long]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(element_list, value _1) Insert(id_list, value _2) Insert(id_list_element, value _3)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS3[String, Long, Long]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(element_list, value _1) Insert(id_list, value _2) Insert(id_list_element, value _3)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Long]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(element_list, value _1) Insert(id_list, value _2) Insert(id_list_element, value _3)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: ListElements*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(element_list, value.element_list) Insert(id_list, value.id_list) Insert(id_list_element, value.id_list_element) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: ListElements*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(element_list, value.element_list) Insert(id_list, value.id_list) Insert(id_list_element, value.id_list_element) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: ListElements*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(element_list, value.element_list) Insert(id_list, value.id_list) Insert(id_list_element, value.id_list_element) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}