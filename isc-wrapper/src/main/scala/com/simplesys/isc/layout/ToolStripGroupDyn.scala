package com.simplesys.isc.layout

import com.simplesys.json.{JsonString, JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

//import com.simplesys.isc._

object ToolStripGroupDyn {
    implicit def ToolStripGrouptoJsonObject(in: ToolStripGroupDyn): JsonObject = in json
}

class ToolStripGroupDyn(override val useSelfName: Boolean = false) extends VLayoutDyn with ToolStripGroupDynInit {
    override val selfName = "ToolStripGroup"

    def AutoSizeToTitle = json.getBooleanOpt("autoSizeToTitle").getOrElse(autoSizeToTitle)
    def AutoSizeToTitle_=(value: Boolean) {
        if (AutoSizeToTitle == value) return
        json("autoSizeToTitle") = value
    }

    private[this] var _body: AutoChild = body
    def Body = _body
    def Body_=(value: AutoChild) {
        if (_body == value) return
        json("body") = value
        _body = value
    }

    def BodyConstructor = json.getStringOpt("bodyConstructor").getOrElse(bodyConstructor)
    def BodyConstructor_=(value: String) {
        if (BodyConstructor == value) return
        json("bodyConstructor") = value
    }

    def Controls = json.getJsonListOpt("controls").getOrElse(controls)
    def Controls_=(value: JsonList) {
        if (Controls == value) return
        json("controls") = value
    }

    private[this] var _label: AutoChild = label
    def Label = _label
    def Label_=(value: AutoChild) {
        if (_label == value) return
        json("label") = value
        _label = value
    }

    private[this] var _labelConstructor: String = labelConstructor
    def LabelConstructor = _labelConstructor
    def LabelConstructor_=(value: String) {
        if (_labelConstructor == value) return
        json("labelConstructor") = value
        _labelConstructor = value
    }

    private[this] var _numRows: Number = numRows
    def NumRows = _numRows
    def NumRows_=(value: Number) {
        if (_numRows == value) return
        json("numRows") = value
        _numRows = value
    }

    private[this] var _rowHeight: Number = rowHeight
    def RowHeight = _rowHeight
    def RowHeight_=(value: Number) {
        if (_rowHeight == value) return
        json("rowHeight") = value
        _rowHeight = value
    }

    private[this] var _styleName: CSSStyleName = styleName
    override def StyleName = _styleName
    override def StyleName_=(value: CSSStyleName) {
        if (_styleName == value) return
        json("styleName") = value
        _styleName = value
    }

    def TitleAlign = json.getValue2[JsonString, AlignmentDyn]("titleAlign").getOrElse(titleAlign)
    def TitleAlign_=(value: AlignmentDyn) {
        if (TitleAlign == value) return
        json("titleAlign") = value
    }

    def TitleHeight = json.getNumberOpt("titleHeight").getOrElse(titleHeight)
    def TitleHeight_=(value: Number) {
        if (TitleHeight == value) return
        json("titleHeight") = value
    }

    def TitleOrientation = json.getValue2[JsonString, AlignmentDyn]("titleOrientation").getOrElse(titleOrientation)
    def TitleOrientation_=(value: AlignmentDyn) {
        if (TitleOrientation == value) return
        json("titleOrientation") = value
    }

    private[this] var _titleProperties: AutoChild = titleProperties
    def TitleProperties = _titleProperties
    def TitleProperties_=(value: AutoChild) {
        if (_titleProperties == value) return
        json("titleProperties") = value
        _titleProperties = value
    }

    private[this] var _titleStyle: CSSStyleName = titleStyle
    def TitleStyle = _titleStyle
    def TitleStyle_=(value: CSSStyleName) {
        if (_titleStyle == value) return
        json("titleStyle") = value
        _titleStyle = value
    }
}

