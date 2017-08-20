package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonNull, JsonElement, JsonObject}

trait CriterionDynInit {
    private[dataSource] val constructor: String = ""
    private[dataSource] val criteria = ArrayDyn.empty[CriterionDyn]
    private[dataSource] val end: Number = ""
    private[dataSource] val fieldName: String = ""
    private[dataSource] val operator: OperatorId = opIdNull
    private[dataSource] val start: Number = ""
    private[dataSource] val value: JsonElement = JsonNull
}