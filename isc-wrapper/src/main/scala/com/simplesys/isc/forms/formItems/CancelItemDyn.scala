package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object CancelItemDyn {
  implicit def CancelItemtoJsonObject(in: CancelItemDyn): JsonObject = in json
}

class CancelItemDyn extends ButtonItemDyn with CancelItemDynInit
