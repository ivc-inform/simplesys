package com.simplesys.script

import java.io.StringWriter
import com.simplesys.common._

class JsStringWriter(short: Boolean) extends StringWriter {
  override def toString =
    short match {
        case false => JsBeautifier(super.toString)
      case true => super.toString.normalizedSpaces
    }
}