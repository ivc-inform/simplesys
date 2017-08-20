package com.simplesys.isc.system.typesDyn


sealed abstract trait ChartType

case object chrtTpArea extends ChartType {
  override def toString = "Area"
}

case object chrtTpColumn extends ChartType {
  override def toString = "Column"
}

case object chrtTpBar extends ChartType {
  override def toString = "Bar"
}

case object chrtTpLine extends ChartType {
  override def toString = "Line"
}

case object chrtTpRadar extends ChartType {
  override def toString = "Radar"
}

case object chrtTp extends ChartType {
  override def toString = "Pie"
}

case object chrtTpDoughnut extends ChartType {
  override def toString = "Doughnut"
}
