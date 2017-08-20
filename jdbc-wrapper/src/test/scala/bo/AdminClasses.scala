// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "SchemaDefMetaGen (generateClasses)"
package ru.simplesys.defs.bo
package admin


import org.joda.time.{DateTime, LocalDateTime}
import ru.simplesys.meta.types.{MetaType, Domain}
import ru.simplesys.meta._
import ru.simplesys.coreutil.{SealedEnumRuntime, SealedCaseClassEnum}
import com.simplesys.jdbc._
import com.simplesys.json.JsonString
import com.simplesys.corelibrary.domain._
import com.simplesys.common.array._
import com.simplesys.jdbc.control.clob._

 

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class UserGroupPK(di: Long) extends BOReference[UserGroup]

case class UserGroupAKCodeGroup(codeGroup: String) extends BOReference[UserGroup]

case class UserGroup (
  di: Long,
  codeGroup: String,
  captionGroup: Option[String],
  descriptionGroup: Option[String],
  active: Boolean,
  parent: Option[Long]) extends Product {

  val pk: UserGroupPK = UserGroupPK(di)
  val ucCodeGroup: UserGroupAKCodeGroup = UserGroupAKCodeGroup(codeGroup)
  val frParent: Option[UserGroupPK] = parent.map(UserGroupPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UserGroup]
  override def productArity: Int = 6
  override def productElement(n: Int): Any = n match {
    case 0 => active
    case 1 => captionGroup
    case 2 => codeGroup
    case 3 => descriptionGroup
    case 4 => di
    case 5 => parent
  }
}

object UserGroup {
   def apply(pk: UserGroupPK, codeGroup: String, captionGroup: Option[String], descriptionGroup: Option[String], active: Boolean, frParent: UserGroupPK) = new UserGroup(di = pk.di, codeGroup = codeGroup, captionGroup = captionGroup, descriptionGroup = descriptionGroup, active = active, parent = Some(frParent).map(_.di))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class UserPK(di: Long) extends BOReference[User]

case class UserAKLogin(login: String) extends BOReference[User]

case class User (
  di: Long,
  login: String,
  firstName: Option[String],
  secondName: Option[String],
  lastName: String,
  password: String,
  active: Boolean,
  group: Long) extends Product {
  def caption: String = lastName + firstName.map(" " + _).getOrElse("") + secondName.map(" " + _).getOrElse("")
  val pk: UserPK = UserPK(di)
  val ucLogin: UserAKLogin = UserAKLogin(login)
  val frGroup: UserGroupPK = UserGroupPK(group)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[User]
  override def productArity: Int = 8
  override def productElement(n: Int): Any = n match {
    case 0 => active
    case 1 => di
    case 2 => firstName
    case 3 => group
    case 4 => lastName
    case 5 => login
    case 6 => password
    case 7 => secondName
  }
}

object User {
   def apply(pk: UserPK, login: String, firstName: Option[String], secondName: Option[String], lastName: String, password: String, active: Boolean, frGroup: UserGroupPK) = new User(di = pk.di, login = login, firstName = firstName, secondName = secondName, lastName = lastName, password = password, active = active, group = frGroup.di)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////