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
import scenarios.PersistenceJournalMessage
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object PersistenceJournalTblMessage {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournalTblMessage(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournalTblMessage(alias = alias)    
    
    val objectName = "PersistenceJournal"    
    val groupName = "scenarios"
}
 
class PersistenceJournalTblMessage(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[PersistenceJournalTblMessage]  {
    
    val quoted = true    
    
     def databaseTablename = "RTM_PERSISTENCEJOURNAL"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val persistence_id = StringColumnTable(name = "SPERSISTENCE_ID")    
    val sequence_number = LongColumnTable(name = "NSEQUENCE_NUMBER")    
    val message = BlobColumnTable(name = "BLBMESSAGE")    
    
    // For select tuple: (persistence_id: String, sequence_number: Long, message: Blob)    
    
    type ColumnTypes =     TupleSS3[String, Long, Blob]    
     def allColumns = persistence_id ~ sequence_number ~ message    
    
     def insert(values: TupleSS3[String, Long, Blob]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(message, value _3)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS3[String, Long, Blob]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(message, value _3)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value _1) Insert(sequence_number, value _2) Insert(message, value _3)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: PersistenceJournalMessage*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(message, value.message) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: PersistenceJournalMessage*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(message, value.message) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournalMessage*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(persistence_id, value.persistence_id) Insert(sequence_number, value.sequence_number) Insert(message, value.message) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}