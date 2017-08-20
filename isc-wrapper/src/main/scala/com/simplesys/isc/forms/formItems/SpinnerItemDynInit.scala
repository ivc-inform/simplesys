package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._

trait SpinnerItemDynInit extends TextItemDynInit {
  protected val max: Number = null
  protected val min: Number = null
  protected val step: Number = 1
}