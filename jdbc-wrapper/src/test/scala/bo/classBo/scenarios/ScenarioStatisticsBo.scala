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



 
object ScenarioStatisticsBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsBo(alias = alias)    
    
    val objectName = "ScenarioStatistics"    
    val groupName = "scenarios"
}


 
class ScenarioStatisticsBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ScenarioStatisticsBo]  {
//////////////////////////////////////// Class: ScenarioStatistics, group: scenarios ////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioStatisticsBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ScenarioStatisticsTbl = new ScenarioStatisticsTbl(alias = alias + "T0".als)    
    override val fromTable = ScenarioStatisticsTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val date = LocalDateTimeColumn(name = "DTDATE", nameInBo = "date", caption = "\u0414\u0430\u0442\u0430", tableColumn = ScenarioStatisticsTbl.date)    
    val in = LongColumn(name = "NIN", nameInBo = "in", caption = "\u041A\u043E\u043B-\u0432\u043E \u0432\u0445\u043E\u0434\u043E\u0432", tableColumn = ScenarioStatisticsTbl.in)    
    val out = LongColumn(name = "NOUT", nameInBo = "out", caption = "\u041A\u043E\u043B-\u0432\u043E \u0432\u044B\u0445\u043E\u0434\u043E\u0432", tableColumn = ScenarioStatisticsTbl.out)    
    val scenario = StringColumn(name = "SSCENARIO", nameInBo = "scenario", caption = "\u041A\u043E\u0434 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = ScenarioStatisticsTbl.scenario)    
    
    // For select tuple: (date: LocalDateTime, in: Long, out: Long, scenario: String)    
    
    type ColumnTypes =     TupleSS4[LocalDateTime, Long, Long, String]    
    val allColumns = date ~ in ~ out ~ scenario    
    val allColumns1 = Seq(date , in , out , scenario)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(scenario)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////// Table: ScenarioStatistics ////////////////////////////////////////////    
    val dateScenarioStatisticsTbl = ScenarioStatisticsTbl.date    
    val inScenarioStatisticsTbl = ScenarioStatisticsTbl.in    
    val outScenarioStatisticsTbl = ScenarioStatisticsTbl.out    
    val scenarioScenarioStatisticsTbl = ScenarioStatisticsTbl.scenario    
/////////////////////////////////////////// End Table: ScenarioStatistics ///////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ScenarioStatisticsTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioStatistics]] = 
        selectPIteratorRoot(columns = columns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS4(date: LocalDateTime, in: Long, out: Long, scenario: String) => 
        ScenarioStatistics(date = date, in = in, out = out, scenario = scenario)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioStatistics]] = 
                selectListRoot(columns = allColumns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS4(date: LocalDateTime, in: Long, out: Long, scenario: String) => 
                        ScenarioStatistics(date = date, in = in, out = out, scenario = scenario)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioStatistics] = 
                selectOneRoot(columns = allColumns, from = From(ScenarioStatisticsTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS4(date: LocalDateTime, in: Long, out: Long, scenario: String)) => 
                ValidationEx(Success(ScenarioStatistics(date = date, in = in, out = out, scenario = scenario)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS4[LocalDateTime, Long, Long, String]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ScenarioStatisticsTbl.insertWithoutCommit(connection = connection, columns = dateScenarioStatisticsTbl ~ inScenarioStatisticsTbl ~ outScenarioStatisticsTbl ~ scenarioScenarioStatisticsTbl, 
                    values map
                        {
                        value =>
                            Insert(dateScenarioStatisticsTbl, value _1) Insert(inScenarioStatisticsTbl, value _2) Insert(outScenarioStatisticsTbl, value _3) Insert(scenarioScenarioStatisticsTbl, value _4)
                    })
        }    
    
     def insertP(values: ScenarioStatistics*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ScenarioStatisticsTbl.insertWithoutCommit(connection = connection, columns = dateScenarioStatisticsTbl ~ inScenarioStatisticsTbl ~ outScenarioStatisticsTbl ~ scenarioScenarioStatisticsTbl, 
                    values map
                        {
                        value =>
                            Insert(dateScenarioStatisticsTbl, value.date) Insert(inScenarioStatisticsTbl, value.in) Insert(outScenarioStatisticsTbl, value.out) Insert(scenarioScenarioStatisticsTbl, value.scenario)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[LocalDateTime, Long, Long, String]*): List[Int] = {
        ScenarioStatisticsTbl.insertWithoutCommit(connection = connection, columns = dateScenarioStatisticsTbl ~ inScenarioStatisticsTbl ~ outScenarioStatisticsTbl ~ scenarioScenarioStatisticsTbl, 
            values map
                {
                value =>
                    Insert(dateScenarioStatisticsTbl, value _1) Insert(inScenarioStatisticsTbl, value _2) Insert(outScenarioStatisticsTbl, value _3) Insert(scenarioScenarioStatisticsTbl, value _4)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: ScenarioStatistics*): List[Int] = {
        ScenarioStatisticsTbl.insertWithoutCommit(connection = connection, columns = dateScenarioStatisticsTbl ~ inScenarioStatisticsTbl ~ outScenarioStatisticsTbl ~ scenarioScenarioStatisticsTbl, 
            values map
                {
                value =>
                    Insert(dateScenarioStatisticsTbl, value.date) Insert(inScenarioStatisticsTbl, value.in) Insert(outScenarioStatisticsTbl, value.out) Insert(scenarioScenarioStatisticsTbl, value.scenario)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS4[LocalDateTime, Long, Long, String], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(date, value _1) Set(in, value _2) Set(out, value _3) Set(scenario, value _4), where = where, table = SQLTable(ScenarioStatisticsTbl.databaseTablename))
        }    
    
     def updateP(value: ScenarioStatistics, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(date, value.date) Set(in, value.in) Set(out, value.out) Set(scenario, value.scenario), where = where, table = SQLTable(ScenarioStatisticsTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS4[LocalDateTime, Long, Long, String], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(date, value _1) Set(in, value _2) Set(out, value _3) Set(scenario, value _4), where = where, table = SQLTable(ScenarioStatisticsTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: ScenarioStatistics, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(date, value.date) Set(in, value.in) Set(out, value.out) Set(scenario, value.scenario), where = where, table = SQLTable(ScenarioStatisticsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioStatisticsTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioStatisticsTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}