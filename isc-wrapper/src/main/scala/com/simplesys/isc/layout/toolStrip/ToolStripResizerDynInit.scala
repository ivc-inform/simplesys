package com.simplesys.isc.layout.toolStrip

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.ImgSplitbarDynInit
import com.simplesys.json.UnquotedString
import com.simplesys.isc.system.misc._

trait ToolStripResizerDynInit extends ImgSplitbarDynInit {
  override protected val hSrc: SCImgURL = "[SKIN]hresizer.png"
  override protected val skinImgDir: URL = "images/ToolStrip/".url
  override protected val vSrc: SCImgURL = "[SKIN]resizer.png"
}