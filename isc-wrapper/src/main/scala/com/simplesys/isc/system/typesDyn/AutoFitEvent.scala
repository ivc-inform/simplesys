package com.simplesys.isc.system.typesDyn


sealed abstract trait AutoFitEvent

case object atFtEvntDoubleClick extends AutoFitEvent {
  override def toString = "doubleClick"
}

case object atFtEvntClick extends AutoFitEvent {
  override def toString = "click"
}

case object atFtEvntNone extends AutoFitEvent {
  override def toString = "none"
}


