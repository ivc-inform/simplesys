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



 
object PersistenceJournal_DebugBo {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugBo(alias = alias)    
    
    val objectName = "PersistenceJournal_Debug"    
    val groupName = "scenarios"
}


 
class PersistenceJournal_DebugBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[PersistenceJournal_DebugBo]  {
////////////////////////////////////// Class: PersistenceJournal_Debug, group: scenarios //////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournal_DebugBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val PersistenceJournal_DebugTbl = new PersistenceJournal_DebugTbl(alias = alias + "T0".als)    
    override val fromTable = PersistenceJournal_DebugTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val created = LongColumn(name = "NCREATED", nameInBo = "created", caption = "created", tableColumn = PersistenceJournal_DebugTbl.created)    
    val deleted = BooleanOptionColumn(name = "BDELETED", nameInBo = "deleted", caption = "deleted", tableColumn = PersistenceJournal_DebugTbl.deletedOption)    
    val ordering = LongOptionColumn(name = "NORDERING", nameInBo = "ordering", caption = "ordering", tableColumn = PersistenceJournal_DebugTbl.orderingOption)    
    val persistence_id = StringColumn(name = "SPERSISTENCE_ID", nameInBo = "persistence_id", caption = "persistence_id", tableColumn = PersistenceJournal_DebugTbl.persistence_id)    
    val sequence_number = LongColumn(name = "NSEQUENCE_NUMBER", nameInBo = "sequence_number", caption = "sequence_number", tableColumn = PersistenceJournal_DebugTbl.sequence_number)    
    val tags = StringOptionColumn(name = "STAGS", nameInBo = "tags", caption = "tags", tableColumn = PersistenceJournal_DebugTbl.tagsOption)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "timestamp", tableColumn = PersistenceJournal_DebugTbl.timestamp)    
    
    // For select tuple: (created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]    
    val allColumns = created ~ deleted ~ ordering ~ persistence_id ~ sequence_number ~ tags ~ timestamp    
    val allColumns1 = Seq(created , deleted , ordering , persistence_id , sequence_number , tags , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_id),KeyConstraintData(sequence_number)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
/////////////////////////////////////////// Table: PersistenceJournal_Debug ///////////////////////////////////////////    
    val createdPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.created    
    val deletedPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.deletedOption    
    val orderingPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.orderingOption    
    val persistence_idPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.persistence_id    
    val sequence_numberPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.sequence_number    
    val tagsPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.tagsOption    
    val timestampPersistenceJournal_DebugTbl = PersistenceJournal_DebugTbl.timestamp    
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
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournal_Debug]] = 
        selectPIteratorRoot(columns = columns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime) => 
        PersistenceJournal_Debug(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournal_Debug]] = 
                selectListRoot(columns = allColumns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime) => 
                        PersistenceJournal_Debug(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournal_Debug] = 
                selectOneRoot(columns = allColumns, from = From(PersistenceJournal_DebugTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime)) => 
                ValidationEx(Success(PersistenceJournal_Debug(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournal_DebugTbl ~ deletedPersistenceJournal_DebugTbl ~ orderingPersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl ~ tagsPersistenceJournal_DebugTbl ~ timestampPersistenceJournal_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceJournal_DebugTbl, value _1) Insert(deletedPersistenceJournal_DebugTbl, value _2) Insert(orderingPersistenceJournal_DebugTbl, value _3) Insert(persistence_idPersistenceJournal_DebugTbl, value _4) Insert(sequence_numberPersistenceJournal_DebugTbl, value _5) Insert(tagsPersistenceJournal_DebugTbl, value _6) Insert(timestampPersistenceJournal_DebugTbl, value _7)
                    })
        }    
    
     def insertP(values: PersistenceJournal_Debug*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournal_DebugTbl ~ deletedPersistenceJournal_DebugTbl ~ orderingPersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl ~ tagsPersistenceJournal_DebugTbl ~ timestampPersistenceJournal_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceJournal_DebugTbl, value.created) Insert(deletedPersistenceJournal_DebugTbl, value.deleted) Insert(orderingPersistenceJournal_DebugTbl, value.ordering) Insert(persistence_idPersistenceJournal_DebugTbl, value.persistence_id) Insert(sequence_numberPersistenceJournal_DebugTbl, value.sequence_number) Insert(tagsPersistenceJournal_DebugTbl, value.tags) Insert(timestampPersistenceJournal_DebugTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): List[Int] = {
        PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournal_DebugTbl ~ deletedPersistenceJournal_DebugTbl ~ orderingPersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl ~ tagsPersistenceJournal_DebugTbl ~ timestampPersistenceJournal_DebugTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceJournal_DebugTbl, value _1) Insert(deletedPersistenceJournal_DebugTbl, value _2) Insert(orderingPersistenceJournal_DebugTbl, value _3) Insert(persistence_idPersistenceJournal_DebugTbl, value _4) Insert(sequence_numberPersistenceJournal_DebugTbl, value _5) Insert(tagsPersistenceJournal_DebugTbl, value _6) Insert(timestampPersistenceJournal_DebugTbl, value _7)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal_Debug*): List[Int] = {
        PersistenceJournal_DebugTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournal_DebugTbl ~ deletedPersistenceJournal_DebugTbl ~ orderingPersistenceJournal_DebugTbl ~ persistence_idPersistenceJournal_DebugTbl ~ sequence_numberPersistenceJournal_DebugTbl ~ tagsPersistenceJournal_DebugTbl ~ timestampPersistenceJournal_DebugTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceJournal_DebugTbl, value.created) Insert(deletedPersistenceJournal_DebugTbl, value.deleted) Insert(orderingPersistenceJournal_DebugTbl, value.ordering) Insert(persistence_idPersistenceJournal_DebugTbl, value.persistence_id) Insert(sequence_numberPersistenceJournal_DebugTbl, value.sequence_number) Insert(tagsPersistenceJournal_DebugTbl, value.tags) Insert(timestampPersistenceJournal_DebugTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(deleted, value _2) Set(ordering, value _3) Set(persistence_id, value _4) Set(sequence_number, value _5) Set(tags, value _6) Set(timestamp, value _7), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
        }    
    
     def updateP(value: PersistenceJournal_Debug, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(deleted, value.deleted) Set(ordering, value.ordering) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(tags, value.tags) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(deleted, value _2) Set(ordering, value _3) Set(persistence_id, value _4) Set(sequence_number, value _5) Set(tags, value _6) Set(timestamp, value _7), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: PersistenceJournal_Debug, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(deleted, value.deleted) Set(ordering, value.ordering) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(tags, value.tags) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceJournal_DebugTbl.databaseTablename))
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