package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object StatefulCanvasDyn {

  implicit def StatefulCanvas1toJsonObject(in: StatefulCanvasDyn): JsonObject = in json
}

class StatefulCanvasDyn extends CanvasDyn with StatefulCanvasDynInit {
  private[this] var _title: HTMLString = title
  def Title = _title
  def Title_=(value: HTMLString) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _actionType: SelectionType = actionType
  def ActionType = _actionType
  def ActionType_=(value: SelectionType) {
    if (_actionType == value) return
    json("actionType") = value
    _actionType = value
  }

  private[this] var _align: AlignmentDyn = align
  def Align = _align
  def Align_=(value: AlignmentDyn) {
    if (_align == value) return
    json("align") = value
    _align = value
  }

  private[this] var _autoFit: Bool = autoFit
  def AutoFit = _autoFit
  def AutoFit_=(value: Bool) {
    if (_autoFit == value) return
    json("autoFit") = value
    _autoFit = value
  }

  private[this] var _baseStyle: CSSStyleName = baseStyle
  def BaseStyle = _baseStyle
  def BaseStyle_=(value: CSSStyleName) {
    if (_baseStyle == value) return
    json("baseStyle") = value
    _baseStyle = value
  }

  private[this] var _icon: SCImgURL = icon
  def Icon = _icon
  def Icon_=(value: SCImgURL) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }

  private[this] var _iconHeight: Number = iconHeight
  def IconHeight = _iconHeight
  def IconHeight_=(value: Number) {
    if (_iconHeight == value) return
    json("iconHeight") = value
    _iconHeight = value
  }

  private[this] var _iconOrientation: IconOrientation = iconOrientation
  def IconOrientation = _iconOrientation
  def IconOrientation_=(value: IconOrientation) {
    if (_iconOrientation == value) return
    json("iconOrientation") = value
    _iconOrientation = value
  }

  private[this] var _iconSize: Number = iconSize
  def IconSize = _iconSize
  def IconSize_=(value: Number) {
    if (_iconSize == value) return
    json("iconSize") = value
    _iconSize = value
  }

  private[this] var _iconSpacing: Number = iconSpacing
  def IconSpacing = _iconSpacing
  def IconSpacing_=(value: Number) {
    if (_iconSpacing == value) return
    json("iconSpacing") = value
    _iconSpacing = value
  }

  private[this] var _iconWidth: Number = iconWidth
  def IconWidth = _iconWidth
  def IconWidth_=(value: Number) {
    if (_iconWidth == value) return
    json("iconWidth") = value
    _iconWidth = value
  }

  private[this] var _overCanvas: AutoChild = overCanvas
  def OverCanvas = _overCanvas
  def OverCanvas_=(value: AutoChild) {
    if (_overCanvas == value) return
    json("overCanvas") = value
    _overCanvas = value
  }

  private[this] var _overCanvasConstructor: SCClassName = overCanvasConstructor
  def OverCanvasConstructor = _overCanvasConstructor
  def OverCanvasConstructor_=(value: SCClassName) {
    if (_overCanvasConstructor == value) return
    json("overCanvasConstructor") = value
    _overCanvasConstructor = value
  }

  private[this] var _overCanvasDefaults: CanvasDyn = overCanvasDefaults
  def OverCanvasDefaults = _overCanvasDefaults
  def OverCanvasDefaults_=(value: CanvasDyn) {
    if (_overCanvasDefaults == value) return
    json("overCanvasDefaults") = value
    _overCanvasDefaults = value
  }

  private[this] var _radioGroup: String = radioGroup
  def RadioGroup = _radioGroup
  def RadioGroup_=(value: String) {
    if (_radioGroup == value) return
    json("radioGroup") = value
    _radioGroup = value
  }

  private[this] var _redrawOnStateChange: Bool = redrawOnStateChange
  def RedrawOnStateChange = _redrawOnStateChange
  def RedrawOnStateChange_=(value: Bool) {
    if (_redrawOnStateChange == value) return
    json("redrawOnStateChange") = value
    _redrawOnStateChange = value
  }

  private[this] var _selected: Bool = selected
  def Selected = _selected
  def Selected_=(value: Bool) {
    if (_selected == value) return
    json("selected") = value
    _selected = value
  }

  private[this] var _showDisabled: Bool = showDisabled
  def ShowDisabled = _showDisabled
  def ShowDisabled_=(value: Bool) {
    if (_showDisabled == value) return
    json("showDisabled") = value
    _showDisabled = value
  }

  private[this] var _showDisabledIcon: Bool = showDisabledIcon
  def ShowDisabledIcon = _showDisabledIcon
  def ShowDisabledIcon_=(value: Bool) {
    if (_showDisabledIcon == value) return
    json("showDisabledIcon") = value
    _showDisabledIcon = value
  }

  private[this] var _showDown: Bool = showDown
  def ShowDown = _showDown
  def ShowDown_=(value: Bool) {
    if (_showDown == value) return
    json("showDown") = value
    _showDown = value
  }

  private[this] var _showDownIcon: Bool = showDownIcon
  def ShowDownIcon = _showDownIcon
  def ShowDownIcon_=(value: Bool) {
    if (_showDownIcon == value) return
    json("showDownIcon") = value
    _showDownIcon = value
  }

  private[this] var _showFocus: Bool = showFocus
  def ShowFocus = _showFocus
  def ShowFocus_=(value: Bool) {
    if (_showFocus == value) return
    json("showFocus") = value
    _showFocus = value
  }

  private[this] var _showFocused: Bool = showFocused
  def ShowFocused = _showFocused
  def ShowFocused_=(value: Bool) {
    if (_showFocused == value) return
    json("showFocused") = value
    _showFocused = value
  }

  private[this] var _showFocusedAsOver: Bool = showFocusedAsOver
  def ShowFocusedAsOver = _showFocusedAsOver
  def ShowFocusedAsOver_=(value: Bool) {
    if (_showFocusedAsOver == value) return
    json("showFocusedAsOver") = value
    _showFocusedAsOver = value
  }

  private[this] var _showFocusedIcon: Bool = showFocusedIcon
  def ShowFocusedIcon = _showFocusedIcon
  def ShowFocusedIcon_=(value: Bool) {
    if (_showFocusedIcon == value) return
    json("showFocusedIcon") = value
    _showFocusedIcon = value
  }

  private[this] var _showOverCanvas: Bool = showOverCanvas
  def ShowOverCanvas = _showOverCanvas
  def ShowOverCanvas_=(value: Bool) {
    if (_showOverCanvas == value) return
    json("showOverCanvas") = value
    _showOverCanvas = value
  }

  private[this] var _showRollOver: Bool = showRollOver
  def ShowRollOver = _showRollOver
  def ShowRollOver_=(value: Bool) {
    if (_showRollOver == value) return
    json("showRollOver") = value
    _showRollOver = value
  }

  private[this] var _showRollOverIcon: Bool = showRollOverIcon
  def ShowRollOverIcon = _showRollOverIcon
  def ShowRollOverIcon_=(value: Bool) {
    if (_showRollOverIcon == value) return
    json("showRollOverIcon") = value
    _showRollOverIcon = value
  }

  private[this] var _showSelectedIcon: Bool = showSelectedIcon
  def ShowSelectedIcon = _showSelectedIcon
  def ShowSelectedIcon_=(value: Bool) {
    if (_showSelectedIcon == value) return
    json("showSelectedIcon") = value
    _showSelectedIcon = value
  }

  private[this] var _state = state
  def State = _state
  def State_=(value: State) {
    if (_state == value) return
    json("state") = value
    _state = value
  }

  private[this] var _valign: AlignmentDyn = valign
  def Valign = _valign
  def Valign_=(value: AlignmentDyn) {
    if (_valign == value) return
    json("valign") = value
    _valign = value
  }
}

