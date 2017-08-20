package com.simplesys.isc.control

import com.simplesys.json.{JsonList, JsonElement, JsonObject}
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids._
import com.simplesys.isc.foundation.canvas.ImgPropertiesDyn
import com.simplesys.isc.foundation.CanvasDyn
import menu.MenuItemDyn
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.typesDyn.SCImgURL

object MenuDyn {
  implicit def Menu1toJsonObject(in: MenuDyn): JsonObject = in json

  implicit def JSonObjToClassDyn(jsonObject: JsonObject): MenuDyn = new MenuDyn(jsonObject)

  /*implicit def JSonElmentToClassDyn(jsonElement: JsonElement): MenuDyn = {
    jsonElement match {
      case jsonObject: JsonObject => new MenuDyn(jsonObject)
      case _ => ???
    }
  }*/
}

class MenuDyn(override val inJson: JsonObject = null,
              override val useSelfName: Boolean = false) extends ListGridDyn with MenuDynInit {
  override val selfName = "MenuSS"

  private[this] var _canSelectParentItems: Bool = canSelectParentItems
  def CanSelectParentItems = _canSelectParentItems
  def CanSelectParentItems_=(value: Bool) {
    if (_canSelectParentItems == value) return

    json("canSelectParentItems") = value
    _canSelectParentItems = value
  }

  private[this] var _itemClick: FunctionExpression = itemClick
  def ItemClick = _itemClick
  def ItemClick_=(value: FunctionExpression) {
    if (_itemClick == value) return
    json("itemClick") = value
    _itemClick = value
  }

  private[this] var _autoDismiss: Bool = autoDismiss
  def AutoDismiss = _autoDismiss
  def AutoDismiss_=(value: Bool) {
    if (_autoDismiss == value) return
    json("autoDismiss") = value
    _autoDismiss = value
  }

  private[this] var _autoDismissOnBlur: Bool = autoDismissOnBlur
  def AutoDismissOnBlur = _autoDismissOnBlur
  def AutoDismissOnBlur_=(value: Bool) {
    if (_autoDismissOnBlur == value) return
    json("autoDismissOnBlur") = value
    _autoDismissOnBlur = value
  }

  private[this] var _cascadeAutoDismiss: Bool = cascadeAutoDismiss
  def CascadeAutoDismiss = _cascadeAutoDismiss
  def CascadeAutoDismiss_=(value: Bool) {
    if (_cascadeAutoDismiss == value) return
    json("cascadeAutoDismiss") = value
    _cascadeAutoDismiss = value
  }

  private[this] var _checkmarkDisabledImage: ImgPropertiesDyn = checkmarkDisabledImage
  def CheckmarkDisabledImage = _checkmarkDisabledImage
  def CheckmarkDisabledImage_=(value: ImgPropertiesDyn) {
    if (_checkmarkDisabledImage == value) return
    json("checkmarkDisabledImage") = value
    _checkmarkDisabledImage = value
  }

  private[this] var _checkmarkImage: ImgPropertiesDyn = checkmarkImage
  def CheckmarkImage = _checkmarkImage
  def CheckmarkImage_=(value: ImgPropertiesDyn) {
    if (_checkmarkImage == value) return
    json("checkmarkImage") = value
    _checkmarkImage = value
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

  private[this] var _items: ArrayDyn[MenuItemDyn] = items
  def Items = _items
  def Items_=(value: ArrayDyn[MenuItemDyn]) {
    if (_items == value) return
    json("items") = value
    _items = value
  }

  def JSFile = json.getSCImgURL("JSFile").getOrElse(jSFile)
  def JSFile_=(value: SCImgURL) {
    if (JSFile == value) return
    json("JSFile") = value
  }

  private[this] var _menuButtonWidth: Number = menuButtonWidth
  def MenuButtonWidth = _menuButtonWidth
  def MenuButtonWidth_=(value: Number) {
    if (_menuButtonWidth == value) return
    json("menuButtonWidth") = value
    _menuButtonWidth = value
  }

  private[this] var _showAnimationEffect: String = showAnimationEffect
  def ShowAnimationEffect = _showAnimationEffect
  def ShowAnimationEffect_=(value: String) {
    if (_showAnimationEffect == value) return
    json("showAnimationEffect") = value
    _showAnimationEffect = value
  }

  private[this] var _showIcons: Bool = showIcons
  def ShowIcons = _showIcons
  def ShowIcons_=(value: Bool) {
    if (_showIcons == value) return
    json("showIcons") = value
    _showIcons = value
  }

  private[this] var _showKeys: Bool = showKeys
  def ShowKeys = _showKeys
  def ShowKeys_=(value: Bool) {
    if (_showKeys == value) return
    json("showKeys") = value
    _showKeys = value
  }

  private[this] var _showSubmenus: Bool = showSubmenus
  def ShowSubmenus = _showSubmenus
  def ShowSubmenus_=(value: Bool) {
    if (_showSubmenus == value) return
    json("showSubmenus") = value
    _showSubmenus = value
  }

  private[this] var _submenuDirection: String = submenuDirection
  def SubmenuDirection = _submenuDirection
  def SubmenuDirection_=(value: String) {
    if (_submenuDirection == value) return
    json("submenuDirection") = value
    _submenuDirection = value
  }

  private[this] var _submenuDisabledImage: ImgPropertiesDyn = submenuDisabledImage
  def SubmenuDisabledImage = _submenuDisabledImage
  def SubmenuDisabledImage_=(value: ImgPropertiesDyn) {
    if (_submenuDisabledImage == value) return
    json("submenuDisabledImage") = value
    _submenuDisabledImage = value
  }

  private[this] var _submenuImage: ImgPropertiesDyn = submenuImage
  def SubmenuImage = _submenuImage
  def SubmenuImage_=(value: ImgPropertiesDyn) {
    if (_submenuImage == value) return
    json("submenuImage") = value
    _submenuImage = value
  }

  private[this] var _target: CanvasDyn = target
  def Target = _target
  def Target_=(value: CanvasDyn) {
    if (_target == value) return
    json("target") = value
    _target = value
  }

  private[this] var _useKeys: Bool = useKeys
  def UseKeys = _useKeys
  def UseKeys_=(value: Bool) {
    if (_useKeys == value) return
    json("useKeys") = value
    _useKeys = value
  }

}
