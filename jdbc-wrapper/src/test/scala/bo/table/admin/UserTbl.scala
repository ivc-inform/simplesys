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
import admin.User
import com.simplesys.jdbc.control.clob._
import com.simplesys.common.array._
import com.simplesys.tuple._

 
object UserTbl {
     def apply(implicit dataSource: BoneCPDataSource) = new UserTbl(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserTbl(alias = alias)    
    
    val objectName = "User"    
    val groupName = "admin"
}
 
class UserTbl(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends Table[UserTbl]  {
    
    val quoted = true    
    
     def databaseTablename = "A_USER"    
    
    val sqlDialect = dataSource.SQLDialect    
    
    val active = BooleanColumnTable(name = "BACTIVE")    
    val caption = StringColumnTable(name = "SCAPTION")    
    val di = LongColumnTable(name = "IDDI")    
    val firstNameOption = StringOptionColumnTable(name = "SFIRSTNAME")    
    val group = LongColumnTable(name = "IDGROUP")    
    val lastName = StringColumnTable(name = "SLASTNAME")    
    val login = StringColumnTable(name = "SLOGIN")    
    val password = StringColumnTable(name = "SPASSWORD")    
    val secondNameOption = StringOptionColumnTable(name = "SSECONDNAME")    
    
    // For select tuple: (active: Boolean, caption: String, di: Long, firstNameOption: Array[String], group: Long, lastName: String, login: String, password: String, secondNameOption: Array[String])    
    
    type ColumnTypes =     TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]    
     def allColumns = active ~ caption ~ di ~ firstNameOption ~ group ~ lastName ~ login ~ password ~ secondNameOption    
    
     def insert(values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(caption, value _2) Insert(di, value _3) Insert(firstNameOption, value _4) Insert(group, value _5) Insert(lastName, value _6) Insert(login, value _7) Insert(password, value _8) Insert(secondNameOption, value _9)
    })    
    
     def batch4Insert(preparedStatement: PreparedStatement, values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(caption, value _2) Insert(di, value _3) Insert(firstNameOption, value _4) Insert(group, value _5) Insert(lastName, value _6) Insert(login, value _7) Insert(password, value _8) Insert(secondNameOption, value _9)
    })    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value _1) Insert(caption, value _2) Insert(di, value _3) Insert(firstNameOption, value _4) Insert(group, value _5) Insert(lastName, value _6) Insert(login, value _7) Insert(password, value _8) Insert(secondNameOption, value _9)
    })    
    
//////////////////////////////////////////////// P Methods ////////////////////////////////////////////////    
    
     def insertP(values: User*): ValidationEx[List[Int]] = insertRoot(allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(caption, value.caption) Insert(di, value.di) Insert(firstNameOption, value.firstName) Insert(group, value.group) Insert(lastName, value.lastName) Insert(login, value.login) Insert(password, value.password) Insert(secondNameOption, value.secondName) 
    })    
    
     def batch4PInsert(preparedStatement: PreparedStatement, values: User*): Unit = batch4Insert(preparedStatement, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(caption, value.caption) Insert(di, value.di) Insert(firstNameOption, value.firstName) Insert(group, value.group) Insert(lastName, value.lastName) Insert(login, value.login) Insert(password, value.password) Insert(secondNameOption, value.secondName) 
    })    
    
     def insertPWithoutCommit(connection: Connection, values: User*): List[Int] = insertWithoutCommit(connection, allColumns, 
    values map
        {
        value =>
            Insert(active, value.active) Insert(caption, value.caption) Insert(di, value.di) Insert(firstNameOption, value.firstName) Insert(group, value.group) Insert(lastName, value.lastName) Insert(login, value.login) Insert(password, value.password) Insert(secondNameOption, value.secondName) 
    })    
    
/////////////////////////////////////////////// End P Methods ///////////////////////////////////////////////
}