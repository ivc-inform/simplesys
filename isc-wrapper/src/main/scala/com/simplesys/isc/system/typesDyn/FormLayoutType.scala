package com.simplesys.isc.system.typesDyn


sealed abstract trait FormLayoutType

case object frmLtTable extends FormLayoutType {
  override def toString = "table"
}

