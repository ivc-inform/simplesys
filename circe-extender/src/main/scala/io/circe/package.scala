package io

import io.circe.Json.{JObject, _}

package object circe {
    implicit def jsonObj2json(jsonobg: JsonObject): Json = fromJsonObject(jsonobg)

    implicit def json2jsonObj(json: Json): JsonObject = json match {
        case JObject(jsonObj) ⇒ jsonObj
        case _ ⇒ JsonObject.empty
    }

    implicit def json2jsonVectot(json: Json): Vector[Json] = json match {
        case JArray(jsonArray) ⇒ jsonArray
        case _ ⇒ Vector.empty
    }
}
