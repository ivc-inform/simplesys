package com.simplesys.isc.system.typesDyn


sealed abstract trait DragTrackerMode

case object drgTrcModeNone extends DragTrackerMode {
  override def toString = "none"
}

case object drgTrcModeIcon extends DragTrackerMode {
  override def toString = "icon"
}

case object drgTrcModeTitle extends DragTrackerMode {
  override def toString = "title"
}

case object drgTrcModeRecord extends DragTrackerMode {
  override def toString = "record"
}



