package com.simplesys.isc.forms

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.LayoutDynInit
import com.simplesys.isc.dataBinging.dataSource.AdvancedCriteriaDyn
import com.simplesys.isc.dataBinging.DataSourceDyn
import formItems.FormItemDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonNull, JsonElement, JsonList}

trait FilterBuilderDynInit extends LayoutDynInit {
  protected val addButton: AutoChild = null
  protected val addButtonPrompt: String = "Add"
  protected val allowEmpty: Bool = false
  protected val bracket: AutoChild = null
  protected val clauseStack: AutoChild = null
  protected val criteria: AdvancedCriteriaDyn = null
  protected val dataSource: JsonElement = JsonNull
  protected val defaultSubClauseOperator: LogicalOperator = lgcOprOr
  protected val fieldDataSource: JsonElement = JsonNull
  protected val fieldPicker: AutoChild = null
  protected val fieldPickerProperties: FormItemDyn = null
  protected val fieldPickerTitle: String = "Field Name"
  protected val filterChanged: FunctionExpression = null
  protected val inlineAndNotTitle: String = "and not"
  protected val inlineAndTitle: String = "and"
  protected val inlineOrTitle: String = "or"
  protected val matchAllTitle: String = "Match All"
  protected val matchAnyTitle: String = "Match Any"
  protected val matchNoneTitle: String = "Match None"
  protected val missingFieldPrompt: String = "[missing field definition]"
  protected val operatorPickerTitle: String = "Operator"
  protected val radioOperatorForm: AutoChild = null
  protected val radioOperatorTitle: String = "Overall Operator"
  protected val radioOptions: JsonList = null
  protected val rangeSeparator: String = "and"
  protected val removeButton: AutoChild = null
  protected val removeButtonPrompt: String = "Remove"
  protected val retainValuesAcrossFields: Bool = true
  protected val saveOnEnter: Bool = null
  protected val showAddButton: Bool = true
  protected val showFieldTitles: Bool = true
  protected val showRemoveButton: Bool = true
  protected val showSelectionCheckbox: Bool = false
  protected val showSubClauseButton: Bool = true
  protected val subClauseButton: AutoChild = null
  protected val subClauseButtonPrompt: String = "Add Subclause"
  protected val subClauseButtonTitle: String = "+()"
  protected val topOperator: LogicalOperator = lgcOprAnd
  protected val topOperatorAppearance: TopOperatorAppearance = tpOpAprncBracket
  protected val topOperatorForm: AutoChild = null
  protected val topOperatorTitle: String = "Clause Operator"
  protected val validateOnChange: Bool = true
}