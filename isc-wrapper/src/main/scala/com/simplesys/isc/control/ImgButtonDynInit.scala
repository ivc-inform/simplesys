package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.ImgDynInit
import com.simplesys.json.UnquotedString

trait ImgButtonDynInit extends ImgDynInit {
  protected val action: UnquotedString = null
  override protected val autoFit: Bool = null
  override protected val baseStyle: CSSStyleName = "imgButton"
  protected val hiliteAccessKey: Bool = null
  protected val iconAlign: AlignmentDyn = AlNull
  protected val labelHPad: Number = null
  protected val labelVPad: Number = null
  override protected val src: SCImgURL = "[SKIN]/ImgButton/button.png"
  override protected val state: State = stNull
}