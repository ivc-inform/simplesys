package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object TextItemDyn {
  implicit def TextItemtoJsonObject(in: TextItemDyn): JsonObject = in json
}

class TextItemDyn(override val useSelfName: Boolean = false) extends FormItemDyn with TextItemDynInit {

  override val selfName: String = "TextItem"

  private[this] var _changeOnKeypress: Bool = changeOnKeypress
  def ChangeOnKeypress = _changeOnKeypress
  def ChangeOnKeypress_=(value: Bool) {
    if (_changeOnKeypress == value) return
    json("changeOnKeypress") = value
    _changeOnKeypress = value
  }

  private[this] var _characterCasing: CharacterCasing = characterCasing
  def CharacterCasing = _characterCasing
  def CharacterCasing_=(value: CharacterCasing) {
    if (_characterCasing == value) return
    json("characterCasing") = value
    _characterCasing = value
  }

  private[this] var _emptyStringValue: String = emptyStringValue
  def EmptyStringValue = _emptyStringValue
  def EmptyStringValue_=(value: String) {
    json("emptyStringValue") = value
    _emptyStringValue = value
  }

  private[this] var _formatOnFocusChange: Bool = formatOnFocusChange
  def FormatOnFocusChange = _formatOnFocusChange
  def FormatOnFocusChange_=(value: Bool) {
    if (_formatOnFocusChange == value) return
    json("formatOnFocusChange") = value
    _formatOnFocusChange = value
  }

  private[this] var _keyPressFilter: String = keyPressFilter
  def KeyPressFilter = _keyPressFilter
  def KeyPressFilter_=(value: String) {
    if (_keyPressFilter == value) return
    json("keyPressFilter") = value
    _keyPressFilter = value
  }

  private[this] var _length: Number = length
  def Length = _length
  def Length_=(value: Number) {
    if (_length == value) return
    json("length") = value
    _length = value
  }

  private[this] var _mask: String = mask
  def Mask = _mask
  def Mask_=(value: String) {
    if (_mask == value) return
    json("mask") = value
    _mask = value
  }

  private[this] var _maskOverwriteMode: Bool = maskOverwriteMode
  def MaskOverwriteMode = _maskOverwriteMode
  def MaskOverwriteMode_=(value: Bool) {
    if (_maskOverwriteMode == value) return
    json("maskOverwriteMode") = value
    _maskOverwriteMode = value
  }

  private[this] var _maskPadChar: String = maskPadChar
  def MaskPadChar = _maskPadChar
  def MaskPadChar_=(value: String) {
    if (_maskPadChar == value) return
    json("maskPadChar") = value
    _maskPadChar = value
  }

  private[this] var _maskPromptChar: String = maskPromptChar
  def MaskPromptChar = _maskPromptChar
  def MaskPromptChar_=(value: String) {
    if (_maskPromptChar == value) return
    json("maskPromptChar") = value
    _maskPromptChar = value
  }

  private[this] var _maskSaveLiterals: Bool = maskSaveLiterals
  def MaskSaveLiterals = _maskSaveLiterals
  def MaskSaveLiterals_=(value: Bool) {
    if (_maskSaveLiterals == value) return
    json("maskSaveLiterals") = value
    _maskSaveLiterals = value
  }

  private[this] var _printFullText: Bool = printFullText
  def PrintFullText = _printFullText
  def PrintFullText_=(value: Bool) {
    if (_printFullText == value) return
    json("printFullTex") = value
    _printFullText = value
  }

  private[this] var _showHintInField: Bool = showHintInField
  def ShowHintInField = _showHintInField
  def ShowHintInField_=(value: Bool) {
    if (_showHintInField == value) return
    json("showHintInField") = value
    _showHintInField = value
  }
}

