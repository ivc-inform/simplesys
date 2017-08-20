package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import formItem.FormItemIconDyn

trait ColorItemDynInit extends TextItemDynInit {
  protected val allowComplexMode: Bool = true
  protected val defaultPickerMode: String = "simple"
  override protected val pickerIconHeight: Number = 18
  override protected val pickerIconProperties: FormItemIconDyn = null
  override protected val pickerIconSrc: SCImgURL = "[SKIN]/DynamicForm/ColorPicker_icon.png"
  override protected val pickerIconWidth: Number = 18
  override protected val showPickerIcon: Bool = true
  protected val supportsTransparency: Bool = false
}