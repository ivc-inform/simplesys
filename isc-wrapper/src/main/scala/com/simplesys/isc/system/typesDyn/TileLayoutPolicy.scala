
package com.simplesys.isc.system.typesDyn


sealed abstract trait TileLayoutPolicy

case object tlplcFit extends TileLayoutPolicy {
  override def toString = "fit"
}

case object tlplcFlow extends TileLayoutPolicy {
  override def toString = "flow"
}

