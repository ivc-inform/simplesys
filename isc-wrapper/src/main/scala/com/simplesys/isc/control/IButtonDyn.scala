package com.simplesys.isc.control

import com.simplesys.json.JsonObject

object IButtonDyn {
  implicit def IButtontoJsonObject(in: IButtonDyn): JsonObject = in json
}

class IButtonDyn(override val useSelfName: Boolean = false) extends StretchImgButtonDyn with IButtonDynInit {
  override val selfName = "IButton"
}
