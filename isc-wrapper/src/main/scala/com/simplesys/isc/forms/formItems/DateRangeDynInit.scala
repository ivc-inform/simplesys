package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonElement, JsonNull}


trait DateRangeDynInit {
  protected val end: JsonElement = JsonNull
  protected val start: JsonElement = JsonNull
}