

package com.simplesys.isc.system.typesDyn


sealed abstract trait TableMode

case object tblMdPlane extends TableMode {
  override def toString = "plain"
}

case object tblMdGrouped extends TableMode {
  override def toString = "grouped"
}


