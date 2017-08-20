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
import scenarios.PersistenceSnapshot
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object PersistenceSnapshotTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotTbl(alias = alias)    
    
    val objectName = "PersistenceSnapshot"    
    val groupName = "scenarios"
}
 
class PersistenceSnapshotTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[PersistenceSnapshotTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_PERSISTENCESNAPSHOT"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val createdOption = LongOptionColumnTable(name = "NCREATED")    
    val persistence_id = StringColumnTable(name = "SPERSISTENCE_ID")    
    val sequence_number = LongColumnTable(name = "NSEQUENCE_NUMBER")    
    val timestamp = LocalDateTimeColumnTable(name = "DTTIMESTAMP")    
    
    // For select tuple: (createdOption: Array[Long], persistence_id: String, sequence_number: Long, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS4[Array[Long], String, Long, LocalDateTime]    
     def allColumns = createdOption ~ persistence_id ~ sequence_number ~ timestamp    
    
     def insert(values: TupleSS4[Array[Long], String, Long, LocalDateTime]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(createdOption, value _1) Insert(persistence_id, value _2) Insert(sequence_number, value _3) Insert(timestamp, value _4)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS4[Array[Long], String, Long, LocalDateTime]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(createdOption, value _1) Insert(persistence_id, value _2) Insert(sequence_number, value _3) Insert(timestamp, value _4)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[Array[Long], String, Long, LocalDateTime]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(createdOption, value _1) Insert(persistence_id, value _2) Insert(sequence_number, value _3) Insert(timestamp, value _4)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: PersistenceSnapshot*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(createdOption, value.created) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(timestamp, value.timestamp) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: PersistenceSnapshot*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(createdOption, value.created) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(timestamp, value.timestamp) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceSnapshot*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(createdOption, value.created) Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(timestamp, value.timestamp) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}