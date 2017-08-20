package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.ButtonDyn
import com.simplesys.json.JsonNull

trait ButtonItemDynInit extends CanvasItemDynInit {
  protected val autoFit: Bool = true
  protected val baseStyle: CSSStyleName = ""
  protected val buttonConstructor: SCClassName = "Button"
  protected val buttonProperties: ButtonDyn = null
  override protected val endRow: Bool = true
  override protected val height: Number = null
  protected val icon: SCImgURL = JsonNull
  override protected val showTitle: Bool = false
  override protected val startRow: Bool = true
  override protected val __type: FormItemType = frmitmtpButton
}