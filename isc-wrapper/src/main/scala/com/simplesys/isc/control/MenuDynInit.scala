package com.simplesys.isc.control

import com.simplesys.isc.foundation.canvas.ImgPropertiesDyn
import menu.MenuItemDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.grids.ListGridDynInit
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.JsonElement

trait MenuDynInit extends ListGridDynInit {
  override protected val alternateRecordStyles: Bool = false
  protected val autoDismiss: Bool = true
  protected val autoDismissOnBlur: Bool = true
  override protected val autoDraw: Bool = true
  override protected val baseStyle: CSSStyleName = "menu"
  protected val canSelectParentItems: Bool = false
  protected val cascadeAutoDismiss: Bool = true
  override protected val cellHeight: Number = 20
  protected val checkmarkDisabledImage: ImgPropertiesDyn = null
  protected val checkmarkImage: ImgPropertiesDyn = null
  override protected val defaultWidth: Number = 150
  override protected val emptyMessage: JsonElement = "[Empty menu]"
  protected val fetchSubmenus: Bool = true
  protected val iconHeight: Number = 16
  protected val iconWidth: Number = 16
  protected val items: ArrayDyn[MenuItemDyn] = null
  protected val itemClick: FunctionExpression = null
  private[control] val jSFile: SCImgURL = ""
  protected val menuButtonWidth: Number = null
  override protected val shadowDepth: Number = 0
  protected val showAnimationEffect: String = ""
  protected val showIcons: Bool = true
  protected val showKeys: Bool = true
  protected val showSubmenus: Bool = true
  protected val submenuDirection: String = "right"
  protected val submenuDisabledImage: ImgPropertiesDyn = null
  protected val submenuImage: ImgPropertiesDyn = null
  protected val target: CanvasDyn = null
  protected val useKeys: Bool = true
}