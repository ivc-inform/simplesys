
package com.simplesys.isc.system.typesDyn


sealed abstract trait SelectionType

case object slTpNull extends SelectionType {
  override def toString = ""
}

case object slTpButton extends SelectionType {
  override def toString = "button"
}

case object slTpCheckbox extends SelectionType {
  override def toString = "checkbox"
}

case object slTpRadio extends SelectionType {
  override def toString = "radio"
}


