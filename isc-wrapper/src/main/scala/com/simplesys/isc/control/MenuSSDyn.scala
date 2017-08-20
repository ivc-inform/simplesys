package com.simplesys.isc.control

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object MenuSSDyn extends MenuSSDynInit {
    implicit def MenuSSDyn2JsonObject(in: MenuSSDyn): JsonObject = in json
}

class MenuSSDyn(override val useSelfName: Boolean = false) extends MenuDyn with MenuSSDynInit {
    override val selfName = "MenuSS"
}