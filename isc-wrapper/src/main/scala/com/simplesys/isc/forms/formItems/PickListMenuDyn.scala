package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.grids.ListGridRecordDyn

object PickListMenuDyn {
  implicit def PickListMenutoJsonObject(in: PickListMenuDyn): JsonObject = in json
}

class PickListMenuDyn extends ScrollingMenuDyn with PickListMenuDynInit {
  private[this] var _bodyStyleName: CSSStyleName = bodyStyleName
  def BodyStyleName = _bodyStyleName
  def BodyStyleName_=(value: CSSStyleName) {
    if (_bodyStyleName == value) return
    json("bodyStyleName") = value
    _bodyStyleName = value
  }

  private[this] var _dataProperties: ArrayDyn[ListGridRecordDyn] = dataProperties
  def DataProperties = _dataProperties
  def DataProperties_=(value: ArrayDyn[ListGridRecordDyn]) {
    if (_dataProperties == value) return
    json("dataProperties") = value
    _dataProperties = value
  }

  private[this] var _emptyMessage: String = emptyMessage
  def EmptyMessage = _emptyMessage
  def EmptyMessage_=(value: String) {
    if (_emptyMessage == value) return
    json("emptyMessage") = value
    _emptyMessage = value
  }

  private[this] var _normalCellHeight: Number = normalCellHeight
  def NormalCellHeight = _normalCellHeight
  def NormalCellHeight_=(value: Number) {
    if (_normalCellHeight == value) return
    json("normalCellHeight") = value
    _normalCellHeight = value
  }

  private[this] var _styleName: CSSStyleName = styleName
  def StyleName = _styleName
  def StyleName_=(value: CSSStyleName) {
    if (_styleName == value) return
    json("styleName") = value
    _styleName = value
  }
}

