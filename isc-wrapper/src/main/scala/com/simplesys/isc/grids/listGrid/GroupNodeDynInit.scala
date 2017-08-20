package com.simplesys.isc.grids.listGrid

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.system.ArrayDyn

trait GroupNodeDynInit {
  protected val groupMembers: ArrayDyn[ListGridRecordDyn] = null
  protected val groupTitle: HTMLString = ""
  protected val groupValue: String = ""
}