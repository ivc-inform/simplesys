package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object SelectOtherItemDyn {
  implicit def SelectOtherItemtoJsonObject(in: SelectOtherItemDyn): JsonObject = in json
}

class SelectOtherItemDyn extends ClassDyn with SelectOtherItemDynInit {
  private[this] var _dialogWidth: Number = dialogWidth
  def DialogWidth = _dialogWidth
  def DialogWidth_=(value: Number) {
    if (_dialogWidth == value) return
    json("dialogWidth") = value
    _dialogWidth = value
  }

  private[this] var _otherTitle: String = otherTitle
  def OtherTitle = _otherTitle
  def OtherTitle_=(value: String) {
    if (_otherTitle == value) return
    json("otherTitle") = value
    _otherTitle = value
  }

  private[this] var _otherValue: String = otherValue
  def OtherValue = _otherValue
  def OtherValue_=(value: String) {
    if (_otherValue == value) return
    json("otherValue") = value
    _otherValue = value
  }

  private[this] var _selectOtherPrompt: HTMLString = selectOtherPrompt
  def SelectOtherPrompt = _selectOtherPrompt
  def SelectOtherPrompt_=(value: HTMLString) {
    if (_selectOtherPrompt == value) return
    json("selectOtherPrompt") = value
    _selectOtherPrompt = value
  }

  private[this] var _separatorTitle: String = separatorTitle
  def SeparatorTitle = _separatorTitle
  def SeparatorTitle_=(value: String) {
    if (_separatorTitle == value) return
    json("separatorTitle") = value
    _separatorTitle = value
  }

  private[this] var _separatorValue: String = separatorValue
  def SeparatorValue = _separatorValue
  def SeparatorValue_=(value: String) {
    if (_separatorValue == value) return
    json("separatorValue") = value
    _separatorValue = value
  }
}

