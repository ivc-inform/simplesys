package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.{CanvasDyn, ImgDynInit}
import com.simplesys.json.{JsonNull, UnquotedString}

trait ImgSplitbarDynInit extends ImgDynInit {
  protected val canCollapse: Bool = true
  override protected val canDrag: Bool = true
  protected val hSrc: SCImgURL = "[SKIN]hgrip.png"
  override protected val skinImgDir: URL = "images/SplitBar/".url
  override protected val src: SCImgURL = JsonNull
  protected val target: CanvasDyn = null
  protected val vertical: Bool = null
  protected val vSrc: SCImgURL = "[SKIN]vgrip.png"
}