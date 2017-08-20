package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonElement, JsonNull, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import formItem.FormItemIconDyn

object MiniDateRangeItemDyn {
  implicit def MiniDateRangeItemtoJsonObject(in: MiniDateRangeItemDyn): JsonObject = in json
}

class MiniDateRangeItemDyn extends StaticTextItemDyn with MiniDateRangeItemDynInit {
  private[this] var _dateDisplayFormat: DateDisplayFormat = dateDisplayFormat
  def DateDisplayFormat = _dateDisplayFormat
  def DateDisplayFormat_=(value: DateDisplayFormat) {
    if (_dateDisplayFormat == value) return
    json("dateDisplayFormat") = value
    _dateDisplayFormat = value
  }

  def FromDate = json.getJsonElement("fromDate").getOrElse(fromDate)
  def FromDate_=(value: JsonElement) {
    if (FromDate == value) return
    json("fromDate") = value
  }

  private[this] var _fromDateOnlyPrefix: String = fromDateOnlyPrefix
  def FromDateOnlyPrefix = _fromDateOnlyPrefix
  def FromDateOnlyPrefix_=(value: String) {
    if (_fromDateOnlyPrefix == value) return
    json("fromDateOnlyPrefix") = value
    _fromDateOnlyPrefix = value
  }

  private[this] var _pickerIcon: FormItemIconDyn = pickerIcon
  def PickerIcon = _pickerIcon
  def PickerIcon_=(value: FormItemIconDyn) {
    if (_pickerIcon == value) return
    json("pickerIcon") = value
    _pickerIcon = value
  }

  private[this] var _rangeDialog: DateRangeDialogDyn = rangeDialog
  def RangeDialog = _rangeDialog
  def RangeDialog_=(value: DateRangeDialogDyn) {
    if (_rangeDialog == value) return
    json("rangeDialog") = value
    _rangeDialog = value
  }

  def ToDate = json.getJsonElement("toDate").getOrElse(toDate)
  def ToDate_=(value: JsonElement) {
    if (ToDate == value) return
    json("toDate") = value
  }

  private[this] var _toDateOnlyPrefix: String = toDateOnlyPrefix
  def ToDateOnlyPrefix = _toDateOnlyPrefix
  def ToDateOnlyPrefix_=(value: String) {
    if (_toDateOnlyPrefix == value) return
    json("toDateOnlyPrefix") = value
    _toDateOnlyPrefix = value
  }
}

