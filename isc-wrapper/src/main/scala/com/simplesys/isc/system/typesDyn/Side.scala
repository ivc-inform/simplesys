package com.simplesys.isc.system.typesDyn


sealed abstract trait Side

case object sdNull extends Side {
  override def toString = ""
}

case object sdLeft extends Side {
  override def toString = "left"
}

case object sdRight extends Side {
  override def toString = "right"
}

case object sdTop extends Side {
  override def toString = "top"
}

case object sdBottom extends Side {
  override def toString = "bottom"
}
