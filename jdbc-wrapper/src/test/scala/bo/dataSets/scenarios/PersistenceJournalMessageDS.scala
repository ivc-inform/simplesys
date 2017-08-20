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



 
case class PersistenceJournalMessageDSData(messagePersistenceJournal: Blob, persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long) {

}


 
object PersistenceJournalMessageDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournalMessageDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournalMessageDS    
    
    val objectName = "PersistenceJournal"    
    val groupName = "scenarios"
}


 
class PersistenceJournalMessageDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceJournalMessageDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournalMessageDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////// Class: PersistenceJournalBo, group: scenarios ///////////////////////////////////////    
    
    val PersistenceJournal = new PersistenceJournalBoMessage(alias = alias + "B0".als)    
    
    val fromBO = PersistenceJournal    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(PersistenceJournal), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val messagePersistenceJournal = PersistenceJournal.message    
    val persistence_idPersistenceJournal = PersistenceJournal.persistence_id    
    val sequence_numberPersistenceJournal = PersistenceJournal.sequence_number    
////////////////////////////////////// End Class: PersistenceJournalBo, group: scenarios //////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceJournal),KeyConstraintData(sequence_numberPersistenceJournal)))    
    
    // For select tuple: (messagePersistenceJournal: Blob, persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long)    
    
    type ColumnTypes =     TupleSS3[Blob, String, Long]    
     def allColumns = messagePersistenceJournal  ~ persistence_idPersistenceJournal  ~ sequence_numberPersistenceJournal     
     def allColumns1 = Seq(messagePersistenceJournal  , persistence_idPersistenceJournal  , sequence_numberPersistenceJournal )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournalMessageDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS3(messagePersistenceJournal: Blob, persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long) => 
                        PersistenceJournalMessageDSData(messagePersistenceJournal = messagePersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournalMessageDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS3(messagePersistenceJournal: Blob, persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long) => 
        PersistenceJournalMessageDSData(messagePersistenceJournal = messagePersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournalMessageDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS3(messagePersistenceJournal: Blob, persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long)) => 
                ValidationEx(Success(PersistenceJournalMessageDSData(messagePersistenceJournal = messagePersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[Blob, String, Long]*): ValidationEx[List[Int]] = PersistenceJournal.insert(values: _*)    
     def insertP(values: PersistenceJournalMessage*): ValidationEx[List[Int]] = PersistenceJournal.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long]*): List[Int] = PersistenceJournal.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournalMessage*): List[Int] = PersistenceJournal.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[Blob, String, Long], where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.update(value = values, where = where)    
     def updateP(values: PersistenceJournalMessage, where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[Blob, String, Long], where: WhereParam): List[Int] = PersistenceJournal.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceJournalMessage, where: WhereParam): List[Int] = PersistenceJournal.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceJournal.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}