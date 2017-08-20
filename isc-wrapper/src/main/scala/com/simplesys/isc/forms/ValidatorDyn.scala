package com.simplesys.isc.forms

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.dataBinging.dataSource.AdvancedCriteriaDyn
import com.simplesys.isc.system.misc.{Bool, Number}
import com.simplesys.isc.dataBinging.RPC.ServerObjectDyn
import com.simplesys.isc.system.typesDyn._

object ValidatorDyn {

  implicit def ValidatortoJsonObject(in: ValidatorDyn): JsonObject = in json
}

class ValidatorDyn extends ClassDyn with ValidotorDynInit {

  private[this] var _applyWhen: AdvancedCriteriaDyn = applyWhen
  def ApplyWhen = _applyWhen
  def ApplyWhen_=(value: AdvancedCriteriaDyn) {
    if (_applyWhen == value) return
    json("applyWhen") = value
    _applyWhen = value
  }

  private[this] var _clientOnly: Bool = clientOnly
  def ClientOnly = _clientOnly
  def ClientOnly_=(value: Bool) {
    if (_clientOnly == value) return
    json("clientOnly") = value
    _clientOnly = value
  }

  private[this] var _dependentFields: JsonList = dependentFields
  def DependentFields = _dependentFields
  def DependentFields_=(value: JsonList) {
    if (_dependentFields == value) return
    json("dependentFields") = value
    _dependentFields = value
  }

  private[this] var _errorMessage: String = errorMessage
  def ErrorMessage = _errorMessage
  def ErrorMessage_=(value: String) {
    if (_errorMessage == value) return
    json("errorMessage") = value
    _errorMessage = value
  }

  private[this] var _min: Number = min
  def Min = _min
  def Min_=(value: Number) {
    json("min") = value
    _min = value
  }

  private[this] var _precision: Number = precision
  def Precision = _precision
  def Precision_=(value: Number) {
    json("precision") = value
    _precision = value
  }

  private[this] var _resultingValue: JsonObject = resultingValue
  def ResultingValue = _resultingValue
  def ResultingValue_=(value: JsonObject) {
    json("resultingValue") = value
    _resultingValue = value
  }

  private[this] var _serverObject: ServerObjectDyn = serverObject
  def ServerObject = _serverObject
  def ServerObject_=(value: ServerObjectDyn) {
    if (_serverObject == value) return
    json("serverObject") = value
    _serverObject = value
  }

  private[this] var _serverOnly: Bool = serverOnly
  def ServerOnly = _serverOnly
  def ServerOnly_=(value: Bool) {
    if (_serverOnly == value) return
    json("serverOnly") = value
    _serverOnly = value
  }

  private[this] var _stopIfFalse: Bool = stopIfFalse
  def StopIfFalse = _stopIfFalse
  def StopIfFalse_=(value: Bool) {
    if (_stopIfFalse == value) return
    json("stopIfFalse") = value
    _stopIfFalse = value
  }

  private[this] var _stopOnError: Bool = stopOnError
  def StopOnError = _stopOnError
  def StopOnError_=(value: Bool) {
    if (_stopOnError == value) return
    json("stopOnError") = value
    _stopOnError = value
  }

  private[this] var _type: ValidatorType = __type
  def Type = _type
  def Type_=(value: ValidatorType) {
    if (_type == value) return
    json("type") = value
    _type = value
  }

  private[this] var _validateOnChange: Bool = validateOnChange
  def ValidateOnChange = _validateOnChange
  def ValidateOnChange_=(value: Bool) {
    if (_validateOnChange == value) return
    json("validateOnChange") = value
    _validateOnChange = value
  }
}

