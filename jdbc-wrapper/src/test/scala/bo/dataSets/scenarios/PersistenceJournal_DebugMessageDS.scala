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



 
case class PersistenceJournal_DebugMessageDSData(messagePersistenceJournal_Debug: Blob, persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long) {

}


 
object PersistenceJournal_DebugMessageDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugMessageDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournal_DebugMessageDS    
    
    val objectName = "PersistenceJournal_Debug"    
    val groupName = "scenarios"
}


 
class PersistenceJournal_DebugMessageDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceJournal_DebugMessageDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournal_DebugMessageDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
////////////////////////////////////// Class: PersistenceJournal_DebugBo, group: scenarios //////////////////////////////////////    
    
    val PersistenceJournal_Debug = new PersistenceJournal_DebugBoMessage(alias = alias + "B0".als)    
    
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
    val messagePersistenceJournal_Debug = PersistenceJournal_Debug.message    
    val persistence_idPersistenceJournal_Debug = PersistenceJournal_Debug.persistence_id    
    val sequence_numberPersistenceJournal_Debug = PersistenceJournal_Debug.sequence_number    
///////////////////////////////////// End Class: PersistenceJournal_DebugBo, group: scenarios /////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceJournal_Debug),KeyConstraintData(sequence_numberPersistenceJournal_Debug)))    
    
    // For select tuple: (messagePersistenceJournal_Debug: Blob, persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long)    
    
    type ColumnTypes =     TupleSS3[Blob, String, Long]    
     def allColumns = messagePersistenceJournal_Debug  ~ persistence_idPersistenceJournal_Debug  ~ sequence_numberPersistenceJournal_Debug     
     def allColumns1 = Seq(messagePersistenceJournal_Debug  , persistence_idPersistenceJournal_Debug  , sequence_numberPersistenceJournal_Debug )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournal_DebugMessageDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(messagePersistenceJournal_Debug: Blob, persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long) => 
                        PersistenceJournal_DebugMessageDSData(messagePersistenceJournal_Debug = messagePersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournal_DebugMessageDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(messagePersistenceJournal_Debug: Blob, persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long) => 
        PersistenceJournal_DebugMessageDSData(messagePersistenceJournal_Debug = messagePersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournal_DebugMessageDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceJournal_Debug), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(messagePersistenceJournal_Debug: Blob, persistence_idPersistenceJournal_Debug: String, sequence_numberPersistenceJournal_Debug: Long)) => 
                ValidationEx(Success(PersistenceJournal_DebugMessageDSData(messagePersistenceJournal_Debug = messagePersistenceJournal_Debug , persistence_idPersistenceJournal_Debug = persistence_idPersistenceJournal_Debug , sequence_numberPersistenceJournal_Debug = sequence_numberPersistenceJournal_Debug )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[Blob, String, Long]*): ValidationEx[List[Int]] = PersistenceJournal_Debug.insert(values: _*)    
     def insertP(values: PersistenceJournal_DebugMessage*): ValidationEx[List[Int]] = PersistenceJournal_Debug.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long]*): List[Int] = PersistenceJournal_Debug.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal_DebugMessage*): List[Int] = PersistenceJournal_Debug.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[Blob, String, Long], where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.update(value = values, where = where)    
     def updateP(values: PersistenceJournal_DebugMessage, where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long], where: WhereParam): List[Int] = PersistenceJournal_Debug.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceJournal_DebugMessage, where: WhereParam): List[Int] = PersistenceJournal_Debug.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal_Debug.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceJournal_Debug.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}