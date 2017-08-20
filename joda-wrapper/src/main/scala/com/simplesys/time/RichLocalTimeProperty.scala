
package com.simplesys.time

import java.util.Locale
import org.joda.time._

class RichLocalTimeProperty(proxy: LocalTime.Property) {
  def localTime: LocalTime =
    proxy.getLocalTime
  def roundFloor: LocalTime =
    proxy.roundFloorCopy
  def roundCeiling: LocalTime =
    proxy.roundCeilingCopy
  def roundDown: LocalTime =
    proxy.roundFloorCopy
  def roundUp: LocalTime =
    proxy.roundCeilingCopy
  def round: LocalTime =
    proxy.roundHalfEvenCopy

  def apply(value: Int): LocalTime = proxy.setCopy(value)
  def apply(text: String): LocalTime = proxy.setCopy(text)
  def apply(text: String, locale: Locale): LocalTime =
    proxy.setCopy(text, locale)
}
