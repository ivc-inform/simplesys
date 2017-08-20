package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.ButtonDyn

object ToolbarItemDyn {
  implicit def ToolbarItemtoJsonObject(in: ToolbarItemDyn): JsonObject = in json
}

class ToolbarItemDyn extends CanvasItemDyn with ToolbarItemDynInit {
  private[this] var _buttonBaseStyle: CSSStyleName = buttonBaseStyle
  def ButtonBaseStyle = _buttonBaseStyle
  def ButtonBaseStyle_=(value: CSSStyleName) {
    if (_buttonBaseStyle == value) return
    json("buttonBaseStyle") = value
    _buttonBaseStyle = value
  }

  private[this] var _buttonConstructor: SCClassName = buttonConstructor
  def ButtonConstructor = _buttonConstructor
  def ButtonConstructor_=(value: SCClassName) {
    if (_buttonConstructor == value) return
    json("buttonConstructor") = value
    _buttonConstructor = value
  }

  private[this] var _buttonProperties: ButtonDyn = buttonProperties
  def ButtonProperties = _buttonProperties
  def ButtonProperties_=(value: ButtonDyn) {
    if (_buttonProperties == value) return
    json("buttonProperties") = value
    _buttonProperties = value
  }

  private[this] var _buttons: JsonList = buttons
  def Buttons = _buttons
  def Buttons_=(value: JsonList) {
    if (_buttons == value) return
    json("buttons") = value
    _buttons = value
  }

  private[this] var _vertical: Bool = vertical
  def Vertical = _vertical
  def Vertical_=(value: Bool) {
    if (_vertical == value) return
    json("vertical") = value
    _vertical = value
  }
}
