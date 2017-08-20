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



 
object PersistenceJournalBoMessage {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournalBoMessage(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournalBoMessage(alias = alias)    
    
    val objectName = "PersistenceJournal"    
    val groupName = "scenarios"
}


 
class PersistenceJournalBoMessage(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[PersistenceJournalBoMessage]  {
//////////////////////////////////////// Class: PersistenceJournal, group: scenarios ////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournalBoMessage = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val PersistenceJournalTbl = new PersistenceJournalTblMessage(alias = alias + "T0".als)    
    override val fromTable = PersistenceJournalTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val message = BlobColumn(name = "BLBMESSAGE", nameInBo = "message", caption = "message", tableColumn = PersistenceJournalTbl.message)    
    val persistence_id = StringColumn(name = "SPERSISTENCE_ID", nameInBo = "persistence_id", caption = "persistence_id", tableColumn = PersistenceJournalTbl.persistence_id)    
    val sequence_number = LongColumn(name = "NSEQUENCE_NUMBER", nameInBo = "sequence_number", caption = "sequence_number", tableColumn = PersistenceJournalTbl.sequence_number)    
    
    // For select tuple: (message: Blob, persistence_id: String, sequence_number: Long)    
    
    type ColumnTypes =     TupleSS3[Blob, String, Long]    
    val allColumns = message ~ persistence_id ~ sequence_number    
    val allColumns1 = Seq(message , persistence_id , sequence_number)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_id),KeyConstraintData(sequence_number)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////// Table: PersistenceJournal ////////////////////////////////////////////    
    val messagePersistenceJournalTbl = PersistenceJournalTbl.message    
    val persistence_idPersistenceJournalTbl = PersistenceJournalTbl.persistence_id    
    val sequence_numberPersistenceJournalTbl = PersistenceJournalTbl.sequence_number    
/////////////////////////////////////////// End Table: PersistenceJournal ///////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(PersistenceJournalTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournalMessage]] = 
        selectPIteratorRoot(columns = columns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(message: Blob, persistence_id: String, sequence_number: Long) => 
        PersistenceJournalMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournalMessage]] = 
                selectListRoot(columns = allColumns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(message: Blob, persistence_id: String, sequence_number: Long) => 
                        PersistenceJournalMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournalMessage] = 
                selectOneRoot(columns = allColumns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(message: Blob, persistence_id: String, sequence_number: Long)) => 
                ValidationEx(Success(PersistenceJournalMessage(message = message, persistence_id = persistence_id, sequence_number = sequence_number)))
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
                PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl, 
                    values map
                        {
                        value =>
                            Insert(messagePersistenceJournalTbl, value _1) Insert(persistence_idPersistenceJournalTbl, value _2) Insert(sequence_numberPersistenceJournalTbl, value _3)
                    })
        }    
    
     def insertP(values: PersistenceJournalMessage*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl, 
                    values map
                        {
                        value =>
                            Insert(messagePersistenceJournalTbl, value.message) Insert(persistence_idPersistenceJournalTbl, value.persistence_id) Insert(sequence_numberPersistenceJournalTbl, value.sequence_number)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long]*): List[Int] = {
        PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl, 
            values map
                {
                value =>
                    Insert(messagePersistenceJournalTbl, value _1) Insert(persistence_idPersistenceJournalTbl, value _2) Insert(sequence_numberPersistenceJournalTbl, value _3)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournalMessage*): List[Int] = {
        PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = messagePersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl, 
            values map
                {
                value =>
                    Insert(messagePersistenceJournalTbl, value.message) Insert(persistence_idPersistenceJournalTbl, value.persistence_id) Insert(sequence_numberPersistenceJournalTbl, value.sequence_number)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS3[Blob, String, Long], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(message, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
        }    
    
     def updateP(value: PersistenceJournalMessage, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(message, value.message) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS3[Blob, String, Long], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(message, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: PersistenceJournalMessage, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(message, value.message) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceJournalTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceJournalTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}