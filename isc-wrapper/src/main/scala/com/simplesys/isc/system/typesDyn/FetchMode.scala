

package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait FetchMode

case object ftchMdNull extends FetchMode {
  override def toString = ""
}

case object ftchMdBasic extends FetchMode {
  override def toString = "basic"
}

case object ftchMdPaged extends FetchMode {
  override def toString = "paged"
}

case object ftchMdLocal extends FetchMode {
  override def toString = "local"
}

object FetchMode {
  private val values = SealedEnumRuntime.values[FetchMode]
  private val mappedKeys: Map[String, FetchMode] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): FetchMode = mappedKeys(objName)
}

