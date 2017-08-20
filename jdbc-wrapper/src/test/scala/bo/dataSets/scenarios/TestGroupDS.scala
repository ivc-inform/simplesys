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



 
case class TestGroupDSData(activeTestGroup: Boolean, captionGroupTestGroup: Array[String], codeGroupTestGroup: String, descriptionGroupTestGroup: Array[String], idTestGroup: Long, parentTestGroup: Array[Long], statusTestGroup: Array[Long]) {

}


 
object TestGroupDS {
     def apply(implicit dataSource: BoneCPDataSource) = new TestGroupDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestGroupDS    
    
    val objectName = "TestGroup"    
    val groupName = "scenarios"
}


 
class TestGroupDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[TestGroupDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): TestGroupDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
///////////////////////////////////////// Class: TestGroupBo, group: scenarios /////////////////////////////////////////    
    
    val TestGroup = new TestGroupBo(alias = alias + "B0".als)    
    
    val fromBO = TestGroup    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(TestGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(TestGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(TestGroup), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(TestGroup), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val activeTestGroup = TestGroup.active    
    val captionGroupTestGroup = TestGroup.captionGroup    
    val codeGroupTestGroup = TestGroup.codeGroup    
    val descriptionGroupTestGroup = TestGroup.descriptionGroup    
    val idTestGroup = TestGroup.id    
    val parentTestGroup = TestGroup.parent    
    val statusTestGroup = TestGroup.status    
//////////////////////////////////////// End Class: TestGroupBo, group: scenarios ////////////////////////////////////////    
    override val boCount = 2    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idTestGroup)),
            UniqueKey(name = "ucCodeGroup", constraintDate = KeyConstraintData(codeGroupTestGroup)),
            ForignKey(name = "frParent", constraintDate = ForignKeyConstraintData(parentTestGroup, ReferencedData("scenarios","TestGroup"), false)))    
    
    // For select tuple: (activeTestGroup: Boolean, captionGroupTestGroup: Array[String], codeGroupTestGroup: String, descriptionGroupTestGroup: Array[String], idTestGroup: Long, parentTestGroup: Array[Long], statusTestGroup: Array[Long])    
    
    type ColumnTypes =     TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]    
     def allColumns = activeTestGroup  ~ captionGroupTestGroup  ~ codeGroupTestGroup  ~ descriptionGroupTestGroup  ~ idTestGroup  ~ parentTestGroup  ~ statusTestGroup     
     def allColumns1 = Seq(activeTestGroup  , captionGroupTestGroup  , codeGroupTestGroup  , descriptionGroupTestGroup  , idTestGroup  , parentTestGroup  , statusTestGroup )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[TestGroupDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(TestGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(activeTestGroup: Boolean, captionGroupTestGroup: Array[String], codeGroupTestGroup: String, descriptionGroupTestGroup: Array[String], idTestGroup: Long, parentTestGroup: Array[Long], statusTestGroup: Array[Long]) => 
                        TestGroupDSData(activeTestGroup = activeTestGroup , captionGroupTestGroup = captionGroupTestGroup , codeGroupTestGroup = codeGroupTestGroup , descriptionGroupTestGroup = descriptionGroupTestGroup , idTestGroup = idTestGroup , parentTestGroup = parentTestGroup , statusTestGroup = statusTestGroup )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[TestGroupDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(TestGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(activeTestGroup: Boolean, captionGroupTestGroup: Array[String], codeGroupTestGroup: String, descriptionGroupTestGroup: Array[String], idTestGroup: Long, parentTestGroup: Array[Long], statusTestGroup: Array[Long]) => 
        TestGroupDSData(activeTestGroup = activeTestGroup , captionGroupTestGroup = captionGroupTestGroup , codeGroupTestGroup = codeGroupTestGroup , descriptionGroupTestGroup = descriptionGroupTestGroup , idTestGroup = idTestGroup , parentTestGroup = parentTestGroup , statusTestGroup = statusTestGroup )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[TestGroupDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(TestGroup), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(activeTestGroup: Boolean, captionGroupTestGroup: Array[String], codeGroupTestGroup: String, descriptionGroupTestGroup: Array[String], idTestGroup: Long, parentTestGroup: Array[Long], statusTestGroup: Array[Long])) => 
                ValidationEx(Success(TestGroupDSData(activeTestGroup = activeTestGroup , captionGroupTestGroup = captionGroupTestGroup , codeGroupTestGroup = codeGroupTestGroup , descriptionGroupTestGroup = descriptionGroupTestGroup , idTestGroup = idTestGroup , parentTestGroup = parentTestGroup , statusTestGroup = statusTestGroup )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): ValidationEx[List[Int]] = TestGroup.insert(values: _*)    
     def insertP(values: TestGroup*): ValidationEx[List[Int]] = TestGroup.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): List[Int] = TestGroup.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: TestGroup*): List[Int] = TestGroup.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]], where: WhereParam): ValidationEx[List[Int]] = TestGroup.update(value = values, where = where)    
     def updateP(values: TestGroup, where: WhereParam): ValidationEx[List[Int]] = TestGroup.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]], where: WhereParam): List[Int] = TestGroup.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: TestGroup, where: WhereParam): List[Int] = TestGroup.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = TestGroup.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = TestGroup.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}