
package com.simplesys.time

import org.joda.time._

class RichReadablePartial(proxy: ReadablePartial) {
  def chronology = proxy.getChronology
}
