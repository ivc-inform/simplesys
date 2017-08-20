package com.simplesys.isc.layout

import com.simplesys.json.{JsonList, UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn.{Overflow, AutoChild}
import portalLayout.PortletDyn
import com.simplesys.isc.system.ArrayDyn

object PortalLayoutDyn {

  implicit def PortalLayouttoJsonObject(in: PortalLayoutDyn): JsonObject = in json
}

class PortalLayoutDyn extends LayoutDyn with PortalLayoutDynInit {
  override val selfName = "PortalLayout"

  private[this] var _canResizeColumns: Bool = canResizeColumns
  def CanResizeColumns = _canResizeColumns
  def CanResizeColumns_=(value: Bool) {
    if (_canResizeColumns == value) return
    json("canResizeColumns") = value
    _canResizeColumns = value
  }

  private[this] var _canResizePortlets: Bool = canResizePortlets
  def CanResizePortlets = _canResizePortlets
  def CanResizePortlets_=(value: Bool) {
    if (_canResizePortlets == value) return
    json("canResizePortlets") = value
    _canResizePortlets = value
  }

  private[this] var _canResizeRows: Bool = canResizeRows
  def CanResizeRows = _canResizeRows
  def CanResizeRows_=(value: Bool) {
    if (_canResizeRows == value) return
    json("canResizeRows") = value
    _canResizeRows = value
  }

  private[this] var _canShrinkColumnWidths: Bool = canShrinkColumnWidths
  def CanShrinkColumnWidths = _canShrinkColumnWidths
  def CanShrinkColumnWidths_=(value: Bool) {
    if (_canShrinkColumnWidths == value) return
    json("canShrinkColumnWidths") = value
    _canShrinkColumnWidths = value
  }

  private[this] var _canStretchColumnWidths: Bool = canStretchColumnWidths
  def CanStretchColumnWidths = _canStretchColumnWidths
  def CanStretchColumnWidths_=(value: Bool) {
    if (_canStretchColumnWidths == value) return
    json("canStretchColumnWidths") = value
    _canStretchColumnWidths = value
  }

  private[this] var _column: AutoChild = column
  def Column = _column
  def Column_=(value: AutoChild) {
    if (_column == value) return
    json("column") = value
    _column = value
  }

  private[this] var _columnBorder: String = columnBorder
  def ColumnBorder = _columnBorder
  def ColumnBorder_=(value: String) {
    if (_columnBorder == value) return
    json("columnBorder") = value
    _columnBorder = value
  }

  private[this] var _columnOverflow: Overflow = columnOverflow
  def ColumnOverflow = _columnOverflow
  def ColumnOverflow_=(value: Overflow) {
    if (_columnOverflow == value) return
    json("columnOverflow") = value
    _columnOverflow = value
  }

  private[this] var _numColumns: Number = numColumns
  def NumColumns = _numColumns
  def NumColumns_=(value: Number) {
    if (_numColumns == value) return
    json("numColumns") = value
    _numColumns = value
  }

  def Portlets = json.getValue2[JsonList, ArrayDyn[PortletDyn]]("portlets").getOrElse(portlets)
  def Portlets_=(value: ArrayDyn[PortletDyn]) {
    if (Portlets == value) return
    json("portlets") = value
  }

  private[this] var _preventColumnUnderflow: Bool = preventColumnUnderflow
  def PreventColumnUnderflow = _preventColumnUnderflow
  def PreventColumnUnderflow_=(value: Bool) {
    if (_preventColumnUnderflow == value) return
    json("preventColumnUnderflow") = value
    _preventColumnUnderflow = value
  }

  private[this] var _preventRowUnderflow: Bool = preventRowUnderflow
  def PreventRowUnderflow = _preventRowUnderflow
  def PreventRowUnderflow_=(value: Bool) {
    if (_preventRowUnderflow == value) return
    json("preventRowUnderflow") = value
    _preventRowUnderflow = value
  }

  private[this] var _preventUnderflow: Bool = preventUnderflow
  def PreventUnderflow = _preventUnderflow
  def PreventUnderflow_=(value: Bool) {
    if (_preventUnderflow == value) return
    json("preventUnderflow") = value
    _preventUnderflow = value
  }

  private[this] var _row: AutoChild = row
  def Row = _row
  def Row_=(value: AutoChild) {
    if (_row == value) return
    json("row") = value
    _row = value
  }

  private[this] var _rowLayout: AutoChild = rowLayout
  def RowLayout = _rowLayout
  def RowLayout_=(value: AutoChild) {
    if (_rowLayout == value) return
    json("rowLayout") = value
    _rowLayout = value
  }

  private[this] var _showColumnMenus: Bool = showColumnMenus
  def ShowColumnMenus = _showColumnMenus
  def ShowColumnMenus_=(value: Bool) {
    if (_showColumnMenus == value) return
    json("showColumnMenus") = value
    _showColumnMenus = value
  }

  private[this] var _stretchColumnWidthsProportionally: Bool = stretchColumnWidthsProportionally
  def StretchColumnWidthsProportionally = _stretchColumnWidthsProportionally
  def StretchColumnWidthsProportionally_=(value: Bool) {
    if (_stretchColumnWidthsProportionally == value) return
    json("stretchColumnWidthsProportionally") = value
    _stretchColumnWidthsProportionally = value
  }

  private[this] var _getDropPortlet: FunctionExpression = getDropPortlet
  def GetDropPortlet = _getDropPortlet
  def GetDropPortlet_=(value: FunctionExpression) {
    if (_getDropPortlet == value) return
    json("getDropPortlet") = value
    _getDropPortlet = value
  }
}