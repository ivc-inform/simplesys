package com.simplesys.isc.layout.toolStrip

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.ImgDynInit
import com.simplesys.json.UnquotedString

trait ToolStripSeparatorDynInit extends ImgDynInit {
  protected val hSrc: SCImgURL = "[SKIN]hseparator.png"
  override protected val skinImgDir: URL = "images/ToolStrip/".url
  protected val vSrc: SCImgURL = "[SKIN]separator.png"
}