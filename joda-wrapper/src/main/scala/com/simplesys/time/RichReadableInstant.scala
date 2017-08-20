
package com.simplesys.time

import org.joda.time._

class RichReadableInstant(proxy: ReadableInstant) extends Ordered[ReadableInstant] {
  def chronology: Chronology =
    proxy.getChronology
  def millis: Long =
    proxy.getMillis
  def zone: DateTimeZone =
    proxy.getZone
  override def compare(that: ReadableInstant): Int =
    proxy.compareTo(that)

  def to(other: ReadableInstant): Interval =
    new Interval(proxy, other)

  def instant: Instant =
    proxy.toInstant
}
