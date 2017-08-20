package com.simplesys.isc.layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.CanvasDyn

object LayoutSpacerDyn {

  implicit def LayoutSpacertoJsonObject(in: LayoutSpacerDyn): JsonObject = in json
}

class LayoutSpacerDyn(override val useSelfName: Boolean = false) extends CanvasDyn with LayoutSpacerDynInit {
  override val selfName = "LayoutSpacer"
}