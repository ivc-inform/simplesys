package com.simplesys.isc.system.global

sealed abstract trait ModeNames


case object PortalMode extends ModeNames {
  override def toString = "isc."
}

case object SimpleNames extends ModeNames {
  override def toString = ""
}