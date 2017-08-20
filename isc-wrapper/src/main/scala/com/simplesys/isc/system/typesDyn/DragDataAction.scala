package com.simplesys.isc.system.typesDyn


sealed abstract trait DragDataAction

case object drgDtActNone extends DragDataAction {
  override def toString = "none"
}

case object drgDtActCopy extends DragDataAction {
  override def toString = "copy"
}

case object drgDtActMove extends DragDataAction {
  override def toString = "move"
}



