package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.json.{JsonString, JsonList, JsonObject}
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.typesDyn.OperatorId
import com.simplesys.isc.system.misc._

object CriterionDyn {
    implicit def CriteriontoJsonObject(in: CriterionDyn): JsonObject = in json
}

class CriterionDyn(override val inJson: JsonObject = null) extends ClassDyn with CriterionDynInit {

    def Constructor = json.getStringOpt("_constructor").getOrElse(constructor)
    def ConstructorOpt = json.getStringOpt("_constructor")
    def Constructor_=(value: String) {
        if (Constructor == value) return
        json("_constructor") = value
    }

    def Criteria = json.getValue2[JsonList, ArrayDyn[CriterionDyn]]("criteria").getOrElse(criteria)
    def Criteria_=(value: ArrayDyn[CriterionDyn]) {
        if (Criteria == value) return
        json("criteria") = value
    }

    def End = json.getNumberOpt("end").getOrElse(end)
    def End_=(value: Number) {
        if (End == value) return
        json("end") = value
    }

    def FieldName = json.getStringOpt("fieldName").getOrElse(fieldName)
    def FieldName_=(value: String) {
        if (FieldName == value) return
        json("fieldName") = value
    }

    def Operator = json.getValue2[JsonString, OperatorId]("operator").getOrElse(operator)
    def Operator_=(value: OperatorId) {
        if (Operator == value) return
        json("operator") = value
    }

    def Start = json.getNumberOpt("start").getOrElse(start)
    def Start_=(value: Number) {
        if (Start == value) return
        json("start") = value
    }
}

