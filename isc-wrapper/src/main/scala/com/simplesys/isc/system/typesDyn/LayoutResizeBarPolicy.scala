
package com.simplesys.isc.system.typesDyn


sealed abstract trait LayoutResizeBarPolicy

case object lyRszBrPolMarked extends LayoutResizeBarPolicy {
  override def toString = "marked"
}

case object lyRszBrPolMiddle extends LayoutResizeBarPolicy {
  override def toString = "middle"
}

case object lyRszBrPolAll extends LayoutResizeBarPolicy {
  override def toString = "all"
}

case object lyRszBrPolNone extends LayoutResizeBarPolicy {
  override def toString = "none"
}


