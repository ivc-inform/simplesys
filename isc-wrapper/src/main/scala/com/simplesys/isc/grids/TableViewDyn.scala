package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.LayoutDynInit

object TableViewDyn {

  implicit def TableViewtoJsonObject(in: TableViewDyn): JsonObject = in json
}

class TableViewDyn extends ListGridDyn with LayoutDynInit with ListGridDynInit with TableViewDynInit {
  override val selfName = "TableView"

  private[this] var _navIcon: SCImgURL = navIcon
  def NavIcon = _navIcon
  def NavIcon_=(value: SCImgURL) {
    if (_navIcon == value) return
    json("navIcon") = value
    _navIcon = value
  }

  private[this] var _navigationMode: NavigationMode = navigationMode
  def NavigationMode = _navigationMode
  def NavigationMode_=(value: NavigationMode) {
    if (_navigationMode == value) return
    json("navigationMode") = value
    _navigationMode = value
  }

  private[this] var _recordDataStyle: CSSStyleName = recordDataStyle
  def RecordDataStyle = _recordDataStyle
  def RecordDataStyle_=(value: CSSStyleName) {
    if (_recordDataStyle == value) return
    json("recordDataStyle") = value
    _recordDataStyle = value
  }

  private[this] var _recordDescriptionStyle: CSSStyleName = recordDescriptionStyle
  def RecordDescriptionStyle = _recordDescriptionStyle
  def RecordDescriptionStyle_=(value: CSSStyleName) {
    if (_recordDescriptionStyle == value) return
    json("recordDescriptionStyle") = value
    _recordDescriptionStyle = value
  }

  private[this] var _recordInfoStyle: CSSStyleName = recordInfoStyle
  def RecordInfoStyle = _recordInfoStyle
  def RecordInfoStyle_=(value: CSSStyleName) {
    if (_recordInfoStyle == value) return
    json("recordInfoStyle") = value
    _recordInfoStyle = value
  }

  private[this] var _recordLayout: RecordLayout = recordLayout
  def RecordLayout = _recordLayout
  def RecordLayout_=(value: RecordLayout) {
    if (_recordLayout == value) return
    json("recordLayout") = value
    _recordLayout = value
  }

  private[this] var _recordNavigationProperty: String = recordNavigationProperty
  def RecordNavigationProperty = _recordNavigationProperty
  def RecordNavigationProperty_=(value: String) {
    if (_recordNavigationProperty == value) return
    json("recordNavigationProperty") = value
    _recordNavigationProperty = value
  }

  private[this] var _recordTitleStyle: SCClassName = recordTitleStyle
  def RecordTitleStyle = _recordTitleStyle
  def RecordTitleStyle_=(value: SCClassName) {
    if (_recordTitleStyle == value) return
    json("recordTitleStyle") = value
    _recordTitleStyle = value
  }

  private[this] var _showIconField: Bool = showIconField
  def ShowIconField = _showIconField
  def ShowIconField_=(value: Bool) {
    if (_showIconField == value) return
    json("showIconField") = value
    _showIconField = value
  }

  private[this] var _showNavigation: Bool = showNavigation
  def ShowNavigation = _showNavigation
  def ShowNavigation_=(value: Bool) {
    if (_showNavigation == value) return
    json("showNavigation") = value
    _showNavigation = value
  }

  private[this] var _tableMode: TableMode = tableMode
  def TableMode = _tableMode
  def TableMode_=(value: TableMode) {
    if (_tableMode == value) return
    json("tableMode") = value
    _tableMode = value
  }

  private[this] var _titleField: String = titleField
  override def TitleField = _titleField
  override def TitleField_=(value: String) {
    if (_titleField == value) return
    json("titleField") = value
    _titleField = value
  }

  private[this] var _wholeRecordNavIcon: SCImgURL = wholeRecordNavIcon
  def WholeRecordNavIcon = _wholeRecordNavIcon
  def WholeRecordNavIcon_=(value: SCImgURL) {
    if (_wholeRecordNavIcon == value) return
    json("wholeRecordNavIcon") = value
    _wholeRecordNavIcon = value
  }
}

