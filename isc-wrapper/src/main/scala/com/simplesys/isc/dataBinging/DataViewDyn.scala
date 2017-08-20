package com.simplesys.isc.dataBinging

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.layout.VLayoutDyn
import com.simplesys.isc.system.misc.FunctionExpression

object DataViewDyn {
  implicit def DataViewtoJsonObject(in: DataViewDyn): JsonObject = in json
}

class DataViewDyn extends VLayoutDyn with DataViewDynInit {
  private[this] var _dataViewLoaded: FunctionExpression = dataViewLoaded
  def DataViewLoaded = _dataViewLoaded
  def DataViewLoaded_=(value: FunctionExpression) {
    if (_dataViewLoaded == value) return
    json("dataViewLoaded") = value
    _dataViewLoaded = value
  }
}