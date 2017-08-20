package com.simplesys.isc.layout

import com.simplesys.json.JsonObject

object HStackDyn {

  implicit def HStacktoJsonObject(in: HStackDyn): JsonObject = in json
}

class HStackDyn(override val useSelfName: Boolean = false) extends LayoutDyn with HStackDynInit {
  override val selfName = "HStack"
}
