// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenTables"

package ru.simplesys.defs.bo

package admin.table

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.jdbc.control.{ValidationEx, Table}
import com.simplesys.jdbc.control.table.Insert
import org.joda.time.{LocalDateTime, DateTime}
import java.sql.{Connection, PreparedStatement}
import com.simplesys.sql.SQLDialect
import com.simplesys.SQL.Gen.SQLAlias
import com.simplesys.common.Strings._
import admin.UserGroup
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object UserGroupTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new UserGroupTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserGroupTbl(alias = alias)    
    
    val objectName = "UserGroup"    
    val groupName = "admin"
}
 
class UserGroupTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[UserGroupTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "A_USERGROUP"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val active = BooleanColumnTable(name = "BACTIVE")    
    val captionGroupOption = StringOptionColumnTable(name = "SCAPTIONGROUP")    
    val codeGroup = StringColumnTable(name = "SCODEGROUP")    
    val descriptionGroupOption = StringOptionColumnTable(name = "SDESCRIPTIONGROUP")    
    val di = LongColumnTable(name = "IDDI")    
    val parentOption = LongOptionColumnTable(name = "IDPARENT")    
    
    // For select tuple: (active: Boolean, captionGroupOption: Array[String], codeGroup: String, descriptionGroupOption: Array[String], di: Long, parentOption: Array[Long])    
    
    type ColumnTypes =     TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]    
     def allColumns = active ~ captionGroupOption ~ codeGroup ~ descriptionGroupOption ~ di ~ parentOption    
    
     def insert(values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(di, value _5) Insert(parentOption, value _6)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(di, value _5) Insert(parentOption, value _6)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(captionGroupOption, value _2) Insert(codeGroup, value _3) Insert(descriptionGroupOption, value _4) Insert(di, value _5) Insert(parentOption, value _6)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: UserGroup*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(di, value.di) Insert(parentOption, value.parent) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: UserGroup*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(di, value.di) Insert(parentOption, value.parent) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: UserGroup*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(captionGroupOption, value.captionGroup) Insert(codeGroup, value.codeGroup) Insert(descriptionGroupOption, value.descriptionGroup) Insert(di, value.di) Insert(parentOption, value.parent) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}