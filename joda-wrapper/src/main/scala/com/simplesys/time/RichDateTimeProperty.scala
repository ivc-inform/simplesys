
package com.simplesys.time

import java.util.Locale
import org.joda.time._

class RichDateTimeProperty(proxy: DateTime.Property) {
  def dateTime: DateTime =
    proxy.getDateTime
  def roundFloor: DateTime =
    proxy.roundFloorCopy
  def roundCeiling: DateTime =
    proxy.roundCeilingCopy
  def roundDown: DateTime =
    proxy.roundFloorCopy
  def roundUp: DateTime =
    proxy.roundCeilingCopy
  def round: DateTime =
    proxy.roundHalfEvenCopy

  def apply(value: Int): DateTime = proxy.setCopy(value)
  def apply(text: String): DateTime = proxy.setCopy(text)
  def apply(text: String, locale: Locale): DateTime =
    proxy.setCopy(text, locale)
}
