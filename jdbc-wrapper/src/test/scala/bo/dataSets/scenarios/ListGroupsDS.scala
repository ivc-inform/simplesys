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



 
case class ListGroupsDSData(caption_listGroupListGroups: String, code_listGroupListGroups: String, description_listGroupListGroups: Array[String], id_listGroupListGroups: Long, parent_listGroupListGroups: Array[Long]) {

}


 
object ListGroupsDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ListGroupsDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListGroupsDS    
    
    val objectName = "ListGroups"    
    val groupName = "scenarios"
}


 
class ListGroupsDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ListGroupsDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListGroupsDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: ListGroupsBo, group: scenarios /////////////////////////////////////////    
    
    val ListGroups = new ListGroupsBo(alias = alias + "B0".als)    
    
    val fromBO = ListGroups    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(ListGroups), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(ListGroups), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(ListGroups), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(ListGroups), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val caption_listGroupListGroups = ListGroups.caption_listGroup    
    val code_listGroupListGroups = ListGroups.code_listGroup    
    val description_listGroupListGroups = ListGroups.description_listGroup    
    val id_listGroupListGroups = ListGroups.id_listGroup    
    val parent_listGroupListGroups = ListGroups.parent_listGroup    
//////////////////////////////////////// End Class: ListGroupsBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 2    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_listGroupListGroups)),
            UniqueKey(name = "ucCode_listGroup", constraintDate = KeyConstraintData(code_listGroupListGroups)),
            ForignKey(name = "frParent_listGroup", constraintDate = ForignKeyConstraintData(parent_listGroupListGroups, ReferencedData("scenarios","ListGroups"), false)))    
    
    // For select tuple: (caption_listGroupListGroups: String, code_listGroupListGroups: String, description_listGroupListGroups: Array[String], id_listGroupListGroups: Long, parent_listGroupListGroups: Array[Long])    
    
    type ColumnTypes =     TupleSS5[String, String, Array[String], Long, Array[Long]]    
     def allColumns = caption_listGroupListGroups  ~ code_listGroupListGroups  ~ description_listGroupListGroups  ~ id_listGroupListGroups  ~ parent_listGroupListGroups     
     def allColumns1 = Seq(caption_listGroupListGroups  , code_listGroupListGroups  , description_listGroupListGroups  , id_listGroupListGroups  , parent_listGroupListGroups )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ListGroupsDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(ListGroups), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS5(caption_listGroupListGroups: String, code_listGroupListGroups: String, description_listGroupListGroups: Array[String], id_listGroupListGroups: Long, parent_listGroupListGroups: Array[Long]) => 
                        ListGroupsDSData(caption_listGroupListGroups = caption_listGroupListGroups , code_listGroupListGroups = code_listGroupListGroups , description_listGroupListGroups = description_listGroupListGroups , id_listGroupListGroups = id_listGroupListGroups , parent_listGroupListGroups = parent_listGroupListGroups )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ListGroupsDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(ListGroups), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS5(caption_listGroupListGroups: String, code_listGroupListGroups: String, description_listGroupListGroups: Array[String], id_listGroupListGroups: Long, parent_listGroupListGroups: Array[Long]) => 
        ListGroupsDSData(caption_listGroupListGroups = caption_listGroupListGroups , code_listGroupListGroups = code_listGroupListGroups , description_listGroupListGroups = description_listGroupListGroups , id_listGroupListGroups = id_listGroupListGroups , parent_listGroupListGroups = parent_listGroupListGroups )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ListGroupsDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(ListGroups), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS5(caption_listGroupListGroups: String, code_listGroupListGroups: String, description_listGroupListGroups: Array[String], id_listGroupListGroups: Long, parent_listGroupListGroups: Array[Long])) => 
                ValidationEx(Success(ListGroupsDSData(caption_listGroupListGroups = caption_listGroupListGroups , code_listGroupListGroups = code_listGroupListGroups , description_listGroupListGroups = description_listGroupListGroups , id_listGroupListGroups = id_listGroupListGroups , parent_listGroupListGroups = parent_listGroupListGroups )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = ListGroups.insert(values: _*)    
     def insertP(values: ListGroups*): ValidationEx[List[Int]] = ListGroups.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS5[String, String, Array[String], Long, Array[Long]]*): List[Int] = ListGroups.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: ListGroups*): List[Int] = ListGroups.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS5[String, String, Array[String], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = ListGroups.update(value = values, where = where)    
     def updateP(values: ListGroups, where: WhereParam): ValidationEx[List[Int]] = ListGroups.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS5[String, String, Array[String], Long, Array[Long]], where: WhereParam): List[Int] = ListGroups.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: ListGroups, where: WhereParam): List[Int] = ListGroups.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = ListGroups.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = ListGroups.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}