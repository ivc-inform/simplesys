package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.SliderDin
import com.simplesys.json._

trait SliderItemDynInit extends CanvasItemDynInit {
  protected val changeOnDrag: Bool = true
  override protected val defaultValue: JsonBigDecimal = JsonBigDecimal(1)
  protected val maxValue: Number = 100
  protected val minValue: Number = 1
  protected val numValues: Number = null
  protected val roundPrecision: Number = 1
  protected val roundValues: Bool = true
  protected val sliderProperties: SliderDin = null
  protected val vertical: Bool = false
}