package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonElement, JsonNull, JsonObject, Json}
import com.simplesys.isc.system.{ClassDynInit, IscDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.common.Strings._

trait WildRecordColumnDynInit extends ClassDynInit {
    private[dataBinging] val name: String = strEmpty
    private[dataBinging] val value: JsonElement = JsonNull

}