package com.simplesys.isc.system.typesDyn

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc.Bool

object KeyIdentifier {
  implicit def KeyIdentifier1toJsonObject(in: KeyIdentifier): JsonObject = in json
}

class KeyIdentifier extends ClassDyn with KeyIdentifierInit {
  private[this] var _keyName: String = keyName
  def KeyName = _keyName
  def KeyName_=(value: String) {
    if (_keyName == value) return
    json("keyName") = value
    _keyName = value
  }

  private[this] var _ctrlKey: Bool = ctrlKey
  def CtrlKey = _ctrlKey
  def CtrlKey_=(value: Bool) {
    if (_ctrlKey == value) return
    json("ctrlKey") = value
    _ctrlKey = value
  }

  private[this] var _shiftKey: Bool = shiftKey
  def ShiftKey = _shiftKey
  def ShiftKey_=(value: Bool) {
    if (_shiftKey == value) return
    json("shiftKey") = value
    _shiftKey = value
  }

  private[this] var _altKey: Bool = altKey
  def AltKey = _altKey
  def AltKey_=(value: Bool) {
    if (_altKey == value) return
    json("altKey") = value
    _altKey = value
  }
}