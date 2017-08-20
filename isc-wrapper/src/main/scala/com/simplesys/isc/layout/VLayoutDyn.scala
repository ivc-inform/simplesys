package com.simplesys.isc.layout

import com.simplesys.json.JsonObject

object VLayoutDyn {

  implicit def VLayouttoJsonObject(in: VLayoutDyn): JsonObject = in json
}

class VLayoutDyn(override val useSelfName: Boolean = false) extends LayoutDyn with VLayoutDynInit {
  override val selfName = "VLayout"
}
