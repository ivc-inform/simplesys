package com.simplesys.isc.control

import com.simplesys.json.{JsonElement, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

object IMenuButtonDyn {
  implicit def IMenuButtontoJsonObject(in: IMenuButtonDyn): JsonObject = in json
}

class IMenuButtonDyn extends StretchImgButtonDyn with IMenuButtonDynInit {
  override val selfName = "IMenuButton"

  private[this] var _autoDestroyMenu: Bool = autoDestroyMenu
  def AutoDestroyMenu = _autoDestroyMenu
  def AutoDestroyMenu_=(value: Bool) {
    if (_autoDestroyMenu == value) return
    json("autoDestroyMenu") = value
    _autoDestroyMenu = value
  }


  def Menu = json.getJsonElement("menu").getOrElse(menu)
  def Menu_=(value: JsonElement) {
    if (Menu == value) return
    json("menu") = value
  }

  private[this] var _menuAnimationEffect: MenuAnimationEffect = menuAnimationEffect
  def MenuAnimationEffect = _menuAnimationEffect
  def MenuAnimationEffect_=(value: MenuAnimationEffect) {
    if (_menuAnimationEffect == value) return
    json("menuAnimationEffect") = value
    _menuAnimationEffect = value
  }

  private[this] var _menuButtonImage: SCImgURL = menuButtonImage
  def MenuButtonImage = _menuButtonImage
  def MenuButtonImage_=(value: SCImgURL) {
    if (_menuButtonImage == value) return
    json("menuButtonImage") = value
    _menuButtonImage = value
  }

  private[this] var _menuButtonImageUp: SCImgURL = menuButtonImageUp
  def MenuButtonImageUp = _menuButtonImageUp
  def MenuButtonImageUp_=(value: SCImgURL) {
    if (_menuButtonImageUp == value) return
    json("menuButtonImageUp") = value
    _menuButtonImageUp = value
  }

  private[this] var _showMenuBelow: Bool = showMenuBelow
  def ShowMenuBelow = _showMenuBelow
  def ShowMenuBelow_=(value: Bool) {
    if (_showMenuBelow == value) return
    json("showMenuBelow") = value
    _showMenuBelow = value
  }

  private[this] var _showMenuButtonImage: Bool = showMenuButtonImage
  def ShowMenuButtonImage = _showMenuButtonImage
  def ShowMenuButtonImage_=(value: Bool) {
    if (_showMenuButtonImage == value) return
    json("showMenuButtonImage") = value
    _showMenuButtonImage = value
  }
}

