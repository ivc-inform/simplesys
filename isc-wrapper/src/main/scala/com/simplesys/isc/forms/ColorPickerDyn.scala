package com.simplesys.isc.forms

import com.simplesys.json.{JsonList, UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.WindowDyn
import com.simplesys.isc.system.ArrayDyn

object ColorPickerDyn {

  implicit def ColorPicker2JsonObject(in: ColorPickerDyn): JsonObject = in json
}

class ColorPickerDyn(override val useSelfName: Boolean = false) extends WindowDyn with ColorPickerDynInit {
  override val selfName = "ColorPicker"

  private[this] var _allowComplexMode: Bool = allowComplexMode
  def AllowComplexMode = _allowComplexMode
  def AllowComplexMode_=(value: Bool) {
    if (_allowComplexMode == value) return
    json("allowComplexMode") = value
    _allowComplexMode = value
  }

  private[this] var _autoCenterOnShow: Bool = autoCenterOnShow
  def AutoCenterOnShow = _autoCenterOnShow
  def AutoCenterOnShow_=(value: Bool) {
    if (_autoCenterOnShow == value) return
    json("autoCenterOnShow") = value
    _autoCenterOnShow = value
  }

  private[this] var _autoPosition: Bool = autoPosition
  def AutoPosition = _autoPosition
  def AutoPosition_=(value: Bool) {
    if (_autoPosition == value) return
    json("autoPosition") = value
    _autoPosition = value
  }

  private[this] var _basicColorLabel: String = basicColorLabel
  def BasicColorLabel = _basicColorLabel
  def BasicColorLabel_=(value: String) {
    if (_basicColorLabel == value) return
    json("basicColorLabel") = value
    _basicColorLabel = value
  }

  private[this] var _cancelButton: AutoChild = cancelButton
  def CancelButton = _cancelButton
  def CancelButton_=(value: AutoChild) {
    if (_cancelButton == value) return
    json("cancelButton") = value
    _cancelButton = value
  }

  private[this] var _cancelButtonConstructor: SCClassName = cancelButtonConstructor
  def CancelButtonConstructor = _cancelButtonConstructor
  def CancelButtonConstructor_=(value: SCClassName) {
    if (_cancelButtonConstructor == value) return
    json("cancelButtonConstructor") = value
    _cancelButtonConstructor = value
  }

  def ColorArray = json.getJsonListOpt("colorArray").getOrElse(colorArray)
  def ColorArray_=(value: JsonList) {
    if (ColorArray == value) return
    json("colorArray") = value
  }

  private[this] var _colorButtonBaseStyle: CSSStyleName = colorButtonBaseStyle
  def ColorButtonBaseStyle = _colorButtonBaseStyle
  def ColorButtonBaseStyle_=(value: CSSStyleName) {
    if (_colorButtonBaseStyle == value) return
    json("colorButtonBaseStyle") = value
    _colorButtonBaseStyle = value
  }

  private[this] var _colorButtonSize: Number = colorButtonSize
  def ColorButtonSize = _colorButtonSize
  def ColorButtonSize_=(value: Number) {
    if (_colorButtonSize == value) return
    json("colorButtonSize") = value
    _colorButtonSize = value
  }

  private[this] var _colorChanged: FunctionExpression = colorChanged
  def ColorChanged = _colorChanged
  def ColorChanged_=(value: FunctionExpression) {
    if (_colorChanged == value) return
    json("colorChanged") = value
    _colorChanged = value
  }

  private[this] var _colorSelected: FunctionExpression = colorSelected
  def ColorSelected = _colorSelected
  def ColorSelected_=(value: FunctionExpression) {
    if (_colorSelected == value) return
    json("colorSelected") = value
    _colorSelected = value
  }

  private[this] var _crosshairImageURL: SCImgURL = crosshairImageURL
  def CrosshairImageURL = _crosshairImageURL
  def CrosshairImageURL_=(value: SCImgURL) {
    if (_crosshairImageURL == value) return
    json("crosshairImageURL") = value
    _crosshairImageURL = value
  }

  private[this] var _defaultColor: Color = defaultColor
  def DefaultColor = _defaultColor
  def DefaultColor_=(value: Color) {
    if (_defaultColor == value) return
    json("defaultColor") = value
    _defaultColor = value
  }

  private[this] var _defaultOpacity: Number = defaultOpacity
  def DefaultOpacity = _defaultOpacity
  def DefaultOpacity_=(value: Number) {
    if (_defaultOpacity == value) return
    json("defaultOpacity") = value
    _defaultOpacity = value
  }

  private[this] var _defaultPickMode: String = defaultPickMode
  def DefaultPickMode = _defaultPickMode
  def DefaultPickMode_=(value: String) {
    if (_defaultPickMode == value) return
    json("defaultPickMode") = value
    _defaultPickMode = value
  }

  private[this] var _lumWidth: Number = lumWidth
  def LumWidth = _lumWidth
  def LumWidth_=(value: Number) {
    if (_lumWidth == value) return
    json("lumWidth") = value
    _lumWidth = value
  }

  private[this] var _modeToggleButton: AutoChild = modeToggleButton
  def ModeToggleButton = _modeToggleButton
  def ModeToggleButton_=(value: AutoChild) {
    if (_modeToggleButton == value) return
    json("modeToggleButton") = value
    _modeToggleButton = value
  }

  private[this] var _modeToggleButtonConstructor: SCClassName = modeToggleButtonConstructor
  def ModeToggleButtonConstructor = _modeToggleButtonConstructor
  def ModeToggleButtonConstructor_=(value: SCClassName) {
    if (_modeToggleButtonConstructor == value) return
    json("modeToggleButtonConstructor") = value
    _modeToggleButtonConstructor = value
  }

  private[this] var _okButton: AutoChild = okButton
  def OkButton = _okButton
  def OkButton_=(value: AutoChild) {
    if (_okButton == value) return
    json("okButton") = value
    _okButton = value
  }

  private[this] var _okButtonConstructor: SCClassName = okButtonConstructor
  def OkButtonConstructor = _okButtonConstructor
  def OkButtonConstructor_=(value: SCClassName) {
    if (_okButtonConstructor == value) return
    json("okButtonConstructor") = value
    _okButtonConstructor = value
  }

  private[this] var _opacitySliderLabel: String = opacitySliderLabel
  def OpacitySliderLabel = _opacitySliderLabel
  def OpacitySliderLabel_=(value: String) {
    if (_opacitySliderLabel == value) return
    json("opacitySliderLabel") = value
    _opacitySliderLabel = value
  }

  private[this] var _opacityText: Bool = opacityText
  def OpacityText = _opacityText
  def OpacityText_=(value: Bool) {
    if (_opacityText == value) return
    json("opacityText") = value
    _opacityText = value
  }

  private[this] var _selectedColorLabel: String = selectedColorLabel
  def SelectedColorLabel = _selectedColorLabel
  def SelectedColorLabel_=(value: String) {
    if (_selectedColorLabel == value) return
    json("selectedColorLabel") = value
    _selectedColorLabel = value
  }

  private[this] var _supportsTransparency: Bool = supportsTransparency
  def SupportsTransparency = _supportsTransparency
  def SupportsTransparency_=(value: Bool) {
    if (_supportsTransparency == value) return
    json("supportsTransparency") = value
    _supportsTransparency = value
  }

  private[this] var _swatchHeight: Number = swatchHeight
  def SwatchHeight = _swatchHeight
  def SwatchHeight_=(value: Number) {
    if (_swatchHeight == value) return
    json("swatchHeight") = value
    _swatchHeight = value
  }

  private[this] var _swatchImageURL: SCImgURL = swatchImageURL
  def SwatchImageURL = _swatchImageURL
  def SwatchImageURL_=(value: SCImgURL) {
    if (_swatchImageURL == value) return
    json("swatchImageURL") = value
    _swatchImageURL = value
  }

  private[this] var _swatchWidth: Number = swatchWidth
  def SwatchWidth = _swatchWidth
  def SwatchWidth_=(value: Number) {
    if (_swatchWidth == value) return
    json("swatchWidth") = value
    _swatchWidth = value
  }
}