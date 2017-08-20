package com.simplesys.isc.system.misc

class TimeString(value: String) {
  def time = Time(value)
}

case class Time(value: String) {
  override def toString = value
}
