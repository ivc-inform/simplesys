package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait DSDataFormat

case object dtftIscServer extends DSDataFormat {
  override def toString = "iscServer"
}

case object dtftXML extends DSDataFormat {
  override def toString = "xml"
}

case object dtftJSON extends DSDataFormat {
  override def toString = "json"
}

case object dtftCustom extends DSDataFormat {
  override def toString = "custom"
}

object DSDataFormat {
  private val values = SealedEnumRuntime.values[DSDataFormat]
  private val mappedKeys: Map[String, DSDataFormat] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): DSDataFormat = mappedKeys(objName)
  def getObjectOpt(objName: String): Option[DSDataFormat] = mappedKeys get objName
}
