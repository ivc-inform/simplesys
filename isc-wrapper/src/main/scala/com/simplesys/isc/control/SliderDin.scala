package com.simplesys.isc.control

import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn.ImageStyle

object SliderDin {
  implicit def SlidertoJsonObject(in: SliderDin): JsonObject = in json
}

class SliderDin(override val useSelfName: Boolean = false) extends CanvasDyn with SliderDynInit {

  override val selfName = "Slider"

  private[this] var _animateThumbInit: Bool = animateThumbInit
  def AnimateThumbInit = _animateThumbInit
  def AnimateThumbInit_=(value: Bool) {
    if (_animateThumbInit == value) return
    json("animateThumbInit") = value
    _animateThumbInit = value
  }

  private[this] var _animateThumbTime: Number = animateThumbTime
  def AnimateThumbTime = _animateThumbTime
  def AnimateThumbTime_=(value: Number) {
    if (_animateThumbTime == value) return
    json("animateThumbTime") = value
    _animateThumbTime = value
  }

  private[this] var _flipValues: Bool = flipValues
  def FlipValues = _flipValues
  def FlipValues_=(value: Bool) {
    if (_flipValues == value) return
    json("flipValues") = value
    _flipValues = value
  }

  private[this] var _hThumbStyle: CSSStyleName = hThumbStyle
  def HThumbStyle = _hThumbStyle
  def HThumbStyle_=(value: CSSStyleName) {
    if (_hThumbStyle == value) return
    json("hThumbStyle") = value
    _hThumbStyle = value
  }

  private[this] var _hTrackStyle: CSSStyleName = hTrackStyle
  def HTrackStyle = _hTrackStyle
  def HTrackStyle_=(value: CSSStyleName) {
    if (_hTrackStyle == value) return
    json("hTrackStyle") = value
    _hTrackStyle = value
  }

  private[this] var _labelHeight: Number = labelHeight
  def LabelHeight = _labelHeight
  def LabelHeight_=(value: Number) {
    if (_labelHeight == value) return
    json("labelHeight") = value
    _labelHeight = value
  }

  private[this] var _labelSpacing: Number = labelSpacing
  def LabelSpacing = _labelSpacing
  def LabelSpacing_=(value: Number) {
    if (_labelSpacing == value) return
    json("labelSpacing") = value
    _labelSpacing = value
  }

  private[this] var _labelWidth: Number = labelWidth
  def LabelWidth = _labelWidth
  def LabelWidth_=(value: Number) {
    if (_labelWidth == value) return
    json("labelWidth") = value
    _labelWidth = value
  }

  private[this] var _length: Number = length
  def Length = _length
  def Length_=(value: Number) {
    if (_length == value) return
    json("length") = value
    _length = value
  }

  private[this] var _maxValue: Number = maxValue
  def MaxValue = _maxValue
  def MaxValue_=(value: Number) {
    if (_maxValue == value) return
    json("maxValue") = value
    _maxValue = value
  }

  private[this] var _maxValueLabel: String = maxValueLabel
  def MaxValueLabel = _maxValueLabel
  def MaxValueLabel_=(value: String) {
    if (_maxValueLabel == value) return
    json("maxValueLabel") = value
    _maxValueLabel = value
  }

  private[this] var _minValue: Number = minValue
  def MinValue = _minValue
  def MinValue_=(value: Number) {
    if (_minValue == value) return
    json("minValue") = value
    _minValue = value
  }

  private[this] var _minValueLabel: String = minValueLabel
  def MinValueLabel = _minValueLabel
  def MinValueLabel_=(value: String) {
    if (_minValueLabel == value) return
    json("minValueLabel") = value
    _minValueLabel = value
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

  private[this] var _showRange: Bool = showRange
  def ShowRange = _showRange
  def ShowRange_=(value: Bool) {
    if (_showRange == value) return
    json("showRange") = value
    _showRange = value
  }

  private[this] var _showTitle: Bool = showTitle
  def ShowTitle = _showTitle
  def ShowTitle_=(value: Bool) {
    if (_showTitle == value) return
    json("showTitle") = value
    _showTitle = value
  }

  private[this] var _showValue: Bool = showValue
  def ShowValue = _showValue
  def ShowValue_=(value: Bool) {
    if (_showValue == value) return
    json("showValue") = value
    _showValue = value
  }

  private[this] var _sliderTarget: CanvasDyn = sliderTarget
  def SliderTarget = _sliderTarget
  def SliderTarget_=(value: CanvasDyn) {
    if (_sliderTarget == value) return
    json("sliderTarget") = value
    _sliderTarget = value
  }

  private[this] var _stepPercent: Number = stepPercent
  def StepPercent = _stepPercent
  def StepPercent_=(value: Number) {
    if (_stepPercent == value) return
    json("stepPercent") = value
    _stepPercent = value
  }

  private[this] var _thumbSrc: String = thumbSrc
  def ThumbSrc = _thumbSrc
  def ThumbSrc_=(value: String) {
    if (_thumbSrc == value) return
    json("thumbSrc") = value
    _thumbSrc = value
  }

  private[this] var _thumbThickWidth: Number = thumbThickWidth
  def ThumbThickWidth = _thumbThickWidth
  def ThumbThickWidth_=(value: Number) {
    if (_thumbThickWidth == value) return
    json("thumbThickWidth") = value
    _thumbThickWidth = value
  }

  private[this] var _thumbThinWidth: Number = thumbThinWidth
  def ThumbThinWidth = _thumbThinWidth
  def ThumbThinWidth_=(value: Number) {
    if (_thumbThinWidth == value) return
    json("thumbThinWidth") = value
    _thumbThinWidth = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _trackCapSize: Number = trackCapSize
  def TrackCapSize = _trackCapSize
  def TrackCapSize_=(value: Number) {
    if (_trackCapSize == value) return
    json("trackCapSize") = value
    _trackCapSize = value
  }

  private[this] var _trackImageType: ImageStyle = trackImageType
  def TrackImageType = _trackImageType
  def TrackImageType_=(value: ImageStyle) {
    if (_trackImageType == value) return
    json("trackImageType") = value
    _trackImageType = value
  }

  private[this] var _trackSrc: String = trackSrc
  def TrackSrc = _trackSrc
  def TrackSrc_=(value: String) {
    if (_trackSrc == value) return
    json("trackSrc") = value
    _trackSrc = value
  }

  private[this] var _trackWidth: Number = trackWidth
  def TrackWidth = _trackWidth
  def TrackWidth_=(value: Number) {
    if (_trackWidth == value) return
    json("trackWidth") = value
    _trackWidth = value
  }

  private[this] var _value: Number = value
  def Value = _value
  def Value_=(value: Number) {
    if (_value == value) return
    json("value") = value
    _value = value
  }

  private[this] var _vertical: Bool = vertical
  def Vertical = _vertical
  def Vertical_=(value: Bool) {
    if (_vertical == value) return
    json("vertical") = value
    _vertical = value
  }

  private[this] var _vThumbStyle: CSSStyleName = vThumbStyle
  def VThumbStyle = _vThumbStyle
  def VThumbStyle_=(value: CSSStyleName) {
    if (_vThumbStyle == value) return
    json("vThumbStyle") = value
    _vThumbStyle = value
  }

  private[this] var _vTrackStyle: CSSStyleName = vTrackStyle
  def VTrackStyle = _vTrackStyle
  def VTrackStyle_=(value: CSSStyleName) {
    if (_vTrackStyle == value) return
    json("vTrackStyle") = value
    _vTrackStyle = value
  }
}