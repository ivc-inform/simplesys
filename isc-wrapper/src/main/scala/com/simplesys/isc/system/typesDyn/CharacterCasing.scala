package com.simplesys.isc.system.typesDyn


sealed abstract trait CharacterCasing

case object chCsDefault extends CharacterCasing {
  override def toString = "default"
}

case object chCSupper extends CharacterCasing {
  override def toString = "upper"
}

case object chCsLower extends CharacterCasing {
  override def toString = "lower"
}
