package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._

object DateRangeDyn {
  implicit def DateRangetoJsonObject(in: DateRangeDyn): JsonObject = in json
}

class DateRangeDyn extends ClassDyn with DateRangeDynInit {

  def End = json.getJsonElement("end").getOrElse(end)
  def End_=(value: JsonElement) {
    if (End == value) return
    json("end") = value
  }

  def Start = json.getJsonElement("start").getOrElse(start)
  def Start_=(value: JsonElement) {
    if (Start == value) return
    json("start") = value
  }
}
