package com.simplesys.isc.dataBinging

import com.simplesys.json.JsonObject

object SummaryBuilderDyn {
  implicit def SummaryBuilder2JsonObject(in: SummaryBuilderDyn): JsonObject = in json
}

class SummaryBuilderDyn(override val useSelfName: Boolean = false) extends FormulaBuilderDyn with SummaryBuilderDynInit {
  override val selfName = "SummaryBuilder"
}