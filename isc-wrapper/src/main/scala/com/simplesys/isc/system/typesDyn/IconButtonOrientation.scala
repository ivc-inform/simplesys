
package com.simplesys.isc.system.typesDyn


sealed abstract trait IconButtonOrientation

case object icbtnOrntHorizontal extends IconButtonOrientation {
  override def toString = "horizontal"
}

case object icbtnOrntVertical extends IconButtonOrientation {
  override def toString = "vertical"
}


