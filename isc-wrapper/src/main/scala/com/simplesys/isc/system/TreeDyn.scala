package com.simplesys.isc.system

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.treeGrid.TreeNodeDyn
import misc._

object TreeDyn {

  implicit def Tree1toJsonObject(in: TreeDyn): JsonObject = in json
}

class TreeDyn(override val useSelfName: Boolean = false) extends ClassDyn with TreeDynInit {

  override val selfName = "Tree"

  private[this] var _root: TreeNodeDyn = root
  def Root = _root
  def Root_=(value: TreeNodeDyn) {
    if (_root == value) return
    json("root") = TreeNodeDyn TreeNode1toJsonObject value
    _root = value
  }

  private[this] var _modelType: TreeModelType = modelType
  def ModelType = _modelType
  def ModelType_=(value: TreeModelType) {
    if (_modelType == value) return
    json("modelType") = value
    _modelType = value
  }

  private[this] var _nameProperty: String = nameProperty
  def NameProperty = _nameProperty
  def NameProperty_=(value: String) {
    if (_nameProperty == value) return
    json("nameProperty") = value
    _nameProperty = value
  }

  private[this] var _idField: String = idField
  def IdField = _idField
  def IdField_=(value: String) {
    if (_idField == value) return
    json("idField") = value
    _idField = value
  }

  private[this] var _parentIdField: String = parentIdField
  def ParentIdField = _parentIdField
  def ParentIdField_=(value: String) {
    if (_parentIdField == value) return
    json("parentIdField") = value
    _parentIdField = value
  }

  def Data = json.getValue2[JsonList, ArrayDyn[TreeNodeDyn]]("data").getOrElse(data)
  def Data_=(value: ArrayDyn[TreeNodeDyn]) {
    if (Data == value) return
    json("data") = value
  }

  private[this] var _childrenProperty: String = childrenProperty
  def ChildrenProperty = _childrenProperty
  def ChildrenProperty_=(value: String) {
    if (_childrenProperty == value) return
    json("childrenProperty") = value
    _childrenProperty = value
  }

  private[this] var _autoOpenRoot: Bool = autoOpenRoot
  def AutoOpenRoot = _autoOpenRoot
  def AutoOpenRoot_=(value: Bool) {
    if (_autoOpenRoot == value) return
    json("autoOpenRoot") = value
    _autoOpenRoot = value
  }

  private[this] var _defaultIsFolder: Bool = defaultIsFolder
  def DefaultIsFolder = _defaultIsFolder
  def DefaultIsFolder_=(value: Bool) {
    if (_defaultIsFolder == value) return
    json("defaultIsFolder") = value
    _defaultIsFolder = value
  }

  private[this] var _defaultNodeTitle: String = defaultNodeTitle
  def DefaultNodeTitle = _defaultNodeTitle
  def DefaultNodeTitle_=(value: String) {
    if (_defaultNodeTitle == value) return
    json("defaultNodeTitle") = value
    _defaultNodeTitle = value
  }

  private[this] var _discardParentlessNodes: Bool = discardParentlessNodes
  def DiscardParentlessNodes = _discardParentlessNodes
  def DiscardParentlessNodes_=(value: Bool) {
    if (_discardParentlessNodes == value) return
    json("discardParentlessNodes") = value
    _discardParentlessNodes = value
  }

  private[this] var _isFolderProperty: String = isFolderProperty
  def IsFolderProperty = _isFolderProperty
  def IsFolderProperty_=(value: String) {
    if (_isFolderProperty == value) return
    json("isFolderProperty") = value
    _isFolderProperty = value
  }

  private[this] var _openProperty: String = openProperty
  def OpenProperty = _openProperty
  def OpenProperty_=(value: String) {
    if (_openProperty == value) return
    json("openProperty") = value
    _openProperty = value
  }

  private[this] var _pathDelim: String = pathDelim
  def PathDelim = _pathDelim
  def PathDelim_=(value: String) {
    if (_pathDelim == value) return
    json("pathDelim") = value
    _pathDelim = value
  }

  private[this] var _reportCollisions: Bool = reportCollisions
  def ReportCollisions = _reportCollisions
  def ReportCollisions_=(value: Bool) {
    if (_reportCollisions == value) return
    json("reportCollisions") = value
    _reportCollisions = value
  }

  private[this] var _rootValue: Number = rootValue
  def RootValue = _rootValue
  def RootValue_=(value: Number) {
    json("rootValue") = value
    _rootValue = value
  }

  private[this] var _separateFolders: Bool = separateFolders
  def SeparateFolders = _separateFolders
  def SeparateFolders_=(value: Bool) {
    if (_separateFolders == value) return
    json("separateFolders") = value
    _separateFolders = value
  }

  private[this] var _showRoot: Bool = showRoot
  def ShowRoot = _showRoot
  def ShowRoot_=(value: Bool) {
    if (_showRoot == value) return
    json("showRoot") = value
    _showRoot = value
  }

  private[this] var _sortFoldersBeforeLeaves: Bool = sortFoldersBeforeLeaves
  def SortFoldersBeforeLeaves = _sortFoldersBeforeLeaves
  def SortFoldersBeforeLeaves_=(value: Bool) {
    if (_sortFoldersBeforeLeaves == value) return
    json("sortFoldersBeforeLeaves") = value
    _sortFoldersBeforeLeaves = value
  }

  private[this] var _titleProperty: String = titleProperty
  def TitleProperty = _titleProperty
  def TitleProperty_=(value: String) {
    if (_titleProperty == value) return
    json("titleProperty") = value
    _titleProperty = value
  }
}
