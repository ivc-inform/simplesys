package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object RowSpacerItemDyn {
  implicit def RowSpacerItemtoJsonObject(in: RowSpacerItemDyn): JsonObject = in json
}

class RowSpacerItemDyn extends SpacerItemDyn with RowSpacerItemDynInit
