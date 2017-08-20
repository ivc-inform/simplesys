// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenBOs, stage: #819"

package ru.simplesys.defs.bo

package scenarios

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
import ru.simplesys.defs.bo.scenarios.table._
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



 
object PersistenceJournal_DebugBoMessage {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugBoMessage(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugBoMessage(alias = alias)    
    
    val objectName = "PersistenceJournal_Debug"    
    val groupName = "scenarios"
}


 
class PersistenceJournal_DebugBoMessage(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[PersistenceJournal_DebugBoMessage]  {
////////////////////////////////////// Class: PersistenceJournal_Debug, group: scenarios //////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournal_DebugBoMessage = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val PersistenceJournal_DebugTbl = new PersistenceJournal_DebugTblMessage(alias = alias + "T0".als)    
    override val fromTable = PersistenceJournal_DebugTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val message = BlobColumn(name = "BLBMESSAGE", nameInBo = "message", caption = "message", tableColumn = PersistenceJournal_DebugTbl.message)    
    val persistence_id = StringColumn(name = "SPERSISTENCE_ID", nameInBo = "persistence_id", caption = "persistence_id", tableColumn = PersistenceJournal_DebugTbl.persistence_id)    
    val sequence_number = LongColumn(name = "NSEQUENCE_NUMBER", nameInBo = "sequence_number", caption = "sequence_number", tableColumn = PersistenceJournal_DebugTbl.sequence_number)    
    
    // For select tuple: (message: Blob, persistence_id: String, sequence_number: Long)    
    
    type ColumnTypes =     TupleSS3[Blob, String, Long]    
    val allColumns = message ~ persistence_id ~ sequence_number    
    val allColumns1 = Seq(message , persistence_id , sequence_number)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_id),KeyConstraintData(sequence_number)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
/////////////////////////////////////////// Table: PersistenceJournal_Debug ///////////////////////////////////////////    
    val messagePersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.message    
    val persistence_idPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.persistence_id    
    val sequence_numberPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.sequence_number    
////////////////////////////////////////// End Table: PersistenceJournal_Debug //////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(PersistenceJournal_DebugTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournal_DebugMessage]] = 
        selectPIteratorRoot(columns = columns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(message: Blob, persistence_id: String, sequence_number: Long) => 
        PersistenceJournal_DebugMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournal_DebugMessage]] = 
                selectListRoot(columns = allColumns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(message: Blob, persistence_id: String, sequence_number: Long) => 
                        PersistenceJournal_DebugMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournal_DebugMessage] = 
                selectOneRoot(columns = allColumns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(message: Blob, persistence_id: String, sequence_number: Long)) => 
                ValidationEx(Success(PersistenceJournal_DebugMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS3[Blob, String, Long]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(messagePersistenceJournal_DebugTbl, value _1) Insert(persistence_idPersistenceJournal_DebugTbl, value _2) Insert(sequence_numberPersistenceJournal_DebugTbl, value _3)
                    })
        }    
    
     def insertP(values: PersistenceJournal_DebugMessage*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(messagePersistenceJournal_DebugTbl, value.message) Insert(persistence_idPersistenceJournal_DebugTbl, value.persistence_id) Insert(sequence_numberPersistenceJournal_DebugTbl, value.sequence_number)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long]*): List[Int] = {
        PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl, 
            values map
                {
                value =>
                    Insert(messagePersistenceJournal_DebugTbl, value _1) Insert(persistence_idPersistenceJournal_DebugTbl, value _2) Insert(sequence_numberPersistenceJournal_DebugTbl, value _3)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal_DebugMessage*): List[Int] = {
        PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl, 
            values map
                {
                value =>
                    Insert(messagePersistenceJournal_DebugTbl, value.message) Insert(persistence_idPersistenceJournal_DebugTbl, value.persistence_id) Insert(sequence_numberPersistenceJournal_DebugTbl, value.sequence_number)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS3[Blob, String, Long], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(message, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
        }    
    
     def updateP(value: PersistenceJournal_DebugMessage, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(message, value.message) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS3[Blob, String, Long], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(message, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: PersistenceJournal_DebugMessage, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(message, value.message) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceJournal_DebugTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceJournal_DebugTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}