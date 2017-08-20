
package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait Visibility

case object vsInherit extends Visibility {
  override def toString = "inherit"
}

case object vsVisible extends Visibility {
  override def toString = "visible"
}

case object vsHidden extends Visibility {
  override def toString = "hidden"
}

object Visibility {
  private val values = SealedEnumRuntime.values[Visibility]
  private val mappedKeys: Map[String, Visibility] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): Visibility = mappedKeys(objName)
}


