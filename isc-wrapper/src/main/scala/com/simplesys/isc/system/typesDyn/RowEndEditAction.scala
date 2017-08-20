
package com.simplesys.isc.system.typesDyn


sealed abstract trait RowEndEditAction

case object rwEndEdActNull extends RowEndEditAction {
  override def toString = ""
}

case object rwEndEdActSame extends RowEndEditAction {
  override def toString = "same"
}

case object rwEndEdActNext extends RowEndEditAction {
  override def toString = "next"
}

case object rwEndEdActDone extends RowEndEditAction {
  override def toString = "done"
}

case object rwEndEdActStop extends RowEndEditAction {
  override def toString = "stop"
}

case object rwEndEdActNone extends RowEndEditAction {
  override def toString = "none"
}


