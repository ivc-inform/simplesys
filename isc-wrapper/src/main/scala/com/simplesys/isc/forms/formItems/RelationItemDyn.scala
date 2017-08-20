package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object RelationItemDyn {
  implicit def RelationItemtoJsonObject(in: RelationItemDyn): JsonObject = in json
}

class RelationItemDyn extends ClassDyn with RelationItemDynInit
