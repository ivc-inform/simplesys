package com.simplesys.isc.forms

import com.simplesys.isc.system.misc._

trait SearchFormDynInit extends DynamicFormDynInit {
  override protected val canEditFieldAttribute: String = "canFilter"
  protected val showFilterFieldsOnly: Bool = true
}