package com.simplesys.isc.system.typesDyn


sealed abstract trait DrawPosition

case object drvPsBeforeBegin extends DrawPosition {
  override def toString = "beforeBegin"
}

case object drvPsAfterBegin extends DrawPosition {
  override def toString = "afterBegin"
}

case object drvPsBeforeEnd extends DrawPosition {
  override def toString = "beforeEnd"
}

case object drvPsAfterEnd extends DrawPosition {
  override def toString = "afterEnd"
}

case object drvPsReplace extends DrawPosition {
  override def toString = "replace"
}
