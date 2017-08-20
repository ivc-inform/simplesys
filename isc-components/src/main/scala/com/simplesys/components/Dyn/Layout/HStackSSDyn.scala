package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.layout.HStackDyn

object HStackSSDyn {
    implicit def HStackSSDyn2JsonObject(in: HStackSSDyn): JsonObject = in json
}

class HStackSSDyn(override val useSelfName: Boolean = false) extends HStackDyn with HStackSSDynInit {
    override val selfName = "HStackSS"
}