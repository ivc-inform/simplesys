package com.simplesys.isc.system.typesDyn


sealed abstract trait TopOperatorAppearance

case object tpOpAprncRadio extends TopOperatorAppearance {
  override def toString = "radio"
}

case object tpOpAprncBracket extends TopOperatorAppearance {
  override def toString = "bracket"
}

case object tpOpAprncInline extends TopOperatorAppearance {
  override def toString = "inline"
}

case object tpOpAprncNone extends TopOperatorAppearance {
  override def toString = "none"
}
