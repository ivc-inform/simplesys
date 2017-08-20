package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.dataBinging.dataSource.RecordDyn
import com.simplesys.isc.foundation.CanvasDyn

object TileRecordDyn {
  implicit def TileRecordtoJsonObject(in: TileRecordDyn): JsonObject = in json
}

class TileRecordDyn extends RecordDyn with TileRecordDynInit {
  private[this] var _tileConstructor: String = tileConstructor
  def TileConstructor = _tileConstructor
  def TileConstructor_=(value: String) {
    if (_tileConstructor == value) return
    json("tileConstructor") = value
    _tileConstructor = value
  }

  private[this] var _tileProperties: CanvasDyn = tileProperties
  def TileProperties = _tileProperties
  def TileProperties_=(value: CanvasDyn) {
    if (_tileProperties == value) return
    json("tileProperties") = value
    _tileProperties = value
  }
}
