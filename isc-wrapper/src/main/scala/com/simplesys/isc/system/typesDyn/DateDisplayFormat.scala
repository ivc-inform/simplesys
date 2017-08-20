package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait DateDisplayFormat

case object ddfNull extends DateDisplayFormat {
  override def toString = ""
}

case object ddfToString extends DateDisplayFormat {
  override def toString = "toString"
}

case object ddfToLocaleString extends DateDisplayFormat {
  override def toString = "toLocaleString"
}

case object ddfToUSShortDate extends DateDisplayFormat {
  override def toString = "toUSShortDate"
}

case object ddfToUSShortDatetime extends DateDisplayFormat {
  override def toString = "toUSShortDatetime"
}

case object ddfToEuropeanShortDate extends DateDisplayFormat {
  override def toString = "toEuropeanShortDate"
}

case object ddfToEuropeanShortDatetime extends DateDisplayFormat {
  override def toString = "toEuropeanShortDatetime"
}

case object ddfToJapanShortDate extends DateDisplayFormat {
  override def toString = "toJapanShortDate"
}

case object ddfToJapanShortDatetime extends DateDisplayFormat {
  override def toString = "toJapanShortDatetime"
}

case object ddfToSerializeableDate extends DateDisplayFormat {
  override def toString = "toSerializeableDate"
}

case object ddfToDateStamp extends DateDisplayFormat {
  override def toString = "toDateStamp"
}

object DateDisplayFormat {
  private val values = SealedEnumRuntime.values[DateDisplayFormat]
  private val mappedKeys: Map[String, DateDisplayFormat] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): DateDisplayFormat = mappedKeys(objName)
}
  

