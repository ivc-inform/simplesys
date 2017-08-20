package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.TreeDyn
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.layout.LayoutDynInit
import com.simplesys.isc.dataBinging.DataBoundComponentDynInit

trait ColumnTreeDynInit extends LayoutDynInit with DataBoundComponentDynInit {
  protected val autoFetchData: Bool = false
  protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleNull
  protected val backButton: AutoChild = null
  protected val backButtonTitle: String = "Back"
  protected val closedIconSuffix: String = "closed"
  protected val column: AutoChild = null
  protected val columnProperties: ListGridDyn = null
  protected val customIconOpenProperty: String = "showOpenIcon"
  protected val customIconProperty: String = "icon"
  protected val data: TreeDyn = null
  protected val firstColumnTitle: String = " "
  protected val folderIcon: SCImgURL = "[SKIN]folder.gif"
  protected val initialCriteria: CriteriaDyn = null
  protected val loadDataOnDemand: Bool = false
  protected val nodeIcon: SCImgURL = "[SKIN]file.gif"
  protected val openIconSuffix: String = "open"
  protected val showCustomIconOpen: Bool = false
  override protected val showDetailFields: Bool = true
  protected val showHeaders: Bool = false
  protected val showMultipleColumns: Bool = false
  protected val showNodeCount: Bool = false
  protected val showOpenIcons: Bool = true
}