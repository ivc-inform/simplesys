
package com.simplesys.time

import org.joda.time._

class RichPeriod(proxy: Period) {
  def days: Int =
    proxy.getDays
  def hours: Int =
    proxy.getHours
  def millis: Int =
    proxy.getMillis
  def minutes: Int =
    proxy.getMinutes
  def months: Int =
    proxy.getMonths
  def seconds: Int =
    proxy.getSeconds
  def weeks: Int =
    proxy.getWeeks
  def years: Int =
    proxy.getYears
  def -(period: ReadablePeriod): Period =
    proxy.minus(period)
  def +(period: ReadablePeriod): Period =
    proxy.plus(period)
  def ago: DateTime =
    StaticDateTime.now.minus(proxy)
  def later: DateTime =
    StaticDateTime.now.plus(proxy)
  def from(dt: DateTime): DateTime =
    dt.plus(proxy)
  def before(dt: DateTime): DateTime =
    dt.minus(proxy)

  def standardDuration: Duration =
    proxy.toStandardDuration
}
