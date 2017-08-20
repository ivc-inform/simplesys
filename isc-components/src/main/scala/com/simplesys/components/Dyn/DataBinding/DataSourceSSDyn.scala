package com.simplesys.components.Dyn.DataBinding

import com.simplesys.isc.dataBinging.DataSourceDyn
import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object DataSourceSSDyn {
    implicit def DataSourceSSDyn2JsonObject(in: DataSourceSSDyn): JsonObject = in json
}

class DataSourceSSDyn(override val useSelfName: Boolean = false) extends DataSourceDyn with DataSourceSSDynInit {
    override val selfName = "DataSourceSS"
}