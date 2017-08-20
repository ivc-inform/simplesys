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



 
object ListElementsBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ListElementsBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListElementsBo(alias = alias)    
    
    val objectName = "ListElements"    
    val groupName = "scenarios"
}


 
class ListElementsBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ListElementsBo]  {
///////////////////////////////////////// Class: ListElements, group: scenarios /////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListElementsBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ListElementsTbl = new ListElementsTbl(alias = alias + "T0".als)    
    override val fromTable = ListElementsTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val element_list = StringColumn(name = "SELEMENT_LIST", nameInBo = "element_list", caption = "\u042D\u043B\u0435\u043C\u0435\u043D\u0442 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListElementsTbl.element_list)    
    val id_list = LongColumn(name = "IDID_LIST", nameInBo = "id_list", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListElementsTbl.id_list)    
    val id_list_element = LongColumn(name = "IDID_LIST_ELEMENT", nameInBo = "id_list_element", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u044D\u043B\u0435\u043C\u0435\u043D\u0442\u0430 \u0441\u043F\u0438\u0441\u043A\u0430", tableColumn = ListElementsTbl.id_list_element)    
    
    // For select tuple: (element_list: String, id_list: Long, id_list_element: Long)    
    
    type ColumnTypes =     TupleSS3[String, Long, Long]    
    val allColumns = element_list ~ id_list ~ id_list_element    
    val allColumns1 = Seq(element_list , id_list , id_list_element)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_list_element)),
            UniqueKey(name = "ucId_listElement_list", constraintDate = KeyConstraintData(id_list),KeyConstraintData(element_list)),
            ForignKey(name = "frId_list", constraintDate = ForignKeyConstraintData(id_list, ReferencedData("scenarios","Lists"), true)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: ListElements //////////////////////////////////////////////    
    val element_listListElementsTbl = ListElementsTbl.element_list    
    val id_listListElementsTbl = ListElementsTbl.id_list    
    val id_list_elementListElementsTbl = ListElementsTbl.id_list_element    
///////////////////////////////////////////// End Table: ListElements /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ListElementsTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ListElementsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ListElementsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ListElementsTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ListElements]] = 
        selectPIteratorRoot(columns = columns, from = From(ListElementsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(element_list: String, id_list: Long, id_list_element: Long) => 
        ListElements(element_list = element_list, id_list = id_list, id_list_element = id_list_element)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ListElements]] = 
                selectListRoot(columns = allColumns, from = From(ListElementsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(element_list: String, id_list: Long, id_list_element: Long) => 
                        ListElements(element_list = element_list, id_list = id_list, id_list_element = id_list_element)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ListElements] = 
                selectOneRoot(columns = allColumns, from = From(ListElementsTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(element_list: String, id_list: Long, id_list_element: Long)) => 
                ValidationEx(Success(ListElements(element_list = element_list, id_list = id_list, id_list_element = id_list_element)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS3[String, Long, Long]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListElementsTbl.insertWithoutCommit(connection = connection, columns = element_listListElementsTbl ~ id_listListElementsTbl ~ id_list_elementListElementsTbl, 
                    values map
                        {
                        value =>
                            Insert(element_listListElementsTbl, value _1) Insert(id_listListElementsTbl, value _2) Insert(id_list_elementListElementsTbl, value _3)
                    })
        }    
    
     def insertP(values: ListElements*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ListElementsTbl.insertWithoutCommit(connection = connection, columns = element_listListElementsTbl ~ id_listListElementsTbl ~ id_list_elementListElementsTbl, 
                    values map
                        {
                        value =>
                            Insert(element_listListElementsTbl, value.element_list) Insert(id_listListElementsTbl, value.id_list) Insert(id_list_elementListElementsTbl, value.id_list_element)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Long]*): List[Int] = {
        ListElementsTbl.insertWithoutCommit(connection = connection, columns = element_listListElementsTbl ~ id_listListElementsTbl ~ id_list_elementListElementsTbl, 
            values map
                {
                value =>
                    Insert(element_listListElementsTbl, value _1) Insert(id_listListElementsTbl, value _2) Insert(id_list_elementListElementsTbl, value _3)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: ListElements*): List[Int] = {
        ListElementsTbl.insertWithoutCommit(connection = connection, columns = element_listListElementsTbl ~ id_listListElementsTbl ~ id_list_elementListElementsTbl, 
            values map
                {
                value =>
                    Insert(element_listListElementsTbl, value.element_list) Insert(id_listListElementsTbl, value.id_list) Insert(id_list_elementListElementsTbl, value.id_list_element)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS3[String, Long, Long], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(element_list, value _1) Set(id_list, value _2) Set(id_list_element, value _3), where = where, table = SQLTable(ListElementsTbl.databaseTablename))
        }    
    
     def updateP(value: ListElements, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(element_list, value.element_list) Set(id_list, value.id_list) Set(id_list_element, value.id_list_element), where = where, table = SQLTable(ListElementsTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS3[String, Long, Long], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(element_list, value _1) Set(id_list, value _2) Set(id_list_element, value _3), where = where, table = SQLTable(ListElementsTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: ListElements, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(element_list, value.element_list) Set(id_list, value.id_list) Set(id_list_element, value.id_list_element), where = where, table = SQLTable(ListElementsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListElementsTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ListElementsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}