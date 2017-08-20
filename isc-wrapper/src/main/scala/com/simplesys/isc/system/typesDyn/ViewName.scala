package com.simplesys.isc.system.typesDyn


sealed abstract trait ViewName

case object vwNmNull extends ViewName {
  override def toString = ""
}

case object vwNmDay extends ViewName {
  override def toString = "day"
}

case object vwNmWeek extends ViewName {
  override def toString = "week"
}

case object vwNmMonth extends ViewName {
  override def toString = "month"
}
