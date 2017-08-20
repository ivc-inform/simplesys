package com.simplesys.isc.control

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.ImgDyn
import com.simplesys.isc.system.typesDyn.AlignmentDyn

object ImgButtonDyn {
  implicit def ImgButton2JsonObject(in: ImgButtonDyn): JsonObject = in json
}

class ImgButtonDyn(override val useSelfName: Boolean = false) extends ImgDyn with ImgButtonDynInit {
  override val selfName = "ImgButton"

  private[this] var _action: UnquotedString = action
  def Action = _action
  def Action_=(value: UnquotedString) {
    if (_action == value) return
    json("action") = value
    _action = value
  }

  private[this] var _hiliteAccessKey: Bool = hiliteAccessKey
  def HiliteAccessKey = _hiliteAccessKey
  def HiliteAccessKey_=(value: Bool) {
    if (_hiliteAccessKey == value) return
    json("hiliteAccessKey") = value
    _hiliteAccessKey = value
  }

  private[this] var _iconAlign: AlignmentDyn = iconAlign
  def IconAlign = _iconAlign
  def IconAlign_=(value: AlignmentDyn) {
    if (_iconAlign == value) return
    json("iconAlign") = value
    _iconAlign = value
  }

  private[this] var _labelHPad: Number = labelHPad
  def LabelHPad = _labelHPad
  def LabelHPad_=(value: Number) {
    if (_labelHPad == value) return
    json("labelHPad") = value
    _labelHPad = value
  }

  private[this] var _labelVPad: Number = labelVPad
  def LabelVPad = _labelVPad
  def LabelVPad_=(value: Number) {
    if (_labelVPad == value) return
    json("labelVPad") = value
    _labelVPad = value
  }
}