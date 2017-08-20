package com.simplesys.isc.calendar

import com.simplesys.json._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.misc._
import com.simplesys.json.UnquotedString
import com.simplesys.isc.dataBinging.DataBoundComponentDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.forms.formItems.FormItemDyn

object CalendarDyn {
  implicit def CalendartoJsonObject(in: CalendarDyn): JsonObject = in json
}

class CalendarDyn(override val useSelfName: Boolean = false) extends CanvasDyn with DataBoundComponentDyn with CalendarDynInit {
  override val selfName = "Calendar"

  private[this] var _addEventButton: AutoChild = addEventButton
  def AddEventButton = _addEventButton
  def AddEventButton_=(value: AutoChild) {
    if (_addEventButton == value) return
    json("addEventButton") = value
    _addEventButton = value
  }

  private[this] var _addEventButtonHoverText: String = addEventButtonHoverText
  def AddEventButtonHoverText = _addEventButtonHoverText
  def AddEventButtonHoverText_=(value: String) {
    if (_addEventButtonHoverText == value) return
    json("addEventButtonHoverText") = value
    _addEventButtonHoverText = value
  }

  private[this] var _autoFetchData: Bool = autoFetchData
  def AutoFetchData = _autoFetchData
  def AutoFetchData_=(value: Bool) {
    if (_autoFetchData == value) return
    json("autoFetchData") = value
    _autoFetchData = value
  }

  private[this] var _autoFetchTextMatchStyle: TextMatchStyle = autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle = _autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle_=(value: TextMatchStyle) {
    if (_autoFetchTextMatchStyle == value) return
    json("autoFetchTextMatchStyle") = value
    _autoFetchTextMatchStyle = value
  }

  private[this] var _baseStyle: CSSStyleName = baseStyle
  def BaseStyle = _baseStyle
  def BaseStyle_=(value: CSSStyleName) {
    if (_baseStyle == value) return
    json("baseStyle") = value
    _baseStyle = value
  }

  private[this] var _cancelButtonTitle: String = cancelButtonTitle
  def CancelButtonTitle = _cancelButtonTitle
  def CancelButtonTitle_=(value: String) {
    if (_cancelButtonTitle == value) return
    json("cancelButtonTitle") = value
    _cancelButtonTitle = value
  }

  private[this] var _canCreateEvents: Bool = canCreateEvents
  def CanCreateEvents = _canCreateEvents
  def CanCreateEvents_=(value: Bool) {
    if (_canCreateEvents == value) return
    json("canCreateEvents") = value
    _canCreateEvents = value
  }

  private[this] var _canDeleteEvents: Bool = canDeleteEvents
  def CanDeleteEvents = _canDeleteEvents
  def CanDeleteEvents_=(value: Bool) {
    if (_canDeleteEvents == value) return
    json("canDeleteEvents") = value
    _canDeleteEvents = value
  }

  private[this] var _canDragEventField: String = canDragEventField
  def CanDragEventField = _canDragEventField
  def CanDragEventField_=(value: String) {
    if (_canDragEventField == value) return
    json("canDragEventField") = value
    _canDragEventField = value
  }

  private[this] var _canDragEvents: Bool = canDragEvents
  def CanDragEvents = _canDragEvents
  def CanDragEvents_=(value: Bool) {
    if (_canDragEvents == value) return
    json("canDragEvents") = value
    _canDragEvents = value
  }

  private[this] var _canEditEvents: Bool = canEditEvents
  def CanEditEvents = _canEditEvents
  def CanEditEvents_=(value: Bool) {
    if (_canEditEvents == value) return
    json("canEditEvents") = value
    _canEditEvents = value
  }

  private[this] var _canEditField: String = canEditField
  def CanEditField = _canEditField
  def CanEditField_=(value: String) {
    if (_canEditField == value) return
    json("canEditField") = value
    _canEditField = value
  }

  private[this] var _chosenDate: Date = chosenDate
  def ChosenDate = _chosenDate
  def ChosenDate_=(value: Date) {
    if (_chosenDate == value) return
    json("chosenDate") = value
    _chosenDate = value
  }

  private[this] var _currentViewName: ViewName = currentViewName
  def CurrentViewName = _currentViewName
  def CurrentViewName_=(value: ViewName) {
    if (_currentViewName == value) return
    json("currentViewName") = value
    _currentViewName = value
  }

  def Data = json.getJsonElement("data").getOrElse(data)
  def Data_=(value: JsonElement) {
    if (Data == value) return
    json("data") = value
  }

  private[this] var _dateChooser: AutoChild = dateChooser
  def DateChooser = _dateChooser
  def DateChooser_=(value: AutoChild) {
    if (_dateChooser == value) return
    json("dateChooser") = value
    _dateChooser = value
  }

  private[this] var _dateFormatter: DateDisplayFormat = dateFormatter
  def DateFormatter = _dateFormatter
  def DateFormatter_=(value: DateDisplayFormat) {
    if (_dateFormatter == value) return
    json("dateFormatter") = value
    _dateFormatter = value
  }

  private[this] var _datePickerButton: AutoChild = datePickerButton
  def DatePickerButton = _datePickerButton
  def DatePickerButton_=(value: AutoChild) {
    if (_datePickerButton == value) return
    json("datePickerButton") = value
    _datePickerButton = value
  }

  private[this] var _datePickerHoverText: String = datePickerHoverText
  def DatePickerHoverText = _datePickerHoverText
  def DatePickerHoverText_=(value: String) {
    if (_datePickerHoverText == value) return
    json("datePickerHoverText") = value
    _datePickerHoverText = value
  }

  private[this] var _dayBodyBaseStyle: CSSStyleName = dayBodyBaseStyle
  def DayBodyBaseStyle = _dayBodyBaseStyle
  def DayBodyBaseStyle_=(value: CSSStyleName) {
    if (_dayBodyBaseStyle == value) return
    json("dayBodyBaseStyle") = value
    _dayBodyBaseStyle = value
  }

  private[this] var _dayHeaderBaseStyle: CSSStyleName = dayHeaderBaseStyle
  def DayHeaderBaseStyle = _dayHeaderBaseStyle
  def DayHeaderBaseStyle_=(value: CSSStyleName) {
    if (_dayHeaderBaseStyle == value) return
    json("dayHeaderBaseStyle") = value
    _dayHeaderBaseStyle = value
  }

  private[this] var _dayView: AutoChild = dayView
  def DayView = _dayView
  def DayView_=(value: AutoChild) {
    if (_dayView == value) return
    json("dayView") = value
    _dayView = value
  }

  private[this] var _dayViewTitle: String = dayViewTitle
  def DayViewTitle = _dayViewTitle
  def DayViewTitle_=(value: String) {
    if (_dayViewTitle == value) return
    json("dayViewTitle") = value
    _dayViewTitle = value
  }

  private[this] var _detailsButtonTitle: String = detailsButtonTitle
  def DetailsButtonTitle = _detailsButtonTitle
  def DetailsButtonTitle_=(value: String) {
    if (_detailsButtonTitle == value) return
    json("detailsButtonTitle") = value
    _detailsButtonTitle = value
  }

  private[this] var _disableWeekends: Bool = disableWeekends
  def DisableWeekends = _disableWeekends
  def DisableWeekends_=(value: Bool) {
    if (_disableWeekends == value) return
    json("disableWeekends") = value
    _disableWeekends = value
  }

  private[this] var _endDateField: String = endDateField
  def EndDateField = _endDateField
  def EndDateField_=(value: String) {
    if (_endDateField == value) return
    json("endDateField") = value
    _endDateField = value
  }

  private[this] var _eventAutoArrange: Bool = eventAutoArrange
  def EventAutoArrange = _eventAutoArrange
  def EventAutoArrange_=(value: Bool) {
    if (_eventAutoArrange == value) return
    json("eventAutoArrange") = value
    _eventAutoArrange = value
  }

  private[this] var _eventDialog: AutoChild = eventDialog
  def EventDialog = _eventDialog
  def EventDialog_=(value: AutoChild) {
    if (_eventDialog == value) return
    json("eventDialog") = value
    _eventDialog = value
  }

  private[this] var _eventDialogFields: ArrayDyn[FormItemDyn] = eventDialogFields
  def EventDialogFields = _eventDialogFields
  def EventDialogFields_=(value: ArrayDyn[FormItemDyn]) {
    if (_eventDialogFields == value) return
    json("eventDialogFields") = value
    _eventDialogFields = value
  }

  private[this] var _eventEditor: Bool = eventEditor
  def EventEditor = _eventEditor
  def EventEditor_=(value: Bool) {
    if (_eventEditor == value) return
    json("eventEditor") = value
    _eventEditor = value
  }

  private[this] var _eventEditorFields: ArrayDyn[FormItemDyn] = eventEditorFields
  def EventEditorFields = _eventEditorFields
  def EventEditorFields_=(value: ArrayDyn[FormItemDyn]) {
    if (_eventEditorFields == value) return
    json("eventEditorFields") = value
    _eventEditorFields = value
  }

  private[this] var _eventEditorLayout: AutoChild = eventEditorLayout
  def EventEditorLayout = _eventEditorLayout
  def EventEditorLayout_=(value: AutoChild) {
    if (_eventEditorLayout == value) return
    json("eventEditorLayout") = value
    _eventEditorLayout = value
  }

  private[this] var _eventNameFieldTitle: String = eventNameFieldTitle
  def EventNameFieldTitle = _eventNameFieldTitle
  def EventNameFieldTitle_=(value: String) {
    if (_eventNameFieldTitle == value) return
    json("eventNameFieldTitle") = value
    _eventNameFieldTitle = value
  }

  private[this] var _eventOverlap: Bool = eventOverlap
  def EventOverlap = _eventOverlap
  def EventOverlap_=(value: Bool) {
    if (_eventOverlap == value) return
    json("eventOverlap") = value
    _eventOverlap = value
  }

  private[this] var _eventOverlapIdenticalStartTimes: Bool = eventOverlapIdenticalStartTimes
  def EventOverlapIdenticalStartTimes = _eventOverlapIdenticalStartTimes
  def EventOverlapIdenticalStartTimes_=(value: Bool) {
    if (_eventOverlapIdenticalStartTimes == value) return
    json("eventOverlapIdenticalStartTimes") = value
    _eventOverlapIdenticalStartTimes = value
  }

  private[this] var _eventOverlapPercent: Number = eventOverlapPercent
  def EventOverlapPercent = _eventOverlapPercent
  def EventOverlapPercent_=(value: Number) {
    if (_eventOverlapPercent == value) return
    json("eventOverlapPercent") = value
    _eventOverlapPercent = value
  }

  private[this] var _eventSnapGap: Number = eventSnapGap
  def EventSnapGap = _eventSnapGap
  def EventSnapGap_=(value: Number) {
    if (_eventSnapGap == value) return
    json("eventSnapGap") = value
    _eventSnapGap = value
  }

  private[this] var _eventWindow: EventWindow = eventWindow
  def EventWindow = _eventWindow
  def EventWindow_=(value: EventWindow) {
    if (_eventWindow == value) return
    json("eventWindow") = value
    _eventWindow = value
  }

  private[this] var _eventWindowStyle: CSSStyleName = eventWindowStyle
  def EventWindowStyle = _eventWindowStyle
  def EventWindowStyle_=(value: CSSStyleName) {
    if (_eventWindowStyle == value) return
    json("eventWindowStyle") = value
    _eventWindowStyle = value
  }

  private[this] var _eventWindowStyleField: String = eventWindowStyleField
  def EventWindowStyleField = _eventWindowStyleField
  def EventWindowStyleField_=(value: String) {
    if (_eventWindowStyleField == value) return
    json("eventWindowStyleField") = value
    _eventWindowStyleField = value
  }

  private[this] var _firstDayOfWeek: Number = firstDayOfWeek
  def FirstDayOfWeek = _firstDayOfWeek
  def FirstDayOfWeek_=(value: Number) {
    if (_firstDayOfWeek == value) return
    json("firstDayOfWeek") = value
    _firstDayOfWeek = value
  }

  private[this] var _initialCriteria: CriteriaDyn = initialCriteria
  def InitialCriteria = _initialCriteria
  def InitialCriteria_=(value: CriteriaDyn) {
    if (_initialCriteria == value) return
    json("initialCriteria") = value
    _initialCriteria = value
  }

  private[this] var _invalidDateMessage: String = invalidDateMessage
  def InvalidDateMessage = _invalidDateMessage
  def InvalidDateMessage_=(value: String) {
    if (_invalidDateMessage == value) return
    json("invalidDateMessage") = value
    _invalidDateMessage = value
  }

  private[this] var _leadingDateField: String = leadingDateField
  def LeadingDateField = _leadingDateField
  def LeadingDateField_=(value: String) {
    if (_leadingDateField == value) return
    json("leadingDateField") = value
    _leadingDateField = value
  }

  private[this] var _monthView: AutoChild = monthView
  def MonthView = _monthView
  def MonthView_=(value: AutoChild) {
    if (_monthView == value) return
    json("monthView") = value
    _monthView = value
  }

  private[this] var _monthViewTitle: String = monthViewTitle
  def MonthViewTitle = _monthViewTitle
  def MonthViewTitle_=(value: String) {
    if (_monthViewTitle == value) return
    json("monthViewTitle") = value
    _monthViewTitle = value
  }

  private[this] var _nameField: String = nameField
  def NameField = _nameField
  def NameField_=(value: String) {
    if (_nameField == value) return
    json("nameField") = value
    _nameField = value
  }

  private[this] var _nextButton: AutoChild = nextButton
  def NextButton = _nextButton
  def NextButton_=(value: AutoChild) {
    if (_nextButton == value) return
    json("nextButton") = value
    _nextButton = value
  }

  private[this] var _nextButtonHoverText: String = nextButtonHoverText
  def NextButtonHoverText = _nextButtonHoverText
  def NextButtonHoverText_=(value: String) {
    if (_nextButtonHoverText == value) return
    json("nextButtonHoverText") = value
    _nextButtonHoverText = value
  }

  private[this] var _otherDayBlankStyle: CSSStyleName = otherDayBlankStyle
  def OtherDayBlankStyle = _otherDayBlankStyle
  def OtherDayBlankStyle_=(value: CSSStyleName) {
    if (_otherDayBlankStyle == value) return
    json("otherDayBlankStyle") = value
    _otherDayBlankStyle = value
  }

  private[this] var _otherDayBodyBaseStyle: CSSStyleName = otherDayBodyBaseStyle
  def OtherDayBodyBaseStyle = _otherDayBodyBaseStyle
  def OtherDayBodyBaseStyle_=(value: CSSStyleName) {
    if (_otherDayBodyBaseStyle == value) return
    json("otherDayBodyBaseStyle") = value
    _otherDayBodyBaseStyle = value
  }

  private[this] var _otherDayHeaderBaseStyle: CSSStyleName = otherDayHeaderBaseStyle
  def OtherDayHeaderBaseStyle = _otherDayHeaderBaseStyle
  def OtherDayHeaderBaseStyle_=(value: CSSStyleName) {
    if (_otherDayHeaderBaseStyle == value) return
    json("otherDayHeaderBaseStyle") = value
    _otherDayHeaderBaseStyle = value
  }

  private[this] var _previousButton: AutoChild = previousButton
  def PreviousButton = _previousButton
  def PreviousButton_=(value: AutoChild) {
    if (_previousButton == value) return
    json("previousButton") = value
    _previousButton = value
  }

  private[this] var _previousButtonHoverText: String = previousButtonHoverText
  def PreviousButtonHoverText = _previousButtonHoverText
  def PreviousButtonHoverText_=(value: String) {
    if (_previousButtonHoverText == value) return
    json("previousButtonHoverText") = value
    _previousButtonHoverText = value
  }

  private[this] var _rowHeight: Number = rowHeight
  def RowHeight = _rowHeight
  def RowHeight_=(value: Number) {
    if (_rowHeight == value) return
    json("rowHeight") = value
    _rowHeight = value
  }

  private[this] var _saveButtonTitle: String = saveButtonTitle
  def SaveButtonTitle = _saveButtonTitle
  def SaveButtonTitle_=(value: String) {
    if (_saveButtonTitle == value) return
    json("saveButtonTitle") = value
    _saveButtonTitle = value
  }

  private[this] var _scrollToWorkday: Bool = scrollToWorkday
  def ScrollToWorkday = _scrollToWorkday
  def ScrollToWorkday_=(value: Bool) {
    if (_scrollToWorkday == value) return
    json("scrollToWorkday") = value
    _scrollToWorkday = value
  }

  private[this] var _selectedCellStyle: CSSStyleName = selectedCellStyle
  def SelectedCellStyle = _selectedCellStyle
  def SelectedCellStyle_=(value: CSSStyleName) {
    if (_selectedCellStyle == value) return
    json("selectedCellStyle") = value
    _selectedCellStyle = value
  }

  private[this] var _showControlsBar: Bool = showControlsBar
  def ShowControlsBar = _showControlsBar
  def ShowControlsBar_=(value: Bool) {
    if (_showControlsBar == value) return
    json("showControlsBar") = value
    _showControlsBar = value
  }

  private[this] var _showDateChooser: Bool = showDateChooser
  def ShowDateChooser = _showDateChooser
  def ShowDateChooser_=(value: Bool) {
    if (_showDateChooser == value) return
    json("showDateChooser") = value
    _showDateChooser = value
  }

  private[this] var _showDayHeaders: Bool = showDayHeaders
  def ShowDayHeaders = _showDayHeaders
  def ShowDayHeaders_=(value: Bool) {
    if (_showDayHeaders == value) return
    json("showDayHeaders") = value
    _showDayHeaders = value
  }

  private[this] var _showOtherDays: Bool = showOtherDays
  def ShowOtherDays = _showOtherDays
  def ShowOtherDays_=(value: Bool) {
    if (_showOtherDays == value) return
    json("showOtherDays") = value
    _showOtherDays = value
  }

  private[this] var _showQuickEventDialog: Bool = showQuickEventDialog
  def ShowQuickEventDialog = _showQuickEventDialog
  def ShowQuickEventDialog_=(value: Bool) {
    if (_showQuickEventDialog == value) return
    json("showQuickEventDialog") = value
    _showQuickEventDialog = value
  }

  private[this] var _showWeekends: Bool = showWeekends
  def ShowWeekends = _showWeekends
  def ShowWeekends_=(value: Bool) {
    if (_showWeekends == value) return
    json("showWeekends") = value
    _showWeekends = value
  }

  private[this] var _showWorkday: Bool = showWorkday
  def ShowWorkday = _showWorkday
  def ShowWorkday_=(value: Bool) {
    if (_showWorkday == value) return
    json("showWorkday") = value
    _showWorkday = value
  }

  private[this] var _startDateField: String = startDateField
  def StartDateField = _startDateField
  def StartDateField_=(value: String) {
    if (_startDateField == value) return
    json("startDateField") = value
    _startDateField = value
  }

  private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter
  def TimeFormatter = _timeFormatter
  def TimeFormatter_=(value: TimeDisplayFormat) {
    if (_timeFormatter == value) return
    json("timeFormatter") = value
    _timeFormatter = value
  }

  private[this] var _timelineViewTitle: String = timelineViewTitle
  def TimelineViewTitle = _timelineViewTitle
  def TimelineViewTitle_=(value: String) {
    if (_timelineViewTitle == value) return
    json("timelineViewTitle") = value
    _timelineViewTitle = value
  }

  private[this] var _trailingDateField: String = trailingDateField
  def TrailingDateField = _trailingDateField
  def TrailingDateField_=(value: String) {
    if (_trailingDateField == value) return
    json("trailingDateField") = value
    _trailingDateField = value
  }

  private[this] var _weekEventBorderOverlap: Bool = weekEventBorderOverlap
  def WeekEventBorderOverlap = _weekEventBorderOverlap
  def WeekEventBorderOverlap_=(value: Bool) {
    if (_weekEventBorderOverlap == value) return
    json("weekEventBorderOverlap") = value
    _weekEventBorderOverlap = value
  }

  private[this] var _weekView: AutoChild = weekView
  def WeekView = _weekView
  def WeekView_=(value: AutoChild) {
    if (_weekView == value) return
    json("weekView") = value
    _weekView = value
  }

  private[this] var _weekViewTitle: String = weekViewTitle
  def WeekViewTitle = _weekViewTitle
  def WeekViewTitle_=(value: String) {
    if (_weekViewTitle == value) return
    json("weekViewTitle") = value
    _weekViewTitle = value
  }

  private[this] var _workdayBaseStyle: CSSStyleName = workdayBaseStyle
  def WorkdayBaseStyle = _workdayBaseStyle
  def WorkdayBaseStyle_=(value: CSSStyleName) {
    if (_workdayBaseStyle == value) return
    json("workdayBaseStyle") = value
    _workdayBaseStyle = value
  }

  private[this] var _workdayEnd: Time = workdayEnd
  def WorkdayEnd = _workdayEnd
  def WorkdayEnd_=(value: Time) {
    if (_workdayEnd == value) return
    json("workdayEnd") = value
    _workdayEnd = value
  }

  private[this] var _workdays: JsonList = workdays
  def Workdays = _workdays
  def Workdays_=(value: JsonList) {
    if (_workdays == value) return
    json("workdays") = value
    _workdays = value
  }

  private[this] var _workdayStart: Time = workdayStart
  def WorkdayStart = _workdayStart
  def WorkdayStart_=(value: Time) {
    if (_workdayStart == value) return
    json("workdayStart") = value
    _workdayStart = value
  }

  private[this] var _showDayView: Bool = showDayView
  def ShowDayView = _showDayView
  def ShowDayView_=(value: Bool) {
    if (_showDayView == value) return
    json("showDayView") = value
    _showDayView = value
  }

  private[this] var _showWeekView: Bool = showWeekView
  def ShowWeekView = _showWeekView
  def ShowWeekView_=(value: Bool) {
    if (_showWeekView == value) return
    json("showWeekView") = value
    _showWeekView = value
  }

  private[this] var _showMonthView: Bool = showMonthView
  def ShowMonthView = _showMonthView
  def ShowMonthView_=(value: Bool) {
    if (_showMonthView == value) return
    json("showMonthView") = value
    _showMonthView = value
  }

  private[this] var _showTimelineView: Bool = showTimelineView
  def ShowTimelineView = _showTimelineView
  def ShowTimelineView_=(value: Bool) {
    if (_showTimelineView == value) return
    json("showTimelineView") = value
    _showTimelineView = value
  }

  private[this] var _showDatePickerButton: Bool = showDatePickerButton
  def ShowDatePickerButton = _showDatePickerButton
  def ShowDatePickerButton_=(value: Bool) {
    if (_showDatePickerButton == value) return
    json("showDatePickerButton") = value
    _showDatePickerButton = value
  }

  private[this] var _showAddEventButton: Bool = showAddEventButton
  def ShowAddEventButton = _showAddEventButton
  def ShowAddEventButton_=(value: Bool) {
    if (_showAddEventButton == value) return
    json("showAddEventButton") = value
    _showAddEventButton = value
  }

  private[this] var _getDayBodyHTML: FunctionExpression = getDayBodyHTML
  def GetDayBodyHTML = _getDayBodyHTML
  def GetDayBodyHTML_=(value: FunctionExpression) {
    if (_getDayBodyHTML == value) return
    json("getDayBodyHTML") = value
    _getDayBodyHTML = value
  }

  private[this] var _dayBodyClick: FunctionExpression = dayBodyClick
  def DayBodyClick = _dayBodyClick
  def DayBodyClick_=(value: FunctionExpression) {
    if (_dayBodyClick == value) return
    json("dayBodyClick") = value
    _dayBodyClick = value
  }

}