
package com.simplesys.isc.system.typesDyn


sealed abstract trait DragAppearance

case object drAprncNull extends DragAppearance {
  override def toString = ""
}

case object drAprncNone extends DragAppearance {
  override def toString = "none"
}

case object drAprncTracker extends DragAppearance {
  override def toString = "tracker"
}

case object drAprncTarget extends DragAppearance {
  override def toString = "target"
}

case object drAprncOutline extends DragAppearance {
  override def toString = "outline"
}

