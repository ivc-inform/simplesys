package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait DateItemDynInit extends FormItemDynInit {
  protected val centuryThreshold: Number = 25
  protected val daySelector: AutoChild = null
  protected val daySelectorProperties: SelectItemDyn = null
  protected val defaultChooserDate: Date = ""
  protected val endDate: Date = "12/31/2015"
  protected val enforceDate: Bool = false
  protected val invalidDateStringMessage: String = "Invalid date"
  protected val maskDateSeparator: String = ""
  protected val monthSelector: AutoChild = null
  protected val monthSelectorProperties: SelectItemDyn = null
  override protected val pickerConstructor: SCClassName = "DateChooser"
  override protected val pickerIconPrompt: String = "SShow Date Chooser"
  protected val selectorFormat: DateItemSelectorFormat = dtSlFmtNull
  protected val startDate: Date = "1/1/1995"
  override protected val textAlign: AlignmentDyn = AlRight
  protected val textField: AutoChild = null
  protected val textFieldProperties: TextItemDyn = null
  protected val useMask: Bool = false
  protected val useSharedPicker: Bool = true
  protected val useTextField: Bool = false
  protected val yearSelector: AutoChild = null
  protected val yearSelectorProperties: SelectItemDyn = null
}