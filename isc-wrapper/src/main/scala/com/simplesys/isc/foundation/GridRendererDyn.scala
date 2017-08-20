package com.simplesys.isc.foundation

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._

object GridRendererDyn {

  implicit def GridRenderertoJsonObject(in: GridRendererDyn): JsonObject = in json
}

class GridRendererDyn(override val useSelfName: Boolean = false) extends CanvasDyn with GridRendererDynInit {

  override val selfName = "GridRenderer"

  private[this] var _alternateRowFrequency: Number = alternateRowFrequency
  def AlternateRowFrequency = _alternateRowFrequency
  def AlternateRowFrequency_=(value: Number) {
    if (_alternateRowFrequency == value) return
    json("alternateRowFrequency") = value
    _alternateRowFrequency = value
  }

  private[this] var _alternateRowStyles: Bool = alternateRowStyles
  def AlternateRowStyles = _alternateRowStyles
  def AlternateRowStyles_=(value: Bool) {
    if (_alternateRowStyles == value) return
    json("alternateRowStyles") = value
    _alternateRowStyles = value
  }

  private[this] var _autoFit: Bool = autoFit
  def AutoFit = _autoFit
  def AutoFit_=(value: Bool) {
    if (_autoFit == value) return
    json("autoFit") = value
    _autoFit = value
  }

  private[this] var _baseStyle: CSSStyleName = baseStyle
  def BaseStyle = _baseStyle
  def BaseStyle_=(value: CSSStyleName) {
    if (_baseStyle == value) return
    json("baseStyle") = value
    _baseStyle = value
  }

  private[this] var _canSelectOnRightMouse: Bool = canSelectOnRightMouse
  def CanSelectOnRightMouse = _canSelectOnRightMouse
  def CanSelectOnRightMouse_=(value: Bool) {
    if (_canSelectOnRightMouse == value) return
    json("canSelectOnRightMouse") = value
    _canSelectOnRightMouse = value
  }

  private[this] var _cellHeight: Number = cellHeight
  def CellHeight = _cellHeight
  def CellHeight_=(value: Number) {
    if (_cellHeight == value) return
    json("cellHeight") = value
    _cellHeight = value
  }

  private[this] var _cellPadding: Number = cellPadding
  def CellPadding = _cellPadding
  def CellPadding_=(value: Number) {
    if (_cellPadding == value) return
    json("cellPadding") = value
    _cellPadding = value
  }

  private[this] var _drawAheadRatio: Number = drawAheadRatio
  def DrawAheadRatio = _drawAheadRatio
  def DrawAheadRatio_=(value: Number) {
    if (_drawAheadRatio == value) return
    json("drawAheadRatio") = value
    _drawAheadRatio = value
  }

  private[this] var _drawAllMaxCells: Number = drawAllMaxCells
  def DrawAllMaxCells = _drawAllMaxCells
  def DrawAllMaxCells_=(value: Number) {
    if (_drawAllMaxCells == value) return
    json("drawAllMaxCells") = value
    _drawAllMaxCells = value
  }

  private[this] var _emptyCellValue: String = emptyCellValue
  def EmptyCellValue = _emptyCellValue
  def EmptyCellValue_=(value: String) {
    if (_emptyCellValue == value) return
    json("emptyCellValue") = value
    _emptyCellValue = value
  }

  private[this] var _emptyMessage: String = emptyMessage
  def EmptyMessage = _emptyMessage
  def EmptyMessage_=(value: String) {
    if (_emptyMessage == value) return
    json("emptyMessage") = value
    _emptyMessage = value
  }

  private[this] var _emptyMessageStyle: CSSStyleName = emptyMessageStyle
  def EmptyMessageStyle = _emptyMessageStyle
  def EmptyMessageStyle_=(value: CSSStyleName) {
    if (_emptyMessageStyle == value) return
    json("emptyMessageStyle") = value
    _emptyMessageStyle = value
  }

  private[this] var _emptyMessageTableStyle: CSSStyleName = emptyMessageTableStyle
  def EmptyMessageTableStyle = _emptyMessageTableStyle
  def EmptyMessageTableStyle_=(value: CSSStyleName) {
    if (_emptyMessageTableStyle == value) return
    json("emptyMessageTableStyle") = value
    _emptyMessageTableStyle = value
  }

  private[this] var _fastCellUpdates: Bool = fastCellUpdates
  def FastCellUpdates = _fastCellUpdates
  def FastCellUpdates_=(value: Bool) {
    if (_fastCellUpdates == value) return
    json("fastCellUpdates") = value
    _fastCellUpdates = value
  }

  private[this] var _fixedColumnWidths: Bool = fixedColumnWidths
  def FixedColumnWidths = _fixedColumnWidths
  def FixedColumnWidths_=(value: Bool) {
    if (_fixedColumnWidths == value) return
    json("fixedColumnWidths") = value
    _fixedColumnWidths = value
  }

  private[this] var _fixedRowHeights: Bool = fixedRowHeights
  def FixedRowHeights = _fixedRowHeights
  def FixedRowHeights_=(value: Bool) {
    if (_fixedRowHeights == value) return
    json("fixedRowHeights") = value
    _fixedRowHeights = value
  }

  private[this] var _instantScrollTrackRedraw: Bool = instantScrollTrackRedraw
  def InstantScrollTrackRedraw = _instantScrollTrackRedraw
  def InstantScrollTrackRedraw_=(value: Bool) {
    if (_instantScrollTrackRedraw == value) return
    json("instantScrollTrackRedraw") = value
    _instantScrollTrackRedraw = value
  }

  private[this] var _offlineMessage: String = offlineMessage
  def OfflineMessage = _offlineMessage
  def OfflineMessage_=(value: String) {
    if (_offlineMessage == value) return
    json("offlineMessage") = value
    _offlineMessage = value
  }

  private[this] var _offlineMessageStyle: CSSStyleName = offlineMessageStyle
  def OfflineMessageStyle = _offlineMessageStyle
  def OfflineMessageStyle_=(value: CSSStyleName) {
    if (_offlineMessageStyle == value) return
    json("offlineMessageStyle") = value
    _offlineMessageStyle = value
  }

  private[this] var _quickDrawAheadRatio: Number = quickDrawAheadRatio
  def QuickDrawAheadRatio = _quickDrawAheadRatio
  def QuickDrawAheadRatio_=(value: Number) {
    if (_quickDrawAheadRatio == value) return
    json("quickDrawAheadRatio") = value
    _quickDrawAheadRatio = value
  }

  private[this] var _recordCustomStyleProperty: SCClassName = recordCustomStyleProperty
  def RecordCustomStyleProperty = _recordCustomStyleProperty
  def RecordCustomStyleProperty_=(value: SCClassName) {
    if (_recordCustomStyleProperty == value) return
    json("recordCustomStyleProperty") = value
    _recordCustomStyleProperty = value
  }

  private[this] var _scrollRedrawDelay: Number = scrollRedrawDelay
  def ScrollRedrawDelay = _scrollRedrawDelay
  def ScrollRedrawDelay_=(value: Number) {
    if (_scrollRedrawDelay == value) return
    json("scrollRedrawDelay") = value
    _scrollRedrawDelay = value
  }

  private[this] var _showAllColumns: Bool = showAllColumns
  def ShowAllColumns = _showAllColumns
  def ShowAllColumns_=(value: Bool) {
    if (_showAllColumns == value) return
    json("showAllColumns") = value
    _showAllColumns = value
  }

  private[this] var _showAllRows: Bool = showAllRows
  def ShowAllRows = _showAllRows
  def ShowAllRows_=(value: Bool) {
    if (_showAllRows == value) return
    json("showAllRows") = value
    _showAllRows = value
  }

  private[this] var _showEmptyMessage: Bool = showEmptyMessage
  def ShowEmptyMessage = _showEmptyMessage
  def ShowEmptyMessage_=(value: Bool) {
    if (_showEmptyMessage == value) return
    json("showEmptyMessage") = value
    _showEmptyMessage = value
  }

  private[this] var _showOfflineMessage: Bool = showOfflineMessage
  def ShowOfflineMessage = _showOfflineMessage
  def ShowOfflineMessage_=(value: Bool) {
    if (_showOfflineMessage == value) return
    json("showOfflineMessage") = value
    _showOfflineMessage = value
  }

  private[this] var _showSelectedStyle: Bool = showSelectedStyle
  def ShowSelectedStyle = _showSelectedStyle
  def ShowSelectedStyle_=(value: Bool) {
    if (_showSelectedStyle == value) return
    json("showSelectedStyle") = value
    _showSelectedStyle = value
  }

  private[this] var _snapInsideBorder: Bool = snapInsideBorder
  def SnapInsideBorder = _snapInsideBorder
  def SnapInsideBorder_=(value: Bool) {
    if (_snapInsideBorder == value) return
    json("snapInsideBorder") = value
    _snapInsideBorder = value
  }

  private[this] var _snapToCells: Bool = snapToCells
  def SnapToCells = _snapToCells
  def SnapToCells_=(value: Bool) {
    if (_snapToCells == value) return
    json("snapToCells") = value
    _snapToCells = value
  }

  private[this] var _totalRows: Number = totalRows
  def TotalRows = _totalRows
  def TotalRows_=(value: Number) {
    if (_totalRows == value) return
    json("totalRows") = value
    _totalRows = value
  }

  private[this] var _virtualScrolling: Bool = virtualScrolling
  def VirtualScrolling = _virtualScrolling
  def VirtualScrolling_=(value: Bool) {
    if (_virtualScrolling == value) return
    json("virtualScrolling") = value
    _virtualScrolling = value
  }

  private[this] var _wrapCells: Bool = wrapCells
  def WrapCells = _wrapCells
  def WrapCells_=(value: Bool) {
    if (_wrapCells == value) return
    json("wrapCells") = value
    _wrapCells = value
  }
}