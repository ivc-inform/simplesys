package com.simplesys.isc.system.typesDyn


sealed abstract trait VisibilityMode

case object vsbMdMutext extends VisibilityMode {
  override def toString = "mutex"
}

case object vsbMdMultiple extends VisibilityMode {
  override def toString = "multiple"
}

