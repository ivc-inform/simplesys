package com.simplesys.components.Dyn.Control

import com.simplesys.json.JsonObject
import com.simplesys.isc.control.IconButtonDyn
import com.simplesys.components.Dyn.EscapeKeyPressDyn

object IconButtonSSDyn {
  implicit def IconButtonSSDyn2JsonObject(in: IconButtonSSDyn): JsonObject = in json
}

class IconButtonSSDyn(override val useSelfName: Boolean = false) extends IconButtonDyn with EscapeKeyPressDyn with IconButtonSSDynInit {
  override val selfName = "IconButtonSS"
}