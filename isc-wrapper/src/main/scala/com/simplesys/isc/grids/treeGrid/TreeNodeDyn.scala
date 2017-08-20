package com.simplesys.isc.grids.treeGrid

import com.simplesys.json.{JsonNull, JsonElement, JsonList, JsonObject}
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

object TreeNodeDyn {

  implicit def TreeNode1toJsonObject(in: TreeNodeDyn): JsonObject = in json
}

class TreeNodeDyn(override val inJson: JsonObject = null) extends ClassDyn with TreeNodeDynInit {

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  def Children = json.getValue2[JsonList, ArrayDyn[TreeNodeDyn]]("children").getOrElse(children)
  def Children_=(value: ArrayDyn[TreeNodeDyn]) {
    if (Children == value) return
    json("children") = value
  }

  private[this] var _title: HTMLString = title
  def Title = _title
  def Title_=(value: HTMLString) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  def Id = json.getJsonElement("id").getOrElse(id)
  def Id_=(value: JsonElement) {
    if (Id == value) return
    json("id") = value
  }

  def ParentId = json.getJsonElement("parentId").getOrElse(parentId)
  def ParentId_=(value: JsonElement) {
    if (ParentId == value) return
    json("parentId") = value
  }

  private[this] var _showDropIcons: Bool = showDropIcons
  def ShowDropIcons = _showDropIcons
  def ShowDropIcons_=(value: Bool) {
    if (_showDropIcons == value) return
    json("showDropIcons") = value
    _showDropIcons = value
  }

  private[this] var _showOpenIcons: Bool = showOpenIcons
  def ShowOpenIcons = _showOpenIcons
  def ShowOpenIcons_=(value: Bool) {
    if (_showOpenIcons == value) return
    json("showOpenIcons") = value
    _showOpenIcons = value
  }

  private[this] var _canAcceptDrop: Bool = canAcceptDrop
  def CanAcceptDrop = _canAcceptDrop
  def CanAcceptDrop_=(value: Bool) {
    if (_canAcceptDrop == value) return
    json("canAcceptDrop") = value
    _canAcceptDrop = value
  }

  private[this] var _canDrag: Bool = canDrag
  def CanDrag = _canDrag
  def CanDrag_=(value: Bool) {
    if (_canDrag == value) return
    json("canDrag") = value
    _canDrag = value
  }

  private[this] var _enabled: Bool = enabled
  def Enabled = _enabled
  def Enabled_=(value: Bool) {
    if (_enabled == value) return
    json("enabled") = value
    _enabled = value
  }

  private[this] var _icon: SCImgURL = icon
  def Icon = _icon
  def Icon_=(value: SCImgURL) {
    if (_icon == value) return
    json("icon") = value
    _icon = value
  }

  def IsFolder = json.getJsonElement("isFolder").getOrElse(isFolder)
  def IsFolder_=(value: JsonElement) {
    if (IsFolder == value) return
    json("isFolder") = value
  }
}
