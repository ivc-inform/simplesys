package com.simplesys.isc.forms.validator

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn

object ValidatorDefinitionDyn {
  implicit def ValidatorDefinition2JsonObject(in: ValidatorDefinitionDyn): JsonObject = in json
}

class ValidatorDefinitionDyn(override val useSelfName: Boolean = false) extends ClassDyn with ValidatorDefinitionDynInit {
  override val selfName = "ValidatorDefinition"

  private[this] var _action: FunctionExpression = action
  def Action = _action
  def Action_=(value: FunctionExpression) {
    if (_action == value) return
    json("action") = value
    _action = value
  }

  private[this] var _condition: FunctionExpression = condition
  def Condition = _condition
  def Condition_=(value: FunctionExpression) {
    if (_condition == value) return
    json("condition") = value
    _condition = value
  }

  private[this] var _defaultErrorMessage: String = defaultErrorMessage
  def DefaultErrorMessage = _defaultErrorMessage
  def DefaultErrorMessage_=(value: String) {
    if (_defaultErrorMessage == value) return
    json("defaultErrorMessage") = value
    _defaultErrorMessage = value
  }

  private[this] var _requiresServer: Bool = requiresServer
  def RequiresServer = _requiresServer
  def RequiresServer_=(value: Bool) {
    if (_requiresServer == value) return
    json("requiresServer") = value
    _requiresServer = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _type: String = __type
  def Type = _type
  def Type_=(value: String) {
    if (_type == value) return
    json("type") = value
    _type = value
  }
}