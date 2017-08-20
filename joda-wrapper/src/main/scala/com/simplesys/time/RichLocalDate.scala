
package com.simplesys.time

import org.joda.time._

class RichLocalDate(proxy: LocalDate) {
  def -(period: ReadablePeriod): LocalDate =
    proxy.minus(period)
  def -(builder: DurationBuilder): LocalDate =
    proxy.minus(builder.proxy)
  def +(period: ReadablePeriod): LocalDate =
    proxy.plus(period)
  def +(builder: DurationBuilder): LocalDate =
    proxy.plus(builder.proxy)

  def day: LocalDate.Property = proxy.dayOfMonth
  def week: LocalDate.Property = proxy.weekOfWeekyear
  def month: LocalDate.Property = proxy.monthOfYear
  def year: LocalDate.Property = proxy.year
  def century: LocalDate.Property = proxy.centuryOfEra
  def era: LocalDate.Property = proxy.era

  def withDay(day: Int) = proxy.withDayOfMonth(day)
  def withWeek(week: Int) = proxy.withWeekOfWeekyear(week)
  def withMonth(month: Int) = proxy.withMonthOfYear(month)
  def withYear(year: Int) = proxy.withYear(year)
  def withCentury(century: Int) = proxy.withCenturyOfEra(century)
  def withEra(era: Int) = proxy.withEra(era)

  def interval = proxy.toInterval
}
