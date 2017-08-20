// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "SchemaDefMetaGen (generateClasses)"
package ru.simplesys.defs.bo
package systemservice


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
case class SeqGeneratorPK(nameSeq: String) extends BOReference[SeqGenerator]

case class SeqGenerator (
  nameSeq: String,
  maxValue: Long) extends Product {

  val pk: SeqGeneratorPK = SeqGeneratorPK(nameSeq)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[SeqGenerator]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => maxValue
    case 1 => nameSeq
  }
}

object SeqGenerator {
   def apply(pk: SeqGeneratorPK, maxValue: Long) = new SeqGenerator(nameSeq = pk.nameSeq, maxValue = maxValue)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////