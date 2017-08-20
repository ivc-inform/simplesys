package com.simplesys.components.Dyn.DataBinding

import com.simplesys.isc.dataBinging.RestDataSourceDyn
import com.simplesys.json.JsonObject

object RestDataSourceSSDyn {
    implicit def RestDataSourceSSDyn2JsonObject(in: RestDataSourceSSDyn): JsonObject = in json
    implicit def JSonObjToRestDataSourceSS(jsonObject: JsonObject): RestDataSourceSSDyn = new RestDataSourceSSDyn(inJson = jsonObject, useSelfName = true)
}

class RestDataSourceSSDyn(override val inJson: JsonObject = null,
                          override val useSelfName: Boolean = false) extends RestDataSourceDyn with RestDataSourceSSDynInit {
    override val selfName = "RestDataSourceSS"
}