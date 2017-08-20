
package com.simplesys.time

import java.util.Locale
import org.joda.time._

class RichPartialProperty(proxy: Partial.Property) {
  def partial: Partial =
    proxy.getPartial

  def apply(value: Int): Partial = proxy.setCopy(value)
  def apply(text: String): Partial = proxy.setCopy(text)
  def apply(text: String, locale: Locale): Partial =
    proxy.setCopy(text, locale)
}
