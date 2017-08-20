

package com.simplesys.isc.system.typesDyn


sealed abstract trait LocatorStrategy

case object lcStrgNull extends LocatorStrategy {
  override def toString = ""
}

case object lcStrgName extends LocatorStrategy {
  override def toString = "name"
}

case object lcStrgTitle extends LocatorStrategy {
  override def toString = "title"
}

case object lcStrgIndex extends LocatorStrategy {
  override def toString = "index"
}


