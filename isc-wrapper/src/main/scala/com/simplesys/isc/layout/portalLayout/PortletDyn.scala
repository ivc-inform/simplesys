package com.simplesys.isc.layout.portalLayout

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.WindowDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.misc.Bool

object PortletDyn {

  implicit def PortlettoJsonObject(in: PortletDyn): JsonObject = in json
}

class PortletDyn(override val useSelfName: Boolean = false) extends WindowDyn with PortletDynInit {

  override val selfName = "Portlet"

  private[this] var _closeConfirmationMessage: String = closeConfirmationMessage
  def CloseConfirmationMessage = _closeConfirmationMessage
  def CloseConfirmationMessage_=(value: String) {
    if (_closeConfirmationMessage == value) return
    json("closeConfirmationMessage") = value
    _closeConfirmationMessage = value
  }

  private[this] var _destroyOnClose: Bool = destroyOnClose
  def DestroyOnClose = _destroyOnClose
  def DestroyOnClose_=(value: Bool) {
    if (_destroyOnClose == value) return
    json("destroyOnClose") = value
    _destroyOnClose = value
  }

  private[this] var _rowHeight: Number = rowHeight
  def RowHeight = _rowHeight
  def RowHeight_=(value: Number) {
    if (_rowHeight == value) return
    json("rowHeight") = value
    _rowHeight = value
  }

  private[this] var _showCloseConfirmationMessage: Bool = showCloseConfirmationMessage
  def ShowCloseConfirmationMessage = _showCloseConfirmationMessage
  def ShowCloseConfirmationMessage_=(value: Bool) {
    if (_showCloseConfirmationMessage == value) return
    json("showCloseConfirmationMessage") = value
    _showCloseConfirmationMessage = value
  }
}