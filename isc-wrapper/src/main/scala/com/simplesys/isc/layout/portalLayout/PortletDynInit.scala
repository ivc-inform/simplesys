package com.simplesys.isc.layout.portalLayout

import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDynInit

trait PortletDynInit extends WindowDynInit {
  override protected val canDrop: Bool = true
  protected val closeConfirmationMessage: String = "Close portlet?"
  protected val destroyOnClose: Bool = false
  override protected val minHeight: Number = 60
  override protected val minWidth: Number = 70
  protected val rowHeight: Number = null
  protected val showCloseConfirmationMessage: Bool = true
}