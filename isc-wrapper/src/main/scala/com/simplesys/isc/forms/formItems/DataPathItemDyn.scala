package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object DataPathItemDyn {
  implicit def DataPathItemtoJsonObject(in: DataPathItemDyn): JsonObject = in json
}

class DataPathItemDyn extends TextItemDyn with DataPathItemDynInit
