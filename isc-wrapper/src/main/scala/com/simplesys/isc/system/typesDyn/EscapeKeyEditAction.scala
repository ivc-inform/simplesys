
package com.simplesys.isc.system.typesDyn


sealed abstract trait EscapeKeyEditAction

case object escKeyEdActCancel extends EscapeKeyEditAction {
  override def toString = "cancel"
}

case object escKeyEdActDone extends EscapeKeyEditAction {
  override def toString = "done"
}
