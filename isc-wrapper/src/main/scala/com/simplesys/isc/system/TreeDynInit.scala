package com.simplesys.isc.system

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.treeGrid.TreeNodeDyn
import misc._

trait TreeDynInit {
  protected val autoOpenRoot: Bool = true
  protected val childrenProperty: String = "children"
  protected val data: ArrayDyn[TreeNodeDyn] = null
  protected val defaultIsFolder: Bool = false
  protected val defaultNodeTitle: String = "Untitled"
  protected val discardParentlessNodes: Bool = false
  protected val idField: String = "id"
  protected val isFolderProperty: String = "isFolder"
  protected val modelType: TreeModelType = trmdChildren
  protected val nameProperty: String = "name"
  protected val openProperty: String = ""
  protected val parentIdField: String = "parentId"
  protected val pathDelim: String = "/"
  protected val reportCollisions: Bool = true
  protected val root: TreeNodeDyn = null
  protected val rootValue: Number = null
  protected val separateFolders: Bool = false
  protected val showRoot: Bool = false
  protected val sortFoldersBeforeLeaves: Bool = true
  protected val titleProperty: String = "title"
}