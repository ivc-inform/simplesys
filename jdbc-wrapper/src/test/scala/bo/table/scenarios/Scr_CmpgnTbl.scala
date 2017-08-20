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
import scenarios.Scr_Cmpgn
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object Scr_CmpgnTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnTbl(alias = alias)    
    
    val objectName = "Scr_Cmpgn"    
    val groupName = "scenarios"
}
 
class Scr_CmpgnTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[Scr_CmpgnTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_SCR_CMPGN"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val active_cmpgnOption = BooleanOptionColumnTable(name = "BACTIVE_CMPGN")    
    val begin_cmpgnOption = LocalDateTimeOptionColumnTable(name = "DTBEGIN_CMPGN")    
    val caption_cmpgn = StringColumnTable(name = "SCAPTION_CMPGN")    
    val code_cmpgn = StringColumnTable(name = "SCODE_CMPGN")    
    val description_cmpgnOption = StringOptionColumnTable(name = "SDESCRIPTION_CMPGN")    
    val end_cmpgnOption = LocalDateTimeOptionColumnTable(name = "DTEND_CMPGN")    
    val id_cmpgn = LongColumnTable(name = "IDID_CMPGN")    
    val parent_cmpgnOption = LongOptionColumnTable(name = "IDPARENT_CMPGN")    
    
    // For select tuple: (active_cmpgnOption: Array[Boolean], begin_cmpgnOption: Array[LocalDateTime], caption_cmpgn: String, code_cmpgn: String, description_cmpgnOption: Array[String], end_cmpgnOption: Array[LocalDateTime], id_cmpgn: Long, parent_cmpgnOption: Array[Long])    
    
    type ColumnTypes =     TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]    
     def allColumns = active_cmpgnOption ~ begin_cmpgnOption ~ caption_cmpgn ~ code_cmpgn ~ description_cmpgnOption ~ end_cmpgnOption ~ id_cmpgn ~ parent_cmpgnOption    
    
     def insert(values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value _1) Insert(begin_cmpgnOption, value _2) Insert(caption_cmpgn, value _3) Insert(code_cmpgn, value _4) Insert(description_cmpgnOption, value _5) Insert(end_cmpgnOption, value _6) Insert(id_cmpgn, value _7) Insert(parent_cmpgnOption, value _8)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value _1) Insert(begin_cmpgnOption, value _2) Insert(caption_cmpgn, value _3) Insert(code_cmpgn, value _4) Insert(description_cmpgnOption, value _5) Insert(end_cmpgnOption, value _6) Insert(id_cmpgn, value _7) Insert(parent_cmpgnOption, value _8)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value _1) Insert(begin_cmpgnOption, value _2) Insert(caption_cmpgn, value _3) Insert(code_cmpgn, value _4) Insert(description_cmpgnOption, value _5) Insert(end_cmpgnOption, value _6) Insert(id_cmpgn, value _7) Insert(parent_cmpgnOption, value _8)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: Scr_Cmpgn*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value.active_cmpgn) Insert(begin_cmpgnOption, value.begin_cmpgn) Insert(caption_cmpgn, value.caption_cmpgn) Insert(code_cmpgn, value.code_cmpgn) Insert(description_cmpgnOption, value.description_cmpgn) Insert(end_cmpgnOption, value.end_cmpgn) Insert(id_cmpgn, value.id_cmpgn) Insert(parent_cmpgnOption, value.parent_cmpgn) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: Scr_Cmpgn*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value.active_cmpgn) Insert(begin_cmpgnOption, value.begin_cmpgn) Insert(caption_cmpgn, value.caption_cmpgn) Insert(code_cmpgn, value.code_cmpgn) Insert(description_cmpgnOption, value.description_cmpgn) Insert(end_cmpgnOption, value.end_cmpgn) Insert(id_cmpgn, value.id_cmpgn) Insert(parent_cmpgnOption, value.parent_cmpgn) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Cmpgn*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active_cmpgnOption, value.active_cmpgn) Insert(begin_cmpgnOption, value.begin_cmpgn) Insert(caption_cmpgn, value.caption_cmpgn) Insert(code_cmpgn, value.code_cmpgn) Insert(description_cmpgnOption, value.description_cmpgn) Insert(end_cmpgnOption, value.end_cmpgn) Insert(id_cmpgn, value.id_cmpgn) Insert(parent_cmpgnOption, value.parent_cmpgn) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}