package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object ContainerItemDyn {
  implicit def ContainerItemtoJsonObject(in: ContainerItemDyn): JsonObject = in json
}

class ContainerItemDyn extends FormItemDyn with ContainerItemDynInit {

  private[this] var _vertical: Bool = vertical
  def Vertical = _vertical
  def Vertical_=(value: Bool) {
    if (_vertical == value) return
    json("vertical") = value
    _vertical = value
  }

  private[this] var _wrap: Bool = wrap
  def Wrap = _wrap
  def Wrap_=(value: Bool) {
    if (_wrap == value) return
    json("wrap") = value
    _wrap = value
  }
}
