package com.simplesys.components.Dyn.Layout

import com.simplesys.isc.layout.TabSetDyn
import com.simplesys.json.JsonObject

object TabSetSSDyn extends TabSetSSDynInit {
    implicit def TabSetSSDyn2JsonObject(in: TabSetSSDyn): JsonObject = in json
}

class TabSetSSDyn(override val useSelfName: Boolean = false) extends TabSetDyn with TabSetSSDynInit {
    override val selfName = "TabSetSS"
}