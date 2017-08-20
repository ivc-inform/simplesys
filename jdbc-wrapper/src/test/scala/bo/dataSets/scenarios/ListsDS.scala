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



 
case class ListsDSData(caption_listLists: String, code_listLists: String, description_listLists: Array[String], id_listLists: Long, id_listGroup_refLists: Array[Long], type_listLists: String, id_listGroupListGroups_Id_listGroup_ref: Long, caption_listGroupListGroups_Id_listGroup_ref: String) {

}


 
object ListsDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ListsDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListsDS    
    
    val objectName = "Lists"    
    val groupName = "scenarios"
}


 
class ListsDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ListsDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListsDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
////////////////////////////////////////// Class: ListsBo, group: scenarios //////////////////////////////////////////    
    
    val Lists = new ListsBo(alias = alias + "B0".als)    
    
    val fromBO = Lists    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(Lists), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(Lists), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(Lists), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(Lists), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val caption_listLists = Lists.caption_list    
    val code_listLists = Lists.code_list    
    val description_listLists = Lists.description_list    
    val id_listLists = Lists.id_list    
    val id_listGroup_refLists = Lists.id_listGroup_ref    
    val type_listLists = Lists.type_list    
///////////////////////////////////////// End Class: ListsBo, group: scenarios /////////////////////////////////////////    
    override val boCount = 2    
    
///////////////////////////////////// Class: ListGroupsBo_Id_listGroup_ref, group: scenarios /////////////////////////////////////    
    val ListGroups_Id_listGroup_ref = new ListGroupsBo(alias = alias +"B1".als)    
    val id_listGroupListGroups_Id_listGroup_ref = ListGroups_Id_listGroup_ref.id_listGroup    
    id_listGroupListGroups_Id_listGroup_ref As id_listGroupListGroups_Id_listGroup_ref.name + "_B1"     
    
    
    val caption_listGroupListGroups_Id_listGroup_ref = ListGroups_Id_listGroup_ref.caption_listGroup    
    caption_listGroupListGroups_Id_listGroup_ref As caption_listGroupListGroups_Id_listGroup_ref.name + "_B1"     
    
    
    val code_listGroupListGroups_Id_listGroup_ref = ListGroups_Id_listGroup_ref.code_listGroup    
    code_listGroupListGroups_Id_listGroup_ref As code_listGroupListGroups_Id_listGroup_ref.name + "_B1"     
    
    
    val parent_listGroupListGroups_Id_listGroup_ref = ListGroups_Id_listGroup_ref.parent_listGroup    
    parent_listGroupListGroups_Id_listGroup_ref As parent_listGroupListGroups_Id_listGroup_ref.name + "_B1"     
    
    
    _join.LeftJoin(ListGroups_Id_listGroup_ref)((id_listGroup_refLists === id_listGroupListGroups_Id_listGroup_ref).JoinCondition)    
//////////////////////////////////// End Class: ListGroupsBo_Id_listGroup_ref, group: scenarios ////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_listLists)),
            UniqueKey(name = "ucCode_list", constraintDate = KeyConstraintData(code_listLists)),
            ForignKey(name = "frId_listGroup_ref", constraintDate = ForignKeyConstraintData(id_listGroup_refLists, ReferencedData("scenarios","ListGroups"), false)),
            MigratedPrimaryKey(name = "pk_Id_listGroup_ref", constraintDate = KeyConstraintData(id_listGroupListGroups_Id_listGroup_ref)),
            UniqueKey(name = "ucCode_listGroup_Id_listGroup_ref", constraintDate = KeyConstraintData(code_listGroupListGroups_Id_listGroup_ref)),
            ForignKey(name = "frParent_listGroup_Id_listGroup_ref", constraintDate = ForignKeyConstraintData(parent_listGroupListGroups_Id_listGroup_ref, ReferencedData("scenarios","ListGroups"), false)))    
    
    // For select tuple: (caption_listLists: String, code_listLists: String, description_listLists: Array[String], id_listLists: Long, id_listGroup_refLists: Array[Long], type_listLists: String, id_listGroupListGroups: Long, caption_listGroupListGroups: String)    
    
    type ColumnTypes =     TupleSS8[String, String, Array[String], Long, Array[Long], String, Long, String]    
     def allColumns = caption_listLists  ~ code_listLists  ~ description_listLists  ~ id_listLists  ~ id_listGroup_refLists  ~ type_listLists  ~ id_listGroupListGroups_Id_listGroup_ref  ~ caption_listGroupListGroups_Id_listGroup_ref     
     def allColumns1 = Seq(caption_listLists  , code_listLists  , description_listLists  , id_listLists  , id_listGroup_refLists  , type_listLists  , id_listGroupListGroups_Id_listGroup_ref  , caption_listGroupListGroups_Id_listGroup_ref )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ListsDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Lists), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS8(caption_listLists: String, code_listLists: String, description_listLists: Array[String], id_listLists: Long, id_listGroup_refLists: Array[Long], type_listLists: String, id_listGroupListGroups_Id_listGroup_ref: Long, caption_listGroupListGroups_Id_listGroup_ref: String) => 
                        ListsDSData(caption_listLists = caption_listLists , code_listLists = code_listLists , description_listLists = description_listLists , id_listLists = id_listLists , id_listGroup_refLists = id_listGroup_refLists , type_listLists = type_listLists , id_listGroupListGroups_Id_listGroup_ref = id_listGroupListGroups_Id_listGroup_ref , caption_listGroupListGroups_Id_listGroup_ref = caption_listGroupListGroups_Id_listGroup_ref )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ListsDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Lists), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS8(caption_listLists: String, code_listLists: String, description_listLists: Array[String], id_listLists: Long, id_listGroup_refLists: Array[Long], type_listLists: String, id_listGroupListGroups_Id_listGroup_ref: Long, caption_listGroupListGroups_Id_listGroup_ref: String) => 
        ListsDSData(caption_listLists = caption_listLists , code_listLists = code_listLists , description_listLists = description_listLists , id_listLists = id_listLists , id_listGroup_refLists = id_listGroup_refLists , type_listLists = type_listLists , id_listGroupListGroups_Id_listGroup_ref = id_listGroupListGroups_Id_listGroup_ref , caption_listGroupListGroups_Id_listGroup_ref = caption_listGroupListGroups_Id_listGroup_ref )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ListsDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Lists), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS8(caption_listLists: String, code_listLists: String, description_listLists: Array[String], id_listLists: Long, id_listGroup_refLists: Array[Long], type_listLists: String, id_listGroupListGroups_Id_listGroup_ref: Long, caption_listGroupListGroups_Id_listGroup_ref: String)) => 
                ValidationEx(Success(ListsDSData(caption_listLists = caption_listLists , code_listLists = code_listLists , description_listLists = description_listLists , id_listLists = id_listLists , id_listGroup_refLists = id_listGroup_refLists , type_listLists = type_listLists , id_listGroupListGroups_Id_listGroup_ref = id_listGroupListGroups_Id_listGroup_ref , caption_listGroupListGroups_Id_listGroup_ref = caption_listGroupListGroups_Id_listGroup_ref )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): ValidationEx[List[Int]] = Lists.insert(values: _*)    
     def insertP(values: Lists*): ValidationEx[List[Int]] = Lists.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[String, String, Array[String], Long, Array[Long], String]*): List[Int] = Lists.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Lists*): List[Int] = Lists.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS6[String, String, Array[String], Long, Array[Long], String], where: WhereParam): ValidationEx[List[Int]] = Lists.update(value = values, where = where)    
     def updateP(values: Lists, where: WhereParam): ValidationEx[List[Int]] = Lists.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS6[String, String, Array[String], Long, Array[Long], String], where: WhereParam): List[Int] = Lists.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Lists, where: WhereParam): List[Int] = Lists.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Lists.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Lists.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}