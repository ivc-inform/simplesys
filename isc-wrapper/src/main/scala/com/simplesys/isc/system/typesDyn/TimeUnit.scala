
package com.simplesys.isc.system.typesDyn


sealed abstract trait TimeUnit

case object tmUntMillisecond extends TimeUnit {
  override def toString = "millisecond"
}

case object tmUntSecond extends TimeUnit {
  override def toString = "second"
}

case object tmUntMinute extends TimeUnit {
  override def toString = "minute"
}

case object tmUntHour extends TimeUnit {
  override def toString = "hour"
}

case object tmUntDay extends TimeUnit {
  override def toString = "day"
}

case object tmUntWeek extends TimeUnit {
  override def toString = "week"
}

case object tmUntMonth extends TimeUnit {
  override def toString = "month"
}

case object tmUntQuarter extends TimeUnit {
  override def toString = "quarter"
}

case object tmUntYear extends TimeUnit {
  override def toString = "year"
}

