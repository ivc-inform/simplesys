package com.simplesys.isc.system.typesDyn


sealed abstract trait DSServerType

case object srvtpSQL extends DSServerType {
  override def toString = "sql"
}