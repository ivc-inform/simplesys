package com.simplesys.scalaGen

import com.simplesys.common.Strings._

abstract class ScalaClassGen extends ScalaElement{
    def name = serrialize().trim
}

case object ScalaClassUnknown extends ScalaClassGen {
  def serrialize(indent: Int = 0) = spaces(indent) + "Unknown"
}

