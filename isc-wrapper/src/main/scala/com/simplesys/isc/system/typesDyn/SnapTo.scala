package com.simplesys.isc.system.typesDyn


sealed abstract trait SnapTo

case object sntBottom extends SnapTo {
  override def toString = "B"
}

case object sntTop extends SnapTo {
  override def toString = "T"
}

case object sntLeft extends SnapTo {
  override def toString = "L"
}

case object sntRight extends SnapTo {
  override def toString = "R"
}

case object sntBottomLeft extends SnapTo {
  override def toString = "BL"
}

case object sntBottomRight extends SnapTo {
  override def toString = "BR"
}

case object sntTopLeft extends SnapTo {
  override def toString = "TL"
}

case object sntTopRight extends SnapTo {
  override def toString = "TR"
}

case object sntCenter extends SnapTo {
  override def toString = "C"
}

case object sntNone extends SnapTo {
  override def toString = ""
}

