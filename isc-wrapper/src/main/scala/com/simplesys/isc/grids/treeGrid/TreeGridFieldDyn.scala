package com.simplesys.isc.grids.treeGrid

import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject
import com.simplesys.isc.grids.listGrid.ListGridFieldDyn

object TreeGridFieldDyn {

  implicit def TreeGridFieldtoJsonObject(in: TreeGridFieldDyn): JsonObject = in json
}

class TreeGridFieldDyn extends ListGridFieldDyn with TreeGridFieldDynInit {
  private[this] var _treeField: Bool = treeField
  def TreeField = _treeField
  def TreeField_=(value: Bool) {
    if (_treeField == value) return
    json("treeField") = value
    _treeField = value
  }
}
