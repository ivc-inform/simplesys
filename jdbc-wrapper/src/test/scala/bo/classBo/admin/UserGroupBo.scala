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



 
object UserGroupBo {
     def apply(implicit dataSource: BoneCPDataSource) = new UserGroupBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserGroupBo(alias = alias)    
    
    val objectName = "UserGroup"    
    val groupName = "admin"
}


 
class UserGroupBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[UserGroupBo]  {
/////////////////////////////////////////// Class: UserGroup, group: admin ///////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): UserGroupBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val UserGroupTbl = new UserGroupTbl(alias = alias + "T0".als)    
    override val fromTable = UserGroupTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val active = BooleanColumn(name = "BACTIVE", nameInBo = "active", caption = "\u0410\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u044C", tableColumn = UserGroupTbl.active)    
    val captionGroup = StringOptionColumn(name = "SCAPTIONGROUP", nameInBo = "captionGroup", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = UserGroupTbl.captionGroupOption)    
    val codeGroup = StringColumn(name = "SCODEGROUP", nameInBo = "codeGroup", caption = "\u041A\u043E\u0434 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = UserGroupTbl.codeGroup)    
    val descriptionGroup = StringOptionColumn(name = "SDESCRIPTIONGROUP", nameInBo = "descriptionGroup", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = UserGroupTbl.descriptionGroupOption)    
    val di = LongColumn(name = "IDDI", nameInBo = "di", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = UserGroupTbl.di)    
    val parent = LongOptionColumn(name = "IDPARENT", nameInBo = "parent", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = UserGroupTbl.parentOption)    
    
    // For select tuple: (active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], di: Long, parent: Array[Long])    
    
    type ColumnTypes =     TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]    
    val allColumns = active ~ captionGroup ~ codeGroup ~ descriptionGroup ~ di ~ parent    
    val allColumns1 = Seq(active , captionGroup , codeGroup , descriptionGroup , di , parent)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(di)),
            UniqueKey(name = "ucCodeGroup", constraintDate = KeyConstraintData(codeGroup)),
            ForignKey(name = "frParent", constraintDate = ForignKeyConstraintData(parent, ReferencedData("admin","UserGroup"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: UserGroup //////////////////////////////////////////////    
    val activeUserGroupTbl = UserGroupTbl.active    
    val captionGroupUserGroupTbl = UserGroupTbl.captionGroupOption    
    val codeGroupUserGroupTbl = UserGroupTbl.codeGroup    
    val descriptionGroupUserGroupTbl = UserGroupTbl.descriptionGroupOption    
    val diUserGroupTbl = UserGroupTbl.di    
    val parentUserGroupTbl = UserGroupTbl.parentOption    
///////////////////////////////////////////// End Table: UserGroup /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(UserGroupTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(UserGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(UserGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(UserGroupTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[UserGroup]] = 
        selectPIteratorRoot(columns = columns, from = From(UserGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS6(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], di: Long, parent: Array[Long]) => 
        UserGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, di = di, parent = parent)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[UserGroup]] = 
                selectListRoot(columns = allColumns, from = From(UserGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS6(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], di: Long, parent: Array[Long]) => 
                        UserGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, di = di, parent = parent)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[UserGroup] = 
                selectOneRoot(columns = allColumns, from = From(UserGroupTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS6(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], di: Long, parent: Array[Long])) => 
                ValidationEx(Success(UserGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, di = di, parent = parent)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                UserGroupTbl.insertWithoutCommit(connection = connection, columns = activeUserGroupTbl ~ captionGroupUserGroupTbl ~ codeGroupUserGroupTbl ~ descriptionGroupUserGroupTbl ~ diUserGroupTbl ~ parentUserGroupTbl, 
                    values map
                        {
                        value =>
                            Insert(activeUserGroupTbl, value _1) Insert(captionGroupUserGroupTbl, value _2) Insert(codeGroupUserGroupTbl, value _3) Insert(descriptionGroupUserGroupTbl, value _4) Insert(diUserGroupTbl, value _5) Insert(parentUserGroupTbl, value _6)
                    })
        }    
    
     def insertP(values: UserGroup*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                UserGroupTbl.insertWithoutCommit(connection = connection, columns = activeUserGroupTbl ~ captionGroupUserGroupTbl ~ codeGroupUserGroupTbl ~ descriptionGroupUserGroupTbl ~ diUserGroupTbl ~ parentUserGroupTbl, 
                    values map
                        {
                        value =>
                            Insert(activeUserGroupTbl, value.active) Insert(captionGroupUserGroupTbl, value.captionGroup) Insert(codeGroupUserGroupTbl, value.codeGroup) Insert(descriptionGroupUserGroupTbl, value.descriptionGroup) Insert(diUserGroupTbl, value.di) Insert(parentUserGroupTbl, value.parent)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): List[Int] = {
        UserGroupTbl.insertWithoutCommit(connection = connection, columns = activeUserGroupTbl ~ captionGroupUserGroupTbl ~ codeGroupUserGroupTbl ~ descriptionGroupUserGroupTbl ~ diUserGroupTbl ~ parentUserGroupTbl, 
            values map
                {
                value =>
                    Insert(activeUserGroupTbl, value _1) Insert(captionGroupUserGroupTbl, value _2) Insert(codeGroupUserGroupTbl, value _3) Insert(descriptionGroupUserGroupTbl, value _4) Insert(diUserGroupTbl, value _5) Insert(parentUserGroupTbl, value _6)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: UserGroup*): List[Int] = {
        UserGroupTbl.insertWithoutCommit(connection = connection, columns = activeUserGroupTbl ~ captionGroupUserGroupTbl ~ codeGroupUserGroupTbl ~ descriptionGroupUserGroupTbl ~ diUserGroupTbl ~ parentUserGroupTbl, 
            values map
                {
                value =>
                    Insert(activeUserGroupTbl, value.active) Insert(captionGroupUserGroupTbl, value.captionGroup) Insert(codeGroupUserGroupTbl, value.codeGroup) Insert(descriptionGroupUserGroupTbl, value.descriptionGroup) Insert(diUserGroupTbl, value.di) Insert(parentUserGroupTbl, value.parent)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(captionGroup, value _2) Set(codeGroup, value _3) Set(descriptionGroup, value _4) Set(di, value _5) Set(parent, value _6), where = where, table = SQLTable(UserGroupTbl.databaseTablename))
        }    
    
     def updateP(value: UserGroup, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(captionGroup, value.captionGroup) Set(codeGroup, value.codeGroup) Set(descriptionGroup, value.descriptionGroup) Set(di, value.di) Set(parent, value.parent), where = where, table = SQLTable(UserGroupTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(captionGroup, value _2) Set(codeGroup, value _3) Set(descriptionGroup, value _4) Set(di, value _5) Set(parent, value _6), where = where, table = SQLTable(UserGroupTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: UserGroup, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(captionGroup, value.captionGroup) Set(codeGroup, value.codeGroup) Set(descriptionGroup, value.descriptionGroup) Set(di, value.di) Set(parent, value.parent), where = where, table = SQLTable(UserGroupTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = UserGroupTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = UserGroupTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}