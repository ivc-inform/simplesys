package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.VLayoutDynInit
import com.simplesys.isc.forms.formItems.TextItemDyn
import com.simplesys.isc.control.ButtonDyn
import com.simplesys.isc.grids.ListGridDyn
import com.simplesys.isc.forms.formItems.formItem.FormItemIconDyn
import com.simplesys.isc.foundation.LabelDyn
import dataSource.RecordDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonElement, JsonNull}

trait FormulaBuilderDynInit extends VLayoutDynInit {
  protected val autoHideCheckBox: TextItemDyn = null
  protected val autoHideCheckBoxLabel: String = "Auto hide fields used in formula"
  protected val autoTest: Bool = true
  protected val autoTestDelay: Number = 200
  protected val builderTypeText: String = "Formula"
  protected val cancelButton: ButtonDyn = null
  protected val cancelButtonTitle: String = "Cancel"
  protected val cancelled: Bool = false
  protected val dataSource: JsonElement = JsonNull
  protected val defaultErrorText: String = "[No Explicit Error]"
  protected val defaultNewFieldTitle: String = "New Field"
  protected val editMode: Bool = false
  protected val field: DataSourceFieldDyn = null
  protected val fieldKey: ListGridDyn = null
  protected val fields: ArrayDyn[DataSourceFieldDyn] = null
  protected val fireOnClose: FunctionExpression = null
  protected val formulaField: TextItemDyn = null
  protected val helpIcon: FormItemIconDyn = null
  protected val helpTextIntro: HTMLString = "For basic arithmetic, type in symbols (+-/%) directly.<P>The following functions are also available:"
  protected val helpWindowTitle: String = "${builderType} Help"
  protected val instructions: LabelDyn = null
  protected val instructionsTextStart: String = "The following fields are available for use in this ${builderType}"
  protected val invalidBlankPrompt: String = "Invalid blank ${builderType}"
  protected val invalidBuilderPrompt: String = "Invalid ${builderType}: ${errorText}"
  protected val invalidGeneratedFunctionPrompt: String = "The generated function is invalid - Check your ${builderType} and retry."
  protected val keyColumnTitle: String = "Key"
  protected val mathFunctions: Strings = null
  protected val messageLabel: LabelDyn = null
  protected val sampleHeaderTitle: String = "Sample:"
  protected val samplePrompt: HTMLString = "<nobr>For record: ${title}</nobr><br><nobr>Output: ${output}</nobr>"
  protected val saveAddAnotherButton: ButtonDyn = null
  protected val saveAddAnotherButtonTitle: String = "Save /& Add Another"
  protected val saveButton: ButtonDyn = null
  protected val saveButtonTitle: String = "Save"
  protected val saveConfirmationPrompt: String = "Save changes to this ${builderType}?"
  protected val showAutoHideCheckBox: Bool = true
  protected val showHelpIcon: Bool = true
  protected val sourceFieldColumnTitle: String = "Source Field"
  protected val testButton: ButtonDyn = null
  protected val testButtonTitle: String = "Test"
  protected val testRecord: RecordDyn = null
  protected val titleField: TextItemDyn = null
  protected val titleFieldTitle: String = "Title"
  protected val validBuilderPrompt: String = "Valid ${builderType}"
  protected val warnDuplicateTitles: String = ""
  protected val warnDuplicateTitlesMessage: String = "Another field already has the title ''. Continue anyway?"
}