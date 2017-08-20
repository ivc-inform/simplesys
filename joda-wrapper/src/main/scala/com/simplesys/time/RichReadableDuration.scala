
package com.simplesys.time

import org.joda.time._

class RichReadableDuration(proxy: ReadableDuration) extends Ordered[ReadableDuration] {
  def millis: Long =
    proxy.getMillis
  def compare(other: ReadableDuration): Int =
    proxy.compareTo(other)
}
