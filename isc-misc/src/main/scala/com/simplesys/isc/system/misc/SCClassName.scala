package com.simplesys.isc.system.misc

class SCClassNameString(path: String) {
  def scc = SCClassName(path)
}

case class SCClassName(path: String) {
  override def toString = path
}