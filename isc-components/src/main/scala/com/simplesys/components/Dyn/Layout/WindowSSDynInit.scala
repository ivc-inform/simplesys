package com.simplesys.components.Dyn.Layout

import com.simplesys.common.Strings._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDynInit
import com.simplesys.json.{JsonElement, JsonNull}

trait WindowSSDynInit extends WindowDynInit {
    private[Dyn] val saveSize: Bool = true
    private[Dyn] val savePosition: Bool = true
    private[Layout] val headerIconPath: String = strEmpty
    private[Dyn] val onDestroy: FunctionExpression = null
    override protected val keepInParentRect: JsonElement = true
    override protected val showMaximizeButton: Bool = true
}   