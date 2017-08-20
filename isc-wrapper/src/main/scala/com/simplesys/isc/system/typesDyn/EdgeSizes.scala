package com.simplesys.isc.system.typesDyn

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object EdgeSizes {

  implicit def EdgeSizestoJsonObject(in: EdgeSizes): JsonObject = in json
}

class EdgeSizes extends ClassDyn with EdgeSizesInit