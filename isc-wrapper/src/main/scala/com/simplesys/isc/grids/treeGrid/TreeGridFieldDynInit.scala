package com.simplesys.isc.grids.treeGrid

import com.simplesys.isc.grids.listGrid.ListGridFieldDynInit
import com.simplesys.isc.system.misc.Bool

trait TreeGridFieldDynInit extends ListGridFieldDynInit {
  protected val treeField: Bool = false
}