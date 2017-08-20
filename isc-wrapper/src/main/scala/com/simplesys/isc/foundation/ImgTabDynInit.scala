package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.StretchImgButtonDynInit
import com.simplesys.json.UnquotedString

trait ImgTabDynInit extends StretchImgButtonDynInit {
  override protected val baseStyle: CSSStyleName = "tab"
  override protected val capSize: Number = 2
  override protected val labelSkinImgDir: URL = "images/".url
  override protected val showFocus: Bool = true
  override protected val showFocused: Bool = true
  override protected val showRollOver: Bool = true
  override protected val skinImgDir: URL = "images/Tab/".url
  protected val srs: SCImgURL = "tab.gif"
}