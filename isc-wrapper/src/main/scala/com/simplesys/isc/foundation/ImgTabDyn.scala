package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.control.StretchImgButtonDyn

object ImgTabDyn {

  implicit def ImgTab2JsonObject(in: ImgTabDyn): JsonObject = in json
}

class ImgTabDyn(override val useSelfName: Boolean = false) extends StretchImgButtonDyn with ImgTabDynInit {
  override val selfName = "ImgTab"

  private[this] var _srs: SCImgURL = srs
  def Srs = _srs
  def Srs_=(value: SCImgURL) {
    if (_srs == value) return
    json("srs") = value
    _srs = value
  }
}