package com.simplesys.isc.layout

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.foundation.CanvasDyn

object ToolbarDyn {

  implicit def ToolbartoJsonObject(in: ToolbarDyn): JsonObject = in json
}

class ToolbarDyn(override val useSelfName: Boolean = false) extends LayoutDyn with ToolbarDynInit {
  override val selfName = "Toolbar"

  private[this] var _buttonConstructor: SCClassName = buttonConstructor
  def ButtonConstructor = _buttonConstructor
  def ButtonConstructor_=(value: SCClassName) {
    if (_buttonConstructor == value) return
    json("buttonConstructor") = value
    _buttonConstructor = value
  }

  private[this] var _buttonDefaults: ClassDyn = buttonDefaults
  def ButtonDefaults = _buttonDefaults
  def ButtonDefaults_=(value: ClassDyn) {
    if (_buttonDefaults == value) return
    json("buttonDefaults") = value
    _buttonDefaults = value
  }

  private[this] var _buttons: ArrayDyn[CanvasDyn] = buttons
  def Buttons = _buttons
  def Buttons_=(value: ArrayDyn[CanvasDyn]) {
    if (_buttons == value) return
    json("buttons") = value
    _buttons = value
  }

  private[this] var _canReorderItems: Bool = canReorderItems
  def CanReorderItems = _canReorderItems
  def CanReorderItems_=(value: Bool) {
    if (_canReorderItems == value) return
    json("canReorderItems") = value
    _canReorderItems = value
  }

  private[this] var _canResizeItems: Bool = canResizeItems
  def CanResizeItems = _canResizeItems
  def CanResizeItems_=(value: Bool) {
    if (_canResizeItems == value) return
    json("canResizeItems") = value
    _canResizeItems = value
  }

  private[this] var _itemClick: FunctionExpression = itemClick
  def ItemClick = _itemClick
  def ItemClick_=(value: FunctionExpression) {
    if (_itemClick == value) return
    json("itemClick") = value
    _itemClick = value
  }

  private[this] var _itemDoubleClick: FunctionExpression = itemDoubleClick
  def ItemDoubleClick = _itemDoubleClick
  def ItemDoubleClick_=(value: FunctionExpression) {
    if (_itemDoubleClick == value) return
    json("itemDoubleClick") = value
    _itemDoubleClick = value
  }

  private[this] var _itemDragResized: FunctionExpression = itemDragResized
  def ItemDragResized = _itemDragResized
  def ItemDragResized_=(value: FunctionExpression) {
    if (_itemDragResized == value) return
    json("itemDragResized") = value
    _itemDragResized = value
  }
}