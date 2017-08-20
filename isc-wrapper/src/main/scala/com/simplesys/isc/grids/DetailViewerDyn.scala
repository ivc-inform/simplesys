package com.simplesys.isc.grids

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.{CanvasDynInit, CanvasDyn}
import com.simplesys.isc.system.ArrayDyn
import detailViewer.{DetailViewerFieldDyn, DetailViewerRecordDyn}

object DetailViewerDyn {


  implicit def DetailViewertoJsonObject(in: DetailViewerDyn): JsonObject = in json
}

class DetailViewerDyn(override val useSelfName: Boolean = false) extends CanvasDyn with CanvasDynInit with DetailViewerDynInit {
  override val selfName = "DetailViewer"

  private[this] var _blockSeparator: HTMLString = blockSeparator
  def BlockSeparator = _blockSeparator
  def BlockSeparator_=(value: HTMLString) {
    if (_blockSeparator == value) return
    json("blockSeparator") = value
    _blockSeparator = value
  }

  private[this] var _blockStyle: CSSStyleName = blockStyle
  def BlockStyle = _blockStyle
  def BlockStyle_=(value: CSSStyleName) {
    if (_blockStyle == value) return
    json("blockStyle") = value
    _blockStyle = value
  }

  private[this] var _cellStyle: CSSStyleName = cellStyle
  def CellStyle = _cellStyle
  def CellStyle_=(value: CSSStyleName) {
    if (_cellStyle == value) return
    json("cellStyle") = value
    _cellStyle = value
  }

  private[this] var _data: ArrayDyn[DetailViewerRecordDyn] = data
  def Data = _data
  def Data_=(value: ArrayDyn[DetailViewerRecordDyn]) {
    if (_data == value) return
    json("data") = value
    _data = value
  }

  private[this] var _dataFetchMode: FetchMode = dataFetchMode
  def DataFetchMode = _dataFetchMode
  def DataFetchMode_=(value: FetchMode) {
    if (_dataFetchMode == value) return
    json("dataFetchMode") = value
    _dataFetchMode = value
  }

  private[this] var _dateFormatter: DateDisplayFormat = dateFormatter
  def DateFormatter = _dateFormatter
  def DateFormatter_=(value: DateDisplayFormat) {
    if (_dateFormatter == value) return
    json("dateFormatter") = value
    _dateFormatter = value
  }

  private[this] var _datetimeFormatter: DateDisplayFormat = datetimeFormatter
  def DatetimeFormatter = _datetimeFormatter
  def DatetimeFormatter_=(value: DateDisplayFormat) {
    if (_datetimeFormatter == value) return
    json("datetimeFormatter") = value
    _datetimeFormatter = value
  }

  private[this] var _emptyCellValue: HTMLString = emptyCellValue
  def EmptyCellValue = _emptyCellValue
  def EmptyCellValue_=(value: HTMLString) {
    if (_emptyCellValue == value) return
    json("emptyCellValue") = value
    _emptyCellValue = value
  }

  private[this] var _emptyMessage: HTMLString = emptyMessage
  def EmptyMessage = _emptyMessage
  def EmptyMessage_=(value: HTMLString) {
    if (_emptyMessage == value) return
    json("emptyMessage") = value
    _emptyMessage = value
  }

  private[this] var _emptyMessageStyle: CSSStyleName = emptyMessageStyle
  def EmptyMessageStyle = _emptyMessageStyle
  def EmptyMessageStyle_=(value: CSSStyleName) {
    if (_emptyMessageStyle == value) return
    json("emptyMessageStyle") = value
    _emptyMessageStyle = value
  }

  private[this] var _fieldIdProperty: String = fieldIdProperty
  def FieldIdProperty = _fieldIdProperty
  def FieldIdProperty_=(value: String) {
    if (_fieldIdProperty == value) return
    json("fieldIdProperty") = value
    _fieldIdProperty = value
  }

  private[this] var _fields: ArrayDyn[DetailViewerFieldDyn] = fields
  def Fields = _fields
  def Fields_=(value: ArrayDyn[DetailViewerFieldDyn]) {
    if (_fields == value) return
    json("fields") = value
    _fields = value
  }

  private[this] var _headerStyle: CSSStyleName = headerStyle
  def HeaderStyle = _headerStyle
  def HeaderStyle_=(value: CSSStyleName) {
    if (_headerStyle == value) return
    json("headerStyle") = value
    _headerStyle = value
  }

  private[this] var _labelPrefix: HTMLString = labelPrefix
  def LabelPrefix = _labelPrefix
  def LabelPrefix_=(value: HTMLString) {
    if (_labelPrefix == value) return
    json("labelPrefix") = value
    _labelPrefix = value
  }

  private[this] var _labelStyle: CSSStyleName = labelStyle
  def LabelStyle = _labelStyle
  def LabelStyle_=(value: CSSStyleName) {
    if (_labelStyle == value) return
    json("labelStyle") = value
    _labelStyle = value
  }

  private[this] var _labelSuffix: HTMLString = labelSuffix
  def LabelSuffix = _labelSuffix
  def LabelSuffix_=(value: HTMLString) {
    if (_labelSuffix == value) return
    json("labelSuffix") = value
    _labelSuffix = value
  }

  private[this] var _loadingMessage: HTMLString = loadingMessage
  def LoadingMessage = _loadingMessage
  def LoadingMessage_=(value: HTMLString) {
    if (_loadingMessage == value) return
    json("loadingMessage") = value
    _loadingMessage = value
  }

  private[this] var _loadingMessageStyle: CSSStyleName = loadingMessageStyle
  def LoadingMessageStyle = _loadingMessageStyle
  def LoadingMessageStyle_=(value: CSSStyleName) {
    if (_loadingMessageStyle == value) return
    json("loadingMessageStyle") = value
    _loadingMessageStyle = value
  }

  private[this] var _printCellStyle: CSSStyleName = printCellStyle
  def PrintCellStyle = _printCellStyle
  def PrintCellStyle_=(value: CSSStyleName) {
    if (_printCellStyle == value) return
    json("printCellStyle") = value
    _printCellStyle = value
  }

  private[this] var _printHeaderStyle: CSSStyleName = printHeaderStyle
  def PrintHeaderStyle = _printHeaderStyle
  def PrintHeaderStyle_=(value: CSSStyleName) {
    if (_printHeaderStyle == value) return
    json("printHeaderStyle") = value
    _printHeaderStyle = value
  }

  private[this] var _printLabelStyle: CSSStyleName = printLabelStyle
  def PrintLabelStyle = _printLabelStyle
  def PrintLabelStyle_=(value: CSSStyleName) {
    if (_printLabelStyle == value) return
    json("printLabelStyle") = value
    _printLabelStyle = value
  }

  private[this] var _recordsPerBlock: Number = recordsPerBlock
  def RecordsPerBlock = _recordsPerBlock
  def RecordsPerBlock_=(value: Number) {
    if (_recordsPerBlock == value) return
    json("recordsPerBlock") = value
    _recordsPerBlock = value
  }

  private[this] var _separatorStyle: CSSStyleName = separatorStyle
  def SeparatorStyle = _separatorStyle
  def SeparatorStyle_=(value: CSSStyleName) {
    if (_separatorStyle == value) return
    json("separatorStyle") = value
    _separatorStyle = value
  }

  private[this] var _showDetailFields: Bool = showDetailFields
  def ShowDetailFields = _showDetailFields
  def ShowDetailFields_=(value: Bool) {
    if (_showDetailFields == value) return
    json("showDetailFields") = value
    _showDetailFields = value
  }

  private[this] var _showEmptyField: Bool = showEmptyField
  def ShowEmptyField = _showEmptyField
  def ShowEmptyField_=(value: Bool) {
    if (_showEmptyField == value) return
    json("showEmptyField") = value
    _showEmptyField = value
  }

  private[this] var _showEmptyMessage: Bool = showEmptyMessage
  def ShowEmptyMessage = _showEmptyMessage
  def ShowEmptyMessage_=(value: Bool) {
    if (_showEmptyMessage == value) return
    json("showEmptyMessage") = value
    _showEmptyMessage = value
  }

  private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter
  def TimeFormatter = _timeFormatter
  def TimeFormatter_=(value: TimeDisplayFormat) {
    if (_timeFormatter == value) return
    json("timeFormatter") = value
    _timeFormatter = value
  }

  private[this] var _wrapLabel: Bool = wrapLabel
  def WrapLabel = _wrapLabel
  def WrapLabel_=(value: Bool) {
    if (_wrapLabel == value) return
    json("wrapLabel") = value
    _wrapLabel = value
  }

  private[this] var _wrapValues: Bool = wrapValues
  def WrapValues = _wrapValues
  def WrapValues_=(value: Bool) {
    if (_wrapValues == value) return
    json("wrapValues") = value
    _wrapValues = value
  }
}

