// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenBOs, stage: #819"

package ru.simplesys.defs.bo

package admin

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
import ru.simplesys.defs.bo.admin.table._
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



 
object UserBo {
     def apply(implicit dataSource: BoneCPDataSource) = new UserBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserBo(alias = alias)    
    
    val objectName = "User"    
    val groupName = "admin"
}


 
class UserBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[UserBo]  {
//////////////////////////////////////////// Class: User, group: admin ////////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): UserBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val UserTbl = new UserTbl(alias = alias + "T0".als)    
    override val fromTable = UserTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val active = BooleanColumn(name = "BACTIVE", nameInBo = "active", caption = "\u0410\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u044C", tableColumn = UserTbl.active)    
    val caption = StringColumn(name = "SCAPTION", nameInBo = "caption", caption = "\u0418\u043C\u044F \u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u044F", tableColumn = UserTbl.caption)    
    val di = LongColumn(name = "IDDI", nameInBo = "di", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = UserTbl.di)    
    val firstName = StringOptionColumn(name = "SFIRSTNAME", nameInBo = "firstName", caption = "\u0418\u043C\u044F", tableColumn = UserTbl.firstNameOption)    
    val group = LongColumn(name = "IDGROUP", nameInBo = "group", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = UserTbl.group)    
    val lastName = StringColumn(name = "SLASTNAME", nameInBo = "lastName", caption = "\u0424\u0430\u043C\u0438\u043B\u0438\u044F", tableColumn = UserTbl.lastName)    
    val login = StringColumn(name = "SLOGIN", nameInBo = "login", caption = "\u041B\u043E\u0433\u0438\u043D", tableColumn = UserTbl.login)    
    val password = StringColumn(name = "SPASSWORD", nameInBo = "password", caption = "\u041F\u0430\u0440\u043E\u043B\u044C", tableColumn = UserTbl.password)    
    val secondName = StringOptionColumn(name = "SSECONDNAME", nameInBo = "secondName", caption = "\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E", tableColumn = UserTbl.secondNameOption)    
    
    // For select tuple: (active: Boolean, caption: String, di: Long, firstName: Array[String], group: Long, lastName: String, login: String, password: String, secondName: Array[String])    
    
    type ColumnTypes =     TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]    
    val allColumns = active ~ caption ~ di ~ firstName ~ group ~ lastName ~ login ~ password ~ secondName    
    val allColumns1 = Seq(active , caption , di , firstName , group , lastName , login , password , secondName)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(di)),
            UniqueKey(name = "ucLogin", constraintDate = KeyConstraintData(login)),
            ForignKey(name = "frGroup", constraintDate = ForignKeyConstraintData(group, ReferencedData("admin","UserGroup"), true)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////////// Table: User ////////////////////////////////////////////////    
    val activeUserTbl = UserTbl.active    
    val captionUserTbl = UserTbl.caption    
    val diUserTbl = UserTbl.di    
    val firstNameUserTbl = UserTbl.firstNameOption    
    val groupUserTbl = UserTbl.group    
    val lastNameUserTbl = UserTbl.lastName    
    val loginUserTbl = UserTbl.login    
    val passwordUserTbl = UserTbl.password    
    val secondNameUserTbl = UserTbl.secondNameOption    
/////////////////////////////////////////////// End Table: User ///////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(UserTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(UserTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(UserTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(UserTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[User]] = 
        selectPIteratorRoot(columns = columns, from = From(UserTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS9(active: Boolean, caption: String, di: Long, firstName: Array[String], group: Long, lastName: String, login: String, password: String, secondName: Array[String]) => 
        User(active = active, di = di, firstName = firstName, group = group, lastName = lastName, login = login, password = password, secondName = secondName)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[User]] = 
                selectListRoot(columns = allColumns, from = From(UserTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS9(active: Boolean, caption: String, di: Long, firstName: Array[String], group: Long, lastName: String, login: String, password: String, secondName: Array[String]) => 
                        User(active = active, di = di, firstName = firstName, group = group, lastName = lastName, login = login, password = password, secondName = secondName)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[User] = 
                selectOneRoot(columns = allColumns, from = From(UserTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS9(active: Boolean, caption: String, di: Long, firstName: Array[String], group: Long, lastName: String, login: String, password: String, secondName: Array[String])) => 
                ValidationEx(Success(User(active = active, di = di, firstName = firstName, group = group, lastName = lastName, login = login, password = password, secondName = secondName)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                UserTbl.insertWithoutCommit(connection = connection, columns = activeUserTbl ~ captionUserTbl ~ diUserTbl ~ firstNameUserTbl ~ groupUserTbl ~ lastNameUserTbl ~ loginUserTbl ~ passwordUserTbl ~ secondNameUserTbl, 
                    values map
                        {
                        value =>
                            Insert(activeUserTbl, value _1) Insert(captionUserTbl, value _2) Insert(diUserTbl, value _3) Insert(firstNameUserTbl, value _4) Insert(groupUserTbl, value _5) Insert(lastNameUserTbl, value _6) Insert(loginUserTbl, value _7) Insert(passwordUserTbl, value _8) Insert(secondNameUserTbl, value _9)
                    })
        }    
    
     def insertP(values: User*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                UserTbl.insertWithoutCommit(connection = connection, columns = activeUserTbl ~ captionUserTbl ~ diUserTbl ~ firstNameUserTbl ~ groupUserTbl ~ lastNameUserTbl ~ loginUserTbl ~ passwordUserTbl ~ secondNameUserTbl, 
                    values map
                        {
                        value =>
                            Insert(activeUserTbl, value.active) Insert(captionUserTbl, value.caption) Insert(diUserTbl, value.di) Insert(firstNameUserTbl, value.firstName) Insert(groupUserTbl, value.group) Insert(lastNameUserTbl, value.lastName) Insert(loginUserTbl, value.login) Insert(passwordUserTbl, value.password) Insert(secondNameUserTbl, value.secondName)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): List[Int] = {
        UserTbl.insertWithoutCommit(connection = connection, columns = activeUserTbl ~ captionUserTbl ~ diUserTbl ~ firstNameUserTbl ~ groupUserTbl ~ lastNameUserTbl ~ loginUserTbl ~ passwordUserTbl ~ secondNameUserTbl, 
            values map
                {
                value =>
                    Insert(activeUserTbl, value _1) Insert(captionUserTbl, value _2) Insert(diUserTbl, value _3) Insert(firstNameUserTbl, value _4) Insert(groupUserTbl, value _5) Insert(lastNameUserTbl, value _6) Insert(loginUserTbl, value _7) Insert(passwordUserTbl, value _8) Insert(secondNameUserTbl, value _9)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: User*): List[Int] = {
        UserTbl.insertWithoutCommit(connection = connection, columns = activeUserTbl ~ captionUserTbl ~ diUserTbl ~ firstNameUserTbl ~ groupUserTbl ~ lastNameUserTbl ~ loginUserTbl ~ passwordUserTbl ~ secondNameUserTbl, 
            values map
                {
                value =>
                    Insert(activeUserTbl, value.active) Insert(captionUserTbl, value.caption) Insert(diUserTbl, value.di) Insert(firstNameUserTbl, value.firstName) Insert(groupUserTbl, value.group) Insert(lastNameUserTbl, value.lastName) Insert(loginUserTbl, value.login) Insert(passwordUserTbl, value.password) Insert(secondNameUserTbl, value.secondName)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(caption, value _2) Set(di, value _3) Set(firstName, value _4) Set(group, value _5) Set(lastName, value _6) Set(login, value _7) Set(password, value _8) Set(secondName, value _9), where = where, table = SQLTable(UserTbl.databaseTablename))
        }    
    
     def updateP(value: User, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(caption, value.caption) Set(di, value.di) Set(firstName, value.firstName) Set(group, value.group) Set(lastName, value.lastName) Set(login, value.login) Set(password, value.password) Set(secondName, value.secondName), where = where, table = SQLTable(UserTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(caption, value _2) Set(di, value _3) Set(firstName, value _4) Set(group, value _5) Set(lastName, value _6) Set(login, value _7) Set(password, value _8) Set(secondName, value _9), where = where, table = SQLTable(UserTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: User, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(caption, value.caption) Set(di, value.di) Set(firstName, value.firstName) Set(group, value.group) Set(lastName, value.lastName) Set(login, value.login) Set(password, value.password) Set(secondName, value.secondName), where = where, table = SQLTable(UserTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = UserTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = UserTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}