package com.simplesys.isc.system.misc

class NumberString(path: String) {
    def n = Number(path)
    def % = Number(path + "%")
    def fnk = Number(path + "fnk")
}

case class Number(value: String) {
    override def toString = value

    def toLong: Long = value match {
        case null => 0
        case _ => java.lang.Long.parseLong(value)
    }

    def toInt: Int = value match {
        case null => 0
        case _ => java.lang.Integer.parseInt(value)
    }

    def toBigDecimal: BigDecimal =
        value match {
            case null => 0
            case _ => BigDecimal(toString)
        }
}