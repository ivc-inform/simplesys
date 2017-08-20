package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StretchImgDynInit
import com.simplesys.json.UnquotedString

trait StretchImgButtonDynInit extends StretchImgDynInit {
  protected val action: FunctionExpression = null
  override protected val align: AlignmentDyn = AlCenter
  override protected val baseStyle: CSSStyleName = "stretchImgButton"
  override protected val capSize: Number = 12
  protected val hiliteAccessKey: Bool = true
  protected val iconAlign:AlignmentDyn = AlNull
  protected val iconClick: FunctionExpression = null
  protected val labelBreadthPad: Number = null
  protected val labelHPad: Number = null
  protected val labelLengthPad: Number = null
  protected val labelSkinImgDir: URL = null
  protected val labelVPad: Number = null
  override protected val showTitle: Bool = true
  override protected val src: SCImgURL = "button.gif"
  protected val titleStyle: CSSStyleName = ""
  override protected val vertical: Bool = false
  protected val wrap: Bool = false
}