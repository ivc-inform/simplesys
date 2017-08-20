
package com.simplesys.time

import java.util.Locale
import org.joda.time._
import org.joda.time.format.{DateTimeFormatter, DateTimeParser,
DateTimePrinter}

class RichDateTimeFormatter(proxy: DateTimeFormatter) {
  def chronology: Chronology = proxy.getChronology
  def locale: Locale = proxy.getLocale
  def parser: DateTimeParser = proxy.getParser
  def pivotYear: Int = proxy.getPivotYear.intValue
  def printer: DateTimePrinter = proxy.getPrinter
  def zone: DateTimeZone = proxy.getZone
  def parseOption(text: String): Option[DateTime] =
    try {
      Some(proxy.parseDateTime(text))
    } catch {
      case _: UnsupportedOperationException => None
      case _: IllegalArgumentException => None
    }
}
