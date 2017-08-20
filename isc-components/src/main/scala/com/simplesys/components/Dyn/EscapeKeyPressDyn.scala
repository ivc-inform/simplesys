package com.simplesys.components.Dyn

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn


trait EscapeKeyPressDyn extends ClassDyn with EscapeKeyPressDynInit {
    def Focused = json.getBoolOpt("focused").getOrElse(focused)
    def Focused_=(value: Bool) {
    if (Focused == value) return
    json("focused") = value
  }

  def EscapeKeyPress = json.getFunctionExpressionOpt("escapeKeyPress").getOrElse(escapeKeyPress)
  def EscapeKeyPress_=(value: FunctionExpression) {
    if (EscapeKeyPress == value) return
    json("escapeKeyPress") = value
  }
}