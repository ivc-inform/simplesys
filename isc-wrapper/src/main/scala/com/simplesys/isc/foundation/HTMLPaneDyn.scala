package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject

object HTMLPaneDyn {

  implicit def HTMLPanetoJsonObject(in: HTMLPaneDyn): JsonObject = in json
}

class HTMLPaneDyn(override val useSelfName: Boolean = false) extends HTMLFlowDyn with HTMLPaneDynInit {
  override val selfName = "HTMLPane"
}
