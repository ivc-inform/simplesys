package com.simplesys.isc.forms

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.DataBoundComponentDyn
import com.simplesys.isc.system.misc.Bool

object ValuesManagerDyn {
  implicit def ValuesManagertoJsonObject(in: ValuesManagerDyn): JsonObject = in json
}

class ValuesManagerDyn extends ClassDyn with DataBoundComponentDyn with ValuesManagerDynInit {
  override val selfName = "ValuesManager"

  private[this] var _autoSynchronize: Bool = autoSynchronize
  def AutoSynchronize = _autoSynchronize
  def AutoSynchronize_=(value: Bool) {
    if (_autoSynchronize == value) return
    json("autoSynchronize") = value
    _autoSynchronize = value
  }

  private[this] var _disableValidation: Bool = disableValidation
  def DisableValidation = _disableValidation
  def DisableValidation_=(value: Bool) {
    if (_disableValidation == value) return
    json("disableValidation") = value
    _disableValidation = value
  }

  private[this] var _members: JsonList = members
  def Members = _members
  def Members_=(value: JsonList) {
    if (_members == value) return
    json("members") = value
    _members = value
  }

  private[this] var _saveOperationType: DSOperationType = saveOperationType
  def SaveOperationType = _saveOperationType
  def SaveOperationType_=(value: DSOperationType) {
    if (_saveOperationType == value) return
    json("saveOperationType") = value
    _saveOperationType = value
  }

  private[this] var _suppressValidationErrorCallback: Bool = suppressValidationErrorCallback
  def SuppressValidationErrorCallback = _suppressValidationErrorCallback
  def SuppressValidationErrorCallback_=(value: Bool) {
    if (_suppressValidationErrorCallback == value) return
    json("suppressValidationErrorCallback") = value
    _suppressValidationErrorCallback = value
  }

}

