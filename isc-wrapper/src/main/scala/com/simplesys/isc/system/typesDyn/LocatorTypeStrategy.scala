
package com.simplesys.isc.system.typesDyn


sealed abstract trait LocatorTypeStrategy

case object lctTpStrgNull extends LocatorTypeStrategy {
  override def toString = ""
}

case object lctTpStrgClass extends LocatorTypeStrategy {
  override def toString = "Class"
}

case object lctTpStrgScClass extends LocatorTypeStrategy {
  override def toString = "scClass"
}

case object lctTpStrgRole extends LocatorTypeStrategy {
  override def toString = "role"
}

case object lctTpStrgNone extends LocatorTypeStrategy {
  override def toString = "none"
}

