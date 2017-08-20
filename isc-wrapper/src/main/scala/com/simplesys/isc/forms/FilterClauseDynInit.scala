package com.simplesys.isc.forms

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.HStackDynInit
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn

trait FilterClauseDynInit extends HStackDynInit {
  protected val clause: AutoChild = null
  protected val criterion: CriteriaDyn = null
  protected val fieldPickerTitle: String = "Field Name"
  protected val removeButton: AutoChild = null
  protected val removeButtonPrompt: String = "Remove"
  protected val showFieldTitles: Bool = true
  protected val showRemoveButton: Bool = true
  protected val validateOnChange: Bool = true
  protected val valueItemTitle: String = "Value"
}