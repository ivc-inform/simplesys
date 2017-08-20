
package com.simplesys.time

import com.simplesys.time.Implicits._
import org.joda.time._

object StaticInterval extends StaticInterval

trait StaticInterval {
  def thisSecond = StaticDateTime.now.second.interval
  def thisMinute = StaticDateTime.now.minute.interval
  def thisHour = StaticDateTime.now.hour.interval
  def thisDay = StaticDateTime.now.day.interval
  def today = StaticDateTime.now.day.interval
  def thisWeek = StaticDateTime.now.week.interval
  def thisMonth = StaticDateTime.now.month.interval
  def thisYear = StaticDateTime.now.year.interval

  def nextSecond = StaticDateTime.nextSecond.second.interval
  def nextMinute = StaticDateTime.nextMinute.minute.interval
  def nextHour = StaticDateTime.nextHour.hour.interval
  def nextDay = StaticDateTime.nextDay.day.interval
  def tomorrow = StaticDateTime.nextDay.day.interval
  def nextWeek = StaticDateTime.nextWeek.week.interval
  def nextMonth = StaticDateTime.nextMonth.month.interval
  def nextYear = StaticDateTime.nextYear.year.interval

  def lastSecond = StaticDateTime.lastSecond.second.interval
  def lastMinute = StaticDateTime.lastMinute.minute.interval
  def lastHour = StaticDateTime.lastHour.hour.interval
  def lastDay = StaticDateTime.lastDay.day.interval
  def yesterday = StaticDateTime.lastDay.day.interval
  def lastWeek = StaticDateTime.lastWeek.week.interval
  def lastMonth = StaticDateTime.lastMonth.month.interval
  def lastYear = StaticDateTime.lastYear.year.interval
}
