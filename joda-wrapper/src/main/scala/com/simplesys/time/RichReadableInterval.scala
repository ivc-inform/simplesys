
package com.simplesys.time

import org.joda.time._

class RichReadableInterval(proxy: ReadableInterval) {
  def chronology: Chronology =
    proxy.getChronology
  def end: DateTime =
    proxy.getEnd
  def start: DateTime =
    proxy.getStart

  def duration: Duration =
    proxy.toDuration
  def millis: Long =
    proxy.toDuration.getMillis
  // TODO: Should > and > be added as aliases for isAfter and isBefore?
  //   could be convenient, or just confusing because this isn't Ordered.
}
