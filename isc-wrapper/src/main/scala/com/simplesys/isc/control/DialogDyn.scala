package com.simplesys.isc.control

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.{LayoutDyn, WindowDyn}
import com.simplesys.isc.foundation.{LabelDyn, ImgDyn}
import com.simplesys.isc.system.ArrayDyn

object DialogDyn {
  implicit def Dialog2JsonObject(in: DialogDyn): JsonObject = in json
}

class DialogDyn(override val useSelfName: Boolean = false) extends WindowDyn with DialogDynInit {
  override val selfName = "Dialog"

  private[this] var _applyClick: FunctionExpression = applyClick
  def ApplyClick = _applyClick
  def ApplyClick_=(value: FunctionExpression) {
    if (_applyClick == value) return
    json("applyClick") = value
    _applyClick = value
  }

  private[this] var _autoFocus: Bool = autoFocus
  def AutoFocus = _autoFocus
  def AutoFocus_=(value: Bool) {
    if (_autoFocus == value) return
    json("autoFocus") = value
    _autoFocus = value
  }

  private[this] var _buttonClick: FunctionExpression = buttonClick
  def ButtonClick = _buttonClick
  def ButtonClick_=(value: FunctionExpression) {
    if (_buttonClick == value) return
    json("buttonClick") = value
    _buttonClick = value
  }

  private[this] var _buttons: ArrayDyn[ButtonDyn] = buttons
  def Buttons = _buttons
  def Buttons_=(value: ArrayDyn[ButtonDyn]) {
    json("buttons") = value
    _buttons = value
  }

  def ToolbarButtons = json.getJsonListOpt("toolbarButtons").getOrElse(toolbarButtons)
  def ToolbarButtons_=(value: JsonList) {
    if (ToolbarButtons == value) return
    json("toolbarButtons") = value
  }

  private[this] var _cancelClick: FunctionExpression = cancelClick
  def CancelClick = _cancelClick
  def CancelClick_=(value: FunctionExpression) {
    if (_cancelClick == value) return
    json("cancelClick") = value
    _cancelClick = value
  }

  private[this] var _doneClick: FunctionExpression = doneClick
  def DoneClick = _doneClick
  def DoneClick_=(value: FunctionExpression) {
    if (_doneClick == value) return
    json("doneClick") = value
    _doneClick = value
  }

  private[this] var _icon: SCImgURL = icon
  def Icon = _icon
  def Icon_=(value: SCImgURL) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }

  private[this] var _iconSize: Number = iconSize
  def IconSize = _iconSize
  def IconSize_=(value: Number) {
    if (_iconSize == value) return
    json("iconSize") = value
    _iconSize = value
  }

  private[this] var _message: HTMLString = message
  def Message = _message
  def Message_=(value: HTMLString) {
    if (_message == value) return
    json("message") = value
    _message = value
  }

  private[this] var _messageIcon: ImgDyn = messageIcon
  def MessageIcon = _messageIcon
  def MessageIcon_=(value: ImgDyn) {
    if (_messageIcon == value) return
    json("messageIcon") = value
    _messageIcon = value
  }

  private[this] var _messageLabel: LabelDyn = messageLabel
  def MessageLabel = _messageLabel
  def MessageLabel_=(value: LabelDyn) {
    if (_messageLabel == value) return
    json("messageLabel") = value
    _messageLabel = value
  }

  private[this] var _messageStack: LayoutDyn = messageStack
  def MessageStack = _messageStack
  def MessageStack_=(value: LayoutDyn) {
    if (_messageStack == value) return
    json("messageStack") = value
    _messageStack = value
  }

  private[this] var _messageStyle: CSSStyleName = messageStyle
  def MessageStyle = _messageStyle
  def MessageStyle_=(value: CSSStyleName) {
    if (_messageStyle == value) return
    json("messageStyle") = value
    _messageStyle = value
  }

  private[this] var _noClick: FunctionExpression = noClick
  def NoClick = _noClick
  def NoClick_=(value: FunctionExpression) {
    if (_noClick == value) return
    json("noClick") = value
    _noClick = value
  }

  private[this] var _okClick: FunctionExpression = okClick
  def OkClick = _okClick
  def OkClick_=(value: FunctionExpression) {
    if (_okClick == value) return
    json("okClick") = value
    _okClick = value
  }

  private[this] var _saveData: FunctionExpression = saveData
  def SaveData = _saveData
  def SaveData_=(value: FunctionExpression) {
    if (_saveData == value) return
    json("saveData") = value
    _saveData = value
  }

  private[this] var _showToolbar: Bool = showToolbar
  def ShowToolbar = _showToolbar
  def ShowToolbar_=(value: Bool) {
    if (_showToolbar == value) return
    json("showToolbar") = value
    _showToolbar = value
  }

  private[this] var _toolbar: AutoChild = toolbar
  def Toolbar = _toolbar
  def Toolbar_=(value: AutoChild) {
    if (_toolbar == value) return
    json("toolbar") = value
    _toolbar = value
  }

  private[this] var _yesClick: FunctionExpression = yesClick
  def YesClick = _yesClick
  def YesClick_=(value: FunctionExpression) {
    if (_yesClick == value) return
    json("yesClick") = value
    _yesClick = value
  }
}