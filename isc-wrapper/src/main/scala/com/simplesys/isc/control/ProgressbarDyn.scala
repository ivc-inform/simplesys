package com.simplesys.isc.control

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StretchImgDyn

object ProgressbarDyn {
  implicit def Progressbar2JsonObject(in: ProgressbarDyn): JsonObject = in json
}

class ProgressbarDyn(override val useSelfName: Boolean = false) extends StretchImgDyn with ProgressbarDynInit {
  override val selfName = "Progressbar"

  private[this] var _breadth: Number = breadth
  def Breadth = _breadth
  def Breadth_=(value: Number) {
    if (_breadth == value) return
    json("breadth") = value
    _breadth = value
  }

  private[this] var _length: Number = length
  def Length = _length
  def Length_=(value: Number) {
    if (_length == value) return
    json("length") = value
    _length = value
  }

  private[this] var _percentChanged: FunctionExpression = percentChanged
  def PercentChanged = _percentChanged
  def PercentChanged_=(value: FunctionExpression) {
    if (_percentChanged == value) return
    json("percentChanged") = value
    _percentChanged = value
  }

  private[this] var _percentDone: Number = percentDone
  def PercentDone = _percentDone
  def PercentDone_=(value: Number) {
    if (_percentDone == value) return
    json("percentDone") = value
    _percentDone = value
  }
}