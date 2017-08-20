package com.simplesys.isc.system.typesDyn

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object EventWindow {

  implicit def EventWindowtoJsonObject(in: EventWindow): JsonObject = in json
}

class EventWindow extends ClassDyn with EventWindowInit