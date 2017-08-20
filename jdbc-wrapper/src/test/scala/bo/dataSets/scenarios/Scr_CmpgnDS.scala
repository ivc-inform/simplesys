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



 
case class Scr_CmpgnDSData(active_cmpgnScr_Cmpgn: Array[Boolean], begin_cmpgnScr_Cmpgn: Array[LocalDateTime], caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String, description_cmpgnScr_Cmpgn: Array[String], end_cmpgnScr_Cmpgn: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, parent_cmpgnScr_Cmpgn: Array[Long]) {

}


 
object Scr_CmpgnDS {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_CmpgnDS    
    
    val objectName = "Scr_Cmpgn"    
    val groupName = "scenarios"
}


 
class Scr_CmpgnDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[Scr_CmpgnDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_CmpgnDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: Scr_CmpgnBo, group: scenarios /////////////////////////////////////////    
    
    val Scr_Cmpgn = new Scr_CmpgnBo(alias = alias + "B0".als)    
    
    val fromBO = Scr_Cmpgn    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(Scr_Cmpgn), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val active_cmpgnScr_Cmpgn = Scr_Cmpgn.active_cmpgn    
    val begin_cmpgnScr_Cmpgn = Scr_Cmpgn.begin_cmpgn    
    val caption_cmpgnScr_Cmpgn = Scr_Cmpgn.caption_cmpgn    
    val code_cmpgnScr_Cmpgn = Scr_Cmpgn.code_cmpgn    
    val description_cmpgnScr_Cmpgn = Scr_Cmpgn.description_cmpgn    
    val end_cmpgnScr_Cmpgn = Scr_Cmpgn.end_cmpgn    
    val id_cmpgnScr_Cmpgn = Scr_Cmpgn.id_cmpgn    
    val parent_cmpgnScr_Cmpgn = Scr_Cmpgn.parent_cmpgn    
//////////////////////////////////////// End Class: Scr_CmpgnBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 2    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_cmpgnScr_Cmpgn)),
            UniqueKey(name = "ucCode_cmpgn", constraintDate = KeyConstraintData(code_cmpgnScr_Cmpgn)),
            ForignKey(name = "frParent_cmpgn", constraintDate = ForignKeyConstraintData(parent_cmpgnScr_Cmpgn, ReferencedData("scenarios","Scr_Cmpgn"), false)))    
    
    // For select tuple: (active_cmpgnScr_Cmpgn: Array[Boolean], begin_cmpgnScr_Cmpgn: Array[LocalDateTime], caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String, description_cmpgnScr_Cmpgn: Array[String], end_cmpgnScr_Cmpgn: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, parent_cmpgnScr_Cmpgn: Array[Long])    
    
    type ColumnTypes =     TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]    
     def allColumns = active_cmpgnScr_Cmpgn  ~ begin_cmpgnScr_Cmpgn  ~ caption_cmpgnScr_Cmpgn  ~ code_cmpgnScr_Cmpgn  ~ description_cmpgnScr_Cmpgn  ~ end_cmpgnScr_Cmpgn  ~ id_cmpgnScr_Cmpgn  ~ parent_cmpgnScr_Cmpgn     
     def allColumns1 = Seq(active_cmpgnScr_Cmpgn  , begin_cmpgnScr_Cmpgn  , caption_cmpgnScr_Cmpgn  , code_cmpgnScr_Cmpgn  , description_cmpgnScr_Cmpgn  , end_cmpgnScr_Cmpgn  , id_cmpgnScr_Cmpgn  , parent_cmpgnScr_Cmpgn )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_CmpgnDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS8(active_cmpgnScr_Cmpgn: Array[Boolean], begin_cmpgnScr_Cmpgn: Array[LocalDateTime], caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String, description_cmpgnScr_Cmpgn: Array[String], end_cmpgnScr_Cmpgn: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, parent_cmpgnScr_Cmpgn: Array[Long]) => 
                        Scr_CmpgnDSData(active_cmpgnScr_Cmpgn = active_cmpgnScr_Cmpgn , begin_cmpgnScr_Cmpgn = begin_cmpgnScr_Cmpgn , caption_cmpgnScr_Cmpgn = caption_cmpgnScr_Cmpgn , code_cmpgnScr_Cmpgn = code_cmpgnScr_Cmpgn , description_cmpgnScr_Cmpgn = description_cmpgnScr_Cmpgn , end_cmpgnScr_Cmpgn = end_cmpgnScr_Cmpgn , id_cmpgnScr_Cmpgn = id_cmpgnScr_Cmpgn , parent_cmpgnScr_Cmpgn = parent_cmpgnScr_Cmpgn )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_CmpgnDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS8(active_cmpgnScr_Cmpgn: Array[Boolean], begin_cmpgnScr_Cmpgn: Array[LocalDateTime], caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String, description_cmpgnScr_Cmpgn: Array[String], end_cmpgnScr_Cmpgn: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, parent_cmpgnScr_Cmpgn: Array[Long]) => 
        Scr_CmpgnDSData(active_cmpgnScr_Cmpgn = active_cmpgnScr_Cmpgn , begin_cmpgnScr_Cmpgn = begin_cmpgnScr_Cmpgn , caption_cmpgnScr_Cmpgn = caption_cmpgnScr_Cmpgn , code_cmpgnScr_Cmpgn = code_cmpgnScr_Cmpgn , description_cmpgnScr_Cmpgn = description_cmpgnScr_Cmpgn , end_cmpgnScr_Cmpgn = end_cmpgnScr_Cmpgn , id_cmpgnScr_Cmpgn = id_cmpgnScr_Cmpgn , parent_cmpgnScr_Cmpgn = parent_cmpgnScr_Cmpgn )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_CmpgnDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Scr_Cmpgn), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS8(active_cmpgnScr_Cmpgn: Array[Boolean], begin_cmpgnScr_Cmpgn: Array[LocalDateTime], caption_cmpgnScr_Cmpgn: String, code_cmpgnScr_Cmpgn: String, description_cmpgnScr_Cmpgn: Array[String], end_cmpgnScr_Cmpgn: Array[LocalDateTime], id_cmpgnScr_Cmpgn: Long, parent_cmpgnScr_Cmpgn: Array[Long])) => 
                ValidationEx(Success(Scr_CmpgnDSData(active_cmpgnScr_Cmpgn = active_cmpgnScr_Cmpgn , begin_cmpgnScr_Cmpgn = begin_cmpgnScr_Cmpgn , caption_cmpgnScr_Cmpgn = caption_cmpgnScr_Cmpgn , code_cmpgnScr_Cmpgn = code_cmpgnScr_Cmpgn , description_cmpgnScr_Cmpgn = description_cmpgnScr_Cmpgn , end_cmpgnScr_Cmpgn = end_cmpgnScr_Cmpgn , id_cmpgnScr_Cmpgn = id_cmpgnScr_Cmpgn , parent_cmpgnScr_Cmpgn = parent_cmpgnScr_Cmpgn )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): ValidationEx[List[Int]] = Scr_Cmpgn.insert(values: _*)    
     def insertP(values: Scr_Cmpgn*): ValidationEx[List[Int]] = Scr_Cmpgn.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]]*): List[Int] = Scr_Cmpgn.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Scr_Cmpgn*): List[Int] = Scr_Cmpgn.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = Scr_Cmpgn.update(value = values, where = where)    
     def updateP(values: Scr_Cmpgn, where: WhereParam): ValidationEx[List[Int]] = Scr_Cmpgn.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS8[Array[Boolean], Array[LocalDateTime], String, String, Array[String], Array[LocalDateTime], Long, Array[Long]], where: WhereParam): List[Int] = Scr_Cmpgn.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Scr_Cmpgn, where: WhereParam): List[Int] = Scr_Cmpgn.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Scr_Cmpgn.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Scr_Cmpgn.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}