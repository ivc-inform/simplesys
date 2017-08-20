package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait CheckboxItemDynInit extends CycleItemDynInit {
  protected val allowEmptyValue: Bool = false
  protected val checkedImage: SCImgURL = "[SKIN]/DynamicForm/checked.gif"
  protected val labelAsTitle: Bool = false
  protected val partialSelectedImage: SCImgURL = "[SKIN]/DynamicForm/partialcheck.gif"
  protected val showLabel: Bool = true
  protected val showUnsetImage: Bool = false
  override protected val textBoxStyle: FormItemBaseStyle = "labelAnchor"
  override protected val titleStyle: FormItemBaseStyle = ""
  protected val uncheckedImage: SCImgURL = "[SKIN]/DynamicForm/unchecked.gif"
  protected val unsetImage: SCImgURL = "[SKIN]/DynamicForm/unsetcheck.gif"
  override protected val valueIconHeight: Number = 13
  override protected val valueIconWidth: Number = 13
  override protected val __type: FormItemType = frmitmtpCheckBox
}