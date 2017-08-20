package com.simplesys.isc.system.typesDyn


sealed abstract trait AutoFitIconFieldType

case object aftIcnFldTpNone extends AutoFitIconFieldType {
  override def toString = "none"
}

case object aftIcnFldTpIconWidth extends AutoFitIconFieldType {
  override def toString = "iconWidth"
}

case object aftIcnFldTpTitle extends AutoFitIconFieldType {
  override def toString = "title"
}

