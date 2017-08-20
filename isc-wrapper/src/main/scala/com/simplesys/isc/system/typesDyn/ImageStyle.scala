
package com.simplesys.isc.system.typesDyn


sealed abstract trait ImageStyle

case object imgStCenter extends ImageStyle {
  override def toString = "center"
}

case object imgStTile extends ImageStyle {
  override def toString = "tile"
}

case object imgStStretch extends ImageStyle {
  override def toString = "stretch"
}

case object imgStNormal extends ImageStyle {
  override def toString = "normal"
}



