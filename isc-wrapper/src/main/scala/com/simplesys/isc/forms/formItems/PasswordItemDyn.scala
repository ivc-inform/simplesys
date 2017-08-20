package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn.frmitmtpPassword

object PasswordItemDyn {
  implicit def PasswordItemtoJsonObject(in: PasswordItemDyn): JsonObject = in json
}

class PasswordItemDyn(override val useSelfName: Boolean = false) extends TextItemDyn with PasswordItemDynInit {
  EditorType = frmitmtpPassword
  override val selfName: String = "PasswordItem"
}
