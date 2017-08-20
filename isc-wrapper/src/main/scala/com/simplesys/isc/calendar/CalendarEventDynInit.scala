package com.simplesys.isc.calendar

import com.simplesys.isc.system.misc._
import com.simplesys.isc.config.StoredData

trait CalendarEventDynInit extends StoredData {
  protected val canEdit: String = ""
  protected val description: String = ""
  protected val endDate: Date = ""
  protected val eventWindowStyle: CSSStyleName = ""
  protected val name: String = ""
  protected val startDate: Date = ""
}