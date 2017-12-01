package com.simplesys.isc.system.misc

import com.simplesys.common.JVM.Strings._
import com.simplesys.json.UnquotedString

object StringMethod {
  def apply(body: String) = new StringMethod(body)
}

class StringMethod(val body: String) extends UnquotedString(body) {
  override def toString = body.dblQuoted
}
