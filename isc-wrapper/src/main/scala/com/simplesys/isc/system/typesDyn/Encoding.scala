package com.simplesys.isc.system.typesDyn


sealed abstract trait Encoding

case object encdNormal extends Encoding {
  override def toString = "normal"
}

case object encdMultipart extends Encoding {
  override def toString = "multipart"
}


