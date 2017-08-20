
package com.simplesys.isc.system.typesDyn


sealed abstract trait Orientation

case object orntVertical extends Orientation {
  override def toString = "vertical"
}

case object orntHorizontal extends Orientation {
  override def toString = "horizontal"
}


