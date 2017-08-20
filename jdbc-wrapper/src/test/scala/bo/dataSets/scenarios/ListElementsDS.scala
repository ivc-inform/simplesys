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



 
case class ListElementsDSData(element_listListElements: String, id_listListElements: Long, id_list_elementListElements: Long, id_listLists_Id_list: Long, code_listLists_Id_list: String) {

}


 
object ListElementsDS {
     def apply(implicit dataSource: BoneCPDataSource) = new ListElementsDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new ListElementsDS    
    
    val objectName = "ListElements"    
    val groupName = "scenarios"
}


 
class ListElementsDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[ListElementsDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): ListElementsDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: ListElementsBo, group: scenarios /////////////////////////////////////////    
    
    val ListElements = new ListElementsBo(alias = alias + "B0".als)    
    
    val fromBO = ListElements    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(ListElements), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(ListElements), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(ListElements), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(ListElements), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val element_listListElements = ListElements.element_list    
    val id_listListElements = ListElements.id_list    
    val id_list_elementListElements = ListElements.id_list_element    
//////////////////////////////////////// End Class: ListElementsBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 2    
    
//////////////////////////////////////// Class: ListsBo_Id_list, group: scenarios ////////////////////////////////////////    
    val Lists_Id_list = new ListsBo(alias = alias +"B1".als)    
    val id_listLists_Id_list = Lists_Id_list.id_list    
    id_listLists_Id_list As id_listLists_Id_list.name + "_B1"     
    
    
    val code_listLists_Id_list = Lists_Id_list.code_list    
    code_listLists_Id_list As code_listLists_Id_list.name + "_B1"     
    
    
    val id_listGroup_refLists_Id_list = Lists_Id_list.id_listGroup_ref    
    id_listGroup_refLists_Id_list As id_listGroup_refLists_Id_list.name + "_B1"     
    
    
    _join.InnerJoin(Lists_Id_list)((id_listListElements === id_listLists_Id_list).JoinCondition)    
/////////////////////////////////////// End Class: ListsBo_Id_list, group: scenarios ///////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id_list_elementListElements)),
            UniqueKey(name = "ucId_listElement_list", constraintDate = KeyConstraintData(id_listListElements),KeyConstraintData(element_listListElements)),
            ForignKey(name = "frId_list", constraintDate = ForignKeyConstraintData(id_listListElements, ReferencedData("scenarios","Lists"), true)),
            MigratedPrimaryKey(name = "pk_Id_list", constraintDate = KeyConstraintData(id_listLists_Id_list)),
            UniqueKey(name = "ucCode_list_Id_list", constraintDate = KeyConstraintData(code_listLists_Id_list)),
            ForignKey(name = "frId_listGroup_ref_Id_list", constraintDate = ForignKeyConstraintData(id_listGroup_refLists_Id_list, ReferencedData("scenarios","ListGroups"), false)))    
    
    // For select tuple: (element_listListElements: String, id_listListElements: Long, id_list_elementListElements: Long, id_listLists: Long, code_listLists: String)    
    
    type ColumnTypes =     TupleSS5[String, Long, Long, Long, String]    
     def allColumns = element_listListElements  ~ id_listListElements  ~ id_list_elementListElements  ~ id_listLists_Id_list  ~ code_listLists_Id_list     
     def allColumns1 = Seq(element_listListElements  , id_listListElements  , id_list_elementListElements  , id_listLists_Id_list  , code_listLists_Id_list )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[ListElementsDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(ListElements), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS5(element_listListElements: String, id_listListElements: Long, id_list_elementListElements: Long, id_listLists_Id_list: Long, code_listLists_Id_list: String) => 
                        ListElementsDSData(element_listListElements = element_listListElements , id_listListElements = id_listListElements , id_list_elementListElements = id_list_elementListElements , id_listLists_Id_list = id_listLists_Id_list , code_listLists_Id_list = code_listLists_Id_list )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[ListElementsDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(ListElements), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS5(element_listListElements: String, id_listListElements: Long, id_list_elementListElements: Long, id_listLists_Id_list: Long, code_listLists_Id_list: String) => 
        ListElementsDSData(element_listListElements = element_listListElements , id_listListElements = id_listListElements , id_list_elementListElements = id_list_elementListElements , id_listLists_Id_list = id_listLists_Id_list , code_listLists_Id_list = code_listLists_Id_list )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[ListElementsDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(ListElements), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS5(element_listListElements: String, id_listListElements: Long, id_list_elementListElements: Long, id_listLists_Id_list: Long, code_listLists_Id_list: String)) => 
                ValidationEx(Success(ListElementsDSData(element_listListElements = element_listListElements , id_listListElements = id_listListElements , id_list_elementListElements = id_list_elementListElements , id_listLists_Id_list = id_listLists_Id_list , code_listLists_Id_list = code_listLists_Id_list )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS3[String, Long, Long]*): ValidationEx[List[Int]] = ListElements.insert(values: _*)    
     def insertP(values: ListElements*): ValidationEx[List[Int]] = ListElements.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Long]*): List[Int] = ListElements.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: ListElements*): List[Int] = ListElements.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS3[String, Long, Long], where: WhereParam): ValidationEx[List[Int]] = ListElements.update(value = values, where = where)    
     def updateP(values: ListElements, where: WhereParam): ValidationEx[List[Int]] = ListElements.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS3[String, Long, Long], where: WhereParam): List[Int] = ListElements.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: ListElements, where: WhereParam): List[Int] = ListElements.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = ListElements.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = ListElements.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}