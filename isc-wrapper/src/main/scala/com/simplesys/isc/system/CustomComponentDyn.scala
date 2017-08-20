package com.simplesys.isc.system

import com.simplesys.json.{JsonString, JsonElement, JsonObject}
import com.simplesys.isc.foundation.CanvasDyn

object CustomComponentDyn {

    implicit def CustomComponenttoJsonObject(in: CustomComponentDyn): JsonObject = in json
    def apply(_class: ClassDyn) = new CustomComponentDyn(JsonObject(_class))
}

class CustomComponentDyn(override val inJson: JsonObject = null, override val selfName: String = "custom", override val useSelfName: Boolean = false) extends CanvasDyn with CustomComponentDynInit