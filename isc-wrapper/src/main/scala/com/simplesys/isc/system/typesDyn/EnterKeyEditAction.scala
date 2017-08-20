
package com.simplesys.isc.system.typesDyn


sealed abstract trait EnterKeyEditAction

case object entrKeyEdActDone extends EnterKeyEditAction {
  override def toString = "done"
}

case object entrKeyEdActnExtCell extends EnterKeyEditAction {
  override def toString = "nextCell"
}

case object entrKeyEdActNextRow extends EnterKeyEditAction {
  override def toString = "nextRow"
}

case object entrKeyEdActNextRowStart extends EnterKeyEditAction {
  override def toString = "nextRowStart"
}
