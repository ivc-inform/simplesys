package com.simplesys.isc.system.typesDyn

import com.simplesys.common.Strings._

sealed abstract trait DSOperationType

case object dsOptTypeNull extends DSOperationType {
  override def toString = "unknown"
}

case object dsOptTypeFetch extends DSOperationType {
  override def toString = "fetch"
}

case object dsOptTypeAdd extends DSOperationType {
  override def toString = "add"
}

case object dsOptTypeUpdate extends DSOperationType {
  override def toString = "update"
}

case object dsOptTypeRemove extends DSOperationType {
  override def toString = "remove"
}

case object dsOptTypeValidate extends DSOperationType {
  override def toString = "validate"
}

case object dsOptTypeCustom extends DSOperationType {
  override def toString = "custom"
}

import ru.simplesys.coreutil.SealedEnumRuntime

object DSOperationType {
  private val values = SealedEnumRuntime.values[DSOperationType]
  private val mappedKeys: Map[String, DSOperationType] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): DSOperationType = mappedKeys(objName)
  def getObjectOpt(objName: String): Option[DSOperationType] = mappedKeys get objName
}
