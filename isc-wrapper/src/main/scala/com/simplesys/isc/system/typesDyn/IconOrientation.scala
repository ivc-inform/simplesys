
package com.simplesys.isc.system.typesDyn


sealed abstract trait IconOrientation

case object IoLeft extends IconOrientation {
  override def toString = "left"
}

case object IoRight extends IconOrientation {
  override def toString = "right"
}

case object IoCenter extends IconOrientation {
  override def toString = "center"
}
