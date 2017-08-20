package com.simplesys.isc.system.typesDyn


sealed abstract trait JSONCircularReferenceMode

case object jsonCrclRfMdOmit extends JSONCircularReferenceMode {
  override def toString = "omit"
}

case object jsonCrclRfMdMarker extends JSONCircularReferenceMode {
  override def toString = "marker"
}

case object jsonCrclRfMdPath extends JSONCircularReferenceMode {
  override def toString = "path"
}
