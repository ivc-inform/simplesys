package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn

object DSRequestModifierDyn {
  implicit def DSRequestModifiertoJsonObject(in: DSRequestModifierDyn): JsonObject = in json
}

class DSRequestModifierDyn extends ClassDyn with DSRequestModifierDynInit {
  private[this] var _fieldName: String = fieldName
  def FieldName = _fieldName
  def FieldName_=(value: String) {
    if (_fieldName == value) return
    json("fieldName") = value
    _fieldName = value
  }

  private[this] var _value: String = value
  def Value = _value
  def Value_=(value: String) {
    if (_value == value) return
    json("value") = value
    _value = value
  }
}