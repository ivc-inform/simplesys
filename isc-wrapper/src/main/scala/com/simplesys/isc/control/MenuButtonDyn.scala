package com.simplesys.isc.control

import com.simplesys.json.{JsonElement, UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.control

object MenuButtonDyn {
  implicit def MenuButtontoJsonObject(in: MenuButtonDyn): JsonObject = in json
}

class MenuButtonDyn(override val useSelfName: Boolean = false) extends ButtonDyn with MenuButtonDynInit {
  override val selfName = "MenuButton"

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

  private[this] var _menuAnimationEffect: String = menuAnimationEffect
  def MenuAnimationEffect = _menuAnimationEffect
  def MenuAnimationEffect_=(value: String) {
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

  private[this] var _rollOverMenuHideDelay: Number = rollOverMenuHideDelay
  def RollOverMenuHideDelay = _rollOverMenuHideDelay
  def RollOverMenuHideDelay_=(value: Number) {
    if (_rollOverMenuHideDelay == value) return
    json("rollOverMenuHideDelay") = value
    _rollOverMenuHideDelay = value
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

  private[this] var _showMenuOnRollOver: Bool = showMenuOnRollOver
  def ShowMenuOnRollOver = _showMenuOnRollOver
  def ShowMenuOnRollOver_=(value: Bool) {
    if (_showMenuOnRollOver == value) return
    json("showMenuOnRollOver") = value
    _showMenuOnRollOver = value
  }
}

