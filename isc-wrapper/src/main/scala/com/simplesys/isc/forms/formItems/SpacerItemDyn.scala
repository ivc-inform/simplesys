package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object SpacerItemDyn {
  implicit def SpacerItemtoJsonObject(in: SpacerItemDyn): JsonObject = in json
}

class SpacerItemDyn(override val useSelfName: Boolean = false) extends FormItemDyn with SpacerItemDynInit {
  override val selfName = "SpacerItem"
}
