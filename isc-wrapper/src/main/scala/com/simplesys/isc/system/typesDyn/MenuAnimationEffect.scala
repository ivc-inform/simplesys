
package com.simplesys.isc.system.typesDyn


sealed abstract trait MenuAnimationEffect

case object mnuAnimEffctNull extends MenuAnimationEffect {
  override def toString = ""
}

case object mnuAnimEffctFade extends MenuAnimationEffect {
  override def toString = "fade"
}

case object mnuAnimEffctSlide extends MenuAnimationEffect {
  override def toString = "slide"
}

case object mnuAnimEffctWipe extends MenuAnimationEffect {
  override def toString = "wipe"
}


