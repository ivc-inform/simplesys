
package com.simplesys.time

import java.util.Locale
import org.joda.time._

class RichLocalDateTimeProperty(proxy: LocalDateTime.Property) {
  def localDateTime: LocalDateTime =
    proxy.getLocalDateTime
  def roundFloor: LocalDateTime =
    proxy.roundFloorCopy
  def roundCeiling: LocalDateTime =
    proxy.roundCeilingCopy
  def roundDown: LocalDateTime =
    proxy.roundFloorCopy
  def roundUp: LocalDateTime =
    proxy.roundCeilingCopy
  def round: LocalDateTime =
    proxy.roundHalfEvenCopy

  def apply(value: Int): LocalDateTime = proxy.setCopy(value)
  def apply(text: String): LocalDateTime = proxy.setCopy(text)
  def apply(text: String, locale: Locale): LocalDateTime =
    proxy.setCopy(text, locale)
}
