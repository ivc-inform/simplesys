package com.simplesys.json

class Unquoted_String(string: String) {
  def unq = UnquotedString(string)
}

case class UnquotedString(string: String){
  override def toString = string
}