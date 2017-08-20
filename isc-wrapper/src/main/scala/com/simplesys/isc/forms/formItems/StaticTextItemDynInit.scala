package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait StaticTextItemDynInit extends FormItemDynInit {
  protected val clipValue: Bool = false
  override protected val dateFormatter: DateDisplayFormat = ddfNull
  protected val escapeHTML: Bool = false
  protected val outputAsHTML: Bool = false
  override protected val textBoxStyle: FormItemBaseStyle = "staticTextItem"
  protected val wrap: Bool = true
  override protected val __type: FormItemType = frmitmtpStaticText
}