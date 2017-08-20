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



 
object ListsBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ListsBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListsBo(alias = alias)    
    
    val objectName = "Lists"    
    val groupName = "scenarios"
}


 
class ListsBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ListsBo]  {
/////////////////////////////////////////// Class: Lists, group: scenarios ///////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListsBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ListsTbl = new ListsTbl(alias = alias + "T0".als)    
    override val fromTable = ListsTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val caption_list = StringColumn(name = "SCAPTION_LIST", nameInBo = "caption_list", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListsTbl.caption_list)    
    val code_list = StringColumn(name = "SCODE_LIST", nameInBo = "code_list", caption = "\u041A\u043E\u0434 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListsTbl.code_list)    
    val description_list = StringOptionColumn(name = "SDESCRIPTION_LIST", nameInBo = "description_list", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListsTbl.description_listOption)    
    val id_list = LongColumn(name = "IDID_LIST", nameInBo = "id_list", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListsTbl.id_list)    
    val id_listGroup_ref = LongOptionColumn(name = "IDID_LISTGROUP_REF", nameInBo = "id_listGroup_ref", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0433\u0440\u0443\u043F\u043F\u044B \u0441\u043F\u0438\u0441\u043A\u043E\u0432", tableColumn = ListsTbl.id_listGroup_refOption)    
    val type_list = StringColumn(name = "STYPE_LIST", nameInBo = "type_list", caption = "\u0422\u0438\u043F \u044D\u043B\u0435\u043C\u0435\u043D\u0442\u0430 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListsTbl.type_list)    
    
    // For select tuple: (caption_list: String, code_list: String, description_list: Array[String], id_list: Long, id_listGroup_ref: Array[Long], type_list: String)    
    
    type ColumnTypes =     TupleSS6[String, String, Array[String], Long, Array[Long], String]    
    val allColumns = caption_list ~ code_list ~ description_list ~ id_list ~ id_listGroup_ref ~ type_list    
    val allColumns1 = Seq(caption_list , code_list , description_list , id_list , id_listGroup_ref , type_list)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_list)),
            UniqueKey(name = "ucCode_list", constraintDate = KeyConstraintData(code_list)),
            ForignKey(name = "frId_listGroup_ref", constraintDate = ForignKeyConstraintData(id_listGroup_ref, ReferencedData("scenarios","ListGroups"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
/////////////////////////////////////////////// Table: Lists ///////////////////////////////////////////////    
    val caption_listListsTbl = ListsTbl.caption_list    
    val code_listListsTbl = ListsTbl.code_list    
    val description_listListsTbl = ListsTbl.description_listOption    
    val id_listListsTbl = ListsTbl.id_list    
    val id_listGroup_refListsTbl = ListsTbl.id_listGroup_refOption    
    val type_listListsTbl = ListsTbl.type_list    
////////////////////////////////////////////// End Table: Lists //////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ListsTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ListsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ListsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ListsTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Lists]] = 
        selectPIteratorRoot(columns = columns, from = From(ListsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS6(caption_list: String, code_list: String, description_list: Array[String], id_list: Long, id_listGroup_ref: Array[Long], type_list: String) => 
        Lists(caption_list = caption_list, code_list = code_list, description_list = description_list, id_list = id_list, id_listGroup_ref = id_listGroup_ref, type_list = type_list)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Lists]] = 
                selectListRoot(columns = allColumns, from = From(ListsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS6(caption_list: String, code_list: String, description_list: Array[String], id_list: Long, id_listGroup_ref: Array[Long], type_list: String) => 
                        Lists(caption_list = caption_list, code_list = code_list, description_list = description_list, id_list = id_list, id_listGroup_ref = id_listGroup_ref, type_list = type_list)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Lists] = 
                selectOneRoot(columns = allColumns, from = From(ListsTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS6(caption_list: String, code_list: String, description_list: Array[String], id_list: Long, id_listGroup_ref: Array[Long], type_list: String)) => 
                ValidationEx(Success(Lists(caption_list = caption_list, code_list = code_list, description_list = description_list, id_list = id_list, id_listGroup_ref = id_listGroup_ref, type_list = type_list)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListsTbl.insertWithoutCommit(connection = connection, columns = caption_listListsTbl ~ code_listListsTbl ~ description_listListsTbl ~ id_listListsTbl ~ id_listGroup_refListsTbl ~ type_listListsTbl, 
                    values map
                        {
                        value =>
                            Insert(caption_listListsTbl, value _1) Insert(code_listListsTbl, value _2) Insert(description_listListsTbl, value _3) Insert(id_listListsTbl, value _4) Insert(id_listGroup_refListsTbl, value _5) Insert(type_listListsTbl, value _6)
                    })
        }    
    
     def insertP(values: Lists*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListsTbl.insertWithoutCommit(connection = connection, columns = caption_listListsTbl ~ code_listListsTbl ~ description_listListsTbl ~ id_listListsTbl ~ id_listGroup_refListsTbl ~ type_listListsTbl, 
                    values map
                        {
                        value =>
                            Insert(caption_listListsTbl, value.caption_list) Insert(code_listListsTbl, value.code_list) Insert(description_listListsTbl, value.description_list) Insert(id_listListsTbl, value.id_list) Insert(id_listGroup_refListsTbl, value.id_listGroup_ref) Insert(type_listListsTbl, value.type_list)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): List[Int] = {
        ListsTbl.insertWithoutCommit(connection = connection, columns = caption_listListsTbl ~ code_listListsTbl ~ description_listListsTbl ~ id_listListsTbl ~ id_listGroup_refListsTbl ~ type_listListsTbl, 
            values map
                {
                value =>
                    Insert(caption_listListsTbl, value _1) Insert(code_listListsTbl, value _2) Insert(description_listListsTbl, value _3) Insert(id_listListsTbl, value _4) Insert(id_listGroup_refListsTbl, value _5) Insert(type_listListsTbl, value _6)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Lists*): List[Int] = {
        ListsTbl.insertWithoutCommit(connection = connection, columns = caption_listListsTbl ~ code_listListsTbl ~ description_listListsTbl ~ id_listListsTbl ~ id_listGroup_refListsTbl ~ type_listListsTbl, 
            values map
                {
                value =>
                    Insert(caption_listListsTbl, value.caption_list) Insert(code_listListsTbl, value.code_list) Insert(description_listListsTbl, value.description_list) Insert(id_listListsTbl, value.id_list) Insert(id_listGroup_refListsTbl, value.id_listGroup_ref) Insert(type_listListsTbl, value.type_list)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS6[String, String, Array[String], Long, Array[Long], String], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(caption_list, value _1) Set(code_list, value _2) Set(description_list, value _3) Set(id_list, value _4) Set(id_listGroup_ref, value _5) Set(type_list, value _6), where = where, table = SQLTable(ListsTbl.databaseTablename))
        }    
    
     def updateP(value: Lists, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(caption_list, value.caption_list) Set(code_list, value.code_list) Set(description_list, value.description_list) Set(id_list, value.id_list) Set(id_listGroup_ref, value.id_listGroup_ref) Set(type_list, value.type_list), where = where, table = SQLTable(ListsTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS6[String, String, Array[String], Long, Array[Long], String], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(caption_list, value _1) Set(code_list, value _2) Set(description_list, value _3) Set(id_list, value _4) Set(id_listGroup_ref, value _5) Set(type_list, value _6), where = where, table = SQLTable(ListsTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Lists, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(caption_list, value.caption_list) Set(code_list, value.code_list) Set(description_list, value.description_list) Set(id_list, value.id_list) Set(id_listGroup_ref, value.id_listGroup_ref) Set(type_list, value.type_list), where = where, table = SQLTable(ListsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListsTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}