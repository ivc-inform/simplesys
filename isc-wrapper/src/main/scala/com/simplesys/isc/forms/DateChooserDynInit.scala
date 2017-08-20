package com.simplesys.isc.forms

import com.simplesys.isc.system.misc._

trait DateChooserDynInit {
  protected val alternateStyleSuffix: String = "Dark"
  protected val alternateWeekStyles: Bool = false
  protected val baseBottomButtonStyle: SCClassName = ""
  protected val baseButtonStyle: String = "dateChooserButton"
  protected val baseNavButtonStyle: SCClassName = ""
  protected val baseWeekdayStyle: String = ""
  protected val baseWeekendStyle: String = ""
  protected val cancelButtonTitle: String = "Cancel"
  protected val dayNameLength: Number = 2
  protected val disableWeekends: Bool = false
  protected val endYear: Number = 2015
  protected val firstDayOfWeek: Number = 0
  protected val headerHeight: Number = 20
  protected val headerStyle: CSSStyleName = "dateChooserButtonDisabled"
  protected val monthMenuStyle: CSSStyleName = "dateChooserMonthMenu"
  protected val nextMonthIcon: URL = "[SKIN]arrow_right.gif".url
  protected val nextMonthIconHeight: Number = 7
  protected val nextMonthIconWidth: Number = 7
  protected val nextYearIcon: URL = "[SKIN]doubleArrow_right.gif".url
  protected val nextYearIconHeight: Number = 7
  protected val nextYearIconWidth: Number = 14
  protected val prevMonthIcon: URL = "[SKIN]arrow_left.gif".url
  protected val prevMonthIconHeight: Number = 7
  protected val prevMonthIconWidth: Number = 7
  protected val prevYearIcon: URL = "[SKIN]doubleArrow_left.gif".url
  protected val prevYearIconHeight: Number = 7
  protected val prevYearIconWidth: Number = 14
  protected val showCancelButton: Bool = false
  protected val showDoubleYearIcon: Bool = true
  protected val showTodayButton: Bool = true
  protected val showWeekends: Bool = true
  protected val skinImgDir: URL = "images/common/".url
  protected val startYear: Number = 1995
  protected val todayButtonHeight: Number = null
  protected val todayButtonTitle: String = "Today"
  protected val weekendHeaderStyle: CSSStyleName = ""
  protected val yearMenuStyle: CSSStyleName = "dateChooserYearMenu"
}