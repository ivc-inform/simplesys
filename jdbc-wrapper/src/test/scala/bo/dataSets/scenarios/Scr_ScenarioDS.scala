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



 
case class Scr_ScenarioDSData(begin_scenarioScr_Scenario: Array[LocalDateTime], caption_scenarioScr_Scenario: String, code_scenarioScr_Scenario: String, debug_modeScr_Scenario: Array[Boolean], description_scenarioScr_Scenario: Array[String], end_scenarioScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Scenario: Array[Long], id_scenarioScr_Scenario: Long, statusScr_Scenario: Array[Long], versionScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Cmpgn_Id_cmpgn: Long, caption_cmpgnScr_Cmpgn_Id_cmpgn: String, code_cmpgnScr_Cmpgn_Id_cmpgn: String) {

}


 
object Scr_ScenarioDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_ScenarioDS    
    
    val objectName = "Scr_Scenario"    
    val groupName = "scenarios"
}


 
class Scr_ScenarioDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_ScenarioDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_ScenarioDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: Scr_ScenarioBo, group: scenarios /////////////////////////////////////////    
    
    val Scr_Scenario = new Scr_ScenarioBo(alias = alias + "B0".als)    
    
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
    val begin_scenarioScr_Scenario = Scr_Scenario.begin_scenario    
    val caption_scenarioScr_Scenario = Scr_Scenario.caption_scenario    
    val code_scenarioScr_Scenario = Scr_Scenario.code_scenario    
    val debug_modeScr_Scenario = Scr_Scenario.debug_mode    
    val description_scenarioScr_Scenario = Scr_Scenario.description_scenario    
    val end_scenarioScr_Scenario = Scr_Scenario.end_scenario    
    val id_cmpgnScr_Scenario = Scr_Scenario.id_cmpgn    
    val id_scenarioScr_Scenario = Scr_Scenario.id_scenario    
    val statusScr_Scenario = Scr_Scenario.status    
    val versionScr_Scenario = Scr_Scenario.version    
//////////////////////////////////////// End Class: Scr_ScenarioBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 2    
    
/////////////////////////////////////// Class: Scr_CmpgnBo_Id_cmpgn, group: scenarios ///////////////////////////////////////    
    val Scr_Cmpgn_Id_cmpgn = new Scr_CmpgnBo(alias = alias +"B1".als)    
    val id_cmpgnScr_Cmpgn_Id_cmpgn = Scr_Cmpgn_Id_cmpgn.id_cmpgn    
    id_cmpgnScr_Cmpgn_Id_cmpgn As id_cmpgnScr_Cmpgn_Id_cmpgn.name + "_B1"     
    
    
    val caption_cmpgnScr_Cmpgn_Id_cmpgn = Scr_Cmpgn_Id_cmpgn.caption_cmpgn    
    caption_cmpgnScr_Cmpgn_Id_cmpgn As caption_cmpgnScr_Cmpgn_Id_cmpgn.name + "_B1"     
    
    
    val code_cmpgnScr_Cmpgn_Id_cmpgn = Scr_Cmpgn_Id_cmpgn.code_cmpgn    
    code_cmpgnScr_Cmpgn_Id_cmpgn As code_cmpgnScr_Cmpgn_Id_cmpgn.name + "_B1"     
    
    
    val parent_cmpgnScr_Cmpgn_Id_cmpgn = Scr_Cmpgn_Id_cmpgn.parent_cmpgn    
    parent_cmpgnScr_Cmpgn_Id_cmpgn As parent_cmpgnScr_Cmpgn_Id_cmpgn.name + "_B1"     
    
    
    _join.LeftJoin(Scr_Cmpgn_Id_cmpgn)((id_cmpgnScr_Scenario === id_cmpgnScr_Cmpgn_Id_cmpgn).JoinCondition)    
////////////////////////////////////// End Class: Scr_CmpgnBo_Id_cmpgn, group: scenarios //////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_scenarioScr_Scenario)),
            UniqueKey(name = "ucCode_scenario", constraintDate = KeyConstraintData(code_scenarioScr_Scenario)),
            ForignKey(name = "frId_cmpgn", constraintDate = ForignKeyConstraintData(id_cmpgnScr_Scenario, ReferencedData("scenarios","Scr_Cmpgn"), false)),
            MigratedPrimaryKey(name = "pk_Id_cmpgn", constraintDate = KeyConstraintData(id_cmpgnScr_Cmpgn_Id_cmpgn)),
            UniqueKey(name = "ucCode_cmpgn_Id_cmpgn", constraintDate = KeyConstraintData(code_cmpgnScr_Cmpgn_Id_cmpgn)),
            ForignKey(name = "frParent_cmpgn_Id_cmpgn", constraintDate = ForignKeyConstraintData(parent_cmpgnScr_Cmpgn_Id_cmpgn, ReferencedData("scenarios","Scr_Cmpgn"), false)))    
    
    // For select tuple: (begin_scenarioScr_Scenario: Array[LocalDateTime], caption_scenarioScr_Scenario: String, code_scenarioScr_Scenario: String, debug_modeScr_Scenario: Array[Boolean], description_scenarioScr_Scenario: Array[String], end_scenarioScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Scenario: Array[Long], id_scenarioScr_Scenario: Long, statusScr_Scenario: Array[Long], versionScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String)    
    
    type ColumnTypes =     TupleSS13[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime], Long, String, String]    
     def allColumns = begin_scenarioScr_Scenario  ~ caption_scenarioScr_Scenario  ~ code_scenarioScr_Scenario  ~ debug_modeScr_Scenario  ~ description_scenarioScr_Scenario  ~ end_scenarioScr_Scenario  ~ id_cmpgnScr_Scenario  ~ id_scenarioScr_Scenario  ~ statusScr_Scenario  ~ versionScr_Scenario  ~ id_cmpgnScr_Cmpgn_Id_cmpgn  ~ caption_cmpgnScr_Cmpgn_Id_cmpgn  ~ code_cmpgnScr_Cmpgn_Id_cmpgn     
     def allColumns1 = Seq(begin_scenarioScr_Scenario  , caption_scenarioScr_Scenario  , code_scenarioScr_Scenario  , debug_modeScr_Scenario  , description_scenarioScr_Scenario  , end_scenarioScr_Scenario  , id_cmpgnScr_Scenario  , id_scenarioScr_Scenario  , statusScr_Scenario  , versionScr_Scenario  , id_cmpgnScr_Cmpgn_Id_cmpgn  , caption_cmpgnScr_Cmpgn_Id_cmpgn  , code_cmpgnScr_Cmpgn_Id_cmpgn )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_ScenarioDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS13(begin_scenarioScr_Scenario: Array[LocalDateTime], caption_scenarioScr_Scenario: String, code_scenarioScr_Scenario: String, debug_modeScr_Scenario: Array[Boolean], description_scenarioScr_Scenario: Array[String], end_scenarioScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Scenario: Array[Long], id_scenarioScr_Scenario: Long, statusScr_Scenario: Array[Long], versionScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Cmpgn_Id_cmpgn: Long, caption_cmpgnScr_Cmpgn_Id_cmpgn: String, code_cmpgnScr_Cmpgn_Id_cmpgn: String) => 
                        Scr_ScenarioDSData(begin_scenarioScr_Scenario = begin_scenarioScr_Scenario , caption_scenarioScr_Scenario = caption_scenarioScr_Scenario , code_scenarioScr_Scenario = code_scenarioScr_Scenario , debug_modeScr_Scenario = debug_modeScr_Scenario , description_scenarioScr_Scenario = description_scenarioScr_Scenario , end_scenarioScr_Scenario = end_scenarioScr_Scenario , id_cmpgnScr_Scenario = id_cmpgnScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario , statusScr_Scenario = statusScr_Scenario , versionScr_Scenario = versionScr_Scenario , id_cmpgnScr_Cmpgn_Id_cmpgn = id_cmpgnScr_Cmpgn_Id_cmpgn , caption_cmpgnScr_Cmpgn_Id_cmpgn = caption_cmpgnScr_Cmpgn_Id_cmpgn , code_cmpgnScr_Cmpgn_Id_cmpgn = code_cmpgnScr_Cmpgn_Id_cmpgn )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_ScenarioDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS13(begin_scenarioScr_Scenario: Array[LocalDateTime], caption_scenarioScr_Scenario: String, code_scenarioScr_Scenario: String, debug_modeScr_Scenario: Array[Boolean], description_scenarioScr_Scenario: Array[String], end_scenarioScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Scenario: Array[Long], id_scenarioScr_Scenario: Long, statusScr_Scenario: Array[Long], versionScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Cmpgn_Id_cmpgn: Long, caption_cmpgnScr_Cmpgn_Id_cmpgn: String, code_cmpgnScr_Cmpgn_Id_cmpgn: String) => 
        Scr_ScenarioDSData(begin_scenarioScr_Scenario = begin_scenarioScr_Scenario , caption_scenarioScr_Scenario = caption_scenarioScr_Scenario , code_scenarioScr_Scenario = code_scenarioScr_Scenario , debug_modeScr_Scenario = debug_modeScr_Scenario , description_scenarioScr_Scenario = description_scenarioScr_Scenario , end_scenarioScr_Scenario = end_scenarioScr_Scenario , id_cmpgnScr_Scenario = id_cmpgnScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario , statusScr_Scenario = statusScr_Scenario , versionScr_Scenario = versionScr_Scenario , id_cmpgnScr_Cmpgn_Id_cmpgn = id_cmpgnScr_Cmpgn_Id_cmpgn , caption_cmpgnScr_Cmpgn_Id_cmpgn = caption_cmpgnScr_Cmpgn_Id_cmpgn , code_cmpgnScr_Cmpgn_Id_cmpgn = code_cmpgnScr_Cmpgn_Id_cmpgn )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_ScenarioDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Scenario), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS13(begin_scenarioScr_Scenario: Array[LocalDateTime], caption_scenarioScr_Scenario: String, code_scenarioScr_Scenario: String, debug_modeScr_Scenario: Array[Boolean], description_scenarioScr_Scenario: Array[String], end_scenarioScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Scenario: Array[Long], id_scenarioScr_Scenario: Long, statusScr_Scenario: Array[Long], versionScr_Scenario: Array[LocalDateTime], id_cmpgnScr_Cmpgn_Id_cmpgn: Long, caption_cmpgnScr_Cmpgn_Id_cmpgn: String, code_cmpgnScr_Cmpgn_Id_cmpgn: String)) => 
                ValidationEx(Success(Scr_ScenarioDSData(begin_scenarioScr_Scenario = begin_scenarioScr_Scenario , caption_scenarioScr_Scenario = caption_scenarioScr_Scenario , code_scenarioScr_Scenario = code_scenarioScr_Scenario , debug_modeScr_Scenario = debug_modeScr_Scenario , description_scenarioScr_Scenario = description_scenarioScr_Scenario , end_scenarioScr_Scenario = end_scenarioScr_Scenario , id_cmpgnScr_Scenario = id_cmpgnScr_Scenario , id_scenarioScr_Scenario = id_scenarioScr_Scenario , statusScr_Scenario = statusScr_Scenario , versionScr_Scenario = versionScr_Scenario , id_cmpgnScr_Cmpgn_Id_cmpgn = id_cmpgnScr_Cmpgn_Id_cmpgn , caption_cmpgnScr_Cmpgn_Id_cmpgn = caption_cmpgnScr_Cmpgn_Id_cmpgn , code_cmpgnScr_Cmpgn_Id_cmpgn = code_cmpgnScr_Cmpgn_Id_cmpgn )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): ValidationEx[List[Int]] = Scr_Scenario.insert(values: _*)    
     def insertP(values: Scr_Scenario*): ValidationEx[List[Int]] = Scr_Scenario.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]]*): List[Int] = Scr_Scenario.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_Scenario*): List[Int] = Scr_Scenario.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]], where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.update(value = values, where = where)    
     def updateP(values: Scr_Scenario, where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS10[Array[LocalDateTime], String, String, Array[Boolean], Array[String], Array[LocalDateTime], Array[Long], Long, Array[Long], Array[LocalDateTime]], where: WhereParam): List[Int] = Scr_Scenario.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_Scenario, where: WhereParam): List[Int] = Scr_Scenario.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Scenario.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Scenario.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}