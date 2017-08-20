package com.simplesys.isc.system.typesDyn


sealed abstract trait AnimationAcceleration

case object anAcsNull extends AnimationAcceleration {
  override def toString = ""
}

case object anAcsSmoothStart extends AnimationAcceleration {
  override def toString = "smoothStart"
}

case object anAcsSmoothEnd extends AnimationAcceleration {
  override def toString = "smoothEnd"
}

case object anAcsSmoothStartEnd extends AnimationAcceleration {
  override def toString = "smoothStartEnd"
}

case object anAcsNone extends AnimationAcceleration {
  override def toString = "none"
}


