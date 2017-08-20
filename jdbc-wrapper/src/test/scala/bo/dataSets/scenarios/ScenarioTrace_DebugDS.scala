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



 
case class ScenarioTrace_DebugDSData(actionmessageScenarioTrace_Debug: Array[String], actionobjectScenarioTrace_Debug: Array[String], actiontypeScenarioTrace_Debug: Array[String], addressScenarioTrace_Debug: String, bonusbaseScenarioTrace_Debug: Array[Double], bonusmessageScenarioTrace_Debug: Array[String], eventScenarioTrace_Debug: String, idScenarioTrace_Debug: Long, idactionmessageScenarioTrace_Debug: Array[Long], idbonusmessageScenarioTrace_Debug: Array[Long], idmarketingmessageScenarioTrace_Debug: Array[Long], marketingmessageScenarioTrace_Debug: Array[String], parentstageScenarioTrace_Debug: Array[String], scenarioScenarioTrace_Debug: String, stageScenarioTrace_Debug: String, timestampScenarioTrace_Debug: LocalDateTime) {

}


 
object ScenarioTrace_DebugDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioTrace_DebugDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioTrace_DebugDS    
    
    val objectName = "ScenarioTrace_Debug"    
    val groupName = "scenarios"
}


 
class ScenarioTrace_DebugDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ScenarioTrace_DebugDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioTrace_DebugDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////// Class: ScenarioTrace_DebugBo, group: scenarios ///////////////////////////////////////    
    
    val ScenarioTrace_Debug = new ScenarioTrace_DebugBo(alias = alias + "B0".als)    
    
    val fromBO = ScenarioTrace_Debug    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(ScenarioTrace_Debug), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val actionmessageScenarioTrace_Debug = ScenarioTrace_Debug.actionmessage    
    val actionobjectScenarioTrace_Debug = ScenarioTrace_Debug.actionobject    
    val actiontypeScenarioTrace_Debug = ScenarioTrace_Debug.actiontype    
    val addressScenarioTrace_Debug = ScenarioTrace_Debug.address    
    val bonusbaseScenarioTrace_Debug = ScenarioTrace_Debug.bonusbase    
    val bonusmessageScenarioTrace_Debug = ScenarioTrace_Debug.bonusmessage    
    val eventScenarioTrace_Debug = ScenarioTrace_Debug.event    
    val idScenarioTrace_Debug = ScenarioTrace_Debug.id    
    val idactionmessageScenarioTrace_Debug = ScenarioTrace_Debug.idactionmessage    
    val idbonusmessageScenarioTrace_Debug = ScenarioTrace_Debug.idbonusmessage    
    val idmarketingmessageScenarioTrace_Debug = ScenarioTrace_Debug.idmarketingmessage    
    val marketingmessageScenarioTrace_Debug = ScenarioTrace_Debug.marketingmessage    
    val parentstageScenarioTrace_Debug = ScenarioTrace_Debug.parentstage    
    val scenarioScenarioTrace_Debug = ScenarioTrace_Debug.scenario    
    val stageScenarioTrace_Debug = ScenarioTrace_Debug.stage    
    val timestampScenarioTrace_Debug = ScenarioTrace_Debug.timestamp    
////////////////////////////////////// End Class: ScenarioTrace_DebugBo, group: scenarios //////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idScenarioTrace_Debug)))    
    
    // For select tuple: (actionmessageScenarioTrace_Debug: Array[String], actionobjectScenarioTrace_Debug: Array[String], actiontypeScenarioTrace_Debug: Array[String], addressScenarioTrace_Debug: String, bonusbaseScenarioTrace_Debug: Array[Double], bonusmessageScenarioTrace_Debug: Array[String], eventScenarioTrace_Debug: String, idScenarioTrace_Debug: Long, idactionmessageScenarioTrace_Debug: Array[Long], idbonusmessageScenarioTrace_Debug: Array[Long], idmarketingmessageScenarioTrace_Debug: Array[Long], marketingmessageScenarioTrace_Debug: Array[String], parentstageScenarioTrace_Debug: Array[String], scenarioScenarioTrace_Debug: String, stageScenarioTrace_Debug: String, timestampScenarioTrace_Debug: LocalDateTime)    
    
    type ColumnTypes =     TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]    
     def allColumns = actionmessageScenarioTrace_Debug  ~ actionobjectScenarioTrace_Debug  ~ actiontypeScenarioTrace_Debug  ~ addressScenarioTrace_Debug  ~ bonusbaseScenarioTrace_Debug  ~ bonusmessageScenarioTrace_Debug  ~ eventScenarioTrace_Debug  ~ idScenarioTrace_Debug  ~ idactionmessageScenarioTrace_Debug  ~ idbonusmessageScenarioTrace_Debug  ~ idmarketingmessageScenarioTrace_Debug  ~ marketingmessageScenarioTrace_Debug  ~ parentstageScenarioTrace_Debug  ~ scenarioScenarioTrace_Debug  ~ stageScenarioTrace_Debug  ~ timestampScenarioTrace_Debug     
     def allColumns1 = Seq(actionmessageScenarioTrace_Debug  , actionobjectScenarioTrace_Debug  , actiontypeScenarioTrace_Debug  , addressScenarioTrace_Debug  , bonusbaseScenarioTrace_Debug  , bonusmessageScenarioTrace_Debug  , eventScenarioTrace_Debug  , idScenarioTrace_Debug  , idactionmessageScenarioTrace_Debug  , idbonusmessageScenarioTrace_Debug  , idmarketingmessageScenarioTrace_Debug  , marketingmessageScenarioTrace_Debug  , parentstageScenarioTrace_Debug  , scenarioScenarioTrace_Debug  , stageScenarioTrace_Debug  , timestampScenarioTrace_Debug )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioTrace_DebugDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS16(actionmessageScenarioTrace_Debug: Array[String], actionobjectScenarioTrace_Debug: Array[String], actiontypeScenarioTrace_Debug: Array[String], addressScenarioTrace_Debug: String, bonusbaseScenarioTrace_Debug: Array[Double], bonusmessageScenarioTrace_Debug: Array[String], eventScenarioTrace_Debug: String, idScenarioTrace_Debug: Long, idactionmessageScenarioTrace_Debug: Array[Long], idbonusmessageScenarioTrace_Debug: Array[Long], idmarketingmessageScenarioTrace_Debug: Array[Long], marketingmessageScenarioTrace_Debug: Array[String], parentstageScenarioTrace_Debug: Array[String], scenarioScenarioTrace_Debug: String, stageScenarioTrace_Debug: String, timestampScenarioTrace_Debug: LocalDateTime) => 
                        ScenarioTrace_DebugDSData(actionmessageScenarioTrace_Debug = actionmessageScenarioTrace_Debug , actionobjectScenarioTrace_Debug = actionobjectScenarioTrace_Debug , actiontypeScenarioTrace_Debug = actiontypeScenarioTrace_Debug , addressScenarioTrace_Debug = addressScenarioTrace_Debug , bonusbaseScenarioTrace_Debug = bonusbaseScenarioTrace_Debug , bonusmessageScenarioTrace_Debug = bonusmessageScenarioTrace_Debug , eventScenarioTrace_Debug = eventScenarioTrace_Debug , idScenarioTrace_Debug = idScenarioTrace_Debug , idactionmessageScenarioTrace_Debug = idactionmessageScenarioTrace_Debug , idbonusmessageScenarioTrace_Debug = idbonusmessageScenarioTrace_Debug , idmarketingmessageScenarioTrace_Debug = idmarketingmessageScenarioTrace_Debug , marketingmessageScenarioTrace_Debug = marketingmessageScenarioTrace_Debug , parentstageScenarioTrace_Debug = parentstageScenarioTrace_Debug , scenarioScenarioTrace_Debug = scenarioScenarioTrace_Debug , stageScenarioTrace_Debug = stageScenarioTrace_Debug , timestampScenarioTrace_Debug = timestampScenarioTrace_Debug )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioTrace_DebugDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS16(actionmessageScenarioTrace_Debug: Array[String], actionobjectScenarioTrace_Debug: Array[String], actiontypeScenarioTrace_Debug: Array[String], addressScenarioTrace_Debug: String, bonusbaseScenarioTrace_Debug: Array[Double], bonusmessageScenarioTrace_Debug: Array[String], eventScenarioTrace_Debug: String, idScenarioTrace_Debug: Long, idactionmessageScenarioTrace_Debug: Array[Long], idbonusmessageScenarioTrace_Debug: Array[Long], idmarketingmessageScenarioTrace_Debug: Array[Long], marketingmessageScenarioTrace_Debug: Array[String], parentstageScenarioTrace_Debug: Array[String], scenarioScenarioTrace_Debug: String, stageScenarioTrace_Debug: String, timestampScenarioTrace_Debug: LocalDateTime) => 
        ScenarioTrace_DebugDSData(actionmessageScenarioTrace_Debug = actionmessageScenarioTrace_Debug , actionobjectScenarioTrace_Debug = actionobjectScenarioTrace_Debug , actiontypeScenarioTrace_Debug = actiontypeScenarioTrace_Debug , addressScenarioTrace_Debug = addressScenarioTrace_Debug , bonusbaseScenarioTrace_Debug = bonusbaseScenarioTrace_Debug , bonusmessageScenarioTrace_Debug = bonusmessageScenarioTrace_Debug , eventScenarioTrace_Debug = eventScenarioTrace_Debug , idScenarioTrace_Debug = idScenarioTrace_Debug , idactionmessageScenarioTrace_Debug = idactionmessageScenarioTrace_Debug , idbonusmessageScenarioTrace_Debug = idbonusmessageScenarioTrace_Debug , idmarketingmessageScenarioTrace_Debug = idmarketingmessageScenarioTrace_Debug , marketingmessageScenarioTrace_Debug = marketingmessageScenarioTrace_Debug , parentstageScenarioTrace_Debug = parentstageScenarioTrace_Debug , scenarioScenarioTrace_Debug = scenarioScenarioTrace_Debug , stageScenarioTrace_Debug = stageScenarioTrace_Debug , timestampScenarioTrace_Debug = timestampScenarioTrace_Debug )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioTrace_DebugDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(ScenarioTrace_Debug), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS16(actionmessageScenarioTrace_Debug: Array[String], actionobjectScenarioTrace_Debug: Array[String], actiontypeScenarioTrace_Debug: Array[String], addressScenarioTrace_Debug: String, bonusbaseScenarioTrace_Debug: Array[Double], bonusmessageScenarioTrace_Debug: Array[String], eventScenarioTrace_Debug: String, idScenarioTrace_Debug: Long, idactionmessageScenarioTrace_Debug: Array[Long], idbonusmessageScenarioTrace_Debug: Array[Long], idmarketingmessageScenarioTrace_Debug: Array[Long], marketingmessageScenarioTrace_Debug: Array[String], parentstageScenarioTrace_Debug: Array[String], scenarioScenarioTrace_Debug: String, stageScenarioTrace_Debug: String, timestampScenarioTrace_Debug: LocalDateTime)) => 
                ValidationEx(Success(ScenarioTrace_DebugDSData(actionmessageScenarioTrace_Debug = actionmessageScenarioTrace_Debug , actionobjectScenarioTrace_Debug = actionobjectScenarioTrace_Debug , actiontypeScenarioTrace_Debug = actiontypeScenarioTrace_Debug , addressScenarioTrace_Debug = addressScenarioTrace_Debug , bonusbaseScenarioTrace_Debug = bonusbaseScenarioTrace_Debug , bonusmessageScenarioTrace_Debug = bonusmessageScenarioTrace_Debug , eventScenarioTrace_Debug = eventScenarioTrace_Debug , idScenarioTrace_Debug = idScenarioTrace_Debug , idactionmessageScenarioTrace_Debug = idactionmessageScenarioTrace_Debug , idbonusmessageScenarioTrace_Debug = idbonusmessageScenarioTrace_Debug , idmarketingmessageScenarioTrace_Debug = idmarketingmessageScenarioTrace_Debug , marketingmessageScenarioTrace_Debug = marketingmessageScenarioTrace_Debug , parentstageScenarioTrace_Debug = parentstageScenarioTrace_Debug , scenarioScenarioTrace_Debug = scenarioScenarioTrace_Debug , stageScenarioTrace_Debug = stageScenarioTrace_Debug , timestampScenarioTrace_Debug = timestampScenarioTrace_Debug )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): ValidationEx[List[Int]] = ScenarioTrace_Debug.insert(values: _*)    
     def insertP(values: ScenarioTrace_Debug*): ValidationEx[List[Int]] = ScenarioTrace_Debug.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime]*): List[Int] = ScenarioTrace_Debug.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: ScenarioTrace_Debug*): List[Int] = ScenarioTrace_Debug.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace_Debug.update(value = values, where = where)    
     def updateP(values: ScenarioTrace_Debug, where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace_Debug.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS16[Array[String], Array[String], Array[String], String, Array[Double], Array[String], String, Long, Array[Long], Array[Long], Array[Long], Array[String], Array[String], String, String, LocalDateTime], where: WhereParam): List[Int] = ScenarioTrace_Debug.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: ScenarioTrace_Debug, where: WhereParam): List[Int] = ScenarioTrace_Debug.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = ScenarioTrace_Debug.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = ScenarioTrace_Debug.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}