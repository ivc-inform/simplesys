package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonList

trait ToolStripGroupDynInit extends LayoutDynInit {
    protected val body: AutoChild = null
    protected val bodyConstructor: String = "HLayout"
    protected val controls: JsonList = null
    protected val label: AutoChild = null
    protected val labelConstructor: String = "Label"
    protected val numRows: Number = 1
    protected val rowHeight: Number = 20
    override protected val styleName: CSSStyleName = "toolStripGroup"
    protected val titleAlign: AlignmentDyn = AlCenter
    private[layout] val titleHeight: Number = 18
    protected val titleOrientation: AlignmentDyn = ValTop
    protected val titleProperties: AutoChild = null
    protected val titleStyle: CSSStyleName = "toolStripGroupTitle"
    private[layout] val autoSizeToTitle: Boolean = true
}