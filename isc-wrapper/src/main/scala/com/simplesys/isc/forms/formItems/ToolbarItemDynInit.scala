package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonList}
import com.simplesys.isc.control.ButtonDyn

trait ToolbarItemDynInit extends CanvasItemDynInit {
  protected val buttonBaseStyle: CSSStyleName = ""
  protected val buttonConstructor: SCClassName = "AutoFitButton"
  protected val buttonProperties: ButtonDyn = null
  protected val buttons: JsonList = JsonList()
  override protected val colSpan:JsonElement = true
  override protected val endRow: Bool = true
  override protected val showTitle: Bool = false
  override protected val startRow: Bool = true
  protected val vertical: Bool = false
}