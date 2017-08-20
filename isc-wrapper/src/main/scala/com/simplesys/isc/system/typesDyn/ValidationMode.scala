
package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait ValidationMode

case object vldModeFull extends ValidationMode {
  override def toString = "full"
}

case object vldModePartial extends ValidationMode {
  override def toString = "partial"
}

object ValidationMode {
  private val values = SealedEnumRuntime.values[ValidationMode]
  private val mappedKeys: Map[String, ValidationMode] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ValidationMode = mappedKeys(objName)
}
  

