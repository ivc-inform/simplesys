package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.portalLayout.PortletDyn
import com.simplesys.isc.system.ArrayDyn

trait PortalLayoutDynInit extends LayoutDynInit {
  protected val canResizeColumns: Bool = false
  protected val canResizePortlets: Bool = false
  protected val canResizeRows: Bool = false
  protected val canShrinkColumnWidths: Bool = true
  protected val canStretchColumnWidths: Bool = true
  protected val column: AutoChild = null
  protected val columnBorder: String = "1px solid gray"
  protected val columnOverflow: Overflow = ovAuto
  protected val getDropPortlet: FunctionExpression = null
  protected val numColumns: Number = 2
  override protected val overflow: Overflow = ovAuto
  protected val portlets: ArrayDyn[PortletDyn] = null
  protected val preventColumnUnderflow: Bool = true
  protected val preventRowUnderflow: Bool = true
  protected val preventUnderflow: Bool = true
  protected val row: AutoChild = null
  protected val rowLayout: AutoChild = null
  protected val showColumnMenus: Bool = true
  protected val stretchColumnWidthsProportionally: Bool = false
}