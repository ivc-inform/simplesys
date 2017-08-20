package com.simplesys.isc.system.typesDyn


sealed abstract trait EmbeddedPosition

case object embPosNull extends EmbeddedPosition {
  override def toString = ""
}

case object embPosExpand extends EmbeddedPosition {
  override def toString = "expand"
}

case object embPosWithin extends EmbeddedPosition {
  override def toString = "within"
}



