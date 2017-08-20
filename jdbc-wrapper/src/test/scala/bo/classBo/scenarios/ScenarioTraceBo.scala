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



 
object ScenarioTraceBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioTraceBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioTraceBo(alias = alias)    
    
    val objectName = "ScenarioTrace"    
    val groupName = "scenarios"
}


 
class ScenarioTraceBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ScenarioTraceBo]  {
///////////////////////////////////////// Class: ScenarioTrace, group: scenarios /////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioTraceBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ScenarioTraceTbl = new ScenarioTraceTbl(alias = alias + "T0".als)    
    override val fromTable = ScenarioTraceTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val actionmessage = StringOptionColumn(name = "SACTIONMESSAGE", nameInBo = "actionmessage", caption = "\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0439 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438", tableColumn = ScenarioTraceTbl.actionmessageOption)    
    val actionobject = StringOptionColumn(name = "SACTIONOBJECT", nameInBo = "actionobject", caption = "\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u043E\u0431\u044A\u0435\u043A\u0442", tableColumn = ScenarioTraceTbl.actionobjectOption)    
    val actiontype = StringOptionColumn(name = "SACTIONTYPE", nameInBo = "actiontype", caption = "\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u0430\u044F \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F", tableColumn = ScenarioTraceTbl.actiontypeOption)    
    val address = StringColumn(name = "SADDRESS", nameInBo = "address", caption = "\u041D\u043E\u043C\u0435\u0440 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430", tableColumn = ScenarioTraceTbl.address)    
    val bonusbase = DoubleOptionColumn(name = "FBONUSBASE", nameInBo = "bonusbase", caption = "\u0427\u0438\u0441\u043B\u043E\u0432\u043E\u0435 \u043F\u043E\u043B\u0435", tableColumn = ScenarioTraceTbl.bonusbaseOption)    
    val bonusmessage = StringOptionColumn(name = "SBONUSMESSAGE", nameInBo = "bonusmessage", caption = "C\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u043E \u0431\u043E\u043D\u0443\u0441\u0435", tableColumn = ScenarioTraceTbl.bonusmessageOption)    
    val event = StringColumn(name = "SEVENT", nameInBo = "event", caption = "\u0421\u043E\u0431\u044B\u0442\u0438\u0435", tableColumn = ScenarioTraceTbl.event)    
    val id = LongColumn(name = "ID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = ScenarioTraceTbl.id)    
    val idactionmessage = LongOptionColumn(name = "IDIDACTIONMESSAGE", nameInBo = "idactionmessage", caption = "ID \u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0439 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438", tableColumn = ScenarioTraceTbl.idactionmessageOption)    
    val idbonusmessage = LongOptionColumn(name = "IDIDBONUSMESSAGE", nameInBo = "idbonusmessage", caption = "ID \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F \u043E \u0431\u043E\u043D\u0443\u0441\u0435", tableColumn = ScenarioTraceTbl.idbonusmessageOption)    
    val idmarketingmessage = LongOptionColumn(name = "IDIDMARKETINGMESSAGE", nameInBo = "idmarketingmessage", caption = "ID \u043C\u0430\u0440\u043A\u0435\u0442\u0438\u043D\u0433\u043E\u0432\u043E\u0433\u043E \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = ScenarioTraceTbl.idmarketingmessageOption)    
    val marketingmessage = StringOptionColumn(name = "SMARKETINGMESSAGE", nameInBo = "marketingmessage", caption = "\u0422\u0435\u043A\u0441\u0442\u043E\u0432\u043E\u0435 \u043F\u043E\u043B\u0435", tableColumn = ScenarioTraceTbl.marketingmessageOption)    
    val parentstage = StringOptionColumn(name = "SPARENTSTAGE", nameInBo = "parentstage", caption = "\u041F\u0440\u0435\u0434\u044B\u0434\u0443\u0449\u0438\u0439 \u044D\u0442\u0430\u043F \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = ScenarioTraceTbl.parentstageOption)    
    val scenario = StringColumn(name = "SSCENARIO", nameInBo = "scenario", caption = "\u0421\u0446\u0435\u043D\u0430\u0440\u0438\u0439", tableColumn = ScenarioTraceTbl.scenario)    
    val stage = StringColumn(name = "SSTAGE", nameInBo = "stage", caption = "\u042D\u0442\u0430\u043F \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = ScenarioTraceTbl.stage)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "\u0412\u0440\u0435\u043C\u044F \u043D\u0430\u0441\u0442\u0443\u043F\u043B\u0435\u043D\u0438\u044F \u0441\u043E\u0431\u044B\u0442\u0438\u044F", tableColumn = ScenarioTraceTbl.timestamp)    
    
    // For select tuple: (actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]    
    val allColumns = actionmessage ~ actionobject ~ actiontype ~ address ~ bonusbase ~ bonusmessage ~ event ~ id ~ idactionmessage ~ idbonusmessage ~ idmarketingmessage ~ marketingmessage ~ parentstage ~ scenario ~ stage ~ timestamp    
    val allColumns1 = Seq(actionmessage , actionobject , actiontype , address , bonusbase , bonusmessage , event , id , idactionmessage , idbonusmessage , idmarketingmessage , marketingmessage , parentstage , scenario , stage , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
///////////////////////////////////////////// Table: ScenarioTrace /////////////////////////////////////////////    
    val actionmessageScenarioTraceTbl = ScenarioTraceTbl.actionmessageOption    
    val actionobjectScenarioTraceTbl = ScenarioTraceTbl.actionobjectOption    
    val actiontypeScenarioTraceTbl = ScenarioTraceTbl.actiontypeOption    
    val addressScenarioTraceTbl = ScenarioTraceTbl.address    
    val bonusbaseScenarioTraceTbl = ScenarioTraceTbl.bonusbaseOption    
    val bonusmessageScenarioTraceTbl = ScenarioTraceTbl.bonusmessageOption    
    val eventScenarioTraceTbl = ScenarioTraceTbl.event    
    val idScenarioTraceTbl = ScenarioTraceTbl.id    
    val idactionmessageScenarioTraceTbl = ScenarioTraceTbl.idactionmessageOption    
    val idbonusmessageScenarioTraceTbl = ScenarioTraceTbl.idbonusmessageOption    
    val idmarketingmessageScenarioTraceTbl = ScenarioTraceTbl.idmarketingmessageOption    
    val marketingmessageScenarioTraceTbl = ScenarioTraceTbl.marketingmessageOption    
    val parentstageScenarioTraceTbl = ScenarioTraceTbl.parentstageOption    
    val scenarioScenarioTraceTbl = ScenarioTraceTbl.scenario    
    val stageScenarioTraceTbl = ScenarioTraceTbl.stage    
    val timestampScenarioTraceTbl = ScenarioTraceTbl.timestamp    
//////////////////////////////////////////// End Table: ScenarioTrace ////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ScenarioTraceTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioTrace]] = 
        selectPIteratorRoot(columns = columns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime) => 
        ScenarioTrace(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioTrace]] = 
                selectListRoot(columns = allColumns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime) => 
                        ScenarioTrace(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioTrace] = 
                selectOneRoot(columns = allColumns, from = From(ScenarioTraceTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime)) => 
                ValidationEx(Success(ScenarioTrace(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ScenarioTraceTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTraceTbl ~ actionobjectScenarioTraceTbl ~ actiontypeScenarioTraceTbl ~ addressScenarioTraceTbl ~ bonusbaseScenarioTraceTbl ~ bonusmessageScenarioTraceTbl ~ eventScenarioTraceTbl ~ idScenarioTraceTbl ~ idactionmessageScenarioTraceTbl ~ idbonusmessageScenarioTraceTbl ~ idmarketingmessageScenarioTraceTbl ~ marketingmessageScenarioTraceTbl ~ parentstageScenarioTraceTbl ~ scenarioScenarioTraceTbl ~ stageScenarioTraceTbl ~ timestampScenarioTraceTbl, 
                    values map
                        {
                        value =>
                            Insert(actionmessageScenarioTraceTbl, value _1) Insert(actionobjectScenarioTraceTbl, value _2) Insert(actiontypeScenarioTraceTbl, value _3) Insert(addressScenarioTraceTbl, value _4) Insert(bonusbaseScenarioTraceTbl, value _5) Insert(bonusmessageScenarioTraceTbl, value _6) Insert(eventScenarioTraceTbl, value _7) Insert(idScenarioTraceTbl, value _8) Insert(idactionmessageScenarioTraceTbl, value _9) Insert(idbonusmessageScenarioTraceTbl, value _10) Insert(idmarketingmessageScenarioTraceTbl, value _11) Insert(marketingmessageScenarioTraceTbl, value _12) Insert(parentstageScenarioTraceTbl, value _13) Insert(scenarioScenarioTraceTbl, value _14) Insert(stageScenarioTraceTbl, value _15) Insert(timestampScenarioTraceTbl, value _16)
                    })
        }    
    
     def insertP(values: ScenarioTrace*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ScenarioTraceTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTraceTbl ~ actionobjectScenarioTraceTbl ~ actiontypeScenarioTraceTbl ~ addressScenarioTraceTbl ~ bonusbaseScenarioTraceTbl ~ bonusmessageScenarioTraceTbl ~ eventScenarioTraceTbl ~ idScenarioTraceTbl ~ idactionmessageScenarioTraceTbl ~ idbonusmessageScenarioTraceTbl ~ idmarketingmessageScenarioTraceTbl ~ marketingmessageScenarioTraceTbl ~ parentstageScenarioTraceTbl ~ scenarioScenarioTraceTbl ~ stageScenarioTraceTbl ~ timestampScenarioTraceTbl, 
                    values map
                        {
                        value =>
                            Insert(actionmessageScenarioTraceTbl, value.actionmessage) Insert(actionobjectScenarioTraceTbl, value.actionobject) Insert(actiontypeScenarioTraceTbl, value.actiontype) Insert(addressScenarioTraceTbl, value.address) Insert(bonusbaseScenarioTraceTbl, value.bonusbase) Insert(bonusmessageScenarioTraceTbl, value.bonusmessage) Insert(eventScenarioTraceTbl, value.event) Insert(idScenarioTraceTbl, value.id) Insert(idactionmessageScenarioTraceTbl, value.idactionmessage) Insert(idbonusmessageScenarioTraceTbl, value.idbonusmessage) Insert(idmarketingmessageScenarioTraceTbl, value.idmarketingmessage) Insert(marketingmessageScenarioTraceTbl, value.marketingmessage) Insert(parentstageScenarioTraceTbl, value.parentstage) Insert(scenarioScenarioTraceTbl, value.scenario) Insert(stageScenarioTraceTbl, value.stage) Insert(timestampScenarioTraceTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): List[Int] = {
        ScenarioTraceTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTraceTbl ~ actionobjectScenarioTraceTbl ~ actiontypeScenarioTraceTbl ~ addressScenarioTraceTbl ~ bonusbaseScenarioTraceTbl ~ bonusmessageScenarioTraceTbl ~ eventScenarioTraceTbl ~ idScenarioTraceTbl ~ idactionmessageScenarioTraceTbl ~ idbonusmessageScenarioTraceTbl ~ idmarketingmessageScenarioTraceTbl ~ marketingmessageScenarioTraceTbl ~ parentstageScenarioTraceTbl ~ scenarioScenarioTraceTbl ~ stageScenarioTraceTbl ~ timestampScenarioTraceTbl, 
            values map
                {
                value =>
                    Insert(actionmessageScenarioTraceTbl, value _1) Insert(actionobjectScenarioTraceTbl, value _2) Insert(actiontypeScenarioTraceTbl, value _3) Insert(addressScenarioTraceTbl, value _4) Insert(bonusbaseScenarioTraceTbl, value _5) Insert(bonusmessageScenarioTraceTbl, value _6) Insert(eventScenarioTraceTbl, value _7) Insert(idScenarioTraceTbl, value _8) Insert(idactionmessageScenarioTraceTbl, value _9) Insert(idbonusmessageScenarioTraceTbl, value _10) Insert(idmarketingmessageScenarioTraceTbl, value _11) Insert(marketingmessageScenarioTraceTbl, value _12) Insert(parentstageScenarioTraceTbl, value _13) Insert(scenarioScenarioTraceTbl, value _14) Insert(stageScenarioTraceTbl, value _15) Insert(timestampScenarioTraceTbl, value _16)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: ScenarioTrace*): List[Int] = {
        ScenarioTraceTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTraceTbl ~ actionobjectScenarioTraceTbl ~ actiontypeScenarioTraceTbl ~ addressScenarioTraceTbl ~ bonusbaseScenarioTraceTbl ~ bonusmessageScenarioTraceTbl ~ eventScenarioTraceTbl ~ idScenarioTraceTbl ~ idactionmessageScenarioTraceTbl ~ idbonusmessageScenarioTraceTbl ~ idmarketingmessageScenarioTraceTbl ~ marketingmessageScenarioTraceTbl ~ parentstageScenarioTraceTbl ~ scenarioScenarioTraceTbl ~ stageScenarioTraceTbl ~ timestampScenarioTraceTbl, 
            values map
                {
                value =>
                    Insert(actionmessageScenarioTraceTbl, value.actionmessage) Insert(actionobjectScenarioTraceTbl, value.actionobject) Insert(actiontypeScenarioTraceTbl, value.actiontype) Insert(addressScenarioTraceTbl, value.address) Insert(bonusbaseScenarioTraceTbl, value.bonusbase) Insert(bonusmessageScenarioTraceTbl, value.bonusmessage) Insert(eventScenarioTraceTbl, value.event) Insert(idScenarioTraceTbl, value.id) Insert(idactionmessageScenarioTraceTbl, value.idactionmessage) Insert(idbonusmessageScenarioTraceTbl, value.idbonusmessage) Insert(idmarketingmessageScenarioTraceTbl, value.idmarketingmessage) Insert(marketingmessageScenarioTraceTbl, value.marketingmessage) Insert(parentstageScenarioTraceTbl, value.parentstage) Insert(scenarioScenarioTraceTbl, value.scenario) Insert(stageScenarioTraceTbl, value.stage) Insert(timestampScenarioTraceTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(actionmessage, value _1) Set(actionobject, value _2) Set(actiontype, value _3) Set(address, value _4) Set(bonusbase, value _5) Set(bonusmessage, value _6) Set(event, value _7) Set(id, value _8) Set(idactionmessage, value _9) Set(idbonusmessage, value _10) Set(idmarketingmessage, value _11) Set(marketingmessage, value _12) Set(parentstage, value _13) Set(scenario, value _14) Set(stage, value _15) Set(timestamp, value _16), where = where, table = SQLTable(ScenarioTraceTbl.databaseTablename))
        }    
    
     def updateP(value: ScenarioTrace, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(actionmessage, value.actionmessage) Set(actionobject, value.actionobject) Set(actiontype, value.actiontype) Set(address, value.address) Set(bonusbase, value.bonusbase) Set(bonusmessage, value.bonusmessage) Set(event, value.event) Set(id, value.id) Set(idactionmessage, value.idactionmessage) Set(idbonusmessage, value.idbonusmessage) Set(idmarketingmessage, value.idmarketingmessage) Set(marketingmessage, value.marketingmessage) Set(parentstage, value.parentstage) Set(scenario, value.scenario) Set(stage, value.stage) Set(timestamp, value.timestamp), where = where, table = SQLTable(ScenarioTraceTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(actionmessage, value _1) Set(actionobject, value _2) Set(actiontype, value _3) Set(address, value _4) Set(bonusbase, value _5) Set(bonusmessage, value _6) Set(event, value _7) Set(id, value _8) Set(idactionmessage, value _9) Set(idbonusmessage, value _10) Set(idmarketingmessage, value _11) Set(marketingmessage, value _12) Set(parentstage, value _13) Set(scenario, value _14) Set(stage, value _15) Set(timestamp, value _16), where = where, table = SQLTable(ScenarioTraceTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: ScenarioTrace, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(actionmessage, value.actionmessage) Set(actionobject, value.actionobject) Set(actiontype, value.actiontype) Set(address, value.address) Set(bonusbase, value.bonusbase) Set(bonusmessage, value.bonusmessage) Set(event, value.event) Set(id, value.id) Set(idactionmessage, value.idactionmessage) Set(idbonusmessage, value.idbonusmessage) Set(idmarketingmessage, value.idmarketingmessage) Set(marketingmessage, value.marketingmessage) Set(parentstage, value.parentstage) Set(scenario, value.scenario) Set(stage, value.stage) Set(timestamp, value.timestamp), where = where, table = SQLTable(ScenarioTraceTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioTraceTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioTraceTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}