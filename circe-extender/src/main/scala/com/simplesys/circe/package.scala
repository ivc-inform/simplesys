package com.simplesys
import io.circe.Json._
import io.circe.{Json, JsonObject}

package object circe {
    implicit def jsonObj2json(jsonobg: JsonObject): Json = fromJsonObject(jsonobg)

    implicit def json2jsonObj(json: Json): JsonObject = json match {
        case JObject(jsonObj) ⇒ jsonObj
        case _ ⇒ JsonObject.empty
    }
}
