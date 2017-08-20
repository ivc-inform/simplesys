package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc.Bool


trait ContainerItemDynInit extends FormItemDynInit {
  protected val vertical: Bool = true
  protected val wrap: Bool = false
}