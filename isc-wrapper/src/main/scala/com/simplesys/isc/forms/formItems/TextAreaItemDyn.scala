package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object TextAreaItemDyn {
  implicit def TextAreaItemtoJsonObject(in: TextAreaItemDyn): JsonObject = in json
}

class TextAreaItemDyn(override val useSelfName: Boolean = false) extends FormItemDyn with TextAreaItemDynInit {

  override val selfName: String = "TextAreaItem"

  private[this] var _changeOnKeypress: Bool = changeOnKeypress
  def ChangeOnKeypress = _changeOnKeypress
  def ChangeOnKeypress_=(value: Bool) {
    if (_changeOnKeypress == value) return
    json("changeOnKeypress") = value
    _changeOnKeypress = value
  }

  private[this] var _emptyStringValue: String = emptyStringValue
  def EmptyStringValue = _emptyStringValue
  def EmptyStringValue_=(value: String) {
    json("emptyStringValue") = value
    _emptyStringValue = value
  }

  private[this] var _minHeight: Number = minHeight
  def MinHeight = _minHeight
  def MinHeight_=(value: Number) {
    if (_minHeight == value) return
    json("minHeight") = value
    _minHeight = value
  }

  private[this] var _printFullText: Bool = printFullText
  def PrintFullText = _printFullText
  def PrintFullText_=(value: Bool) {
    if (_printFullText == value) return
    json("printFullText") = value
    _printFullText = value
  }

  private[this] var _showHintInField: Bool = showHintInField
  def ShowHintInField = _showHintInField
  def ShowHintInField_=(value: Bool) {
    if (_showHintInField == value) return
    json("showHintInField") = value
    _showHintInField = value
  }

  private[this] var _wrap: TestAreaWrap = wrap
  def Wrap = _wrap
  def Wrap_=(value: TestAreaWrap) {
    if (_wrap == value) return
    json("wrap") = value
    _wrap = value
  }
}
