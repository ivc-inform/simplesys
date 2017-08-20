
package com.simplesys.time

import java.util.Locale
import org.joda.time._
import org.joda.time.format._

object StaticDateTimeFormat extends StaticDateTimeFormat

trait StaticDateTimeFormat {
  def forPattern(pattern: String): DateTimeFormatter =
    DateTimeFormat.forPattern(pattern)
  def forStyle(style: String): DateTimeFormatter =
    DateTimeFormat.forStyle(style)
  def fullDate(): DateTimeFormatter = DateTimeFormat.fullDate()
  def fullDateTime(): DateTimeFormatter = DateTimeFormat.fullDateTime()
  def fullTime(): DateTimeFormatter = DateTimeFormat.fullTime()
  def longDate(): DateTimeFormatter = DateTimeFormat.longDate()
  def longDateTime(): DateTimeFormatter = DateTimeFormat.longDateTime()
  def longTime(): DateTimeFormatter = DateTimeFormat.longTime()
  def mediumDate(): DateTimeFormatter = DateTimeFormat.mediumDate()
  def mediumDateTime(): DateTimeFormatter = DateTimeFormat.mediumDateTime()
  def mediumTime(): DateTimeFormatter = DateTimeFormat.mediumTime()
  def patternForStyle(style: String, locale: Locale): String =
    DateTimeFormat.patternForStyle(style, locale)
  def shortDate(): DateTimeFormatter = DateTimeFormat.shortDate()
  def shortDateTime(): DateTimeFormatter = DateTimeFormat.shortDateTime()
  def shortTime(): DateTimeFormatter = DateTimeFormat.shortTime()
}
