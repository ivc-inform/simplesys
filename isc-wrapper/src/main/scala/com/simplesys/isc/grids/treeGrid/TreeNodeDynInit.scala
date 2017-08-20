package com.simplesys.isc.grids.treeGrid

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonNull, JsonElement}

trait TreeNodeDynInit {
  protected val canAcceptDrop: Bool = false
  protected val canDrag: Bool = false
  protected val children: ArrayDyn[TreeNodeDyn] = null
  protected val enabled: Bool = false
  protected val icon: SCImgURL = JsonNull
  protected val id: JsonElement = ""
  protected val isFolder: JsonElement = JsonNull
  protected val name: String = ""
  protected val parentId: JsonElement = JsonNull
  protected val showDropIcons: Bool = false
  protected val showOpenIcons: Bool = false
  protected val title: HTMLString = ""
}