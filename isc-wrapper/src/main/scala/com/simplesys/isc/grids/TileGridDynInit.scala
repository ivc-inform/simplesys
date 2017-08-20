package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.DataBoundComponentDynInit
import com.simplesys.isc.system.ArrayDyn

trait TileGridDynInit extends TileLayoutDynInit with DataBoundComponentDynInit {
  override protected val animateTileChange: Bool = true
  protected val autoFetchData: Bool = false
  protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleSubstring
  protected val canAcceptDroppedRecords: Bool = false
  protected val canDragTilesOut: Bool = false
  protected val canReorderTiles: Bool = false
  protected val data: ArrayDyn[TileRecordDyn] = null
  protected val detailViewer: AutoChild = null
  protected val detailViewerProperties: DetailViewerDyn = null
  override protected val dragDataAction: DragDataAction = drgDtActMove
  protected val initialCriteria: CriteriaDyn = null
  protected val printTilesPerLine: Number = null
  protected val selectionType: SelectionStyle = slStlMultiple
  protected val showAllRecords: Bool = false
  override protected val styleName: CSSStyleName = "tileGrid"
  protected val tileGrid: AutoChild = null
  protected val tileConstructor: SCClassName = "SimpleTile"
  protected val tileDragAppearance: DragAppearance = drAprncTracker
  protected val tileProperties: CanvasDyn = null
  protected val tileValueAlign: AlignmentDyn = AlCenter
  protected val tileValueStyle: SCClassName = "tileValue"
  protected val wrapValues: Bool = true
}