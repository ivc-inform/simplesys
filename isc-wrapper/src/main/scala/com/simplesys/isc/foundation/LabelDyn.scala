package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.control.ButtonDyn

object LabelDyn {

  implicit def Label1toJsonObject(in: LabelDyn): JsonObject = in json
}

class LabelDyn(override val useSelfName: Boolean = false) extends ButtonDyn with LabelDynInit {
  override val selfName = "Label"
}

