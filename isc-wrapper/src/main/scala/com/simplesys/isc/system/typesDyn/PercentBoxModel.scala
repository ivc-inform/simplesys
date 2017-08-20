package com.simplesys.isc.system.typesDyn


sealed abstract trait PercentBoxModel

case object prBxMdVisible extends PercentBoxModel {
  override def toString = "visible"
}

case object prBxMdViewport extends PercentBoxModel {
  override def toString = "viewport"
}
