
package com.simplesys.time

import org.joda.time._

class RichChronology(proxy: Chronology) {
  def zone: Option[DateTimeZone] =
    nullCheck(proxy.getZone)
  private def nullCheck[T <: AnyRef](x: T): Option[T] =
    if (x == null) None else Some(x)
}
