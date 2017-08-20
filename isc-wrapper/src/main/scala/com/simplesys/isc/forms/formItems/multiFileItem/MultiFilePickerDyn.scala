package com.simplesys.isc.forms.formItems.multiFileItem

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.VStackDyn

object MultiFilePickerDyn {
  implicit def MultiFilePickertoJsonObject(in: MultiFilePickerDyn): JsonObject = in json
}

class MultiFilePickerDyn(override val useSelfName: Boolean = false) extends VStackDyn with MultiFilePickerDynInit {
  override val selfName = "MultiFilePicker"
}
