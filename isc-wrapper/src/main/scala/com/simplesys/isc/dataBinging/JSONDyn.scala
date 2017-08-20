package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonElement, JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object JSONDyn {

  implicit def JSONDyn2JsonObject(in: JSONDyn): JsonObject = in json
  def apply() = new JSONDyn
}

class JSONDyn extends ClassDyn {
  override val useSelfName = true
  override val fabriqueClass = true
  override val selfName = "JSON"

  def decode(jsonString: String) {
    commandEnqueue(this, s"decode(${jsonString})")
  }

  def encode(obj: JsonElement, settings: JSONEncoderDyn = JSONEncoderDyn()) {
    commandEnqueue(this, s"encode(${obj},${settings.toString()})")
  }
}