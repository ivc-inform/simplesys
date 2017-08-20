package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.json.JsonObject

object AdvancedCriteriaDyn {
  implicit def AdvancedCriteriatoJsonObject(in: AdvancedCriteriaDyn): JsonObject = in json
}

class AdvancedCriteriaDyn(override val inJson: JsonObject = null) extends CriterionDyn(inJson) with AdvancedCriteriaDynInit
