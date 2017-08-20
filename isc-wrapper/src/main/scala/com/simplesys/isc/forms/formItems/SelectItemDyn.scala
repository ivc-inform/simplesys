package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.DSRequestDyn

object SelectItemDyn {
  implicit def SelectItemtoJsonObject(in: SelectItemDyn): JsonObject = in json
  val className = "select"
}

class SelectItemDyn extends FormItemDyn with SelectItemDynInit {

  private[this] var _addUnknownValues: Bool = addUnknownValues
  def AddUnknownValues = _addUnknownValues
  def AddUnknownValues_=(value: Bool) {
    if (_addUnknownValues == value) return
    json("addUnknownValues") = value
    _addUnknownValues = value
  }

  private[this] var _allowEmptyValue: Bool = allowEmptyValue
  def AllowEmptyValue = _allowEmptyValue
  def AllowEmptyValue_=(value: Bool) {
    if (_allowEmptyValue == value) return
    json("allowEmptyValue") = value
    _allowEmptyValue = value
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

  private[this] var _controlStyle: FormItemBaseStyle = controlStyle
  def ControlStyle = _controlStyle
  def ControlStyle_=(value: FormItemBaseStyle) {
    if (_controlStyle == value) return
    json("controlStyle") = value
    _controlStyle = value
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

  private[this] var _hiliteColor: Color = hiliteColor
  def HiliteColor = _hiliteColor
  def HiliteColor_=(value: Color) {
    if (_hiliteColor == value) return
    json("hiliteColor") = value
    _hiliteColor = value
  }

  private[this] var _hiliteOnFocus: Bool = hiliteOnFocus
  def HiliteOnFocus = _hiliteOnFocus
  def HiliteOnFocus_=(value: Bool) {
    if (_hiliteOnFocus == value) return
    json("hiliteOnFocus") = value
    _hiliteOnFocus = value
  }

  private[this] var _hiliteTextColor: Color = hiliteTextColor
  def HiliteTextColor = _hiliteTextColor
  def HiliteTextColor_=(value: Color) {
    if (_hiliteTextColor == value) return
    json("hiliteTextColor") = value
    _hiliteTextColor = value
  }

  private[this] var _multiple: Bool = multiple
  def Multiple = _multiple
  def Multiple_=(value: Bool) {
    if (_multiple == value) return
    json("multiple") = value
    _multiple = value
  }

  private[this] var _multipleAppearance: MultipleAppearance = multipleAppearance
  def MultipleAppearance = _multipleAppearance
  def MultipleAppearance_=(value: MultipleAppearance) {
    if (_multipleAppearance == value) return
    json("multipleAppearance") = value
    _multipleAppearance = value
  }

  private[this] var _optionFilterContext: DSRequestDyn = optionFilterContext
  override def OptionFilterContext = _optionFilterContext
  def OptionFilterContext_=(value: DSRequestDyn) {
    if (_optionFilterContext == value) return
    json("optionFilterContext") = value
    _optionFilterContext = value
  }

  private[this] var _pickButtonHeight: Number = pickButtonHeight
  def PickButtonHeight = _pickButtonHeight
  def PickButtonHeight_=(value: Number) {
    if (_pickButtonHeight == value) return
    json("pickButtonHeight") = value
    _pickButtonHeight = value
  }

  private[this] var _pickButtonSrc: String = pickButtonSrc
  def PickButtonSrc = _pickButtonSrc
  def PickButtonSrc_=(value: String) {
    if (_pickButtonSrc == value) return
    json("pickButtonSrc") = value
    _pickButtonSrc = value
  }

  private[this] var _pickButtonWidth: Number = pickButtonWidth
  def PickButtonWidth = _pickButtonWidth
  def PickButtonWidth_=(value: Number) {
    if (_pickButtonWidth == value) return
    json("pickButtonWidth") = value
    _pickButtonWidth = value
  }

  private[this] var _pickerIconStyle: FormItemBaseStyle = pickerIconStyle
  def PickerIconStyle = _pickerIconStyle
  def PickerIconStyle_=(value: FormItemBaseStyle) {
    if (_pickerIconStyle == value) return
    json("pickerIconStyle") = value
    _pickerIconStyle = value
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

  private[this] var _showHintInField: Bool = showHintInField
  def ShowHintInField = _showHintInField
  def ShowHintInField_=(value: Bool) {
    if (_showHintInField == value) return
    json("showHintInField") = value
    _showHintInField = value
  }

  private[this] var _showOptionsFromDataSource: Bool = showOptionsFromDataSource
  def ShowOptionsFromDataSource = _showOptionsFromDataSource
  def ShowOptionsFromDataSource_=(value: Bool) {
    if (_showOptionsFromDataSource == value) return
    json("showOptionsFromDataSource") = value
    _showOptionsFromDataSource = value
  }

  private[this] var _showOver: Bool = showOver
  def ShowOver = _showOver
  def ShowOver_=(value: Bool) {
    if (_showOver == value) return
    json("showOver") = value
    _showOver = value
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



