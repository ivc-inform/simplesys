package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonNull, JsonList}
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.DSRequestDyn
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.system.ArrayDyn

trait PickListDynInit {
  protected val animatePickList: Bool = false
  protected val animationTime: Number = 200
  protected val cachePickListResults: Bool = true
  protected val displayField: String = ""
  protected val emptyPickListHeight: Number = 100
  protected val emptyPickListMessage: String = ""
  protected val fetchDelay: Number = 200
  protected val fetchDisplayedFieldsOnly: Bool = false
  protected val filterLocally: Bool = false
  protected val hideEmptyPickList: Bool = false
  protected val optionDataSource: JsonElement = JsonNull
  protected val optionFilterContext: DSRequestDyn = null
  protected val pickListBaseStyle: CSSStyleName = "pickListCell"
  protected val pickListCriteria: CriteriaDyn = null
  protected val pickListFields: JsonList = JsonList()
  protected val pickListHeaderHeight: Number = 22
  protected val pickListHeight: Number = 300
  protected val pickListMaxWidth: Number = 400
  protected val pickListProperties: PickListDyn = null
  protected val pickListTallBaseStyle: CSSStyleName = ""
  protected val pickListWidth: Number = null
  protected val separatorRows: ArrayDyn[ListGridRecordDyn] = null
  protected val showAllOptions: Bool = false
  protected val showOptionsFromDataSource: Bool = false
  protected val sortField: Number = null
  protected val textMatchStyle: TextMatchStyle = txtMchStyleStartWith
  protected val valueField: String = ""
  protected val valueIconField: String = ""
}