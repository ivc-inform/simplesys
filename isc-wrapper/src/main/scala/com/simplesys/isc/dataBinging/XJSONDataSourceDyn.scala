package com.simplesys.isc.dataBinging

import com.simplesys.json.JsonObject

object XJSONDataSourceDyn {
  implicit def XJSONDataSource2JsonObject(in: XJSONDataSourceDyn): JsonObject = in json
}

class XJSONDataSourceDyn(override val useSelfName: Boolean = false) extends DataSourceDyn with XJSONDataSourceDynInit {
  override val selfName = "XJSONDataSource"
}