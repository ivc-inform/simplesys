package com.simplesys.isc.system.typesDyn


sealed abstract trait Autofit

case object aftNull extends Autofit {
  override def toString = ""
}

case object aftVertical extends Autofit {
  override def toString = "vertical"
}

case object aftHorizontal extends Autofit {
  override def toString = "horizontal"
}

case object aftBoth extends Autofit {
  override def toString = "both"
}

