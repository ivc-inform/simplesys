
package com.simplesys.isc.system.typesDyn


sealed abstract trait HashAlgorithm

case object halgNull extends HashAlgorithm {
  override def toString = ""
}

case object halgMD5 extends HashAlgorithm {
  override def toString = "MD5"
}

case object halgSHA extends HashAlgorithm {
  override def toString = "SHA"
}


