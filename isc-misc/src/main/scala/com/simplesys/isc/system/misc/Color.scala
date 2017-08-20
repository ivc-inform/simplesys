package com.simplesys.isc.system.misc

class ColorString(path: String) {
  def clr = Color(path)
}

case class Color(value: String) {

  override def toString = {
    try {
        val int: Int = java.lang.Integer.parseInt(value)
        "#" + value
    }
    catch {
      case ex: NumberFormatException =>
        value
    }
  }
}