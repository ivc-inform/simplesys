package com.simplesys.isc.layout

import com.simplesys.json.JsonObject

object HLayoutDyn {


  implicit def HLayouttoJsonObject(in: HLayoutDyn): JsonObject = in json
}

class HLayoutDyn(override val useSelfName: Boolean = false) extends LayoutDyn with HLayoutDynInit {
  override val selfName = "HLayout"
}
