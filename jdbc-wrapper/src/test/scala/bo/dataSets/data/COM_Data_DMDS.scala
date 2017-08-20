// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenDSs"

package ru.simplesys.defs.bo
package data

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



 
case class COM_Data_DMDSData(acnCOM_Data_DM: Array[Long], acnCodeCOM_Data_DM: String, addressCOM_Data_DM: String, cnrCOM_Data_DM: Array[Long], cnrCodeCOM_Data_DM: Array[String], dlv_errorCOM_Data_DM: Array[String], dlv_statusCOM_Data_DM: String, dlv_status_atCOM_Data_DM: LocalDateTime, idCOM_Data_DM: BigDecimal, start_timeCOM_Data_DM: Array[LocalDateTime], subjectCOM_Data_DM: String, textCOM_Data_DM: String, timestampCOM_Data_DM: LocalDateTime) {

}


 
object COM_Data_DMDS {
     def apply(implicit dataSource: BoneCPDataSource) = new COM_Data_DMDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new COM_Data_DMDS    
    
    val objectName = "COM_Data_DM"    
    val groupName = "data"
}


 
class COM_Data_DMDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[COM_Data_DMDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): COM_Data_DMDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
////////////////////////////////////////// Class: COM_Data_DMBo, group: data //////////////////////////////////////////    
    
    val COM_Data_DM = new COM_Data_DMBo(alias = alias + "B0".als)    
    
    val fromBO = COM_Data_DM    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(COM_Data_DM), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val acnCOM_Data_DM = COM_Data_DM.acn    
    val acnCodeCOM_Data_DM = COM_Data_DM.acnCode    
    val addressCOM_Data_DM = COM_Data_DM.address    
    val cnrCOM_Data_DM = COM_Data_DM.cnr    
    val cnrCodeCOM_Data_DM = COM_Data_DM.cnrCode    
    val dlv_errorCOM_Data_DM = COM_Data_DM.dlv_error    
    val dlv_statusCOM_Data_DM = COM_Data_DM.dlv_status    
    val dlv_status_atCOM_Data_DM = COM_Data_DM.dlv_status_at    
    val idCOM_Data_DM = COM_Data_DM.id    
    val start_timeCOM_Data_DM = COM_Data_DM.start_time    
    val subjectCOM_Data_DM = COM_Data_DM.subject    
    val textCOM_Data_DM = COM_Data_DM.text    
    val timestampCOM_Data_DM = COM_Data_DM.timestamp    
///////////////////////////////////////// End Class: COM_Data_DMBo, group: data /////////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idCOM_Data_DM)))    
    
    // For select tuple: (acnCOM_Data_DM: Array[Long], acnCodeCOM_Data_DM: String, addressCOM_Data_DM: String, cnrCOM_Data_DM: Array[Long], cnrCodeCOM_Data_DM: Array[String], dlv_errorCOM_Data_DM: Array[String], dlv_statusCOM_Data_DM: String, dlv_status_atCOM_Data_DM: LocalDateTime, idCOM_Data_DM: BigDecimal, start_timeCOM_Data_DM: Array[LocalDateTime], subjectCOM_Data_DM: String, textCOM_Data_DM: String, timestampCOM_Data_DM: LocalDateTime)    
    
    type ColumnTypes =     TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]    
     def allColumns = acnCOM_Data_DM  ~ acnCodeCOM_Data_DM  ~ addressCOM_Data_DM  ~ cnrCOM_Data_DM  ~ cnrCodeCOM_Data_DM  ~ dlv_errorCOM_Data_DM  ~ dlv_statusCOM_Data_DM  ~ dlv_status_atCOM_Data_DM  ~ idCOM_Data_DM  ~ start_timeCOM_Data_DM  ~ subjectCOM_Data_DM  ~ textCOM_Data_DM  ~ timestampCOM_Data_DM     
     def allColumns1 = Seq(acnCOM_Data_DM  , acnCodeCOM_Data_DM  , addressCOM_Data_DM  , cnrCOM_Data_DM  , cnrCodeCOM_Data_DM  , dlv_errorCOM_Data_DM  , dlv_statusCOM_Data_DM  , dlv_status_atCOM_Data_DM  , idCOM_Data_DM  , start_timeCOM_Data_DM  , subjectCOM_Data_DM  , textCOM_Data_DM  , timestampCOM_Data_DM )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[COM_Data_DMDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS13(acnCOM_Data_DM: Array[Long], acnCodeCOM_Data_DM: String, addressCOM_Data_DM: String, cnrCOM_Data_DM: Array[Long], cnrCodeCOM_Data_DM: Array[String], dlv_errorCOM_Data_DM: Array[String], dlv_statusCOM_Data_DM: String, dlv_status_atCOM_Data_DM: LocalDateTime, idCOM_Data_DM: BigDecimal, start_timeCOM_Data_DM: Array[LocalDateTime], subjectCOM_Data_DM: String, textCOM_Data_DM: String, timestampCOM_Data_DM: LocalDateTime) => 
                        COM_Data_DMDSData(acnCOM_Data_DM = acnCOM_Data_DM , acnCodeCOM_Data_DM = acnCodeCOM_Data_DM , addressCOM_Data_DM = addressCOM_Data_DM , cnrCOM_Data_DM = cnrCOM_Data_DM , cnrCodeCOM_Data_DM = cnrCodeCOM_Data_DM , dlv_errorCOM_Data_DM = dlv_errorCOM_Data_DM , dlv_statusCOM_Data_DM = dlv_statusCOM_Data_DM , dlv_status_atCOM_Data_DM = dlv_status_atCOM_Data_DM , idCOM_Data_DM = idCOM_Data_DM , start_timeCOM_Data_DM = start_timeCOM_Data_DM , subjectCOM_Data_DM = subjectCOM_Data_DM , textCOM_Data_DM = textCOM_Data_DM , timestampCOM_Data_DM = timestampCOM_Data_DM )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[COM_Data_DMDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS13(acnCOM_Data_DM: Array[Long], acnCodeCOM_Data_DM: String, addressCOM_Data_DM: String, cnrCOM_Data_DM: Array[Long], cnrCodeCOM_Data_DM: Array[String], dlv_errorCOM_Data_DM: Array[String], dlv_statusCOM_Data_DM: String, dlv_status_atCOM_Data_DM: LocalDateTime, idCOM_Data_DM: BigDecimal, start_timeCOM_Data_DM: Array[LocalDateTime], subjectCOM_Data_DM: String, textCOM_Data_DM: String, timestampCOM_Data_DM: LocalDateTime) => 
        COM_Data_DMDSData(acnCOM_Data_DM = acnCOM_Data_DM , acnCodeCOM_Data_DM = acnCodeCOM_Data_DM , addressCOM_Data_DM = addressCOM_Data_DM , cnrCOM_Data_DM = cnrCOM_Data_DM , cnrCodeCOM_Data_DM = cnrCodeCOM_Data_DM , dlv_errorCOM_Data_DM = dlv_errorCOM_Data_DM , dlv_statusCOM_Data_DM = dlv_statusCOM_Data_DM , dlv_status_atCOM_Data_DM = dlv_status_atCOM_Data_DM , idCOM_Data_DM = idCOM_Data_DM , start_timeCOM_Data_DM = start_timeCOM_Data_DM , subjectCOM_Data_DM = subjectCOM_Data_DM , textCOM_Data_DM = textCOM_Data_DM , timestampCOM_Data_DM = timestampCOM_Data_DM )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[COM_Data_DMDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(COM_Data_DM), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS13(acnCOM_Data_DM: Array[Long], acnCodeCOM_Data_DM: String, addressCOM_Data_DM: String, cnrCOM_Data_DM: Array[Long], cnrCodeCOM_Data_DM: Array[String], dlv_errorCOM_Data_DM: Array[String], dlv_statusCOM_Data_DM: String, dlv_status_atCOM_Data_DM: LocalDateTime, idCOM_Data_DM: BigDecimal, start_timeCOM_Data_DM: Array[LocalDateTime], subjectCOM_Data_DM: String, textCOM_Data_DM: String, timestampCOM_Data_DM: LocalDateTime)) => 
                ValidationEx(Success(COM_Data_DMDSData(acnCOM_Data_DM = acnCOM_Data_DM , acnCodeCOM_Data_DM = acnCodeCOM_Data_DM , addressCOM_Data_DM = addressCOM_Data_DM , cnrCOM_Data_DM = cnrCOM_Data_DM , cnrCodeCOM_Data_DM = cnrCodeCOM_Data_DM , dlv_errorCOM_Data_DM = dlv_errorCOM_Data_DM , dlv_statusCOM_Data_DM = dlv_statusCOM_Data_DM , dlv_status_atCOM_Data_DM = dlv_status_atCOM_Data_DM , idCOM_Data_DM = idCOM_Data_DM , start_timeCOM_Data_DM = start_timeCOM_Data_DM , subjectCOM_Data_DM = subjectCOM_Data_DM , textCOM_Data_DM = textCOM_Data_DM , timestampCOM_Data_DM = timestampCOM_Data_DM )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): ValidationEx[List[Int]] = COM_Data_DM.insert(values: _*)    
     def insertP(values: COM_Data_DM*): ValidationEx[List[Int]] = COM_Data_DM.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime]*): List[Int] = COM_Data_DM.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: COM_Data_DM*): List[Int] = COM_Data_DM.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = COM_Data_DM.update(value = values, where = where)    
     def updateP(values: COM_Data_DM, where: WhereParam): ValidationEx[List[Int]] = COM_Data_DM.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS13[Array[Long], String, String, Array[Long], Array[String], Array[String], String, LocalDateTime, BigDecimal, Array[LocalDateTime], String, String, LocalDateTime], where: WhereParam): List[Int] = COM_Data_DM.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: COM_Data_DM, where: WhereParam): List[Int] = COM_Data_DM.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = COM_Data_DM.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = COM_Data_DM.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}