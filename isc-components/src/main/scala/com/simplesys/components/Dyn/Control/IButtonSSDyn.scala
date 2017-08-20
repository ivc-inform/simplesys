package com.simplesys.components.Dyn.Control

import com.simplesys.json.JsonObject
import com.simplesys.isc.control.IButtonDyn
import com.simplesys.components.Dyn.EscapeKeyPressDyn

object IButtonSSDyn extends IButtonSSDynInit {
  implicit def IButtonSSDyn2JsonObject(in: IButtonSSDyn): JsonObject = in json
}

class IButtonSSDyn(override val useSelfName: Boolean = false) extends IButtonDyn with EscapeKeyPressDyn with IButtonSSDynInit {
  override val selfName = "IButtonSS"

  def TypeButton = json.getStringOpt("typeButton").getOrElse(typeButton)
  def TypeButton_=(value: String) {
    if (TypeButton == value) return
    json("typeButton") = value
  }
}