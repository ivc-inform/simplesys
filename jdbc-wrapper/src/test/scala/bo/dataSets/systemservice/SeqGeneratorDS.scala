// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenDSs"

package ru.simplesys.defs.bo
package systemservice

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



 
case class SeqGeneratorDSData(maxValueSeqGenerator: Long, nameSeqSeqGenerator: String) {

}


 
object SeqGeneratorDS {
     def apply(implicit dataSource: BoneCPDataSource) = new SeqGeneratorDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new SeqGeneratorDS    
    
    val objectName = "SeqGenerator"    
    val groupName = "systemservice"
}


 
class SeqGeneratorDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[SeqGeneratorDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): SeqGeneratorDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
//////////////////////////////////////// Class: SeqGeneratorBo, group: systemservice ////////////////////////////////////////    
    
    val SeqGenerator = new SeqGeneratorBo(alias = alias + "B0".als)    
    
    val fromBO = SeqGenerator    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(SeqGenerator), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val maxValueSeqGenerator = SeqGenerator.maxValue    
    val nameSeqSeqGenerator = SeqGenerator.nameSeq    
/////////////////////////////////////// End Class: SeqGeneratorBo, group: systemservice ///////////////////////////////////////    
    override val boCount = 1    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(nameSeqSeqGenerator)))    
    
    // For select tuple: (maxValueSeqGenerator: Long, nameSeqSeqGenerator: String)    
    
    type ColumnTypes =     TupleSS2[Long, String]    
     def allColumns = maxValueSeqGenerator  ~ nameSeqSeqGenerator     
     def allColumns1 = Seq(maxValueSeqGenerator  , nameSeqSeqGenerator )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[SeqGeneratorDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS2(maxValueSeqGenerator: Long, nameSeqSeqGenerator: String) => 
                        SeqGeneratorDSData(maxValueSeqGenerator = maxValueSeqGenerator , nameSeqSeqGenerator = nameSeqSeqGenerator )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[SeqGeneratorDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS2(maxValueSeqGenerator: Long, nameSeqSeqGenerator: String) => 
        SeqGeneratorDSData(maxValueSeqGenerator = maxValueSeqGenerator , nameSeqSeqGenerator = nameSeqSeqGenerator )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[SeqGeneratorDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(SeqGenerator), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS2(maxValueSeqGenerator: Long, nameSeqSeqGenerator: String)) => 
                ValidationEx(Success(SeqGeneratorDSData(maxValueSeqGenerator = maxValueSeqGenerator , nameSeqSeqGenerator = nameSeqSeqGenerator )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS2[Long, String]*): ValidationEx[List[Int]] = SeqGenerator.insert(values: _*)    
     def insertP(values: SeqGenerator*): ValidationEx[List[Int]] = SeqGenerator.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, String]*): List[Int] = SeqGenerator.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: SeqGenerator*): List[Int] = SeqGenerator.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS2[Long, String], where: WhereParam): ValidationEx[List[Int]] = SeqGenerator.update(value = values, where = where)    
     def updateP(values: SeqGenerator, where: WhereParam): ValidationEx[List[Int]] = SeqGenerator.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS2[Long, String], where: WhereParam): List[Int] = SeqGenerator.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: SeqGenerator, where: WhereParam): List[Int] = SeqGenerator.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = SeqGenerator.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = SeqGenerator.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}