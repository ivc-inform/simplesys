
package com.simplesys.time

import org.joda.time._

class RichInstant(proxy: Instant) {
  def -(duration: Long): Instant =
    proxy.minus(duration)
  def -(duration: ReadableDuration): Instant =
    proxy.minus(duration)
  def +(duration: Long): Instant =
    proxy.plus(duration)

  def +(duration: ReadableDuration): Instant =
    proxy.plus(duration)
}
