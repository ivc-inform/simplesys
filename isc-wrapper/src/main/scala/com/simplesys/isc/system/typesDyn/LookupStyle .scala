
package com.simplesys.isc.system.typesDyn


sealed abstract trait LookupStyle

case object lkstlNew extends LookupStyle {
  override def toString = "new"
}

case object lkstFactory extends LookupStyle {
  override def toString = "factory"
}

case object lkstSprong extends LookupStyle {
  override def toString = "spring"
}
