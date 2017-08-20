package com.simplesys.isc.layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.{CanvasDyn, ImgDyn}

object ImgSplitbarDyn {

  implicit def ImgSplitbar2JsonObject(in: ImgSplitbarDyn): JsonObject = in json
}

class ImgSplitbarDyn(override val useSelfName: Boolean = false) extends ImgDyn with ImgSplitbarDynInit {
  override val selfName = "ImgSplitbar"

  private[this] var _canCollapse: Bool = canCollapse
  def CanCollapse = _canCollapse
  def CanCollapse_=(value: Bool) {
    if (_canCollapse == value) return
    json("canCollapse") = value
    _canCollapse = value
  }

  private[this] var _hSrc: SCImgURL = hSrc
  def HSrc = _hSrc
  def HSrc_=(value: SCImgURL) {
    if (_hSrc == value) return
    json("hSrc") = value
    _hSrc = value
  }

  private[this] var _target: CanvasDyn = target
  def Target = _target
  def Target_=(value: CanvasDyn) {
    if (_target == value) return
    json("target") = value
    _target = value
  }

  private[this] var _vertical: Bool = vertical
  def Vertical = _vertical
  def Vertical_=(value: Bool) {
    if (_vertical == value) return
    json("vertical") = value
    _vertical = value
  }

  private[this] var _vSrc: SCImgURL = vSrc
  def VSrc = _vSrc
  def VSrc_=(value: SCImgURL) {
    if (_vSrc == value) return
    json("vSrc") = value
    _vSrc = value
  }
}