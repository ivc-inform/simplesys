package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object StaticTextItemDyn {
  implicit def StaticTextItemtoJsonObject(in: StaticTextItemDyn): JsonObject = in json
}

class StaticTextItemDyn extends FormItemDyn with StaticTextItemDynInit {
  private[this] var _clipValue: Bool = clipValue
  def ClipValue = _clipValue
  def ClipValue_=(value: Bool) {
    if (_clipValue == value) return
    json("clipValue") = value
    _clipValue = value
  }

  private[this] var _escapeHTML: Bool = escapeHTML
  def EscapeHTML = _escapeHTML
  def EscapeHTML_=(value: Bool) {
    if (_escapeHTML == value) return
    json("escapeHTML") = value
    _escapeHTML = value
  }

  private[this] var _outputAsHTML: Bool = outputAsHTML
  def OutputAsHTML = _outputAsHTML
  def OutputAsHTML_=(value: Bool) {
    if (_outputAsHTML == value) return
    json("outputAsHTML") = value
    _outputAsHTML = value
  }

  private[this] var _wrap: Bool = wrap
  def Wrap = _wrap
  def Wrap_=(value: Bool) {
    if (_wrap == value) return
    json("wrap") = value
    _wrap = value
  }
}
