package com.simplesys.isc.system.typesDyn


sealed abstract trait Cursor

case object crDefault extends Cursor {
  override def toString = "default"
}

case object crAuto extends Cursor {
  override def toString = "auto"
}

case object crHand extends Cursor {
  override def toString = "hand"
}

case object crWait extends Cursor {
  override def toString = "wait"
}

case object crPointer extends Cursor {
  override def toString = "pointer"
}

case object crMove extends Cursor {
  override def toString = "move"
}

case object crHelp extends Cursor {
  override def toString = "help"
}

case object crText extends Cursor {
  override def toString = "text"
}

case object crAllScroll extends Cursor {
  override def toString = "all-scroll"
}

case object crArrow extends Cursor {
  override def toString = "arrow"
}

case object crCrosshair extends Cursor {
  override def toString = "crosshair"
}

case object crColResize extends Cursor {
  override def toString = "col-resize"
}

case object crRowResize extends Cursor {
  override def toString = "row-resize"
}

case object crEResize extends Cursor {
  override def toString = "e-resize"
}

case object crWResize extends Cursor {
  override def toString = "w-resize"
}

case object crNResize extends Cursor {
  override def toString = "n-resize"
}

case object crSResize extends Cursor {
  override def toString = "s-resize"
}

case object crSeResize extends Cursor {
  override def toString = "se-resize"
}

case object crNeResize extends Cursor {
  override def toString = "ne-resize"
}

case object crNwResize extends Cursor {
  override def toString = "nw-resize"
}

case object crSwResize extends Cursor {
  override def toString = "sw-resize"
}

case object crNotAllowed extends Cursor {
  override def toString = "not-allowed"
}



