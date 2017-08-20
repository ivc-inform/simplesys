package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object NativeCheckboxItemDyn {
  implicit def NativeCheckboxItemtoJsonObject(in: NativeCheckboxItemDyn): JsonObject = in json
}

class NativeCheckboxItemDyn extends FormItemDyn with FormItemDynInit with NativeCheckboxItemDynInit {
  private[this] var _showLabel: Bool = showLabel
  def ShowLabel = _showLabel
  def ShowLabel_=(value: Bool) {
    if (_showLabel == value) return
    json("showLabel") = value
    _showLabel = value
  }
}
