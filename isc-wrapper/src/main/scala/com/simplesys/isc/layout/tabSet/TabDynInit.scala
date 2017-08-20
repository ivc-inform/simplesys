package com.simplesys.isc.layout.tabSet

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonNull}
import com.simplesys.isc.foundation.CanvasDyn

trait TabDynInit {
    protected val canClose: Bool = null
    protected val canEditTitle: Bool = null
    protected val closeIcon: SCImgURL = JsonNull
    protected val closeIconSize: Number = null
    protected val disabled: Bool = null
    protected val icon: SCImgURL = JsonNull
    protected val iconHeight: Number = null
    protected val iconSize: Number = null
    protected val iconWidth: Number = null
    protected val pickerTitle: HTMLString = ""
    private[tabSet] val pane: CanvasDyn = null
    protected val prompt: String = ""
    protected val title: HTMLString = ""
    protected val width: Number = 100
}