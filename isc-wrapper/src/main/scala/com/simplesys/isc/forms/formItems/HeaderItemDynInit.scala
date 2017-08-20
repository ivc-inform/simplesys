package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonString}

trait HeaderItemDynInit extends FormItemDynInit {
  override protected val colSpan: JsonElement = "*"
  override protected val defaultValue: JsonString = JsonString("Header")
  override protected val endRow: Bool = true
  override protected val showTitle: Bool = false
  override protected val startRow: Bool = true
  override protected val textBoxStyle: FormItemBaseStyle = "headerItem"
  override protected val __type: FormItemType = frmitmtpHeader
}