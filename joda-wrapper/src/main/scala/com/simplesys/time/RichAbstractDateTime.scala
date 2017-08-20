
package com.simplesys.time

import java.util.{Locale, Calendar}
import org.joda.time.base.AbstractDateTime

class RichAbstractDateTime(proxy: AbstractDateTime) {
  def calendar(locale: Locale): Calendar =
    proxy.toCalendar(locale)
  def gregorianCalendar: Calendar =
    proxy.toGregorianCalendar
}
