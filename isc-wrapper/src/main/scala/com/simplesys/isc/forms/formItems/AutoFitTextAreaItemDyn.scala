package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object AutoFitTextAreaItemDyn {
  implicit def AutoFitTextAreaItemtoJsonObject(in: AutoFitTextAreaItemDyn): JsonObject = in json
}

class AutoFitTextAreaItemDyn(override val useSelfName: Boolean = false) extends TextAreaItemDyn with AutoFitTextAreaItemDynInit {
  override val selfName: String = "AutoFitTextAreaItem"
}
