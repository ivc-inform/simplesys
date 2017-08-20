package com.simplesys.isc.system.typesDyn


sealed abstract trait ContentLayout

case object cntlytVertical extends ContentLayout {
  override def toString = "vertical"
}

case object cntlytHorizontal extends ContentLayout {
  override def toString = "horizontal"
}


