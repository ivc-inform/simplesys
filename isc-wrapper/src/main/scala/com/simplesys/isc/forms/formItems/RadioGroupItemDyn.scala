package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}
import radioGroupItem.RadioItemDyn

object RadioGroupItemDyn {
  implicit def RadioGroupItemtoJsonObject(in: RadioGroupItemDyn): JsonObject = in json
}

class RadioGroupItemDyn extends ContainerItemDyn with RadioGroupItemDynInit {

  private[this] var _disabledValues: JsonList = disabledValues
  def DisabledValues = _disabledValues
  def DisabledValues_=(value: JsonList) {
    if (_disabledValues == value) return
    json("disabledValues") = value
    _disabledValues = value
  }

  private[this] var _itemProperties: RadioItemDyn = itemProperties
  def ItemProperties = _itemProperties
  def ItemProperties_=(value: RadioItemDyn) {
    if (_itemProperties == value) return
    json("itemProperties") = value
    _itemProperties = value
  }
}

