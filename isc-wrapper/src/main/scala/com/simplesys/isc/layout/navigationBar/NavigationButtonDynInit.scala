package com.simplesys.isc.layout.navigationBar

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.ButtonDynInit

trait NavigationButtonDynInit extends ButtonDynInit {
  protected val backBaseStyle: CSSStyleName = "navBackButton"
  override protected val baseStyle: CSSStyleName = "navButton"
  protected val direction: NavigationDirection = NvDrNone
  protected val forwardBaseStyle: CSSStyleName = "navForwardButton"
}