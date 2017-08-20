package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object ScrollingMenuDyn {
  implicit def ScrollingMenutoJsonObject(in: ScrollingMenuDyn): JsonObject = in json
}

class ScrollingMenuDyn extends ClassDyn with ScrollingMenuDynInit
