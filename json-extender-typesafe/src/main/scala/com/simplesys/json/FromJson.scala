package com.simplesys.json

import com.simplesys.common.Strings._
import com.simplesys.isc.system.misc._
import com.simplesys.log.Logging

trait JsonConverter2[T, R] {
    def getValue(x: T): R
}

object JsonConverter2 extends Logging {
    implicit def fromStringToJsonList = new JsonConverter2[JsonString, JsonList] {
        def getValue(x: JsonString): JsonList = Json(x.toString.unQuoted, null)
    }

    implicit def fromStringToJsonObject = new JsonConverter2[JsonString, JsonObject] {
        def getValue(x: JsonString): JsonObject = Json(x.toString.unQuoted)
    }

    implicit def fromBigDecimalToNumber = new JsonConverter2[JsonBigDecimal, Number] {
        def getValue(x: JsonBigDecimal): Number = Number(x.toString)
    }

    implicit def fromStringToNumber = new JsonConverter2[JsonString, Number] {
        def getValue(x: JsonString): Number = Number(x.toString)
    }

    implicit def fromBooleanToBool = new JsonConverter2[JsonBoolean, Bool] {
        def getValue(x: JsonBoolean): Bool = Bool(x.toString)
    }

    implicit def fromStringToFunctionExpression = new JsonConverter2[JsonString, FunctionExpression] {
        def getValue(x: JsonString): FunctionExpression = x.toString.f
    }
}