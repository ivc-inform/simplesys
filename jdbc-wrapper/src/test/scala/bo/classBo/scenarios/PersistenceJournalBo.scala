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



 
object PersistenceJournalBo {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournalBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournalBo(alias = alias)    
    
    val objectName = "PersistenceJournal"    
    val groupName = "scenarios"
}


 
class PersistenceJournalBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[PersistenceJournalBo]  {
//////////////////////////////////////// Class: PersistenceJournal, group: scenarios ////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournalBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val PersistenceJournalTbl = new PersistenceJournalTbl(alias = alias + "T0".als)    
    override val fromTable = PersistenceJournalTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val created = LongColumn(name = "NCREATED", nameInBo = "created", caption = "created", tableColumn = PersistenceJournalTbl.created)    
    val deleted = BooleanOptionColumn(name = "BDELETED", nameInBo = "deleted", caption = "deleted", tableColumn = PersistenceJournalTbl.deletedOption)    
    val ordering = LongOptionColumn(name = "NORDERING", nameInBo = "ordering", caption = "ordering", tableColumn = PersistenceJournalTbl.orderingOption)    
    val persistence_id = StringColumn(name = "SPERSISTENCE_ID", nameInBo = "persistence_id", caption = "persistence_id", tableColumn = PersistenceJournalTbl.persistence_id)    
    val sequence_number = LongColumn(name = "NSEQUENCE_NUMBER", nameInBo = "sequence_number", caption = "sequence_number", tableColumn = PersistenceJournalTbl.sequence_number)    
    val tags = StringOptionColumn(name = "STAGS", nameInBo = "tags", caption = "tags", tableColumn = PersistenceJournalTbl.tagsOption)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "timestamp", tableColumn = PersistenceJournalTbl.timestamp)    
    
    // For select tuple: (created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]    
    val allColumns = created ~ deleted ~ ordering ~ persistence_id ~ sequence_number ~ tags ~ timestamp    
    val allColumns1 = Seq(created , deleted , ordering , persistence_id , sequence_number , tags , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_id),KeyConstraintData(sequence_number)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////// Table: PersistenceJournal ////////////////////////////////////////////    
    val createdPersistenceJournalTbl = PersistenceJournalTbl.created    
    val deletedPersistenceJournalTbl = PersistenceJournalTbl.deletedOption    
    val orderingPersistenceJournalTbl = PersistenceJournalTbl.orderingOption    
    val persistence_idPersistenceJournalTbl = PersistenceJournalTbl.persistence_id    
    val sequence_numberPersistenceJournalTbl = PersistenceJournalTbl.sequence_number    
    val tagsPersistenceJournalTbl = PersistenceJournalTbl.tagsOption    
    val timestampPersistenceJournalTbl = PersistenceJournalTbl.timestamp    
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
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournal]] = 
        selectPIteratorRoot(columns = columns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime) => 
        PersistenceJournal(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournal]] = 
                selectListRoot(columns = allColumns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime) => 
                        PersistenceJournal(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournal] = 
                selectOneRoot(columns = allColumns, from = From(PersistenceJournalTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(created: Long, deleted: Array[Boolean], ordering: Array[Long], persistence_id: String, sequence_number: Long, tags: Array[String], timestamp: LocalDateTime)) => 
                ValidationEx(Success(PersistenceJournal(created = created, deleted = deleted, ordering = ordering, persistence_id = persistence_id, sequence_number = sequence_number, tags = tags, timestamp = timestamp)))
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
                PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournalTbl ~ deletedPersistenceJournalTbl ~ orderingPersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl ~ tagsPersistenceJournalTbl ~ timestampPersistenceJournalTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceJournalTbl, value _1) Insert(deletedPersistenceJournalTbl, value _2) Insert(orderingPersistenceJournalTbl, value _3) Insert(persistence_idPersistenceJournalTbl, value _4) Insert(sequence_numberPersistenceJournalTbl, value _5) Insert(tagsPersistenceJournalTbl, value _6) Insert(timestampPersistenceJournalTbl, value _7)
                    })
        }    
    
     def insertP(values: PersistenceJournal*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournalTbl ~ deletedPersistenceJournalTbl ~ orderingPersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl ~ tagsPersistenceJournalTbl ~ timestampPersistenceJournalTbl, 
                    values map
                        {
                        value =>
                            Insert(createdPersistenceJournalTbl, value.created) Insert(deletedPersistenceJournalTbl, value.deleted) Insert(orderingPersistenceJournalTbl, value.ordering) Insert(persistence_idPersistenceJournalTbl, value.persistence_id) Insert(sequence_numberPersistenceJournalTbl, value.sequence_number) Insert(tagsPersistenceJournalTbl, value.tags) Insert(timestampPersistenceJournalTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): List[Int] = {
        PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournalTbl ~ deletedPersistenceJournalTbl ~ orderingPersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl ~ tagsPersistenceJournalTbl ~ timestampPersistenceJournalTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceJournalTbl, value _1) Insert(deletedPersistenceJournalTbl, value _2) Insert(orderingPersistenceJournalTbl, value _3) Insert(persistence_idPersistenceJournalTbl, value _4) Insert(sequence_numberPersistenceJournalTbl, value _5) Insert(tagsPersistenceJournalTbl, value _6) Insert(timestampPersistenceJournalTbl, value _7)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal*): List[Int] = {
        PersistenceJournalTbl.insertWithoutCommit(connection = connection, columns = createdPersistenceJournalTbl ~ deletedPersistenceJournalTbl ~ orderingPersistenceJournalTbl ~ persistence_idPersistenceJournalTbl ~ sequence_numberPersistenceJournalTbl ~ tagsPersistenceJournalTbl ~ timestampPersistenceJournalTbl, 
            values map
                {
                value =>
                    Insert(createdPersistenceJournalTbl, value.created) Insert(deletedPersistenceJournalTbl, value.deleted) Insert(orderingPersistenceJournalTbl, value.ordering) Insert(persistence_idPersistenceJournalTbl, value.persistence_id) Insert(sequence_numberPersistenceJournalTbl, value.sequence_number) Insert(tagsPersistenceJournalTbl, value.tags) Insert(timestampPersistenceJournalTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(deleted, value _2) Set(ordering, value _3) Set(persistence_id, value _4) Set(sequence_number, value _5) Set(tags, value _6) Set(timestamp, value _7), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
        }    
    
     def updateP(value: PersistenceJournal, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(deleted, value.deleted) Set(ordering, value.ordering) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(tags, value.tags) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value _1) Set(deleted, value _2) Set(ordering, value _3) Set(persistence_id, value _4) Set(sequence_number, value _5) Set(tags, value _6) Set(timestamp, value _7), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: PersistenceJournal, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(created, value.created) Set(deleted, value.deleted) Set(ordering, value.ordering) Set(persistence_id, value.persistence_id) Set(sequence_number, value.sequence_number) Set(tags, value.tags) Set(timestamp, value.timestamp), where = where, table = SQLTable(PersistenceJournalTbl.databaseTablename))
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