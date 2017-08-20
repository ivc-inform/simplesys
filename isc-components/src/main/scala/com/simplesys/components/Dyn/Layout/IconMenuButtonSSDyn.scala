package com.simplesys.components.Dyn.Layout

import com.simplesys.isc.control.IconMenuButtonDyn
import com.simplesys.json.JsonObject

object IconMenuButtonSSDyn extends IconMenuButtonSSDynInit {
    implicit def IconMenuButtonSSDyn2JsonObject(in: IconMenuButtonSSDyn): JsonObject = in json
}

class IconMenuButtonSSDyn(override val useSelfName: Boolean = false) extends IconMenuButtonDyn with IconMenuButtonSSDynInit {
    override val selfName = "IconMenuButtonSS"
}