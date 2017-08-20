package com.simplesys.components

import com.simplesys.log.Logging
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.global._

abstract class Component extends Logging {
  val _Isc = IscDyn()
  val _Isc2 = IscDyn()
  ModeNames = PortalMode

  def create: String
}