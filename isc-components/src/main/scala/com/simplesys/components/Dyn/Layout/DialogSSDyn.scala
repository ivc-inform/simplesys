package com.simplesys.components.Dyn.Layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.control.DialogDyn

object DialogSSDyn extends DialogSSDynInit {
    implicit def DialogSSDyn2JsonObject(in: DialogSSDyn): JsonObject = in json
}

class DialogSSDyn(override val useSelfName: Boolean = false) extends DialogDyn with DialogSSDynInit {
    override val selfName = "DialogSS"

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
}