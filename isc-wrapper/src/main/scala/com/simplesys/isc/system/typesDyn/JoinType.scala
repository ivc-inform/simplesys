package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait JoinType

case object jtNull extends JoinType {
  override def toString = ""
}

case object jtInner extends JoinType {
  override def toString = "inner"
}

case object jtOuted extends JoinType {
  override def toString = "outer"
}

object JoinType {
  private val values = SealedEnumRuntime.values[JoinType]
  private val mappedKeys: Map[String, JoinType] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): JoinType = mappedKeys(objName)
}



  
  