
package com.simplesys.isc.system.typesDyn


sealed abstract trait DragIntersectStyle

case object drgInspStlMouse extends DragIntersectStyle {
  override def toString = "mouse"
}

case object drgInspStlRect extends DragIntersectStyle {
  override def toString = "rect"
}


