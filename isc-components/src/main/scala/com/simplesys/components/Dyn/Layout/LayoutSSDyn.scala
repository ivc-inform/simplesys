package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.layout.LayoutDyn

object LayoutSSDyn extends LayoutSSDynInit {
  implicit def LayoutSSDyn2JsonObject(in: LayoutSSDyn): JsonObject = in json
}

class LayoutSSDyn(override val useSelfName: Boolean = false) extends LayoutDyn with LayoutSSDynInit {
  override val selfName = "LayoutSS"
}