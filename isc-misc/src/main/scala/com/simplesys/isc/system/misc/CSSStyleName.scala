package com.simplesys.isc.system.misc

class CSSStyleNameString(path: String) {
  def css = CSSStyleName(path)
}

case class CSSStyleName(path: String) {
  override def toString = path
}