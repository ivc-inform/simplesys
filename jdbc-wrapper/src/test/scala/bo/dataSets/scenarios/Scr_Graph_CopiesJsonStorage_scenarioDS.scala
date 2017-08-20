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



 
case class Scr_Graph_CopiesJsonStorage_scenarioDSData(idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, jsonStorage_scenarioScr_Graph_Copies: Array[Json]) {

}


 
object Scr_Graph_CopiesJsonStorage_scenarioDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesJsonStorage_scenarioDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesJsonStorage_scenarioDS    
    
    val objectName = "Scr_Graph_Copies"    
    val groupName = "scenarios"
}


 
class Scr_Graph_CopiesJsonStorage_scenarioDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_Graph_CopiesJsonStorage_scenarioDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_Graph_CopiesJsonStorage_scenarioDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
//////////////////////////////////////// Class: Scr_Graph_CopiesBo, group: scenarios ////////////////////////////////////////    
    
    val Scr_Graph_Copies = new Scr_Graph_CopiesBoJsonStorage_scenario(alias = alias + "B0".als)    
    
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
    val idScr_Graph_Copies = Scr_Graph_Copies.id    
    val id_scenario_refScr_Graph_Copies = Scr_Graph_Copies.id_scenario_ref    
    val jsonStorage_scenarioScr_Graph_Copies = Scr_Graph_Copies.jsonStorage_scenario    
/////////////////////////////////////// End Class: Scr_Graph_CopiesBo, group: scenarios ///////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idScr_Graph_Copies),KeyConstraintData(id_scenario_refScr_Graph_Copies)))    
    
    // For select tuple: (idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, jsonStorage_scenarioScr_Graph_Copies: Array[Json])    
    
    type ColumnTypes =     TupleSS3[Long, Long, Array[Json]]    
     def allColumns = idScr_Graph_Copies  ~ id_scenario_refScr_Graph_Copies  ~ jsonStorage_scenarioScr_Graph_Copies     
     def allColumns1 = Seq(idScr_Graph_Copies  , id_scenario_refScr_Graph_Copies  , jsonStorage_scenarioScr_Graph_Copies )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_Graph_CopiesJsonStorage_scenarioDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, jsonStorage_scenarioScr_Graph_Copies: Array[Json]) => 
                        Scr_Graph_CopiesJsonStorage_scenarioDSData(idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , jsonStorage_scenarioScr_Graph_Copies = jsonStorage_scenarioScr_Graph_Copies )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_Graph_CopiesJsonStorage_scenarioDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, jsonStorage_scenarioScr_Graph_Copies: Array[Json]) => 
        Scr_Graph_CopiesJsonStorage_scenarioDSData(idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , jsonStorage_scenarioScr_Graph_Copies = jsonStorage_scenarioScr_Graph_Copies )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_Graph_CopiesJsonStorage_scenarioDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Graph_Copies), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(idScr_Graph_Copies: Long, id_scenario_refScr_Graph_Copies: Long, jsonStorage_scenarioScr_Graph_Copies: Array[Json])) => 
                ValidationEx(Success(Scr_Graph_CopiesJsonStorage_scenarioDSData(idScr_Graph_Copies = idScr_Graph_Copies , id_scenario_refScr_Graph_Copies = id_scenario_refScr_Graph_Copies , jsonStorage_scenarioScr_Graph_Copies = jsonStorage_scenarioScr_Graph_Copies )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[Long, Long, Array[Json]]*): ValidationEx[List[Int]] = Scr_Graph_Copies.insert(values: _*)    
     def insertP(values: Scr_Graph_CopiesJsonStorage_scenario*): ValidationEx[List[Int]] = Scr_Graph_Copies.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Long, Long, Array[Json]]*): List[Int] = Scr_Graph_Copies.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_Graph_CopiesJsonStorage_scenario*): List[Int] = Scr_Graph_Copies.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[Long, Long, Array[Json]], where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.update(value = values, where = where)    
     def updateP(values: Scr_Graph_CopiesJsonStorage_scenario, where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[Long, Long, Array[Json]], where: WhereParam): List[Int] = Scr_Graph_Copies.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_Graph_CopiesJsonStorage_scenario, where: WhereParam): List[Int] = Scr_Graph_Copies.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Graph_Copies.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Graph_Copies.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}