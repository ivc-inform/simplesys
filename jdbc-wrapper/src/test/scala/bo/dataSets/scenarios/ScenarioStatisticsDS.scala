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



 
case class ScenarioStatisticsDSData(dateScenarioStatistics: LocalDateTime, inScenarioStatistics: Long, outScenarioStatistics: Long, scenarioScenarioStatistics: String) {

}


 
object ScenarioStatisticsDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ScenarioStatisticsDS    
    
    val objectName = "ScenarioStatistics"    
    val groupName = "scenarios"
}


 
class ScenarioStatisticsDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ScenarioStatisticsDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ScenarioStatisticsDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////// Class: ScenarioStatisticsBo, group: scenarios ///////////////////////////////////////    
    
    val ScenarioStatistics = new ScenarioStatisticsBo(alias = alias + "B0".als)    
    
    val fromBO = ScenarioStatistics    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(ScenarioStatistics), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val dateScenarioStatistics = ScenarioStatistics.date    
    val inScenarioStatistics = ScenarioStatistics.in    
    val outScenarioStatistics = ScenarioStatistics.out    
    val scenarioScenarioStatistics = ScenarioStatistics.scenario    
////////////////////////////////////// End Class: ScenarioStatisticsBo, group: scenarios //////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(scenarioScenarioStatistics)))    
    
    // For select tuple: (dateScenarioStatistics: LocalDateTime, inScenarioStatistics: Long, outScenarioStatistics: Long, scenarioScenarioStatistics: String)    
    
    type ColumnTypes =     TupleSS4[LocalDateTime, Long, Long, String]    
     def allColumns = dateScenarioStatistics  ~ inScenarioStatistics  ~ outScenarioStatistics  ~ scenarioScenarioStatistics     
     def allColumns1 = Seq(dateScenarioStatistics  , inScenarioStatistics  , outScenarioStatistics  , scenarioScenarioStatistics )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ScenarioStatisticsDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS4(dateScenarioStatistics: LocalDateTime, inScenarioStatistics: Long, outScenarioStatistics: Long, scenarioScenarioStatistics: String) => 
                        ScenarioStatisticsDSData(dateScenarioStatistics = dateScenarioStatistics , inScenarioStatistics = inScenarioStatistics , outScenarioStatistics = outScenarioStatistics , scenarioScenarioStatistics = scenarioScenarioStatistics )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ScenarioStatisticsDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS4(dateScenarioStatistics: LocalDateTime, inScenarioStatistics: Long, outScenarioStatistics: Long, scenarioScenarioStatistics: String) => 
        ScenarioStatisticsDSData(dateScenarioStatistics = dateScenarioStatistics , inScenarioStatistics = inScenarioStatistics , outScenarioStatistics = outScenarioStatistics , scenarioScenarioStatistics = scenarioScenarioStatistics )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ScenarioStatisticsDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(ScenarioStatistics), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS4(dateScenarioStatistics: LocalDateTime, inScenarioStatistics: Long, outScenarioStatistics: Long, scenarioScenarioStatistics: String)) => 
                ValidationEx(Success(ScenarioStatisticsDSData(dateScenarioStatistics = dateScenarioStatistics , inScenarioStatistics = inScenarioStatistics , outScenarioStatistics = outScenarioStatistics , scenarioScenarioStatistics = scenarioScenarioStatistics )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS4[LocalDateTime, Long, Long, String]*): ValidationEx[List[Int]] = ScenarioStatistics.insert(values: _*)    
     def insertP(values: ScenarioStatistics*): ValidationEx[List[Int]] = ScenarioStatistics.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[LocalDateTime, Long, Long, String]*): List[Int] = ScenarioStatistics.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: ScenarioStatistics*): List[Int] = ScenarioStatistics.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS4[LocalDateTime, Long, Long, String], where: WhereParam): ValidationEx[List[Int]] = ScenarioStatistics.update(value = values, where = where)    
     def updateP(values: ScenarioStatistics, where: WhereParam): ValidationEx[List[Int]] = ScenarioStatistics.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS4[LocalDateTime, Long, Long, String], where: WhereParam): List[Int] = ScenarioStatistics.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: ScenarioStatistics, where: WhereParam): List[Int] = ScenarioStatistics.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = ScenarioStatistics.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = ScenarioStatistics.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}