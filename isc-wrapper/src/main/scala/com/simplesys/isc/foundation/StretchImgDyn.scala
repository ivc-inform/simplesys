package com.simplesys.isc.foundation

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object StretchImgDyn {
  implicit def StretchImgtoJsonObject(in: StretchImgDyn): JsonObject = in json
}

class StretchImgDyn extends StatefulCanvasDyn with StretchImgDynInit {

  private[this] var _capSize: Number = capSize
  def CapSize = _capSize
  def CapSize_=(value: Number) {
    if (_capSize == value) return
    json("capSize") = value
    _capSize = value
  }

  private[this] var _gripImgSuffix: String = gripImgSuffix
  def GripImgSuffix = _gripImgSuffix
  def GripImgSuffix_=(value: String) {
    if (_gripImgSuffix == value) return
    json("gripImgSuffix") = value
    _gripImgSuffix = value
  }

  private[this] var _hSrc: SCImgURL = hSrc
  def HSrc = _hSrc
  def HSrc_=(value: SCImgURL) {
    if (_hSrc == value) return
    json("hSrc") = value
    _hSrc = value
  }

  private[this] var _imageType: ImageStyle = imageType
  def ImageType = _imageType
  def ImageType_=(value: ImageStyle) {
    if (_imageType == value) return
    json("imageType") = value
    _imageType = value
  }


  private[this] var _itemBaseStyle: CSSStyleName = itemBaseStyle
  def ItemBaseStyle = _itemBaseStyle
  def ItemBaseStyle_=(value: CSSStyleName) {
    if (_itemBaseStyle == value) return
    json("itemBaseStyle") = value
    _itemBaseStyle = value
  }

  private[this] var _items: JsonList = items
  def Items = _items
  def Items_=(value: JsonList) {
    if (_items == value) return
    json("items") = value
    _items = value
  }

  private[this] var _showDownGrip: Bool = showDownGrip
  def ShowDownGrip = _showDownGrip
  def ShowDownGrip_=(value: Bool) {
    if (_showDownGrip == value) return
    json("showDownGrip") = value
    _showDownGrip = value
  }

  private[this] var _showGrip: Bool = showGrip
  def ShowGrip = _showGrip
  def ShowGrip_=(value: Bool) {
    if (_showGrip == value) return
    json("showGrip") = value
    _showGrip = value
  }

  private[this] var _showRollOverGrip: Bool = showRollOverGrip
  def ShowRollOverGrip = _showRollOverGrip
  def ShowRollOverGrip_=(value: Bool) {
    if (_showRollOverGrip == value) return
    json("showRollOverGrip") = value
    _showRollOverGrip = value
  }

  private[this] var _showTitle: Bool = showTitle
  def ShowTitle = _showTitle
  def ShowTitle_=(value: Bool) {
    if (_showTitle == value) return
    json("showTitle") = value
    _showTitle = value
  }

  private[this] var _src: SCImgURL = src
  def Src = _src
  def Src_=(value: SCImgURL) {
    if (_src == value) return
    json("src") = value
    _src = value
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

