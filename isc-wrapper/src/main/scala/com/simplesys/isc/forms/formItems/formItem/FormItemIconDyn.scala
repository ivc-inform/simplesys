package com.simplesys.isc.forms.formItems.formItem

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._

object FormItemIconDyn {
  implicit def FormItemIcontoJsonObject(in: FormItemIconDyn): JsonObject = in json
}

class FormItemIconDyn extends ClassDyn with FormItemIconDynInit {

  private[this] var _click: FunctionExpression = click
  def Click = _click
  def Click_=(value: FunctionExpression) {
    if (_click == value) return
    json("click") = value
    _click = value
  }

  private[this] var _disableOnReadOnly: Bool = disableOnReadOnly
  def DisableOnReadOnly = _disableOnReadOnly
  def DisableOnReadOnly_=(value: Bool) {
    if (_disableOnReadOnly == value) return
    json("disableOnReadOnly") = value
    _disableOnReadOnly = value
  }

  private[this] var _height: Number = height
  def Height = _height
  def Height_=(value: Number) {
    if (_height == value) return
    json("height") = value
    _height = value
  }

  private[this] var _keyPress: FunctionExpression = keyPress
  def KeyPress = _keyPress
  def KeyPress_=(value: FunctionExpression) {
    if (_keyPress == value) return
    json("keyPress") = value
    _keyPress = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _neverDisable: Bool = neverDisable
  def NeverDisable = _neverDisable
  def NeverDisable_=(value: Bool) {
    if (_neverDisable == value) return
    json("neverDisable") = value
    _neverDisable = value
  }

  private[this] var _prompt: String = prompt
  def Prompt = _prompt
  def Prompt_=(value: String) {
    if (_prompt == value) return
    json("prompt") = value
    _prompt = value
  }

  private[this] var _showFocused: Bool = showFocused
  def ShowFocused = _showFocused
  def ShowFocused_=(value: Bool) {
    if (_showFocused == value) return
    json("showFocused") = value
    _showFocused = value
  }

  private[this] var _showFocusedWithItem: Bool = showFocusedWithItem
  def ShowFocusedWithItem = _showFocusedWithItem
  def ShowFocusedWithItem_=(value: Bool) {
    if (_showFocusedWithItem == value) return
    json("showFocusedWithItem") = value
    _showFocusedWithItem = value
  }

  private[this] var _showOver: Bool = showOver
  def ShowOver = _showOver
  def ShowOver_=(value: Bool) {
    if (_showOver == value) return
    json("showOver") = value
    _showOver = value
  }

  private[this] var _src: String = src
  def Src = _src
  def Src_=(value: String) {
    if (_src == value) return
    json("src") = value
    _src = value
  }

  private[this] var _tabIndex: Number = tabIndex
  def TabIndex = _tabIndex
  def TabIndex_=(value: Number) {
    if (_tabIndex == value) return
    json("tabIndex") = value
    _tabIndex = value
  }

  private[this] var _width: Number = width
  def Width = _width
  def Width_=(value: Number) {
    if (_width == value) return
    json("width") = value
    _width = value
  }
}

