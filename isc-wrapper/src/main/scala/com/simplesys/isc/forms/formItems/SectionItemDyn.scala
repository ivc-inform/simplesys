package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._

object SectionItemDyn {
  implicit def SectionItemtoJsonObject(in: SectionItemDyn): JsonObject = in json
}

class SectionItemDyn extends CanvasItemDyn with SectionItemDynInit {
  private[this] var _canCollapse: Bool = canCollapse
  def CanCollapse = _canCollapse
  def CanCollapse_=(value: Bool) {
    if (_canCollapse == value) return
    json("canCollapse") = value
    _canCollapse = value
  }

  private[this] var _canTabToHeader: Bool = canTabToHeader
  def CanTabToHeader = _canTabToHeader
  def CanTabToHeader_=(value: Bool) {
    if (_canTabToHeader == value) return
    json("canTabToHeader") = value
    _canTabToHeader = value
  }

  private[this] var _itemIds: JsonList = itemIds
  def ItemIds = _itemIds
  def ItemIds_=(value: JsonList) {
    if (_itemIds == value) return
    json("itemIds") = value
    _itemIds = value
  }

  private[this] var _sectionExpanded: Bool = sectionExpanded
  def SectionExpanded = _sectionExpanded
  def SectionExpanded_=(value: Bool) {
    if (_sectionExpanded == value) return
    json("sectionExpanded") = value
    _sectionExpanded = value
  }

  private[this] var _sectionHeaderClass: SCClassName = sectionHeaderClass
  def SectionHeaderClass = _sectionHeaderClass
  def SectionHeaderClass_=(value: SCClassName) {
    if (_sectionHeaderClass == value) return
    json("sectionHeaderClass") = value
    _sectionHeaderClass = value
  }

  private[this] var _sectionVisible: Bool = sectionVisible
  def SectionVisible = _sectionVisible
  def SectionVisible_=(value: Bool) {
    if (_sectionVisible == value) return
    json("sectionVisible") = value
    _sectionVisible = value
  }
}

