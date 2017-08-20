package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait AlignmentDyn

case object AlNull extends AlignmentDyn {
  override def toString = ""
}

case object AlLeft extends AlignmentDyn {
  override def toString = "left"
}

case object AlRight extends AlignmentDyn {
  override def toString = "right"
}

case object AlCenter extends AlignmentDyn {
  override def toString = "center"
}

case object ValAll extends AlignmentDyn {
  override def toString = ""
}

case object ValTop extends AlignmentDyn {
  override def toString = "top"
}

case object ValBottom extends AlignmentDyn {
  override def toString = "bottom"
}


object AlignmentDyn {
  private val values = SealedEnumRuntime.values[AlignmentDyn]
  private val mappedKeys: Map[String, AlignmentDyn] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): AlignmentDyn = mappedKeys(objName)
}




