package com.simplesys.isc.system.typesDyn


sealed abstract trait JSONInstanceSerializationMode

case object jsonInstSrlzLong extends JSONInstanceSerializationMode {
  override def toString = "long"
}

case object jsonInstSrlzShort extends JSONInstanceSerializationMode {
  override def toString = "short"
}

case object jsonInstSrlzSkip extends JSONInstanceSerializationMode {
  override def toString = "skip"
}

