package com.simplesys.isc.grids.listGrid

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object GroupingMessagesDyn {

  implicit def GroupingMessagestoJsonObject(in: GroupingMessagesDyn): JsonObject = in json
}

class GroupingMessagesDyn extends ClassDyn with GroupingMessagesDynInit
