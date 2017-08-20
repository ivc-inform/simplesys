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
import scenarios.PersistenceSnapshot_DebugSnapshot
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object PersistenceSnapshot_DebugTblSnapshot {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshot_DebugTblSnapshot(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshot_DebugTblSnapshot(alias = alias)    
    
    val objectName = "PersistenceSnapshot_Debug"    
    val groupName = "scenarios"
}
 
class PersistenceSnapshot_DebugTblSnapshot(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[PersistenceSnapshot_DebugTblSnapshot]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_PERSISTENCESNAPSHOT_DEBUG"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val persistence_id = StringColumnTable(name = "SPERSISTENCE_ID")    
    val sequence_number = LongColumnTable(name = "NSEQUENCE_NUMBER")    
    val snapshot = BlobColumnTable(name = "BLBSNAPSHOT")    
    
    // For select tuple: (persistence_id: String, sequence_number: Long, snapshot: Blob)    
    
    type ColumnTypes =     TupleSS3[String, Long, Blob]    
     def allColumns = persistence_id ~ sequence_number ~ snapshot    
    
     def insert(values: TupleSS3[String, Long, Blob]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(snapshot, value _3)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS3[String, Long, Blob]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(snapshot, value _3)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(snapshot, value _3)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: PersistenceSnapshot_DebugSnapshot*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(snapshot, value.snapshot) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: PersistenceSnapshot_DebugSnapshot*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(snapshot, value.snapshot) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceSnapshot_DebugSnapshot*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(snapshot, value.snapshot) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}