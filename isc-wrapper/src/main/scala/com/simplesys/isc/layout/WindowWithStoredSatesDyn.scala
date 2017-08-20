package com.simplesys.isc.layout

import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object WindowWithStoredSatesDyn extends WindowWithStoredSatesDynInit {

  implicit def WindowWithStoredSatesDyn2JsonObject(in: WindowWithStoredSatesDyn): JsonObject = in json
}

class WindowWithStoredSatesDyn(override val useSelfName: Boolean = false) extends WindowDyn with WindowWithStoredSatesDynInit {
  override val selfName = "WindowWithStoredSates"
}