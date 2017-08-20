package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.TreeDyn
import com.simplesys.isc.dataBinging.DataSourceDyn
import com.simplesys.isc.system.misc.Bool

object PickTreeItemDyn {
  implicit def PickTreeItemtoJsonObject(in: PickTreeItemDyn): JsonObject = in json
}

class PickTreeItemDyn extends CanvasItemDyn with PickTreeItemDynInit {
  override val selfName = "PickTreeItem"

  private[this] var _canSelectParentItems: Bool = canSelectParentItems
  def CanSelectParentItems = _canSelectParentItems
  def CanSelectParentItems_=(value: Bool) {
    if (_canSelectParentItems == value) return
    json("canSelectParentItems") = value
    _canSelectParentItems = value
  }

  private[this] var _emptyMenuMessage: String = emptyMenuMessage
  def EmptyMenuMessage = _emptyMenuMessage
  def EmptyMenuMessage_=(value: String) {
    if (_emptyMenuMessage == value) return
    json("emptyMenuMessage") = value
    _emptyMenuMessage = value
  }

  private[this] var _loadDataOnDemand: Bool = loadDataOnDemand
  def LoadDataOnDemand = _loadDataOnDemand
  def LoadDataOnDemand_=(value: Bool) {
    if (_loadDataOnDemand == value) return
    json("loadDataOnDemand") = value
    _loadDataOnDemand = value
  }

  private[this] var _ValueTree: TreeDyn = ValueTree
  def ValueTree = _ValueTree
  def ValueTree_=(value: TreeDyn) {
    if (_ValueTree == value) return
    json("ValueTree") = value
    _ValueTree = value
  }

  private[this] var _dataSource: DataSourceDyn = dataSource
  def DataSource = _dataSource
  def DataSource_=(value: DataSourceDyn) {
    if (_dataSource == value) return
    json("dataSource") = value
    _dataSource = value
  }

}

