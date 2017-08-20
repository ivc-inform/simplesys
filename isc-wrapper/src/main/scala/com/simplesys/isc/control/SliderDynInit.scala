package com.simplesys.isc.control

import com.simplesys.isc.foundation.{CanvasDynInit, CanvasDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn.{ImageStyle, imgStStretch}

trait SliderDynInit extends CanvasDynInit {
  protected val animateThumbInit: Bool = false
  protected val animateThumbTime: Number = 250
  override protected val canFocus: Bool = true
  protected val flipValues: Bool = false
  protected val hThumbStyle: CSSStyleName = ""
  protected val hTrackStyle: CSSStyleName = ""
  protected val labelHeight: Number = 20
  protected val labelSpacing: Number = 5
  protected val labelWidth: Number = 50
  protected val length: Number = 200
  protected val maxValue: Number = 100
  protected val maxValueLabel: String = ""
  protected val minValue: Number = 1
  protected val minValueLabel: String = ""
  protected val numValues: Number = null
  protected val roundPrecision: Number = 1
  protected val roundValues: Bool = true
  protected val showRange: Bool = true
  protected val showTitle: Bool = true
  protected val showValue: Bool = true
  protected val sliderTarget: CanvasDyn = null
  protected val stepPercent: Number = 5
  protected val thumbSrc: String = "thumb.gif"
  protected val thumbThickWidth: Number = 23
  protected val thumbThinWidth: Number = 17
  protected val title: String = "Set Value"
  protected val trackCapSize: Number = 6
  protected val trackImageType: ImageStyle = imgStStretch
  protected val trackSrc: String = "track.gif"
  protected val trackWidth: Number = 7
  protected val value: Number = 1
  protected val vertical: Bool = true
  protected val vThumbStyle: CSSStyleName = ""
  protected val vTrackStyle: CSSStyleName = ""
}