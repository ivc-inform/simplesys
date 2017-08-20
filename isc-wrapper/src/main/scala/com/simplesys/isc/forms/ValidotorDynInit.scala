package com.simplesys.isc.forms

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.dataBinging.RPC.ServerObjectDyn
import com.simplesys.json.{JsonObject, JsonList}
import com.simplesys.isc.dataBinging.dataSource.AdvancedCriteriaDyn

trait ValidotorDynInit {
  protected val applyWhen: AdvancedCriteriaDyn = null
  protected val clientOnly: Bool = false
  protected val dependentFields: JsonList = JsonList()
  protected val errorMessage: String = ""
  protected val min: Number = null
  protected val precision: Number = null
  protected val resultingValue: JsonObject = JsonObject()
  protected val serverObject: ServerObjectDyn = null
  protected val serverOnly: Bool = false
  protected val stopIfFalse: Bool = false
  protected val stopOnError: Bool = false
  protected val __type: ValidatorType = vldTpNull
  protected val validateOnChange: Bool = false
}