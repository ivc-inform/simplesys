package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object SubmitItemDyn {
  implicit def SubmitItemtoJsonObject(in: SubmitItemDyn): JsonObject = in json
}

class SubmitItemDyn extends ButtonItemDyn with SubmitItemDynInit
