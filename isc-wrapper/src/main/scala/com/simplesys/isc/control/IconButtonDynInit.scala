package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonNull

trait IconButtonDynInit extends ButtonDynInit {
  override protected val baseStyle: CSSStyleName = "iconButton"
  protected val largeIcon: SCImgURL = JsonNull
  protected val largeIconSize: Number = 32
  protected val menuIconSrc: SCImgURL = "[SKINIMG]/Menu/submenu_down.png"
  protected val orientation: IconButtonOrientation = icbtnOrntHorizontal
  protected val showMenuIcon: Bool = false
  protected val showMenuIconOver: Bool = false
}