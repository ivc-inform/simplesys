
package com.simplesys.isc.system.typesDyn


sealed abstract trait SelectionStyle

case object slStlNull extends SelectionStyle {
  override def toString = ""
}

case object slStlSingle extends SelectionStyle {
  override def toString = "single"
}

case object slStlMultiple extends SelectionStyle {
  override def toString = "multiple"
}

case object slStlSimple extends SelectionStyle {
  override def toString = "simple"
}

import com.simplesys.common.Strings._
import ru.simplesys.coreutil.SealedEnumRuntime

object SelectionStyle {
  private val values = SealedEnumRuntime.values[SelectionStyle]
  private val mappedKeys: Map[String, SelectionStyle] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): SelectionStyle = mappedKeys(objName)
}




