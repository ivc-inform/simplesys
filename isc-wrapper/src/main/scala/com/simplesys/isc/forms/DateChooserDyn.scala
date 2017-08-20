package com.simplesys.isc.forms

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.misc.{SCClassName, CSSStyleName}
import com.simplesys.json.{UnquotedString, JsonObject}

object DateChooserDyn {

  implicit def DateChoosertoJsonObject(in: DateChooserDyn): JsonObject = in json
}

class DateChooserDyn extends ButtonTableDyn with DateChooserDynInit {
  override val selfName = "DateChooser"

  private[this] var _alternateStyleSuffix: String = alternateStyleSuffix
  def AlternateStyleSuffix = _alternateStyleSuffix
  def AlternateStyleSuffix_=(value: String) {
    if (_alternateStyleSuffix == value) return
    json("alternateStyleSuffix") = value
    _alternateStyleSuffix = value
  }

  private[this] var _alternateWeekStyles: Bool = alternateWeekStyles
  def AlternateWeekStyles = _alternateWeekStyles
  def AlternateWeekStyles_=(value: Bool) {
    if (_alternateWeekStyles == value) return
    json("alternateWeekStyles") = value
    _alternateWeekStyles = value
  }

  private[this] var _baseBottomButtonStyle: SCClassName = baseBottomButtonStyle
  def BaseBottomButtonStyle = _baseBottomButtonStyle
  def BaseBottomButtonStyle_=(value: SCClassName) {
    if (_baseBottomButtonStyle == value) return
    json("baseBottomButtonStyle") = value
    _baseBottomButtonStyle = value
  }

  private[this] var _baseButtonStyle: String = baseButtonStyle
  def BaseButtonStyle = _baseButtonStyle
  def BaseButtonStyle_=(value: String) {
    if (_baseButtonStyle == value) return
    json("baseButtonStyle") = value
    _baseButtonStyle = value
  }

  private[this] var _baseWeekdayStyle: String = baseWeekdayStyle
  def BaseWeekdayStyle = _baseWeekdayStyle
  def BaseWeekdayStyle_=(value: String) {
    if (_baseWeekdayStyle == value) return
    json("baseWeekdayStyle") = value
    _baseWeekdayStyle = value
  }

  private[this] var _baseWeekendStyle: String = baseWeekendStyle
  def BaseWeekendStyle = _baseWeekendStyle
  def BaseWeekendStyle_=(value: String) {
    if (_baseWeekendStyle == value) return
    json("baseWeekendStyle") = value
    _baseWeekendStyle = value
  }

  private[this] var _cancelButtonTitle: String = cancelButtonTitle
  def CancelButtonTitle = _cancelButtonTitle
  def CancelButtonTitle_=(value: String) {
    if (_cancelButtonTitle == value) return
    json("cancelButtonTitle") = value
    _cancelButtonTitle = value
  }

  private[this] var _dayNameLength: Number = dayNameLength
  def DayNameLength = _dayNameLength
  def DayNameLength_=(value: Number) {
    if (_dayNameLength == value) return
    json("dayNameLength") = value
    _dayNameLength = value
  }

  private[this] var _disableWeekends: Bool = disableWeekends
  def DisableWeekends = _disableWeekends
  def DisableWeekends_=(value: Bool) {
    if (_disableWeekends == value) return
    json("disableWeekends") = value
    _disableWeekends = value
  }

  private[this] var _endYear: Number = endYear
  def EndYear = _endYear
  def EndYear_=(value: Number) {
    if (_endYear == value) return
    json("endYear") = value
    _endYear = value
  }

  private[this] var _firstDayOfWeek: Number = firstDayOfWeek
  def FirstDayOfWeek = _firstDayOfWeek
  def FirstDayOfWeek_=(value: Number) {
    if (_firstDayOfWeek == value) return
    json("firstDayOfWeek") = value
    _firstDayOfWeek = value
  }

  private[this] var _headerHeight: Number = headerHeight
  def HeaderHeight = _headerHeight
  def HeaderHeight_=(value: Number) {
    if (_headerHeight == value) return
    json("headerHeight") = value
    _headerHeight = value
  }

  private[this] var _headerStyle: CSSStyleName = headerStyle
  def HeaderStyle = _headerStyle
  def HeaderStyle_=(value: CSSStyleName) {
    if (_headerStyle == value) return
    json("headerStyle") = value
    _headerStyle = value
  }

  private[this] var _monthMenuStyle: CSSStyleName = monthMenuStyle
  def MonthMenuStyle = _monthMenuStyle
  def MonthMenuStyle_=(value: CSSStyleName) {
    if (_monthMenuStyle == value) return
    json("monthMenuStyle") = value
    _monthMenuStyle = value
  }

  private[this] var _nextMonthIcon: URL = nextMonthIcon
  def NextMonthIcon = _nextMonthIcon
  def NextMonthIcon_=(value: URL) {
    if (_nextMonthIcon == value) return
    json("nextMonthIcon") = value
    _nextMonthIcon = value
  }

  private[this] var _nextMonthIconHeight: Number = nextMonthIconHeight
  def NextMonthIconHeight = _nextMonthIconHeight
  def NextMonthIconHeight_=(value: Number) {
    if (_nextMonthIconHeight == value) return
    json("nextMonthIconHeight") = value
    _nextMonthIconHeight = value
  }

  private[this] var _nextMonthIconWidth: Number = nextMonthIconWidth
  def NextMonthIconWidth = _nextMonthIconWidth
  def NextMonthIconWidth_=(value: Number) {
    if (_nextMonthIconWidth == value) return
    json("nextMonthIconWidth") = value
    _nextMonthIconWidth = value
  }

  private[this] var _nextYearIcon: URL = nextYearIcon
  def NextYearIcon = _nextYearIcon
  def NextYearIcon_=(value: URL) {
    if (_nextYearIcon == value) return
    json("nextYearIcon") = value
    _nextYearIcon = value
  }

  private[this] var _nextYearIconHeight: Number = nextYearIconHeight
  def NextYearIconHeight = _nextYearIconHeight
  def NextYearIconHeight_=(value: Number) {
    if (_nextYearIconHeight == value) return
    json("nextYearIconHeight") = value
    _nextYearIconHeight = value
  }

  private[this] var _nextYearIconWidth: Number = nextYearIconWidth
  def NextYearIconWidth = _nextYearIconWidth
  def NextYearIconWidth_=(value: Number) {
    if (_nextYearIconWidth == value) return
    json("nextYearIconWidth") = value
    _nextYearIconWidth = value
  }

  private[this] var _prevMonthIcon: URL = prevMonthIcon
  def PrevMonthIcon = _prevMonthIcon
  def PrevMonthIcon_=(value: URL) {
    if (_prevMonthIcon == value) return
    json("prevMonthIcon") = value
    _prevMonthIcon = value
  }

  private[this] var _prevMonthIconHeight: Number = prevMonthIconHeight
  def PrevMonthIconHeight = _prevMonthIconHeight
  def PrevMonthIconHeight_=(value: Number) {
    if (_prevMonthIconHeight == value) return
    json("prevMonthIconHeight") = value
    _prevMonthIconHeight = value
  }

  private[this] var _prevMonthIconWidth: Number = prevMonthIconWidth
  def PrevMonthIconWidth = _prevMonthIconWidth
  def PrevMonthIconWidth_=(value: Number) {
    if (_prevMonthIconWidth == value) return
    json("prevMonthIconWidth") = value
    _prevMonthIconWidth = value
  }

  private[this] var _prevYearIcon: URL = prevYearIcon
  def PrevYearIcon = _prevYearIcon
  def PrevYearIcon_=(value: URL) {
    if (_prevYearIcon == value) return
    json("prevYearIcon") = value
    _prevYearIcon = value
  }

  private[this] var _prevYearIconHeight: Number = prevYearIconHeight
  def PrevYearIconHeight = _prevYearIconHeight
  def PrevYearIconHeight_=(value: Number) {
    if (_prevYearIconHeight == value) return
    json("prevYearIconHeight") = value
    _prevYearIconHeight = value
  }

  private[this] var _prevYearIconWidth: Number = prevYearIconWidth
  def PrevYearIconWidth = _prevYearIconWidth
  def PrevYearIconWidth_=(value: Number) {
    if (_prevYearIconWidth == value) return
    json("prevYearIconWidth") = value
    _prevYearIconWidth = value
  }

  private[this] var _showCancelButton: Bool = showCancelButton
  def ShowCancelButton = _showCancelButton
  def ShowCancelButton_=(value: Bool) {
    if (_showCancelButton == value) return
    json("showCancelButton") = value
    _showCancelButton = value
  }

  private[this] var _showDoubleYearIcon: Bool = showDoubleYearIcon
  def ShowDoubleYearIcon = _showDoubleYearIcon
  def ShowDoubleYearIcon_=(value: Bool) {
    if (_showDoubleYearIcon == value) return
    json("showDoubleYearIcon") = value
    _showDoubleYearIcon = value
  }

  private[this] var _showTodayButton: Bool = showTodayButton
  def ShowTodayButton = _showTodayButton
  def ShowTodayButton_=(value: Bool) {
    if (_showTodayButton == value) return
    json("showTodayButton") = value
    _showTodayButton = value
  }

  private[this] var _showWeekends: Bool = showWeekends
  def ShowWeekends = _showWeekends
  def ShowWeekends_=(value: Bool) {
    if (_showWeekends == value) return
    json("showWeekends") = value
    _showWeekends = value
  }

  private[this] var _skinImgDir: URL = skinImgDir
  def SkinImgDir = _skinImgDir
  def SkinImgDir_=(value: URL) {
    if (_skinImgDir == value) return
    json("skinImgDir") = value
    _skinImgDir = value
  }

  private[this] var _startYear: Number = startYear
  def StartYear = _startYear
  def StartYear_=(value: Number) {
    if (_startYear == value) return
    json("startYear") = value
    _startYear = value
  }

  private[this] var _todayButtonHeight: Number = todayButtonHeight
  def TodayButtonHeight = _todayButtonHeight
  def TodayButtonHeight_=(value: Number) {
    if (_todayButtonHeight == value) return
    json("todayButtonHeight") = value
    _todayButtonHeight = value
  }

  private[this] var _todayButtonTitle: String = todayButtonTitle
  def TodayButtonTitle = _todayButtonTitle
  def TodayButtonTitle_=(value: String) {
    if (_todayButtonTitle == value) return
    json("todayButtonTitle") = value
    _todayButtonTitle = value
  }

  private[this] var _weekendHeaderStyle: CSSStyleName = weekendHeaderStyle
  def WeekendHeaderStyle = _weekendHeaderStyle
  def WeekendHeaderStyle_=(value: CSSStyleName) {
    if (_weekendHeaderStyle == value) return
    json("weekendHeaderStyle") = value
    _weekendHeaderStyle = value
  }

  private[this] var _yearMenuStyle: CSSStyleName = yearMenuStyle
  def YearMenuStyle = _yearMenuStyle
  def YearMenuStyle_=(value: CSSStyleName) {
    if (_yearMenuStyle == value) return
    json("yearMenuStyle") = value
    _yearMenuStyle = value
  }

  private[this] var _baseNavButtonStyle: SCClassName = baseNavButtonStyle
  def BaseNavButtonStyle = _baseNavButtonStyle
  def BaseNavButtonStyle_=(value: SCClassName) {
    if (_baseNavButtonStyle == value) return
    json("baseNavButtonStyle") = value
    _baseNavButtonStyle = value
  }
}
