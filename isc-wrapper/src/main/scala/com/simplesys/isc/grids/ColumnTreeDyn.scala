package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.{ArrayDyn, TreeDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.{LayoutDynInit, LayoutDyn}
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.dataBinging.DataBoundComponentDyn

object ColumnTreeDyn {


  implicit def ColumnTreetoJsonObject(in: ColumnTreeDyn): JsonObject = in json
}

class ColumnTreeDyn(override val useSelfName: Boolean = false) extends LayoutDyn with DataBoundComponentDyn with LayoutDynInit with ColumnTreeDynInit {
  override val selfName = "ColumnTree"

  private[this] var _autoFetchData: Bool = autoFetchData
  def AutoFetchData = _autoFetchData
  def AutoFetchData_=(value: Bool) {
    if (_autoFetchData == value) return
    json("autoFetchData") = value
    _autoFetchData = value
  }

  private[this] var _autoFetchTextMatchStyle: TextMatchStyle = autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle = _autoFetchTextMatchStyle
  def AutoFetchTextMatchStyle_=(value: TextMatchStyle) {
    if (_autoFetchTextMatchStyle == value) return
    json("autoFetchTextMatchStyle") = value
    _autoFetchTextMatchStyle = value
  }

  private[this] var _backButton: AutoChild = backButton
  def BackButton = _backButton
  def BackButton_=(value: AutoChild) {
    if (_backButton == value) return
    json("backButton") = value
    _backButton = value
  }

  private[this] var _backButtonTitle: String = backButtonTitle
  def BackButtonTitle = _backButtonTitle
  def BackButtonTitle_=(value: String) {
    if (_backButtonTitle == value) return
    json("backButtonTitle") = value
    _backButtonTitle = value
  }

  private[this] var _closedIconSuffix: String = closedIconSuffix
  def ClosedIconSuffix = _closedIconSuffix
  def ClosedIconSuffix_=(value: String) {
    if (_closedIconSuffix == value) return
    json("closedIconSuffix") = value
    _closedIconSuffix = value
  }

  private[this] var _column: AutoChild = column
  def Column = _column
  def Column_=(value: AutoChild) {
    if (_column == value) return
    json("column") = value
    _column = value
  }

  private[this] var _columnProperties: ListGridDyn = columnProperties
  def ColumnProperties = _columnProperties
  def ColumnProperties_=(value: ListGridDyn) {
    if (_columnProperties == value) return
    json("columnProperties") = value
    _columnProperties = value
  }

  private[this] var _customIconOpenProperty: String = customIconOpenProperty
  def CustomIconOpenProperty = _customIconOpenProperty
  def CustomIconOpenProperty_=(value: String) {
    if (_customIconOpenProperty == value) return
    json("customIconOpenProperty") = value
    _customIconOpenProperty = value
  }

  private[this] var _customIconProperty: String = customIconProperty
  def CustomIconProperty = _customIconProperty
  def CustomIconProperty_=(value: String) {
    if (_customIconProperty == value) return
    json("customIconProperty") = value
    _customIconProperty = value
  }

  private[this] var _data: TreeDyn = data
  def Data = _data
  def Data_=(value: TreeDyn) {
    if (_data == value) return
    json("data") = value
    _data = value
  }

  private[this] var _firstColumnTitle: String = firstColumnTitle
  def FirstColumnTitle = _firstColumnTitle
  def FirstColumnTitle_=(value: String) {
    if (_firstColumnTitle == value) return
    json("firstColumnTitle") = value
    _firstColumnTitle = value
  }

  private[this] var _folderIcon: SCImgURL = folderIcon
  def FolderIcon = _folderIcon
  def FolderIcon_=(value: SCImgURL) {
    if (_folderIcon == value) return
    json("folderIcon") = value
    _folderIcon = value
  }

  private[this] var _initialCriteria: CriteriaDyn = initialCriteria
  def InitialCriteria = _initialCriteria
  def InitialCriteria_=(value: CriteriaDyn) {
    if (_initialCriteria == value) return
    json("initialCriteria") = value
    _initialCriteria = value
  }

  private[this] var _loadDataOnDemand: Bool = loadDataOnDemand
  def LoadDataOnDemand = _loadDataOnDemand
  def LoadDataOnDemand_=(value: Bool) {
    if (_loadDataOnDemand == value) return
    json("loadDataOnDemand") = value
    _loadDataOnDemand = value
  }

  private[this] var _nodeIcon: SCImgURL = nodeIcon
  def NodeIcon = _nodeIcon
  def NodeIcon_=(value: SCImgURL) {
    if (_nodeIcon == value) return
    json("nodeIcon") = value
    _nodeIcon = value
  }

  private[this] var _openIconSuffix: String = openIconSuffix
  def OpenIconSuffix = _openIconSuffix
  def OpenIconSuffix_=(value: String) {
    if (_openIconSuffix == value) return
    json("openIconSuffix") = value
    _openIconSuffix = value
  }

  private[this] var _showCustomIconOpen: Bool = showCustomIconOpen
  def ShowCustomIconOpen = _showCustomIconOpen
  def ShowCustomIconOpen_=(value: Bool) {
    if (_showCustomIconOpen == value) return
    json("showCustomIconOpen") = value
    _showCustomIconOpen = value
  }

  private[this] var _showHeaders: Bool = showHeaders
  def ShowHeaders = _showHeaders
  def ShowHeaders_=(value: Bool) {
    if (_showHeaders == value) return
    json("showHeaders") = value
    _showHeaders = value
  }

  private[this] var _showMultipleColumns: Bool = showMultipleColumns
  def ShowMultipleColumns = _showMultipleColumns
  def ShowMultipleColumns_=(value: Bool) {
    if (_showMultipleColumns == value) return
    json("showMultipleColumns") = value
    _showMultipleColumns = value
  }

  private[this] var _showNodeCount: Bool = showNodeCount
  def ShowNodeCount = _showNodeCount
  def ShowNodeCount_=(value: Bool) {
    if (_showNodeCount == value) return
    json("showNodeCount") = value
    _showNodeCount = value
  }

  private[this] var _showOpenIcons: Bool = showOpenIcons
  def ShowOpenIcons = _showOpenIcons
  def ShowOpenIcons_=(value: Bool) {
    if (_showOpenIcons == value) return
    json("showOpenIcons") = value
    _showOpenIcons = value
  }
}

