package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonElement

trait HiddenItemDynInit extends FormItemDynInit {
  override protected val colSpan: JsonElement = 0
  override protected val rowSpan: Number = 0
  override protected val showTitle: Bool = false
}