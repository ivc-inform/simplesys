package com.simplesys.scalaGen

import com.simplesys.common.Strings.spaces

sealed abstract class ScalaClassType extends ScalaElement

case object TypeScalaClass extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "class"
}

case object AnonimousScalaClass extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "new"
}

case object TypeScalaCaseClass extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "case class"
}

case object TypeScalaCaseObject extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "case object"
}

case object TypeScalaTrait extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "trait"
}

case object TypeScalaObject extends ScalaClassType {
  def serrialize(indent: Int = 0) = spaces(indent) + "object"
}
