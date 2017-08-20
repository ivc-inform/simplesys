
package com.simplesys.isc.system.typesDyn


sealed abstract trait Overflow

case object ovNull extends Overflow {
  override def toString = ""
}

case object ovVisible extends Overflow {
  override def toString = "visible"
}

case object ovHidden extends Overflow {
  override def toString = "hidden"
}

case object ovAuto extends Overflow {
  override def toString = "auto"
}

case object ovScroll extends Overflow {
  override def toString = "scroll"
}

case object ovClipH extends Overflow {
  override def toString = "clip-h"
}

case object ovClipV extends Overflow {
  override def toString = "clip-v"
}


