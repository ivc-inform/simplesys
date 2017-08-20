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



 
case class PersistenceSnapshotSnapshotDSData(persistence_idPersistenceSnapshot: String, sequence_numberPersistenceSnapshot: Long, snapshotPersistenceSnapshot: Blob) {

}


 
object PersistenceSnapshotSnapshotDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotSnapshotDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceSnapshotSnapshotDS    
    
    val objectName = "PersistenceSnapshot"    
    val groupName = "scenarios"
}


 
class PersistenceSnapshotSnapshotDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceSnapshotSnapshotDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceSnapshotSnapshotDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////// Class: PersistenceSnapshotBo, group: scenarios ///////////////////////////////////////    
    
    val PersistenceSnapshot = new PersistenceSnapshotBoSnapshot(alias = alias + "B0".als)    
    
    val fromBO = PersistenceSnapshot    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(PersistenceSnapshot), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val persistence_idPersistenceSnapshot = PersistenceSnapshot.persistence_id    
    val sequence_numberPersistenceSnapshot = PersistenceSnapshot.sequence_number    
    val snapshotPersistenceSnapshot = PersistenceSnapshot.snapshot    
////////////////////////////////////// End Class: PersistenceSnapshotBo, group: scenarios //////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceSnapshot),KeyConstraintData(sequence_numberPersistenceSnapshot)))    
    
    // For select tuple: (persistence_idPersistenceSnapshot: String, sequence_numberPersistenceSnapshot: Long, snapshotPersistenceSnapshot: Blob)    
    
    type ColumnTypes =     TupleSS3[String, Long, Blob]    
     def allColumns = persistence_idPersistenceSnapshot  ~ sequence_numberPersistenceSnapshot  ~ snapshotPersistenceSnapshot     
     def allColumns1 = Seq(persistence_idPersistenceSnapshot  , sequence_numberPersistenceSnapshot  , snapshotPersistenceSnapshot )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceSnapshotSnapshotDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(persistence_idPersistenceSnapshot: String, sequence_numberPersistenceSnapshot: Long, snapshotPersistenceSnapshot: Blob) => 
                        PersistenceSnapshotSnapshotDSData(persistence_idPersistenceSnapshot = persistence_idPersistenceSnapshot , sequence_numberPersistenceSnapshot = sequence_numberPersistenceSnapshot , snapshotPersistenceSnapshot = snapshotPersistenceSnapshot )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceSnapshotSnapshotDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(persistence_idPersistenceSnapshot: String, sequence_numberPersistenceSnapshot: Long, snapshotPersistenceSnapshot: Blob) => 
        PersistenceSnapshotSnapshotDSData(persistence_idPersistenceSnapshot = persistence_idPersistenceSnapshot , sequence_numberPersistenceSnapshot = sequence_numberPersistenceSnapshot , snapshotPersistenceSnapshot = snapshotPersistenceSnapshot )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceSnapshotSnapshotDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceSnapshot), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(persistence_idPersistenceSnapshot: String, sequence_numberPersistenceSnapshot: Long, snapshotPersistenceSnapshot: Blob)) => 
                ValidationEx(Success(PersistenceSnapshotSnapshotDSData(persistence_idPersistenceSnapshot = persistence_idPersistenceSnapshot , sequence_numberPersistenceSnapshot = sequence_numberPersistenceSnapshot , snapshotPersistenceSnapshot = snapshotPersistenceSnapshot )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[String, Long, Blob]*): ValidationEx[List[Int]] = PersistenceSnapshot.insert(values: _*)    
     def insertP(values: PersistenceSnapshotSnapshot*): ValidationEx[List[Int]] = PersistenceSnapshot.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob]*): List[Int] = PersistenceSnapshot.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceSnapshotSnapshot*): List[Int] = PersistenceSnapshot.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[String, Long, Blob], where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot.update(value = values, where = where)    
     def updateP(values: PersistenceSnapshotSnapshot, where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Blob], where: WhereParam): List[Int] = PersistenceSnapshot.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceSnapshotSnapshot, where: WhereParam): List[Int] = PersistenceSnapshot.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceSnapshot.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceSnapshot.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}