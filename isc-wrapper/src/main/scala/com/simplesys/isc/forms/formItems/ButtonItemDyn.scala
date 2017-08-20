package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.control.ButtonDyn

object ButtonItemDyn {
  implicit def ButtonItemtoJsonObject(in: ButtonItemDyn): JsonObject = in json
}

class ButtonItemDyn(override val useSelfName: Boolean = false) extends CanvasItemDyn with ButtonItemDynInit {
  EditorType = frmitmtpButton

  override val selfName: String = "ButtonItem"

  private[this] var _autoFit: Bool = autoFit
  def AutoFit = _autoFit
  def AutoFit_=(value: Bool) {
    if (_autoFit == value) return
    json("autoFit") = value
    _autoFit = value
  }

  private[this] var _baseStyle: CSSStyleName = baseStyle
  def BaseStyle = _baseStyle
  def BaseStyle_=(value: CSSStyleName) {
    if (_baseStyle == value) return
    json("baseStyle") = value
    _baseStyle = value
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

  private[this] var _icon: SCImgURL = icon
  def Icon = _icon
  def Icon_=(value: SCImgURL) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }
}

