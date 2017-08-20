
package com.simplesys.time

import org.joda.time._

class RichLocalDateTime(proxy: LocalDateTime) {
  def -(duration: ReadableDuration): LocalDateTime =
    proxy.minus(duration)
  def -(period: ReadablePeriod): LocalDateTime =
    proxy.minus(period)
  def -(builder: DurationBuilder): LocalDateTime =
    proxy.minus(builder.proxy)
  def +(duration: ReadableDuration): LocalDateTime =
    proxy.plus(duration)
  def +(period: ReadablePeriod): LocalDateTime =
    proxy.plus(period)
  def +(builder: DurationBuilder): LocalDateTime =
    proxy.plus(builder.proxy)

  def second: LocalDateTime.Property = proxy.secondOfMinute
  def minute: LocalDateTime.Property = proxy.minuteOfHour
  def hour: LocalDateTime.Property = proxy.hourOfDay
  def day: LocalDateTime.Property = proxy.dayOfMonth
  def week: LocalDateTime.Property = proxy.weekOfWeekyear
  def month: LocalDateTime.Property = proxy.monthOfYear
  def year: LocalDateTime.Property = proxy.year
  def century: LocalDateTime.Property = proxy.centuryOfEra
  def era: LocalDateTime.Property = proxy.era

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
