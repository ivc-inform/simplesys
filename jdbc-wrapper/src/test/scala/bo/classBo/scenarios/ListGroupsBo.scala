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



 
object ListGroupsBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ListGroupsBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListGroupsBo(alias = alias)    
    
    val objectName = "ListGroups"    
    val groupName = "scenarios"
}


 
class ListGroupsBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ListGroupsBo]  {
////////////////////////////////////////// Class: ListGroups, group: scenarios //////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListGroupsBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ListGroupsTbl = new ListGroupsTbl(alias = alias + "T0".als)    
    override val fromTable = ListGroupsTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val caption_listGroup = StringColumn(name = "SCAPTION_LISTGROUP", nameInBo = "caption_listGroup", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListGroupsTbl.caption_listGroup)    
    val code_listGroup = StringColumn(name = "SCODE_LISTGROUP", nameInBo = "code_listGroup", caption = "\u041A\u043E\u0434 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListGroupsTbl.code_listGroup)    
    val description_listGroup = StringOptionColumn(name = "SDESCRIPTION_LISTGROUP", nameInBo = "description_listGroup", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListGroupsTbl.description_listGroupOption)    
    val id_listGroup = LongColumn(name = "IDID_LISTGROUP", nameInBo = "id_listGroup", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListGroupsTbl.id_listGroup)    
    val parent_listGroup = LongOptionColumn(name = "IDPARENT_LISTGROUP", nameInBo = "parent_listGroup", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListGroupsTbl.parent_listGroupOption)    
    
    // For select tuple: (caption_listGroup: String, code_listGroup: String, description_listGroup: Array[String], id_listGroup: Long, parent_listGroup: Array[Long])    
    
    type ColumnTypes =     TupleSS5[String, String, Array[String], Long, Array[Long]]    
    val allColumns = caption_listGroup ~ code_listGroup ~ description_listGroup ~ id_listGroup ~ parent_listGroup    
    val allColumns1 = Seq(caption_listGroup , code_listGroup , description_listGroup , id_listGroup , parent_listGroup)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_listGroup)),
            UniqueKey(name = "ucCode_listGroup", constraintDate = KeyConstraintData(code_listGroup)),
            ForignKey(name = "frParent_listGroup", constraintDate = ForignKeyConstraintData(parent_listGroup, ReferencedData("scenarios","ListGroups"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: ListGroups //////////////////////////////////////////////    
    val caption_listGroupListGroupsTbl = ListGroupsTbl.caption_listGroup    
    val code_listGroupListGroupsTbl = ListGroupsTbl.code_listGroup    
    val description_listGroupListGroupsTbl = ListGroupsTbl.description_listGroupOption    
    val id_listGroupListGroupsTbl = ListGroupsTbl.id_listGroup    
    val parent_listGroupListGroupsTbl = ListGroupsTbl.parent_listGroupOption    
///////////////////////////////////////////// End Table: ListGroups /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ListGroupsTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ListGroups]] = 
        selectPIteratorRoot(columns = columns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS5(caption_listGroup: String, code_listGroup: String, description_listGroup: Array[String], id_listGroup: Long, parent_listGroup: Array[Long]) => 
        ListGroups(caption_listGroup = caption_listGroup, code_listGroup = code_listGroup, description_listGroup = description_listGroup, id_listGroup = id_listGroup, parent_listGroup = parent_listGroup)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ListGroups]] = 
                selectListRoot(columns = allColumns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS5(caption_listGroup: String, code_listGroup: String, description_listGroup: Array[String], id_listGroup: Long, parent_listGroup: Array[Long]) => 
                        ListGroups(caption_listGroup = caption_listGroup, code_listGroup = code_listGroup, description_listGroup = description_listGroup, id_listGroup = id_listGroup, parent_listGroup = parent_listGroup)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ListGroups] = 
                selectOneRoot(columns = allColumns, from = From(ListGroupsTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS5(caption_listGroup: String, code_listGroup: String, description_listGroup: Array[String], id_listGroup: Long, parent_listGroup: Array[Long])) => 
                ValidationEx(Success(ListGroups(caption_listGroup = caption_listGroup, code_listGroup = code_listGroup, description_listGroup = description_listGroup, id_listGroup = id_listGroup, parent_listGroup = parent_listGroup)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListGroupsTbl.insertWithoutCommit(connection = connection, columns = caption_listGroupListGroupsTbl ~ code_listGroupListGroupsTbl ~ description_listGroupListGroupsTbl ~ id_listGroupListGroupsTbl ~ parent_listGroupListGroupsTbl, 
                    values map
                        {
                        value =>
                            Insert(caption_listGroupListGroupsTbl, value _1) Insert(code_listGroupListGroupsTbl, value _2) Insert(description_listGroupListGroupsTbl, value _3) Insert(id_listGroupListGroupsTbl, value _4) Insert(parent_listGroupListGroupsTbl, value _5)
                    })
        }    
    
     def insertP(values: ListGroups*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListGroupsTbl.insertWithoutCommit(connection = connection, columns = caption_listGroupListGroupsTbl ~ code_listGroupListGroupsTbl ~ description_listGroupListGroupsTbl ~ id_listGroupListGroupsTbl ~ parent_listGroupListGroupsTbl, 
                    values map
                        {
                        value =>
                            Insert(caption_listGroupListGroupsTbl, value.caption_listGroup) Insert(code_listGroupListGroupsTbl, value.code_listGroup) Insert(description_listGroupListGroupsTbl, value.description_listGroup) Insert(id_listGroupListGroupsTbl, value.id_listGroup) Insert(parent_listGroupListGroupsTbl, value.parent_listGroup)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): List[Int] = {
        ListGroupsTbl.insertWithoutCommit(connection = connection, columns = caption_listGroupListGroupsTbl ~ code_listGroupListGroupsTbl ~ description_listGroupListGroupsTbl ~ id_listGroupListGroupsTbl ~ parent_listGroupListGroupsTbl, 
            values map
                {
                value =>
                    Insert(caption_listGroupListGroupsTbl, value _1) Insert(code_listGroupListGroupsTbl, value _2) Insert(description_listGroupListGroupsTbl, value _3) Insert(id_listGroupListGroupsTbl, value _4) Insert(parent_listGroupListGroupsTbl, value _5)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: ListGroups*): List[Int] = {
        ListGroupsTbl.insertWithoutCommit(connection = connection, columns = caption_listGroupListGroupsTbl ~ code_listGroupListGroupsTbl ~ description_listGroupListGroupsTbl ~ id_listGroupListGroupsTbl ~ parent_listGroupListGroupsTbl, 
            values map
                {
                value =>
                    Insert(caption_listGroupListGroupsTbl, value.caption_listGroup) Insert(code_listGroupListGroupsTbl, value.code_listGroup) Insert(description_listGroupListGroupsTbl, value.description_listGroup) Insert(id_listGroupListGroupsTbl, value.id_listGroup) Insert(parent_listGroupListGroupsTbl, value.parent_listGroup)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS5[String, String, Array[String], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(caption_listGroup, value _1) Set(code_listGroup, value _2) Set(description_listGroup, value _3) Set(id_listGroup, value _4) Set(parent_listGroup, value _5), where = where, table = SQLTable(ListGroupsTbl.databaseTablename))
        }    
    
     def updateP(value: ListGroups, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(caption_listGroup, value.caption_listGroup) Set(code_listGroup, value.code_listGroup) Set(description_listGroup, value.description_listGroup) Set(id_listGroup, value.id_listGroup) Set(parent_listGroup, value.parent_listGroup), where = where, table = SQLTable(ListGroupsTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS5[String, String, Array[String], Long, Array[Long]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(caption_listGroup, value _1) Set(code_listGroup, value _2) Set(description_listGroup, value _3) Set(id_listGroup, value _4) Set(parent_listGroup, value _5), where = where, table = SQLTable(ListGroupsTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: ListGroups, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(caption_listGroup, value.caption_listGroup) Set(code_listGroup, value.code_listGroup) Set(description_listGroup, value.description_listGroup) Set(id_listGroup, value.id_listGroup) Set(parent_listGroup, value.parent_listGroup), where = where, table = SQLTable(ListGroupsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListGroupsTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListGroupsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}