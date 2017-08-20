package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonNull, JsonElement}

trait IMenuButtonDynInit extends StretchImgButtonDynInit {
  protected val autoDestroyMenu: Bool = true
  override protected val height: Number = 22
  override protected val hiliteAccessKey: Bool = true
  protected val menu: JsonElement = JsonNull
  protected val menuAnimationEffect: MenuAnimationEffect = mnuAnimEffctNull
  protected val menuButtonImage: SCImgURL = "SKIN]menu_button.gif"
  protected val menuButtonImageUp: SCImgURL = "[SKIN]menu_button_up.gif"
  protected val showMenuBelow: Bool = true
  protected val showMenuButtonImage: Bool = true
  override protected val title: String = "Show Menu"
}