

package com.simplesys.isc.system.typesDyn


sealed abstract trait SQLType

case object sqlTpNull extends SQLType {
  override def toString = ""
}

case object sqlTpQuery extends SQLType {
  override def toString = "query"
}

case object sqlTpUpdate extends SQLType {
  override def toString = "update"
}


