// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenTables"

package ru.simplesys.defs.bo

package data.table

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.jdbc.control.{ValidationEx, Table}
import com.simplesys.jdbc.control.table.Insert
import org.joda.time.{LocalDateTime, DateTime}
import java.sql.{Connection, PreparedStatement}
import com.simplesys.sql.SQLDialect
import com.simplesys.SQL.Gen.SQLAlias
import com.simplesys.common.Strings._
import data.COM_Data_DM
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object COM_Data_DMTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new COM_Data_DMTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new COM_Data_DMTbl(alias = alias)    
    
    val objectName = "COM_Data_DM"    
    val groupName = "data"
}
 
class COM_Data_DMTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[COM_Data_DMTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "DT_COM_DATA_DM"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val acnOption = LongOptionColumnTable(name = "IDACN")    
    val acnCode = StringColumnTable(name = "SACNCODE")    
    val address = StringColumnTable(name = "SADDRESS")    
    val cnrOption = LongOptionColumnTable(name = "IDCNR")    
    val cnrCodeOption = StringOptionColumnTable(name = "SCNRCODE")    
    val dlv_errorOption = StringOptionColumnTable(name = "SDLV_ERROR")    
    val dlv_status = StringColumnTable(name = "SSDLV_STATUS")    
    val dlv_status_at = LocalDateTimeColumnTable(name = "DTDLV_STATUS_AT")    
    val id = BigDecimalColumnTable(name = "DIID")    
    val start_timeOption = LocalDateTimeOptionColumnTable(name = "DTSTART_TIME")    
    val subject = StringColumnTable(name = "SSUBJECT")    
    val text = StringColumnTable(name = "STEXT")    
    val timestamp = LocalDateTimeColumnTable(name = "DTTIMESTAMP")    
    
    // For select tuple: (acnOption: Array[Long], acnCode: String, address: String, cnrOption: Array[Long], cnrCodeOption: Array[String], dlv_errorOption: Array[String], dlv_status: String, dlv_status_at: LocalDateTime, id: BigDecimal, start_timeOption: Array[LocalDateTime], subject: String, text: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]    
     def allColumns = acnOption ~ acnCode ~ address ~ cnrOption ~ cnrCodeOption ~ dlv_errorOption ~ dlv_status ~ dlv_status_at ~ id ~ start_timeOption ~ subject ~ text ~ timestamp    
    
     def insert(values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(acnOption, value _1) Insert(acnCode, value _2) Insert(address, value _3) Insert(cnrOption, value _4) Insert(cnrCodeOption, value _5) Insert(dlv_errorOption, value _6) Insert(dlv_status, value _7) Insert(dlv_status_at, value _8) Insert(id, value _9) Insert(start_timeOption, value _10) Insert(subject, value _11) Insert(text, value _12) Insert(timestamp, value _13)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(acnOption, value _1) Insert(acnCode, value _2) Insert(address, value _3) Insert(cnrOption, value _4) Insert(cnrCodeOption, value _5) Insert(dlv_errorOption, value _6) Insert(dlv_status, value _7) Insert(dlv_status_at, value _8) Insert(id, value _9) Insert(start_timeOption, value _10) Insert(subject, value _11) Insert(text, value _12) Insert(timestamp, value _13)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(acnOption, value _1) Insert(acnCode, value _2) Insert(address, value _3) Insert(cnrOption, value _4) Insert(cnrCodeOption, value _5) Insert(dlv_errorOption, value _6) Insert(dlv_status, value _7) Insert(dlv_status_at, value _8) Insert(id, value _9) Insert(start_timeOption, value _10) Insert(subject, value _11) Insert(text, value _12) Insert(timestamp, value _13)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: COM_Data_DM*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(acnOption, value.acn) Insert(acnCode, value.acnCode) Insert(address, value.address) Insert(cnrOption, value.cnr) Insert(cnrCodeOption, value.cnrCode) Insert(dlv_errorOption, value.dlv_error) Insert(dlv_status, value.dlv_status) Insert(dlv_status_at, value.dlv_status_at) Insert(id, value.id) Insert(start_timeOption, value.start_time) Insert(subject, value.subject) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: COM_Data_DM*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(acnOption, value.acn) Insert(acnCode, value.acnCode) Insert(address, value.address) Insert(cnrOption, value.cnr) Insert(cnrCodeOption, value.cnrCode) Insert(dlv_errorOption, value.dlv_error) Insert(dlv_status, value.dlv_status) Insert(dlv_status_at, value.dlv_status_at) Insert(id, value.id) Insert(start_timeOption, value.start_time) Insert(subject, value.subject) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: COM_Data_DM*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(acnOption, value.acn) Insert(acnCode, value.acnCode) Insert(address, value.address) Insert(cnrOption, value.cnr) Insert(cnrCodeOption, value.cnrCode) Insert(dlv_errorOption, value.dlv_error) Insert(dlv_status, value.dlv_status) Insert(dlv_status_at, value.dlv_status_at) Insert(id, value.id) Insert(start_timeOption, value.start_time) Insert(subject, value.subject) Insert(text, value.text) Insert(timestamp, value.timestamp) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}