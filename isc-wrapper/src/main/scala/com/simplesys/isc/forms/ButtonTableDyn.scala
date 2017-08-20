package com.simplesys.isc.forms

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object ButtonTableDyn {

  implicit def ButtonTabletoJsonObject(in: ButtonTableDyn): JsonObject = in json
}

class ButtonTableDyn extends ClassDyn with ButtonTableDynInit {
  override val selfName = "ButtonTable"
}
