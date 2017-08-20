

package com.simplesys.isc.system.typesDyn


sealed abstract trait Positioning

case object pstNull extends Positioning {
  override def toString = ""
}

case object pstAbsolute extends Positioning {
  override def toString = "absolute"
}

case object pstRelative extends Positioning {
  override def toString = "relative"
}

