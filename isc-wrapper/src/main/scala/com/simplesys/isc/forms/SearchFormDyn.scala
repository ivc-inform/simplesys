package com.simplesys.isc.forms

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._

object SearchFormDyn {

  implicit def SearchForm2JsonObject(in: SearchFormDyn): JsonObject = in json
}

class SearchFormDyn(override val useSelfName: Boolean = false) extends DynamicFormDyn with SearchFormDynInit {
  override val selfName = "SearchForm"

  private[this] var _showFilterFieldsOnly: Bool = showFilterFieldsOnly
  def ShowFilterFieldsOnly = _showFilterFieldsOnly
  def ShowFilterFieldsOnly_=(value: Bool) {
    if (_showFilterFieldsOnly == value) return
    json("showFilterFieldsOnly") = value
    _showFilterFieldsOnly = value
  }
}