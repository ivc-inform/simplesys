package com.simplesys.isc.control

import com.simplesys.json.{JsonNull, JsonElement, UnquotedString, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.global.RuntimeIscException

object IconMenuButtonDyn {
  implicit def IconMenuButtontoJsonObject(in: IconMenuButtonDyn): JsonObject = in json
}

class IconMenuButtonDyn(override val useSelfName: Boolean = false) extends IconButtonDyn with IconMenuButtonDynInit {
  override val selfName = "IconMenuButton"

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
}
