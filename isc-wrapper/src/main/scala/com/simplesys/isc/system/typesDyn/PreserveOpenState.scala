package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait PreserveOpenState

case object prsrvNever extends PreserveOpenState {
  override def toString = "never"
}

case object prsrvWhenUnique extends PreserveOpenState {
  override def toString = "whenUnique"
}

case object prsrvAlways extends PreserveOpenState {
  override def toString = "always"
}

case object prsrvNull extends PreserveOpenState {
  override def toString = "null"
}

object PreserveOpenState {
  private val values = SealedEnumRuntime.values[PreserveOpenState]
  private val mappedKeys: Map[String, PreserveOpenState] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): PreserveOpenState = mappedKeys(objName)
}
  


  
