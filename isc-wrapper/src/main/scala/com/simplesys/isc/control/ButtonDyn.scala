package com.simplesys.isc.control

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StatefulCanvasDyn

object ButtonDyn {
  implicit def Button1toJsonObject(in: ButtonDyn): JsonObject = in json
}

class ButtonDyn(override val useSelfName: Boolean = false) extends StatefulCanvasDyn with ButtonDynInit {
  override val selfName = "Button"

  private[this] var _wrap: Bool = wrap
  def Wrap = _wrap
  def Wrap_=(value: Bool) {
    if (_wrap == value) return

    json("wrap") = value
    _wrap = value
  }

  private[this] var _hiliteAccessKey: Bool = hiliteAccessKey
  def HiliteAccessKey = _hiliteAccessKey
  def HiliteAccessKey_=(value: Bool) {
    if (_hiliteAccessKey == value) return
    json("hiliteAccessKey") = value
    _hiliteAccessKey = value
  }

  private[this] var _iconAlign: String = iconAlign
  def IconAlign = _iconAlign
  def IconAlign_=(value: String) {
    if (_iconAlign == value) return
    json("iconAlign") = value
    _iconAlign = value
  }

  private[this] var _action: FunctionExpression = action
  def Action = _action
  def Action_=(value: FunctionExpression) {
    if (_action == value) return
    json("action") = value
    _action = value
  }

  private[this] var _iconClick: FunctionExpression = iconClick
  def IconClick = _iconClick
  def IconClick_=(value: FunctionExpression) {
    if (_iconClick == value) return
    json("iconClick") = value
    _iconClick = value
  }

  private[this] var _message: String = message
  def Message = _message
  def Message_=(value: String) {
    if (_message == value) return
    json("message") = value
    _message = value
  }
}

