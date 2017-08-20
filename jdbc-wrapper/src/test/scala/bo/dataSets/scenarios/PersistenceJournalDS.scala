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



 
case class PersistenceJournalDSData(createdPersistenceJournal: Long, deletedPersistenceJournal: Array[Boolean], orderingPersistenceJournal: Array[Long], persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long, tagsPersistenceJournal: Array[String], timestampPersistenceJournal: LocalDateTime) {

}


 
object PersistenceJournalDS {
     def apply(implicit dataSource: BoneCPDataSource) = new PersistenceJournalDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new PersistenceJournalDS    
    
    val objectName = "PersistenceJournal"    
    val groupName = "scenarios"
}


 
class PersistenceJournalDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[PersistenceJournalDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): PersistenceJournalDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////// Class: PersistenceJournalBo, group: scenarios ///////////////////////////////////////    
    
    val PersistenceJournal = new PersistenceJournalBo(alias = alias + "B0".als)    
    
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
    val createdPersistenceJournal = PersistenceJournal.created    
    val deletedPersistenceJournal = PersistenceJournal.deleted    
    val orderingPersistenceJournal = PersistenceJournal.ordering    
    val persistence_idPersistenceJournal = PersistenceJournal.persistence_id    
    val sequence_numberPersistenceJournal = PersistenceJournal.sequence_number    
    val tagsPersistenceJournal = PersistenceJournal.tags    
    val timestampPersistenceJournal = PersistenceJournal.timestamp    
////////////////////////////////////// End Class: PersistenceJournalBo, group: scenarios //////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(persistence_idPersistenceJournal),KeyConstraintData(sequence_numberPersistenceJournal)))    
    
    // For select tuple: (createdPersistenceJournal: Long, deletedPersistenceJournal: Array[Boolean], orderingPersistenceJournal: Array[Long], persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long, tagsPersistenceJournal: Array[String], timestampPersistenceJournal: LocalDateTime)    
    
    type ColumnTypes =     TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]    
     def allColumns = createdPersistenceJournal  ~ deletedPersistenceJournal  ~ orderingPersistenceJournal  ~ persistence_idPersistenceJournal  ~ sequence_numberPersistenceJournal  ~ tagsPersistenceJournal  ~ timestampPersistenceJournal     
     def allColumns1 = Seq(createdPersistenceJournal  , deletedPersistenceJournal  , orderingPersistenceJournal  , persistence_idPersistenceJournal  , sequence_numberPersistenceJournal  , tagsPersistenceJournal  , timestampPersistenceJournal )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[PersistenceJournalDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(createdPersistenceJournal: Long, deletedPersistenceJournal: Array[Boolean], orderingPersistenceJournal: Array[Long], persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long, tagsPersistenceJournal: Array[String], timestampPersistenceJournal: LocalDateTime) => 
                        PersistenceJournalDSData(createdPersistenceJournal = createdPersistenceJournal , deletedPersistenceJournal = deletedPersistenceJournal , orderingPersistenceJournal = orderingPersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal , tagsPersistenceJournal = tagsPersistenceJournal , timestampPersistenceJournal = timestampPersistenceJournal )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[PersistenceJournalDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(createdPersistenceJournal: Long, deletedPersistenceJournal: Array[Boolean], orderingPersistenceJournal: Array[Long], persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long, tagsPersistenceJournal: Array[String], timestampPersistenceJournal: LocalDateTime) => 
        PersistenceJournalDSData(createdPersistenceJournal = createdPersistenceJournal , deletedPersistenceJournal = deletedPersistenceJournal , orderingPersistenceJournal = orderingPersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal , tagsPersistenceJournal = tagsPersistenceJournal , timestampPersistenceJournal = timestampPersistenceJournal )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[PersistenceJournalDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(PersistenceJournal), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(createdPersistenceJournal: Long, deletedPersistenceJournal: Array[Boolean], orderingPersistenceJournal: Array[Long], persistence_idPersistenceJournal: String, sequence_numberPersistenceJournal: Long, tagsPersistenceJournal: Array[String], timestampPersistenceJournal: LocalDateTime)) => 
                ValidationEx(Success(PersistenceJournalDSData(createdPersistenceJournal = createdPersistenceJournal , deletedPersistenceJournal = deletedPersistenceJournal , orderingPersistenceJournal = orderingPersistenceJournal , persistence_idPersistenceJournal = persistence_idPersistenceJournal , sequence_numberPersistenceJournal = sequence_numberPersistenceJournal , tagsPersistenceJournal = tagsPersistenceJournal , timestampPersistenceJournal = timestampPersistenceJournal )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): ValidationEx[List[Int]] = PersistenceJournal.insert(values: _*)    
     def insertP(values: PersistenceJournal*): ValidationEx[List[Int]] = PersistenceJournal.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime]*): List[Int] = PersistenceJournal.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: PersistenceJournal*): List[Int] = PersistenceJournal.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.update(value = values, where = where)    
     def updateP(values: PersistenceJournal, where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS7[Long, Array[Boolean], Array[Long], String, Long, Array[String], LocalDateTime], where: WhereParam): List[Int] = PersistenceJournal.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: PersistenceJournal, where: WhereParam): List[Int] = PersistenceJournal.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = PersistenceJournal.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = PersistenceJournal.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}