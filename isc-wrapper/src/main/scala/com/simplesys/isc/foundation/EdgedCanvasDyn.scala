package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._

object EdgedCanvasDyn {

  implicit def EdgedCanvas2JsonObject(in: EdgedCanvasDyn): JsonObject = in json
}

class EdgedCanvasDyn(override val useSelfName: Boolean = false) extends CanvasDyn with EdgedCanvasDynInit {
  override val selfName = "EdgedCanvas"

  private[this] var _addEdgeStyleSuffix: Bool = addEdgeStyleSuffix
  def AddEdgeStyleSuffix = _addEdgeStyleSuffix
  def AddEdgeStyleSuffix_=(value: Bool) {
    if (_addEdgeStyleSuffix == value) return
    json("addEdgeStyleSuffix") = value
    _addEdgeStyleSuffix = value
  }

  private[this] var _centerBackgroundColor: Color = centerBackgroundColor
  def CenterBackgroundColor = _centerBackgroundColor
  def CenterBackgroundColor_=(value: Color) {
    if (_centerBackgroundColor == value) return
    json("centerBackgroundColor") = value
    _centerBackgroundColor = value
  }

  private[this] var _edgeBottom: Number = edgeBottom
  def EdgeBottom = _edgeBottom
  def EdgeBottom_=(value: Number) {
    if (_edgeBottom == value) return
    json("edgeBottom") = value
    _edgeBottom = value
  }

  private[this] var _edgeColor: Color = edgeColor
  def EdgeColor = _edgeColor
  def EdgeColor_=(value: Color) {
    if (_edgeColor == value) return
    json("edgeColor") = value
    _edgeColor = value
  }

  private[this] var _edgeLeft: Number = edgeLeft
  def EdgeLeft = _edgeLeft
  def EdgeLeft_=(value: Number) {
    if (_edgeLeft == value) return
    json("edgeLeft") = value
    _edgeLeft = value
  }

  private[this] var _edgeOffsetBottom: Number = edgeOffsetBottom
  def EdgeOffsetBottom = _edgeOffsetBottom
  def EdgeOffsetBottom_=(value: Number) {
    if (_edgeOffsetBottom == value) return
    json("edgeOffsetBottom") = value
    _edgeOffsetBottom = value
  }

  private[this] var _edgeOffsetLeft: Number = edgeOffsetLeft
  def EdgeOffsetLeft = _edgeOffsetLeft
  def EdgeOffsetLeft_=(value: Number) {
    if (_edgeOffsetLeft == value) return
    json("edgeOffsetLeft") = value
    _edgeOffsetLeft = value
  }

  private[this] var _edgeOffsetRight: Number = edgeOffsetRight
  def EdgeOffsetRight = _edgeOffsetRight
  def EdgeOffsetRight_=(value: Number) {
    if (_edgeOffsetRight == value) return
    json("edgeOffsetRight") = value
    _edgeOffsetRight = value
  }

  private[this] var _edgeOffsetTop: Number = edgeOffsetTop
  def EdgeOffsetTop = _edgeOffsetTop
  def EdgeOffsetTop_=(value: Number) {
    if (_edgeOffsetTop == value) return
    json("edgeOffsetTop") = value
    _edgeOffsetTop = value
  }

  private[this] var _edgeRight: Number = edgeRight
  def EdgeRight = _edgeRight
  def EdgeRight_=(value: Number) {
    if (_edgeRight == value) return
    json("edgeRight") = value
    _edgeRight = value
  }

  private[this] var _edgeStyleName: CSSStyleName = edgeStyleName
  def EdgeStyleName = _edgeStyleName
  def EdgeStyleName_=(value: CSSStyleName) {
    if (_edgeStyleName == value) return
    json("edgeStyleName") = value
    _edgeStyleName = value
  }

  private[this] var _edgeTop: Number = edgeTop
  def EdgeTop = _edgeTop
  def EdgeTop_=(value: Number) {
    if (_edgeTop == value) return
    json("edgeTop") = value
    _edgeTop = value
  }

  private[this] var _showCenter: Bool = showCenter
  def ShowCenter = _showCenter
  def ShowCenter_=(value: Bool) {
    if (_showCenter == value) return
    json("showCenter") = value
    _showCenter = value
  }
}