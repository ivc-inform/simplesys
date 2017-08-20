package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonElement, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.SliderDin

object SliderItemDyn {
  implicit def SliderItemtoJsonObject(in: SliderItemDyn): JsonObject = in json
}

class SliderItemDyn extends CanvasItemDyn with SliderItemDynInit {
  override val selfName = "SliderItem"

  private[this] var _changeOnDrag: Bool = changeOnDrag
  def ChangeOnDrag = _changeOnDrag
  def ChangeOnDrag_=(value: Bool) {
    if (_changeOnDrag == value) return
    json("changeOnDrag") = value
    _changeOnDrag = value
  }

  private[this] var _maxValue: Number = maxValue
  def MaxValue = _maxValue
  def MaxValue_=(value: Number) {
    if (_maxValue == value) return
    json("maxValue") = value
    _maxValue = value
  }

  private[this] var _minValue: Number = minValue
  def MinValue = _minValue
  def MinValue_=(value: Number) {
    if (_minValue == value) return
    json("minValue") = value
    _minValue = value
  }

  private[this] var _numValues: Number = numValues
  def NumValues = _numValues
  def NumValues_=(value: Number) {
    if (_numValues == value) return
    json("numValues") = value
    _numValues = value
  }

  private[this] var _roundPrecision: Number = roundPrecision
  def RoundPrecision = _roundPrecision
  def RoundPrecision_=(value: Number) {
    if (_roundPrecision == value) return
    json("roundPrecision") = value
    _roundPrecision = value
  }

  private[this] var _roundValues: Bool = roundValues
  def RoundValues = _roundValues
  def RoundValues_=(value: Bool) {
    if (_roundValues == value) return
    json("roundValues") = value
    _roundValues = value
  }

  private[this] var _vertical: Bool = vertical
  def Vertical = _vertical
  def Vertical_=(value: Bool) {
    if (_vertical == value) return
    json("vertical") = value
    _vertical = value
  }

  private[this] var _sliderProperties: SliderDin = sliderProperties
  def SliderProperties = _sliderProperties
  def SliderProperties_=(value: SliderDin) {
    if (_sliderProperties == value) return
    json("sliderProperties") = value
    _sliderProperties = value
  }
}

