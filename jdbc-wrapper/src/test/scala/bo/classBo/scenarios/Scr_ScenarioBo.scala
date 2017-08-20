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



 
object Scr_ScenarioBo {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioBo(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}


 
class Scr_ScenarioBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[Scr_ScenarioBo]  {
///////////////////////////////////////// Class: Scr_Scenario, group: scenarios /////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_ScenarioBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val Scr_ScenarioTbl = new Scr_ScenarioTbl(alias = alias + "T0".als)    
    override val fromTable = Scr_ScenarioTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val begin_scenario = LocalDateTimeOptionColumn(name = "DTBEGIN_SCENARIO", nameInBo = "begin_scenario", caption = "\u0414\u0430\u0442\u0430 \u0441\u0442\u0430\u0440\u0442\u0430 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.begin_scenarioOption)    
    val caption_scenario = StringColumn(name = "SCAPTION_SCENARIO", nameInBo = "caption_scenario", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.caption_scenario)    
    val code_scenario = StringColumn(name = "SCODE_SCENARIO", nameInBo = "code_scenario", caption = "\u041A\u043E\u0434 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.code_scenario)    
    val debug_mode = BooleanOptionColumn(name = "BDEBUG_MODE", nameInBo = "debug_mode", caption = "\u0420\u0435\u0436\u0438\u043C \u043E\u0442\u043B\u0430\u0434\u043A\u0438", tableColumn = Scr_ScenarioTbl.debug_modeOption)    
    val description_scenario = StringOptionColumn(name = "SDESCRIPTION_SCENARIO", nameInBo = "description_scenario", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.description_scenarioOption)    
    val end_scenario = LocalDateTimeOptionColumn(name = "DTEND_SCENARIO", nameInBo = "end_scenario", caption = "\u0414\u0430\u0442\u0430 \u043E\u043A\u043E\u043D\u0447\u0430\u043D\u0438\u044F \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.end_scenarioOption)    
    val id_cmpgn = LongOptionColumn(name = "IDID_CMPGN", nameInBo = "id_cmpgn", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u043A\u0430\u043C\u043F\u0430\u043D\u0438\u0438", tableColumn = Scr_ScenarioTbl.id_cmpgnOption)    
    val id_scenario = LongColumn(name = "IDID_SCENARIO", nameInBo = "id_scenario", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.id_scenario)    
    val status = LongOptionColumn(name = "NSTATUS", nameInBo = "status", caption = "\u0421\u0442\u0430\u0442\u0443\u0441 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.statusOption)    
    val version = LocalDateTimeOptionColumn(name = "DTVERSION", nameInBo = "version", caption = "\u0412\u0435\u0440\u0441\u0438\u044F", tableColumn = Scr_ScenarioTbl.versionOption)    
    
    // For select tuple: (begin_scenario: Array[LocalDateTime], caption_scenario: String, code_scenario: String, debug_mode: Array[Boolean], description_scenario: Array[String], end_scenario: Array[LocalDateTime], id_cmpgn: Array[Long], id_scenario: Long, status: Array[Long], version: Array[LocalDateTime])    
    
    type ColumnTypes =     TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]    
    val allColumns = begin_scenario ~ caption_scenario ~ code_scenario ~ debug_mode ~ description_scenario ~ end_scenario ~ id_cmpgn ~ id_scenario ~ status ~ version    
    val allColumns1 = Seq(begin_scenario , caption_scenario , code_scenario , debug_mode , description_scenario , end_scenario , id_cmpgn , id_scenario , status , version)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_scenario)),
            UniqueKey(name = "ucCode_scenario", constraintDate = KeyConstraintData(code_scenario)),
            ForignKey(name = "frId_cmpgn", constraintDate = ForignKeyConstraintData(id_cmpgn, ReferencedData("scenarios","Scr_Cmpgn"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: Scr_Scenario //////////////////////////////////////////////    
    val begin_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.begin_scenarioOption    
    val caption_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.caption_scenario    
    val code_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.code_scenario    
    val debug_modeScr_ScenarioTbl = Scr_ScenarioTbl.debug_modeOption    
    val description_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.description_scenarioOption    
    val end_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.end_scenarioOption    
    val id_cmpgnScr_ScenarioTbl = Scr_ScenarioTbl.id_cmpgnOption    
    val id_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.id_scenario    
    val statusScr_ScenarioTbl = Scr_ScenarioTbl.statusOption    
    val versionScr_ScenarioTbl = Scr_ScenarioTbl.versionOption    
///////////////////////////////////////////// End Table: Scr_Scenario /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(Scr_ScenarioTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_Scenario]] = 
        selectPIteratorRoot(columns = columns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS10(begin_scenario: Array[LocalDateTime], caption_scenario: String, code_scenario: String, debug_mode: Array[Boolean], description_scenario: Array[String], end_scenario: Array[LocalDateTime], id_cmpgn: Array[Long], id_scenario: Long, status: Array[Long], version: Array[LocalDateTime]) => 
        Scr_Scenario(begin_scenario = begin_scenario, caption_scenario = caption_scenario, code_scenario = code_scenario, debug_mode = debug_mode, description_scenario = description_scenario, end_scenario = end_scenario, id_cmpgn = id_cmpgn, id_scenario = id_scenario, status = status, version = version)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_Scenario]] = 
                selectListRoot(columns = allColumns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS10(begin_scenario: Array[LocalDateTime], caption_scenario: String, code_scenario: String, debug_mode: Array[Boolean], description_scenario: Array[String], end_scenario: Array[LocalDateTime], id_cmpgn: Array[Long], id_scenario: Long, status: Array[Long], version: Array[LocalDateTime]) => 
                        Scr_Scenario(begin_scenario = begin_scenario, caption_scenario = caption_scenario, code_scenario = code_scenario, debug_mode = debug_mode, description_scenario = description_scenario, end_scenario = end_scenario, id_cmpgn = id_cmpgn, id_scenario = id_scenario, status = status, version = version)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_Scenario] = 
                selectOneRoot(columns = allColumns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS10(begin_scenario: Array[LocalDateTime], caption_scenario: String, code_scenario: String, debug_mode: Array[Boolean], description_scenario: Array[String], end_scenario: Array[LocalDateTime], id_cmpgn: Array[Long], id_scenario: Long, status: Array[Long], version: Array[LocalDateTime])) => 
                ValidationEx(Success(Scr_Scenario(begin_scenario = begin_scenario, caption_scenario = caption_scenario, code_scenario = code_scenario, debug_mode = debug_mode, description_scenario = description_scenario, end_scenario = end_scenario, id_cmpgn = id_cmpgn, id_scenario = id_scenario, status = status, version = version)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = begin_scenarioScr_ScenarioTbl ~ caption_scenarioScr_ScenarioTbl ~ code_scenarioScr_ScenarioTbl ~ debug_modeScr_ScenarioTbl ~ description_scenarioScr_ScenarioTbl ~ end_scenarioScr_ScenarioTbl ~ id_cmpgnScr_ScenarioTbl ~ id_scenarioScr_ScenarioTbl ~ statusScr_ScenarioTbl ~ versionScr_ScenarioTbl, 
                    values map
                        {
                        value =>
                            Insert(begin_scenarioScr_ScenarioTbl, value _1) Insert(caption_scenarioScr_ScenarioTbl, value _2) Insert(code_scenarioScr_ScenarioTbl, value _3) Insert(debug_modeScr_ScenarioTbl, value _4) Insert(description_scenarioScr_ScenarioTbl, value _5) Insert(end_scenarioScr_ScenarioTbl, value _6) Insert(id_cmpgnScr_ScenarioTbl, value _7) Insert(id_scenarioScr_ScenarioTbl, value _8) Insert(statusScr_ScenarioTbl, value _9) Insert(versionScr_ScenarioTbl, value _10)
                    })
        }    
    
     def insertP(values: Scr_Scenario*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = begin_scenarioScr_ScenarioTbl ~ caption_scenarioScr_ScenarioTbl ~ code_scenarioScr_ScenarioTbl ~ debug_modeScr_ScenarioTbl ~ description_scenarioScr_ScenarioTbl ~ end_scenarioScr_ScenarioTbl ~ id_cmpgnScr_ScenarioTbl ~ id_scenarioScr_ScenarioTbl ~ statusScr_ScenarioTbl ~ versionScr_ScenarioTbl, 
                    values map
                        {
                        value =>
                            Insert(begin_scenarioScr_ScenarioTbl, value.begin_scenario) Insert(caption_scenarioScr_ScenarioTbl, value.caption_scenario) Insert(code_scenarioScr_ScenarioTbl, value.code_scenario) Insert(debug_modeScr_ScenarioTbl, value.debug_mode) Insert(description_scenarioScr_ScenarioTbl, value.description_scenario) Insert(end_scenarioScr_ScenarioTbl, value.end_scenario) Insert(id_cmpgnScr_ScenarioTbl, value.id_cmpgn) Insert(id_scenarioScr_ScenarioTbl, value.id_scenario) Insert(statusScr_ScenarioTbl, value.status) Insert(versionScr_ScenarioTbl, value.version)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): List[Int] = {
        Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = begin_scenarioScr_ScenarioTbl ~ caption_scenarioScr_ScenarioTbl ~ code_scenarioScr_ScenarioTbl ~ debug_modeScr_ScenarioTbl ~ description_scenarioScr_ScenarioTbl ~ end_scenarioScr_ScenarioTbl ~ id_cmpgnScr_ScenarioTbl ~ id_scenarioScr_ScenarioTbl ~ statusScr_ScenarioTbl ~ versionScr_ScenarioTbl, 
            values map
                {
                value =>
                    Insert(begin_scenarioScr_ScenarioTbl, value _1) Insert(caption_scenarioScr_ScenarioTbl, value _2) Insert(code_scenarioScr_ScenarioTbl, value _3) Insert(debug_modeScr_ScenarioTbl, value _4) Insert(description_scenarioScr_ScenarioTbl, value _5) Insert(end_scenarioScr_ScenarioTbl, value _6) Insert(id_cmpgnScr_ScenarioTbl, value _7) Insert(id_scenarioScr_ScenarioTbl, value _8) Insert(statusScr_ScenarioTbl, value _9) Insert(versionScr_ScenarioTbl, value _10)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Scenario*): List[Int] = {
        Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = begin_scenarioScr_ScenarioTbl ~ caption_scenarioScr_ScenarioTbl ~ code_scenarioScr_ScenarioTbl ~ debug_modeScr_ScenarioTbl ~ description_scenarioScr_ScenarioTbl ~ end_scenarioScr_ScenarioTbl ~ id_cmpgnScr_ScenarioTbl ~ id_scenarioScr_ScenarioTbl ~ statusScr_ScenarioTbl ~ versionScr_ScenarioTbl, 
            values map
                {
                value =>
                    Insert(begin_scenarioScr_ScenarioTbl, value.begin_scenario) Insert(caption_scenarioScr_ScenarioTbl, value.caption_scenario) Insert(code_scenarioScr_ScenarioTbl, value.code_scenario) Insert(debug_modeScr_ScenarioTbl, value.debug_mode) Insert(description_scenarioScr_ScenarioTbl, value.description_scenario) Insert(end_scenarioScr_ScenarioTbl, value.end_scenario) Insert(id_cmpgnScr_ScenarioTbl, value.id_cmpgn) Insert(id_scenarioScr_ScenarioTbl, value.id_scenario) Insert(statusScr_ScenarioTbl, value.status) Insert(versionScr_ScenarioTbl, value.version)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(begin_scenario, value _1) Set(caption_scenario, value _2) Set(code_scenario, value _3) Set(debug_mode, value _4) Set(description_scenario, value _5) Set(end_scenario, value _6) Set(id_cmpgn, value _7) Set(id_scenario, value _8) Set(status, value _9) Set(version, value _10), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
        }    
    
     def updateP(value: Scr_Scenario, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(begin_scenario, value.begin_scenario) Set(caption_scenario, value.caption_scenario) Set(code_scenario, value.code_scenario) Set(debug_mode, value.debug_mode) Set(description_scenario, value.description_scenario) Set(end_scenario, value.end_scenario) Set(id_cmpgn, value.id_cmpgn) Set(id_scenario, value.id_scenario) Set(status, value.status) Set(version, value.version), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(begin_scenario, value _1) Set(caption_scenario, value _2) Set(code_scenario, value _3) Set(debug_mode, value _4) Set(description_scenario, value _5) Set(end_scenario, value _6) Set(id_cmpgn, value _7) Set(id_scenario, value _8) Set(status, value _9) Set(version, value _10), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Scr_Scenario, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(begin_scenario, value.begin_scenario) Set(caption_scenario, value.caption_scenario) Set(code_scenario, value.code_scenario) Set(debug_mode, value.debug_mode) Set(description_scenario, value.description_scenario) Set(end_scenario, value.end_scenario) Set(id_cmpgn, value.id_cmpgn) Set(id_scenario, value.id_scenario) Set(status, value.status) Set(version, value.version), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_ScenarioTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_ScenarioTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}