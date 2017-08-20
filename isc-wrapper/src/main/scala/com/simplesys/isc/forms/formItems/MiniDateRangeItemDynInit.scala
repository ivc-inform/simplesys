package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import formItem.FormItemIconDyn
import com.simplesys.json.JsonElement

trait MiniDateRangeItemDynInit extends StaticTextItemDynInit {
  override protected val canFocus: Bool = true
  protected val dateDisplayFormat: DateDisplayFormat = ddfNull
  protected val fromDate: JsonElement = "$today"
  protected val fromDateOnlyPrefix: String = "Since"
  protected val pickerIcon: FormItemIconDyn = null
  override protected val pickerIconPrompt: String = "Show Date Chooser"
  protected val rangeDialog: DateRangeDialogDyn = null
  override protected val shouldSaveValue: Bool = true
  override protected val textBoxStyle: FormItemBaseStyle = "textItem"
  protected val toDate: JsonElement = "$today"
  protected val toDateOnlyPrefix: String = "Before"
}