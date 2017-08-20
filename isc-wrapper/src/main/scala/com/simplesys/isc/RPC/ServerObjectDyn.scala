package com.simplesys.isc.dataBinging.RPC

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.{Bool, XPathExpression}

object ServerObjectDyn {


  implicit def ServerObject1toJsonObject(in: ServerObjectDyn): JsonObject = in json
}

class ServerObjectDyn extends ClassDyn with ServerObjectDynInit {
  override val selfName = "ServerObject"

  private[this] var _attributeName: String = attributeName
  def AttributeName = _attributeName
  def AttributeName_=(value: String) {
    if (_attributeName == value) return
    json("attributeName") = value
    _attributeName = value
  }

  private[this] var _attributeScope: AttributeScope = attributeScope
  def AttributeScope = _attributeScope
  def AttributeScope_=(value: AttributeScope) {
    if (_attributeScope == value) return
    json("attributeScope") = value
    _attributeScope = value
  }

  private[this] var _bean: String = bean
  def Bean = _bean
  def Bean_=(value: String) {
    if (_bean == value) return
    json("bean") = value
    _bean = value
  }

  private[this] var _className: String = className
  def ClassName = _className
  def ClassName_=(value: String) {
    if (_className == value) return
    json("className") = value
    _className = value
  }

  private[this] var _crudOnly: Bool = crudOnly
  def CrudOnly = _crudOnly
  def CrudOnly_=(value: Bool) {
    if (_crudOnly == value) return
    json("crudOnly") = value
    _crudOnly = value
  }

  private[this] var _dropExtraFields: Bool = dropExtraFields
  def DropExtraFields = _dropExtraFields
  def DropExtraFields_=(value: Bool) {
    if (_dropExtraFields == value) return
    json("dropExtraFields") = value
    _dropExtraFields = value
  }

  private[this] var _lookupStyle: LookupStyle = lookupStyle
  def LookupStyle = _lookupStyle
  def LookupStyle_=(value: LookupStyle) {
    if (_lookupStyle == value) return
    json("lookupStyle") = value
    _lookupStyle = value
  }

  private[this] var _methodName: String = methodName
  def MethodName = _methodName
  def MethodName_=(value: String) {
    if (_methodName == value) return
    json("methodName") = value
    _methodName = value
  }

  private[this] var _targetXPath: XPathExpression = targetXPath
  def TargetXPath = _targetXPath
  def TargetXPath_=(value: XPathExpression) {
    if (_targetXPath == value) return
    json("targetXPath") = value
    _targetXPath = value
  }

  private[this] var _visibleMethods: JsonList = visibleMethods
  def VisibleMethods = _visibleMethods
  def VisibleMethods_=(value: JsonList) {
    if (_visibleMethods == value) return
    json("visibleMethods") = value
    _visibleMethods = value
  }
}

