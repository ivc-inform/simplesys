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



 
case class Scr_ScenarioJsonStorage_scenarioDSData(id_scenarioScr_Scenario: Long, jsonStorage_scenarioScr_Scenario: Array[Json]) {

}


 
object Scr_ScenarioJsonStorage_scenarioDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioJsonStorage_scenarioDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioJsonStorage_scenarioDS    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}


 
class Scr_ScenarioJsonStorage_scenarioDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_ScenarioJsonStorage_scenarioDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_ScenarioJsonStorage_scenarioDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: Scr_ScenarioBo, group: scenarios /////////////////////////////////////////    
    
    val Scr_Scenario = new Scr_ScenarioBoJsonStorage_scenario(alias = alias + "B0".als)    
    
    val fromBO = Scr_Scenario    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(Scr_Scenario), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val id_scenarioScr_Scenario = Scr_Scenario.id_scenario    
    val jsonStorage_scenarioScr_Scenario = Scr_Scenario.jsonStorage_scenario    
//////////////////////////////////////// End Class: Scr_ScenarioBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_scenarioScr_Scenario)))    
    
    // For select tuple: (id_scenarioScr_Scenario: Long, jsonStorage_scenarioScr_Scenario: Array[Json])    
    
    type ColumnTypes =     TupleSS2[Long, Array[Json]]    
     def allColumns = id_scenarioScr_Scenario  ~ jsonStorage_scenarioScr_Scenario     
     def allColumns1 = Seq(id_scenarioScr_Scenario  , jsonStorage_scenarioScr_Scenario )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_ScenarioJsonStorage_scenarioDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS2(id_scenarioScr_Scenario: Long, jsonStorage_scenarioScr_Scenario: Array[Json]) => 
                        Scr_ScenarioJsonStorage_scenarioDSData(id_scenarioScr_Scenario = id_scenarioScr_Scenario , jsonStorage_scenarioScr_Scenario = jsonStorage_scenarioScr_Scenario )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_ScenarioJsonStorage_scenarioDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS2(id_scenarioScr_Scenario: Long, jsonStorage_scenarioScr_Scenario: Array[Json]) => 
        Scr_ScenarioJsonStorage_scenarioDSData(id_scenarioScr_Scenario = id_scenarioScr_Scenario , jsonStorage_scenarioScr_Scenario = jsonStorage_scenarioScr_Scenario )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_ScenarioJsonStorage_scenarioDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS2(id_scenarioScr_Scenario: Long, jsonStorage_scenarioScr_Scenario: Array[Json])) => 
                ValidationEx(Success(Scr_ScenarioJsonStorage_scenarioDSData(id_scenarioScr_Scenario = id_scenarioScr_Scenario , jsonStorage_scenarioScr_Scenario = jsonStorage_scenarioScr_Scenario )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS2[Long, Array[Json]]*): ValidationEx[List[Int]] = Scr_Scenario.insert(values: _*)    
     def insertP(values: Scr_ScenarioJsonStorage_scenario*): ValidationEx[List[Int]] = Scr_Scenario.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Json]]*): List[Int] = Scr_Scenario.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioJsonStorage_scenario*): List[Int] = Scr_Scenario.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS2[Long, Array[Json]], where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.update(value = values, where = where)    
     def updateP(values: Scr_ScenarioJsonStorage_scenario, where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS2[Long, Array[Json]], where: WhereParam): List[Int] = Scr_Scenario.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_ScenarioJsonStorage_scenario, where: WhereParam): List[Int] = Scr_Scenario.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Scenario.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}