package com.simplesys.isc.system.typesDyn


sealed abstract trait JSONDateFormat

case object jsonDtFmtXmlSchema extends JSONDateFormat {
  override def toString = "xmlSchema"
}

case object jsonDtFmtDateConstructor extends JSONDateFormat {
  override def toString = "dateConstructor"
}

