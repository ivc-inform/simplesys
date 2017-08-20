package com.simplesys.isc.control.menu

import com.simplesys.json.{JsonString, JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.{ClassDyn, ArrayDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.control.MenuDyn

object MenuItemDyn {
  implicit def MenuItemtoJsonObject(in: MenuItemDyn): JsonObject = in json
  implicit def JSonObjToMenuItemDyn(jsonObject: JsonObject): MenuItemDyn = new MenuItemDyn(jsonObject)
}

class MenuItemDyn(override val inJson: JsonObject = null,
                  override val useSelfName: Boolean = false) extends ListGridRecordDyn with MenuItemDynInit {
  override val selfName = "MenuItem"

  private[this] var _click: FunctionExpression = click
  def Click = _click
  def Click_=(value: FunctionExpression) {
    if (_click == value) return
    json("click") = value
    _click = value
  }

    def VisibilityIf = json.getValue2[JsonString, FunctionExpression]("visibilityIf").getOrElse(visibilityIf)
    def VisibilityIf_=(value: FunctionExpression) {
        if (VisibilityIf == value) return
        json("visibilityIf") = value
    }

  private[this] var _action: FunctionExpression = action
  def Action = _action
  def Action_=(value: FunctionExpression) {
    if (_action == value) return
    json("action") = value
    _action = value
  }

  private[this] var _title: HTMLString = title
  def Title = _title
  def Title_=(value: HTMLString) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _keyTitle: String = keyTitle
  def KeyTitle = _keyTitle
  def KeyTitle_=(value: String) {
    if (_keyTitle == value) return
    json("keyTitle") = value
    _keyTitle = value
  }

  private[this] var _icon: SCImgURL = icon
  def Icon = _icon
  def Icon_=(value: SCImgURL) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }

  private[this] var _checked: Bool = checked
  def Checked = _checked
  def Checked_=(value: Bool) {
    if (_checked == value) return
    json("checked") = value
    _checked = value
  }

  def Submenu = json.getJsonElement("submenu").getOrElse(submenu)
  def Submenu_=(value: JsonElement) {
    if (Submenu == value) return
    json("submenu") = value
  }

  private[this] var _dynamicTitle: FunctionExpression = dynamicTitle
  def DynamicTitle = _dynamicTitle
  def DynamicTitle_=(value: FunctionExpression) {
    if (_dynamicTitle == value) return
    json("dynamicTitle") = value

    _dynamicTitle = value
  }

  private[this] var _dynamicIcon: FunctionExpression = dynamicIcon
  def DynamicIcon = _dynamicIcon
  def DynamicIcon_=(value: FunctionExpression) {
    if (_dynamicIcon == value) return

    json("dynamicIcon") = value
    _dynamicIcon = value
  }

  private[this] var _enableIf: FunctionExpression = enableIf
  def EnableIf = _enableIf
  def EnableIf_=(value: FunctionExpression) {
    if (_enableIf == value) return
    json("enableIf") = value
    _enableIf = value
  }

  private[this] var _checkIf: FunctionExpression = checkIf
  def CheckIf = _enableIf
  def CheckIf_=(value: FunctionExpression) {
    if (_checkIf == value) return
    json("checkIf") = value
    _checkIf = value
  }

  private[this] var _canSelectParent: Bool = canSelectParent
  def CanSelectParent = _canSelectParent
  def CanSelectParent_=(value: Bool) {
    if (_canSelectParent == value) return
    json("canSelectParent") = value
    _canSelectParent = value
  }

  private[this] var _fetchSubmenus: Bool = fetchSubmenus
  def FetchSubmenus = _fetchSubmenus
  def FetchSubmenus_=(value: Bool) {
    if (_fetchSubmenus == value) return
    json("fetchSubmenus") = value
    _fetchSubmenus = value
  }

  private[this] var _iconHeight: Number = iconHeight
  def IconHeight = _iconHeight
  def IconHeight_=(value: Number) {
    if (_iconHeight == value) return
    json("iconHeight") = value
    _iconHeight = value
  }

  private[this] var _iconWidth: Number = iconWidth
  def IconWidth = _iconWidth
  def IconWidth_=(value: Number) {
    if (_iconWidth == value) return
    json("iconWidth") = value
    _iconWidth = value
  }

  private[this] var _keys: ArrayDyn[KeyIdentifier] = keys
  def Keys = _keys
  def Keys_=(value: ArrayDyn[KeyIdentifier]) {
    if (_keys == value) return
    json("keys") = value
    _keys = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    json("name") = value
    _name = value
  }
}

