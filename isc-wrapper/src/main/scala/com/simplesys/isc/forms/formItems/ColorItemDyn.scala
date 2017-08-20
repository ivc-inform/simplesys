package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object ColorItemDyn {
  implicit def ColorItemtoJsonObject(in: ColorItemDyn): JsonObject = in json
}

class ColorItemDyn extends TextItemDyn with ColorItemDynInit {

  override val selfName = "ColorItem"

  private[this] var _allowComplexMode: Bool = allowComplexMode
  def AllowComplexMode = _allowComplexMode
  def AllowComplexMode_=(value: Bool) {
    if (_allowComplexMode == value) return
    json("allowComplexMode") = value
    _allowComplexMode = value
  }

  private[this] var _defaultPickerMode: String = defaultPickerMode
  def DefaultPickerMode = _defaultPickerMode
  def DefaultPickerMode_=(value: String) {
    if (_defaultPickerMode == value) return
    json("defaultPickerMode") = value
    _defaultPickerMode = value
  }

  private[this] var _supportsTransparency: Bool = supportsTransparency
  def SupportsTransparency = _supportsTransparency
  def SupportsTransparency_=(value: Bool) {
    if (_supportsTransparency == value) return
    json("supportsTransparency") = value
    _supportsTransparency = value
  }
}
