package com.simplesys.isc.system.typesDyn


sealed abstract trait NavigationDirection

case object NvDrBack extends NavigationDirection {
  override def toString = "Back"
}

case object NvDrForward extends NavigationDirection {
  override def toString = "Forward"
}

case object NvDrNone extends NavigationDirection {
  override def toString = "none"
}

