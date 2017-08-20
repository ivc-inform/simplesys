package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object ResetItemDyn {
  implicit def ResetItemtoJsonObject(in: ResetItemDyn): JsonObject = in json
}

class ResetItemDyn extends ButtonItemDyn with ResetItemDynInit
