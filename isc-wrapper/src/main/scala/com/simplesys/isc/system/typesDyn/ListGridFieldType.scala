package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait ListGridFieldType

case object lgftText extends ListGridFieldType {
  override def toString = "text"
}

case object lgftBoolean extends ListGridFieldType {
  override def toString = "boolean"
}

case object lgftInteger extends ListGridFieldType {
  override def toString = "integer"
}

case object lgftFloat extends ListGridFieldType {
  override def toString = "float"
}

case object lgftDate extends ListGridFieldType {
  override def toString = "date"
}

case object lgftTime extends ListGridFieldType {
  override def toString = "time"
}

case object lgftSequence extends ListGridFieldType {
  override def toString = "sequence"
}

case object lgftLink extends ListGridFieldType {
  override def toString = "link"
}

case object lgftImage extends ListGridFieldType {
  override def toString = "image"
}

case object lgftIcon extends ListGridFieldType {
  override def toString = "icon"
}

case object lgftBinary extends ListGridFieldType {
  override def toString = "binary"
}

case object lgftImageFile extends ListGridFieldType {
  override def toString = "imageFile"
}

case object lgftSummary extends ListGridFieldType {
  override def toString = "summary"
}

object ListGridFieldType {
  private val values = SealedEnumRuntime.values[ListGridFieldType]
  private val mappedKeys: Map[String, ListGridFieldType] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ListGridFieldType = mappedKeys(objName)
}

