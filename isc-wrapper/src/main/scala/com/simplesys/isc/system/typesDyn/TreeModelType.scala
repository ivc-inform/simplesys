package com.simplesys.isc.system.typesDyn


sealed abstract trait TreeModelType

case object trmdParent extends TreeModelType {
  override def toString = "parent"
}

case object trmdChildren extends TreeModelType {
  override def toString = "children"
}