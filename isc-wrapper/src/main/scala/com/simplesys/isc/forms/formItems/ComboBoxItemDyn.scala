package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.grids.ListGridRecordDyn

object ComboBoxItemDyn {
  implicit def ComboBoxItemtoJsonObject(in: ComboBoxItemDyn): JsonObject = in json
  val className = "comboBox"
}

class ComboBoxItemDyn(override val useSelfName: Boolean = false) extends TextItemDyn with ComboBoxItemDynInit {
  override val selfName: String = " ComboBoxItem"

  private[this] var _addUnknownValues: Bool = addUnknownValues
  def AddUnknownValues = _addUnknownValues
  def AddUnknownValues_=(value: Bool) {
    if (_addUnknownValues == value) return
    json("addUnknownValues") = value
    _addUnknownValues = value
  }

  private[this] var _autoFetchData: Bool = autoFetchData
  def AutoFetchData = _autoFetchData
  def AutoFetchData_=(value: Bool) {
    if (_autoFetchData == value) return
    json("autoFetchData") = value
    _autoFetchData = value
  }

  private[this] var _cachePickListResults: Bool = cachePickListResults
  def CachePickListResults = _cachePickListResults
  def CachePickListResults_=(value: Bool) {
    if (_cachePickListResults == value) return
    json("cachePickListResults") = value
    _cachePickListResults = value
  }

  private[this] var _completeOnTab: Bool = completeOnTab
  def CompleteOnTab = _completeOnTab
  def CompleteOnTab_=(value: Bool) {
    if (_completeOnTab == value) return
    json("completeOnTab") = value
    _completeOnTab = value
  }

  private[this] var _defaultToFirstOption: Bool = defaultToFirstOption
  def DefaultToFirstOption = _defaultToFirstOption
  def DefaultToFirstOption_=(value: Bool) {
    if (_defaultToFirstOption == value) return
    json("defaultToFirstOption") = value
    _defaultToFirstOption = value
  }

  private[this] var _fetchDisplayedFieldsOnly: Bool = fetchDisplayedFieldsOnly
  def FetchDisplayedFieldsOnly = _fetchDisplayedFieldsOnly
  def FetchDisplayedFieldsOnly_=(value: Bool) {
    if (_fetchDisplayedFieldsOnly == value) return
    json("fetchDisplayedFieldsOnly") = value
    _fetchDisplayedFieldsOnly = value
  }

  private[this] var _filterFields: JsonList = filterFields
  def FilterFields = _filterFields
  def FilterFields_=(value: JsonList) {
    if (_filterFields == value) return
    json("filterFields") = value
    _filterFields = value
  }

  private[this] var _filterWithValue: Bool = filterWithValue
  def FilterWithValue = _filterWithValue
  def FilterWithValue_=(value: Bool) {
    if (_filterWithValue == value) return
    json("filterWithValue") = value
    _filterWithValue = value
  }

  private[this] var _generateExactMatchCriteria: Bool = generateExactMatchCriteria
  def GenerateExactMatchCriteria = _generateExactMatchCriteria
  def GenerateExactMatchCriteria_=(value: Bool) {
    if (_generateExactMatchCriteria == value) return
    json("generateExactMatchCriteria") = value
    _generateExactMatchCriteria = value
  }

  private[this] var _pendingTextBoxStyle: CSSStyleName = pendingTextBoxStyle
  def PendingTextBoxStyle = _pendingTextBoxStyle
  def PendingTextBoxStyle_=(value: CSSStyleName) {
    if (_pendingTextBoxStyle == value) return
    json("pendingTextBoxStyle") = value
    _pendingTextBoxStyle = value
  }

  private[this] var _pickListCriteria: CriteriaDyn = pickListCriteria
  def PickListCriteria = _pickListCriteria
  def PickListCriteria_=(value: CriteriaDyn) {
    if (_pickListCriteria == value) return
    json("pickListCriteria") = value
    _pickListCriteria = value
  }

  private[this] var _pickListFields: JsonList = pickListFields
  def PickListFields = _pickListFields
  def PickListFields_=(value: JsonList) {
    if (_pickListFields == value) return
    json("pickListFields") = value
    _pickListFields = value
  }

  private[this] var _pickListProperties: PickListDyn = pickListProperties
  def PickListProperties = _pickListProperties
  def PickListProperties_=(value: PickListDyn) {
    if (_pickListProperties == value) return
    json("pickListProperties") = value
    _pickListProperties = value
  }

  private[this] var _separatorRows: ArrayDyn[ListGridRecordDyn] = separatorRows
  def SeparatorRows = _separatorRows
  def SeparatorRows_=(value: ArrayDyn[ListGridRecordDyn]) {
    if (_separatorRows == value) return
    json("separatorRows") = value
    _separatorRows = value
  }

  private[this] var _showAllOptions: Bool = showAllOptions
  def ShowAllOptions = _showAllOptions
  def ShowAllOptions_=(value: Bool) {
    if (_showAllOptions == value) return
    json("showAllOptions") = value
    _showAllOptions = value
  }

  private[this] var _showOptionsFromDataSource: Bool = showOptionsFromDataSource
  def ShowOptionsFromDataSource = _showOptionsFromDataSource
  def ShowOptionsFromDataSource_=(value: Bool) {
    if (_showOptionsFromDataSource == value) return
    json("showOptionsFromDataSource") = value
    _showOptionsFromDataSource = value
  }

  private[this] var _showPickListOnKeypress: Bool = showPickListOnKeypress
  def ShowPickListOnKeypress = _showPickListOnKeypress
  def ShowPickListOnKeypress_=(value: Bool) {
    if (_showPickListOnKeypress == value) return
    json("showPickListOnKeypress") = value
    _showPickListOnKeypress = value
  }

  private[this] var _sortField: Number = sortField
  def SortField = _sortField
  def SortField_=(value: Number) {
    if (_sortField == value) return
    json("sortField") = value
    _sortField = value
  }

  private[this] var _textMatchStyle: TextMatchStyle = textMatchStyle
  def TextMatchStyle = _textMatchStyle
  def TextMatchStyle_=(value: TextMatchStyle) {
    if (_textMatchStyle == value) return
    json("textMatchStyle") = value
    _textMatchStyle = value
  }
}


