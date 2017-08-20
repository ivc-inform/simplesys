package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._

trait SpacerItemDynInit extends FormItemDynInit {
  override protected val height: Number = 20
  override protected val showTitle: Bool = false
  override protected val width: Number = 20
}