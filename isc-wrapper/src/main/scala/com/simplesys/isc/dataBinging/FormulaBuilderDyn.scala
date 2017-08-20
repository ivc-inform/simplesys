package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonElement, UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.VLayoutDyn
import com.simplesys.isc.forms.formItems.TextItemDyn
import com.simplesys.isc.control.ButtonDyn
import com.simplesys.isc.grids.ListGridDyn
import com.simplesys.isc.forms.formItems.formItem.FormItemIconDyn
import com.simplesys.isc.foundation.LabelDyn
import dataSource.RecordDyn
import com.simplesys.isc.system.ArrayDyn

object FormulaBuilderDyn {
  implicit def FormulaBuilder2JsonObject(in: FormulaBuilderDyn): JsonObject = in json
}

class FormulaBuilderDyn(override val useSelfName: Boolean = false) extends VLayoutDyn with FormulaBuilderDynInit {
  override val selfName = "FormulaBuilder"

  private[this] var _autoHideCheckBox: TextItemDyn = autoHideCheckBox
  def AutoHideCheckBox = _autoHideCheckBox
  def AutoHideCheckBox_=(value: TextItemDyn) {
    if (_autoHideCheckBox == value) return
    json("autoHideCheckBox") = value
    _autoHideCheckBox = value
  }

  private[this] var _autoHideCheckBoxLabel: String = autoHideCheckBoxLabel
  def AutoHideCheckBoxLabel = _autoHideCheckBoxLabel
  def AutoHideCheckBoxLabel_=(value: String) {
    if (_autoHideCheckBoxLabel == value) return
    json("autoHideCheckBoxLabel") = value
    _autoHideCheckBoxLabel = value
  }

  private[this] var _autoTest: Bool = autoTest
  def AutoTest = _autoTest
  def AutoTest_=(value: Bool) {
    if (_autoTest == value) return
    json("autoTest") = value
    _autoTest = value
  }

  private[this] var _autoTestDelay: Number = autoTestDelay
  def AutoTestDelay = _autoTestDelay
  def AutoTestDelay_=(value: Number) {
    if (_autoTestDelay == value) return
    json("autoTestDelay") = value
    _autoTestDelay = value
  }

  private[this] var _builderTypeText: String = builderTypeText
  def BuilderTypeText = _builderTypeText
  def BuilderTypeText_=(value: String) {
    if (_builderTypeText == value) return
    json("builderTypeText") = value
    _builderTypeText = value
  }

  private[this] var _cancelButton: ButtonDyn = cancelButton
  def CancelButton = _cancelButton
  def CancelButton_=(value: ButtonDyn) {
    if (_cancelButton == value) return
    json("cancelButton") = value
    _cancelButton = value
  }

  private[this] var _cancelButtonTitle: String = cancelButtonTitle
  def CancelButtonTitle = _cancelButtonTitle
  def CancelButtonTitle_=(value: String) {
    if (_cancelButtonTitle == value) return
    json("cancelButtonTitle") = value
    _cancelButtonTitle = value
  }

  private[this] var _cancelled: Bool = cancelled
  def Cancelled = _cancelled
  def Cancelled_=(value: Bool) {
    if (_cancelled == value) return
    json("cancelled") = value
    _cancelled = value
  }

  def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
  def DataSource_=(value: JsonElement) {
    if (DataSource == value) return
    json("dataSource") = value
  }

  private[this] var _defaultErrorText: String = defaultErrorText
  def DefaultErrorText = _defaultErrorText
  def DefaultErrorText_=(value: String) {
    if (_defaultErrorText == value) return
    json("defaultErrorText") = value
    _defaultErrorText = value
  }

  private[this] var _defaultNewFieldTitle: String = defaultNewFieldTitle
  def DefaultNewFieldTitle = _defaultNewFieldTitle
  def DefaultNewFieldTitle_=(value: String) {
    if (_defaultNewFieldTitle == value) return
    json("defaultNewFieldTitle") = value
    _defaultNewFieldTitle = value
  }

  private[this] var _editMode: Bool = editMode
  def EditMode = _editMode
  def EditMode_=(value: Bool) {
    if (_editMode == value) return
    json("editMode") = value
    _editMode = value
  }

  private[this] var _field: DataSourceFieldDyn = field
  def Field = _field
  def Field_=(value: DataSourceFieldDyn) {
    if (_field == value) return
    json("field") = value
    _field = value
  }

  private[this] var _fieldKey: ListGridDyn = fieldKey
  def FieldKey = _fieldKey
  def FieldKey_=(value: ListGridDyn) {
    if (_fieldKey == value) return
    json("fieldKey") = value
    _fieldKey = value
  }

  private[this] var _fields: ArrayDyn[DataSourceFieldDyn] = fields
  def Fields = _fields
  def Fields_=(value: ArrayDyn[DataSourceFieldDyn]) {
    if (_fields == value) return
    json("fields") = value
    _fields = value
  }

  private[this] var _fireOnClose: FunctionExpression = fireOnClose
  def FireOnClose = _fireOnClose
  def FireOnClose_=(value: FunctionExpression) {
    if (_fireOnClose == value) return
    json("fireOnClose") = value
    _fireOnClose = value
  }

  private[this] var _formulaField: TextItemDyn = formulaField
  def FormulaField = _formulaField
  def FormulaField_=(value: TextItemDyn) {
    if (_formulaField == value) return
    json("formulaField") = value
    _formulaField = value
  }

  private[this] var _helpIcon: FormItemIconDyn = helpIcon
  def HelpIcon = _helpIcon
  def HelpIcon_=(value: FormItemIconDyn) {
    if (_helpIcon == value) return
    json("helpIcon") = value
    _helpIcon = value
  }

  private[this] var _helpTextIntro: HTMLString = helpTextIntro
  def HelpTextIntro = _helpTextIntro
  def HelpTextIntro_=(value: HTMLString) {
    if (_helpTextIntro == value) return
    json("helpTextIntro") = value
    _helpTextIntro = value
  }

  private[this] var _helpWindowTitle: String = helpWindowTitle
  def HelpWindowTitle = _helpWindowTitle
  def HelpWindowTitle_=(value: String) {
    if (_helpWindowTitle == value) return
    json("helpWindowTitle") = value
    _helpWindowTitle = value
  }

  private[this] var _instructions: LabelDyn = instructions
  def Instructions = _instructions
  def Instructions_=(value: LabelDyn) {
    if (_instructions == value) return
    json("instructions") = value
    _instructions = value
  }

  private[this] var _instructionsTextStart: String = instructionsTextStart
  def InstructionsTextStart = _instructionsTextStart
  def InstructionsTextStart_=(value: String) {
    if (_instructionsTextStart == value) return
    json("instructionsTextStart") = value
    _instructionsTextStart = value
  }

  private[this] var _invalidBlankPrompt: String = invalidBlankPrompt
  def InvalidBlankPrompt = _invalidBlankPrompt
  def InvalidBlankPrompt_=(value: String) {
    if (_invalidBlankPrompt == value) return
    json("invalidBlankPrompt") = value
    _invalidBlankPrompt = value
  }

  private[this] var _invalidBuilderPrompt: String = invalidBuilderPrompt
  def InvalidBuilderPrompt = _invalidBuilderPrompt
  def InvalidBuilderPrompt_=(value: String) {
    if (_invalidBuilderPrompt == value) return
    json("invalidBuilderPrompt") = value
    _invalidBuilderPrompt = value
  }

  private[this] var _invalidGeneratedFunctionPrompt: String = invalidGeneratedFunctionPrompt
  def InvalidGeneratedFunctionPrompt = _invalidGeneratedFunctionPrompt
  def InvalidGeneratedFunctionPrompt_=(value: String) {
    if (_invalidGeneratedFunctionPrompt == value) return
    json("invalidGeneratedFunctionPrompt") = value
    _invalidGeneratedFunctionPrompt = value
  }

  private[this] var _keyColumnTitle: String = keyColumnTitle
  def KeyColumnTitle = _keyColumnTitle
  def KeyColumnTitle_=(value: String) {
    if (_keyColumnTitle == value) return
    json("keyColumnTitle") = value
    _keyColumnTitle = value
  }

  private[this] var _mathFunctions: Strings = mathFunctions
  def MathFunctions = _mathFunctions
  def MathFunctions_=(value: Strings) {
    if (_mathFunctions == value) return
    json("mathFunctions") = value
    _mathFunctions = value
  }

  private[this] var _messageLabel: LabelDyn = messageLabel
  def MessageLabel = _messageLabel
  def MessageLabel_=(value: LabelDyn) {
    if (_messageLabel == value) return
    json("messageLabel") = value
    _messageLabel = value
  }

  private[this] var _sampleHeaderTitle: String = sampleHeaderTitle
  def SampleHeaderTitle = _sampleHeaderTitle
  def SampleHeaderTitle_=(value: String) {
    if (_sampleHeaderTitle == value) return
    json("sampleHeaderTitle") = value
    _sampleHeaderTitle = value
  }

  private[this] var _samplePrompt: HTMLString = samplePrompt
  def SamplePrompt = _samplePrompt
  def SamplePrompt_=(value: HTMLString) {
    if (_samplePrompt == value) return
    json("samplePrompt") = value
    _samplePrompt = value
  }

  private[this] var _saveAddAnotherButton: ButtonDyn = saveAddAnotherButton
  def SaveAddAnotherButton = _saveAddAnotherButton
  def SaveAddAnotherButton_=(value: ButtonDyn) {
    if (_saveAddAnotherButton == value) return
    json("saveAddAnotherButton") = value
    _saveAddAnotherButton = value
  }

  private[this] var _saveAddAnotherButtonTitle: String = saveAddAnotherButtonTitle
  def SaveAddAnotherButtonTitle = _saveAddAnotherButtonTitle
  def SaveAddAnotherButtonTitle_=(value: String) {
    if (_saveAddAnotherButtonTitle == value) return
    json("saveAddAnotherButtonTitle") = value
    _saveAddAnotherButtonTitle = value
  }

  private[this] var _saveButton: ButtonDyn = saveButton
  def SaveButton = _saveButton
  def SaveButton_=(value: ButtonDyn) {
    if (_saveButton == value) return
    json("saveButton") = value
    _saveButton = value
  }

  private[this] var _saveButtonTitle: String = saveButtonTitle
  def SaveButtonTitle = _saveButtonTitle
  def SaveButtonTitle_=(value: String) {
    if (_saveButtonTitle == value) return
    json("saveButtonTitle") = value
    _saveButtonTitle = value
  }

  private[this] var _saveConfirmationPrompt: String = saveConfirmationPrompt
  def SaveConfirmationPrompt = _saveConfirmationPrompt
  def SaveConfirmationPrompt_=(value: String) {
    if (_saveConfirmationPrompt == value) return
    json("saveConfirmationPrompt") = value
    _saveConfirmationPrompt = value
  }

  private[this] var _showAutoHideCheckBox: Bool = showAutoHideCheckBox
  def ShowAutoHideCheckBox = _showAutoHideCheckBox
  def ShowAutoHideCheckBox_=(value: Bool) {
    if (_showAutoHideCheckBox == value) return
    json("showAutoHideCheckBox") = value
    _showAutoHideCheckBox = value
  }

  private[this] var _showHelpIcon: Bool = showHelpIcon
  def ShowHelpIcon = _showHelpIcon
  def ShowHelpIcon_=(value: Bool) {
    if (_showHelpIcon == value) return
    json("showHelpIcon") = value
    _showHelpIcon = value
  }

  private[this] var _sourceFieldColumnTitle: String = sourceFieldColumnTitle
  def SourceFieldColumnTitle = _sourceFieldColumnTitle
  def SourceFieldColumnTitle_=(value: String) {
    if (_sourceFieldColumnTitle == value) return
    json("sourceFieldColumnTitle") = value
    _sourceFieldColumnTitle = value
  }

  private[this] var _testButton: ButtonDyn = testButton
  def TestButton = _testButton
  def TestButton_=(value: ButtonDyn) {
    if (_testButton == value) return
    json("testButton") = value
    _testButton = value
  }

  private[this] var _testButtonTitle: String = testButtonTitle
  def TestButtonTitle = _testButtonTitle
  def TestButtonTitle_=(value: String) {
    if (_testButtonTitle == value) return
    json("testButtonTitle") = value
    _testButtonTitle = value
  }

  private[this] var _testRecord: RecordDyn = testRecord
  def TestRecord = _testRecord
  def TestRecord_=(value: RecordDyn) {
    if (_testRecord == value) return
    json("testRecord") = value
    _testRecord = value
  }

  private[this] var _titleField: TextItemDyn = titleField
  def TitleField = _titleField
  def TitleField_=(value: TextItemDyn) {
    if (_titleField == value) return
    json("titleField") = value
    _titleField = value
  }

  private[this] var _titleFieldTitle: String = titleFieldTitle
  def TitleFieldTitle = _titleFieldTitle
  def TitleFieldTitle_=(value: String) {
    if (_titleFieldTitle == value) return
    json("titleFieldTitle") = value
    _titleFieldTitle = value
  }

  private[this] var _validBuilderPrompt: String = validBuilderPrompt
  def ValidBuilderPrompt = _validBuilderPrompt
  def ValidBuilderPrompt_=(value: String) {
    if (_validBuilderPrompt == value) return
    json("validBuilderPrompt") = value
    _validBuilderPrompt = value
  }

  private[this] var _warnDuplicateTitles: String = warnDuplicateTitles
  def WarnDuplicateTitles = _warnDuplicateTitles
  def WarnDuplicateTitles_=(value: String) {
    if (_warnDuplicateTitles == value) return
    json("warnDuplicateTitles") = value
    _warnDuplicateTitles = value
  }

  private[this] var _warnDuplicateTitlesMessage: String = warnDuplicateTitlesMessage
  def WarnDuplicateTitlesMessage = _warnDuplicateTitlesMessage
  def WarnDuplicateTitlesMessage_=(value: String) {
    if (_warnDuplicateTitlesMessage == value) return
    json("warnDuplicateTitlesMessage") = value
    _warnDuplicateTitlesMessage = value
  }
}