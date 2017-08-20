package com.simplesys.isc.grids.listGrid

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object HeaderSpanDyn {

  implicit def HeaderSpantoJsonObject(in: HeaderSpanDyn): JsonObject = in json
}

class HeaderSpanDyn extends ClassDyn with HeaderSpanDynInit {
  private[this] var _align: AlignmentDyn = align
  def Align = _align
  def Align_=(value: AlignmentDyn) {
    if (_align == value) return
    json("align") = value
    _align = value
  }

  private[this] var _fields: JsonList = fields
  def Fields = _fields
  def Fields_=(value: JsonList) {
    if (_fields == value) return
    json("fields") = value
    _fields = value
  }

  private[this] var _height: Number = height
  def Height = _height
  def Height_=(value: Number) {
    if (_height == value) return
    json("height") = value
    _height = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _valign: AlignmentDyn = valign
  def Valign = _valign
  def Valign_=(value: AlignmentDyn) {
    if (_valign == value) return
    json("valign") = value
    _valign = value
  }
}
