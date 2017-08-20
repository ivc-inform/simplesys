package com.simplesys.isc.system.misc

class RelativeDateString(value: String) {
  def rldate = RelativeDate(value)
}

case class RelativeDate(value: String) {
  override def toString = value
}