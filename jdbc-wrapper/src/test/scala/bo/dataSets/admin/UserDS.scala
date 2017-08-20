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



 
case class UserDSData(activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup_Group: Long, captionGroupUserGroup_Group: Array[String], codeGroupUserGroup_Group: String) {

}


 
object UserDS {
     def apply(implicit dataSource: BoneCPDataSource) = new UserDS(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new UserDS    
    
    val objectName = "User"    
    val groupName = "admin"
}


 
class UserDS(override val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends DataSet[UserDS]  {
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
    val quoted = true    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): UserDS = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
//////////////////////////////////////////// Class: UserBo, group: admin ////////////////////////////////////////////    
    
    val User = new UserBo(alias = alias + "B0".als)    
    
    val fromBO = User    
    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = FromBo(User), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = FromBo(User), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = FromBo(User), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = FromBo(User), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
    val activeUser = User.active    
    val captionUser = User.caption    
    val diUser = User.di    
    val firstNameUser = User.firstName    
    val groupUser = User.group    
    val lastNameUser = User.lastName    
    val loginUser = User.login    
    val passwordUser = User.password    
    val secondNameUser = User.secondName    
/////////////////////////////////////////// End Class: UserBo, group: admin ///////////////////////////////////////////    
    override val boCount = 2    
    
///////////////////////////////////////// Class: UserGroupBo_Group, group: admin /////////////////////////////////////////    
    val UserGroup_Group = new UserGroupBo(alias = alias +"B1".als)    
    val diUserGroup_Group = UserGroup_Group.di    
    diUserGroup_Group As diUserGroup_Group.name + "_B1"     
    
    
    val captionGroupUserGroup_Group = UserGroup_Group.captionGroup    
    captionGroupUserGroup_Group As captionGroupUserGroup_Group.name + "_B1"     
    
    
    val codeGroupUserGroup_Group = UserGroup_Group.codeGroup    
    codeGroupUserGroup_Group As codeGroupUserGroup_Group.name + "_B1"     
    
    
    val parentUserGroup_Group = UserGroup_Group.parent    
    parentUserGroup_Group As parentUserGroup_Group.name + "_B1"     
    
    
    _join.InnerJoin(UserGroup_Group)((groupUser === diUserGroup_Group).JoinCondition)    
//////////////////////////////////////// End Class: UserGroupBo_Group, group: admin ////////////////////////////////////////    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(diUser)),
            UniqueKey(name = "ucLogin", constraintDate = KeyConstraintData(loginUser)),
            ForignKey(name = "frGroup", constraintDate = ForignKeyConstraintData(groupUser, ReferencedData("admin","UserGroup"), true)),
            MigratedPrimaryKey(name = "pk_Group", constraintDate = KeyConstraintData(diUserGroup_Group)),
            UniqueKey(name = "ucCodeGroup_Group", constraintDate = KeyConstraintData(codeGroupUserGroup_Group)),
            ForignKey(name = "frParent_Group", constraintDate = ForignKeyConstraintData(parentUserGroup_Group, ReferencedData("admin","UserGroup"), false)))    
    
    // For select tuple: (activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup: Long, captionGroupUserGroup: Array[String], codeGroupUserGroup: String)    
    
    type ColumnTypes =     TupleSS12[Boolean, String, Long, Array[String], Long, String, String, String, Array[String], Long, Array[String], String]    
     def allColumns = activeUser  ~ captionUser  ~ diUser  ~ firstNameUser  ~ groupUser  ~ lastNameUser  ~ loginUser  ~ passwordUser  ~ secondNameUser  ~ diUserGroup_Group  ~ captionGroupUserGroup_Group  ~ codeGroupUserGroup_Group     
     def allColumns1 = Seq(activeUser  , captionUser  , diUser  , firstNameUser  , groupUser  , lastNameUser  , loginUser  , passwordUser  , secondNameUser  , diUserGroup_Group  , captionGroupUserGroup_Group  , codeGroupUserGroup_Group )    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[UserDSData]] = 
                selectListRoot(columns = allColumns, from = FromBo(User), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS12(activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup_Group: Long, captionGroupUserGroup_Group: Array[String], codeGroupUserGroup_Group: String) => 
                        UserDSData(activeUser = activeUser , captionUser = captionUser , diUser = diUser , firstNameUser = firstNameUser , groupUser = groupUser , lastNameUser = lastNameUser , loginUser = loginUser , passwordUser = passwordUser , secondNameUser = secondNameUser , diUserGroup_Group = diUserGroup_Group , captionGroupUserGroup_Group = captionGroupUserGroup_Group , codeGroupUserGroup_Group = codeGroupUserGroup_Group )
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[UserDSData]] = 
        selectPIteratorRoot(columns = columns, from = FromBo(User), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS12(activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup_Group: Long, captionGroupUserGroup_Group: Array[String], codeGroupUserGroup_Group: String) => 
        UserDSData(activeUser = activeUser , captionUser = captionUser , diUser = diUser , firstNameUser = firstNameUser , groupUser = groupUser , lastNameUser = lastNameUser , loginUser = loginUser , passwordUser = passwordUser , secondNameUser = secondNameUser , diUserGroup_Group = diUserGroup_Group , captionGroupUserGroup_Group = captionGroupUserGroup_Group , codeGroupUserGroup_Group = codeGroupUserGroup_Group )
}    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[UserDSData] = 
                selectOneRoot(columns = allColumns, from = FromBo(User), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS12(activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup_Group: Long, captionGroupUserGroup_Group: Array[String], codeGroupUserGroup_Group: String)) => 
                ValidationEx(Success(UserDSData(activeUser = activeUser , captionUser = captionUser , diUser = diUser , firstNameUser = firstNameUser , groupUser = groupUser , lastNameUser = lastNameUser , loginUser = loginUser , passwordUser = passwordUser , secondNameUser = secondNameUser , diUserGroup_Group = diUserGroup_Group , captionGroupUserGroup_Group = captionGroupUserGroup_Group , codeGroupUserGroup_Group = codeGroupUserGroup_Group )))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// insert /////////////////////////////////////////////////    
     def insert(values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): ValidationEx[List[Int]] = User.insert(values: _*)    
     def insertP(values: User*): ValidationEx[List[Int]] = User.insertP(values: _*)    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]]*): List[Int] = User.insertWithoutCommit(connection = connection, values: _*)    
     def insertPWithoutCommit(connection: Connection, values: User*): List[Int] = User.insertPWithoutCommit(connection = connection, values: _*)    
//////////////////////////////////////////////// End insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// update /////////////////////////////////////////////////    
     def update(values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]], where: WhereParam): ValidationEx[List[Int]] = User.update(value = values, where = where)    
     def updateP(values: User, where: WhereParam): ValidationEx[List[Int]] = User.updateP(value = values, where = where)    
    
     def updateWithoutCommit(connection: Connection, values: TupleSS9[Boolean, String, Long, Array[String], Long, String, String, String, Array[String]], where: WhereParam): List[Int] = User.updateWithoutCommit(connection = connection, value = values, where = where)    
     def updatePWithoutCommit(connection: Connection, values: User, where: WhereParam): List[Int] = User.updatePWithoutCommit(connection = connection, value = values, where = where)    
//////////////////////////////////////////////// End update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = User.delete(where = where)    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = User.deleteWithoutCommit(connection = connection, where = where)    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////    
    

}