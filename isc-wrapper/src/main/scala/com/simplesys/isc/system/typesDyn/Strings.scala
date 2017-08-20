package com.simplesys.isc.system.typesDyn

import collection.mutable.ArrayBuffer
import com.simplesys.log.Logging
import com.simplesys.json._

object Strings {
  def apply(strings: JsonString*) = new Strings(ArrayBuffer.empty[JsonElement], strings: _*)
  implicit def Strings2JsonList(in: Strings): JsonList = new JsonList()
}

class Strings(override protected val proxy: ArrayBuffer[JsonElement], strings: JsonString*) extends JsonList with Logging {
  def this() = this(ArrayBuffer.empty[JsonElement])

  logger trace "//////////////////////////// Strings ///////////////////////////////////////////"
  strings foreach (+= _)
  logger trace "//////////////////////////// End of Strings ///////////////////////////////////////////"


  def +=(string: JsonString) = {
    proxy += string
    logger trace(s"string += : ${string}")
  }
}
