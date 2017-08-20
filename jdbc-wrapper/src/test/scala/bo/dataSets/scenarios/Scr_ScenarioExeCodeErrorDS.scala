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



 
case class Scr_ScenarioExeCodeErrorDSData(exeCodeErrorScr_Scenario: Array[Clob], id_scenarioScr_Scenario: Long) {

}


 
object Scr_ScenarioExeCodeErrorDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioExeCodeErrorDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioExeCodeErrorDS    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}


 
class Scr_ScenarioExeCodeErrorDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_ScenarioExeCodeErrorDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_ScenarioExeCodeErrorDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: Scr_ScenarioBo, group: scenarios /////////////////////////////////////////    
    
    val Scr_Scenario = new Scr_ScenarioBoExeCodeError(alias = alias + "B0".als)    
    
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
    val exeCodeErrorScr_Scenario = Scr_Scenario.exeCodeError    
    val id_scenarioScr_Scenario = Scr_Scenario.id_scenario    
//////////////////////////////////////// End Class: Scr_ScenarioBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_scenarioScr_Scenario)))    
    
    // For select tuple: (exeCodeErrorScr_Scenario: Array[Clob], id_scenarioScr_Scenario: Long)    
    
    type ColumnTypes =     TupleSS2[Array[Clob], Long]    
     def allColumns = exeCodeErrorScr_Scenario  ~ id_scenarioScr_Scenario     
     def allColumns1 = Seq(exeCodeErrorScr_Scenario  , id_scenarioScr_Scenario )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_ScenarioExeCodeErrorDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS2(exeCodeErrorScr_Scenario: Array[Clob], id_scenarioScr_Scenario: Long) => 
                        Scr_ScenarioExeCodeErrorDSData(exeCodeErrorScr_Scenario = exeCodeErrorScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_ScenarioExeCodeErrorDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS2(exeCodeErrorScr_Scenario: Array[Clob], id_scenarioScr_Scenario: Long) => 
        Scr_ScenarioExeCodeErrorDSData(exeCodeErrorScr_Scenario = exeCodeErrorScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_ScenarioExeCodeErrorDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS2(exeCodeErrorScr_Scenario: Array[Clob], id_scenarioScr_Scenario: Long)) => 
                ValidationEx(Success(Scr_ScenarioExeCodeErrorDSData(exeCodeErrorScr_Scenario = exeCodeErrorScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS2[Array[Clob], Long]*): ValidationEx[List[Int]] = Scr_Scenario.insert(values: _*)    
     def insertP(values: Scr_ScenarioExeCodeError*): ValidationEx[List[Int]] = Scr_Scenario.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Array[Clob], Long]*): List[Int] = Scr_Scenario.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_ScenarioExeCodeError*): List[Int] = Scr_Scenario.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS2[Array[Clob], Long], where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.update(value = values, where = where)    
     def updateP(values: Scr_ScenarioExeCodeError, where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS2[Array[Clob], Long], where: WhereParam): List[Int] = Scr_Scenario.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_ScenarioExeCodeError, where: WhereParam): List[Int] = Scr_Scenario.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Scenario.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}