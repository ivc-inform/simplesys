package com.simplesys.isc.control

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object IconButtonDyn {
  implicit def IconButton1toJsonObject(in: IconButtonDyn): JsonObject = in json
}

class IconButtonDyn(override val useSelfName: Boolean = false) extends ButtonDyn with IconButtonDynInit {
  override val selfName = "IconButton"

  private[this] var _largeIcon: SCImgURL = largeIcon
  def LargeIcon = _largeIcon
  def LargeIcon_=(value: SCImgURL) {
    if (_largeIcon == value) return
    json("largeIcon") = value
    _largeIcon = value
  }

  private[this] var _largeIconSize: Number = largeIconSize
  def LargeIconSize = _largeIconSize
  def LargeIconSize_=(value: Number) {
    if (_largeIconSize == value) return
    json("largeIconSize") = value
    _largeIconSize = value
  }

  private[this] var _menuIconSrc: SCImgURL = menuIconSrc
  def MenuIconSrc = _menuIconSrc
  def MenuIconSrc_=(value: SCImgURL) {
    if (_menuIconSrc == value) return
    json("menuIconSrc") = value
    _menuIconSrc = value
  }

  private[this] var _orientation: IconButtonOrientation = orientation
  def Orientation = _orientation
  def Orientation_=(value: IconButtonOrientation) {
    if (_orientation == value) return
    json("orientation") = value
    _orientation = value
  }

  private[this] var _showMenuIcon: Bool = showMenuIcon
  def ShowMenuIcon = _showMenuIcon
  def ShowMenuIcon_=(value: Bool) {
    if (_showMenuIcon == value) return
    json("showMenuIcon") = value
    _showMenuIcon = value
  }

  private[this] var _showMenuIconOver: Bool = showMenuIconOver
  def ShowMenuIconOver = _showMenuIconOver
  def ShowMenuIconOver_=(value: Bool) {
    if (_showMenuIconOver == value) return
    json("showMenuIconOver") = value
    _showMenuIconOver = value
  }
}

