
package com.simplesys.isc.system.typesDyn


sealed abstract trait EnumTranslateStrategy

case object enTrlsStrgNull extends EnumTranslateStrategy {
  override def toString = ""
}

case object enTrlsStrgString extends EnumTranslateStrategy {
  override def toString = "string"
}

case object enTrlsStrgOrdinal extends EnumTranslateStrategy {
  override def toString = "ordinal"
}

case object enTrlsStrgBean extends EnumTranslateStrategy {
  override def toString = "bean"
}


