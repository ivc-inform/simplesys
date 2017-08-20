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



 
case class PersistenceSnapshot_DebugSnapshotDSData(persistence_idPersistenceSnapshot_Debug: String, sequence_numberPersistenceSnapshot_Debug: Long, snapshotPersistenceSnapshot_Debug: Blob) {

}


 
object PersistenceSnapshot_DebugSnapshotDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshot_DebugSnapshotDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshot_DebugSnapshotDS    
    
    val objectName = "PersistenceSnapshot_Debug"    
    val groupName = "scenarios"
}


 
class PersistenceSnapshot_DebugSnapshotDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceSnapshot_DebugSnapshotDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceSnapshot_DebugSnapshotDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////// Class: PersistenceSnapshot_DebugBo, group: scenarios /////////////////////////////////////    
    
    val PersistenceSnapshot_Debug = new PersistenceSnapshot_DebugBoSnapshot(alias = alias + "B0".als)    
    
    val fromBO = PersistenceSnapshot_Debug    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(PersistenceSnapshot_Debug), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val persistence_idPersistenceSnapshot_Debug = PersistenceSnapshot_Debug.persistence_id    
    val sequence_numberPersistenceSnapshot_Debug = PersistenceSnapshot_Debug.sequence_number    
    val snapshotPersistenceSnapshot_Debug = PersistenceSnapshot_Debug.snapshot    
//////////////////////////////////// End Class: PersistenceSnapshot_DebugBo, group: scenarios ////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceSnapshot_Debug),KeyConstraintData(sequence_numberPersistenceSnapshot_Debug)))    
    
    // For select tuple: (persistence_idPersistenceSnapshot_Debug: String, sequence_numberPersistenceSnapshot_Debug: Long, snapshotPersistenceSnapshot_Debug: Blob)    
    
    type ColumnTypes =     TupleSS3[String, Long, Blob]    
     def allColumns = persistence_idPersistenceSnapshot_Debug  ~ sequence_numberPersistenceSnapshot_Debug  ~ snapshotPersistenceSnapshot_Debug     
     def allColumns1 = Seq(persistence_idPersistenceSnapshot_Debug  , sequence_numberPersistenceSnapshot_Debug  , snapshotPersistenceSnapshot_Debug )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceSnapshot_DebugSnapshotDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(persistence_idPersistenceSnapshot_Debug: String, sequence_numberPersistenceSnapshot_Debug: Long, snapshotPersistenceSnapshot_Debug: Blob) => 
                        PersistenceSnapshot_DebugSnapshotDSData(persistence_idPersistenceSnapshot_Debug = persistence_idPersistenceSnapshot_Debug , sequence_numberPersistenceSnapshot_Debug = sequence_numberPersistenceSnapshot_Debug , snapshotPersistenceSnapshot_Debug = snapshotPersistenceSnapshot_Debug )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceSnapshot_DebugSnapshotDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(persistence_idPersistenceSnapshot_Debug: String, sequence_numberPersistenceSnapshot_Debug: Long, snapshotPersistenceSnapshot_Debug: Blob) => 
        PersistenceSnapshot_DebugSnapshotDSData(persistence_idPersistenceSnapshot_Debug = persistence_idPersistenceSnapshot_Debug , sequence_numberPersistenceSnapshot_Debug = sequence_numberPersistenceSnapshot_Debug , snapshotPersistenceSnapshot_Debug = snapshotPersistenceSnapshot_Debug )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceSnapshot_DebugSnapshotDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceSnapshot_Debug), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(persistence_idPersistenceSnapshot_Debug: String, sequence_numberPersistenceSnapshot_Debug: Long, snapshotPersistenceSnapshot_Debug: Blob)) => 
                ValidationEx(Success(PersistenceSnapshot_DebugSnapshotDSData(persistence_idPersistenceSnapshot_Debug = persistence_idPersistenceSnapshot_Debug , sequence_numberPersistenceSnapshot_Debug = sequence_numberPersistenceSnapshot_Debug , snapshotPersistenceSnapshot_Debug = snapshotPersistenceSnapshot_Debug )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[String, Long, Blob]*): ValidationEx[List[Int]] = PersistenceSnapshot_Debug.insert(values: _*)    
     def insertP(values: PersistenceSnapshot_DebugSnapshot*): ValidationEx[List[Int]] = PersistenceSnapshot_Debug.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob]*): List[Int] = PersistenceSnapshot_Debug.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceSnapshot_DebugSnapshot*): List[Int] = PersistenceSnapshot_Debug.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[String, Long, Blob], where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot_Debug.update(value = values, where = where)    
     def updateP(values: PersistenceSnapshot_DebugSnapshot, where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot_Debug.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob], where: WhereParam): List[Int] = PersistenceSnapshot_Debug.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceSnapshot_DebugSnapshot, where: WhereParam): List[Int] = PersistenceSnapshot_Debug.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot_Debug.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceSnapshot_Debug.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}