package com.simplesys.isc.layout

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

object ToolStripDyn {

  implicit def ToolStriptoJsonObject(in: ToolStripDyn): JsonObject = in json
}

class ToolStripDyn(override val useSelfName: Boolean = false) extends LayoutDyn with LayoutDynInit with ToolStripDynInit {
  override val selfName = "ToolStrip"

  private[this] var _formWrapper: AutoChild = formWrapper
  def FormWrapper = _formWrapper
  def FormWrapper_=(value: AutoChild) {
    if (_formWrapper == value) return
    json("formWrapper") = value
    _formWrapper = value
  }

  private[this] var _formWrapperConstructor: String = formWrapperConstructor
  def FormWrapperConstructor = _formWrapperConstructor
  def FormWrapperConstructor_=(value: String) {
    if (_formWrapperConstructor == value) return
    json("formWrapperConstructor") = value
    _formWrapperConstructor = value
  }

  private[this] var _formWrapperDefaults: JsonObject = formWrapperDefaults
  def FormWrapperDefaults = _formWrapperDefaults
  def FormWrapperDefaults_=(value: JsonObject) {
    if (_formWrapperDefaults == value) return
    json("formWrapperDefaults") = value
    _formWrapperDefaults = value
  }

  private[this] var _formWrapperProperties: JsonObject = formWrapperProperties
  def FormWrapperProperties = _formWrapperProperties
  def FormWrapperProperties_=(value: JsonObject) {
    if (_formWrapperProperties == value) return
    json("formWrapperProperties") = value
    _formWrapperProperties = value
  }

  private[this] var _groupTitleAlign: AlignmentDyn = groupTitleAlign
  def GroupTitleAlign = _groupTitleAlign
  def GroupTitleAlign_=(value: AlignmentDyn) {
    if (_groupTitleAlign == value) return
    json("groupTitleAlign") = value
    _groupTitleAlign = value
  }

  private[this] var _groupTitleOrientation: AlignmentDyn = groupTitleOrientation
  def GroupTitleOrientation = _groupTitleOrientation
  def GroupTitleOrientation_=(value: AlignmentDyn) {
    if (_groupTitleOrientation == value) return
    json("groupTitleOrientation") = value
    _groupTitleOrientation = value
  }

  private[this] var _separatorClass: String = separatorClass
  def SeparatorClass = _separatorClass
  def SeparatorClass_=(value: String) {
    if (_separatorClass == value) return
    json("separatorClass") = value
    _separatorClass = value
  }

  private[this] var _separatorSize: Number = separatorSize
  def SeparatorSize = _separatorSize
  def SeparatorSize_=(value: Number) {
    if (_separatorSize == value) return
    json("separatorSize") = value
    _separatorSize = value
  }

  private[this] var _showGroupTitle: Bool = showGroupTitle
  def ShowGroupTitle = _showGroupTitle
  def ShowGroupTitle_=(value: Bool) {
    if (_showGroupTitle == value) return
    json("showGroupTitle") = value
    _showGroupTitle = value
  }

  private[this] var _verticalStyleName: CSSStyleName = verticalStyleName
  def VerticalStyleName = _verticalStyleName
  def VerticalStyleName_=(value: CSSStyleName) {
    if (_verticalStyleName == value) return
    json("verticalStyleName") = value
    _verticalStyleName = value
  }
}

