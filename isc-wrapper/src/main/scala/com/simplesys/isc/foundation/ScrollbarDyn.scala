package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object ScrollbarDyn {

  implicit def ScrollbartoJsonObject(in: ScrollbarDyn): JsonObject = in json
}

class ScrollbarDyn(override val useSelfName: Boolean = false) extends StretchImgDyn with ScrollbarDynInit {
  override val selfName = "Scrollbar"

  private[this] var _allowThumbDownState: Bool = allowThumbDownState
  def AllowThumbDownState = _allowThumbDownState
  def AllowThumbDownState_=(value: Bool) {
    if (_allowThumbDownState == value) return
    json("allowThumbDownState") = value
    _allowThumbDownState = value
  }

  private[this] var _allowThumbOverState: Bool = allowThumbOverState
  def AllowThumbOverState = _allowThumbOverState
  def AllowThumbOverState_=(value: Bool) {
    if (_allowThumbOverState == value) return
    json("allowThumbOverState") = value
    _allowThumbOverState = value
  }

  private[this] var _autoEnable: Bool = autoEnable
  def AutoEnable = _autoEnable
  def AutoEnable_=(value: Bool) {
    if (_autoEnable == value) return
    json("autoEnable") = value
    _autoEnable = value
  }

  private[this] var _btnSize: Number = btnSize
  def BtnSize = _btnSize
  def BtnSize_=(value: Number) {
    if (_btnSize == value) return
    json("btnSize") = value
    _btnSize = value
  }

  private[this] var _cornerSize: Number = cornerSize
  def CornerSize = _cornerSize
  def CornerSize_=(value: Number) {
    if (_cornerSize == value) return
    json("cornerSize") = value
    _cornerSize = value
  }

  private[this] var _cornerSrc: SCImgURL = cornerSrc
  def CornerSrc = _cornerSrc
  def CornerSrc_=(value: SCImgURL) {
    if (_cornerSrc == value) return
    json("cornerSrc") = value
    _cornerSrc = value
  }

  private[this] var _endThumbOverlap: Number = endThumbOverlap
  def EndThumbOverlap = _endThumbOverlap
  def EndThumbOverlap_=(value: Number) {
    if (_endThumbOverlap == value) return
    json("endThumbOverlap") = value
    _endThumbOverlap = value
  }

  private[this] var _scrollTarget: CanvasDyn = scrollTarget
  def ScrollTarget = _scrollTarget
  def ScrollTarget_=(value: CanvasDyn) {
    if (_scrollTarget == value) return
    json("scrollTarget") = value
    _scrollTarget = value
  }

  private[this] var _showCorner: Bool = showCorner
  def ShowCorner = _showCorner
  def ShowCorner_=(value: Bool) {
    if (_showCorner == value) return
    json("showCorner") = value
    _showCorner = value
  }

  private[this] var _showTrackEnds: Bool = showTrackEnds
  def ShowTrackEnds = _showTrackEnds
  def ShowTrackEnds_=(value: Bool) {
    if (_showTrackEnds == value) return
    json("showTrackEnds") = value
    _showTrackEnds = value
  }

  private[this] var _startThumbOverlap: Number = startThumbOverlap
  def StartThumbOverlap = _startThumbOverlap
  def StartThumbOverlap_=(value: Number) {
    if (_startThumbOverlap == value) return
    json("startThumbOverlap") = value
    _startThumbOverlap = value
  }

  private[this] var _thumbInset: Number = thumbInset
  def ThumbInset = _thumbInset
  def ThumbInset_=(value: Number) {
    if (_thumbInset == value) return
    json("thumbInset") = value
    _thumbInset = value
  }

  private[this] var _thumbMinSize: Number = thumbMinSize
  def ThumbMinSize = _thumbMinSize
  def ThumbMinSize_=(value: Number) {
    if (_thumbMinSize == value) return
    json("thumbMinSize") = value
    _thumbMinSize = value
  }

  private[this] var _thumbOverlap: Number = thumbOverlap
  def ThumbOverlap = _thumbOverlap
  def ThumbOverlap_=(value: Number) {
    if (_thumbOverlap == value) return
    json("thumbOverlap") = value
    _thumbOverlap = value
  }

  private[this] var _trackEndHeight: Number = trackEndHeight
  def TrackEndHeight = _trackEndHeight
  def TrackEndHeight_=(value: Number) {
    if (_trackEndHeight == value) return
    json("trackEndHeight") = value
    _trackEndHeight = value
  }

  private[this] var _trackEndWidth: Number = trackEndWidth
  def TrackEndWidth = _trackEndWidth
  def TrackEndWidth_=(value: Number) {
    if (_trackEndWidth == value) return
    json("trackEndWidth") = value
    _trackEndWidth = value
  }
}