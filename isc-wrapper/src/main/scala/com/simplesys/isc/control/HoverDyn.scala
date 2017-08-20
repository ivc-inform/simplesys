package com.simplesys.isc.control

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object HoverDyn {
  implicit def Hover2JsonObject(in: HoverDyn): JsonObject = in json
}

class HoverDyn(override val useSelfName: Boolean = false) extends ClassDyn with HoverDynInit {
  override val selfName = "Hover"
}