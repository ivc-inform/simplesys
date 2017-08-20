package com.simplesys.isc.dataBinging

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ClassDyn

object JSONEncoderDyn {
  implicit def JSONEncoder2JsonObject(in: JSONEncoderDyn): JsonObject = in json
  def apply() = new JSONEncoderDyn()
}

class JSONEncoderDyn(override val useSelfName: Boolean = false) extends ClassDyn with JSONEncoderDynInit {
  override val selfName = "JSONEncoder"

  private[this] var _circularReferenceMarker: String = circularReferenceMarker
  def CircularReferenceMarker = _circularReferenceMarker
  def CircularReferenceMarker_=(value: String) {
    if (_circularReferenceMarker == value) return
    json("circularReferenceMarker") = value
    _circularReferenceMarker = value
  }

  private[this] var _circularReferenceMode: JSONCircularReferenceMode = circularReferenceMode
  def CircularReferenceMode = _circularReferenceMode
  def CircularReferenceMode_=(value: JSONCircularReferenceMode) {
    if (_circularReferenceMode == value) return
    json("circularReferenceMode") = value
    _circularReferenceMode = value
  }

  private[this] var _dateFormat: JSONDateFormat = dateFormat
  def DateFormat = _dateFormat
  def DateFormat_=(value: JSONDateFormat) {
    if (_dateFormat == value) return
    json("dateFormat") = value
    _dateFormat = value
  }

  private[this] var _prettyPrint: Bool = prettyPrint
  def PrettyPrint = _prettyPrint
  def PrettyPrint_=(value: Bool) {
    if (_prettyPrint == value) return
    json("prettyPrint") = value
    _prettyPrint = value
  }

  private[this] var _serializeInstances: JSONInstanceSerializationMode = serializeInstances
  def SerializeInstances = _serializeInstances
  def SerializeInstances_=(value: JSONInstanceSerializationMode) {
    if (_serializeInstances == value) return
    json("serializeInstances") = value
    _serializeInstances = value
  }

  private[this] var _showDebugOutput: Bool = showDebugOutput
  def ShowDebugOutput = _showDebugOutput
  def ShowDebugOutput_=(value: Bool) {
    if (_showDebugOutput == value) return
    json("showDebugOutput") = value
    _showDebugOutput = value
  }

  private[this] var _skipInternalProperties: Bool = skipInternalProperties
  def SkipInternalProperties = _skipInternalProperties
  def SkipInternalProperties_=(value: Bool) {
    if (_skipInternalProperties == value) return
    json("skipInternalProperties") = value
    _skipInternalProperties = value
  }

  private[this] var _strictQuoting: Bool = strictQuoting
  def StrictQuoting = _strictQuoting
  def StrictQuoting_=(value: Bool) {
    if (_strictQuoting == value) return
    json("strictQuoting") = value
    _strictQuoting = value
  }
}