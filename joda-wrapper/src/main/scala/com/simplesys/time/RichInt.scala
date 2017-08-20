
package com.simplesys.time

import org.joda.time._

class RichInt(n: Int) {
  // These units of time can build durations or periods.
  // At most we lose a leap second. (Unless someone adopts
  // leap minutes).
  def millis = DurationBuilder(Period.millis(n))
  def seconds = DurationBuilder(Period.seconds(n))
  def minutes = DurationBuilder(Period.minutes(n))
  def hours = DurationBuilder(Period.hours(n))

  // These units of time can only be periods. At this
  // point if we made durations automatically we'd start
  // getting into trouble with daylight savings time,
  // monthly differences, leap years, etc.
  def days = Period.days(n)
  def weeks = Period.weeks(n)
  def months = Period.months(n)
  def years = Period.years(n)

  // See above.
  def milli = DurationBuilder(Period.millis(n))
  def second = DurationBuilder(Period.seconds(n))
  def minute = DurationBuilder(Period.minutes(n))
  def hour = DurationBuilder(Period.hours(n))

  // See above.
  def day = Period.days(n)
  def week = Period.weeks(n)
  def month = Period.months(n)
  def year = Period.years(n)
}
