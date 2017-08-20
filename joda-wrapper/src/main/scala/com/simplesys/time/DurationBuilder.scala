
package com.simplesys.time

import org.joda.time._

private[time] object DurationBuilder {
  def apply(proxy: Period): DurationBuilder =
    new DurationBuilder(proxy)
}

// Duration Builder
sealed private[time] class DurationBuilder(val proxy: Period) {
  // DurationBuilder + DurationBuilder = DurationBuilder
  // This is the only operation that can maintain a DurationBuilder
  // Everything else kicks us out to DateTime, Duration, or Period
  def +(that: DurationBuilder): DurationBuilder =
    DurationBuilder(this.proxy.plus(that.proxy))

  def ago: DateTime =
    StaticDateTime.now.minus(proxy)
  def later: DateTime =
    StaticDateTime.now.plus(proxy)
  def from(dt: DateTime): DateTime =
    dt.plus(proxy)
  def before(dt: DateTime): DateTime =
    dt.minus(proxy)

  def standardDuration: Duration =
    proxy.toStandardDuration
  def toDuration: Duration =
    proxy.toStandardDuration
  def toPeriod: Period =
    proxy

  def -(period: ReadablePeriod): Period =
    proxy.minus(period)
  def +(period: ReadablePeriod): Period =
    proxy.plus(period)

  def millis: Long =
    proxy.toStandardDuration.getMillis
  def seconds: Long =
    proxy.toStandardDuration.getStandardSeconds
  def -(amount: Long): Duration =
    proxy.toStandardDuration.minus(amount)
  def -(amount: ReadableDuration): Duration =
    proxy.toStandardDuration.minus(amount)
  def +(amount: Long): Duration =
    proxy.toStandardDuration.plus(amount)
  def +(amount: ReadableDuration): Duration =
    proxy.toStandardDuration.plus(amount)
}
