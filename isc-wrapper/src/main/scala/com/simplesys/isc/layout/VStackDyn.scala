package com.simplesys.isc.layout

import com.simplesys.json.JsonObject

object VStackDyn {

  implicit def VStacktoJsonObject(in: VStackDyn): JsonObject = in json
}

class VStackDyn(override val useSelfName: Boolean = false) extends LayoutDyn with VStackDynInit {
  override val selfName = "VStack"
}
