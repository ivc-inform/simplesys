package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object ImgDyn {

  implicit def ImgtoJsonObject(in: ImgDyn): JsonObject = in json
}

class ImgDyn(override val useSelfName: Boolean = false) extends StatefulCanvasDyn with ImgDynInit {
  override val selfName = "Img"

  private[this] var _activeAreaHTML: String = activeAreaHTML
  def ActiveAreaHTML = _activeAreaHTML
  def ActiveAreaHTML_=(value: String) {
    if (_activeAreaHTML == value) return
    json("activeAreaHTML") = value
    _activeAreaHTML = value
  }

  private[this] var _altText: String = altText
  def AltText = _altText
  def AltText_=(value: String) {
    if (_altText == value) return
    json("altText") = value
    _altText = value
  }

  private[this] var _imageHeight: Number = imageHeight
  def ImageHeight = _imageHeight
  def ImageHeight_=(value: Number) {
    if (_imageHeight == value) return
    json("imageHeight") = value
    _imageHeight = value
  }

  private[this] var _imageType: ImageStyle = imageType
  def ImageType = _imageType
  def ImageType_=(value: ImageStyle) {
    if (_imageType == value) return
    json("imageType") = value
    _imageType = value
  }

  private[this] var _imageWidth: Number = imageWidth
  def ImageWidth = _imageWidth
  def ImageWidth_=(value: Number) {
    if (_imageWidth == value) return
    json("imageWidth") = value
    _imageWidth = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _showTitle: Bool = showTitle
  def ShowTitle = _showTitle
  def ShowTitle_=(value: Bool) {
    if (_showTitle == value) return
    json("showTitle") = value
    _showTitle = value
  }

  private[this] var _size: Number = size
  def Size = _size
  def Size_=(value: Number) {
    if (_size == value) return
    json("size") = value
    _size = value
  }

  private[this] var _src: SCImgURL = src
  def Src = _src
  def Src_=(value: SCImgURL) {
    if (_src == value) return
    json("src") = value
    _src = value
  }

  private[this] var _usePNGFix: Bool = usePNGFix
  def UsePNGFix = _usePNGFix
  def UsePNGFix_=(value: Bool) {
    if (_usePNGFix == value) return
    json("usePNGFix") = value
    _usePNGFix = value
  }

}