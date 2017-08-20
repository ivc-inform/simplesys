package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object HLayoutSSDyn extends HLayoutSSDynInit {
    implicit def HLayoutSSDyn2JsonObject(in: HLayoutSSDyn): JsonObject = in json
}

class HLayoutSSDyn(override val useSelfName: Boolean = false) extends LayoutSSDyn with HLayoutSSDynInit {
    override val selfName = "HLayoutSS"
}