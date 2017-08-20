
package com.simplesys.isc.system.typesDyn


sealed abstract trait NavigationMode

case object nvMdWholeRecord extends NavigationMode {
  override def toString = "wholeRecord"
}

case object nvMdNavIconOnly extends NavigationMode {
  override def toString = "navIconOnly"
}
