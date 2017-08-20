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



 
object ScenarioTrace_DebugBo {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioTrace_DebugBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioTrace_DebugBo(alias = alias)    
    
    val objectName = "ScenarioTrace_Debug"    
    val groupName = "scenarios"
}


 
class ScenarioTrace_DebugBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[ScenarioTrace_DebugBo]  {
/////////////////////////////////////// Class: ScenarioTrace_Debug, group: scenarios ///////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioTrace_DebugBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val ScenarioTrace_DebugTbl = new ScenarioTrace_DebugTbl(alias = alias + "T0".als)    
    override val fromTable = ScenarioTrace_DebugTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val actionmessage = StringOptionColumn(name = "SACTIONMESSAGE", nameInBo = "actionmessage", caption = "\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0439 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438", tableColumn = ScenarioTrace_DebugTbl.actionmessageOption)    
    val actionobject = StringOptionColumn(name = "SACTIONOBJECT", nameInBo = "actionobject", caption = "\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u043E\u0431\u044A\u0435\u043A\u0442", tableColumn = ScenarioTrace_DebugTbl.actionobjectOption)    
    val actiontype = StringOptionColumn(name = "SACTIONTYPE", nameInBo = "actiontype", caption = "\u0414\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u0430\u044F \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F", tableColumn = ScenarioTrace_DebugTbl.actiontypeOption)    
    val address = StringColumn(name = "SADDRESS", nameInBo = "address", caption = "\u041D\u043E\u043C\u0435\u0440 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430", tableColumn = ScenarioTrace_DebugTbl.address)    
    val bonusbase = DoubleOptionColumn(name = "FBONUSBASE", nameInBo = "bonusbase", caption = "\u0427\u0438\u0441\u043B\u043E\u0432\u043E\u0435 \u043F\u043E\u043B\u0435", tableColumn = ScenarioTrace_DebugTbl.bonusbaseOption)    
    val bonusmessage = StringOptionColumn(name = "SBONUSMESSAGE", nameInBo = "bonusmessage", caption = "C\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435 \u043E \u0431\u043E\u043D\u0443\u0441\u0435", tableColumn = ScenarioTrace_DebugTbl.bonusmessageOption)    
    val event = StringColumn(name = "SEVENT", nameInBo = "event", caption = "\u0421\u043E\u0431\u044B\u0442\u0438\u0435", tableColumn = ScenarioTrace_DebugTbl.event)    
    val id = LongColumn(name = "ID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = ScenarioTrace_DebugTbl.id)    
    val idactionmessage = LongOptionColumn(name = "IDIDACTIONMESSAGE", nameInBo = "idactionmessage", caption = "ID \u0434\u043E\u043F\u043E\u043B\u043D\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0439 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438", tableColumn = ScenarioTrace_DebugTbl.idactionmessageOption)    
    val idbonusmessage = LongOptionColumn(name = "IDIDBONUSMESSAGE", nameInBo = "idbonusmessage", caption = "ID \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F \u043E \u0431\u043E\u043D\u0443\u0441\u0435", tableColumn = ScenarioTrace_DebugTbl.idbonusmessageOption)    
    val idmarketingmessage = LongOptionColumn(name = "IDIDMARKETINGMESSAGE", nameInBo = "idmarketingmessage", caption = "ID \u043C\u0430\u0440\u043A\u0435\u0442\u0438\u043D\u0433\u043E\u0432\u043E\u0433\u043E \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = ScenarioTrace_DebugTbl.idmarketingmessageOption)    
    val marketingmessage = StringOptionColumn(name = "SMARKETINGMESSAGE", nameInBo = "marketingmessage", caption = "\u0422\u0435\u043A\u0441\u0442\u043E\u0432\u043E\u0435 \u043F\u043E\u043B\u0435", tableColumn = ScenarioTrace_DebugTbl.marketingmessageOption)    
    val parentstage = StringOptionColumn(name = "SPARENTSTAGE", nameInBo = "parentstage", caption = "\u041F\u0440\u0435\u0434\u044B\u0434\u0443\u0449\u0438\u0439 \u044D\u0442\u0430\u043F \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = ScenarioTrace_DebugTbl.parentstageOption)    
    val scenario = StringColumn(name = "SSCENARIO", nameInBo = "scenario", caption = "\u0421\u0446\u0435\u043D\u0430\u0440\u0438\u0439", tableColumn = ScenarioTrace_DebugTbl.scenario)    
    val stage = StringColumn(name = "SSTAGE", nameInBo = "stage", caption = "\u042D\u0442\u0430\u043F \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = ScenarioTrace_DebugTbl.stage)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "\u0412\u0440\u0435\u043C\u044F \u043D\u0430\u0441\u0442\u0443\u043F\u043B\u0435\u043D\u0438\u044F \u0441\u043E\u0431\u044B\u0442\u0438\u044F", tableColumn = ScenarioTrace_DebugTbl.timestamp)    
    
    // For select tuple: (actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]    
    val allColumns = actionmessage ~ actionobject ~ actiontype ~ address ~ bonusbase ~ bonusmessage ~ event ~ id ~ idactionmessage ~ idbonusmessage ~ idmarketingmessage ~ marketingmessage ~ parentstage ~ scenario ~ stage ~ timestamp    
    val allColumns1 = Seq(actionmessage , actionobject , actiontype , address , bonusbase , bonusmessage , event , id , idactionmessage , idbonusmessage , idmarketingmessage , marketingmessage , parentstage , scenario , stage , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////// Table: ScenarioTrace_Debug ////////////////////////////////////////////    
    val actionmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.actionmessageOption    
    val actionobjectScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.actionobjectOption    
    val actiontypeScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.actiontypeOption    
    val addressScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.address    
    val bonusbaseScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.bonusbaseOption    
    val bonusmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.bonusmessageOption    
    val eventScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.event    
    val idScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.id    
    val idactionmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.idactionmessageOption    
    val idbonusmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.idbonusmessageOption    
    val idmarketingmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.idmarketingmessageOption    
    val marketingmessageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.marketingmessageOption    
    val parentstageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.parentstageOption    
    val scenarioScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.scenario    
    val stageScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.stage    
    val timestampScenarioTrace_DebugTbl = ScenarioTrace_DebugTbl.timestamp    
/////////////////////////////////////////// End Table: ScenarioTrace_Debug ///////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(ScenarioTrace_DebugTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioTrace_Debug]] = 
        selectPIteratorRoot(columns = columns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime) => 
        ScenarioTrace_Debug(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioTrace_Debug]] = 
                selectListRoot(columns = allColumns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime) => 
                        ScenarioTrace_Debug(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioTrace_Debug] = 
                selectOneRoot(columns = allColumns, from = From(ScenarioTrace_DebugTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS16(actionmessage: Array[String], actionobject: Array[String], actiontype: Array[String], address: String, bonusbase: Array[Double], bonusmessage: Array[String], event: String, id: Long, idactionmessage: Array[Long], idbonusmessage: Array[Long], idmarketingmessage: Array[Long], marketingmessage: Array[String], parentstage: Array[String], scenario: String, stage: String, timestamp: LocalDateTime)) => 
                ValidationEx(Success(ScenarioTrace_Debug(actionmessage = actionmessage, actionobject = actionobject, actiontype = actiontype, address = address, bonusbase = bonusbase, bonusmessage = bonusmessage, event = event, id = id, idactionmessage = idactionmessage, idbonusmessage = idbonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, parentstage = parentstage, scenario = scenario, stage = stage, timestamp = timestamp)))
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
                ScenarioTrace_DebugTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTrace_DebugTbl ~ actionobjectScenarioTrace_DebugTbl ~ actiontypeScenarioTrace_DebugTbl ~ addressScenarioTrace_DebugTbl ~ bonusbaseScenarioTrace_DebugTbl ~ bonusmessageScenarioTrace_DebugTbl ~ eventScenarioTrace_DebugTbl ~ idScenarioTrace_DebugTbl ~ idactionmessageScenarioTrace_DebugTbl ~ idbonusmessageScenarioTrace_DebugTbl ~ idmarketingmessageScenarioTrace_DebugTbl ~ marketingmessageScenarioTrace_DebugTbl ~ parentstageScenarioTrace_DebugTbl ~ scenarioScenarioTrace_DebugTbl ~ stageScenarioTrace_DebugTbl ~ timestampScenarioTrace_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(actionmessageScenarioTrace_DebugTbl, value _1) Insert(actionobjectScenarioTrace_DebugTbl, value _2) Insert(actiontypeScenarioTrace_DebugTbl, value _3) Insert(addressScenarioTrace_DebugTbl, value _4) Insert(bonusbaseScenarioTrace_DebugTbl, value _5) Insert(bonusmessageScenarioTrace_DebugTbl, value _6) Insert(eventScenarioTrace_DebugTbl, value _7) Insert(idScenarioTrace_DebugTbl, value _8) Insert(idactionmessageScenarioTrace_DebugTbl, value _9) Insert(idbonusmessageScenarioTrace_DebugTbl, value _10) Insert(idmarketingmessageScenarioTrace_DebugTbl, value _11) Insert(marketingmessageScenarioTrace_DebugTbl, value _12) Insert(parentstageScenarioTrace_DebugTbl, value _13) Insert(scenarioScenarioTrace_DebugTbl, value _14) Insert(stageScenarioTrace_DebugTbl, value _15) Insert(timestampScenarioTrace_DebugTbl, value _16)
                    })
        }    
    
     def insertP(values: ScenarioTrace_Debug*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                ScenarioTrace_DebugTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTrace_DebugTbl ~ actionobjectScenarioTrace_DebugTbl ~ actiontypeScenarioTrace_DebugTbl ~ addressScenarioTrace_DebugTbl ~ bonusbaseScenarioTrace_DebugTbl ~ bonusmessageScenarioTrace_DebugTbl ~ eventScenarioTrace_DebugTbl ~ idScenarioTrace_DebugTbl ~ idactionmessageScenarioTrace_DebugTbl ~ idbonusmessageScenarioTrace_DebugTbl ~ idmarketingmessageScenarioTrace_DebugTbl ~ marketingmessageScenarioTrace_DebugTbl ~ parentstageScenarioTrace_DebugTbl ~ scenarioScenarioTrace_DebugTbl ~ stageScenarioTrace_DebugTbl ~ timestampScenarioTrace_DebugTbl, 
                    values map
                        {
                        value =>
                            Insert(actionmessageScenarioTrace_DebugTbl, value.actionmessage) Insert(actionobjectScenarioTrace_DebugTbl, value.actionobject) Insert(actiontypeScenarioTrace_DebugTbl, value.actiontype) Insert(addressScenarioTrace_DebugTbl, value.address) Insert(bonusbaseScenarioTrace_DebugTbl, value.bonusbase) Insert(bonusmessageScenarioTrace_DebugTbl, value.bonusmessage) Insert(eventScenarioTrace_DebugTbl, value.event) Insert(idScenarioTrace_DebugTbl, value.id) Insert(idactionmessageScenarioTrace_DebugTbl, value.idactionmessage) Insert(idbonusmessageScenarioTrace_DebugTbl, value.idbonusmessage) Insert(idmarketingmessageScenarioTrace_DebugTbl, value.idmarketingmessage) Insert(marketingmessageScenarioTrace_DebugTbl, value.marketingmessage) Insert(parentstageScenarioTrace_DebugTbl, value.parentstage) Insert(scenarioScenarioTrace_DebugTbl, value.scenario) Insert(stageScenarioTrace_DebugTbl, value.stage) Insert(timestampScenarioTrace_DebugTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): List[Int] = {
        ScenarioTrace_DebugTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTrace_DebugTbl ~ actionobjectScenarioTrace_DebugTbl ~ actiontypeScenarioTrace_DebugTbl ~ addressScenarioTrace_DebugTbl ~ bonusbaseScenarioTrace_DebugTbl ~ bonusmessageScenarioTrace_DebugTbl ~ eventScenarioTrace_DebugTbl ~ idScenarioTrace_DebugTbl ~ idactionmessageScenarioTrace_DebugTbl ~ idbonusmessageScenarioTrace_DebugTbl ~ idmarketingmessageScenarioTrace_DebugTbl ~ marketingmessageScenarioTrace_DebugTbl ~ parentstageScenarioTrace_DebugTbl ~ scenarioScenarioTrace_DebugTbl ~ stageScenarioTrace_DebugTbl ~ timestampScenarioTrace_DebugTbl, 
            values map
                {
                value =>
                    Insert(actionmessageScenarioTrace_DebugTbl, value _1) Insert(actionobjectScenarioTrace_DebugTbl, value _2) Insert(actiontypeScenarioTrace_DebugTbl, value _3) Insert(addressScenarioTrace_DebugTbl, value _4) Insert(bonusbaseScenarioTrace_DebugTbl, value _5) Insert(bonusmessageScenarioTrace_DebugTbl, value _6) Insert(eventScenarioTrace_DebugTbl, value _7) Insert(idScenarioTrace_DebugTbl, value _8) Insert(idactionmessageScenarioTrace_DebugTbl, value _9) Insert(idbonusmessageScenarioTrace_DebugTbl, value _10) Insert(idmarketingmessageScenarioTrace_DebugTbl, value _11) Insert(marketingmessageScenarioTrace_DebugTbl, value _12) Insert(parentstageScenarioTrace_DebugTbl, value _13) Insert(scenarioScenarioTrace_DebugTbl, value _14) Insert(stageScenarioTrace_DebugTbl, value _15) Insert(timestampScenarioTrace_DebugTbl, value _16)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: ScenarioTrace_Debug*): List[Int] = {
        ScenarioTrace_DebugTbl.insertWithoutCommit(connection = connection, columns = actionmessageScenarioTrace_DebugTbl ~ actionobjectScenarioTrace_DebugTbl ~ actiontypeScenarioTrace_DebugTbl ~ addressScenarioTrace_DebugTbl ~ bonusbaseScenarioTrace_DebugTbl ~ bonusmessageScenarioTrace_DebugTbl ~ eventScenarioTrace_DebugTbl ~ idScenarioTrace_DebugTbl ~ idactionmessageScenarioTrace_DebugTbl ~ idbonusmessageScenarioTrace_DebugTbl ~ idmarketingmessageScenarioTrace_DebugTbl ~ marketingmessageScenarioTrace_DebugTbl ~ parentstageScenarioTrace_DebugTbl ~ scenarioScenarioTrace_DebugTbl ~ stageScenarioTrace_DebugTbl ~ timestampScenarioTrace_DebugTbl, 
            values map
                {
                value =>
                    Insert(actionmessageScenarioTrace_DebugTbl, value.actionmessage) Insert(actionobjectScenarioTrace_DebugTbl, value.actionobject) Insert(actiontypeScenarioTrace_DebugTbl, value.actiontype) Insert(addressScenarioTrace_DebugTbl, value.address) Insert(bonusbaseScenarioTrace_DebugTbl, value.bonusbase) Insert(bonusmessageScenarioTrace_DebugTbl, value.bonusmessage) Insert(eventScenarioTrace_DebugTbl, value.event) Insert(idScenarioTrace_DebugTbl, value.id) Insert(idactionmessageScenarioTrace_DebugTbl, value.idactionmessage) Insert(idbonusmessageScenarioTrace_DebugTbl, value.idbonusmessage) Insert(idmarketingmessageScenarioTrace_DebugTbl, value.idmarketingmessage) Insert(marketingmessageScenarioTrace_DebugTbl, value.marketingmessage) Insert(parentstageScenarioTrace_DebugTbl, value.parentstage) Insert(scenarioScenarioTrace_DebugTbl, value.scenario) Insert(stageScenarioTrace_DebugTbl, value.stage) Insert(timestampScenarioTrace_DebugTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(actionmessage, value _1) Set(actionobject, value _2) Set(actiontype, value _3) Set(address, value _4) Set(bonusbase, value _5) Set(bonusmessage, value _6) Set(event, value _7) Set(id, value _8) Set(idactionmessage, value _9) Set(idbonusmessage, value _10) Set(idmarketingmessage, value _11) Set(marketingmessage, value _12) Set(parentstage, value _13) Set(scenario, value _14) Set(stage, value _15) Set(timestamp, value _16), where = where, table = SQLTable(ScenarioTrace_DebugTbl.databaseTablename))
        }    
    
     def updateP(value: ScenarioTrace_Debug, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(actionmessage, value.actionmessage) Set(actionobject, value.actionobject) Set(actiontype, value.actiontype) Set(address, value.address) Set(bonusbase, value.bonusbase) Set(bonusmessage, value.bonusmessage) Set(event, value.event) Set(id, value.id) Set(idactionmessage, value.idactionmessage) Set(idbonusmessage, value.idbonusmessage) Set(idmarketingmessage, value.idmarketingmessage) Set(marketingmessage, value.marketingmessage) Set(parentstage, value.parentstage) Set(scenario, value.scenario) Set(stage, value.stage) Set(timestamp, value.timestamp), where = where, table = SQLTable(ScenarioTrace_DebugTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(actionmessage, value _1) Set(actionobject, value _2) Set(actiontype, value _3) Set(address, value _4) Set(bonusbase, value _5) Set(bonusmessage, value _6) Set(event, value _7) Set(id, value _8) Set(idactionmessage, value _9) Set(idbonusmessage, value _10) Set(idmarketingmessage, value _11) Set(marketingmessage, value _12) Set(parentstage, value _13) Set(scenario, value _14) Set(stage, value _15) Set(timestamp, value _16), where = where, table = SQLTable(ScenarioTrace_DebugTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: ScenarioTrace_Debug, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(actionmessage, value.actionmessage) Set(actionobject, value.actionobject) Set(actiontype, value.actiontype) Set(address, value.address) Set(bonusbase, value.bonusbase) Set(bonusmessage, value.bonusmessage) Set(event, value.event) Set(id, value.id) Set(idactionmessage, value.idactionmessage) Set(idbonusmessage, value.idbonusmessage) Set(idmarketingmessage, value.idmarketingmessage) Set(marketingmessage, value.marketingmessage) Set(parentstage, value.parentstage) Set(scenario, value.scenario) Set(stage, value.stage) Set(timestamp, value.timestamp), where = where, table = SQLTable(ScenarioTrace_DebugTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioTrace_DebugTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = ScenarioTrace_DebugTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}