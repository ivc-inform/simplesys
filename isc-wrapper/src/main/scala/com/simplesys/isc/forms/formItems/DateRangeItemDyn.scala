package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object DateRangeItemDyn {
  implicit def DateRangeItemtoJsonObject(in: DateRangeItemDyn): JsonObject = in json
}

class DateRangeItemDyn extends CanvasItemDyn with DateRangeItemDynInit {
  private[this] var _allowRelativeDates: Bool = allowRelativeDates
  def AllowRelativeDates = _allowRelativeDates
  def AllowRelativeDates_=(value: Bool) {
    if (_allowRelativeDates == value) return
    json("allowRelativeDates") = value
    _allowRelativeDates = value
  }

  private[this] var _dateDisplayFormat: DateDisplayFormat = dateDisplayFormat
  def DateDisplayFormat = _dateDisplayFormat
  def DateDisplayFormat_=(value: DateDisplayFormat) {
    if (_dateDisplayFormat == value) return
    json("dateDisplayFormat") = value
    _dateDisplayFormat = value
  }

  private[this] var _dateInputFormat: DateInputFormat = dateInputFormat
  def DateInputFormat = _dateInputFormat
  def DateInputFormat_=(value: DateInputFormat) {
    if (_dateInputFormat == value) return
    json("dateInputFormat") = value
    _dateInputFormat = value
  }

  private[this] var _dateRangeForm: AutoChild = dateRangeForm
  def DateRangeForm = _dateRangeForm
  def DateRangeForm_=(value: AutoChild) {
    if (_dateRangeForm == value) return
    json("dateRangeForm") = value
    _dateRangeForm = value
  }

  def FromDate = json.getJsonElement("fromDate").getOrElse(fromDate)
  def FromDate_=(value: JsonElement) {
    if (FromDate == value) return
    json("fromDate") = value
  }

  private[this] var _fromField: FormItemDyn = fromField
  def FromField = _fromField
  def FromField_=(value: FormItemDyn) {
    if (_fromField == value) return
    json("fromField") = value
    _fromField = value
  }

  private[this] var _fromTitle: String = fromTitle
  def FromTitle = _fromTitle
  def FromTitle_=(value: String) {
    if (_fromTitle == value) return
    json("fromTitle") = value
    _fromTitle = value
  }

  private[this] var _innerTitleOrientation: TitleOrientation = innerTitleOrientation
  def InnerTitleOrientation = _innerTitleOrientation
  def InnerTitleOrientation_=(value: TitleOrientation) {
    if (_innerTitleOrientation == value) return
    json("innerTitleOrientation") = value
    _innerTitleOrientation = value
  }

  def ToDate = json.getJsonElement("toDate").getOrElse(toDate)
  def ToDate_=(value: JsonElement) {
    if (ToDate == value) return
    json("toDate") = value
  }

  private[this] var _toField: FormItemDyn = toField
  def ToField = _toField
  def ToField_=(value: FormItemDyn) {
    if (_toField == value) return
    json("toField") = value
    _toField = value
  }

  private[this] var _toTitle: String = toTitle
  def ToTitle = _toTitle
  def ToTitle_=(value: String) {
    if (_toTitle == value) return
    json("toTitle") = value
    _toTitle = value
  }
}

