package com.simplesys.isc.foundation

import com.simplesys.isc.system.misc._

trait GridRendererDynInit extends CanvasDynInit {
  protected val alternateRowFrequency: Number = 1
  protected val alternateRowStyles: Bool = false
  protected val autoFit: Bool = false
  protected val baseStyle: CSSStyleName = "cell"
  protected val canSelectOnRightMouse: Bool = true
  protected val cellHeight: Number = 20
  protected val cellPadding: Number = 2
  protected val drawAheadRatio: Number = 1.3
  protected val drawAllMaxCells: Number = 250
  protected val emptyCellValue: String = " "
  protected val emptyMessage: String = ""
  protected val emptyMessageStyle: CSSStyleName = ""
  protected val emptyMessageTableStyle: CSSStyleName = ""
  protected val fastCellUpdates: Bool = true
  protected val fixedColumnWidths: Bool = true
  protected val fixedRowHeights: Bool = true
  protected val instantScrollTrackRedraw: Bool = true
  protected val offlineMessage: String = ""
  protected val offlineMessageStyle: CSSStyleName = ""
  protected val quickDrawAheadRatio: Number = 1.0
  protected val recordCustomStyleProperty: SCClassName = ""
  protected val scrollRedrawDelay: Number = 75
  protected val showAllColumns: Bool = false
  protected val showAllRows: Bool = false
  protected val showEmptyMessage: Bool = true
  override protected val showHover: Bool = null
  protected val showOfflineMessage: Bool = true
  protected val showSelectedStyle: Bool = true
  protected val snapInsideBorder: Bool = false
  protected val snapToCells: Bool = false
  protected val totalRows: Number = 0
  protected val virtualScrolling: Bool = null
  protected val wrapCells: Bool = false
}