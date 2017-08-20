package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonBoolean, JsonList}
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.DSRequestDyn
import com.simplesys.isc.system.ArrayDyn

trait ComboBoxItemDynInit extends TextItemDynInit {
  protected val addUnknownValues: Bool = true
  protected val autoFetchData: Bool = false
  protected val cachePickListResults: Bool = true
  protected val completeOnTab: Bool = false
  protected val defaultToFirstOption: Bool = false
  override protected val defaultValue: JsonBoolean = JsonBoolean(false)
  override protected val displayField: String = ""
  protected val fetchDisplayedFieldsOnly: Bool = false
  protected val filterFields: JsonList = JsonList()
  override protected val filterLocally: Bool = false
  protected val filterWithValue: Bool = false
  protected val generateExactMatchCriteria: Bool = false
  override protected val optionFilterContext: DSRequestDyn = null
  override protected val optionOperationId: String = ""
  protected val pendingTextBoxStyle: CSSStyleName = ""
  override protected val pickerIconHeight: Number = null
  override protected val pickerIconSrc: SCImgURL = "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
  override protected val pickerIconWidth: Number = 15
  protected val pickListCriteria: CriteriaDyn = null
  protected val pickListFields: JsonList = JsonList()
  protected val pickListProperties: PickListDyn = null
  override protected val saveOnEnter: Bool = true
  protected val separatorRows: ArrayDyn[ListGridRecordDyn] = null
  protected val showAllOptions: Bool = false
  override protected val showHintInField: Bool = false
  protected val showOptionsFromDataSource: Bool = false
  override protected val showPickerIcon: Bool = true
  protected val showPickListOnKeypress: Bool = true
  protected val sortField: Number = null
  protected val textMatchStyle: TextMatchStyle = txtMchStyleStartWith
  override protected val valueField: String = ""
}