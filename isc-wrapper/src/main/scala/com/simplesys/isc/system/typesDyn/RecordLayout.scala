

package com.simplesys.isc.system.typesDyn


sealed abstract trait RecordLayout

case object rcLytTitleOnly extends RecordLayout {
  override def toString = "titleOnly"
}

case object rcLytTitleAndDescription extends RecordLayout {
  override def toString = "titleAndDescription"
}

case object rcLytSummaryInfo extends RecordLayout {
  override def toString = "summaryInfo"
}

case object rcLytSummaryData extends RecordLayout {
  override def toString = "summaryData"
}

case object rcLytSummaryFull extends RecordLayout {
  override def toString = "summaryFull"
}

