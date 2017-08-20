package com.simplesys.isc.system.typesDyn


sealed abstract trait SendMethod

case object sndMtGet extends SendMethod {
  override def toString = "GET"
}

case object sndMtPost extends SendMethod {
  override def toString = "POST"
}
