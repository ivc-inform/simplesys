
package com.simplesys.time

import org.joda.time._

class RichDateTimeZone(proxy: DateTimeZone) {
  def id: String =
    proxy.getID
}
