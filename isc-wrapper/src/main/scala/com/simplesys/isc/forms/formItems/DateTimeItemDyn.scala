package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object DateTimeItemDyn {
  implicit def DateTimeItemtoJsonObject(in: DateTimeItemDyn): JsonObject = in json
}

class DateTimeItemDyn extends DateDynItem with DateTimeItemDynInit
