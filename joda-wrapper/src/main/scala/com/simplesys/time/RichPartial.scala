
package com.simplesys.time

import org.joda.time._

class RichPartial(proxy: Partial) {
  def formatter = proxy.getFormatter

  def -(period: ReadablePeriod): Partial =
    proxy.minus(period)
  def -(builder: DurationBuilder): Partial =
    proxy.minus(builder.proxy)
  def +(period: ReadablePeriod): Partial =
    proxy.plus(period)
  def +(builder: DurationBuilder): Partial =
    proxy.plus(builder.proxy)
}
