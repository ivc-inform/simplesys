package com.simplesys.isc.grids.tileGrid

import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.{StatefulCanvasDynInit, StatefulCanvasDyn}
import com.simplesys.isc.grids.TileGridDyn


object SimpleTileDyn {

  implicit def SimpleTiletoJsonObject(in: SimpleTileDyn): JsonObject = in json
}

class SimpleTileDyn extends StatefulCanvasDyn with StatefulCanvasDynInit with SimpleTileDynInit {
  private[this] var _creator: TileGridDyn = creator
  def Creator = _creator
  def Creator_=(value: TileGridDyn) {
    if (_creator == value) return
    json("creator") = value
    _creator = value
  }
}
