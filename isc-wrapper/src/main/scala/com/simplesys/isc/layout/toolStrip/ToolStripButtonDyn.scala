package com.simplesys.isc.layout.toolStrip

import com.simplesys.json.JsonObject
import com.simplesys.isc.control.StretchImgButtonDyn

object ToolStripButtonDyn {

  implicit def ToolStripButton2JsonObject(in: ToolStripButtonDyn): JsonObject = in json
}

class ToolStripButtonDyn(override val useSelfName: Boolean = false) extends StretchImgButtonDyn with ToolStripButtonDynInit {
  override val selfName = "ToolStripButton"
}