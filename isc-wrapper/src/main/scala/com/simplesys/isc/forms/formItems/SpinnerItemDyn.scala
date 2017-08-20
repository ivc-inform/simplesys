package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._

object SpinnerItemDyn {
  implicit def SpinnerItemtoJsonObject(in: SpinnerItemDyn): JsonObject = in json
}

class SpinnerItemDyn extends TextItemDyn with SpinnerItemDynInit {

  override val selfName = "SpinnerItem"

  private[this] var _max: Number = max
  def Max = _max
  def Max_=(value: Number) {
    if (_max == value) return
    json("max") = value
    _max = value
  }

  private[this] var _min: Number = min
  def Min = _min
  def Min_=(value: Number) {
    if (_min == value) return
    json("min") = value
    _min = value
  }

  private[this] var _step: Number = step
  def Step = _step
  def Step_=(value: Number) {
    if (_step == value) return
    json("step") = value
    _step = value
  }
}
