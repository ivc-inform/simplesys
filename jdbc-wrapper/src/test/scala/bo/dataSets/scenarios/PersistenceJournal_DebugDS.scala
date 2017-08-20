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



 
case class PersistenceJournal_DebugDSData(createdPersistenceJournal_Debug: Long, deletedPersistenceJournal_Debug: Array[Boolean], orderingPersistenceJournal_Debug: Array[Long], persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long, tagsPersistenceJournal_Debug: Array[String], timestampPersistenceJournal_Debug: LocalDateTime) {

}


 
object PersistenceJournal_DebugDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugDS    
    
    val objectName = "PersistenceJournal_Debug"    
    val groupName = "scenarios"
}


 
class PersistenceJournal_DebugDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceJournal_DebugDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournal_DebugDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
////////////////////////////////////// Class: PersistenceJournal_DebugBo, group: scenarios //////////////////////////////////////    
    
    val PersistenceJournal_Debug = new PersistenceJournal_DebugBo(alias = alias + "B0".als)    
    
    val fromBO = PersistenceJournal_Debug    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(PersistenceJournal_Debug), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val createdPersistenceJournal_Debug = PersistenceJournal_Debug.created    
    val deletedPersistenceJournal_Debug = PersistenceJournal_Debug.deleted    
    val orderingPersistenceJournal_Debug = PersistenceJournal_Debug.ordering    
    val persistence_idPersistenceJournal_Debug = PersistenceJournal_Debug.persistence_id    
    val sequence_numberPersistenceJournal_Debug = PersistenceJournal_Debug.sequence_number    
    val tagsPersistenceJournal_Debug = PersistenceJournal_Debug.tags    
    val timestampPersistenceJournal_Debug = PersistenceJournal_Debug.timestamp    
///////////////////////////////////// End Class: PersistenceJournal_DebugBo, group: scenarios /////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceJournal_Debug),KeyConstraintData(sequence_numberPersistenceJournal_Debug)))    
    
    // For select tuple: (createdPersistenceJournal_Debug: Long, deletedPersistenceJournal_Debug: Array[Boolean], orderingPersistenceJournal_Debug: Array[Long], persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long, tagsPersistenceJournal_Debug: Array[String], timestampPersistenceJournal_Debug: LocalDateTime)    
    
    type ColumnTypes =     TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]    
     def allColumns = createdPersistenceJournal_Debug  ~ deletedPersistenceJournal_Debug  ~ orderingPersistenceJournal_Debug  ~ persistence_idPersistenceJournal_Debug  ~ sequence_numberPersistenceJournal_Debug  ~ tagsPersistenceJournal_Debug  ~ timestampPersistenceJournal_Debug     
     def allColumns1 = Seq(createdPersistenceJournal_Debug  , deletedPersistenceJournal_Debug  , orderingPersistenceJournal_Debug  , persistence_idPersistenceJournal_Debug  , sequence_numberPersistenceJournal_Debug  , tagsPersistenceJournal_Debug  , timestampPersistenceJournal_Debug )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournal_DebugDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(createdPersistenceJournal_Debug: Long, deletedPersistenceJournal_Debug: Array[Boolean], orderingPersistenceJournal_Debug: Array[Long], persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long, tagsPersistenceJournal_Debug: Array[String], timestampPersistenceJournal_Debug: LocalDateTime) => 
                        PersistenceJournal_DebugDSData(createdPersistenceJournal_Debug = createdPersistenceJournal_Debug , deletedPersistenceJournal_Debug = deletedPersistenceJournal_Debug , orderingPersistenceJournal_Debug = orderingPersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug , tagsPersistenceJournal_Debug = tagsPersistenceJournal_Debug , timestampPersistenceJournal_Debug = timestampPersistenceJournal_Debug )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournal_DebugDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(createdPersistenceJournal_Debug: Long, deletedPersistenceJournal_Debug: Array[Boolean], orderingPersistenceJournal_Debug: Array[Long], persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long, tagsPersistenceJournal_Debug: Array[String], timestampPersistenceJournal_Debug: LocalDateTime) => 
        PersistenceJournal_DebugDSData(createdPersistenceJournal_Debug = createdPersistenceJournal_Debug , deletedPersistenceJournal_Debug = deletedPersistenceJournal_Debug , orderingPersistenceJournal_Debug = orderingPersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug , tagsPersistenceJournal_Debug = tagsPersistenceJournal_Debug , timestampPersistenceJournal_Debug = timestampPersistenceJournal_Debug )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournal_DebugDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(createdPersistenceJournal_Debug: Long, deletedPersistenceJournal_Debug: Array[Boolean], orderingPersistenceJournal_Debug: Array[Long], persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long, tagsPersistenceJournal_Debug: Array[String], timestampPersistenceJournal_Debug: LocalDateTime)) => 
                ValidationEx(Success(PersistenceJournal_DebugDSData(createdPersistenceJournal_Debug = createdPersistenceJournal_Debug , deletedPersistenceJournal_Debug = deletedPersistenceJournal_Debug , orderingPersistenceJournal_Debug = orderingPersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug , tagsPersistenceJournal_Debug = tagsPersistenceJournal_Debug , timestampPersistenceJournal_Debug = timestampPersistenceJournal_Debug )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): ValidationEx[List[Int]] = PersistenceJournal_Debug.insert(values: _*)    
     def insertP(values: PersistenceJournal_Debug*): ValidationEx[List[Int]] = PersistenceJournal_Debug.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): List[Int] = PersistenceJournal_Debug.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal_Debug*): List[Int] = PersistenceJournal_Debug.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.update(value = values, where = where)    
     def updateP(values: PersistenceJournal_Debug, where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): List[Int] = PersistenceJournal_Debug.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceJournal_Debug, where: WhereParam): List[Int] = PersistenceJournal_Debug.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceJournal_Debug.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}