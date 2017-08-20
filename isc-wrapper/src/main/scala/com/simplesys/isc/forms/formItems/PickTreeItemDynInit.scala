package com.simplesys.isc.forms.formItems

import com.simplesys.isc.dataBinging.DataSourceDyn
import com.simplesys.isc.system.TreeDyn
import com.simplesys.isc.system.misc.Bool

trait PickTreeItemDynInit {
  protected val canSelectParentItems: Bool = false
  protected val dataSource: DataSourceDyn = null
  protected val emptyMenuMessage: String = "No items to display"
  protected val loadDataOnDemand: Bool = false
  protected val valueTree: TreeDyn = null
}