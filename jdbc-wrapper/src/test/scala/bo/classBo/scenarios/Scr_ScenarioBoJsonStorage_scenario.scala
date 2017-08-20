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



 
object Scr_ScenarioBoJsonStorage_scenario {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioBoJsonStorage_scenario(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioBoJsonStorage_scenario(alias = alias)    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}


 
class Scr_ScenarioBoJsonStorage_scenario(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[Scr_ScenarioBoJsonStorage_scenario]  {
///////////////////////////////////////// Class: Scr_Scenario, group: scenarios /////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_ScenarioBoJsonStorage_scenario = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val Scr_ScenarioTbl = new Scr_ScenarioTblJsonStorage_scenario(alias = alias + "T0".als)    
    override val fromTable = Scr_ScenarioTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val id_scenario = LongColumn(name = "IDID_SCENARIO", nameInBo = "id_scenario", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_ScenarioTbl.id_scenario)    
    val jsonStorage_scenario = JsonOptionColumn(name = "JSNJSONSTORAGE_SCENARIO", nameInBo = "jsonStorage_scenario", caption = "JSON", tableColumn = Scr_ScenarioTbl.jsonStorage_scenarioOption)    
    
    // For select tuple: (id_scenario: Long, jsonStorage_scenario: Array[Json])    
    
    type ColumnTypes =     TupleSS2[Long, Array[Json]]    
    val allColumns = id_scenario ~ jsonStorage_scenario    
    val allColumns1 = Seq(id_scenario , jsonStorage_scenario)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_scenario)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: Scr_Scenario //////////////////////////////////////////////    
    val id_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.id_scenario    
    val jsonStorage_scenarioScr_ScenarioTbl = Scr_ScenarioTbl.jsonStorage_scenarioOption    
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
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_ScenarioJsonStorage_scenario]] = 
        selectPIteratorRoot(columns = columns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS2(id_scenario: Long, jsonStorage_scenario: Array[Json]) => 
        Scr_ScenarioJsonStorage_scenario(id_scenario = id_scenario, jsonStorage_scenario = jsonStorage_scenario)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_ScenarioJsonStorage_scenario]] = 
                selectListRoot(columns = allColumns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS2(id_scenario: Long, jsonStorage_scenario: Array[Json]) => 
                        Scr_ScenarioJsonStorage_scenario(id_scenario = id_scenario, jsonStorage_scenario = jsonStorage_scenario)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_ScenarioJsonStorage_scenario] = 
                selectOneRoot(columns = allColumns, from = From(Scr_ScenarioTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS2(id_scenario: Long, jsonStorage_scenario: Array[Json])) => 
                ValidationEx(Success(Scr_ScenarioJsonStorage_scenario(id_scenario = id_scenario, jsonStorage_scenario = jsonStorage_scenario)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS2[Long, Array[Json]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = id_scenarioScr_ScenarioTbl ~ jsonStorage_scenarioScr_ScenarioTbl, 
                    values map
                        {
                        value =>
                            Insert(id_scenarioScr_ScenarioTbl, value _1) Insert(jsonStorage_scenarioScr_ScenarioTbl, value _2)
                    })
        }    
    
     def insertP(values: Scr_ScenarioJsonStorage_scenario*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = id_scenarioScr_ScenarioTbl ~ jsonStorage_scenarioScr_ScenarioTbl, 
                    values map
                        {
                        value =>
                            Insert(id_scenarioScr_ScenarioTbl, value.id_scenario) Insert(jsonStorage_scenarioScr_ScenarioTbl, value.jsonStorage_scenario)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Json]]*): List[Int] = {
        Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = id_scenarioScr_ScenarioTbl ~ jsonStorage_scenarioScr_ScenarioTbl, 
            values map
                {
                value =>
                    Insert(id_scenarioScr_ScenarioTbl, value _1) Insert(jsonStorage_scenarioScr_ScenarioTbl, value _2)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioJsonStorage_scenario*): List[Int] = {
        Scr_ScenarioTbl.insertWithoutCommit(connection = connection, columns = id_scenarioScr_ScenarioTbl ~ jsonStorage_scenarioScr_ScenarioTbl, 
            values map
                {
                value =>
                    Insert(id_scenarioScr_ScenarioTbl, value.id_scenario) Insert(jsonStorage_scenarioScr_ScenarioTbl, value.jsonStorage_scenario)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS2[Long, Array[Json]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(id_scenario, value _1) Set(jsonStorage_scenario, value _2), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
        }    
    
     def updateP(value: Scr_ScenarioJsonStorage_scenario, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(id_scenario, value.id_scenario) Set(jsonStorage_scenario, value.jsonStorage_scenario), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS2[Long, Array[Json]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(id_scenario, value _1) Set(jsonStorage_scenario, value _2), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Scr_ScenarioJsonStorage_scenario, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(id_scenario, value.id_scenario) Set(jsonStorage_scenario, value.jsonStorage_scenario), where = where, table = SQLTable(Scr_ScenarioTbl.databaseTablename))
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