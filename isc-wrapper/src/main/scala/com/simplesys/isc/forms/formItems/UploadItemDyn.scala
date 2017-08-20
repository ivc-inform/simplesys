package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object UploadItemDyn {
  implicit def UploadItemtoJsonObject(in: UploadItemDyn): JsonObject = in json
}

class UploadItemDyn extends TextItemDyn with UploadItemDynInit
