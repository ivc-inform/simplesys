package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonList}

trait RichTextItemDynInit extends CanvasItemDynInit {
  override protected val colSpan: JsonElement = "*"
  protected val controlGroups: JsonList = JsonList()
  override protected val endRow: Bool = true
  override protected val showTitle: Bool = false
  override protected val startRow: Bool = true
}