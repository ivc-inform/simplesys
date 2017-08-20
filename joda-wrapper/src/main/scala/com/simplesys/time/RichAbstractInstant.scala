
package com.simplesys.time

import java.util.Date
import org.joda.time._
import org.joda.time.base.AbstractInstant

class RichAbstractInstant(proxy: AbstractInstant) {
  def date: Date =
    proxy.toDate
  def dateTime: DateTime =
    proxy.toDateTime
  def dateTime(chronology: Chronology): DateTime =
    proxy.toDateTime(chronology)
  def dateTime(zone: DateTimeZone): DateTime =
    proxy.toDateTime(zone)
  def dateTimeISO: DateTime =
    proxy.toDateTimeISO
  def instant: Instant =
    proxy.toInstant
  def mutableDateTime: MutableDateTime =
    proxy.toMutableDateTime
  def mutableDateTime(chronology: Chronology): MutableDateTime =
    proxy.toMutableDateTime(chronology)
  def mutableDateTime(zone: DateTimeZone): MutableDateTime =
    proxy.toMutableDateTime(zone)
  def mutableDateTimeISO: MutableDateTime =
    proxy.toMutableDateTimeISO
}
