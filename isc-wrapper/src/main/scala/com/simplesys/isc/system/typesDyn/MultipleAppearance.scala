
package com.simplesys.isc.system.typesDyn


sealed abstract trait MultipleAppearance

case object mlApprncPicklist extends MultipleAppearance {
  override def toString = "picklist"
}

case object mlApprncGrid extends MultipleAppearance {
  override def toString = "grid"
}


