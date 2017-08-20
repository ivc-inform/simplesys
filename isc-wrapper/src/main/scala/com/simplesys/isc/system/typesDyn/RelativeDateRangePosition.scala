
package com.simplesys.isc.system.typesDyn


sealed abstract trait RelativeDateRangePosition

case object rlDtRngPosNull extends RelativeDateRangePosition {
  override def toString = ""
}

case object rlDtRngPosStart extends RelativeDateRangePosition {
  override def toString = "start"
}

case object rlDtRngPosEnd extends RelativeDateRangePosition {
  override def toString = "end"
}


