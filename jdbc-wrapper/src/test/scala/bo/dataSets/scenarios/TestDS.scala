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



 
case class TestDSData(activeTest: Boolean, addressTest: String, captionTestTest: Array[String], codeTestTest: Array[String], createDateTest: Array[LocalDateTime], descriptionTestTest: Array[String], groupTest: Long, idTest: Long, textTest: String, timestampTest: LocalDateTime, idTestGroup_Group: Long, codeGroupTestGroup_Group: String) {

}


 
object TestDS {
     def apply(implicit dataSource: BoneCPDataSource) = new TestDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestDS    
    
    val objectName = "Test"    
    val groupName = "scenarios"
}


 
class TestDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[TestDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): TestDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
/////////////////////////////////////////// Class: TestBo, group: scenarios ///////////////////////////////////////////    
    
    val Test = new TestBo(alias = alias + "B0".als)    
    
    val fromBO = Test    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(Test), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(Test), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(Test), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(Test), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val activeTest = Test.active    
    val addressTest = Test.address    
    val captionTestTest = Test.captionTest    
    val codeTestTest = Test.codeTest    
    val createDateTest = Test.createDate    
    val descriptionTestTest = Test.descriptionTest    
    val groupTest = Test.group    
    val idTest = Test.id    
    val textTest = Test.text    
    val timestampTest = Test.timestamp    
////////////////////////////////////////// End Class: TestBo, group: scenarios //////////////////////////////////////////    
    override val boCount = 2    
    
//////////////////////////////////////// Class: TestGroupBo_Group, group: scenarios ////////////////////////////////////////    
    val TestGroup_Group = new TestGroupBo(alias = alias +"B1".als)    
    val idTestGroup_Group = TestGroup_Group.id    
    idTestGroup_Group As idTestGroup_Group.name + "_B1"     
    
    
    val codeGroupTestGroup_Group = TestGroup_Group.codeGroup    
    codeGroupTestGroup_Group As codeGroupTestGroup_Group.name + "_B1"     
    
    
    val parentTestGroup_Group = TestGroup_Group.parent    
    parentTestGroup_Group As parentTestGroup_Group.name + "_B1"     
    
    
    _join.InnerJoin(TestGroup_Group)((groupTest === idTestGroup_Group).JoinCondition)    
/////////////////////////////////////// End Class: TestGroupBo_Group, group: scenarios ///////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(idTest)),
            UniqueKey(name = "ucCodeTest", constraintDate = KeyConstraintData(codeTestTest)),
            ForignKey(name = "frGroup", constraintDate = ForignKeyConstraintData(groupTest, ReferencedData("scenarios","TestGroup"), true)),
            MigratedPrimaryKey(name = "pk_Group", constraintDate = KeyConstraintData(idTestGroup_Group)),
            UniqueKey(name = "ucCodeGroup_Group", constraintDate = KeyConstraintData(codeGroupTestGroup_Group)),
            ForignKey(name = "frParent_Group", constraintDate = ForignKeyConstraintData(parentTestGroup_Group, ReferencedData("scenarios","TestGroup"), false)))    
    
    // For select tuple: (activeTest: Boolean, addressTest: String, captionTestTest: Array[String], codeTestTest: Array[String], createDateTest: Array[LocalDateTime], descriptionTestTest: Array[String], groupTest: Long, idTest: Long, textTest: String, timestampTest: LocalDateTime, idTestGroup: Long, codeGroupTestGroup: String)    
    
    type ColumnTypes =     TupleSS12[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime, Long, String]    
     def allColumns = activeTest  ~ addressTest  ~ captionTestTest  ~ codeTestTest  ~ createDateTest  ~ descriptionTestTest  ~ groupTest  ~ idTest  ~ textTest  ~ timestampTest  ~ idTestGroup_Group  ~ codeGroupTestGroup_Group     
     def allColumns1 = Seq(activeTest  , addressTest  , captionTestTest  , codeTestTest  , createDateTest  , descriptionTestTest  , groupTest  , idTest  , textTest  , timestampTest  , idTestGroup_Group  , codeGroupTestGroup_Group )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[TestDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(Test), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS12(activeTest: Boolean, addressTest: String, captionTestTest: Array[String], codeTestTest: Array[String], createDateTest: Array[LocalDateTime], descriptionTestTest: Array[String], groupTest: Long, idTest: Long, textTest: String, timestampTest: LocalDateTime, idTestGroup_Group: Long, codeGroupTestGroup_Group: String) => 
                        TestDSData(activeTest = activeTest , addressTest = addressTest , captionTestTest = captionTestTest , codeTestTest = codeTestTest , createDateTest = createDateTest , descriptionTestTest = descriptionTestTest , groupTest = groupTest , idTest = idTest , textTest = textTest , timestampTest = timestampTest , idTestGroup_Group = idTestGroup_Group , codeGroupTestGroup_Group = codeGroupTestGroup_Group )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[TestDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(Test), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS12(activeTest: Boolean, addressTest: String, captionTestTest: Array[String], codeTestTest: Array[String], createDateTest: Array[LocalDateTime], descriptionTestTest: Array[String], groupTest: Long, idTest: Long, textTest: String, timestampTest: LocalDateTime, idTestGroup_Group: Long, codeGroupTestGroup_Group: String) => 
        TestDSData(activeTest = activeTest , addressTest = addressTest , captionTestTest = captionTestTest , codeTestTest = codeTestTest , createDateTest = createDateTest , descriptionTestTest = descriptionTestTest , groupTest = groupTest , idTest = idTest , textTest = textTest , timestampTest = timestampTest , idTestGroup_Group = idTestGroup_Group , codeGroupTestGroup_Group = codeGroupTestGroup_Group )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[TestDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(Test), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS12(activeTest: Boolean, addressTest: String, captionTestTest: Array[String], codeTestTest: Array[String], createDateTest: Array[LocalDateTime], descriptionTestTest: Array[String], groupTest: Long, idTest: Long, textTest: String, timestampTest: LocalDateTime, idTestGroup_Group: Long, codeGroupTestGroup_Group: String)) => 
                ValidationEx(Success(TestDSData(activeTest = activeTest , addressTest = addressTest , captionTestTest = captionTestTest , codeTestTest = codeTestTest , createDateTest = createDateTest , descriptionTestTest = descriptionTestTest , groupTest = groupTest , idTest = idTest , textTest = textTest , timestampTest = timestampTest , idTestGroup_Group = idTestGroup_Group , codeGroupTestGroup_Group = codeGroupTestGroup_Group )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): ValidationEx[List[Int]] = Test.insert(values: _*)    
     def insertP(values: Test*): ValidationEx[List[Int]] = Test.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): List[Int] = Test.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: Test*): List[Int] = Test.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = Test.update(value = values, where = where)    
     def updateP(values: Test, where: WhereParam): ValidationEx[List[Int]] = Test.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime], where: WhereParam): List[Int] = Test.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: Test, where: WhereParam): List[Int] = Test.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = Test.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = Test.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}