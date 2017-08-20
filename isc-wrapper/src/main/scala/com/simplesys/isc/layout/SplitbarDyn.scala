package com.simplesys.isc.layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.{CanvasDyn, StretchImgDyn}

object SplitbarDyn {

  implicit def Splitbar2JsonObject(in: SplitbarDyn): JsonObject = in json
}

class SplitbarDyn(override val useSelfName: Boolean = false) extends StretchImgDyn with SplitbarDynInit {
  override val selfName = "Splitbar"

  private[this] var _canCollapse: Bool = canCollapse
  def CanCollapse = _canCollapse
  def CanCollapse_=(value: Bool) {
    if (_canCollapse == value) return
    json("canCollapse") = value
    _canCollapse = value
  }

  private[this] var _hResizeCursor: Cursor = hResizeCursor
  def HResizeCursor = _hResizeCursor
  def HResizeCursor_=(value: Cursor) {
    if (_hResizeCursor == value) return
    json("hResizeCursor") = value
    _hResizeCursor = value
  }

  private[this] var _showClosedGrip: Bool = showClosedGrip
  def ShowClosedGrip = _showClosedGrip
  def ShowClosedGrip_=(value: Bool) {
    if (_showClosedGrip == value) return
    json("showClosedGrip") = value
    _showClosedGrip = value
  }

  private[this] var _target: CanvasDyn = target
  def Target = _target
  def Target_=(value: CanvasDyn) {
    if (_target == value) return
    json("target") = value
    _target = value
  }

  private[this] var _vResizeCursor: Cursor = vResizeCursor
  def VResizeCursor = _vResizeCursor
  def VResizeCursor_=(value: Cursor) {
    if (_vResizeCursor == value) return
    json("vResizeCursor") = value
    _vResizeCursor = value
  }
}