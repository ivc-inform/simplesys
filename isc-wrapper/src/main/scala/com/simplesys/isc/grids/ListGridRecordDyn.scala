package com.simplesys.isc.grids

import com.simplesys.json.{JsonElement, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.dataSource.RecordDyn
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.dataBinging.DataSourceDyn

object ListGridRecordDyn {

    implicit def ListGridRecord1toJsonObject(in: ListGridRecordDyn): JsonObject = in json
    def apply(seq: (String, JsonElement)*) = new ListGridRecordDyn(false, seq)
}

class ListGridRecordDyn(override val useSelfName: Boolean = false, seq: Seq[(String, JsonElement)] = Seq.empty) extends RecordDyn(seq: _*) with ListGridRecordDynInit {
    private[this] var _baseStyle: CSSStyleName = baseStyle
    def BaseStyle = _baseStyle
    def BaseStyle_=(value: CSSStyleName) {
        if (_baseStyle == value) return
        json("_baseStyle") = value //Здесь параметр должен быть именно с подчеркиванием !!!
        _baseStyle = value
    }

    private[this] var _backgroundComponent: CanvasDyn = backgroundComponent
    def BackgroundComponent = _backgroundComponent
    def BackgroundComponent_=(value: CanvasDyn) {
        if (_backgroundComponent == value) return
        json("backgroundComponent") = value
        _backgroundComponent = value
    }

    private[this] var _canAcceptDrop: Bool = canAcceptDrop
    def CanAcceptDrop = _canAcceptDrop
    def CanAcceptDrop_=(value: Bool) {
        if (_canAcceptDrop == value) return
        json("canAcceptDrop") = value
        _canAcceptDrop = value
    }

    private[this] var _canDrag: Bool = canDrag
    def CanDrag = _canDrag
    def CanDrag_=(value: Bool) {
        if (_canDrag == value) return
        json("canDrag") = value
        _canDrag = value
    }

    def CanEdit = json.getBoolOpt("canEdit").getOrElse(canEdit)
    def CanEdit_=(value: Bool) {
        if (CanEdit == value) return
        json("_canEdit") = value //Здесь параметр должен быть именно с подчеркиванием !!!
    }

    private[this] var _canExpand: Bool = canExpand
    def CanExpand = _canExpand
    def CanExpand_=(value: Bool) {
        if (_canExpand == value) return
        json("canExpand") = value
        _canExpand = value
    }

    def CanSelect = json.getBoolOpt("canSelect").getOrElse(canSelect)
    def CanSelect_=(value: Bool) {
        if (CanSelect == value) return
        json("canSelect") = value
    }

    def CanRemove = json.getBoolOpt("canRemove").getOrElse(canRemove)
    def CanRemove_=(value: Bool) {
        if (CanRemove == value) return
        json("_canRemove") = value //Здесь параметр должен быть именно с подчеркиванием !!!
    }

    private[this] var _customStyle: CSSStyleName = customStyle
    def CustomStyle = _customStyle
    def CustomStyle_=(value: CSSStyleName) {
        if (_customStyle == value) return
        json("customStyle") = value
        _customStyle = value
    }

    private[this] var _detailDS: DataSourceDyn = detailDS
    def DetailDS = _detailDS
    def DetailDS_=(value: DataSourceDyn) {
        if (_detailDS == value) return
        json("detailDS") = value
        _detailDS = value
    }

    private[this] var _enabled: Bool = enabled
    def Enabled = _enabled
    def Enabled_=(value: Bool) {
        if (_enabled == value) return
        json("enabled") = value
        _enabled = value
    }

    private[this] var _includeInSummary: Bool = includeInSummary
    def IncludeInSummary = _includeInSummary
    def IncludeInSummary_=(value: Bool) {
        if (_includeInSummary == value) return
        json("includeInSummary") = value
        _includeInSummary = value
    }

    private[this] var _isGridSummary: Bool = isGridSummary
    def IsGridSummary = _isGridSummary
    def IsGridSummary_=(value: Bool) {
        if (_isGridSummary == value) return
        json("isGridSummary") = value
        _isGridSummary = value
    }

    private[this] var _isGroupSummary: Bool = isGroupSummary
    def IsGroupSummary = _isGroupSummary
    def IsGroupSummary_=(value: Bool) {
        if (_isGroupSummary == value) return
        json("isGroupSummary") = value
        _isGroupSummary = value
    }

    private[this] var _isSeparator: Bool = isSeparator
    def IsSeparator = _isSeparator
    def IsSeparator_=(value: Bool) {
        if (_isSeparator == value) return
        json("isSeparator") = value
        _isSeparator = value
    }

    private[this] var _linkText: String = linkText
    def LinkText = _linkText
    def LinkText_=(value: String) {
        if (_linkText == value) return
        json("linkText") = value
        _linkText = value
    }

    private[this] var _singleCellValue: HTMLString = singleCellValue
    def SingleCellValue = _singleCellValue
    def SingleCellValue_=(value: HTMLString) {
        if (_singleCellValue == value) return
        json("singleCellValue") = value
        _singleCellValue = value
    }
}

