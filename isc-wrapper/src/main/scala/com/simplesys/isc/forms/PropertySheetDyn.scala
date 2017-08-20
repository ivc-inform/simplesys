package com.simplesys.isc.forms

import com.simplesys.json.JsonObject

object PropertySheetDyn {

  implicit def PropertySheet2JsonObject(in: PropertySheetDyn): JsonObject = in json
}

class PropertySheetDyn(override val useSelfName: Boolean = false) extends DynamicFormDyn with PropertySheetDynInit {
  override val selfName = "PropertySheet"
}