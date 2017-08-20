package com.simplesys.isc.forms

import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonList
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.dataBinging.DataBoundComponentDynInit

trait ValuesManagerDynInit extends DataBoundComponentDynInit {
  protected val autoSynchronize: Bool = false
  protected val disableValidation: Bool = false
  protected val members: JsonList = JsonList()
  protected val saveOperationType: DSOperationType = dsOptTypeNull
  protected val suppressValidationErrorCallback: Bool = false
}