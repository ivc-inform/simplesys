package com.simplesys.isc.forms.formItems

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.DSRequestDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.CSSStyleName

object PickListDyn {
  implicit def PickListtoJsonObject(in: PickListDyn): JsonObject = in json
}

class PickListDyn extends ClassDyn with PickListDynInit {
  private[this] var _animatePickList: Bool = animatePickList
  def AnimatePickList = _animatePickList
  def AnimatePickList_=(value: Bool) {
    if (_animatePickList == value) return
    json("animatePickList") = value
    _animatePickList = value
  }

  private[this] var _animationTime: Number = animationTime
  def AnimationTime = _animationTime
  def AnimationTime_=(value: Number) {
    if (_animationTime == value) return
    json("animationTime") = value
    _animationTime = value
  }

  private[this] var _cachePickListResults: Bool = cachePickListResults
  def CachePickListResults = _cachePickListResults
  def CachePickListResults_=(value: Bool) {
    if (_cachePickListResults == value) return
    json("cachePickListResults") = value
    _cachePickListResults = value
  }

  private[this] var _displayField: String = displayField
  def DisplayField = _displayField
  def DisplayField_=(value: String) {
    if (_displayField == value) return
    json("displayField") = value
    _displayField = value
  }

  private[this] var _emptyPickListHeight: Number = emptyPickListHeight
  def EmptyPickListHeight = _emptyPickListHeight
  def EmptyPickListHeight_=(value: Number) {
    if (_emptyPickListHeight == value) return
    json("emptyPickListHeight") = value
    _emptyPickListHeight = value
  }

  private[this] var _emptyPickListMessage: String = emptyPickListMessage
  def EmptyPickListMessage = _emptyPickListMessage
  def EmptyPickListMessage_=(value: String) {
    if (_emptyPickListMessage == value) return
    json("emptyPickListMessage") = value
    _emptyPickListMessage = value
  }

  private[this] var _fetchDelay: Number = fetchDelay
  def FetchDelay = _fetchDelay
  def FetchDelay_=(value: Number) {
    if (_fetchDelay == value) return
    json("fetchDelay") = value
    _fetchDelay = value
  }

  private[this] var _fetchDisplayedFieldsOnly: Bool = fetchDisplayedFieldsOnly
  def FetchDisplayedFieldsOnly = _fetchDisplayedFieldsOnly
  def FetchDisplayedFieldsOnly_=(value: Bool) {
    if (_fetchDisplayedFieldsOnly == value) return
    json("fetchDisplayedFieldsOnly") = value
    _fetchDisplayedFieldsOnly = value
  }

  private[this] var _filterLocally: Bool = filterLocally
  def FilterLocally = _filterLocally
  def FilterLocally_=(value: Bool) {
    if (_filterLocally == value) return
    json("filterLocally") = value
    _filterLocally = value
  }

  private[this] var _hideEmptyPickList: Bool = hideEmptyPickList
  def HideEmptyPickList = _hideEmptyPickList
  def HideEmptyPickList_=(value: Bool) {
    if (_hideEmptyPickList == value) return
    json("hideEmptyPickList") = value
    _hideEmptyPickList = value
  }

  def OptionDataSource = json.getJsonElement("optionDataSource").getOrElse(optionDataSource)
  def OptionDataSource_=(value: JsonElement) {
    if (OptionDataSource == value) return
    json("optionDataSource") = value
  }

  private[this] var _optionFilterContext: DSRequestDyn = optionFilterContext
  def OptionFilterContext = _optionFilterContext
  def OptionFilterContext_=(value: DSRequestDyn) {
    if (_optionFilterContext == value) return
    json("optionFilterContext") = value
    _optionFilterContext = value
  }

  private[this] var _pickListBaseStyle: CSSStyleName = pickListBaseStyle
  def PickListBaseStyle = _pickListBaseStyle
  def PickListBaseStyle_=(value: CSSStyleName) {
    if (_pickListBaseStyle == value) return
    json("pickListBaseStyle") = value
    _pickListBaseStyle = value
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

  private[this] var _pickListHeaderHeight: Number = pickListHeaderHeight
  def PickListHeaderHeight = _pickListHeaderHeight
  def PickListHeaderHeight_=(value: Number) {
    if (_pickListHeaderHeight == value) return
    json("pickListHeaderHeight") = value
    _pickListHeaderHeight = value
  }

  private[this] var _pickListHeight: Number = pickListHeight
  def PickListHeight = _pickListHeight
  def PickListHeight_=(value: Number) {
    if (_pickListHeight == value) return
    json("pickListHeight") = value
    _pickListHeight = value
  }

  private[this] var _pickListMaxWidth: Number = pickListMaxWidth
  def PickListMaxWidth = _pickListMaxWidth
  def PickListMaxWidth_=(value: Number) {
    if (_pickListMaxWidth == value) return
    json("pickListMaxWidth") = value
    _pickListMaxWidth = value
  }

  private[this] var _pickListProperties: PickListDyn = pickListProperties
  def PickListProperties = _pickListProperties
  def PickListProperties_=(value: PickListDyn) {
    if (_pickListProperties == value) return
    json("pickListProperties") = value
    _pickListProperties = value
  }

  private[this] var _pickListTallBaseStyle: CSSStyleName = pickListTallBaseStyle
  def PickListTallBaseStyle = _pickListTallBaseStyle
  def PickListTallBaseStyle_=(value: CSSStyleName) {
    if (_pickListTallBaseStyle == value) return
    json("pickListTallBaseStyle") = value
    _pickListTallBaseStyle = value
  }

  private[this] var _pickListWidth: Number = pickListWidth
  def PickListWidth = _pickListWidth
  def PickListWidth_=(value: Number) {
    if (_pickListWidth == value) return
    json("pickListWidth") = value
    _pickListWidth = value
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

  private[this] var _valueField: String = valueField
  def ValueField = _valueField
  def ValueField_=(value: String) {
    if (_valueField == value) return
    json("valueField") = value
    _valueField = value
  }

  private[this] var _valueIconField: String = valueIconField
  def ValueIconField = _valueIconField
  def ValueIconField_=(value: String) {
    if (_valueIconField == value) return
    json("valueIconField") = value
    _valueIconField = value
  }
}

