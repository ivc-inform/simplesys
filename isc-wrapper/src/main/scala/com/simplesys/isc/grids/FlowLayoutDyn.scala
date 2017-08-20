package com.simplesys.isc.grids

import com.simplesys.json.JsonObject

object FlowLayoutDyn {

  implicit def FlowLayouttoJsonObject(in: FlowLayoutDyn): JsonObject = in json
}

class FlowLayoutDyn(override val useSelfName: Boolean = false) extends TileLayoutDyn with FlowLayoutDynInit {
  override val selfName = "FlowLayout"
}
