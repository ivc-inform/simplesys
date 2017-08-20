package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonNull, JsonElement}

trait MenuButtonDynInit extends ButtonDynInit {
  protected val autoDestroyMenu: Bool = true
  override protected val height: Number = 22
  override protected val hiliteAccessKey: Bool = true
  protected val menu: JsonElement = JsonNull
  protected val menuAnimationEffect: String = ""
  protected val menuButtonImage: SCImgURL = "[SKIN]menu_button.gif"
  protected val menuButtonImageUp: SCImgURL = "[SKIN]menu_button_up.gif"
  protected val rollOverMenuHideDelay: Number = 200
  protected val showMenuBelow: Bool = true
  protected val showMenuButtonImage: Bool = true
  protected val showMenuOnRollOver: Bool = false
  override protected val title: String = "Show Menu"
}