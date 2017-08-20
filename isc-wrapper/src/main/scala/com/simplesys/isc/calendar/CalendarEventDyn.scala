package com.simplesys.isc.calendar

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._

object CalendarEventDyn {
  implicit def CalendarEventtoJsonObject(in: CalendarEventDyn): JsonObject = in json
}

class CalendarEventDyn extends ClassDyn with CalendarEventDynInit {
  private[this] var _canEdit: String = canEdit
  def CanEdit = _canEdit
  def CanEdit_=(value: String) {
    if (_canEdit == value) return
    json("canEdit") = value
    _canEdit = value
  }

  private[this] var _description: String = description
  def Description = _description
  def Description_=(value: String) {
    if (_description == value) return
    json("description") = value
    _description = value
  }

  private[this] var _endDate: Date = endDate
  def EndDate = _endDate
  def EndDate_=(value: Date) {
    if (_endDate == value) return
    json("endDate") = value
    _endDate = value
  }

  private[this] var _eventWindowStyle: CSSStyleName = eventWindowStyle
  def EventWindowStyle = _eventWindowStyle
  def EventWindowStyle_=(value: CSSStyleName) {
    if (_eventWindowStyle == value) return
    json("eventWindowStyle") = value
    _eventWindowStyle = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _startDate: Date = startDate
  def StartDate = _startDate
  def StartDate_=(value: Date) {
    if (_startDate == value) return
    json("startDate") = value
    _startDate = value
  }
}