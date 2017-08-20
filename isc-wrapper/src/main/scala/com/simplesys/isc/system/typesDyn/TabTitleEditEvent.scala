package com.simplesys.isc.system.typesDyn


sealed abstract trait TabTitleEditEvent

case object tbttlEdEvtNull extends TabTitleEditEvent {
  override def toString = ""
}

case object tbttlEdEvtClick extends TabTitleEditEvent {
  override def toString = "click"
}

case object tbttlEdEvtDoubleClick extends TabTitleEditEvent {
  override def toString = "doubleClick"
}
