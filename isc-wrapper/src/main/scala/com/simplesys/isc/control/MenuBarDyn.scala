package com.simplesys.isc.control

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.ToolbarDyn
import com.simplesys.isc.system.ArrayDyn

object MenuBarDyn {
  implicit def MenuBar2JsonObject(in: MenuBarDyn): JsonObject = in json
}

class MenuBarDyn(override val useSelfName: Boolean = false) extends ToolbarDyn with MenuBarDynInit {
  override val selfName = "MenuBar"

  private[this] var _menus: ArrayDyn[MenuDyn] = menus
  def Menus = _menus
  def Menus_=(value: ArrayDyn[MenuDyn]) {
    if (_menus == value) return
    json("menus") = value
    _menus = value
  }
}