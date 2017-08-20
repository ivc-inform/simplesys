package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object HiddenItemDyn {
  implicit def HiddenItemtoJsonObject(in: HiddenItemDyn): JsonObject = in json
}

class HiddenItemDyn extends FormItemDyn with HiddenItemDynInit
