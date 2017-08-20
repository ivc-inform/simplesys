
package com.simplesys.isc.system.typesDyn


sealed abstract trait SortArrow

case object srtArrNull extends SortArrow {
  override def toString = ""
}

case object srtArrNone extends SortArrow {
  override def toString = "none"
}

case object srtArrCorner extends SortArrow {
  override def toString = "corner"
}

case object srtArrField extends SortArrow {
  override def toString = "field"
}

case object srtArrBoth extends SortArrow {
  override def toString = "both"
}


