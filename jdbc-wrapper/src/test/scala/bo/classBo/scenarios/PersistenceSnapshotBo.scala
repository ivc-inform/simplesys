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



 
object PersistenceSnapshotBo {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotBo(alias = alias)    
    
    val objectName = "PersistenceSnapshot"    
    val groupName = "scenarios"
}


 
class PersistenceSnapshotBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[PersistenceSnapshotBo]  {
/////////////////////////////////////// Class: PersistenceSnapshot, group: scenarios ///////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceSnapshotBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val PersistenceSnapshotTbl = new PersistenceSnapshotTbl(alias = alias + "T0".als)    
    override val fromTable = PersistenceSnapshotTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val created = LongOptionColumn(name = "NCREATED", nameInBo = "created", caption = "created", tableColumn = PersistenceSnapshotTbl.createdOption)    
    val persistence_id = StringColumn(name = "SPERSISTENCE_ID", nameInBo = "persistence_id", caption = "persistence_id", tableColumn = PersistenceSnapshotTbl.persistence_id)    
    val sequence_number = LongColumn(name = "NSEQUENCE_NUMBER", nameInBo = "sequence_number", caption = "sequence_number", tableColumn = PersistenceSnapshotTbl.sequence_number)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "timestamp", tableColumn = PersistenceSnapshotTbl.timestamp)    
    
    // For select tuple: (created: Array[Long], persistence_id: String, sequence_number: Long, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS4[Array[Long], String, Long, LocalDateTime]    
    val allColumns = created ~ persistence_id ~ sequence_number ~ timestamp    
    val allColumns1 = Seq(created , persistence_id , sequence_number , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_id),KeyConstraintData(sequence_number)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////// Table: PersistenceSnapshot ////////////////////////////////////////////    
    val createdPersistenceSnapshotTbl = PersistenceSnapshotTbl.createdOption    
    val persistence_idPersistenceSnapshotTbl = PersistenceSnapshotTbl.persistence_id    
    val sequence_numberPersistenceSnapshotTbl = PersistenceSnapshotTbl.sequence_number    
    val timestampPersistenceSnapshotTbl = PersistenceSnapshotTbl.timestamp    
/////////////////////////////////////////// End Table: PersistenceSnapshot ///////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(PersistenceSnapshotTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceSnapshot]] = 
        selectPIteratorRoot(columns = columns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS4(created: Array[Long], persistence_id: String, sequence_number: Long, timestamp: LocalDateTime) => 
        PersistenceSnapshot(created = created, persistence_id = persistence_id, sequence_number = sequence_number, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceSnapshot]] = 
                selectListRoot(columns = allColumns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS4(created: Array[Long], persistence_id: String, sequence_number: Long, timestamp: LocalDateTime) => 
                        PersistenceSnapshot(created = created, persistence_id = persistence_id, sequence_number = sequence_number, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceSnapshot] = 
                selectOneRoot(columns = allColumns, from = From(PersistenceSnapshotTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS4(created: Array[Long], persistence_id: String, sequence_number: Long, timestamp: LocalDateTime)) => 
                ValidationEx(Success(PersistenceSnapshot(created = created, persistence_id = persistence_id, sequence_number = sequence_number, timestamp = timestamp)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS4[Array[Long], String, Long, LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceSnapshotTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceSnapshotTbl ~ persistence_idPersistenceSnapshotTbl ~ sequence_numberPersistenceSnapshotTbl ~ timestampPersistenceSnapshotTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceSnapshotTbl, value _1) Insert(persistence_idPersistenceSnapshotTbl, value _2) Insert(sequence_numberPersistenceSnapshotTbl, value _3) Insert(timestampPersistenceSnapshotTbl, value _4)
                    })
        }    
    
     def insertP(values: PersistenceSnapshot*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceSnapshotTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceSnapshotTbl ~ persistence_idPersistenceSnapshotTbl ~ sequence_numberPersistenceSnapshotTbl ~ timestampPersistenceSnapshotTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceSnapshotTbl, value.created) Insert(persistence_idPersistenceSnapshotTbl, value.persistence_id) Insert(sequence_numberPersistenceSnapshotTbl, value.sequence_number) Insert(timestampPersistenceSnapshotTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[Array[Long], String, Long, LocalDateTime]*): List[Int] = {
        PersistenceSnapshotTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceSnapshotTbl ~ persistence_idPersistenceSnapshotTbl ~ sequence_numberPersistenceSnapshotTbl ~ timestampPersistenceSnapshotTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceSnapshotTbl, value _1) Insert(persistence_idPersistenceSnapshotTbl, value _2) Insert(sequence_numberPersistenceSnapshotTbl, value _3) Insert(timestampPersistenceSnapshotTbl, value _4)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceSnapshot*): List[Int] = {
        PersistenceSnapshotTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceSnapshotTbl ~ persistence_idPersistenceSnapshotTbl ~ sequence_numberPersistenceSnapshotTbl ~ timestampPersistenceSnapshotTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceSnapshotTbl, value.created) Insert(persistence_idPersistenceSnapshotTbl, value.persistence_id) Insert(sequence_numberPersistenceSnapshotTbl, value.sequence_number) Insert(timestampPersistenceSnapshotTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS4[Array[Long], String, Long, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3) Set(timestamp, value _4), where = where, table = SQLTable(PersistenceSnapshotTbl.databaseTablename))
        }    
    
     def updateP(value: PersistenceSnapshot, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceSnapshotTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS4[Array[Long], String, Long, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(persistence_id, value _2) Set(sequence_number, value _3) Set(timestamp, value _4), where = where, table = SQLTable(PersistenceSnapshotTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: PersistenceSnapshot, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceSnapshotTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceSnapshotTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = PersistenceSnapshotTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}