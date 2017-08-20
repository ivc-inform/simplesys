package com.simplesys.isc.system.typesDyn


sealed abstract trait AttributeScope

case object attrNull extends AttributeScope {
  override def toString = ""
}

case object attrRequest extends AttributeScope {
  override def toString = "request"
}

case object attrSession extends AttributeScope {
  override def toString = "session"
}

case object attrApplication extends AttributeScope {
  override def toString = "application"
}


