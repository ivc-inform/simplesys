package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.layout.VStackDyn

object VStackSSDyn {
    implicit def VStackSSDyn2JsonObject(in: VStackSSDyn): JsonObject = in json
}

class VStackSSDyn(override val useSelfName: Boolean = false) extends VStackDyn with VStackSSDynInit {
    override val selfName = "VStackSS"
}