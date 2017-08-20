
package com.simplesys.time

import org.joda.time._

class RichReadableDateTime(proxy: ReadableDateTime) {
  def second: Int =
    proxy.getSecondOfMinute
  def minute: Int =
    proxy.getMinuteOfHour
  def hour: Int =
    proxy.getHourOfDay
  def day: Int =
    proxy.getDayOfMonth
  def week: Int =
    proxy.getWeekOfWeekyear
  def month: Int =
    proxy.getMonthOfYear
  def year: Int =
    proxy.getYear
  def century: Int =
    proxy.getCenturyOfEra

  def dateTime: DateTime =
    proxy.toDateTime
  def mutableDateTime: MutableDateTime =
    proxy.toMutableDateTime
}
