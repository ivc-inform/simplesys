package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object IPickTreeItemDyn {
  implicit def IPickTreeItemtoJsonObject(in: IPickTreeItemDyn): JsonObject = in json
}

class IPickTreeItemDyn extends PickTreeItemDyn with IPickTreeItemDynInit
