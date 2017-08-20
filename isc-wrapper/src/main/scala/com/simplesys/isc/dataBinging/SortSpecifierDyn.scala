package com.simplesys.isc.dataBinging

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc.FunctionExpression
import com.simplesys.isc.system.typesDyn.SortDirection

object SortSpecifierDyn {
  implicit def SortSpecifiertoJsonObject(in: SortSpecifierDyn): JsonObject = in json
}

class SortSpecifierDyn extends ClassDyn with SortSpecifierDynInit {
  override val selfName = "SortSpecifier"

  private[this] var _context: JsonObject = context
  def Context = _context
  def Context_=(value: JsonObject) {
    json("context") = value
    _context = value
  }

  private[this] var _direction: SortDirection = direction
  def Direction = _direction
  def Direction_=(value: SortDirection) {
    if (_direction == value) return
    json("direction") = value.toString
    _direction = value
  }

  private[this] var _normalizer: FunctionExpression = normalizer
  def Normalizer = _normalizer
  def Normalizer_=(value: FunctionExpression) {
    if (_normalizer == value) return
    json("normalizer") = value
    _normalizer = value
  }

  private[this] var _property: String = property
  def Property = _property
  def Property_=(value: String) {
    if (_property == value) return
    json("property") = value
    _property = value
  }

}

