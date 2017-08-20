package com.simplesys.isc.calendar

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.forms.formItems._
import com.simplesys.isc.system.misc.Date
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.CSSStyleName
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.json.{JsonElement, JsonNull, JsonList}
import com.simplesys.isc.dataBinging.DataBoundComponentDynInit
import com.simplesys.isc.foundation.CanvasDynInit
import com.simplesys.isc.system.ArrayDyn

trait CalendarDynInit extends CanvasDynInit with DataBoundComponentDynInit {
  protected val addEventButton: AutoChild = null
  protected val addEventButtonHoverText: String = "Add an event"
  protected val autoFetchData: Bool = false
  protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleNull
  protected val baseStyle: CSSStyleName = "calendar"
  protected val cancelButtonTitle: String = "Cancel"
  protected val canCreateEvents: Bool = true
  protected val canDeleteEvents: Bool = true
  protected val canDragEventField: String = "canEdit"
  protected val canDragEvents: Bool = true
  protected val canEditEvents: Bool = true
  protected val canEditField: String = "canEdit"
  protected val chosenDate: Date = "Today"
  protected val currentViewName: ViewName = vwNmNull
  protected val data: JsonElement = JsonNull
  protected val dateChooser: AutoChild = null
  protected val dateFormatter: DateDisplayFormat = ddfNull
  protected val datePickerButton: AutoChild = null
  protected val datePickerHoverText: String = "Choose a date"
  protected val dayBodyBaseStyle: CSSStyleName = "calMonthDayBody"
  protected val dayBodyClick: FunctionExpression = null
  protected val dayHeaderBaseStyle: CSSStyleName = "calMonthDayHeader"
  protected val dayView: AutoChild = null
  protected val dayViewTitle: String = "Day"
  override protected val descriptionField: String = "description"
  protected val detailsButtonTitle: String = "Edit Details"
  protected val disableWeekends: Bool = true
  protected val endDateField: String = "endDate"
  protected val eventAutoArrange: Bool = true
  protected val eventDialog: AutoChild = null
  protected val eventDialogFields: ArrayDyn[FormItemDyn] = null
  protected val eventEditor: Bool = null
  protected val eventEditorFields: ArrayDyn[FormItemDyn] = null
  protected val eventEditorLayout: AutoChild = null
  protected val eventNameFieldTitle: String = "Event Name"
  protected val eventOverlap: Bool = true
  protected val eventOverlapIdenticalStartTimes: Bool = false
  protected val eventOverlapPercent: Number = 10
  protected val eventSnapGap: Number = 30
  protected val eventTypeField: String = "eventType"
  protected val eventWindow: EventWindow = null
  protected val eventWindowStyle: CSSStyleName = "eventWindow"
  protected val eventWindowStyleField: String = "eventWindowStyle"
  protected val firstDayOfWeek: Number = 0
  protected val getDayBodyHTML: FunctionExpression = null
  protected val initialCriteria: CriteriaDyn = null
  protected val invalidDateMessage: String = "From must be before To"
  protected val leadingDateField: String = "leadingDate"
  protected val monthView: AutoChild = null
  protected val monthViewTitle: String = "Month"
  protected val nameField: String = "name"
  protected val nextButton: AutoChild = null
  protected val nextButtonHoverText: String = "Next"
  protected val otherDayBlankStyle: CSSStyleName = "calMonthOtherDayBlank"
  protected val otherDayBodyBaseStyle: CSSStyleName = "calMonthDayBody"
  protected val otherDayHeaderBaseStyle: CSSStyleName = "calMonthDayHeader"
  protected val previousButton: AutoChild = null
  protected val previousButtonHoverText: String = "Previous"
  protected val rowHeight: Number = 20
  protected val saveButtonTitle: String = "Save Event"
  protected val scrollToWorkday: Bool = false
  protected val selectedCellStyle: CSSStyleName = "calendarCellSelected"
  protected val showAddEventButton: Bool = true
  protected val showControlsBar: Bool = true
  protected val showDateChooser: Bool = true
  protected val showDatePickerButton: Bool = true
  protected val showDayView: Bool = true
  protected val showDayHeaders: Bool = true
  override protected val showDetailFields: Bool = true
  protected val showMonthView: Bool = true
  protected val showOtherDays: Bool = true
  protected val showTimelineView: Bool = true
  protected val showQuickEventDialog: Bool = true
  protected val showWeekends: Bool = true
  protected val showWorkday: Bool = false
  protected val showWeekView: Bool = true
  protected val startDateField: String = "startDate"
  protected val timeFormatter: TimeDisplayFormat = tmDspFmtToShortPaddedTime
  protected val timelineViewTitle: String = "Timeline"
  protected val trailingDateField: String = "trailingDate"
  protected val weekEventBorderOverlap: Bool = false
  protected val weekView: AutoChild = null
  protected val weekViewTitle: String = "Week"
  protected val workdayBaseStyle: CSSStyleName = "calendarWorkday"
  protected val workdayEnd: Time = "5:00pm"
  protected val workdays: JsonList = JsonList()
  protected val workdayStart: Time = "9:00am"
}