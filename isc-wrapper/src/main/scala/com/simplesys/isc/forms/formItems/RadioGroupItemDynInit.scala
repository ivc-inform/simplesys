package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import radioGroupItem.RadioItemDyn
import com.simplesys.json.JsonList

trait RadioGroupItemDynInit extends ContainerItemDynInit {
  protected val disabledValues: JsonList = JsonList()
  protected val itemProperties: RadioItemDyn = null
  override protected val textBoxStyle: FormItemBaseStyle = "labelAnchor"
  override protected val __type: FormItemType = frmitmtpRadioGroup
}