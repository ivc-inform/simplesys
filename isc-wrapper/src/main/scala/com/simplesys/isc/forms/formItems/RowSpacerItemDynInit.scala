package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonElement

trait RowSpacerItemDynInit extends SpacerItemDynInit {
  override protected val colSpan: JsonElement = "*"
  override protected val endRow: Bool = true
  override protected val showTitle: Bool = false
  override protected val startRow: Bool = true
}