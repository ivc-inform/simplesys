package com.simplesys.isc.forms

import com.simplesys.json._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.LayoutDyn
import com.simplesys.isc.dataBinging.dataSource.AdvancedCriteriaDyn
import formItems.FormItemDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc.Bool

object FilterBuilderDyn {

  implicit def FilterBuilder2JsonObject(in: FilterBuilderDyn): JsonObject = in json
}

class FilterBuilderDyn(override val useSelfName: Boolean = false) extends LayoutDyn with FilterBuilderDynInit {
  override val selfName = "FilterBuilder"

  private[this] var _addButton: AutoChild = addButton
  def AddButton = _addButton
  def AddButton_=(value: AutoChild) {
    if (_addButton == value) return
    json("addButton") = value
    _addButton = value
  }

  private[this] var _addButtonPrompt: String = addButtonPrompt
  def AddButtonPrompt = _addButtonPrompt
  def AddButtonPrompt_=(value: String) {
    if (_addButtonPrompt == value) return
    json("addButtonPrompt") = value
    _addButtonPrompt = value
  }

  private[this] var _allowEmpty: Bool = allowEmpty
  def AllowEmpty = _allowEmpty
  def AllowEmpty_=(value: Bool) {
    if (_allowEmpty == value) return
    json("allowEmpty") = value
    _allowEmpty = value
  }

  private[this] var _bracket: AutoChild = bracket
  def Bracket = _bracket
  def Bracket_=(value: AutoChild) {
    if (_bracket == value) return
    json("bracket") = value
    _bracket = value
  }

  private[this] var _clauseStack: AutoChild = clauseStack
  def ClauseStack = _clauseStack
  def ClauseStack_=(value: AutoChild) {
    if (_clauseStack == value) return
    json("clauseStack") = value
    _clauseStack = value
  }

  private[this] var _criteria: AdvancedCriteriaDyn = criteria
  def Criteria = _criteria
  def Criteria_=(value: AdvancedCriteriaDyn) {
    if (_criteria == value) return
    json("criteria") = value
    _criteria = value
  }

  def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
  def DataSource_=(value: JsonElement) {
    if (DataSource == value) return
    json("dataSource") = value
  }

  private[this] var _defaultSubClauseOperator: LogicalOperator = defaultSubClauseOperator
  def DefaultSubClauseOperator = _defaultSubClauseOperator
  def DefaultSubClauseOperator_=(value: LogicalOperator) {
    if (_defaultSubClauseOperator == value) return
    json("defaultSubClauseOperator") = value
    _defaultSubClauseOperator = value
  }

  def FieldDataSource = json.getJsonElement("fieldDataSource").getOrElse(fieldDataSource)
  def FieldDataSource_=(value: JsonElement) {
    if (FieldDataSource == value) return
    json("fieldDataSource") = value
  }

  private[this] var _fieldPicker: AutoChild = fieldPicker
  def FieldPicker = _fieldPicker
  def FieldPicker_=(value: AutoChild) {
    if (_fieldPicker == value) return
    json("fieldPicker") = value
    _fieldPicker = value
  }

  private[this] var _fieldPickerProperties: FormItemDyn = fieldPickerProperties
  def FieldPickerProperties = _fieldPickerProperties
  def FieldPickerProperties_=(value: FormItemDyn) {
    if (_fieldPickerProperties == value) return
    json("fieldPickerProperties") = value
    _fieldPickerProperties = value
  }

  private[this] var _fieldPickerTitle: String = fieldPickerTitle
  def FieldPickerTitle = _fieldPickerTitle
  def FieldPickerTitle_=(value: String) {
    if (_fieldPickerTitle == value) return
    json("fieldPickerTitle") = value
    _fieldPickerTitle = value
  }

  private[this] var _filterChanged: FunctionExpression = filterChanged
  def FilterChanged = _filterChanged
  def FilterChanged_=(value: FunctionExpression) {
    if (_filterChanged == value) return
    json("filterChanged") = value
    _filterChanged = value
  }

  private[this] var _inlineAndNotTitle: String = inlineAndNotTitle
  def InlineAndNotTitle = _inlineAndNotTitle
  def InlineAndNotTitle_=(value: String) {
    if (_inlineAndNotTitle == value) return
    json("inlineAndNotTitle") = value
    _inlineAndNotTitle = value
  }

  private[this] var _inlineAndTitle: String = inlineAndTitle
  def InlineAndTitle = _inlineAndTitle
  def InlineAndTitle_=(value: String) {
    if (_inlineAndTitle == value) return
    json("inlineAndTitle") = value
    _inlineAndTitle = value
  }

  private[this] var _inlineOrTitle: String = inlineOrTitle
  def InlineOrTitle = _inlineOrTitle
  def InlineOrTitle_=(value: String) {
    if (_inlineOrTitle == value) return
    json("inlineOrTitle") = value
    _inlineOrTitle = value
  }

  private[this] var _matchAllTitle: String = matchAllTitle
  def MatchAllTitle = _matchAllTitle
  def MatchAllTitle_=(value: String) {
    if (_matchAllTitle == value) return
    json("matchAllTitle") = value
    _matchAllTitle = value
  }

  private[this] var _matchAnyTitle: String = matchAnyTitle
  def MatchAnyTitle = _matchAnyTitle
  def MatchAnyTitle_=(value: String) {
    if (_matchAnyTitle == value) return
    json("matchAnyTitle") = value
    _matchAnyTitle = value
  }

  private[this] var _matchNoneTitle: String = matchNoneTitle
  def MatchNoneTitle = _matchNoneTitle
  def MatchNoneTitle_=(value: String) {
    if (_matchNoneTitle == value) return
    json("matchNoneTitle") = value
    _matchNoneTitle = value
  }

  private[this] var _missingFieldPrompt: String = missingFieldPrompt
  def MissingFieldPrompt = _missingFieldPrompt
  def MissingFieldPrompt_=(value: String) {
    if (_missingFieldPrompt == value) return
    json("missingFieldPrompt") = value
    _missingFieldPrompt = value
  }

  private[this] var _operatorPickerTitle: String = operatorPickerTitle
  def OperatorPickerTitle = _operatorPickerTitle
  def OperatorPickerTitle_=(value: String) {
    if (_operatorPickerTitle == value) return
    json("operatorPickerTitle") = value
    _operatorPickerTitle = value
  }

  private[this] var _radioOperatorForm: AutoChild = radioOperatorForm
  def RadioOperatorForm = _radioOperatorForm
  def RadioOperatorForm_=(value: AutoChild) {
    if (_radioOperatorForm == value) return
    json("radioOperatorForm") = value
    _radioOperatorForm = value
  }

  private[this] var _radioOperatorTitle: String = radioOperatorTitle
  def RadioOperatorTitle = _radioOperatorTitle
  def RadioOperatorTitle_=(value: String) {
    if (_radioOperatorTitle == value) return
    json("radioOperatorTitle") = value
    _radioOperatorTitle = value
  }

  def RadioOptions = json.getJsonListOpt("radioOptions").getOrElse(radioOptions)
  def RadioOptions_=(value: JsonList) {
    if (RadioOptions == value) return
    json("radioOptions") = value
  }

  private[this] var _rangeSeparator: String = rangeSeparator
  def RangeSeparator = _rangeSeparator
  def RangeSeparator_=(value: String) {
    if (_rangeSeparator == value) return
    json("rangeSeparator") = value
    _rangeSeparator = value
  }

  private[this] var _removeButton: AutoChild = removeButton
  def RemoveButton = _removeButton
  def RemoveButton_=(value: AutoChild) {
    if (_removeButton == value) return
    json("removeButton") = value
    _removeButton = value
  }

  private[this] var _removeButtonPrompt: String = removeButtonPrompt
  def RemoveButtonPrompt = _removeButtonPrompt
  def RemoveButtonPrompt_=(value: String) {
    if (_removeButtonPrompt == value) return
    json("removeButtonPrompt") = value
    _removeButtonPrompt = value
  }

  private[this] var _retainValuesAcrossFields: Bool = retainValuesAcrossFields
  def RetainValuesAcrossFields = _retainValuesAcrossFields
  def RetainValuesAcrossFields_=(value: Bool) {
    if (_retainValuesAcrossFields == value) return
    json("retainValuesAcrossFields") = value
    _retainValuesAcrossFields = value
  }

  private[this] var _saveOnEnter: Bool = saveOnEnter
  def SaveOnEnter = _saveOnEnter
  def SaveOnEnter_=(value: Bool) {
    if (_saveOnEnter == value) return
    json("saveOnEnter") = value
    _saveOnEnter = value
  }

  private[this] var _showAddButton: Bool = showAddButton
  def ShowAddButton = _showAddButton
  def ShowAddButton_=(value: Bool) {
    if (_showAddButton == value) return
    json("showAddButton") = value
    _showAddButton = value
  }

  private[this] var _showFieldTitles: Bool = showFieldTitles
  def ShowFieldTitles = _showFieldTitles
  def ShowFieldTitles_=(value: Bool) {
    if (_showFieldTitles == value) return
    json("showFieldTitles") = value
    _showFieldTitles = value
  }

  private[this] var _showRemoveButton: Bool = showRemoveButton
  def ShowRemoveButton = _showRemoveButton
  def ShowRemoveButton_=(value: Bool) {
    if (_showRemoveButton == value) return
    json("showRemoveButton") = value
    _showRemoveButton = value
  }

  private[this] var _showSelectionCheckbox: Bool = showSelectionCheckbox
  def ShowSelectionCheckbox = _showSelectionCheckbox
  def ShowSelectionCheckbox_=(value: Bool) {
    if (_showSelectionCheckbox == value) return
    json("showSelectionCheckbox") = value
    _showSelectionCheckbox = value
  }

  private[this] var _showSubClauseButton: Bool = showSubClauseButton
  def ShowSubClauseButton = _showSubClauseButton
  def ShowSubClauseButton_=(value: Bool) {
    if (_showSubClauseButton == value) return
    json("showSubClauseButton") = value
    _showSubClauseButton = value
  }

  private[this] var _subClauseButton: AutoChild = subClauseButton
  def SubClauseButton = _subClauseButton
  def SubClauseButton_=(value: AutoChild) {
    if (_subClauseButton == value) return
    json("subClauseButton") = value
    _subClauseButton = value
  }

  private[this] var _subClauseButtonPrompt: String = subClauseButtonPrompt
  def SubClauseButtonPrompt = _subClauseButtonPrompt
  def SubClauseButtonPrompt_=(value: String) {
    if (_subClauseButtonPrompt == value) return
    json("subClauseButtonPrompt") = value
    _subClauseButtonPrompt = value
  }

  private[this] var _subClauseButtonTitle: String = subClauseButtonTitle
  def SubClauseButtonTitle = _subClauseButtonTitle
  def SubClauseButtonTitle_=(value: String) {
    if (_subClauseButtonTitle == value) return
    json("subClauseButtonTitle") = value
    _subClauseButtonTitle = value
  }

  private[this] var _topOperator: LogicalOperator = topOperator
  def TopOperator = _topOperator
  def TopOperator_=(value: LogicalOperator) {
    if (_topOperator == value) return
    json("topOperator") = value
    _topOperator = value
  }

  private[this] var _topOperatorAppearance: TopOperatorAppearance = topOperatorAppearance
  def TopOperatorAppearance = _topOperatorAppearance
  def TopOperatorAppearance_=(value: TopOperatorAppearance) {
    if (_topOperatorAppearance == value) return
    json("topOperatorAppearance") = value
    _topOperatorAppearance = value
  }

  private[this] var _topOperatorForm: AutoChild = topOperatorForm
  def TopOperatorForm = _topOperatorForm
  def TopOperatorForm_=(value: AutoChild) {
    if (_topOperatorForm == value) return
    json("topOperatorForm") = value
    _topOperatorForm = value
  }

  private[this] var _topOperatorTitle: String = topOperatorTitle
  def TopOperatorTitle = _topOperatorTitle
  def TopOperatorTitle_=(value: String) {
    if (_topOperatorTitle == value) return
    json("topOperatorTitle") = value
    _topOperatorTitle = value
  }

  private[this] var _validateOnChange: Bool = validateOnChange
  def ValidateOnChange = _validateOnChange
  def ValidateOnChange_=(value: Bool) {
    if (_validateOnChange == value) return
    json("validateOnChange") = value
    _validateOnChange = value
  }
}