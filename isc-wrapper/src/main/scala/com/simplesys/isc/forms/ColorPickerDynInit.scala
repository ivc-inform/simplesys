package com.simplesys.isc.forms

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDynInit
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.JsonList

trait ColorPickerDynInit extends WindowDynInit {
  protected val allowComplexMode: Bool = true
  protected val autoCenterOnShow: Bool = true
  protected val autoPosition: Bool = true
  protected val basicColorLabel: String = "Basic Colors:"
  protected val cancelButton: AutoChild = null
  protected val cancelButtonConstructor: SCClassName = "IButton"
  protected val colorArray: JsonList = null
  protected val colorButtonBaseStyle: CSSStyleName = "ColorChooserCell"
  protected val colorButtonSize: Number = 20
  protected val colorChanged: FunctionExpression = null
  protected val colorSelected: FunctionExpression = null
  protected val crosshairImageURL: SCImgURL = "[SKIN]ColorPicker/crosshair.png"
  protected val defaultColor: Color = 808080
  protected val defaultOpacity: Number = 100
  protected val defaultPickMode: String = "simple"
  protected val lumWidth: Number = 15
  protected val modeToggleButton: AutoChild = null
  protected val modeToggleButtonConstructor: SCClassName = "IButton"
  protected val okButton: AutoChild = null
  protected val okButtonConstructor: SCClassName = "IButton"
  protected val opacitySliderLabel: String = "Opacity"
  protected val opacityText: Bool = true
  protected val selectedColorLabel: String = "Selected Color"
  protected val supportsTransparency: Bool = true
  protected val swatchHeight: Number = 170
  protected val swatchImageURL: SCImgURL = "[SKIN]ColorPicker/spectrum.png"
  protected val swatchWidth: Number = 170
}