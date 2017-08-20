package com.simplesys.isc.system.misc

class DateString(value: String) {
  def date = Date(value)
}

case class Date(value: String) {
  override def toString = value
}