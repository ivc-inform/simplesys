package com.simplesys.isc.system

import com.simplesys.xml.Elem
import misc.{CSSStyleName, FunctionExpression}
import com.simplesys.common.Strings._
import com.simplesys.json.{JsonObject, JsonElement}

object MultiAutoChild {
    def apply() = JsonObject()
}

object AutoChild {
    def apply() = JsonObject()
}

package object typesDyn {
    type HTMLString = String

    type SCImgURL = JsonElement
    type AutoChild = JsonObject
    type MultiAutoChild = JsonObject

    type PageHtml = Elem

    type RPCCallback = FunctionExpression
    type DSCallback = FunctionExpression
    type FormItemBaseStyle = CSSStyleName
    type DateInputFormat = String
    type UserFormula = String

    implicit class jsonOpt(jsonElement: JsonObject) {
        def getMultiAutoChildOpt(key: String): Option[MultiAutoChild] = jsonElement.getJsonObjectOpt(key)
        def getMultiAutoChild(key: String): MultiAutoChild = jsonElement.getJsonObject(key)
        def getAutoChildOpt(key: String): Option[AutoChild] = jsonElement.getJsonObjectOpt(key)
        def getAutoChild(key: String): AutoChild = jsonElement.getJsonObject(key)
    }

    implicit class String2DSOperationType(str: String) {
        def getDSOperationType: DSOperationType = str.unQuoted match {
            case "" => dsOptTypeNull
            case "fetch" => dsOptTypeFetch
            case "add" => dsOptTypeAdd
            case "update" => dsOptTypeUpdate
            case "remove" => dsOptTypeRemove
            case "validate" => dsOptTypeValidate
            case "custom" => dsOptTypeCustom
        }
    }
}