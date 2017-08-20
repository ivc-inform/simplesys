package com.simplesys.components.Dyn.Layout

import com.simplesys.json.{JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDyn
import com.simplesys.common.Strings._

object WindowSSDyn extends WindowSSDynInit {

    implicit def WindowSSDyn2JsonObject(in: WindowSSDyn): JsonObject = in json
}

class WindowSSDyn(override val useSelfName: Boolean = false) extends WindowDyn with WindowSSDynInit {
    override val selfName = "WindowSS"

    def OnDestroy = json.getFunctionExpressionOpt("onDestroy").getOrElse(onDestroy)
    def OnDestroy_=(value: FunctionExpression) {
        if (OnDestroy == value) return
        json("onDestroy") = value
    }

    def SaveSize = json.getBoolOpt("saveSize").getOrElse(saveSize)
    def SaveSize_=(value: Bool) {
        if (SaveSize == value) return
        json("saveSize") = value
    }

    def SavePosition = json.getBoolOpt("savePosition").getOrElse(savePosition)
    def SavePosition_=(value: Bool) {
        if (SavePosition == value) return
        json("savePosition") = value
    }

    def HeaderIconPath = json.getStringOpt("headerIconPath").getOrElse(headerIconPath)
    def HeaderIconPath_=(value: String) {
        if (HeaderIconPath == value) return
        json("headerIconPath") = value
    }
}