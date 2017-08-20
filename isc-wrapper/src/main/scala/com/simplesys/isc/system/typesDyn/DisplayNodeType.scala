package com.simplesys.isc.system.typesDyn


sealed abstract trait DisplayNodeType

case object dspNdTpNull extends DisplayNodeType {
  override def toString = ""
}

case object dspNdTpFolders extends DisplayNodeType {
  override def toString = "folders"
}

case object dspNdTpLeaves extends DisplayNodeType {
  override def toString = "leaves"
}


