
package com.simplesys.time

import org.joda.time._

class RichDateTime(proxy: DateTime) {
  def -(duration: Long): DateTime =
    proxy.minus(duration)
  def -(duration: ReadableDuration): DateTime =
    proxy.minus(duration)
  def -(period: ReadablePeriod): DateTime =
    proxy.minus(period)
  def -(builder: DurationBuilder): DateTime =
    proxy.minus(builder.proxy)
  def +(duration: Long): DateTime =
    proxy.plus(duration)
  def +(duration: ReadableDuration): DateTime =
    proxy.plus(duration)
  def +(period: ReadablePeriod): DateTime =
    proxy.plus(period)
  def +(builder: DurationBuilder): DateTime =
    proxy.plus(builder.proxy)

  def second: DateTime.Property = proxy.secondOfMinute
  def minute: DateTime.Property = proxy.minuteOfHour
  def hour: DateTime.Property = proxy.hourOfDay
  def day: DateTime.Property = proxy.dayOfMonth
  def week: DateTime.Property = proxy.weekOfWeekyear
  def month: DateTime.Property = proxy.monthOfYear
  def year: DateTime.Property = proxy.year
  def century: DateTime.Property = proxy.centuryOfEra
  def era: DateTime.Property = proxy.era

  def withSecond(second: Int) = proxy.withSecondOfMinute(second)
  def withMinute(minute: Int) = proxy.withMinuteOfHour(minute)
  def withHour(hour: Int) = proxy.withHourOfDay(hour)
  def withDay(day: Int) = proxy.withDayOfMonth(day)
  def withWeek(week: Int) = proxy.withWeekOfWeekyear(week)
  def withMonth(month: Int) = proxy.withMonthOfYear(month)
  def withYear(year: Int) = proxy.withYear(year)
  def withCentury(century: Int) = proxy.withCenturyOfEra(century)
  def withEra(era: Int) = proxy.withEra(era)
}
