package com.simplesys.servlet.http

case class Codec(val charset: String)(val encode: String => Array[Byte], val decode: Array[Byte] => String)

object Codec {

  def javaSupported(charset: String) = Codec(charset)(str => str.getBytes(charset), bytes => new String(bytes, charset))

  implicit val utf_8 = javaSupported("utf-8")

  val iso_8859_1 = javaSupported("iso-8859-1")

  val cp_1251 = javaSupported("cp-1251")
}