
package com.simplesys.time

import java.util.Locale
import org.joda.time._

class RichLocalDateProperty(proxy: LocalDate.Property) {
  def localDate: LocalDate =
    proxy.getLocalDate
  def roundFloor: LocalDate =
    proxy.roundFloorCopy
  def roundCeiling: LocalDate =
    proxy.roundCeilingCopy
  def roundDown: LocalDate =
    proxy.roundFloorCopy
  def roundUp: LocalDate =
    proxy.roundCeilingCopy
  def round: LocalDate =
    proxy.roundHalfEvenCopy

  def apply(value: Int): LocalDate = proxy.setCopy(value)
  def apply(text: String): LocalDate = proxy.setCopy(text)
  def apply(text: String, locale: Locale): LocalDate =
    proxy.setCopy(text, locale)
}
