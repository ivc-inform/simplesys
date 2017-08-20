package com.simplesys.isc.system.typesDyn


sealed abstract trait FormMethod

case object frmMthGET extends FormMethod {
  override def toString = "GET"
}

case object frmMthPOST extends FormMethod {
  override def toString = "POST"
}
