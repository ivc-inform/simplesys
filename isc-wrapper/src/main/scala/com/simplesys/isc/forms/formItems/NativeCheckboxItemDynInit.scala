package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait NativeCheckboxItemDynInit extends FormItemDynInit {
  protected val showLabel: Bool = true
  override protected val textBoxStyle: FormItemBaseStyle = "labelAnchor"
}