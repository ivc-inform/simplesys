package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn.{srtDirNull, SortDirection}

trait SortSpecifierDynInit extends {
  protected val context: JsonObject = JsonObject()
  protected val direction: SortDirection = srtDirNull
  protected val normalizer: FunctionExpression = null
  protected val property: String = ""
}