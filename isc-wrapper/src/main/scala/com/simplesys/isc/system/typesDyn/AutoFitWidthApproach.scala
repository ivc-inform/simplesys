package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait AutoFitWidthApproach

case object aftWdAprchNull extends AutoFitWidthApproach {
  override def toString = ""
}

case object aftWdAprchValue extends AutoFitWidthApproach {
  override def toString = "value"
}

case object aftWdAprchTitle extends AutoFitWidthApproach {
  override def toString = "title"
}

case object aftWdAprchBoth extends AutoFitWidthApproach {
  override def toString = "both"
}

object AutoFitWidthApproach {
  private val values = SealedEnumRuntime.values[AutoFitWidthApproach]
  private val mappedKeys: Map[String, AutoFitWidthApproach] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): AutoFitWidthApproach = mappedKeys(objName)
}