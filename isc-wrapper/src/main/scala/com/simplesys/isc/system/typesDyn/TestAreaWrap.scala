
package com.simplesys.isc.system.typesDyn


sealed abstract trait TestAreaWrap

case object TXT_WR_OFF extends TestAreaWrap {
  override def toString = "OFF"
}

case object TXT_WR_SOFT extends TestAreaWrap {
  override def toString = "SOFT"
}

case object TXT_WR_HARD extends TestAreaWrap {
  override def toString = "HARD"
}


