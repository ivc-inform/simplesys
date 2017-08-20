

package com.simplesys.isc.system.typesDyn


sealed abstract trait SummaryFunction

case object smfNull extends SummaryFunction {
  override def toString = ""
}

case object smfSum extends SummaryFunction {
  override def toString = "sum"
}

case object smfAvg extends SummaryFunction {
  override def toString = "avg"
}

case object smfMax extends SummaryFunction {
  override def toString = "max"
}

case object smfMin extends SummaryFunction {
  override def toString = "min"
}

case object smfNultiplier extends SummaryFunction {
  override def toString = "multiplier"
}

case object smfCount extends SummaryFunction {
  override def toString = "count"
}

case object smfTitle extends SummaryFunction {
  override def toString = "title"
}


