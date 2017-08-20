package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.dataBinging.DSRequestDyn
import formItem.FormItemIconDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.json.JsonList

trait SelectItemDynInit extends FormItemDynInit {
  protected val addUnknownValues: Bool = true
  protected val allowEmptyValue: Bool = false
  protected val autoFetchData: Bool = true
  protected val cachePickListResults: Bool = true
  protected val controlStyle: FormItemBaseStyle = "selectItemControl"
  protected val defaultToFirstOption: Bool = false
  override protected val displayField: String = ""
  protected val fetchDisplayedFieldsOnly: Bool = false
  override protected val filterLocally: Bool = false
  override protected val height: Number = 19
  protected val hiliteColor: Color = "#316AC5"
  protected val hiliteOnFocus: Bool = true
  protected val hiliteTextColor: Color = "white"
  protected val multiple: Bool = false
  protected val multipleAppearance: MultipleAppearance = mlApprncPicklist
  override protected val optionFilterContext: DSRequestDyn = null
  override protected val optionOperationId: String = ""
  protected val pickButtonHeight: Number = null
  protected val pickButtonSrc: String = ""
  protected val pickButtonWidth: Number = null
  override protected val pickerIconHeight: Number = null
  override protected val pickerIconProperties: FormItemIconDyn = null
  override protected val pickerIconSrc: SCImgURL = "[SKIN]/DynamicForm/SelectItem_PickButton_icon.gif"
  protected val pickerIconStyle: FormItemBaseStyle = "selectItemPickerIcon"
  override protected val pickerIconWidth: Number = null
  protected val pickListCriteria: CriteriaDyn = null
  protected val pickListFields: JsonList = JsonList()
  protected val pickListProperties: PickListDyn = null
  override protected val saveOnEnter: Bool = true
  override protected val showFocused: Bool = true
  protected val showHintInField: Bool = false
  protected val showOptionsFromDataSource: Bool = false
  protected val showOver: Bool = true
  override protected val showPickerIcon: Bool = true
  protected val sortField: Number = null
  override protected val textBoxStyle: FormItemBaseStyle = "selectItemText"
  protected val textMatchStyle: TextMatchStyle = txtMchStyleStartWith
  override protected val valueField: String = ""
  override protected val __type: FormItemType = frmitmtpSelect
}