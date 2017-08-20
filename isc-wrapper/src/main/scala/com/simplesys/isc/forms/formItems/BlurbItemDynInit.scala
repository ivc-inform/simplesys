package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn.{frmitmtpBlurb, FormItemType}
import com.simplesys.json.JsonElement

trait BlurbItemDynInit extends FormItemDynInit {
  protected val clipValue: Bool = false
  override protected val colSpan: JsonElement = "*"
  override protected val showTitle: Bool = false
  override protected val textBoxStyle: CSSStyleName = "staticTextItem"
  protected val wrap: Bool = false
  override protected val __type: FormItemType = frmitmtpBlurb
}