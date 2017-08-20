

package com.simplesys.isc.system.typesDyn


sealed abstract trait State

case object stNull extends State {
  override def toString = ""
}

case object stDown extends State {
  override def toString = "Down"
}

case object stOver extends State {
  override def toString = "Over"
}

case object stDisabled extends State {
  override def toString = "Disabled"
}


