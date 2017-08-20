package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import formItem.FormItemIconDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc._

object RelativeDateItemDyn {
  implicit def RelativeDateItemtoJsonObject(in: RelativeDateItemDyn): JsonObject = in json
}

class RelativeDateItemDyn extends CanvasItemDyn with RelativeDateItemDynInit {
  private[this] var _baseDate: Date = baseDate
  def BaseDate = _baseDate
  def BaseDate_=(value: Date) {
    if (_baseDate == value) return
    json("baseDate") = value
    _baseDate = value
  }

  private[this] var _calculatedDateField: BlurbItemDyn = calculatedDateField
  def CalculatedDateField = _calculatedDateField
  def CalculatedDateField_=(value: BlurbItemDyn) {
    if (_calculatedDateField == value) return
    json("calculatedDateField") = value
    _calculatedDateField = value
  }

  private[this] var _centuryThreshold: Number = centuryThreshold
  def CenturyThreshold = _centuryThreshold
  def CenturyThreshold_=(value: Number) {
    if (_centuryThreshold == value) return
    json("centuryThreshold") = value
    _centuryThreshold = value
  }

  private[this] var _daysAgoTitle: String = daysAgoTitle
  def DaysAgoTitle = _daysAgoTitle
  def DaysAgoTitle_=(value: String) {
    if (_daysAgoTitle == value) return
    json("daysAgoTitle") = value
    _daysAgoTitle = value
  }

  private[this] var _daysFromNowTitle: String = daysFromNowTitle
  def DaysFromNowTitle = _daysFromNowTitle
  def DaysFromNowTitle_=(value: String) {
    if (_daysFromNowTitle == value) return
    json("daysFromNowTitle") = value
    _daysFromNowTitle = value
  }

  private[this] var _defaultQuantity: Number = defaultQuantity
  def DefaultQuantity = _defaultQuantity
  def DefaultQuantity_=(value: Number) {
    if (_defaultQuantity == value) return
    json("defaultQuantity") = value
    _defaultQuantity = value
  }

  private[this] var _endDate: Date = endDate
  def EndDate = _endDate
  def EndDate_=(value: Date) {
    if (_endDate == value) return
    json("endDate") = value
    _endDate = value
  }

  private[this] var _hoursAgoTitle: String = hoursAgoTitle
  def HoursAgoTitle = _hoursAgoTitle
  def HoursAgoTitle_=(value: String) {
    if (_hoursAgoTitle == value) return
    json("hoursAgoTitle") = value
    _hoursAgoTitle = value
  }

  private[this] var _hoursFromNowTitle: String = hoursFromNowTitle
  def HoursFromNowTitle = _hoursFromNowTitle
  def HoursFromNowTitle_=(value: String) {
    if (_hoursFromNowTitle == value) return
    json("hoursFromNowTitle") = value
    _hoursFromNowTitle = value
  }

  private[this] var _millisecondsAgoTitle: String = millisecondsAgoTitle
  def MillisecondsAgoTitle = _millisecondsAgoTitle
  def MillisecondsAgoTitle_=(value: String) {
    if (_millisecondsAgoTitle == value) return
    json("millisecondsAgoTitle") = value
    _millisecondsAgoTitle = value
  }

  private[this] var _millisecondsFromNowTitle: String = millisecondsFromNowTitle
  def MillisecondsFromNowTitle = _millisecondsFromNowTitle
  def MillisecondsFromNowTitle_=(value: String) {
    if (_millisecondsFromNowTitle == value) return
    json("millisecondsFromNowTitle") = value
    _millisecondsFromNowTitle = value
  }

  private[this] var _minutesAgoTitle: String = minutesAgoTitle
  def MinutesAgoTitle = _minutesAgoTitle
  def MinutesAgoTitle_=(value: String) {
    if (_minutesAgoTitle == value) return
    json("minutesAgoTitle") = value
    _minutesAgoTitle = value
  }

  private[this] var _minutesFromNowTitle: String = minutesFromNowTitle
  def MinutesFromNowTitle = _minutesFromNowTitle
  def MinutesFromNowTitle_=(value: String) {
    if (_minutesFromNowTitle == value) return
    json("minutesFromNowTitle") = value
    _minutesFromNowTitle = value
  }

  private[this] var _monthsAgoTitle: String = monthsAgoTitle
  def MonthsAgoTitle = _monthsAgoTitle
  def MonthsAgoTitle_=(value: String) {
    if (_monthsAgoTitle == value) return
    json("monthsAgoTitle") = value
    _monthsAgoTitle = value
  }

  private[this] var _monthsFromNowTitle: String = monthsFromNowTitle
  def MonthsFromNowTitle = _monthsFromNowTitle
  def MonthsFromNowTitle_=(value: String) {
    if (_monthsFromNowTitle == value) return
    json("monthsFromNowTitle") = value
    _monthsFromNowTitle = value
  }

  private[this] var _pickerIcon: FormItemIconDyn = pickerIcon
  def PickerIcon = _pickerIcon
  def PickerIcon_=(value: FormItemIconDyn) {
    if (_pickerIcon == value) return
    json("pickerIcon") = value
    _pickerIcon = value
  }

  private[this] var _presetOptions: JsonObject = presetOptions
  def PresetOptions = _presetOptions
  def PresetOptions_=(value: JsonObject) {
    if (_presetOptions == value) return
    json("presetOptions") = value
    _presetOptions = value
  }

  private[this] var _quantityField: SpinnerItemDyn = quantityField
  def QuantityField = _quantityField
  def QuantityField_=(value: SpinnerItemDyn) {
    if (_quantityField == value) return
    json("quantityField") = value
    _quantityField = value
  }

  private[this] var _rangePosition: RelativeDateRangePosition = rangePosition
  def RangePosition = _rangePosition
  def RangePosition_=(value: RelativeDateRangePosition) {
    if (_rangePosition == value) return
    json("rangePosition") = value
    _rangePosition = value
  }

  private[this] var _rangeRoundingGranularity: JsonObject = rangeRoundingGranularity
  def RangeRoundingGranularity = _rangeRoundingGranularity
  def RangeRoundingGranularity_=(value: JsonObject) {
    if (_rangeRoundingGranularity == value) return
    json("rangeRoundingGranularity") = value
    _rangeRoundingGranularity = value
  }

  private[this] var _secondsAgoTitle: String = secondsAgoTitle
  def SecondsAgoTitle = _secondsAgoTitle
  def SecondsAgoTitle_=(value: String) {
    if (_secondsAgoTitle == value) return
    json("secondsAgoTitle") = value
    _secondsAgoTitle = value
  }

  private[this] var _secondsFromNowTitle: String = secondsFromNowTitle
  def SecondsFromNowTitle = _secondsFromNowTitle
  def SecondsFromNowTitle_=(value: String) {
    if (_secondsFromNowTitle == value) return
    json("secondsFromNowTitle") = value
    _secondsFromNowTitle = value
  }

  private[this] var _showCalculatedDateField: Bool = showCalculatedDateField
  def ShowCalculatedDateField = _showCalculatedDateField
  def ShowCalculatedDateField_=(value: Bool) {
    if (_showCalculatedDateField == value) return
    json("showCalculatedDateField") = value
    _showCalculatedDateField = value
  }

  private[this] var _showChooserIcon: Bool = showChooserIcon
  def ShowChooserIcon = _showChooserIcon
  def ShowChooserIcon_=(value: Bool) {
    if (_showChooserIcon == value) return
    json("showChooserIcon") = value
    _showChooserIcon = value
  }

  private[this] var _showFutureOptions: Bool = showFutureOptions
  def ShowFutureOptions = _showFutureOptions
  def ShowFutureOptions_=(value: Bool) {
    if (_showFutureOptions == value) return
    json("showFutureOptions") = value
    _showFutureOptions = value
  }

  private[this] var _showPastOptions: Bool = showPastOptions
  def ShowPastOptions = _showPastOptions
  def ShowPastOptions_=(value: Bool) {
    if (_showPastOptions == value) return
    json("showPastOptions") = value
    _showPastOptions = value
  }

  private[this] var _startDate: Date = startDate
  def StartDate = _startDate
  def StartDate_=(value: Date) {
    if (_startDate == value) return
    json("startDate") = value
    _startDate = value
  }

  def TimeUnitOptions = json.getJsonListOpt("timeUnitOptions").getOrElse(timeUnitOptions)
  def TimeUnitOptions_=(value: JsonList) {
    if (TimeUnitOptions == value) return
    json("timeUnitOptions") = value
  }

  private[this] var _useSharedPicker: Bool = useSharedPicker
  def UseSharedPicker = _useSharedPicker
  def UseSharedPicker_=(value: Bool) {
    if (_useSharedPicker == value) return
    json("useSharedPicker") = value
    _useSharedPicker = value
  }

  private[this] var _weeksAgoTitle: String = weeksAgoTitle
  def WeeksAgoTitle = _weeksAgoTitle
  def WeeksAgoTitle_=(value: String) {
    if (_weeksAgoTitle == value) return
    json("weeksAgoTitle") = value
    _weeksAgoTitle = value
  }

  private[this] var _weeksFromNowTitle: String = weeksFromNowTitle
  def WeeksFromNowTitle = _weeksFromNowTitle
  def WeeksFromNowTitle_=(value: String) {
    if (_weeksFromNowTitle == value) return
    json("weeksFromNowTitle") = value
    _weeksFromNowTitle = value
  }

  private[this] var _yearsAgoTitle: String = yearsAgoTitle
  def YearsAgoTitle = _yearsAgoTitle
  def YearsAgoTitle_=(value: String) {
    if (_yearsAgoTitle == value) return
    json("yearsAgoTitle") = value
    _yearsAgoTitle = value
  }
}

