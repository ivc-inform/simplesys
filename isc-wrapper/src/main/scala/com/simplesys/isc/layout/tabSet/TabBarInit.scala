package com.simplesys.isc.layout.tabSet

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.ToolbarDynInit
import com.simplesys.isc.system.ArrayDyn

trait TabBarInit extends ToolbarDynInit {
  protected val baseLineCapSize: Number = 2
  protected val baseLineSrc: SCImgURL = "[SKIN]baseline.gif"
  protected val baseLineThickness: Number = 1
  protected val breadth: Number = 21
  override protected val buttonConstructor: SCClassName = "ImgTab"
  protected val defaultTabSize: Number = 80
  protected val moreTab: TabDyn = null
  protected val moreTabCount: Number = 5
  protected val showMoreTab: Bool = null
  protected val tabs: ArrayDyn[TabDyn] = null //type:Array of Tab Properties
}