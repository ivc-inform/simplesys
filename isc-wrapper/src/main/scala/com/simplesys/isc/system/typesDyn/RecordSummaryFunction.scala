
package com.simplesys.isc.system.typesDyn


sealed abstract trait RecordSummaryFunction

case object rcSumFncNull extends RecordSummaryFunction {
  override def toString = ""
}

case object rcSumFncSum extends RecordSummaryFunction {
  override def toString = "sum"
}

case object rcSumFncAvg extends RecordSummaryFunction {
  override def toString = "avg"
}

case object rcSumFncMax extends RecordSummaryFunction {
  override def toString = "max"
}

case object rcSumFncMin extends RecordSummaryFunction {
  override def toString = "min"
}

case object rcSumFncMultiplier extends RecordSummaryFunction {
  override def toString = "sum"
}

