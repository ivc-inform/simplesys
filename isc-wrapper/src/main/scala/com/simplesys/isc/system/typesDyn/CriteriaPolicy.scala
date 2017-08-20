package com.simplesys.isc.system.typesDyn


sealed abstract trait CriteriaPolicy

case object crtPlcNull extends CriteriaPolicy {
  override def toString = ""
}

case object crtPlcDropOnChange extends CriteriaPolicy {
  override def toString = "dropOnChange"
}

case object crtPlcDropOnShortening extends CriteriaPolicy {
  override def toString = "dropOnShortening"
}


