package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc.Bool

object FormItemEventInfoDyn {
  implicit def FormItemEventInfotoJsonObject(in: FormItemEventInfoDyn): JsonObject = in json
}

class FormItemEventInfoDyn extends ClassDyn with FormItemEventInfoDynInit {
  private[this] var _icon: String = ""
  def Icon = _icon
  def Icon_=(value: String) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }

  private[this] var _item: FormItemDyn = null
  def Item = _item
  def Item_=(value: FormItemDyn) {
    if (_item == value) return
    json("item") = value
    _item = value
  }

  private[this] var _overItem: Bool = false
  def OverItem = _overItem
  def OverItem_=(value: Bool) {
    if (_overItem == value) return
    json("overItem") = value
    _overItem = value
  }

  private[this] var _overTitle: Bool = false
  def OverTitle = _overTitle
  def OverTitle_=(value: Bool) {
    if (_overTitle == value) return
    json("overTitle") = value
    _overTitle = value
  }
}
