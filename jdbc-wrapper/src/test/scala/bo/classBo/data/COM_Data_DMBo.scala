// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenBOs, stage: #819"

package ru.simplesys.defs.bo

package data

import com.simplesys.jdbc.control._
import com.simplesys.bonecp.BoneCPDataSource
import java.sql.Connection
import com.simplesys.jdbc.control.SessionStructures._
import com.simplesys.jdbc.control.ValidationEx
import com.simplesys.SQL.Gen.{SQLAlias, SQLAbsTable, SQLTable}
import com.simplesys.jdbc.control.classBO.{Where, Set}
import com.simplesys.jdbc.control.table.From
import org.joda.time.{LocalDateTime, DateTime}
import com.simplesys.jdbc.control.table.{Insert, InnerJoin}
import scalaz.{Failure, Success}
import ru.simplesys.defs.bo.data.table._
import com.simplesys.common.array._
import com.simplesys.jdbc.control.SuperTuple1.FieldProduct
import com.simplesys.jdbc._
import com.simplesys.SQL._
import com.simplesys.common.Strings._
import collection.SeqView
import com.simplesys.json.JsonElement
import com.simplesys.jdbc.control.clob._
import com.simplesys.tuple._
import com.simplesys.jdbc.control.table.JoinsTable._



 
object COM_Data_DMBo {
     def apply(implicit dataSource: BoneCPDataSource) = new COM_Data_DMBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new COM_Data_DMBo(alias = alias)    
    
    val objectName = "COM_Data_DM"    
    val groupName = "data"
}


 
class COM_Data_DMBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[COM_Data_DMBo]  {
/////////////////////////////////////////// Class: COM_Data_DM, group: data ///////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): COM_Data_DMBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val COM_Data_DMTbl = new COM_Data_DMTbl(alias = alias + "T0".als)    
    override val fromTable = COM_Data_DMTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val acn = LongOptionColumn(name = "IDACN", nameInBo = "acn", caption = "ID \u043A\u043B\u0438\u0435\u043D\u0442\u0430", tableColumn = COM_Data_DMTbl.acnOption)    
    val acnCode = StringColumn(name = "SACNCODE", nameInBo = "acnCode", caption = "\u041A\u043E\u0434 \u043A\u043B\u0438\u0435\u043D\u0442\u0430", tableColumn = COM_Data_DMTbl.acnCode)    
    val address = StringColumn(name = "SADDRESS", nameInBo = "address", caption = "\u0422\u0435\u043B\u0435\u0444\u043E\u043D", tableColumn = COM_Data_DMTbl.address)    
    val cnr = LongOptionColumn(name = "IDCNR", nameInBo = "cnr", caption = "ID \u043A\u043E\u043D\u043D\u0435\u043A\u0442\u043E\u0440\u0430", tableColumn = COM_Data_DMTbl.cnrOption)    
    val cnrCode = StringOptionColumn(name = "SCNRCODE", nameInBo = "cnrCode", caption = "\u041A\u043E\u0434 \u043A\u043E\u043D\u043D\u0435\u043A\u0442\u043E\u0440\u0430", tableColumn = COM_Data_DMTbl.cnrCodeOption)    
    val dlv_error = StringOptionColumn(name = "SDLV_ERROR", nameInBo = "dlv_error", caption = "\u041E\u0448\u0438\u0431\u043A\u0430 \u0434\u043E\u0441\u0442\u0430\u0432\u043A\u0438", tableColumn = COM_Data_DMTbl.dlv_errorOption)    
    val dlv_status = StringColumn(name = "SSDLV_STATUS", nameInBo = "dlv_status", caption = "\u0421\u0442\u0430\u0442\u0443\u0441 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = COM_Data_DMTbl.dlv_status)    
    val dlv_status_at = LocalDateTimeColumn(name = "DTDLV_STATUS_AT", nameInBo = "dlv_status_at", caption = "\u0412\u0440\u0435\u043C\u044F \u043C\u043E\u0434\u0438\u0444\u0438\u043A\u0430\u0446\u0438\u0438 \u0441\u0442\u0430\u0442\u0443\u0441\u0430", tableColumn = COM_Data_DMTbl.dlv_status_at)    
    val id = BigDecimalColumn(name = "DIID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = COM_Data_DMTbl.id)    
    val start_time = LocalDateTimeOptionColumn(name = "DTSTART_TIME", nameInBo = "start_time", caption = "\u0412\u0440\u0435\u043C\u044F \u043E\u0442\u043F\u0440\u0430\u0432\u043A\u0438 \u043E\u0442\u043B\u043E\u0436\u0435\u043D\u043D\u043E\u0433\u043E \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = COM_Data_DMTbl.start_timeOption)    
    val subject = StringColumn(name = "SSUBJECT", nameInBo = "subject", caption = "\u0422\u0435\u043C\u0430 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = COM_Data_DMTbl.subject)    
    val text = StringColumn(name = "STEXT", nameInBo = "text", caption = "\u0421\u043E\u0434\u0435\u0440\u0436\u0430\u043D\u0438\u0435 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = COM_Data_DMTbl.text)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "\u0412\u0440\u0435\u043C\u044F \u0434\u043E\u0431\u0430\u043B\u0435\u043D\u0438\u044F \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = COM_Data_DMTbl.timestamp)    
    
    // For select tuple: (acn: Array[Long], acnCode: String, address: String, cnr: Array[Long], cnrCode: Array[String], dlv_error: Array[String], dlv_status: String, dlv_status_at: LocalDateTime, id: BigDecimal, start_time: Array[LocalDateTime], subject: String, text: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]    
    val allColumns = acn ~ acnCode ~ address ~ cnr ~ cnrCode ~ dlv_error ~ dlv_status ~ dlv_status_at ~ id ~ start_time ~ subject ~ text ~ timestamp    
    val allColumns1 = Seq(acn , acnCode , address , cnr , cnrCode , dlv_error , dlv_status , dlv_status_at , id , start_time , subject , text , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: COM_Data_DM //////////////////////////////////////////////    
    val acnCOM_Data_DMTbl = COM_Data_DMTbl.acnOption    
    val acnCodeCOM_Data_DMTbl = COM_Data_DMTbl.acnCode    
    val addressCOM_Data_DMTbl = COM_Data_DMTbl.address    
    val cnrCOM_Data_DMTbl = COM_Data_DMTbl.cnrOption    
    val cnrCodeCOM_Data_DMTbl = COM_Data_DMTbl.cnrCodeOption    
    val dlv_errorCOM_Data_DMTbl = COM_Data_DMTbl.dlv_errorOption    
    val dlv_statusCOM_Data_DMTbl = COM_Data_DMTbl.dlv_status    
    val dlv_status_atCOM_Data_DMTbl = COM_Data_DMTbl.dlv_status_at    
    val idCOM_Data_DMTbl = COM_Data_DMTbl.id    
    val start_timeCOM_Data_DMTbl = COM_Data_DMTbl.start_timeOption    
    val subjectCOM_Data_DMTbl = COM_Data_DMTbl.subject    
    val textCOM_Data_DMTbl = COM_Data_DMTbl.text    
    val timestampCOM_Data_DMTbl = COM_Data_DMTbl.timestamp    
///////////////////////////////////////////// End Table: COM_Data_DM /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(COM_Data_DMTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[COM_Data_DM]] = 
        selectPIteratorRoot(columns = columns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS13(acn: Array[Long], acnCode: String, address: String, cnr: Array[Long], cnrCode: Array[String], dlv_error: Array[String], dlv_status: String, dlv_status_at: LocalDateTime, id: BigDecimal, start_time: Array[LocalDateTime], subject: String, text: String, timestamp: LocalDateTime) => 
        COM_Data_DM(acn = acn, acnCode = acnCode, address = address, cnr = cnr, cnrCode = cnrCode, dlv_error = dlv_error, dlv_status = dlv_status, dlv_status_at = dlv_status_at, id = id, start_time = start_time, subject = subject, text = text, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[COM_Data_DM]] = 
                selectListRoot(columns = allColumns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS13(acn: Array[Long], acnCode: String, address: String, cnr: Array[Long], cnrCode: Array[String], dlv_error: Array[String], dlv_status: String, dlv_status_at: LocalDateTime, id: BigDecimal, start_time: Array[LocalDateTime], subject: String, text: String, timestamp: LocalDateTime) => 
                        COM_Data_DM(acn = acn, acnCode = acnCode, address = address, cnr = cnr, cnrCode = cnrCode, dlv_error = dlv_error, dlv_status = dlv_status, dlv_status_at = dlv_status_at, id = id, start_time = start_time, subject = subject, text = text, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[COM_Data_DM] = 
                selectOneRoot(columns = allColumns, from = From(COM_Data_DMTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS13(acn: Array[Long], acnCode: String, address: String, cnr: Array[Long], cnrCode: Array[String], dlv_error: Array[String], dlv_status: String, dlv_status_at: LocalDateTime, id: BigDecimal, start_time: Array[LocalDateTime], subject: String, text: String, timestamp: LocalDateTime)) => 
                ValidationEx(Success(COM_Data_DM(acn = acn, acnCode = acnCode, address = address, cnr = cnr, cnrCode = cnrCode, dlv_error = dlv_error, dlv_status = dlv_status, dlv_status_at = dlv_status_at, id = id, start_time = start_time, subject = subject, text = text, timestamp = timestamp)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                COM_Data_DMTbl.insertWithoutCommit(connection = connection, columns = acnCOM_Data_DMTbl ~ acnCodeCOM_Data_DMTbl ~ addressCOM_Data_DMTbl ~ cnrCOM_Data_DMTbl ~ cnrCodeCOM_Data_DMTbl ~ dlv_errorCOM_Data_DMTbl ~ dlv_statusCOM_Data_DMTbl ~ dlv_status_atCOM_Data_DMTbl ~ idCOM_Data_DMTbl ~ start_timeCOM_Data_DMTbl ~ subjectCOM_Data_DMTbl ~ textCOM_Data_DMTbl ~ timestampCOM_Data_DMTbl, 
                    values map
                        {
                        value =>
                            Insert(acnCOM_Data_DMTbl, value _1) Insert(acnCodeCOM_Data_DMTbl, value _2) Insert(addressCOM_Data_DMTbl, value _3) Insert(cnrCOM_Data_DMTbl, value _4) Insert(cnrCodeCOM_Data_DMTbl, value _5) Insert(dlv_errorCOM_Data_DMTbl, value _6) Insert(dlv_statusCOM_Data_DMTbl, value _7) Insert(dlv_status_atCOM_Data_DMTbl, value _8) Insert(idCOM_Data_DMTbl, value _9) Insert(start_timeCOM_Data_DMTbl, value _10) Insert(subjectCOM_Data_DMTbl, value _11) Insert(textCOM_Data_DMTbl, value _12) Insert(timestampCOM_Data_DMTbl, value _13)
                    })
        }    
    
     def insertP(values: COM_Data_DM*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                COM_Data_DMTbl.insertWithoutCommit(connection = connection, columns = acnCOM_Data_DMTbl ~ acnCodeCOM_Data_DMTbl ~ addressCOM_Data_DMTbl ~ cnrCOM_Data_DMTbl ~ cnrCodeCOM_Data_DMTbl ~ dlv_errorCOM_Data_DMTbl ~ dlv_statusCOM_Data_DMTbl ~ dlv_status_atCOM_Data_DMTbl ~ idCOM_Data_DMTbl ~ start_timeCOM_Data_DMTbl ~ subjectCOM_Data_DMTbl ~ textCOM_Data_DMTbl ~ timestampCOM_Data_DMTbl, 
                    values map
                        {
                        value =>
                            Insert(acnCOM_Data_DMTbl, value.acn) Insert(acnCodeCOM_Data_DMTbl, value.acnCode) Insert(addressCOM_Data_DMTbl, value.address) Insert(cnrCOM_Data_DMTbl, value.cnr) Insert(cnrCodeCOM_Data_DMTbl, value.cnrCode) Insert(dlv_errorCOM_Data_DMTbl, value.dlv_error) Insert(dlv_statusCOM_Data_DMTbl, value.dlv_status) Insert(dlv_status_atCOM_Data_DMTbl, value.dlv_status_at) Insert(idCOM_Data_DMTbl, value.id) Insert(start_timeCOM_Data_DMTbl, value.start_time) Insert(subjectCOM_Data_DMTbl, value.subject) Insert(textCOM_Data_DMTbl, value.text) Insert(timestampCOM_Data_DMTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): List[Int] = {
        COM_Data_DMTbl.insertWithoutCommit(connection = connection, columns = acnCOM_Data_DMTbl ~ acnCodeCOM_Data_DMTbl ~ addressCOM_Data_DMTbl ~ cnrCOM_Data_DMTbl ~ cnrCodeCOM_Data_DMTbl ~ dlv_errorCOM_Data_DMTbl ~ dlv_statusCOM_Data_DMTbl ~ dlv_status_atCOM_Data_DMTbl ~ idCOM_Data_DMTbl ~ start_timeCOM_Data_DMTbl ~ subjectCOM_Data_DMTbl ~ textCOM_Data_DMTbl ~ timestampCOM_Data_DMTbl, 
            values map
                {
                value =>
                    Insert(acnCOM_Data_DMTbl, value _1) Insert(acnCodeCOM_Data_DMTbl, value _2) Insert(addressCOM_Data_DMTbl, value _3) Insert(cnrCOM_Data_DMTbl, value _4) Insert(cnrCodeCOM_Data_DMTbl, value _5) Insert(dlv_errorCOM_Data_DMTbl, value _6) Insert(dlv_statusCOM_Data_DMTbl, value _7) Insert(dlv_status_atCOM_Data_DMTbl, value _8) Insert(idCOM_Data_DMTbl, value _9) Insert(start_timeCOM_Data_DMTbl, value _10) Insert(subjectCOM_Data_DMTbl, value _11) Insert(textCOM_Data_DMTbl, value _12) Insert(timestampCOM_Data_DMTbl, value _13)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: COM_Data_DM*): List[Int] = {
        COM_Data_DMTbl.insertWithoutCommit(connection = connection, columns = acnCOM_Data_DMTbl ~ acnCodeCOM_Data_DMTbl ~ addressCOM_Data_DMTbl ~ cnrCOM_Data_DMTbl ~ cnrCodeCOM_Data_DMTbl ~ dlv_errorCOM_Data_DMTbl ~ dlv_statusCOM_Data_DMTbl ~ dlv_status_atCOM_Data_DMTbl ~ idCOM_Data_DMTbl ~ start_timeCOM_Data_DMTbl ~ subjectCOM_Data_DMTbl ~ textCOM_Data_DMTbl ~ timestampCOM_Data_DMTbl, 
            values map
                {
                value =>
                    Insert(acnCOM_Data_DMTbl, value.acn) Insert(acnCodeCOM_Data_DMTbl, value.acnCode) Insert(addressCOM_Data_DMTbl, value.address) Insert(cnrCOM_Data_DMTbl, value.cnr) Insert(cnrCodeCOM_Data_DMTbl, value.cnrCode) Insert(dlv_errorCOM_Data_DMTbl, value.dlv_error) Insert(dlv_statusCOM_Data_DMTbl, value.dlv_status) Insert(dlv_status_atCOM_Data_DMTbl, value.dlv_status_at) Insert(idCOM_Data_DMTbl, value.id) Insert(start_timeCOM_Data_DMTbl, value.start_time) Insert(subjectCOM_Data_DMTbl, value.subject) Insert(textCOM_Data_DMTbl, value.text) Insert(timestampCOM_Data_DMTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(acn, value _1) Set(acnCode, value _2) Set(address, value _3) Set(cnr, value _4) Set(cnrCode, value _5) Set(dlv_error, value _6) Set(dlv_status, value _7) Set(dlv_status_at, value _8) Set(id, value _9) Set(start_time, value _10) Set(subject, value _11) Set(text, value _12) Set(timestamp, value _13), where = where, table = SQLTable(COM_Data_DMTbl.databaseTablename))
        }    
    
     def updateP(value: COM_Data_DM, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(acn, value.acn) Set(acnCode, value.acnCode) Set(address, value.address) Set(cnr, value.cnr) Set(cnrCode, value.cnrCode) Set(dlv_error, value.dlv_error) Set(dlv_status, value.dlv_status) Set(dlv_status_at, value.dlv_status_at) Set(id, value.id) Set(start_time, value.start_time) Set(subject, value.subject) Set(text, value.text) Set(timestamp, value.timestamp), where = where, table = SQLTable(COM_Data_DMTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(acn, value _1) Set(acnCode, value _2) Set(address, value _3) Set(cnr, value _4) Set(cnrCode, value _5) Set(dlv_error, value _6) Set(dlv_status, value _7) Set(dlv_status_at, value _8) Set(id, value _9) Set(start_time, value _10) Set(subject, value _11) Set(text, value _12) Set(timestamp, value _13), where = where, table = SQLTable(COM_Data_DMTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: COM_Data_DM, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(acn, value.acn) Set(acnCode, value.acnCode) Set(address, value.address) Set(cnr, value.cnr) Set(cnrCode, value.cnrCode) Set(dlv_error, value.dlv_error) Set(dlv_status, value.dlv_status) Set(dlv_status_at, value.dlv_status_at) Set(id, value.id) Set(start_time, value.start_time) Set(subject, value.subject) Set(text, value.text) Set(timestamp, value.timestamp), where = where, table = SQLTable(COM_Data_DMTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = COM_Data_DMTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = COM_Data_DMTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}