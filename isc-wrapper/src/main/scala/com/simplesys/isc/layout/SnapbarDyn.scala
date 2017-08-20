package com.simplesys.isc.layout

import com.simplesys.json.JsonObject

object SnapbarDyn {

  implicit def Snapbar2JsonObject(in: SnapbarDyn): JsonObject = in json
}

class SnapbarDyn(override val useSelfName: Boolean = false) extends SplitbarDyn with SnapbarDynInit {
  override val selfName = "Snapbar"
}