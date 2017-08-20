package com.simplesys.components.Dyn.DataBinding

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.LayoutDyn

object DataViewSSDyn extends DataViewSSDynInit {
  implicit def DataViewSSDyn2JsonObject(in: DataViewSSDyn): JsonObject = in json
}

class DataViewSSDyn(override val useSelfName: Boolean = false) extends LayoutDyn with DataViewSSDynInit {
  override val selfName = "DataViewSS"
}