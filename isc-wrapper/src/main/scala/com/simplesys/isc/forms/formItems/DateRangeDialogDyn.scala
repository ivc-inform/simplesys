package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.WindowDyn

object DateRangeDialogDyn {
  implicit def DateRangeDialogtoJsonObject(in: DateRangeDialogDyn): JsonObject = in json
}

class DateRangeDialogDyn(override val useSelfName: Boolean = false) extends WindowDyn with DateRangeDialogDynInit {

  override val selfName = "DateRangeDialog"

  private[this] var _cancelButton: AutoChild = cancelButton
  def CancelButton = _cancelButton
  def CancelButton_=(value: AutoChild) {
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

  private[this] var _clearButton: AutoChild = clearButton
  def ClearButton = _clearButton
  def ClearButton_=(value: AutoChild) {
    if (_clearButton == value) return
    json("clearButton") = value
    _clearButton = value
  }

  private[this] var _clearButtonTitle: String = clearButtonTitle
  def ClearButtonTitle = _clearButtonTitle
  def ClearButtonTitle_=(value: String) {
    if (_clearButtonTitle == value) return
    json("clearButtonTitle") = value
    _clearButtonTitle = value
  }

  private[this] var _headerTitle: String = headerTitle
  def HeaderTitle = _headerTitle
  def HeaderTitle_=(value: String) {
    if (_headerTitle == value) return
    json("headerTitle") = value
    _headerTitle = value
  }

  private[this] var _okButton: AutoChild = okButton
  def OkButton = _okButton
  def OkButton_=(value: AutoChild) {
    if (_okButton == value) return
    json("okButton") = value
    _okButton = value
  }

  private[this] var _okButtonTitle: String = okButtonTitle
  def OkButtonTitle = _okButtonTitle
  def OkButtonTitle_=(value: String) {
    if (_okButtonTitle == value) return
    json("okButtonTitle") = value
    _okButtonTitle = value
  }

  private[this] var _rangeItem: DateRangeItemDyn = rangeItem
  def RangeItem = _rangeItem
  def RangeItem_=(value: DateRangeItemDyn) {
    if (_rangeItem == value) return
    json("rangeItem") = value
    _rangeItem = value
  }
}

