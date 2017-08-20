package com.simplesys.isc.forms.formItems.radioGroupItem

import com.simplesys.json.JsonObject
import com.simplesys.isc.forms.formItems.NativeCheckboxItemDyn

object RadioItemDyn {
  implicit def RadioItemtoJsonObject(in: RadioItemDyn): JsonObject = in json
}

class RadioItemDyn extends NativeCheckboxItemDyn with RadioItemDynInit
