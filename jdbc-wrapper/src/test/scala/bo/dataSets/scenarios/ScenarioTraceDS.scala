// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenDSs"

package ru.simplesys.defs.bo
package scenarios

import com.simplesys.jdbc.control.dataSet.DataSet
import com.simplesys.jdbc.control.ValidationEx
import java.sql.Connection
import org.joda.time.{LocalDateTime, DateTime}
import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.SQL._
import com.simplesys.jdbc._
import com.simplesys.SQL.Gen.{SQLAbsTable, SQLAlias}
import com.simplesys.common.Strings._
import com.simplesys.jdbc.control.classBO.{OrderBy, WheresList, FromBo, LeftJoin}
import com.simplesys.jdbc.control.classBO.JoinsBo._
import com.simplesys.jdbc.control.SuperTuple1.FieldProduct
import collection.SeqView
import scalaz.{Failure, Success}
import scalaz.Validation._
import com.simplesys.jdbc.control.clob._
import com.simplesys.tuple._
import com.simplesys.jdbc.control._



 
case class ScenarioTraceDSData(actionmessageScenarioTrace: Array[String], actionobjectScenarioTrace: Array[String], actiontypeScenarioTrace: Array[String], addressScenarioTrace: String, bonusbaseScenarioTrace: Array[Double], bonusmessageScenarioTrace: Array[String], eventScenarioTrace: String, idScenarioTrace: Long, idactionmessageScenarioTrace: Array[Long], idbonusmessageScenarioTrace: Array[Long], idmarketingmessageScenarioTrace: Array[Long], marketingmessageScenarioTrace: Array[String], parentstageScenarioTrace: Array[String], scenarioScenarioTrace: String, stageScenarioTrace: String, timestampScenarioTrace: LocalDateTime) {

}


 
object ScenarioTraceDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioTraceDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioTraceDS    
    
    val objectName = "ScenarioTrace"    
    val groupName = "scenarios"
}


 
class ScenarioTraceDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ScenarioTraceDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioTraceDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
//////////////////////////////////////// Class: ScenarioTraceBo, group: scenarios ////////////////////////////////////////    
    
    val ScenarioTrace = new ScenarioTraceBo(alias = alias + "B0".als)    
    
    val fromBO = ScenarioTrace    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(ScenarioTrace), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val actionmessageScenarioTrace = ScenarioTrace.actionmessage    
    val actionobjectScenarioTrace = ScenarioTrace.actionobject    
    val actiontypeScenarioTrace = ScenarioTrace.actiontype    
    val addressScenarioTrace = ScenarioTrace.address    
    val bonusbaseScenarioTrace = ScenarioTrace.bonusbase    
    val bonusmessageScenarioTrace = ScenarioTrace.bonusmessage    
    val eventScenarioTrace = ScenarioTrace.event    
    val idScenarioTrace = ScenarioTrace.id    
    val idactionmessageScenarioTrace = ScenarioTrace.idactionmessage    
    val idbonusmessageScenarioTrace = ScenarioTrace.idbonusmessage    
    val idmarketingmessageScenarioTrace = ScenarioTrace.idmarketingmessage    
    val marketingmessageScenarioTrace = ScenarioTrace.marketingmessage    
    val parentstageScenarioTrace = ScenarioTrace.parentstage    
    val scenarioScenarioTrace = ScenarioTrace.scenario    
    val stageScenarioTrace = ScenarioTrace.stage    
    val timestampScenarioTrace = ScenarioTrace.timestamp    
/////////////////////////////////////// End Class: ScenarioTraceBo, group: scenarios ///////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idScenarioTrace)))    
    
    // For select tuple: (actionmessageScenarioTrace: Array[String], actionobjectScenarioTrace: Array[String], actiontypeScenarioTrace: Array[String], addressScenarioTrace: String, bonusbaseScenarioTrace: Array[Double], bonusmessageScenarioTrace: Array[String], eventScenarioTrace: String, idScenarioTrace: Long, idactionmessageScenarioTrace: Array[Long], idbonusmessageScenarioTrace: Array[Long], idmarketingmessageScenarioTrace: Array[Long], marketingmessageScenarioTrace: Array[String], parentstageScenarioTrace: Array[String], scenarioScenarioTrace: String, stageScenarioTrace: String, timestampScenarioTrace: LocalDateTime)    
    
    type ColumnTypes =     TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]    
     def allColumns = actionmessageScenarioTrace  ~ actionobjectScenarioTrace  ~ actiontypeScenarioTrace  ~ addressScenarioTrace  ~ bonusbaseScenarioTrace  ~ bonusmessageScenarioTrace  ~ eventScenarioTrace  ~ idScenarioTrace  ~ idactionmessageScenarioTrace  ~ idbonusmessageScenarioTrace  ~ idmarketingmessageScenarioTrace  ~ marketingmessageScenarioTrace  ~ parentstageScenarioTrace  ~ scenarioScenarioTrace  ~ stageScenarioTrace  ~ timestampScenarioTrace     
     def allColumns1 = Seq(actionmessageScenarioTrace  , actionobjectScenarioTrace  , actiontypeScenarioTrace  , addressScenarioTrace  , bonusbaseScenarioTrace  , bonusmessageScenarioTrace  , eventScenarioTrace  , idScenarioTrace  , idactionmessageScenarioTrace  , idbonusmessageScenarioTrace  , idmarketingmessageScenarioTrace  , marketingmessageScenarioTrace  , parentstageScenarioTrace  , scenarioScenarioTrace  , stageScenarioTrace  , timestampScenarioTrace )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioTraceDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS16(actionmessageScenarioTrace: Array[String], actionobjectScenarioTrace: Array[String], actiontypeScenarioTrace: Array[String], addressScenarioTrace: String, bonusbaseScenarioTrace: Array[Double], bonusmessageScenarioTrace: Array[String], eventScenarioTrace: String, idScenarioTrace: Long, idactionmessageScenarioTrace: Array[Long], idbonusmessageScenarioTrace: Array[Long], idmarketingmessageScenarioTrace: Array[Long], marketingmessageScenarioTrace: Array[String], parentstageScenarioTrace: Array[String], scenarioScenarioTrace: String, stageScenarioTrace: String, timestampScenarioTrace: LocalDateTime) => 
                        ScenarioTraceDSData(actionmessageScenarioTrace = actionmessageScenarioTrace , actionobjectScenarioTrace = actionobjectScenarioTrace , actiontypeScenarioTrace = actiontypeScenarioTrace , addressScenarioTrace = addressScenarioTrace , bonusbaseScenarioTrace = bonusbaseScenarioTrace , bonusmessageScenarioTrace = bonusmessageScenarioTrace , eventScenarioTrace = eventScenarioTrace , idScenarioTrace = idScenarioTrace , idactionmessageScenarioTrace = idactionmessageScenarioTrace , idbonusmessageScenarioTrace = idbonusmessageScenarioTrace , idmarketingmessageScenarioTrace = idmarketingmessageScenarioTrace , marketingmessageScenarioTrace = marketingmessageScenarioTrace , parentstageScenarioTrace = parentstageScenarioTrace , scenarioScenarioTrace = scenarioScenarioTrace , stageScenarioTrace = stageScenarioTrace , timestampScenarioTrace = timestampScenarioTrace )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioTraceDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS16(actionmessageScenarioTrace: Array[String], actionobjectScenarioTrace: Array[String], actiontypeScenarioTrace: Array[String], addressScenarioTrace: String, bonusbaseScenarioTrace: Array[Double], bonusmessageScenarioTrace: Array[String], eventScenarioTrace: String, idScenarioTrace: Long, idactionmessageScenarioTrace: Array[Long], idbonusmessageScenarioTrace: Array[Long], idmarketingmessageScenarioTrace: Array[Long], marketingmessageScenarioTrace: Array[String], parentstageScenarioTrace: Array[String], scenarioScenarioTrace: String, stageScenarioTrace: String, timestampScenarioTrace: LocalDateTime) => 
        ScenarioTraceDSData(actionmessageScenarioTrace = actionmessageScenarioTrace , actionobjectScenarioTrace = actionobjectScenarioTrace , actiontypeScenarioTrace = actiontypeScenarioTrace , addressScenarioTrace = addressScenarioTrace , bonusbaseScenarioTrace = bonusbaseScenarioTrace , bonusmessageScenarioTrace = bonusmessageScenarioTrace , eventScenarioTrace = eventScenarioTrace , idScenarioTrace = idScenarioTrace , idactionmessageScenarioTrace = idactionmessageScenarioTrace , idbonusmessageScenarioTrace = idbonusmessageScenarioTrace , idmarketingmessageScenarioTrace = idmarketingmessageScenarioTrace , marketingmessageScenarioTrace = marketingmessageScenarioTrace , parentstageScenarioTrace = parentstageScenarioTrace , scenarioScenarioTrace = scenarioScenarioTrace , stageScenarioTrace = stageScenarioTrace , timestampScenarioTrace = timestampScenarioTrace )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioTraceDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(ScenarioTrace), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS16(actionmessageScenarioTrace: Array[String], actionobjectScenarioTrace: Array[String], actiontypeScenarioTrace: Array[String], addressScenarioTrace: String, bonusbaseScenarioTrace: Array[Double], bonusmessageScenarioTrace: Array[String], eventScenarioTrace: String, idScenarioTrace: Long, idactionmessageScenarioTrace: Array[Long], idbonusmessageScenarioTrace: Array[Long], idmarketingmessageScenarioTrace: Array[Long], marketingmessageScenarioTrace: Array[String], parentstageScenarioTrace: Array[String], scenarioScenarioTrace: String, stageScenarioTrace: String, timestampScenarioTrace: LocalDateTime)) => 
                ValidationEx(Success(ScenarioTraceDSData(actionmessageScenarioTrace = actionmessageScenarioTrace , actionobjectScenarioTrace = actionobjectScenarioTrace , actiontypeScenarioTrace = actiontypeScenarioTrace , addressScenarioTrace = addressScenarioTrace , bonusbaseScenarioTrace = bonusbaseScenarioTrace , bonusmessageScenarioTrace = bonusmessageScenarioTrace , eventScenarioTrace = eventScenarioTrace , idScenarioTrace = idScenarioTrace , idactionmessageScenarioTrace = idactionmessageScenarioTrace , idbonusmessageScenarioTrace = idbonusmessageScenarioTrace , idmarketingmessageScenarioTrace = idmarketingmessageScenarioTrace , marketingmessageScenarioTrace = marketingmessageScenarioTrace , parentstageScenarioTrace = parentstageScenarioTrace , scenarioScenarioTrace = scenarioScenarioTrace , stageScenarioTrace = stageScenarioTrace , timestampScenarioTrace = timestampScenarioTrace )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): ValidationEx[List[Int]] = ScenarioTrace.insert(values: _*)    
     def insertP(values: ScenarioTrace*): ValidationEx[List[Int]] = ScenarioTrace.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): List[Int] = ScenarioTrace.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: ScenarioTrace*): List[Int] = ScenarioTrace.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace.update(value = values, where = where)    
     def updateP(values: ScenarioTrace, where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): List[Int] = ScenarioTrace.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: ScenarioTrace, where: WhereParam): List[Int] = ScenarioTrace.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = ScenarioTrace.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}