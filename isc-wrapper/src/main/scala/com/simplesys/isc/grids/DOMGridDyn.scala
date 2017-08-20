package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.LayoutDynInit

object DOMGridDyn {

  implicit def DOMGridtoJsonObject(in: DOMGridDyn): JsonObject = in json
}

class DOMGridDyn(override val useSelfName: Boolean = false) extends TreeGridDyn with LayoutDynInit with ListGridDynInit with TreeGridDynInit with DOMGridDynInit {
  override val selfName = "DOMGrid"

  private[this] var _rootElement: JsonObject = rootElement
  def RootElement = _rootElement
  def RootElement_=(value: JsonObject) {
    json("rootElement") = value
    _rootElement = value
  }
}
