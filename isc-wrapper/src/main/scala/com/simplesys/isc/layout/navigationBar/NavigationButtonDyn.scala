package com.simplesys.isc.layout.navigationBar

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.control.ButtonDyn

object NavigationButtonDyn {

  implicit def NavigationButton2JsonObject(in: NavigationButtonDyn): JsonObject = in json
}

class NavigationButtonDyn(override val useSelfName: Boolean = false) extends ButtonDyn with NavigationButtonDynInit {
  override val selfName = "NavigationButton"

  private[this] var _backBaseStyle: CSSStyleName = backBaseStyle
  def BackBaseStyle = _backBaseStyle
  def BackBaseStyle_=(value: CSSStyleName) {
    if (_backBaseStyle == value) return
    json("backBaseStyle") = value
    _backBaseStyle = value
  }

  private[this] var _direction: NavigationDirection = direction
  def Direction = _direction
  def Direction_=(value: NavigationDirection) {
    if (_direction == value) return
    json("direction") = value
    _direction = value
  }

  private[this] var _forwardBaseStyle: CSSStyleName = forwardBaseStyle
  def ForwardBaseStyle = _forwardBaseStyle
  def ForwardBaseStyle_=(value: CSSStyleName) {
    if (_forwardBaseStyle == value) return
    json("forwardBaseStyle") = value
    _forwardBaseStyle = value
  }
}