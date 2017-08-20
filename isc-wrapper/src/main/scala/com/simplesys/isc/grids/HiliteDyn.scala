package com.simplesys.isc.grids

import com.simplesys.json.{JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.{AdvancedCriteriaDyn, CriteriaDyn}

object HiliteDyn {

  implicit def HilitetoJsonObject(in: HiliteDyn): JsonObject = in json
}

class HiliteDyn extends ClassDyn with HiliteDynInit {
  private[this] var _backgroundColor: Color = backgroundColor
  def BackgroundColor = _backgroundColor
  def BackgroundColor_=(value: Color) {
    if (_backgroundColor == value) return
    json("backgroundColor") = value
    _backgroundColor = value
  }

  def Criteria = json.getJsonElement("criteria").getOrElse(criteria)
  def Criteria_=(value: JsonElement) {
    if (Criteria == value) return
    json("criteria") = value
  }

  private[this] var _cssText: String = cssText
  def CssText = _cssText
  def CssText_=(value: String) {
    if (_cssText == value) return
    json("cssText") = value
    _cssText = value
  }

  private[this] var _disabled: Bool = disabled
  def Disabled = _disabled
  def Disabled_=(value: Bool) {
    if (_disabled == value) return
    json("disabled") = value
    _disabled = value
  }

  private[this] var _fieldName: String = fieldName
  def FieldName = _fieldName
  def FieldName_=(value: String) {
    if (_fieldName == value) return
    json("fieldName") = value
    _fieldName = value
  }

  private[this] var _htmlAfter: String = htmlAfter
  def HtmlAfter = _htmlAfter
  def HtmlAfter_=(value: String) {
    if (_htmlAfter == value) return
    json("htmlAfter") = value
    _htmlAfter = value
  }

  private[this] var _htmlBefore: HTMLString = htmlBefore
  def HtmlBefore = _htmlBefore
  def HtmlBefore_=(value: HTMLString) {
    if (_htmlBefore == value) return
    json("htmlBefore") = value
    _htmlBefore = value
  }

  private[this] var _htmlValue: HTMLString = htmlValue
  def HtmlValue = _htmlValue
  def HtmlValue_=(value: HTMLString) {
    if (_htmlValue == value) return
    json("htmlValue") = value
    _htmlValue = value
  }

  private[this] var _textColor: Color = textColor
  def TextColor = _textColor
  def TextColor_=(value: Color) {
    if (_textColor == value) return
    json("textColor") = value
    _textColor = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }
}

