package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.dataBinging.DataBoundComponentDyn
import com.simplesys.isc.system.ArrayDyn

object TileGridDyn {

  implicit def TileGridtoJsonObject(in: TileGridDyn): JsonObject = in json
}

class TileGridDyn(override val useSelfName: Boolean = false) extends TileLayoutDyn with DataBoundComponentDyn with TileGridDynInit {
  override val selfName = "TileGrid"

  private[this] var _animateTileChange: Bool = animateTileChange
  override def AnimateTileChange = _animateTileChange
  override def AnimateTileChange_=(value: Bool) {
    if (_animateTileChange == value) return
    json("animateTileChange") = value
    _animateTileChange = value
  }

  private[this] var _autoFetchData: Bool = autoFetchData
  def AutoFetchData = _autoFetchData
  def AutoFetchData_=(value: Bool) {
    if (_autoFetchData == value) return
    json("autoFetchData") = value
    _autoFetchData = value
  }

  private[this] var _autoFetchTextMatchStyle: TextMatchStyle = autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle = _autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle_=(value: TextMatchStyle) {
    if (_autoFetchTextMatchStyle == value) return
    json("autoFetchTextMatchStyle") = value
    _autoFetchTextMatchStyle = value
  }

  private[this] var _canAcceptDroppedRecords: Bool = canAcceptDroppedRecords
  def CanAcceptDroppedRecords = _canAcceptDroppedRecords
  def CanAcceptDroppedRecords_=(value: Bool) {
    if (_canAcceptDroppedRecords == value) return
    json("canAcceptDroppedRecords") = value
    _canAcceptDroppedRecords = value
  }

  private[this] var _canDragTilesOut: Bool = canDragTilesOut
  def CanDragTilesOut = _canDragTilesOut
  def CanDragTilesOut_=(value: Bool) {
    if (_canDragTilesOut == value) return
    json("canDragTilesOut") = value
    _canDragTilesOut = value
  }

  private[this] var _canReorderTiles: Bool = canReorderTiles
  def CanReorderTiles = _canReorderTiles
  def CanReorderTiles_=(value: Bool) {
    if (_canReorderTiles == value) return
    json("canReorderTiles") = value
    _canReorderTiles = value
  }

  private[this] var _data: ArrayDyn[TileRecordDyn] = data
  def Data = _data
  def Data_=(value: ArrayDyn[TileRecordDyn]) {
    if (_data == value) return
    json("data") = value
    _data = value
  }

  private[this] var _detailViewer: AutoChild = detailViewer
  def DetailViewer = _detailViewer
  def DetailViewer_=(value: AutoChild) {
    if (_detailViewer == value) return
    json("detailViewer") = value
    _detailViewer = value
  }

  private[this] var _detailViewerProperties: DetailViewerDyn = detailViewerProperties
  def DetailViewerProperties = _detailViewerProperties
  def DetailViewerProperties_=(value: DetailViewerDyn) {
    if (_detailViewerProperties == value) return
    json("detailViewerProperties") = value
    _detailViewerProperties = value
  }

  private[this] var _dragDataAction: DragDataAction = dragDataAction
  override def DragDataAction = _dragDataAction
  override def DragDataAction_=(value: DragDataAction) {
    if (_dragDataAction == value) return
    json("dragDataAction") = value
    _dragDataAction = value
  }

  private[this] var _initialCriteria: CriteriaDyn = initialCriteria
  def InitialCriteria = _initialCriteria
  def InitialCriteria_=(value: CriteriaDyn) {
    if (_initialCriteria == value) return
    json("initialCriteria") = value
    _initialCriteria = value
  }

  private[this] var _printTilesPerLine: Number = printTilesPerLine
  def PrintTilesPerLine = _printTilesPerLine
  def PrintTilesPerLine_=(value: Number) {
    if (_printTilesPerLine == value) return
    json("printTilesPerLine") = value
    _printTilesPerLine = value
  }

  private[this] var _selectionType: SelectionStyle = selectionType
  def SelectionType = _selectionType
  def SelectionType_=(value: SelectionStyle) {
    if (_selectionType == value) return
    json("selectionType") = value
    _selectionType = value
  }

  private[this] var _showAllRecords: Bool = showAllRecords
  def ShowAllRecords = _showAllRecords
  def ShowAllRecords_=(value: Bool) {
    if (_showAllRecords == value) return
    json("showAllRecords") = value
    _showAllRecords = value
  }

  private[this] var _tileGrid: AutoChild = tileGrid
  def TileGrid = _tileGrid
  def TileGrid_=(value: AutoChild) {
    if (_tileGrid == value) return
    json("tileGrid") = value
    _tileGrid = value
  }

  private[this] var _tileConstructor: SCClassName = tileConstructor
  def TileConstructor = _tileConstructor
  def TileConstructor_=(value: SCClassName) {
    if (_tileConstructor == value) return
    json("tileConstructor") = value
    _tileConstructor = value
  }

  private[this] var _tileDragAppearance: DragAppearance = tileDragAppearance
  def TileDragAppearance = _tileDragAppearance
  def TileDragAppearance_=(value: DragAppearance) {
    ColumnTreeDyn
    if (_tileDragAppearance == value) return
    json("tileDragAppearance") = value
    _tileDragAppearance = value
  }

  private[this] var _tileProperties: CanvasDyn = tileProperties
  def TileProperties = _tileProperties
  def TileProperties_=(value: CanvasDyn) {
    if (_tileProperties == value) return
    json("tileProperties") = value
    _tileProperties = value
  }

  private[this] var _tileValueAlign: AlignmentDyn = tileValueAlign
  def TileValueAlign = _tileValueAlign
  def TileValueAlign_=(value: AlignmentDyn) {
    if (_tileValueAlign == value) return
    json("tileValueAlign") = value
    _tileValueAlign = value
  }

  private[this] var _tileValueStyle: SCClassName = tileValueStyle
  def TileValueStyle = _tileValueStyle
  def TileValueStyle_=(value: SCClassName) {
    if (_tileValueStyle == value) return
    json("tileValueStyle") = value
    _tileValueStyle = value
  }

  private[this] var _wrapValues: Bool = wrapValues
  def WrapValues = _wrapValues
  def WrapValues_=(value: Bool) {
    if (_wrapValues == value) return
    json("wrapValues") = value
    _wrapValues = value
  }
}

