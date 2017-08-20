package com.simplesys.isc.layout.toolStrip

import com.simplesys.json.JsonObject
import com.simplesys.isc.control.IMenuButtonDyn

object ToolStripMenuButtonDyn {

  implicit def ToolStripMenuButton2JsonObject(in: ToolStripMenuButtonDyn): JsonObject = in json
}

class ToolStripMenuButtonDyn(override val useSelfName: Boolean = false) extends IMenuButtonDyn with ToolStripMenuButtonDynInit {
  override val selfName = "ToolStripMenuButton"
}