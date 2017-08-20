
package com.simplesys.isc.system.typesDyn


sealed abstract trait LayoutPolicy

case object lyPlsNone extends LayoutPolicy {
  override def toString = "none"
}

case object lyPlsFill extends LayoutPolicy {
  override def toString = "fill"
}




