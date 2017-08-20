// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "SchemaDefMetaGen (generateClasses)"
package ru.simplesys.defs.bo
package data


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
case class COM_Data_DMPK(id: BigDecimal) extends BOReference[COM_Data_DM]

case class COM_Data_DM (
  id: BigDecimal,
  cnr: Option[Long],
  cnrCode: Option[String],
  acn: Option[Long],
  acnCode: String,
  timestamp: LocalDateTime,
  subject: String,
  start_time: Option[LocalDateTime],
  dlv_status: String,
  dlv_status_at: LocalDateTime,
  dlv_error: Option[String],
  address: String,
  text: String) extends Product {

  val pk: COM_Data_DMPK = COM_Data_DMPK(id)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[COM_Data_DM]
  override def productArity: Int = 13
  override def productElement(n: Int): Any = n match {
    case 0 => acn
    case 1 => acnCode
    case 2 => address
    case 3 => cnr
    case 4 => cnrCode
    case 5 => dlv_error
    case 6 => dlv_status
    case 7 => dlv_status_at
    case 8 => id
    case 9 => start_time
    case 10 => subject
    case 11 => text
    case 12 => timestamp
  }
}

object COM_Data_DM {
   def apply(pk: COM_Data_DMPK, cnr: Option[Long], cnrCode: Option[String], acn: Option[Long], acnCode: String, timestamp: LocalDateTime, subject: String, start_time: Option[LocalDateTime], dlv_status: String, dlv_status_at: LocalDateTime, dlv_error: Option[String], address: String, text: String) = new COM_Data_DM(id = pk.id, cnr = cnr, cnrCode = cnrCode, acn = acn, acnCode = acnCode, timestamp = timestamp, subject = subject, start_time = start_time, dlv_status = dlv_status, dlv_status_at = dlv_status_at, dlv_error = dlv_error, address = address, text = text)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////