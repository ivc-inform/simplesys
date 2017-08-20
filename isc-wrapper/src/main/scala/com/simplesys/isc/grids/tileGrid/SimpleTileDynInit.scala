package com.simplesys.isc.grids.tileGrid

import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.TileGridDyn
import com.simplesys.isc.foundation.StatefulCanvasDynInit

trait SimpleTileDynInit extends StatefulCanvasDynInit {
  override protected val baseStyle: CSSStyleName = "simpleTile"
  protected val creator: TileGridDyn = null
}