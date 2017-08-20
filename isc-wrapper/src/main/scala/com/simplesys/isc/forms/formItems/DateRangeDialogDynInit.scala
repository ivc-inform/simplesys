package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.WindowDynInit

trait DateRangeDialogDynInit extends WindowDynInit {
  protected val cancelButton: AutoChild = null
  protected val cancelButtonTitle: String = "Cancel"
  protected val clearButton: AutoChild = null
  protected val clearButtonTitle: String = "Clear"
  protected val headerTitle: String = "Select Date Range"
  protected val okButton: AutoChild = null
  protected val okButtonTitle: String = "OK"
  protected val rangeItem: DateRangeItemDyn = null
}