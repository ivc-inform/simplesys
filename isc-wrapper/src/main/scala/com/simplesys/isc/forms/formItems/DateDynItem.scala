package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object DateDynItem {
  implicit def DateItemtoJsonObject(in: DateDynItem): JsonObject = in json
}

class DateDynItem extends ContainerItemDyn with DateItemDynInit {
  private[this] var _centuryThreshold: Number = centuryThreshold
  def CenturyThreshold = _centuryThreshold
  def CenturyThreshold_=(value: Number) {
    if (_centuryThreshold == value) return
    json("centuryThreshold") = value
    _centuryThreshold = value
  }

  private[this] var _daySelector: AutoChild = daySelector
  def DaySelector = _daySelector
  def DaySelector_=(value: AutoChild) {
    if (_daySelector == value) return
    json("daySelector") = value
    _daySelector = value
  }

  private[this] var _daySelectorProperties: SelectItemDyn = daySelectorProperties
  def DaySelectorProperties = _daySelectorProperties
  def DaySelectorProperties_=(value: SelectItemDyn) {
    if (_daySelectorProperties == value) return
    json("daySelectorProperties") = value
    _daySelectorProperties = value
  }

  private[this] var _defaultChooserDate: Date = defaultChooserDate
  def DefaultChooserDate = _defaultChooserDate
  def DefaultChooserDate_=(value: Date) {
    if (_defaultChooserDate == value) return
    json("defaultChooserDate") = value
    _defaultChooserDate = value
  }

  private[this] var _endDate: Date = endDate
  def EndDate = _endDate
  def EndDate_=(value: Date) {
    if (_endDate == value) return
    json("endDate") = value
    _endDate = value
  }

  private[this] var _enforceDate: Bool = enforceDate
  def EnforceDate = _enforceDate
  def EnforceDate_=(value: Bool) {
    if (_enforceDate == value) return
    json("enforceDate") = value
    _enforceDate = value
  }

  private[this] var _invalidDateStringMessage: String = invalidDateStringMessage
  def InvalidDateStringMessage = _invalidDateStringMessage
  def InvalidDateStringMessage_=(value: String) {
    if (_invalidDateStringMessage == value) return
    json("invalidDateStringMessage") = value
    _invalidDateStringMessage = value
  }

  private[this] var _maskDateSeparator: String = maskDateSeparator
  def MaskDateSeparator = _maskDateSeparator
  def MaskDateSeparator_=(value: String) {
    if (_maskDateSeparator == value) return
    json("maskDateSeparator") = value
    _maskDateSeparator = value
  }

  private[this] var _monthSelector: AutoChild = monthSelector
  def MonthSelector = _monthSelector
  def MonthSelector_=(value: AutoChild) {
    if (_monthSelector == value) return
    json("monthSelector") = value
    _monthSelector = value
  }

  private[this] var _monthSelectorProperties: SelectItemDyn = monthSelectorProperties
  def MonthSelectorProperties = _monthSelectorProperties
  def MonthSelectorProperties_=(value: SelectItemDyn) {
    if (_monthSelectorProperties == value) return
    json("monthSelectorProperties") = value
    _monthSelectorProperties = value
  }

  private[this] var _selectorFormat: DateItemSelectorFormat = selectorFormat
  def SelectorFormat = _selectorFormat
  def SelectorFormat_=(value: DateItemSelectorFormat) {
    if (_selectorFormat == value) return
    json("selectorFormat") = value
    _selectorFormat = value
  }

  private[this] var _startDate: Date = startDate
  def StartDate = _startDate
  def StartDate_=(value: Date) {
    if (_startDate == value) return
    json("startDate") = value
    _startDate = value
  }

  private[this] var _textField: AutoChild = textField
  def TextField = _textField
  def TextField_=(value: AutoChild) {
    if (_textField == value) return
    json("textField") = value
    _textField = value
  }

  private[this] var _textFieldProperties: TextItemDyn = textFieldProperties
  def TextFieldProperties = _textFieldProperties
  def TextFieldProperties_=(value: TextItemDyn) {
    if (_textFieldProperties == value) return
    json("textFieldProperties") = value
    _textFieldProperties = value
  }

  private[this] var _useMask: Bool = useMask
  def UseMask = _useMask
  def UseMask_=(value: Bool) {
    if (_useMask == value) return
    json("useMask") = value
    _useMask = value
  }

  private[this] var _useSharedPicker: Bool = useSharedPicker
  def UseSharedPicker = _useSharedPicker
  def UseSharedPicker_=(value: Bool) {
    if (_useSharedPicker == value) return
    json("useSharedPicker") = value
    _useSharedPicker = value
  }

  private[this] var _useTextField: Bool = useTextField
  def UseTextField = _useTextField
  def UseTextField_=(value: Bool) {
    if (_useTextField == value) return
    json("useTextField") = value
    _useTextField = value
  }

  private[this] var _yearSelector: AutoChild = yearSelector
  def YearSelector = _yearSelector
  def YearSelector_=(value: AutoChild) {
    if (_yearSelector == value) return
    json("yearSelector") = value
    _yearSelector = value
  }

  private[this] var _yearSelectorProperties: SelectItemDyn = yearSelectorProperties
  def YearSelectorProperties = _yearSelectorProperties
  def YearSelectorProperties_=(value: SelectItemDyn) {
    if (_yearSelectorProperties == value) return
    json("yearSelectorProperties") = value
    _yearSelectorProperties = value
  }
}

