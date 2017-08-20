package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.ArrayDyn

trait SplitPaneDynInit extends VLayoutDynInit {
  protected val detailNavigationControl: CanvasDyn = null
  protected val detailPane: CanvasDyn = null
  protected val detailToolButtons: ArrayDyn[CanvasDyn] = null
  protected val detailToolStrip: AutoChild = null
  protected val listPane: CanvasDyn = null
  protected val navigationBar: NavigationBarDyn = null
  protected val navigationClick: FunctionExpression = null
  protected val navigationPane: CanvasDyn = null
}