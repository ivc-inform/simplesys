package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait HiliteIconPosition

case object hltPosNull extends HiliteIconPosition {
  override def toString = "null"
}

case object hltPosBefore extends HiliteIconPosition {
  override def toString = "before"
}

case object hltPosAfter extends HiliteIconPosition {
  override def toString = "after"
}

case object hltPosReplace extends HiliteIconPosition {
  override def toString = "replace"
}

object HiliteIconPosition {
  private val values = SealedEnumRuntime.values[HiliteIconPosition]
  private val mappedKeys: Map[String, HiliteIconPosition] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): HiliteIconPosition = mappedKeys(objName)
}
  
  
  