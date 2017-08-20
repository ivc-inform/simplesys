// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenTables"

package ru.simplesys.defs.bo

package systemservice.table

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.jdbc.control.{ValidationEx, Table}
import com.simplesys.jdbc.control.table.Insert
import org.joda.time.{LocalDateTime, DateTime}
import java.sql.{Connection, PreparedStatement}
import com.simplesys.sql.SQLDialect
import com.simplesys.SQL.Gen.SQLAlias
import com.simplesys.common.Strings._
import systemservice.SeqGenerator
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object SeqGeneratorTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new SeqGeneratorTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new SeqGeneratorTbl(alias = alias)    
    
    val objectName = "SeqGenerator"    
    val groupName = "systemservice"
}
 
class SeqGeneratorTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[SeqGeneratorTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "SVC_SEQGENERATOR"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val maxValue = LongColumnTable(name = "NMAXVALUE")    
    val nameSeq = StringColumnTable(name = "SNAMESEQ")    
    
    // For select tuple: (maxValue: Long, nameSeq: String)    
    
    type ColumnTypes =     TupleSS2[Long, String]    
     def allColumns = maxValue ~ nameSeq    
    
     def insert(values: TupleSS2[Long, String]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(maxValue, value _1) Insert(nameSeq, value _2)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS2[Long, String]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(maxValue, value _1) Insert(nameSeq, value _2)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, String]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(maxValue, value _1) Insert(nameSeq, value _2)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: SeqGenerator*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(maxValue, value.maxValue) Insert(nameSeq, value.nameSeq) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: SeqGenerator*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(maxValue, value.maxValue) Insert(nameSeq, value.nameSeq) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: SeqGenerator*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(maxValue, value.maxValue) Insert(nameSeq, value.nameSeq) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}