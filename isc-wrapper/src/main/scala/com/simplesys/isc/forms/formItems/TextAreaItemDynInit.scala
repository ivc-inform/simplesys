package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait TextAreaItemDynInit extends FormItemDynInit {
  protected val changeOnKeypress: Bool = true
  protected val emptyStringValue: String = null
  override protected val height: Number = 100
  override protected val iconVAlign: AlignmentDyn = ValTop
  protected val minHeight: Number = 16
  protected val printFullText: Bool = true
  protected val showHintInField: Bool = false
  override protected val textBoxStyle: FormItemBaseStyle = "textItem"
  override protected val width: Number = 150
  protected val wrap: TestAreaWrap = TXT_WR_SOFT
  override protected val __type: FormItemType = frmitmtpTextArea
}