package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.RecordsDynList
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.JsonObject

trait ResultSetDynInit extends DataBoundComponentDynInit {
  protected val allRows: RecordsDynList = null
  protected val criteria: JsonObject = JsonObject()
  protected val criteriaPolicy: CriteriaPolicy = crtPlcNull
  protected val disableCacheSync: Bool = false
  protected val dropCacheOnUpdate: Bool = false
  protected val fetchDelay: Int = 0
  protected val fetchMode: FetchMode = ftchMdNull
  protected val initialData: RecordsDynList = null
  protected val initialLength: Int = 0
  protected val neverDropUpdatedRows: Bool = false
  protected val resultSize: Int = 75
  protected val sortSpecifiers: ArrayDyn[SortSpecifierDyn] = null
  protected val updateCacheFromRequest: Bool = true
  protected val updatePartialCache: Bool = true
  protected val useClientFiltering: Bool = true
  protected val useClientSorting: Bool = true
}