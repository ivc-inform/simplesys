
package com.simplesys.time

import org.joda.time._

class RichReadablePeriod(proxy: ReadablePeriod) {
  def periodType: PeriodType =
    proxy.getPeriodType
}
