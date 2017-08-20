package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object HeaderItemDyn {
  implicit def HeaderItemtoJsonObject(in: HeaderItemDyn): JsonObject = in json
}

class HeaderItemDyn extends FormItemDyn with HeaderItemDynInit
