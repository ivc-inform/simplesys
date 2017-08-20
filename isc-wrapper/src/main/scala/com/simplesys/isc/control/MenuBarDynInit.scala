package com.simplesys.isc.control

import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.ToolbarDynInit
import com.simplesys.isc.system.ArrayDyn

trait MenuBarDynInit extends ToolbarDynInit {
  protected val menus: ArrayDyn[MenuDyn] = null
  override protected val tabIndex: Number = -1
}