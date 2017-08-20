package com.simplesys.isc.control

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StretchImgDyn
import com.simplesys.isc.system.typesDyn.AlignmentDyn

object StretchImgButtonDyn {
  implicit def StretchImgButtontoJsonObject(in: StretchImgButtonDyn): JsonObject = in json
}

class StretchImgButtonDyn(override val useSelfName: Boolean = false) extends StretchImgDyn with StretchImgButtonDynInit {
  override val selfName = "StretchImgButton"

  private[this] var _iconAlign: AlignmentDyn = iconAlign
  def IconAlign = _iconAlign
  def IconAlign_=(value: AlignmentDyn) {
    if (_iconAlign == value) return
    json("iconAlign") = value
    _iconAlign = value
  }

  private[this] var _labelBreadthPad: Number = labelBreadthPad
  def LabelBreadthPad = _labelBreadthPad
  def LabelBreadthPad_=(value: Number) {
    if (_labelBreadthPad == value) return
    json("labelBreadthPad") = value
    _labelBreadthPad = value
  }

  private[this] var _labelHPad: Number = labelHPad
  def LabelHPad = _labelHPad
  def LabelHPad_=(value: Number) {
    if (_labelHPad == value) return
    json("labelHPad") = value
    _labelHPad = value
  }

  private[this] var _labelLengthPad: Number = labelLengthPad
  def LabelLengthPad = _labelLengthPad
  def LabelLengthPad_=(value: Number) {
    if (_labelLengthPad == value) return
    json("labelLengthPad") = value
    _labelLengthPad = value
  }

  private[this] var _labelSkinImgDir: URL = labelSkinImgDir
  def LabelSkinImgDir = _labelSkinImgDir
  def LabelSkinImgDir_=(value: URL) {
    if (_labelSkinImgDir == value) return
    json("labelSkinImgDir") = value
    _labelSkinImgDir = value
  }

  private[this] var _labelVPad: Number = labelVPad
  def LabelVPad = _labelVPad
  def LabelVPad_=(value: Number) {
    if (_labelVPad == value) return
    json("labelVPad") = value
    _labelVPad = value
  }

  private[this] var _titleStyle: CSSStyleName = titleStyle
  def TitleStyle = _titleStyle
  def TitleStyle_=(value: CSSStyleName) {
    if (_titleStyle == value) return
    json("titleStyle") = value
    _titleStyle = value
  }

  private[this] var _wrap: Bool = wrap
  def Wrap = _wrap
  def Wrap_=(value: Bool) {
    if (_wrap == value) return
    json("wrap") = value
    _wrap = value
  }

  private[this] var _action: FunctionExpression = action
  def Action = _action
  def Action_=(value: FunctionExpression) {
    if (_action == value) return
    json("action") = value
    _action = value
  }

  private[this] var _iconClick: FunctionExpression = iconClick
  def IconClick = _iconClick
  def IconClick_=(value: FunctionExpression) {
    if (_iconClick == value) return
    json("iconClick") = value
    _iconClick = value
  }

  private[this] var _hiliteAccessKey: Bool = hiliteAccessKey
  def HiliteAccessKey = _hiliteAccessKey
  def HiliteAccessKey_=(value: Bool) {
    if (_hiliteAccessKey == value) return
    json("hiliteAccessKey") = value
    _hiliteAccessKey = value
  }

}

