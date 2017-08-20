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



 
object Scr_CmpgnBo {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnBo(alias = alias)    
    
    val objectName = "Scr_Cmpgn"    
    val groupName = "scenarios"
}


 
class Scr_CmpgnBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[Scr_CmpgnBo]  {
////////////////////////////////////////// Class: Scr_Cmpgn, group: scenarios //////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_CmpgnBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val Scr_CmpgnTbl = new Scr_CmpgnTbl(alias = alias + "T0".als)    
    override val fromTable = Scr_CmpgnTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val active_cmpgn = BooleanOptionColumn(name = "BACTIVE_CMPGN", nameInBo = "active_cmpgn", caption = "\u0410\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u044C \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.active_cmpgnOption)    
    val begin_cmpgn = LocalDateTimeOptionColumn(name = "DTBEGIN_CMPGN", nameInBo = "begin_cmpgn", caption = "\u0414\u0430\u0442\u0430 \u0441\u0442\u0430\u0440\u0442\u0430 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.begin_cmpgnOption)    
    val caption_cmpgn = StringColumn(name = "SCAPTION_CMPGN", nameInBo = "caption_cmpgn", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.caption_cmpgn)    
    val code_cmpgn = StringColumn(name = "SCODE_CMPGN", nameInBo = "code_cmpgn", caption = "\u041A\u043E\u0434 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.code_cmpgn)    
    val description_cmpgn = StringOptionColumn(name = "SDESCRIPTION_CMPGN", nameInBo = "description_cmpgn", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.description_cmpgnOption)    
    val end_cmpgn = LocalDateTimeOptionColumn(name = "DTEND_CMPGN", nameInBo = "end_cmpgn", caption = "\u0414\u0430\u0442\u0430 \u043E\u043A\u043E\u043D\u0447\u0430\u043D\u0438\u044F \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.end_cmpgnOption)    
    val id_cmpgn = LongColumn(name = "IDID_CMPGN", nameInBo = "id_cmpgn", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.id_cmpgn)    
    val parent_cmpgn = LongOptionColumn(name = "IDPARENT_CMPGN", nameInBo = "parent_cmpgn", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_CmpgnTbl.parent_cmpgnOption)    
    
    // For select tuple: (active_cmpgn: Array[Boolean], begin_cmpgn: Array[LocalDateTime], caption_cmpgn: String, code_cmpgn: String, description_cmpgn: Array[String], end_cmpgn: Array[LocalDateTime], id_cmpgn: Long, parent_cmpgn: Array[Long])    
    
    type ColumnTypes =     TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]    
    val allColumns = active_cmpgn ~ begin_cmpgn ~ caption_cmpgn ~ code_cmpgn ~ description_cmpgn ~ end_cmpgn ~ id_cmpgn ~ parent_cmpgn    
    val allColumns1 = Seq(active_cmpgn , begin_cmpgn , caption_cmpgn , code_cmpgn , description_cmpgn , end_cmpgn , id_cmpgn , parent_cmpgn)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_cmpgn)),
            UniqueKey(name = "ucCode_cmpgn", constraintDate = KeyConstraintData(code_cmpgn)),
            ForignKey(name = "frParent_cmpgn", constraintDate = ForignKeyConstraintData(parent_cmpgn, ReferencedData("scenarios","Scr_Cmpgn"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: Scr_Cmpgn //////////////////////////////////////////////    
    val active_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.active_cmpgnOption    
    val begin_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.begin_cmpgnOption    
    val caption_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.caption_cmpgn    
    val code_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.code_cmpgn    
    val description_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.description_cmpgnOption    
    val end_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.end_cmpgnOption    
    val id_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.id_cmpgn    
    val parent_cmpgnScr_CmpgnTbl = Scr_CmpgnTbl.parent_cmpgnOption    
///////////////////////////////////////////// End Table: Scr_Cmpgn /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(Scr_CmpgnTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_Cmpgn]] = 
        selectPIteratorRoot(columns = columns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS8(active_cmpgn: Array[Boolean], begin_cmpgn: Array[LocalDateTime], caption_cmpgn: String, code_cmpgn: String, description_cmpgn: Array[String], end_cmpgn: Array[LocalDateTime], id_cmpgn: Long, parent_cmpgn: Array[Long]) => 
        Scr_Cmpgn(active_cmpgn = active_cmpgn, begin_cmpgn = begin_cmpgn, caption_cmpgn = caption_cmpgn, code_cmpgn = code_cmpgn, description_cmpgn = description_cmpgn, end_cmpgn = end_cmpgn, id_cmpgn = id_cmpgn, parent_cmpgn = parent_cmpgn)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_Cmpgn]] = 
                selectListRoot(columns = allColumns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS8(active_cmpgn: Array[Boolean], begin_cmpgn: Array[LocalDateTime], caption_cmpgn: String, code_cmpgn: String, description_cmpgn: Array[String], end_cmpgn: Array[LocalDateTime], id_cmpgn: Long, parent_cmpgn: Array[Long]) => 
                        Scr_Cmpgn(active_cmpgn = active_cmpgn, begin_cmpgn = begin_cmpgn, caption_cmpgn = caption_cmpgn, code_cmpgn = code_cmpgn, description_cmpgn = description_cmpgn, end_cmpgn = end_cmpgn, id_cmpgn = id_cmpgn, parent_cmpgn = parent_cmpgn)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_Cmpgn] = 
                selectOneRoot(columns = allColumns, from = From(Scr_CmpgnTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS8(active_cmpgn: Array[Boolean], begin_cmpgn: Array[LocalDateTime], caption_cmpgn: String, code_cmpgn: String, description_cmpgn: Array[String], end_cmpgn: Array[LocalDateTime], id_cmpgn: Long, parent_cmpgn: Array[Long])) => 
                ValidationEx(Success(Scr_Cmpgn(active_cmpgn = active_cmpgn, begin_cmpgn = begin_cmpgn, caption_cmpgn = caption_cmpgn, code_cmpgn = code_cmpgn, description_cmpgn = description_cmpgn, end_cmpgn = end_cmpgn, id_cmpgn = id_cmpgn, parent_cmpgn = parent_cmpgn)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_CmpgnTbl.insertWithoutCommit(connection = connection, columns = active_cmpgnScr_CmpgnTbl ~ begin_cmpgnScr_CmpgnTbl ~ caption_cmpgnScr_CmpgnTbl ~ code_cmpgnScr_CmpgnTbl ~ description_cmpgnScr_CmpgnTbl ~ end_cmpgnScr_CmpgnTbl ~ id_cmpgnScr_CmpgnTbl ~ parent_cmpgnScr_CmpgnTbl, 
                    values map
                        {
                        value =>
                            Insert(active_cmpgnScr_CmpgnTbl, value _1) Insert(begin_cmpgnScr_CmpgnTbl, value _2) Insert(caption_cmpgnScr_CmpgnTbl, value _3) Insert(code_cmpgnScr_CmpgnTbl, value _4) Insert(description_cmpgnScr_CmpgnTbl, value _5) Insert(end_cmpgnScr_CmpgnTbl, value _6) Insert(id_cmpgnScr_CmpgnTbl, value _7) Insert(parent_cmpgnScr_CmpgnTbl, value _8)
                    })
        }    
    
     def insertP(values: Scr_Cmpgn*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_CmpgnTbl.insertWithoutCommit(connection = connection, columns = active_cmpgnScr_CmpgnTbl ~ begin_cmpgnScr_CmpgnTbl ~ caption_cmpgnScr_CmpgnTbl ~ code_cmpgnScr_CmpgnTbl ~ description_cmpgnScr_CmpgnTbl ~ end_cmpgnScr_CmpgnTbl ~ id_cmpgnScr_CmpgnTbl ~ parent_cmpgnScr_CmpgnTbl, 
                    values map
                        {
                        value =>
                            Insert(active_cmpgnScr_CmpgnTbl, value.active_cmpgn) Insert(begin_cmpgnScr_CmpgnTbl, value.begin_cmpgn) Insert(caption_cmpgnScr_CmpgnTbl, value.caption_cmpgn) Insert(code_cmpgnScr_CmpgnTbl, value.code_cmpgn) Insert(description_cmpgnScr_CmpgnTbl, value.description_cmpgn) Insert(end_cmpgnScr_CmpgnTbl, value.end_cmpgn) Insert(id_cmpgnScr_CmpgnTbl, value.id_cmpgn) Insert(parent_cmpgnScr_CmpgnTbl, value.parent_cmpgn)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): List[Int] = {
        Scr_CmpgnTbl.insertWithoutCommit(connection = connection, columns = active_cmpgnScr_CmpgnTbl ~ begin_cmpgnScr_CmpgnTbl ~ caption_cmpgnScr_CmpgnTbl ~ code_cmpgnScr_CmpgnTbl ~ description_cmpgnScr_CmpgnTbl ~ end_cmpgnScr_CmpgnTbl ~ id_cmpgnScr_CmpgnTbl ~ parent_cmpgnScr_CmpgnTbl, 
            values map
                {
                value =>
                    Insert(active_cmpgnScr_CmpgnTbl, value _1) Insert(begin_cmpgnScr_CmpgnTbl, value _2) Insert(caption_cmpgnScr_CmpgnTbl, value _3) Insert(code_cmpgnScr_CmpgnTbl, value _4) Insert(description_cmpgnScr_CmpgnTbl, value _5) Insert(end_cmpgnScr_CmpgnTbl, value _6) Insert(id_cmpgnScr_CmpgnTbl, value _7) Insert(parent_cmpgnScr_CmpgnTbl, value _8)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Cmpgn*): List[Int] = {
        Scr_CmpgnTbl.insertWithoutCommit(connection = connection, columns = active_cmpgnScr_CmpgnTbl ~ begin_cmpgnScr_CmpgnTbl ~ caption_cmpgnScr_CmpgnTbl ~ code_cmpgnScr_CmpgnTbl ~ description_cmpgnScr_CmpgnTbl ~ end_cmpgnScr_CmpgnTbl ~ id_cmpgnScr_CmpgnTbl ~ parent_cmpgnScr_CmpgnTbl, 
            values map
                {
                value =>
                    Insert(active_cmpgnScr_CmpgnTbl, value.active_cmpgn) Insert(begin_cmpgnScr_CmpgnTbl, value.begin_cmpgn) Insert(caption_cmpgnScr_CmpgnTbl, value.caption_cmpgn) Insert(code_cmpgnScr_CmpgnTbl, value.code_cmpgn) Insert(description_cmpgnScr_CmpgnTbl, value.description_cmpgn) Insert(end_cmpgnScr_CmpgnTbl, value.end_cmpgn) Insert(id_cmpgnScr_CmpgnTbl, value.id_cmpgn) Insert(parent_cmpgnScr_CmpgnTbl, value.parent_cmpgn)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active_cmpgn, value _1) Set(begin_cmpgn, value _2) Set(caption_cmpgn, value _3) Set(code_cmpgn, value _4) Set(description_cmpgn, value _5) Set(end_cmpgn, value _6) Set(id_cmpgn, value _7) Set(parent_cmpgn, value _8), where = where, table = SQLTable(Scr_CmpgnTbl.databaseTablename))
        }    
    
     def updateP(value: Scr_Cmpgn, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active_cmpgn, value.active_cmpgn) Set(begin_cmpgn, value.begin_cmpgn) Set(caption_cmpgn, value.caption_cmpgn) Set(code_cmpgn, value.code_cmpgn) Set(description_cmpgn, value.description_cmpgn) Set(end_cmpgn, value.end_cmpgn) Set(id_cmpgn, value.id_cmpgn) Set(parent_cmpgn, value.parent_cmpgn), where = where, table = SQLTable(Scr_CmpgnTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active_cmpgn, value _1) Set(begin_cmpgn, value _2) Set(caption_cmpgn, value _3) Set(code_cmpgn, value _4) Set(description_cmpgn, value _5) Set(end_cmpgn, value _6) Set(id_cmpgn, value _7) Set(parent_cmpgn, value _8), where = where, table = SQLTable(Scr_CmpgnTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Scr_Cmpgn, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active_cmpgn, value.active_cmpgn) Set(begin_cmpgn, value.begin_cmpgn) Set(caption_cmpgn, value.caption_cmpgn) Set(code_cmpgn, value.code_cmpgn) Set(description_cmpgn, value.description_cmpgn) Set(end_cmpgn, value.end_cmpgn) Set(id_cmpgn, value.id_cmpgn) Set(parent_cmpgn, value.parent_cmpgn), where = where, table = SQLTable(Scr_CmpgnTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_CmpgnTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_CmpgnTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}