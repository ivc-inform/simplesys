package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object VLayoutSSDyn {
    implicit def VLayoutSSDyn2JsonObject(in: VLayoutSSDyn): JsonObject = in json
}

class VLayoutSSDyn(override val useSelfName: Boolean = false) extends LayoutSSDyn with VLayoutSSDynInit {
    override val selfName = "VLayoutSS"
}