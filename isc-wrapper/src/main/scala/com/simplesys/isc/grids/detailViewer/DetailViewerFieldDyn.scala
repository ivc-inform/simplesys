package com.simplesys.isc.grids.detailViewer

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object DetailViewerFieldDyn {

  implicit def DetailViewerFieldtoJsonObject(in: DetailViewerFieldDyn): JsonObject = in json
}

class DetailViewerFieldDyn extends ClassDyn with DetailViewerFieldDynInit {
  private[this] var _canExport: Bool = canExport
  def CanExport = _canExport
  def CanExport_=(value: Bool) {
    if (_canExport == value) return
    json("canExport") = value
    _canExport = value
  }

  private[this] var _cellStyle: CSSStyleName = cellStyle
  def CellStyle = _cellStyle
  def CellStyle_=(value: CSSStyleName) {
    if (_cellStyle == value) return
    json("cellStyle") = value
    _cellStyle = value
  }

  private[this] var _dataPath: XPathExpression = dataPath
  def DataPath = _dataPath
  def DataPath_=(value: XPathExpression) {
    if (_dataPath == value) return
    json("dataPath") = value
    _dataPath = value
  }

  private[this] var _dateFormatter: DateDisplayFormat = dateFormatter
  def DateFormatter = _dateFormatter
  def DateFormatter_=(value: DateDisplayFormat) {
    if (_dateFormatter == value) return
    json("dateFormatter") = value
    _dateFormatter = value
  }

  private[this] var _escapeHTML: HTMLString = escapeHTML
  def EscapeHTML = _escapeHTML
  def EscapeHTML_=(value: HTMLString) {
    if (_escapeHTML == value) return
    json("escapeHTML") = value
    _escapeHTML = value
  }

  private[this] var _height: Number = height
  def Height = _height
  def Height_=(value: Number) {
    if (_height == value) return
    json("height") = value
    _height = value
  }

  private[this] var _imageHeight: Number = imageHeight
  def ImageHeight = _imageHeight
  def ImageHeight_=(value: Number) {
    if (_imageHeight == value) return
    json("imageHeight") = value
    _imageHeight = value
  }

  private[this] var _imageSize: Number = imageSize
  def ImageSize = _imageSize
  def ImageSize_=(value: Number) {
    if (_imageSize == value) return
    json("imageSize") = value
    _imageSize = value
  }

  private[this] var _imageURLPrefix: String = imageURLPrefix
  def ImageURLPrefix = _imageURLPrefix
  def ImageURLPrefix_=(value: String) {
    if (_imageURLPrefix == value) return
    json("imageURLPrefix") = value
    _imageURLPrefix = value
  }

  private[this] var _imageWidth: Number = imageWidth
  def ImageWidth = _imageWidth
  def ImageWidth_=(value: Number) {
    if (_imageWidth == value) return
    json("imageWidth") = value
    _imageWidth = value
  }

  private[this] var _includeFrom: String = includeFrom
  def IncludeFrom = _includeFrom
  def IncludeFrom_=(value: String) {
    if (_includeFrom == value) return
    json("includeFrom") = value
    _includeFrom = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _printCellStyle: String = printCellStyle
  def PrintCellStyle = _printCellStyle
  def PrintCellStyle_=(value: String) {
    if (_printCellStyle == value) return
    json("printCellStyle") = value
    _printCellStyle = value
  }

  private[this] var _showFileInline: Bool = showFileInline
  def ShowFileInline = _showFileInline
  def ShowFileInline_=(value: Bool) {
    if (_showFileInline == value) return
    json("showFileInline") = value
    _showFileInline = value
  }

  private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter
  def TimeFormatter = _timeFormatter
  def TimeFormatter_=(value: TimeDisplayFormat) {
    if (_timeFormatter == value) return
    json("timeFormatter") = value
    _timeFormatter = value
  }

  private[this] var _title: HTMLString = title
  def Title = _title
  def Title_=(value: HTMLString) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _fieldType: String = fieldType
  def Type = _fieldType
  def Type_=(value: String) {
    if (_fieldType == value) return
    json("fieldType") = value
    _fieldType = value
  }

  private[this] var _value: HTMLString = value
  def Value = _value
  def Value_=(value: HTMLString) {
    if (_value == value) return
    json("value") = value
    _value = value
  }

  private[this] var _valueMap: JsonObject = valueMap
  def ValueMap = _valueMap
  def ValueMap_=(value: JsonObject) {
    json("valueMap") = value
    _valueMap = value
  }

}

