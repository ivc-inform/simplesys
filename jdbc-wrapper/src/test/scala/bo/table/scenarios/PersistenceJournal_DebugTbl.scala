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
import scenarios.PersistenceJournal_Debug
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object PersistenceJournal_DebugTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugTbl(alias = alias)    
    
    val objectName = "PersistenceJournal_Debug"    
    val groupName = "scenarios"
}
 
class PersistenceJournal_DebugTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[PersistenceJournal_DebugTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_PERSISTENCEJOURNAL_DEBUG"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val created = LongColumnTable(name = "NCREATED")    
    val deletedOption = BooleanOptionColumnTable(name = "BDELETED")    
    val orderingOption = LongOptionColumnTable(name = "NORDERING")    
    val persistence_id = StringColumnTable(name = "SPERSISTENCE_ID")    
    val sequence_number = LongColumnTable(name = "NSEQUENCE_NUMBER")    
    val tagsOption = StringOptionColumnTable(name = "STAGS")    
    val timestamp = LocalDateTimeColumnTable(name = "DTTIMESTAMP")    
    
    // For select tuple: (created: Long, deletedOption: Array[Boolean], orderingOption: Array[Long], persistence_id: String, sequence_number: Long, tagsOption: Array[String], timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]    
     def allColumns = created ~ deletedOption ~ orderingOption ~ persistence_id ~ sequence_number ~ tagsOption ~ timestamp    
    
     def insert(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(created, value _1) Insert(deletedOption, value _2) Insert(orderingOption, value _3) Insert(persistence_id, value _4) Insert(sequence_number, value _5) Insert(tagsOption, value _6) Insert(timestamp, value _7)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(created, value _1) Insert(deletedOption, value _2) Insert(orderingOption, value _3) Insert(persistence_id, value _4) Insert(sequence_number, value _5) Insert(tagsOption, value _6) Insert(timestamp, value _7)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(created, value _1) Insert(deletedOption, value _2) Insert(orderingOption, value _3) Insert(persistence_id, value _4) Insert(sequence_number, value _5) Insert(tagsOption, value _6) Insert(timestamp, value _7)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: PersistenceJournal_Debug*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(created, value.created) Insert(deletedOption, value.deleted) Insert(orderingOption, value.ordering) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(tagsOption, value.tags) Insert(timestamp, value.timestamp) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: PersistenceJournal_Debug*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(created, value.created) Insert(deletedOption, value.deleted) Insert(orderingOption, value.ordering) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(tagsOption, value.tags) Insert(timestamp, value.timestamp) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal_Debug*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(created, value.created) Insert(deletedOption, value.deleted) Insert(orderingOption, value.ordering) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(tagsOption, value.tags) Insert(timestamp, value.timestamp) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}