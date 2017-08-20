package com.simplesys.isc.control.menu

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.ListGridRecordDynInit
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonElement, JsonNull}

trait MenuItemDynInit extends ListGridRecordDynInit {
    private[menu] val action: FunctionExpression = null
    private[menu] val visibilityIf: FunctionExpression = null
    private[menu] val canSelectParent: Bool = false
    private[menu] val checked: Bool = false
    private[menu] val checkIf: FunctionExpression = null
    private[menu] val click: FunctionExpression = null
    private[menu] val dynamicIcon: FunctionExpression = null
    private[menu] val dynamicTitle: FunctionExpression = null
    override protected val enabled: Bool = true
    private[menu] val enableIf: FunctionExpression = null
    private[menu] val fetchSubmenus: Bool = false
    private[menu] val icon: SCImgURL = JsonNull
    private[menu] val iconHeight: Number = 16
    private[menu] val iconWidth: Number = 16
    override protected val isSeparator: Bool = false
    private[menu] val id: String = ""
    private[menu] val keys: ArrayDyn[KeyIdentifier] = null
    private[menu] val keyTitle: String = null
    private[menu] val name: String = ""
    private[menu] val submenu: JsonElement = JsonNull
    private[menu] val title: HTMLString = ""
}