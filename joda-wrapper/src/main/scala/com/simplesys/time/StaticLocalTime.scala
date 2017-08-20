
package com.simplesys.time

import java.util.{Calendar, Date}
import org.joda.time._
import com.simplesys.time.Implicits._

object StaticLocalTime extends StaticLocalTime

trait StaticLocalTime {
  type Property = LocalTime.Property

  final val MIDNIGHT = LocalTime.MIDNIGHT
  final val Midnight = LocalTime.MIDNIGHT

  def fromCalendarFields(calendar: Calendar) =
    LocalTime.fromCalendarFields(calendar)
  def fromDateFields(date: Date) =
    LocalTime.fromDateFields(date)
  def fromMillisOfDay(millis: Long) =
    LocalTime.fromMillisOfDay(millis)
  def fromMillisOfDay(millis: Long, chrono: Chronology) =
    LocalTime.fromMillisOfDay(millis, chrono)

  def now = new LocalTime

  def nextSecond = now + 1.second
  def nextMinute = now + 1.minute
  def nextHour = now + 1.hour

  def lastSecond = now - 1.second
  def lastMinute = now - 1.minute
  def lastHour = now - 1.hour
}
