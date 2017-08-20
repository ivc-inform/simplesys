package com.simplesys.isc.layout.sectionStack

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.{CanvasDyn, LabelDyn}
import com.simplesys.isc.system.ArrayDyn

object SectionHeaderDyn {

  implicit def SectionHeader2JsonObject(in: SectionHeaderDyn): JsonObject = in json
}

class SectionHeaderDyn(override val useSelfName: Boolean = false) extends LabelDyn with SectionHeaderDynInit {
  override val selfName = "SectionHeader"

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