package com.simplesys.isc.grids

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.CanvasDyn

object TileLayoutDyn {

  implicit def TileLayouttoJsonObject(in: TileLayoutDyn): JsonObject = in json
}

class TileLayoutDyn(override val useSelfName: Boolean = false) extends CanvasDyn with TileLayoutDynInit {
  override val selfName = "TileLayout"

  private[this] var _animateTileChange: Bool = animateTileChange
  def AnimateTileChange = _animateTileChange
  def AnimateTileChange_=(value: Bool) {
    if (_animateTileChange == value) return
    json("animateTileChange") = value
    _animateTileChange = value
  }

  private[this] var _autoWrapLines: Bool = autoWrapLines
  def AutoWrapLines = _autoWrapLines
  def AutoWrapLines_=(value: Bool) {
    if (_autoWrapLines == value) return
    json("autoWrapLines") = value
    _autoWrapLines = value
  }

  private[this] var _dragDataAction: DragDataAction = dragDataAction
  def DragDataAction = _dragDataAction
  def DragDataAction_=(value: DragDataAction) {
    if (_dragDataAction == value) return
    json("dragDataAction") = value
    _dragDataAction = value
  }

  private[this] var _dragLine: AutoChild = dragLine
  def DragLine = _dragLine
  def DragLine_=(value: AutoChild) {
    if (_dragLine == value) return
    json("dragLine") = value
    _dragLine = value
  }

  private[this] var _expandMargins: Bool = expandMargins
  def ExpandMargins = _expandMargins
  def ExpandMargins_=(value: Bool) {
    if (_expandMargins == value) return
    json("expandMargins") = value
    _expandMargins = value
  }

  private[this] var _layoutMargin: Number = layoutMargin
  def LayoutMargin = _layoutMargin
  def LayoutMargin_=(value: Number) {
    if (_layoutMargin == value) return
    json("layoutMargin") = value
    _layoutMargin = value
  }

  private[this] var _layoutPolicy: TileLayoutPolicy = layoutPolicy
  def LayoutPolicy = _layoutPolicy
  def LayoutPolicy_=(value: TileLayoutPolicy) {
    if (_layoutPolicy == value) return
    json("layoutPolicy") = value
    _layoutPolicy = value
  }

  private[this] var _orientation: Orientation = orientation
  def Orientation = _orientation
  def Orientation_=(value: Orientation) {
    if (_orientation == value) return
    json("orientation") = value
    _orientation = value
  }

  private[this] var _overflow: Overflow = overflow
  override def Overflow = _overflow
  override def Overflow_=(value: Overflow) {
    if (_overflow == value) return
    json("overflow") = value
    _overflow = value
  }

  private[this] var _paddingAsLayoutMargin: Bool = paddingAsLayoutMargin
  def PaddingAsLayoutMargin = _paddingAsLayoutMargin
  def PaddingAsLayoutMargin_=(value: Bool) {
    if (_paddingAsLayoutMargin == value) return
    json("paddingAsLayoutMargin") = value
    _paddingAsLayoutMargin = value
  }

  private[this] var _tileHeight: Number = tileHeight
  def TileHeight = _tileHeight
  def TileHeight_=(value: Number) {
    if (_tileHeight == value) return
    json("tileHeight") = value
    _tileHeight = value
  }

  private[this] var _tileHMargin: Number = tileHMargin
  def TileHMargin = _tileHMargin
  def TileHMargin_=(value: Number) {
    if (_tileHMargin == value) return
    json("tileHMargin") = value
    _tileHMargin = value
  }

  private[this] var _tileMargin: Number = tileMargin
  def TileMargin = _tileMargin
  def TileMargin_=(value: Number) {
    if (_tileMargin == value) return
    json("tileMargin") = value
    _tileMargin = value
  }

  private[this] var _tiles: JsonList = tiles
  def Tiles = _tiles
  def Tiles_=(value: JsonList) {
    if (_tiles == value) return
    json("tiles") = value
    _tiles = value
  }

  private[this] var _tileSize: Number = tileSize
  def TileSize = _tileSize
  def TileSize_=(value: Number) {
    if (_tileSize == value) return
    json("tileSize") = value
    _tileSize = value
  }

  private[this] var _tilesPerLine: Number = tilesPerLine
  def TilesPerLine = _tilesPerLine
  def TilesPerLine_=(value: Number) {
    if (_tilesPerLine == value) return
    json("tilesPerLine") = value
    _tilesPerLine = value
  }

  private[this] var _tileVMargin: Number = tileVMargin
  def TileVMargin = _tileVMargin
  def TileVMargin_=(value: Number) {
    if (_tileVMargin == value) return
    json("tileVMargin") = value
    _tileVMargin = value
  }

  private[this] var _tileWidth: Number = tileWidth
  def TileWidth = _tileWidth
  def TileWidth_=(value: Number) {
    if (_tileWidth == value) return
    json("tileWidth") = value
    _tileWidth = value
  }
}

