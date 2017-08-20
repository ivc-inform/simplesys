package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.CanvasDynInit
import com.simplesys.json.JsonList

trait TileLayoutDynInit extends CanvasDynInit {
  protected val animateTileChange: Bool = true
  protected val autoWrapLines: Bool = true
  protected val dragDataAction: DragDataAction = drgDtActMove
  protected val dragLine: AutoChild = null
  protected val expandMargins: Bool = true
  protected val layoutMargin: Number = 5
  protected val layoutPolicy: TileLayoutPolicy = tlplcFit
  protected val orientation: Orientation = orntHorizontal
  override protected val overflow: Overflow = ovAuto
  protected val paddingAsLayoutMargin: Bool = true
  protected val tileHeight: Number = null
  protected val tileHMargin: Number = null
  protected val tileMargin: Number = null
  protected val tiles: JsonList = JsonList()
  protected val tileSize: Number = 50
  protected val tilesPerLine: Number = null
  protected val tileVMargin: Number = null
  protected val tileWidth: Number = null
}