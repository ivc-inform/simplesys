package com.simplesys.isc.dataBinging.formulaBuilder

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn

object MathFunctionDyn {
  implicit def MathFunction2JsonObject(in: MathFunctionDyn): JsonObject = in json
}

class MathFunctionDyn(override val useSelfName: Boolean = false) extends ClassDyn with MathFunctionDynInit {
  override val selfName = "MathFunction"

  private[this] var _defaultSortPosition: Number = defaultSortPosition
  def DefaultSortPosition = _defaultSortPosition
  def DefaultSortPosition_=(value: Number) {
    if (_defaultSortPosition == value) return
    json("defaultSortPosition") = value
    _defaultSortPosition = value
  }

  private[this] var _description: String = description
  def Description = _description
  def Description_=(value: String) {
    if (_description == value) return
    json("description") = value
    _description = value
  }

  private[this] var _jsFunction: FunctionExpression = jsFunction
  def JsFunction = _jsFunction
  def JsFunction_=(value: FunctionExpression) {
    if (_jsFunction == value) return
    json("jsFunction") = value
    _jsFunction = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }
}