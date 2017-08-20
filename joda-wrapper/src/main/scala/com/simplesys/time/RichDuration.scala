
package com.simplesys.time

import org.joda.time._

class RichDuration(proxy: Duration) {
  def seconds: Long =
    proxy.getStandardSeconds
  def -(amount: Long): Duration =
    proxy.minus(amount)
  def -(amount: ReadableDuration): Duration =
    proxy.minus(amount)
  def +(amount: Long): Duration =
    proxy.plus(amount)
  def +(amount: ReadableDuration): Duration =
    proxy.plus(amount)
}
