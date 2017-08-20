package com.simplesys.isc.forms

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HStackDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn

object FilterClauseDyn {

  implicit def FilterClause2JsonObject(in: FilterClauseDyn): JsonObject = in json
}

class FilterClauseDyn(override val useSelfName: Boolean = false) extends HStackDyn with FilterClauseDynInit {
  override val selfName = "FilterClause"

  private[this] var _clause: AutoChild = clause
  def Clause = _clause
  def Clause_=(value: AutoChild) {
    if (_clause == value) return
    json("clause") = value
    _clause = value
  }

  private[this] var _criterion: CriteriaDyn = criterion
  def Criterion = _criterion
  def Criterion_=(value: CriteriaDyn) {
    if (_criterion == value) return
    json("criterion") = value
    _criterion = value
  }

  private[this] var _fieldPickerTitle: String = fieldPickerTitle
  def FieldPickerTitle = _fieldPickerTitle
  def FieldPickerTitle_=(value: String) {
    if (_fieldPickerTitle == value) return
    json("fieldPickerTitle") = value
    _fieldPickerTitle = value
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

  private[this] var _validateOnChange: Bool = validateOnChange
  def ValidateOnChange = _validateOnChange
  def ValidateOnChange_=(value: Bool) {
    if (_validateOnChange == value) return
    json("validateOnChange") = value
    _validateOnChange = value
  }

  private[this] var _valueItemTitle: String = valueItemTitle
  def ValueItemTitle = _valueItemTitle
  def ValueItemTitle_=(value: String) {
    if (_valueItemTitle == value) return
    json("valueItemTitle") = value
    _valueItemTitle = value
  }
}