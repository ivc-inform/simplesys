package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.{LayoutDyn, WindowDynInit}
import com.simplesys.isc.foundation.{LabelDyn, ImgDyn}
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonNull, JsonList}

trait DialogDynInit extends WindowDynInit {
  protected val applyClick: FunctionExpression = null
  protected val autoFocus: Bool = true
  protected val buttonClick: FunctionExpression = null
  protected val buttons: ArrayDyn[ButtonDyn] = null
  protected val cancelClick: FunctionExpression = null
  override protected val defaultWidth: Number = 360
  protected val doneClick: FunctionExpression = null
  protected val icon: SCImgURL = JsonNull
  protected val iconSize: Number = 32
  protected val message: HTMLString = ""
  protected val messageIcon: ImgDyn = null
  protected val messageLabel: LabelDyn = null
  protected val messageStack: LayoutDyn = null
  protected val messageStyle: CSSStyleName = "normal"
  protected val noClick: FunctionExpression = null
  protected val okClick: FunctionExpression = null
  protected val saveData: FunctionExpression = null
  protected val showToolbar: Bool = false
  override protected val styleName: CSSStyleName = "dialogBackground"
  protected val toolbar: AutoChild = null
  protected val toolbarButtons: JsonList = null
  protected val yesClick: FunctionExpression = null
}