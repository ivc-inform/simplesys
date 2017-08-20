package com.simplesys.isc.layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc.FunctionExpression

object SplitPaneDyn {

  implicit def SplitPane2JsonObject(in: SplitPaneDyn): JsonObject = in json
}

class SplitPaneDyn(override val useSelfName: Boolean = false) extends VLayoutDyn with SplitPaneDynInit {
  override val selfName = "SplitPane"

  private[this] var _detailNavigationControl: CanvasDyn = detailNavigationControl
  def DetailNavigationControl = _detailNavigationControl
  def DetailNavigationControl_=(value: CanvasDyn) {
    if (_detailNavigationControl == value) return
    json("detailNavigationControl") = value
    _detailNavigationControl = value
  }

  private[this] var _detailPane: CanvasDyn = detailPane
  def DetailPane = _detailPane
  def DetailPane_=(value: CanvasDyn) {
    if (_detailPane == value) return
    json("detailPane") = value
    _detailPane = value
  }

  private[this] var _detailToolButtons: ArrayDyn[CanvasDyn] = detailToolButtons
  def DetailToolButtons = _detailToolButtons
  def DetailToolButtons_=(value: ArrayDyn[CanvasDyn]) {
    if (_detailToolButtons == value) return
    json("detailToolButtons") = value
    _detailToolButtons = value
  }

  private[this] var _detailToolStrip: AutoChild = detailToolStrip
  def DetailToolStrip = _detailToolStrip
  def DetailToolStrip_=(value: AutoChild) {
    if (_detailToolStrip == value) return
    json("detailToolStrip") = value
    _detailToolStrip = value
  }

  private[this] var _listPane: CanvasDyn = listPane
  def ListPane = _listPane
  def ListPane_=(value: CanvasDyn) {
    if (_listPane == value) return
    json("listPane") = value
    _listPane = value
  }

  private[this] var _navigationBar: NavigationBarDyn = navigationBar
  def NavigationBar = _navigationBar
  def NavigationBar_=(value: NavigationBarDyn) {
    if (_navigationBar == value) return
    json("navigationBar") = value
    _navigationBar = value
  }

  private[this] var _navigationClick: FunctionExpression = navigationClick
  def NavigationClick = _navigationClick
  def NavigationClick_=(value: FunctionExpression) {
    if (_navigationClick == value) return
    json("navigationClick") = value
    _navigationClick = value
  }

  private[this] var _navigationPane: CanvasDyn = navigationPane
  def NavigationPane = _navigationPane
  def NavigationPane_=(value: CanvasDyn) {
    if (_navigationPane == value) return
    json("navigationPane") = value
    _navigationPane = value
  }
}