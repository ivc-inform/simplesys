package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object CycleItemDyn {
  implicit def CycleItemtoJsonObject(in: CycleItemDyn): JsonObject = in json
}

class CycleItemDyn extends FormItemDyn with CycleItemDynInit
