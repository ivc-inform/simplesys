package com.simplesys.isc.dataBinging

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object OfflineDyn {
  implicit def Offline2JsonObject(in: OfflineDyn): JsonObject = in json
}

class OfflineDyn(override val useSelfName: Boolean = false) extends ClassDyn with OfflineDynInit {
  override val selfName = "Offline"
}