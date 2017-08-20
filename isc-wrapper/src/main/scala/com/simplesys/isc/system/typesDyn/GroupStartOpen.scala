
package com.simplesys.isc.system.typesDyn


sealed abstract trait GroupStartOpen

case object grpStrtOpnAll extends GroupStartOpen {
  override def toString = "all"
}

case object grpStrtOpnFirst extends GroupStartOpen {
  override def toString = "first"
}

case object grpStrtOpnNone extends GroupStartOpen {
  override def toString = "none"
}


import com.simplesys.common.Strings._
import ru.simplesys.coreutil.SealedEnumRuntime

object GroupStartOpen {
  private val values = SealedEnumRuntime.values[GroupStartOpen]
  private val mappedKeys: Map[String, GroupStartOpen] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): GroupStartOpen = mappedKeys(objName)
}



