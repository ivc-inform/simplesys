// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenDSs"

package ru.simplesys.defs.bo
package admin

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



 
case class UserGroupDSData(activeUserGroup: Boolean, captionGroupUserGroup: Array[String], codeGroupUserGroup: String, descriptionGroupUserGroup: Array[String], diUserGroup: Long, parentUserGroup: Array[Long]) {

}


 
object UserGroupDS {
     def apply(implicit dataSource: BoneCPDataSource) = new UserGroupDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserGroupDS    
    
    val objectName = "UserGroup"    
    val groupName = "admin"
}


 
class UserGroupDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[UserGroupDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): UserGroupDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
////////////////////////////////////////// Class: UserGroupBo, group: admin //////////////////////////////////////////    
    
    val UserGroup = new UserGroupBo(alias = alias + "B0".als)    
    
    val fromBO = UserGroup    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(UserGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(UserGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(UserGroup), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(UserGroup), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val activeUserGroup = UserGroup.active    
    val captionGroupUserGroup = UserGroup.captionGroup    
    val codeGroupUserGroup = UserGroup.codeGroup    
    val descriptionGroupUserGroup = UserGroup.descriptionGroup    
    val diUserGroup = UserGroup.di    
    val parentUserGroup = UserGroup.parent    
///////////////////////////////////////// End Class: UserGroupBo, group: admin /////////////////////////////////////////    
    override val boCount = 2    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(diUserGroup)),
            UniqueKey(name = "ucCodeGroup", constraintDate = KeyConstraintData(codeGroupUserGroup)),
            ForignKey(name = "frParent", constraintDate = ForignKeyConstraintData(parentUserGroup, ReferencedData("admin","UserGroup"), false)))    
    
    // For select tuple: (activeUserGroup: Boolean, captionGroupUserGroup: Array[String], codeGroupUserGroup: String, descriptionGroupUserGroup: Array[String], diUserGroup: Long, parentUserGroup: Array[Long])    
    
    type ColumnTypes =     TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]    
     def allColumns = activeUserGroup  ~ captionGroupUserGroup  ~ codeGroupUserGroup  ~ descriptionGroupUserGroup  ~ diUserGroup  ~ parentUserGroup     
     def allColumns1 = Seq(activeUserGroup  , captionGroupUserGroup  , codeGroupUserGroup  , descriptionGroupUserGroup  , diUserGroup  , parentUserGroup )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[UserGroupDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(UserGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS6(activeUserGroup: Boolean, captionGroupUserGroup: Array[String], codeGroupUserGroup: String, descriptionGroupUserGroup: Array[String], diUserGroup: Long, parentUserGroup: Array[Long]) => 
                        UserGroupDSData(activeUserGroup = activeUserGroup , captionGroupUserGroup = captionGroupUserGroup , codeGroupUserGroup = codeGroupUserGroup , descriptionGroupUserGroup = descriptionGroupUserGroup , diUserGroup = diUserGroup , parentUserGroup = parentUserGroup )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[UserGroupDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(UserGroup), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS6(activeUserGroup: Boolean, captionGroupUserGroup: Array[String], codeGroupUserGroup: String, descriptionGroupUserGroup: Array[String], diUserGroup: Long, parentUserGroup: Array[Long]) => 
        UserGroupDSData(activeUserGroup = activeUserGroup , captionGroupUserGroup = captionGroupUserGroup , codeGroupUserGroup = codeGroupUserGroup , descriptionGroupUserGroup = descriptionGroupUserGroup , diUserGroup = diUserGroup , parentUserGroup = parentUserGroup )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[UserGroupDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(UserGroup), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS6(activeUserGroup: Boolean, captionGroupUserGroup: Array[String], codeGroupUserGroup: String, descriptionGroupUserGroup: Array[String], diUserGroup: Long, parentUserGroup: Array[Long])) => 
                ValidationEx(Success(UserGroupDSData(activeUserGroup = activeUserGroup , captionGroupUserGroup = captionGroupUserGroup , codeGroupUserGroup = codeGroupUserGroup , descriptionGroupUserGroup = descriptionGroupUserGroup , diUserGroup = diUserGroup , parentUserGroup = parentUserGroup )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): ValidationEx[List[Int]] = UserGroup.insert(values: _*)    
     def insertP(values: UserGroup*): ValidationEx[List[Int]] = UserGroup.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]]*): List[Int] = UserGroup.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: UserGroup*): List[Int] = UserGroup.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]], where: WhereParam): ValidationEx[List[Int]] = UserGroup.update(value = values, where = where)    
     def updateP(values: UserGroup, where: WhereParam): ValidationEx[List[Int]] = UserGroup.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS6[Boolean, Array[String], String, Array[String], Long, Array[Long]], where: WhereParam): List[Int] = UserGroup.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: UserGroup, where: WhereParam): List[Int] = UserGroup.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = UserGroup.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = UserGroup.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}