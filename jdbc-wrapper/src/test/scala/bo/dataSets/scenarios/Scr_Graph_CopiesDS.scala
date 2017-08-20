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



 
case class Scr_Graph_CopiesDSData(description_copyScr_Graph_Copies: Array[String], idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, versionScr_Graph_Copies: LocalDateTime, id_scenarioScr_Scenario_Id_scenario_ref: Long, code_scenarioScr_Scenario_Id_scenario_ref: String) {

}


 
object Scr_Graph_CopiesDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesDS    
    
    val objectName = "Scr_Graph_Copies"    
    val groupName = "scenarios"
}


 
class Scr_Graph_CopiesDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_Graph_CopiesDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_Graph_CopiesDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
//////////////////////////////////////// Class: Scr_Graph_CopiesBo, group: scenarios ////////////////////////////////////////    
    
    val Scr_Graph_Copies = new Scr_Graph_CopiesBo(alias = alias + "B0".als)    
    
    val fromBO = Scr_Graph_Copies    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(Scr_Graph_Copies), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val description_copyScr_Graph_Copies = Scr_Graph_Copies.description_copy    
    val idScr_Graph_Copies = Scr_Graph_Copies.id    
    val id_scenario_refScr_Graph_Copies = Scr_Graph_Copies.id_scenario_ref    
    val versionScr_Graph_Copies = Scr_Graph_Copies.version    
/////////////////////////////////////// End Class: Scr_Graph_CopiesBo, group: scenarios ///////////////////////////////////////    
    override val boCount = 2    
    
///////////////////////////////////// Class: Scr_ScenarioBo_Id_scenario_ref, group: scenarios /////////////////////////////////////    
    val Scr_Scenario_Id_scenario_ref = new Scr_ScenarioBo(alias = alias +"B1".als)    
    val id_scenarioScr_Scenario_Id_scenario_ref = Scr_Scenario_Id_scenario_ref.id_scenario    
    id_scenarioScr_Scenario_Id_scenario_ref As id_scenarioScr_Scenario_Id_scenario_ref.name + "_B1"     
    
    
    val code_scenarioScr_Scenario_Id_scenario_ref = Scr_Scenario_Id_scenario_ref.code_scenario    
    code_scenarioScr_Scenario_Id_scenario_ref As code_scenarioScr_Scenario_Id_scenario_ref.name + "_B1"     
    
    
    val id_cmpgnScr_Scenario_Id_scenario_ref = Scr_Scenario_Id_scenario_ref.id_cmpgn    
    id_cmpgnScr_Scenario_Id_scenario_ref As id_cmpgnScr_Scenario_Id_scenario_ref.name + "_B1"     
    
    
    _join.InnerJoin(Scr_Scenario_Id_scenario_ref)((id_scenario_refScr_Graph_Copies === id_scenarioScr_Scenario_Id_scenario_ref).JoinCondition)    
//////////////////////////////////// End Class: Scr_ScenarioBo_Id_scenario_ref, group: scenarios ////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idScr_Graph_Copies),KeyConstraintData(id_scenario_refScr_Graph_Copies)),
            ForignKey(name = "frId_scenario_ref", constraintDate = ForignKeyConstraintData(id_scenario_refScr_Graph_Copies, ReferencedData("scenarios","Scr_Scenario"), true)),
            MigratedPrimaryKey(name = "pk_Id_scenario_ref", constraintDate = KeyConstraintData(id_scenarioScr_Scenario_Id_scenario_ref)),
            UniqueKey(name = "ucCode_scenario_Id_scenario_ref", constraintDate = KeyConstraintData(code_scenarioScr_Scenario_Id_scenario_ref)),
            ForignKey(name = "frId_cmpgn_Id_scenario_ref", constraintDate = ForignKeyConstraintData(id_cmpgnScr_Scenario_Id_scenario_ref, ReferencedData("scenarios","Scr_Cmpgn"), false)))    
    
    // For select tuple: (description_copyScr_Graph_Copies: Array[String], idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, versionScr_Graph_Copies: LocalDateTime, id_scenarioScr_Scenario: Long, code_scenarioScr_Scenario: String)    
    
    type ColumnTypes =     TupleSS6[Array[String], Long, Long, LocalDateTime, Long, String]    
     def allColumns = description_copyScr_Graph_Copies  ~ idScr_Graph_Copies  ~ id_scenario_refScr_Graph_Copies  ~ versionScr_Graph_Copies  ~ id_scenarioScr_Scenario_Id_scenario_ref  ~ code_scenarioScr_Scenario_Id_scenario_ref     
     def allColumns1 = Seq(description_copyScr_Graph_Copies  , idScr_Graph_Copies  , id_scenario_refScr_Graph_Copies  , versionScr_Graph_Copies  , id_scenarioScr_Scenario_Id_scenario_ref  , code_scenarioScr_Scenario_Id_scenario_ref )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_Graph_CopiesDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS6(description_copyScr_Graph_Copies: Array[String], idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, versionScr_Graph_Copies: LocalDateTime, id_scenarioScr_Scenario_Id_scenario_ref: Long, code_scenarioScr_Scenario_Id_scenario_ref: String) => 
                        Scr_Graph_CopiesDSData(description_copyScr_Graph_Copies = description_copyScr_Graph_Copies , idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , versionScr_Graph_Copies = versionScr_Graph_Copies , id_scenarioScr_Scenario_Id_scenario_ref = id_scenarioScr_Scenario_Id_scenario_ref , code_scenarioScr_Scenario_Id_scenario_ref = code_scenarioScr_Scenario_Id_scenario_ref )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_Graph_CopiesDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS6(description_copyScr_Graph_Copies: Array[String], idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, versionScr_Graph_Copies: LocalDateTime, id_scenarioScr_Scenario_Id_scenario_ref: Long, code_scenarioScr_Scenario_Id_scenario_ref: String) => 
        Scr_Graph_CopiesDSData(description_copyScr_Graph_Copies = description_copyScr_Graph_Copies , idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , versionScr_Graph_Copies = versionScr_Graph_Copies , id_scenarioScr_Scenario_Id_scenario_ref = id_scenarioScr_Scenario_Id_scenario_ref , code_scenarioScr_Scenario_Id_scenario_ref = code_scenarioScr_Scenario_Id_scenario_ref )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_Graph_CopiesDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS6(description_copyScr_Graph_Copies: Array[String], idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, versionScr_Graph_Copies: LocalDateTime, id_scenarioScr_Scenario_Id_scenario_ref: Long, code_scenarioScr_Scenario_Id_scenario_ref: String)) => 
                ValidationEx(Success(Scr_Graph_CopiesDSData(description_copyScr_Graph_Copies = description_copyScr_Graph_Copies , idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , versionScr_Graph_Copies = versionScr_Graph_Copies , id_scenarioScr_Scenario_Id_scenario_ref = id_scenarioScr_Scenario_Id_scenario_ref , code_scenarioScr_Scenario_Id_scenario_ref = code_scenarioScr_Scenario_Id_scenario_ref )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): ValidationEx[List[Int]] = Scr_Graph_Copies.insert(values: _*)    
     def insertP(values: Scr_Graph_Copies*): ValidationEx[List[Int]] = Scr_Graph_Copies.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): List[Int] = Scr_Graph_Copies.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_Graph_Copies*): List[Int] = Scr_Graph_Copies.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS4[Array[String], Long, Long, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.update(value = values, where = where)    
     def updateP(values: Scr_Graph_Copies, where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS4[Array[String], Long, Long, LocalDateTime], where: WhereParam): List[Int] = Scr_Graph_Copies.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_Graph_Copies, where: WhereParam): List[Int] = Scr_Graph_Copies.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Graph_Copies.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}