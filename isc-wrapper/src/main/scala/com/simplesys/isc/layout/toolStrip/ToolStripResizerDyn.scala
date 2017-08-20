package com.simplesys.isc.layout.toolStrip

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.ImgSplitbarDyn

object ToolStripResizerDyn {

  implicit def ToolStripResizer2JsonObject(in: ToolStripResizerDyn): JsonObject = in json
}

class ToolStripResizerDyn(override val useSelfName: Boolean = false) extends ImgSplitbarDyn with ToolStripResizerDynInit {
  override val selfName = "ToolStripResizer"
}