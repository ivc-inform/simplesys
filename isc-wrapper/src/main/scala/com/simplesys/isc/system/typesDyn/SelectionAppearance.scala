

package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait SelectionAppearance

case object slAppearRowStyle extends SelectionAppearance {
  override def toString = "rowStyle"
}

case object slAppearCheckbox extends SelectionAppearance {
  override def toString = "checkbox"
}

object SelectionAppearance {
  private val values = SealedEnumRuntime.values[SelectionAppearance]
  private val mappedKeys: Map[String, SelectionAppearance] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): SelectionAppearance = mappedKeys(objName)
}

