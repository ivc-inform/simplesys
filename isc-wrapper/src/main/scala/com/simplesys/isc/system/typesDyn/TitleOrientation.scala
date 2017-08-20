

package com.simplesys.isc.system.typesDyn


sealed abstract trait TitleOrientation

case object ttlOrntNull extends TitleOrientation {
  override def toString = ""
}

case object ttlOrntLeft extends TitleOrientation {
  override def toString = "left"
}

case object ttlOrntTop extends TitleOrientation {
  override def toString = "top"
}

case object ttlOrntRight extends TitleOrientation {
  override def toString = "right"
}

