package com.simplesys.isc.layout.sectionStack

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HLayoutDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.foundation.CanvasDyn

object ImgSectionHeaderDyn {

  implicit def ImgSectionHeader2JsonObject(in: ImgSectionHeaderDyn): JsonObject = in json
}

class ImgSectionHeaderDyn(override val useSelfName: Boolean = false) extends HLayoutDyn with ImgSectionHeaderDynInit {
  override val selfName = "ImgSectionHeader"

  private[this] var _background: AutoChild = background
  def Background = _background
  def Background_=(value: AutoChild) {
    if (_background == value) return
    json("background") = value
    _background = value
  }

  private[this] var _controls: ArrayDyn[CanvasDyn] = controls
  def Controls = _controls
  def Controls_=(value: ArrayDyn[CanvasDyn]) {
    if (_controls == value) return
    json("controls") = value
    _controls = value
  }

  private[this] var _controlsLayout: AutoChild = controlsLayout
  def ControlsLayout = _controlsLayout
  def ControlsLayout_=(value: AutoChild) {
    if (_controlsLayout == value) return
    json("controlsLayout") = value
    _controlsLayout = value
  }
}