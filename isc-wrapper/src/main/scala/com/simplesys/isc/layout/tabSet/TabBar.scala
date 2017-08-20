package com.simplesys.isc.layout.tabSet

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.ToolbarDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc._

object TabBar {

  implicit def TabBar2JsonObject(in: TabBar): JsonObject = in json
}

class TabBar(override val useSelfName: Boolean = false) extends ToolbarDyn with TabBarInit {
  override val selfName = "TabBar"

  private[this] var _baseLineCapSize: Number = baseLineCapSize
  def BaseLineCapSize = _baseLineCapSize
  def BaseLineCapSize_=(value: Number) {
    if (_baseLineCapSize == value) return
    json("baseLineCapSize") = value
    _baseLineCapSize = value
  }

  private[this] var _baseLineSrc: SCImgURL = baseLineSrc
  def BaseLineSrc = _baseLineSrc
  def BaseLineSrc_=(value: SCImgURL) {
    if (_baseLineSrc == value) return
    json("baseLineSrc") = value
    _baseLineSrc = value
  }

  private[this] var _baseLineThickness: Number = baseLineThickness
  def BaseLineThickness = _baseLineThickness
  def BaseLineThickness_=(value: Number) {
    if (_baseLineThickness == value) return
    json("baseLineThickness") = value
    _baseLineThickness = value
  }

  private[this] var _breadth: Number = breadth
  def Breadth = _breadth
  def Breadth_=(value: Number) {
    if (_breadth == value) return
    json("breadth") = value
    _breadth = value
  }

  private[this] var _defaultTabSize: Number = defaultTabSize
  def DefaultTabSize = _defaultTabSize
  def DefaultTabSize_=(value: Number) {
    if (_defaultTabSize == value) return
    json("defaultTabSize") = value
    _defaultTabSize = value
  }

  private[this] var _moreTab: TabDyn = moreTab
  def MoreTab = _moreTab
  def MoreTab_=(value: TabDyn) {
    if (_moreTab == value) return
    json("moreTab") = value
    _moreTab = value
  }

  private[this] var _moreTabCount: Number = moreTabCount
  def MoreTabCount = _moreTabCount
  def MoreTabCount_=(value: Number) {
    if (_moreTabCount == value) return
    json("moreTabCount") = value
    _moreTabCount = value
  }

  private[this] var _showMoreTab: Bool = showMoreTab
  def ShowMoreTab = _showMoreTab
  def ShowMoreTab_=(value: Bool) {
    if (_showMoreTab == value) return
    json("showMoreTab") = value
    _showMoreTab = value
  }

  def Tabs = json.getValue2[JsonList, ArrayDyn[TabDyn]]("tabs").getOrElse(tabs)
  def Tabs_=(value: ArrayDyn[TabDyn]) {
    if (Tabs == value) return
    json("tabs") = value
  }
}