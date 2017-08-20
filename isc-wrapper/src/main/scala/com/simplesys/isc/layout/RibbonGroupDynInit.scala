package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonList

trait RibbonGroupDynInit extends ToolStripGroupDynInit {
  protected val newControlConstructor: String = "IconButton"
  protected val newControlDefaults: AutoChild = null
  protected val title: String = "Title"
  protected val colWidths: JsonList = null
}