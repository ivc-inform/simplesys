package com.simplesys.isc.layout.toolStrip

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.ImgDyn

object ToolStripSeparatorDyn {

  implicit def ToolStripSeparator2JsonObject(in: ToolStripSeparatorDyn): JsonObject = in json
}

class ToolStripSeparatorDyn(override val useSelfName: Boolean = false) extends ImgDyn with ToolStripSeparatorDynInit {
  override val selfName = "ToolStripSeparator"

  private[this] var _hSrc: SCImgURL = hSrc
  def HSrc = _hSrc
  def HSrc_=(value: SCImgURL) {
    if (_hSrc == value) return
    json("hSrc") = value
    _hSrc = value
  }

  private[this] var _vSrc: SCImgURL = vSrc
  def VSrc = _vSrc
  def VSrc_=(value: SCImgURL) {
    if (_vSrc == value) return
    json("vSrc") = value
    _vSrc = value
  }
}