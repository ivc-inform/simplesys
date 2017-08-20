package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.system.ArrayDyn

trait PickListMenuDynInit extends ScrollingMenuDynInit {
  protected val bodyStyleName: CSSStyleName = "pickListMenuBody"
  protected val dataProperties: ArrayDyn[ListGridRecordDyn] = null
  protected val emptyMessage: String = "No Items To Show"
  protected val normalCellHeight: Number = 16
  protected val styleName: CSSStyleName = "pickListMenu"
}