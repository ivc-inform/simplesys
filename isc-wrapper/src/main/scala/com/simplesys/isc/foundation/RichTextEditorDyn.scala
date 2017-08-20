package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.layout.VLayoutDyn

object RichTextEditorDyn {

  implicit def RichTextEditor2JsonObject(in: RichTextEditorDyn): JsonObject = in json
}

class RichTextEditorDyn(override val useSelfName: Boolean = false) extends VLayoutDyn with RichTextEditorDynInit {
  override val selfName = "RichTextEditor"

  private[this] var _colorControls: Strings = colorControls
  def ColorControls = _colorControls
  def ColorControls_=(value: Strings) {
    if (_colorControls == value) return
    json("colorControls") = value
    _colorControls = value
  }

  private[this] var _controlGroups: Strings = controlGroups
  def ControlGroups = _controlGroups
  def ControlGroups_=(value: Strings) {
    if (_controlGroups == value) return
    json("controlGroups") = value
    _controlGroups = value
  }

  private[this] var _fontControls: Strings = fontControls
  def FontControls = _fontControls
  def FontControls_=(value: Strings) {
    if (_fontControls == value) return
    json("fontControls") = value
    _fontControls = value
  }

  private[this] var _fontNames: ClassDyn = fontNames
  def FontNames = _fontNames
  def FontNames_=(value: ClassDyn) {
    if (_fontNames == value) return
    json("fontNames") = value
    _fontNames = value
  }

  private[this] var _fontSizes: ClassDyn = fontSizes
  def FontSizes = _fontSizes
  def FontSizes_=(value: ClassDyn) {
    if (_fontSizes == value) return
    json("fontSizes") = value
    _fontSizes = value
  }

  private[this] var _formatControls: Strings = formatControls
  def FormatControls = _formatControls
  def FormatControls_=(value: Strings) {
    if (_formatControls == value) return
    json("formatControls") = value
    _formatControls = value
  }

  private[this] var _styleControls: Strings = styleControls
  def StyleControls = _styleControls
  def StyleControls_=(value: Strings) {
    if (_styleControls == value) return
    json("styleControls") = value
    _styleControls = value
  }

  private[this] var _value: String = value
  def Value = _value
  def Value_=(value: String) {
    if (_value == value) return
    json("value") = value
    _value = value
  }
}