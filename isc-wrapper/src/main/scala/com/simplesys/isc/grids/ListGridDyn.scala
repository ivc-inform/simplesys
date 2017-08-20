package com.simplesys.isc.grids

import com.simplesys.isc.layout.VLayoutDyn
import com.simplesys.json._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.{SortSpecifierDyn, DataBoundComponentDyn, DSRequestDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.canvas.ImgPropertiesDyn
import com.simplesys.isc.control.ButtonDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.foundation.CanvasDyn
import listGrid.{ListGridFieldDyn, HeaderSpanDyn}
import com.simplesys.isc.system.{MultiAutoChild, ArrayDyn}
import com.simplesys.isc.system.misc.CSSStyleName
import com.simplesys.isc.system.misc.SCClassName
import com.simplesys.json.JsonString
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.URL


object ListGridDyn {
    implicit def ListGridtoJsonObject(in: ListGridDyn): JsonObject = in json

    implicit def JSonObjToClassDyn(jsonObject: JsonObject): ListGridDyn = new ListGridDyn(jsonObject)
}

class ListGridDyn(override val inJson: JsonObject = null,
                  override val useSelfName: Boolean = false) extends VLayoutDyn with DataBoundComponentDyn with ListGridDynInit {
    override val selfName = "ListGrid"

    def Data = json.getJsonElement("data").getOrElse(data)
    def Data_=(value: JsonElement) {
        if (Data == value) return
        json("data") = value
    }

    private[this] var _alternateRecordStyles: Bool = alternateRecordStyles
    def AlternateRecordStyles = _alternateRecordStyles
    def AlternateRecordStyles_=(value: Bool) {
        if (_alternateRecordStyles == value) return
        json("alternateRecordStyles") = value
        _alternateRecordStyles = value
    }

    private[this] var _autoFetchData: Bool = autoFetchData
    def AutoFetchData = _autoFetchData
    def AutoFetchData_=(value: Bool) {
        if (_autoFetchData == value) return
        json("autoFetchData") = value
        _autoFetchData = value
    }

    private[this] var _emptyCellValue: HTMLString = emptyCellValue

    def EmptyCellValue = _emptyCellValue

    def EmptyCellValue_=(value: HTMLString) {
        if (_emptyCellValue == value) return

        json("emptyCellValue") = value
        _emptyCellValue = value
    }

    private[this] var _allowFilterExpressions: Bool = allowFilterExpressions

    def AllowFilterExpressions = _allowFilterExpressions

    def AllowFilterExpressions_=(value: Bool) {
        if (_allowFilterExpressions == value) return
        json("allowFilterExpressions") = value
        _allowFilterExpressions = value
    }

    private[this] var _alternateBodyStyleName: CSSStyleName = alternateBodyStyleName

    def AlternateBodyStyleName = _alternateBodyStyleName

    def AlternateBodyStyleName_=(value: CSSStyleName) {
        if (_alternateBodyStyleName == value) return
        json("alternateBodyStyleName") = value
        _alternateBodyStyleName = value
    }

    private[this] var _alternateRecordFrequency: Number = alternateRecordFrequency

    def AlternateRecordFrequency = _alternateRecordFrequency

    def AlternateRecordFrequency_=(value: Number) {
        if (_alternateRecordFrequency == value) return
        json("alternateRecordFrequency") = value
        _alternateRecordFrequency = value
    }

    private[this] var _alwaysShowEditors: Bool = alwaysShowEditors

    def AlwaysShowEditors = _alwaysShowEditors

    def AlwaysShowEditors_=(value: Bool) {
        if (_alwaysShowEditors == value) return
        json("alwaysShowEditors") = value
        _alwaysShowEditors = value
    }

    private[this] var _animateFolderEffect: AnimationAcceleration = animateFolderEffect

    def AnimateFolderEffect = _animateFolderEffect

    def AnimateFolderEffect_=(value: AnimationAcceleration) {
        if (_animateFolderEffect == value) return
        json("animateFolderEffect") = value
        _animateFolderEffect = value
    }

    private[this] var _animateFolderMaxRows: Number = animateFolderMaxRows

    def AnimateFolderMaxRows = _animateFolderMaxRows

    def AnimateFolderMaxRows_=(value: Number) {
        if (_animateFolderMaxRows == value) return
        json("animateFolderMaxRows") = value
        _animateFolderMaxRows = value
    }

    private[this] var _animateFolders: Bool = animateFolders

    def AnimateFolders = _animateFolders

    def AnimateFolders_=(value: Bool) {
        if (_animateFolders == value) return
        json("animateFolders") = value
        _animateFolders = value
    }

    private[this] var _animateFolderSpeed: Number = animateFolderSpeed

    def AnimateFolderSpeed = _animateFolderSpeed

    def AnimateFolderSpeed_=(value: Number) {
        if (_animateFolderSpeed == value) return
        json("animateFolderSpeed") = value
        _animateFolderSpeed = value
    }

    private[this] var _animateFolderTime: Number = animateFolderTime

    def AnimateFolderTime = _animateFolderTime

    def AnimateFolderTime_=(value: Number) {
        if (_animateFolderTime == value) return
        json("animateFolderTime") = value
        _animateFolderTime = value
    }

    private[this] var _animateRemoveRecord: Bool = animateRemoveRecord

    def AnimateRemoveRecord = _animateRemoveRecord

    def AnimateRemoveRecord_=(value: Bool) {
        if (_animateRemoveRecord == value) return
        json("animateRemoveRecord") = value
        _animateRemoveRecord = value
    }

    private[this] var _animateRemoveSpeed: Number = animateRemoveSpeed

    def AnimateRemoveSpeed = _animateRemoveSpeed

    def AnimateRemoveSpeed_=(value: Number) {
        if (_animateRemoveSpeed == value) return
        json("animateRemoveSpeed") = value
        _animateRemoveSpeed = value
    }

    private[this] var _animateRemoveTime: Number = animateRemoveTime

    def AnimateRemoveTime = _animateRemoveTime

    def AnimateRemoveTime_=(value: Number) {
        if (_animateRemoveTime == value) return
        json("animateRemoveTime") = value
        _animateRemoveTime = value
    }

    private[this] var _animateRollOver: Bool = animateRollOver

    def AnimateRollOver = _animateRollOver

    def AnimateRollOver_=(value: Bool) {
        if (_animateRollOver == value) return
        json("animateRollOver") = value
        _animateRollOver = value
    }

    private[this] var _animateRollUnder: Bool = animateRollUnder

    def AnimateRollUnder = _animateRollUnder

    def AnimateRollUnder_=(value: Bool) {
        if (_animateRollUnder == value) return
        json("animateRollUnder") = value
        _animateRollUnder = value
    }

    private[this] var _animateSelection: Bool = animateSelection

    def AnimateSelection = _animateSelection

    def AnimateSelection_=(value: Bool) {
        if (_animateSelection == value) return
        json("animateSelection") = value
        _animateSelection = value
    }

    private[this] var _animateSelectionUnder: Bool = animateSelectionUnder

    def AnimateSelectionUnder = _animateSelectionUnder

    def AnimateSelectionUnder_=(value: Bool) {
        if (_animateSelectionUnder == value) return
        json("animateSelectionUnder") = value
        _animateSelectionUnder = value
    }

    private[this] var _arrowKeyAction: String = arrowKeyAction

    def ArrowKeyAction = _arrowKeyAction

    def ArrowKeyAction_=(value: String) {
        if (_arrowKeyAction == value) return
        json("arrowKeyAction") = value
        _arrowKeyAction = value
    }

    private[this] var _autoFetchDisplayMap: Bool = autoFetchDisplayMap

    def AutoFetchDisplayMap = _autoFetchDisplayMap

    def AutoFetchDisplayMap_=(value: Bool) {
        if (_autoFetchDisplayMap == value) return
        json("autoFetchDisplayMap") = value
        _autoFetchDisplayMap = value
    }

    private[this] var _autoFetchTextMatchStyle: TextMatchStyle = autoFetchTextMatchStyle
    def AutoFetchTextMatchStyle = _autoFetchTextMatchStyle
    def AutoFetchTextMatchStyle_=(value: TextMatchStyle) {
        if (_autoFetchTextMatchStyle == value) return
        json("autoFetchTextMatchStyle") = value
        _autoFetchTextMatchStyle = value
    }

    private[this] var _autoFitAllText: String = autoFitAllText

    def AutoFitAllText = _autoFitAllText

    def AutoFitAllText_=(value: String) {
        if (_autoFitAllText == value) return
        json("autoFitAllText") = value
        _autoFitAllText = value
    }

    private[this] var _autoFitClipFields: JsonList = autoFitClipFields

    def AutoFitClipFields = _autoFitClipFields

    def AutoFitClipFields_=(value: JsonList) {
        if (_autoFitClipFields == value) return
        json("autoFitClipFields") = value
        _autoFitClipFields = value
    }

    private[this] var _autoFitData: Autofit = autoFitData

    def AutoFitData = _autoFitData

    def AutoFitData_=(value: Autofit) {
        if (_autoFitData == value) return
        json("autoFitData") = value
        _autoFitData = value
    }

    private[this] var _autoFitExpandField: String = autoFitExpandField

    def AutoFitExpandField = _autoFitExpandField

    def AutoFitExpandField_=(value: String) {
        if (_autoFitExpandField == value) return
        json("autoFitExpandField") = value
        _autoFitExpandField = value
    }

    private[this] var _autoFitExtraRecords: Number = autoFitExtraRecords

    def AutoFitExtraRecords = _autoFitExtraRecords

    def AutoFitExtraRecords_=(value: Number) {
        if (_autoFitExtraRecords == value) return
        json("autoFitExtraRecords") = value
        _autoFitExtraRecords = value
    }

    private[this] var _autoFitFieldsFillViewport: Bool = autoFitFieldsFillViewport

    def AutoFitFieldsFillViewport = _autoFitFieldsFillViewport

    def AutoFitFieldsFillViewport_=(value: Bool) {
        if (_autoFitFieldsFillViewport == value) return
        json("autoFitFieldsFillViewport") = value
        _autoFitFieldsFillViewport = value
    }

    private[this] var _autoFitFieldText: String = autoFitFieldText

    def AutoFitFieldText = _autoFitFieldText

    def AutoFitFieldText_=(value: String) {
        if (_autoFitFieldText == value) return
        json("autoFitFieldText") = value
        _autoFitFieldText = value
    }

    private[this] var _autoFitFieldWidths: Bool = autoFitFieldWidths
    def AutoFitFieldWidths = _autoFitFieldWidths
    def AutoFitFieldWidths_=(value: Bool) {
        if (_autoFitFieldWidths == value) return
        json("autoFitFieldWidths") = value
        _autoFitFieldWidths = value
    }

    private[this] var _autoFitIconFields: AutoFitIconFieldType = autoFitIconFields
    def AutoFitIconFields = _autoFitIconFields
    def AutoFitIconFields_=(value: AutoFitIconFieldType) {
        if (_autoFitIconFields == value) return
        json("autoFitIconFields") = value
        _autoFitIconFields = value
    }

    private[this] var _autoFitMaxColumns: Number = autoFitMaxColumns

    def AutoFitMaxColumns = _autoFitMaxColumns

    def AutoFitMaxColumns_=(value: Number) {
        if (_autoFitMaxColumns == value) return
        json("autoFitMaxColumns") = value
        _autoFitMaxColumns = value
    }

    private[this] var _autoFitMaxHeight: Number = autoFitMaxHeight

    def AutoFitMaxHeight = _autoFitMaxHeight

    def AutoFitMaxHeight_=(value: Number) {
        if (_autoFitMaxHeight == value) return
        json("autoFitMaxHeight") = value
        _autoFitMaxHeight = value
    }

    private[this] var _autoFitMaxRecords: Number = autoFitMaxRecords

    def AutoFitMaxRecords = _autoFitMaxRecords

    def AutoFitMaxRecords_=(value: Number) {
        if (_autoFitMaxRecords == value) return
        json("autoFitMaxRecords") = value
        _autoFitMaxRecords = value
    }

    private[this] var _autoFitMaxWidth: Number = autoFitMaxWidth

    def AutoFitMaxWidth = _autoFitMaxWidth

    def AutoFitMaxWidth_=(value: Number) {
        if (_autoFitMaxWidth == value) return
        json("autoFitMaxWidth") = value
        _autoFitMaxWidth = value
    }

    private[this] var _autoFitWidthApproach: AutoFitWidthApproach = autoFitWidthApproach
    def AutoFitWidthApproach = _autoFitWidthApproach
    def AutoFitWidthApproach_=(value: AutoFitWidthApproach) {
        if (_autoFitWidthApproach == value) return
        json("autoFitWidthApproach") = value
        _autoFitWidthApproach = value
    }

    private[this] var _autoSaveEdits: Bool = autoSaveEdits

    def AutoSaveEdits = _autoSaveEdits

    def AutoSaveEdits_=(value: Bool) {
        if (_autoSaveEdits == value) return
        json("autoSaveEdits") = value
        _autoSaveEdits = value
    }

    private[this] var _backgroundComponent: CanvasDyn = backgroundComponent

    def BackgroundComponent = _backgroundComponent

    def BackgroundComponent_=(value: CanvasDyn) {
        if (_backgroundComponent == value) return
        json("backgroundComponent") = value
        _backgroundComponent = value
    }

    private[this] var _baseStyle: CSSStyleName = baseStyle

    def BaseStyle = _baseStyle

    def BaseStyle_=(value: CSSStyleName) {
        if (_baseStyle == value) return
        json("baseStyle") = value
        _baseStyle = value
    }

    private[this] var _body: AutoChild = body

    def Body = _body

    def Body_=(value: AutoChild) {
        if (_body == value) return
        json("body") = value
        _body = value
    }

    private[this] var _bodyBackgroundColor: Color = bodyBackgroundColor

    def BodyBackgroundColor = _bodyBackgroundColor

    def BodyBackgroundColor_=(value: Color) {
        if (_bodyBackgroundColor == value) return
        json("bodyBackgroundColor") = value
        _bodyBackgroundColor = value
    }

    private[this] var _bodyOverflow: Overflow = bodyOverflow

    def BodyOverflow = _bodyOverflow

    def BodyOverflow_=(value: Overflow) {
        if (_bodyOverflow == value) return
        json("bodyOverflow") = value
        _bodyOverflow = value
    }

    private[this] var _bodyStyleName: CSSStyleName = bodyStyleName

    def BodyStyleName = _bodyStyleName

    def BodyStyleName_=(value: CSSStyleName) {
        if (_bodyStyleName == value) return
        json("bodyStyleName") = value
        _bodyStyleName = value
    }

    private[this] var _booleanFalseImage: SCImgURL = booleanFalseImage

    def BooleanFalseImage = _booleanFalseImage

    def BooleanFalseImage_=(value: SCImgURL) {
        if (_booleanFalseImage == value) return
        json("booleanFalseImage") = value
        _booleanFalseImage = value
    }

    private[this] var _booleanImageHeight: Number = booleanImageHeight

    def BooleanImageHeight = _booleanImageHeight

    def BooleanImageHeight_=(value: Number) {
        if (_booleanImageHeight == value) return
        json("booleanImageHeight") = value
        _booleanImageHeight = value
    }

    private[this] var _booleanImageWidth: Number = booleanImageWidth

    def BooleanImageWidth = _booleanImageWidth

    def BooleanImageWidth_=(value: Number) {
        if (_booleanImageWidth == value) return
        json("booleanImageWidth") = value
        _booleanImageWidth = value
    }

    private[this] var _booleanPartialImage: SCImgURL = booleanPartialImage

    def BooleanPartialImage = _booleanPartialImage

    def BooleanPartialImage_=(value: SCImgURL) {
        if (_booleanPartialImage == value) return
        json("booleanPartialImage") = value
        _booleanPartialImage = value
    }

    private[this] var _booleanTrueImage: SCImgURL = booleanTrueImage

    def BooleanTrueImage = _booleanTrueImage

    def BooleanTrueImage_=(value: SCImgURL) {
        if (_booleanTrueImage == value) return
        json("booleanTrueImage") = value
        _booleanTrueImage = value
    }

    private[this] var _canAcceptDroppedRecords: Bool = canAcceptDroppedRecords
    def CanAcceptDroppedRecords = _canAcceptDroppedRecords
    def CanAcceptDroppedRecords_=(value: Bool) {
        if (_canAcceptDroppedRecords == value) return
        json("canAcceptDroppedRecords") = value
        _canAcceptDroppedRecords = value
    }

    private[this] var _canAutoFitFields: Bool = canAutoFitFields

    def CanAutoFitFields = _canAutoFitFields

    def CanAutoFitFields_=(value: Bool) {
        if (_canAutoFitFields == value) return
        json("canAutoFitFields") = value
        _canAutoFitFields = value
    }

    def CancelEditingConfirmationMessage = json.getJsonElement("cancelEditingConfirmationMessage").getOrElse(cancelEditingConfirmationMessage)
    def CancelEditingConfirmationMessage_=(value: JsonElement) {
        if (CancelEditingConfirmationMessage == value) return
        json("cancelEditingConfirmationMessage") = value
    }

    def CanSelectCells = json.getJsonElement("canSelectCells").getOrElse(canSelectCells)
    def CanSelectCells_=(value: JsonElement) {
        if (CanSelectCells == value) return
        json("canSelectCells") = value
    }

    private[this] var _canCollapseGroup: Bool = canCollapseGroup

    def CanCollapseGroup = _canCollapseGroup

    def CanCollapseGroup_=(value: Bool) {
        if (_canCollapseGroup == value) return
        json("canCollapseGroup") = value
        _canCollapseGroup = value
    }

    private[this] var _canDragRecordsOut: Bool = canDragRecordsOut

    def CanDragRecordsOut = _canDragRecordsOut

    def CanDragRecordsOut_=(value: Bool) {
        if (_canDragRecordsOut == value) return
        json("canDragRecordsOut") = value
        _canDragRecordsOut = value
    }

    private[this] var _canDragSelect: Bool = canDragSelect

    def CanDragSelect = _canDragSelect

    def CanDragSelect_=(value: Bool) {
        if (_canDragSelect == value) return
        json("canDragSelect") = value
        _canDragSelect = value
    }

    def CanDragSelectText = json.getJsonElement("canDragSelectText").getOrElse(canDragSelectText)
    def CanDragSelectText_=(value: JsonElement) {
        if (CanDragSelectText == value) return
        json("canDragSelectText") = value
    }

    def CanEdit = json.getJsonElement("canEdit").getOrElse(canEdit)
    def CanEdit_=(value: JsonElement) {
        if (CanEdit == value) return
        json("canEdit") = value
    }

    private[this] var _canExpandMultipleRecords: Bool = canExpandMultipleRecords

    def CanExpandMultipleRecords = _canExpandMultipleRecords

    def CanExpandMultipleRecords_=(value: Bool) {
        if (_canExpandMultipleRecords == value) return
        json("canExpandMultipleRecords") = value
        _canExpandMultipleRecords = value
    }

    private[this] var _canExpandRecordProperty: String = canExpandRecordProperty

    def CanExpandRecordProperty = _canExpandRecordProperty

    def CanExpandRecordProperty_=(value: String) {
        if (_canExpandRecordProperty == value) return
        json("canExpandRecordProperty") = value
        _canExpandRecordProperty = value
    }

    private[this] var _canExpandRecords: Bool = canExpandRecords
    def CanExpandRecords = _canExpandRecords
    def CanExpandRecords_=(value: Bool) {
        if (_canExpandRecords == value) return
        json("canExpandRecords") = value
        _canExpandRecords = value
    }

    private[this] var _canFreezeFields: Bool = canFreezeFields

    def CanFreezeFields = _canFreezeFields

    def CanFreezeFields_=(value: Bool) {
        if (_canFreezeFields == value) return
        json("canFreezeFields") = value
        _canFreezeFields = value
    }

    private[this] var _canGroupBy: Bool = canGroupBy

    def CanGroupBy = _canGroupBy

    def CanGroupBy_=(value: Bool) {
        if (_canGroupBy == value) return
        json("canGroupBy") = value
        _canGroupBy = value
    }

    private[this] var _canMultiSort: Bool = canMultiSort

    def CanMultiSort = _canMultiSort

    def CanMultiSort_=(value: Bool) {
        if (_canMultiSort == value) return
        json("canMultiSort") = value
        _canMultiSort = value
    }

    private[this] var _canPickFields: Bool = canPickFields

    def CanPickFields = _canPickFields

    def CanPickFields_=(value: Bool) {
        if (_canPickFields == value) return
        json("canPickFields") = value
        _canPickFields = value
    }

    private[this] var _canPickOmittedFields: Bool = canPickOmittedFields

    def CanPickOmittedFields = _canPickOmittedFields

    def CanPickOmittedFields_=(value: Bool) {
        if (_canPickOmittedFields == value) return
        json("canPickOmittedFields") = value
        _canPickOmittedFields = value
    }

    private[this] var _canRemoveRecords: Bool = canRemoveRecords

    def CanRemoveRecords = _canRemoveRecords

    def CanRemoveRecords_=(value: Bool) {
        if (_canRemoveRecords == value) return
        json("canRemoveRecords") = value
        _canRemoveRecords = value
    }

    private[this] var _canReorderFields: Bool = canReorderFields

    def CanReorderFields = _canReorderFields

    def CanReorderFields_=(value: Bool) {
        if (_canReorderFields == value) return
        json("canReorderFields") = value
        _canReorderFields = value
    }

    private[this] var _canReorderRecords: Bool = canReorderRecords

    def CanReorderRecords = _canReorderRecords

    def CanReorderRecords_=(value: Bool) {
        if (_canReorderRecords == value) return
        json("canReorderRecords") = value
        _canReorderRecords = value
    }

    private[this] var _canResizeFields: Bool = canResizeFields

    def CanResizeFields = _canResizeFields

    def CanResizeFields_=(value: Bool) {
        if (_canResizeFields == value) return
        json("canResizeFields") = value
        _canResizeFields = value
    }

    private[this] var _canSelectAll: Bool = canSelectAll

    def CanSelectAll = _canSelectAll

    def CanSelectAll_=(value: Bool) {
        if (_canSelectAll == value) return
        json("canSelectAll") = value
        _canSelectAll = value
    }

    private[this] var _canSort: Bool = canSort

    def CanSort = _canSort

    def CanSort_=(value: Bool) {
        if (_canSort == value) return
        json("canSort") = value
        _canSort = value
    }

    private[this] var _canTabToHeader: Bool = canTabToHeader

    def CanTabToHeader = _canTabToHeader

    def CanTabToHeader_=(value: Bool) {
        if (_canTabToHeader == value) return
        json("canTabToHeader") = value
        _canTabToHeader = value
    }

    private[this] var _cellHeight: Number = cellHeight

    def CellHeight = _cellHeight

    def CellHeight_=(value: Number) {
        if (_cellHeight == value) return
        json("cellHeight") = value
        _cellHeight = value
    }

    private[this] var _cellPadding: Number = cellPadding
    def CellPadding = _cellPadding
    def CellPadding_=(value: Number) {
        if (_cellPadding == value) return
        json("cellPadding") = value
        _cellPadding = value
    }

    def CellSelectionChanged = json.getFunctionExpressionOpt("cellSelectionChanged").getOrElse(cellSelectionChanged)
    def CellSelectionChanged_=(value: FunctionExpression) {
        if (CellSelectionChanged == value) return
        json("cellSelectionChanged") = value
    }

    private[this] var _chartConstructor: SCClassName = chartConstructor
    def ChartConstructor = _chartConstructor
    def ChartConstructor_=(value: SCClassName) {
        if (_chartConstructor == value) return
        json("chartConstructor") = value
        _chartConstructor = value
    }

    private[this] var _chartType: ChartType = chartType
    def ChartType = _chartType
    def ChartType_=(value: ChartType) {
        if (_chartType == value) return
        json("chartType") = value
        _chartType = value
    }

    private[this] var _checkboxField: AutoChild = checkboxField

    def CheckboxField = _checkboxField

    def CheckboxField_=(value: AutoChild) {
        if (_checkboxField == value) return
        json("checkboxField") = value
        _checkboxField = value
    }

    private[this] var _checkboxFieldFalseImage: SCImgURL = checkboxFieldFalseImage

    def CheckboxFieldFalseImage = _checkboxFieldFalseImage

    def CheckboxFieldFalseImage_=(value: SCImgURL) {
        if (_checkboxFieldFalseImage == value) return
        json("checkboxFieldFalseImage") = value
        _checkboxFieldFalseImage = value
    }

    private[this] var _checkboxFieldImageHeight: Number = checkboxFieldImageHeight

    def CheckboxFieldImageHeight = _checkboxFieldImageHeight

    def CheckboxFieldImageHeight_=(value: Number) {
        if (_checkboxFieldImageHeight == value) return
        json("checkboxFieldImageHeight") = value
        _checkboxFieldImageHeight = value
    }

    private[this] var _checkboxFieldImageWidth: Number = checkboxFieldImageWidth

    def CheckboxFieldImageWidth = _checkboxFieldImageWidth

    def CheckboxFieldImageWidth_=(value: Number) {
        if (_checkboxFieldImageWidth == value) return
        json("checkboxFieldImageWidth") = value
        _checkboxFieldImageWidth = value
    }

    private[this] var _checkboxFieldPartialImage: SCImgURL = checkboxFieldPartialImage

    def CheckboxFieldPartialImage = _checkboxFieldPartialImage

    def CheckboxFieldPartialImage_=(value: SCImgURL) {
        if (_checkboxFieldPartialImage == value) return
        json("checkboxFieldPartialImage") = value
        _checkboxFieldPartialImage = value
    }

    private[this] var _checkboxFieldTrueImage: SCImgURL = checkboxFieldTrueImage

    def CheckboxFieldTrueImage = _checkboxFieldTrueImage

    def CheckboxFieldTrueImage_=(value: SCImgURL) {
        if (_checkboxFieldTrueImage == value) return
        json("checkboxFieldTrueImage") = value
        _checkboxFieldTrueImage = value
    }

    private[this] var _childExpansionMode: ExpansionMode = childExpansionMode

    def ChildExpansionMode = _childExpansionMode

    def ChildExpansionMode_=(value: ExpansionMode) {
        if (_childExpansionMode == value) return
        json("childExpansionMode") = value
        _childExpansionMode = value
    }

    private[this] var _clearAllSortingText: String = clearAllSortingText

    def ClearAllSortingText = _clearAllSortingText

    def ClearAllSortingText_=(value: String) {
        if (_clearAllSortingText == value) return
        json("clearAllSortingText") = value
        _clearAllSortingText = value
    }

    private[this] var _clearFilterText: String = clearFilterText

    def ClearFilterText = _clearFilterText

    def ClearFilterText_=(value: String) {
        if (_clearFilterText == value) return
        json("clearFilterText") = value
        _clearFilterText = value
    }

    private[this] var _clearSortFieldText: String = clearSortFieldText

    def ClearSortFieldText = _clearSortFieldText

    def ClearSortFieldText_=(value: String) {
        if (_clearSortFieldText == value) return
        json("clearSortFieldText") = value
        _clearSortFieldText = value
    }

    private[this] var _configureSortText: String = configureSortText

    def ConfigureSortText = _configureSortText

    def ConfigureSortText_=(value: String) {
        if (_configureSortText == value) return
        json("configureSortText") = value
        _configureSortText = value
    }

    private[this] var _confirmCancelEditing: Bool = confirmCancelEditing

    def ConfirmCancelEditing = _confirmCancelEditing

    def ConfirmCancelEditing_=(value: Bool) {
        if (_confirmCancelEditing == value) return
        json("confirmCancelEditing") = value
        _confirmCancelEditing = value
    }

    private[this] var _confirmDiscardEdits: Bool = confirmDiscardEdits

    def ConfirmDiscardEdits = _confirmDiscardEdits

    def ConfirmDiscardEdits_=(value: Bool) {
        if (_confirmDiscardEdits == value) return
        json("confirmDiscardEdits") = value
        _confirmDiscardEdits = value
    }

    private[this] var _confirmDiscardEditsMessage: String = confirmDiscardEditsMessage

    def ConfirmDiscardEditsMessage = _confirmDiscardEditsMessage

    def ConfirmDiscardEditsMessage_=(value: String) {
        if (_confirmDiscardEditsMessage == value) return
        json("confirmDiscardEditsMessage") = value
        _confirmDiscardEditsMessage = value
    }

    def CreateRecordComponent = json.getFunctionExpressionOpt("createRecordComponent").getOrElse(createRecordComponent)
    def CreateRecordComponent_=(value: FunctionExpression) {
        if (CreateRecordComponent == value) return
        json("createRecordComponent") = value
    }

    def DataProperties = json.getJsonElement("dataProperties").getOrElse(dataProperties)
    def DataProperties_=(value: JsonElement) {
        if (DataProperties == value) return
        json("dataProperties") = value
    }

    private[this] var _dateFormatter: DateDisplayFormat = dateFormatter

    def DateFormatter = _dateFormatter

    def DateFormatter_=(value: DateDisplayFormat) {
        if (_dateFormatter == value) return
        json("dateFormatter") = value
        _dateFormatter = value
    }

    private[this] var _dateInputFormat: String = dateInputFormat

    def DateInputFormat = _dateInputFormat

    def DateInputFormat_=(value: String) {
        if (_dateInputFormat == value) return
        json("dateInputFormat") = value
        _dateInputFormat = value
    }

    private[this] var _datetimeFormatter: DateDisplayFormat = datetimeFormatter

    def DatetimeFormatter = _datetimeFormatter

    def DatetimeFormatter_=(value: DateDisplayFormat) {
        if (_datetimeFormatter == value) return
        json("datetimeFormatter") = value
        _datetimeFormatter = value
    }

    private[this] var _defaultFields: ArrayDyn[ListGridFieldDyn] = defaultFields

    def DefaultFields = _defaultFields

    def DefaultFields_=(value: ArrayDyn[ListGridFieldDyn]) {
        if (_defaultFields == value) return
        json("defaultFields") = value
        _defaultFields = value
    }

    private[this] var _deferRemoval: Bool = deferRemoval

    def DeferRemoval = _deferRemoval

    def DeferRemoval_=(value: Bool) {
        if (_deferRemoval == value) return
        json("deferRemoval") = value
        _deferRemoval = value
    }

    private[this] var _detailDS: String = detailDS

    def DetailDS = _detailDS

    def DetailDS_=(value: String) {
        if (_detailDS == value) return
        json("detailDS") = value
        _detailDS = value
    }

    def DetailField = json.getJsonElement("detailField").getOrElse(detailField)
    def DetailField_=(value: JsonElement) {
        if (DetailField == value) return
        json("detailField") = value
    }

    private[this] var _discardEditsSaveButtonTitle: String = discardEditsSaveButtonTitle

    def DiscardEditsSaveButtonTitle = _discardEditsSaveButtonTitle

    def DiscardEditsSaveButtonTitle_=(value: String) {
        if (_discardEditsSaveButtonTitle == value) return
        json("discardEditsSaveButtonTitle") = value
        _discardEditsSaveButtonTitle = value
    }

    private[this] var _dragTrackerMode: DragTrackerMode = dragTrackerMode
    def DragTrackerMode = _dragTrackerMode
    def DragTrackerMode_=(value: DragTrackerMode) {
        if (_dragTrackerMode == value) return
        json("dragTrackerMode") = value
        _dragTrackerMode = value
    }

    def DrawAheadRatio = json.getJsonElement("drawAheadRatio").getOrElse(drawAheadRatio)
    def DrawAheadRatio_=(value: JsonElement) {
        if (DrawAheadRatio == value) return
        json("drawAheadRatio") = value
    }

    private[this] var _drawAllMaxCells: Number = drawAllMaxCells

    def DrawAllMaxCells = _drawAllMaxCells

    def DrawAllMaxCells_=(value: Number) {
        if (_drawAllMaxCells == value) return
        json("drawAllMaxCells") = value
        _drawAllMaxCells = value
    }

    def EditByCell = json.getJsonElement("editByCell").getOrElse(editByCell)
    def EditByCell_=(value: JsonElement) {
        if (EditByCell == value) return
        json("editByCell") = value
    }

    def EditEvent = json.getValue2[JsonString, ListGridEditEvent]("editEvent").getOrElse(editEvent)
    def EditEvent_=(value: ListGridEditEvent) {
        if (EditEvent == value) return
        json("editEvent") = value
    }

    def EditComplete = json.getFunctionExpressionOpt("editComplete").getOrElse(editComplete)
    def EditComplete_=(value: FunctionExpression) {
        if (EditComplete == value) return
        json("editComplete") = value
    }

    def EditFailed = json.getFunctionExpressionOpt("editFailed").getOrElse(editFailed)
    def EditFailed_=(value: FunctionExpression) {
        if (EditFailed == value) return
        json("editFailed") = value
    }

    private[this] var _editFailedBaseStyle: CSSStyleName = editFailedBaseStyle
    def EditFailedBaseStyle = _editFailedBaseStyle
    def EditFailedBaseStyle_=(value: CSSStyleName) {
        if (_editFailedBaseStyle == value) return
        json("editFailedBaseStyle") = value
        _editFailedBaseStyle = value
    }

    private[this] var _editFailedCSSText: String = editFailedCSSText

    def EditFailedCSSText = _editFailedCSSText

    def EditFailedCSSText_=(value: String) {
        if (_editFailedCSSText == value) return
        json("editFailedCSSText") = value
        _editFailedCSSText = value
    }

    private[this] var _editOnF2Keypress: Bool = editOnF2Keypress

    def EditOnF2Keypress = _editOnF2Keypress

    def EditOnF2Keypress_=(value: Bool) {
        if (_editOnF2Keypress == value) return
        json("editOnF2Keypress") = value
        _editOnF2Keypress = value
    }

    private[this] var _editOnFocus: Bool = editOnFocus

    def EditOnFocus = _editOnFocus

    def EditOnFocus_=(value: Bool) {
        if (_editOnFocus == value) return
        json("editOnFocus") = value
        _editOnFocus = value
    }

    private[this] var _editPendingBaseStyle: CSSStyleName = editPendingBaseStyle

    def EditPendingBaseStyle = _editPendingBaseStyle

    def EditPendingBaseStyle_=(value: CSSStyleName) {
        if (_editPendingBaseStyle == value) return
        json("editPendingBaseStyle") = value
        _editPendingBaseStyle = value
    }

    private[this] var _editPendingCSSText: String = editPendingCSSText

    def EditPendingCSSText = _editPendingCSSText

    def EditPendingCSSText_=(value: String) {
        if (_editPendingCSSText == value) return
        json("editPendingCSSText") = value
        _editPendingCSSText = value
    }

    def EmptyMessage = json.getJsonElement("emptyMessage").getOrElse(emptyMessage)
    def EmptyMessage_=(value: JsonElement) {
        if (EmptyMessage == value) return
        json("emptyMessage") = value
    }

    private[this] var _emptyMessageStyle: CSSStyleName = emptyMessageStyle

    def EmptyMessageStyle = _emptyMessageStyle

    def EmptyMessageStyle_=(value: CSSStyleName) {
        if (_emptyMessageStyle == value) return
        json("emptyMessageStyle") = value
        _emptyMessageStyle = value
    }

    private[this] var _enforceVClipping: Bool = enforceVClipping

    def EnforceVClipping = _enforceVClipping

    def EnforceVClipping_=(value: Bool) {
        if (_enforceVClipping == value) return
        json("enforceVClipping") = value
        _enforceVClipping = value
    }

    private[this] var _enterKeyEditAction: EnterKeyEditAction = enterKeyEditAction
    def EnterKeyEditAction = _enterKeyEditAction
    def EnterKeyEditAction_=(value: EnterKeyEditAction) {
        if (_enterKeyEditAction == value) return
        json("enterKeyEditAction") = value
        _enterKeyEditAction = value
    }

    private[this] var _enumCriteriaAsInitialValues: Bool = enumCriteriaAsInitialValues

    def EnumCriteriaAsInitialValues = _enumCriteriaAsInitialValues

    def EnumCriteriaAsInitialValues_=(value: Bool) {
        if (_enumCriteriaAsInitialValues == value) return
        json("enumCriteriaAsInitialValues") = value
        _enumCriteriaAsInitialValues = value
    }

    private[this] var _escapeKeyEditAction: EscapeKeyEditAction = escapeKeyEditAction
    def EscapeKeyEditAction = _escapeKeyEditAction
    def EscapeKeyEditAction_=(value: EscapeKeyEditAction) {
        if (_escapeKeyEditAction == value) return
        json("escapeKeyEditAction") = value
        _escapeKeyEditAction = value
    }

    private[this] var _expansionCanEdit: Bool = expansionCanEdit

    def ExpansionCanEdit = _expansionCanEdit

    def ExpansionCanEdit_=(value: Bool) {
        if (_expansionCanEdit == value) return
        json("expansionCanEdit") = value
        _expansionCanEdit = value
    }

    private[this] var _expansionDetailField: AutoChild = expansionDetailField

    def ExpansionDetailField = _expansionDetailField

    def ExpansionDetailField_=(value: AutoChild) {
        if (_expansionDetailField == value) return
        json("expansionDetailField") = value
        _expansionDetailField = value
    }

    private[this] var _expansionDetailRelated: AutoChild = expansionDetailRelated

    def ExpansionDetailRelated = _expansionDetailRelated

    def ExpansionDetailRelated_=(value: AutoChild) {
        if (_expansionDetailRelated == value) return
        json("expansionDetailRelated") = value
        _expansionDetailRelated = value
    }

    private[this] var _expansionDetails: AutoChild = expansionDetails

    def ExpansionDetails = _expansionDetails

    def ExpansionDetails_=(value: AutoChild) {
        if (_expansionDetails == value) return
        json("expansionDetails") = value
        _expansionDetails = value
    }

    private[this] var _expansionEditor: AutoChild = expansionEditor

    def ExpansionEditor = _expansionEditor

    def ExpansionEditor_=(value: AutoChild) {
        if (_expansionEditor == value) return
        json("expansionEditor") = value
        _expansionEditor = value
    }

    private[this] var _expansionEditorSaveDialogPrompt: String = expansionEditorSaveDialogPrompt

    def ExpansionEditorSaveDialogPrompt = _expansionEditorSaveDialogPrompt

    def ExpansionEditorSaveDialogPrompt_=(value: String) {
        if (_expansionEditorSaveDialogPrompt == value) return
        json("expansionEditorSaveDialogPrompt") = value
        _expansionEditorSaveDialogPrompt = value
    }

    def ExpansionField = json.getJsonElement("expansionField").getOrElse(expansionField)
    def ExpansionField_=(value: JsonElement) {
        if (ExpansionField == value) return
        json("expansionField") = value
    }

    private[this] var _expansionFieldFalseImage: SCImgURL = expansionFieldFalseImage

    def ExpansionFieldFalseImage = _expansionFieldFalseImage

    def ExpansionFieldFalseImage_=(value: SCImgURL) {
        if (_expansionFieldFalseImage == value) return
        json("expansionFieldFalseImage") = value
        _expansionFieldFalseImage = value
    }

    private[this] var _expansionFieldImageHeight: Number = expansionFieldImageHeight

    def ExpansionFieldImageHeight = _expansionFieldImageHeight

    def ExpansionFieldImageHeight_=(value: Number) {
        if (_expansionFieldImageHeight == value) return
        json("expansionFieldImageHeight") = value
        _expansionFieldImageHeight = value
    }

    private[this] var _expansionFieldImageWidth: Number = expansionFieldImageWidth

    def ExpansionFieldImageWidth = _expansionFieldImageWidth

    def ExpansionFieldImageWidth_=(value: Number) {
        if (_expansionFieldImageWidth == value) return
        json("expansionFieldImageWidth") = value
        _expansionFieldImageWidth = value
    }

    private[this] var _expansionFieldTrueImage: SCImgURL = expansionFieldTrueImage

    def ExpansionFieldTrueImage = _expansionFieldTrueImage

    def ExpansionFieldTrueImage_=(value: SCImgURL) {
        if (_expansionFieldTrueImage == value) return
        json("expansionFieldTrueImage") = value
        _expansionFieldTrueImage = value
    }

    private[this] var _expansionLayout: AutoChild = expansionLayout

    def ExpansionLayout = _expansionLayout

    def ExpansionLayout_=(value: AutoChild) {
        if (_expansionLayout == value) return
        json("expansionLayout") = value
        _expansionLayout = value
    }

    private[this] var _expansionMode: ExpansionMode = expansionMode
    def ExpansionMode = _expansionMode
    def ExpansionMode_=(value: ExpansionMode) {
        if (_expansionMode == value) return
        json("expansionMode") = value
        _expansionMode = value
    }

    private[this] var _expansionRelated: AutoChild = expansionRelated

    def ExpansionRelated = _expansionRelated

    def ExpansionRelated_=(value: AutoChild) {
        if (_expansionRelated == value) return
        json("expansionRelated") = value
        _expansionRelated = value
    }

    private[this] var _exportRawValues: Bool = exportRawValues

    def ExportRawValues = _exportRawValues

    def ExportRawValues_=(value: Bool) {
        if (_exportRawValues == value) return
        json("exportRawValues") = value
        _exportRawValues = value
    }

    private[this] var _fastCellUpdates: Bool = fastCellUpdates

    def FastCellUpdates = _fastCellUpdates

    def FastCellUpdates_=(value: Bool) {
        if (_fastCellUpdates == value) return
        json("fastCellUpdates") = value
        _fastCellUpdates = value
    }

    private[this] var _fetchDelay: Number = fetchDelay
    def FetchDelay = _fetchDelay
    def FetchDelay_=(value: Number) {
        if (_fetchDelay == value) return
        json("fetchDelay") = value
        _fetchDelay = value
    }

    private[this] var _fieldVisibilitySubmenuTitle: String = fieldVisibilitySubmenuTitle
    def FieldVisibilitySubmenuTitle = _fieldVisibilitySubmenuTitle
    def FieldVisibilitySubmenuTitle_=(value: String) {
        if (_fieldVisibilitySubmenuTitle == value) return
        json("fieldVisibilitySubmenuTitle") = value
        _fieldVisibilitySubmenuTitle = value
    }

    private[this] var _filterButtonPrompt: String = filterButtonPrompt

    def FilterButtonPrompt = _filterButtonPrompt

    def FilterButtonPrompt_=(value: String) {
        if (_filterButtonPrompt == value) return
        json("filterButtonPrompt") = value
        _filterButtonPrompt = value
    }

    private[this] var _filterButtonProperties: ButtonDyn = filterButtonProperties

    def FilterButtonProperties = _filterButtonProperties

    def FilterButtonProperties_=(value: ButtonDyn) {
        if (_filterButtonProperties == value) return
        json("filterButtonProperties") = value
        _filterButtonProperties = value
    }

    private[this] var _filterByCell: Bool = filterByCell

    def FilterByCell = _filterByCell

    def FilterByCell_=(value: Bool) {
        if (_filterByCell == value) return
        json("filterByCell") = value
        _filterByCell = value
    }

    def FilterEditor = json.getJsonElement("filterEditor").getOrElse(filterEditor)
    def FilterEditor_=(value: JsonElement) {
        if (FilterEditor == value) return
        json("filterEditor") = value
    }

    private[this] var _filterEditorHeight: Number = filterEditorHeight

    def FilterEditorHeight = _filterEditorHeight

    def FilterEditorHeight_=(value: Number) {
        if (_filterEditorHeight == value) return
        json("filterEditorHeight") = value
        _filterEditorHeight = value
    }

    private[this] var _filterOnKeypress: Bool = filterOnKeypress

    def FilterOnKeypress = _filterOnKeypress

    def FilterOnKeypress_=(value: Bool) {
        if (_filterOnKeypress == value) return
        json("filterOnKeypress") = value
        _filterOnKeypress = value
    }

    private[this] var _fixedFieldWidths: Bool = fixedFieldWidths

    def FixedFieldWidths = _fixedFieldWidths

    def FixedFieldWidths_=(value: Bool) {
        if (_fixedFieldWidths == value) return
        json("fixedFieldWidths") = value
        _fixedFieldWidths = value
    }

    def FixedRecordHeights = json.getJsonElement("fixedRecordHeights").getOrElse(fixedRecordHeights)
    def FixedRecordHeights_=(value: JsonElement) {
        if (FixedRecordHeights == value) return
        json("fixedRecordHeights") = value
    }

    private[this] var _freezeFieldText: String = freezeFieldText

    def FreezeFieldText = _freezeFieldText

    def FreezeFieldText_=(value: String) {
        if (_freezeFieldText == value) return
        json("freezeFieldText") = value
        _freezeFieldText = value
    }

    private[this] var _freezeOnLeftText: String = freezeOnLeftText

    def FreezeOnLeftText = _freezeOnLeftText

    def FreezeOnLeftText_=(value: String) {
        if (_freezeOnLeftText == value) return
        json("freezeOnLeftText") = value
        _freezeOnLeftText = value
    }

    private[this] var _freezeOnRightText: String = freezeOnRightText

    def FreezeOnRightText = _freezeOnRightText

    def FreezeOnRightText_=(value: String) {
        if (_freezeOnRightText == value) return
        json("freezeOnRightText") = value
        _freezeOnRightText = value
    }

    private[this] var _frozenBaseStyle: String = frozenBaseStyle

    def FrozenBaseStyle = _frozenBaseStyle

    def FrozenBaseStyle_=(value: String) {
        if (_frozenBaseStyle == value) return
        json("frozenBaseStyle") = value
        _frozenBaseStyle = value
    }

    private[this] var _frozenHeaderBaseStyle: CSSStyleName = frozenHeaderBaseStyle

    def FrozenHeaderBaseStyle = _frozenHeaderBaseStyle

    def FrozenHeaderBaseStyle_=(value: CSSStyleName) {
        if (_frozenHeaderBaseStyle == value) return
        json("frozenHeaderBaseStyle") = value
        _frozenHeaderBaseStyle = value
    }

    private[this] var _frozenHeaderTitleStyle: CSSStyleName = frozenHeaderTitleStyle

    def FrozenHeaderTitleStyle = _frozenHeaderTitleStyle

    def FrozenHeaderTitleStyle_=(value: CSSStyleName) {
        if (_frozenHeaderTitleStyle == value) return
        json("frozenHeaderTitleStyle") = value
        _frozenHeaderTitleStyle = value
    }

    private[this] var _generateClickOnEnter: Bool = generateClickOnEnter

    def GenerateClickOnEnter = _generateClickOnEnter

    def GenerateClickOnEnter_=(value: Bool) {
        if (_generateClickOnEnter == value) return
        json("generateClickOnEnter") = value
        _generateClickOnEnter = value
    }

    private[this] var _generateClickOnSpace: Bool = generateClickOnSpace

    def GenerateClickOnSpace = _generateClickOnSpace

    def GenerateClickOnSpace_=(value: Bool) {
        if (_generateClickOnSpace == value) return
        json("generateClickOnSpace") = value
        _generateClickOnSpace = value
    }

    private[this] var _generateDoubleClickOnEnter: Bool = generateDoubleClickOnEnter

    def GenerateDoubleClickOnEnter = _generateDoubleClickOnEnter

    def GenerateDoubleClickOnEnter_=(value: Bool) {
        if (_generateDoubleClickOnEnter == value) return
        json("generateDoubleClickOnEnter") = value
        _generateDoubleClickOnEnter = value
    }

    private[this] var _generateDoubleClickOnSpace: Bool = generateDoubleClickOnSpace

    def GenerateDoubleClickOnSpace = _generateDoubleClickOnSpace

    def GenerateDoubleClickOnSpace_=(value: Bool) {
        if (_generateDoubleClickOnSpace == value) return
        json("generateDoubleClickOnSpace") = value
        _generateDoubleClickOnSpace = value
    }

    private[this] var _gridComponents: ListGridComponent = gridComponents
    def GridComponents = _gridComponents
    def GridComponents_=(value: ListGridComponent) {
        if (_gridComponents == value) return
        json("gridComponents") = value
        _gridComponents = value
    }

    private[this] var _gridSummaryRecordProperty: String = gridSummaryRecordProperty

    def GridSummaryRecordProperty = _gridSummaryRecordProperty

    def GridSummaryRecordProperty_=(value: String) {
        if (_gridSummaryRecordProperty == value) return
        json("gridSummaryRecordProperty") = value
        _gridSummaryRecordProperty = value
    }

    def GroupByField = json.getJsonElement("groupByField").getOrElse(groupByField)
    def GroupByField_=(value: JsonElement) {
        if (GroupByField == value) return
        json("groupByField") = value
    }

    private[this] var _groupByFieldSummaries: JsonList = groupByFieldSummaries

    def GroupByFieldSummaries = _groupByFieldSummaries

    def GroupByFieldSummaries_=(value: JsonList) {
        if (_groupByFieldSummaries == value) return
        json("groupByFieldSummaries") = value
        _groupByFieldSummaries = value
    }

    private[this] var _groupByMaxRecords: Number = groupByMaxRecords

    def GroupByMaxRecords = _groupByMaxRecords

    def GroupByMaxRecords_=(value: Number) {
        if (_groupByMaxRecords == value) return
        json("groupByMaxRecords") = value
        _groupByMaxRecords = value
    }

    private[this] var _groupByText: String = groupByText

    def GroupByText = _groupByText

    def GroupByText_=(value: String) {
        if (_groupByText == value) return
        json("groupByText") = value
        _groupByText = value
    }

    private[this] var _groupIcon: SCImgURL = groupIcon

    def GroupIcon = _groupIcon

    def GroupIcon_=(value: SCImgURL) {
        if (_groupIcon == value) return
        json("groupIcon") = value
        _groupIcon = value
    }


    private[this] var _groupIconSize: Number = groupIconSize

    def GroupIconSize = _groupIconSize

    def GroupIconSize_=(value: Number) {
        if (_groupIconSize == value) return
        json("groupIconSize") = value
        _groupIconSize = value
    }

    private[this] var _groupIndentSize: Number = groupIndentSize

    def GroupIndentSize = _groupIndentSize

    def GroupIndentSize_=(value: Number) {
        if (_groupIndentSize == value) return
        json("groupIndentSize") = value
        _groupIndentSize = value
    }

    private[this] var _groupLeadingIndent: Number = groupLeadingIndent

    def GroupLeadingIndent = _groupLeadingIndent

    def GroupLeadingIndent_=(value: Number) {
        if (_groupLeadingIndent == value) return
        json("groupLeadingIndent") = value
        _groupLeadingIndent = value
    }

    private[this] var _groupNodeStyle: String = groupNodeStyle

    def GroupNodeStyle = _groupNodeStyle

    def GroupNodeStyle_=(value: String) {
        if (_groupNodeStyle == value) return
        json("groupNodeStyle") = value
        _groupNodeStyle = value
    }

    private[this] var _groupStartOpen: GroupStartOpen = groupStartOpen
    def GroupStartOpen = _groupStartOpen
    def GroupStartOpen_=(value: GroupStartOpen) {
        if (_groupStartOpen == value) return
        json("groupStartOpen") = value
        _groupStartOpen = value
    }

    private[this] var _groupSummaryRecordProperty: String = groupSummaryRecordProperty

    def GroupSummaryRecordProperty = _groupSummaryRecordProperty

    def GroupSummaryRecordProperty_=(value: String) {
        if (_groupSummaryRecordProperty == value) return
        json("groupSummaryRecordProperty") = value
        _groupSummaryRecordProperty = value
    }

    private[this] var _groupSummaryStyle: CSSStyleName = groupSummaryStyle

    def GroupSummaryStyle = _groupSummaryStyle

    def GroupSummaryStyle_=(value: CSSStyleName) {
        if (_groupSummaryStyle == value) return
        json("groupSummaryStyle") = value
        _groupSummaryStyle = value
    }

    private[this] var _groupTitleColumnDefaults: ListGridFieldDyn = groupTitleColumnDefaults

    def GroupTitleColumnDefaults = _groupTitleColumnDefaults

    def GroupTitleColumnDefaults_=(value: ListGridFieldDyn) {
        if (_groupTitleColumnDefaults == value) return
        json("groupTitleColumnDefaults") = value
        _groupTitleColumnDefaults = value
    }

    private[this] var _groupTitleColumnProperties: ListGridFieldDyn = groupTitleColumnProperties
    def GroupTitleColumnProperties = _groupTitleColumnProperties
    def GroupTitleColumnProperties_=(value: ListGridFieldDyn) {
        if (_groupTitleColumnProperties == value) return
        json("groupTitleColumnProperties") = value
        _groupTitleColumnProperties = value
    }

    private[this] var _groupTitleField: String = groupTitleField

    def GroupTitleField = _groupTitleField

    def GroupTitleField_=(value: String) {
        if (_groupTitleField == value) return
        json("groupTitleField") = value
        _groupTitleField = value
    }

    private[this] var _groupTree: AutoChild = groupTree

    def GroupTree = _groupTree

    def GroupTree_=(value: AutoChild) {
        if (_groupTree == value) return
        json("groupTree") = value
        _groupTree = value
    }

    private[this] var _header: AutoChild = header

    def Header = _header

    def Header_=(value: AutoChild) {
        if (_header == value) return
        json("header") = value
        _header = value
    }

    private[this] var _headerAutoFitEvent: AutoFitEvent = headerAutoFitEvent
    def HeaderAutoFitEvent = _headerAutoFitEvent
    def HeaderAutoFitEvent_=(value: AutoFitEvent) {
        if (_headerAutoFitEvent == value) return
        json("headerAutoFitEvent") = value
        _headerAutoFitEvent = value
    }

    private[this] var _headerBackgroundColor: Color = headerBackgroundColor

    def HeaderBackgroundColor = _headerBackgroundColor

    def HeaderBackgroundColor_=(value: Color) {
        if (_headerBackgroundColor == value) return
        json("headerBackgroundColor") = value
        _headerBackgroundColor = value
    }

    private[this] var _headerBarStyle: CSSStyleName = headerBarStyle

    def HeaderBarStyle = _headerBarStyle

    def HeaderBarStyle_=(value: CSSStyleName) {
        if (_headerBarStyle == value) return
        json("headerBarStyle") = value
        _headerBarStyle = value
    }

    private[this] var _headerBaseStyle: CSSStyleName = headerBaseStyle

    def HeaderBaseStyle = _headerBaseStyle

    def HeaderBaseStyle_=(value: CSSStyleName) {
        if (_headerBaseStyle == value) return
        json("headerBaseStyle") = value
        _headerBaseStyle = value
    }

    private[this] var _headerButtonConstructor: SCClassName = headerButtonConstructor

    def HeaderButtonConstructor = _headerButtonConstructor

    def HeaderButtonConstructor_=(value: SCClassName) {
        if (_headerButtonConstructor == value) return
        json("headerButtonConstructor") = value
        _headerButtonConstructor = value
    }

    private[this] var _headerButtonDefaults: ButtonDyn = headerButtonDefaults

    def HeaderButtonDefaults = _headerButtonDefaults

    def HeaderButtonDefaults_=(value: ButtonDyn) {
        if (_headerButtonDefaults == value) return
        json("headerButtonDefaults") = value
        _headerButtonDefaults = value
    }

    private[this] var _headerButtonProperties: ButtonDyn = headerButtonProperties

    def HeaderButtonProperties = _headerButtonProperties

    def HeaderButtonProperties_=(value: ButtonDyn) {
        if (_headerButtonProperties == value) return
        json("headerButtonProperties") = value
        _headerButtonProperties = value
    }

    private[this] var _headerHeight: Number = headerHeight

    def HeaderHeight = _headerHeight

    def HeaderHeight_=(value: Number) {
        if (_headerHeight == value) return
        json("headerHeight") = value
        _headerHeight = value
    }

    private[this] var _headerMenuButton: AutoChild = headerMenuButton

    def HeaderMenuButton = _headerMenuButton

    def HeaderMenuButton_=(value: AutoChild) {
        if (_headerMenuButton == value) return
        json("headerMenuButton") = value
        _headerMenuButton = value
    }

    private[this] var _headerMenuButtonConstructor: SCClassName = headerMenuButtonConstructor

    def HeaderMenuButtonConstructor = _headerMenuButtonConstructor

    def HeaderMenuButtonConstructor_=(value: SCClassName) {
        if (_headerMenuButtonConstructor == value) return
        json("headerMenuButtonConstructor") = value
        _headerMenuButtonConstructor = value
    }

    private[this] var _headerMenuButtonHeight: Number = headerMenuButtonHeight

    def HeaderMenuButtonHeight = _headerMenuButtonHeight

    def HeaderMenuButtonHeight_=(value: Number) {
        if (_headerMenuButtonHeight == value) return
        json("headerMenuButtonHeight") = value
        _headerMenuButtonHeight = value
    }

    private[this] var _headerMenuButtonIcon: URL = headerMenuButtonIcon

    def HeaderMenuButtonIcon = _headerMenuButtonIcon

    def HeaderMenuButtonIcon_=(value: URL) {
        if (_headerMenuButtonIcon == value) return
        json("headerMenuButtonIcon") = value
        _headerMenuButtonIcon = value
    }

    private[this] var _headerMenuButtonIconHeight: Number = headerMenuButtonIconHeight

    def HeaderMenuButtonIconHeight = _headerMenuButtonIconHeight

    def HeaderMenuButtonIconHeight_=(value: Number) {
        if (_headerMenuButtonIconHeight == value) return
        json("headerMenuButtonIconHeight") = value
        _headerMenuButtonIconHeight = value
    }

    private[this] var _headerMenuButtonIconWidth: Number = headerMenuButtonIconWidth

    def HeaderMenuButtonIconWidth = _headerMenuButtonIconWidth

    def HeaderMenuButtonIconWidth_=(value: Number) {
        if (_headerMenuButtonIconWidth == value) return
        json("headerMenuButtonIconWidth") = value
        _headerMenuButtonIconWidth = value
    }

    private[this] var _headerMenuButtonWidth: Number = headerMenuButtonWidth

    def HeaderMenuButtonWidth = _headerMenuButtonWidth

    def HeaderMenuButtonWidth_=(value: Number) {
        if (_headerMenuButtonWidth == value) return
        json("headerMenuButtonWidth") = value
        _headerMenuButtonWidth = value
    }

    private[this] var _headerSpan: AutoChild = headerSpan

    def HeaderSpan = _headerSpan

    def HeaderSpan_=(value: AutoChild) {
        if (_headerSpan == value) return
        json("headerSpan") = value
        _headerSpan = value
    }

    private[this] var _headerSpanConstructor: SCClassName = headerSpanConstructor

    def HeaderSpanConstructor = _headerSpanConstructor

    def HeaderSpanConstructor_=(value: SCClassName) {
        if (_headerSpanConstructor == value) return
        json("headerSpanConstructor") = value
        _headerSpanConstructor = value
    }

    private[this] var _headerSpanHeight: Number = headerSpanHeight

    def HeaderSpanHeight = _headerSpanHeight

    def HeaderSpanHeight_=(value: Number) {
        if (_headerSpanHeight == value) return
        json("headerSpanHeight") = value
        _headerSpanHeight = value
    }

    private[this] var _headerSpans: ArrayDyn[HeaderSpanDyn] = headerSpans

    def HeaderSpans = _headerSpans

    def HeaderSpans_=(value: ArrayDyn[HeaderSpanDyn]) {
        if (_headerSpans == value) return
        json("headerSpans") = value
        _headerSpans = value
    }

    private[this] var _headerSpanVAlign: AlignmentDyn = headerSpanVAlign

    def HeaderSpanVAlign = _headerSpanVAlign

    def HeaderSpanVAlign_=(value: AlignmentDyn) {
        if (_headerSpanVAlign == value) return
        json("headerSpanVAlign") = value
        _headerSpanVAlign = value
    }

    private[this] var _headerTitleStyle: CSSStyleName = headerTitleStyle

    def HeaderTitleStyle = _headerTitleStyle

    def HeaderTitleStyle_=(value: CSSStyleName) {
        if (_headerTitleStyle == value) return
        json("headerTitleStyle") = value
        _headerTitleStyle = value
    }

    private[this] var _hoverMode: HoverMode = hoverMode
    def HoverMode = _hoverMode
    def HoverMode_=(value: HoverMode) {
        if (_hoverMode == value) return
        json("hoverMode") = value
        _hoverMode = value
    }

    private[this] var _id: String = id

    def Id = _id

    def Id_=(value: String) {
        if (_id == value) return
        json("id") = value
        _id = value
    }

    private[this] var _imageSize: Number = imageSize

    def ImageSize = _imageSize

    def ImageSize_=(value: Number) {
        if (_imageSize == value) return
        json("imageSize") = value
        _imageSize = value
    }

    private[this] var _includeInSummaryProperty: String = includeInSummaryProperty

    def IncludeInSummaryProperty = _includeInSummaryProperty

    def IncludeInSummaryProperty_=(value: String) {
        if (_includeInSummaryProperty == value) return
        json("includeInSummaryProperty") = value
        _includeInSummaryProperty = value
    }

    def InitialCriteria = json.getJsonElement("initialCriteria").getOrElse(initialCriteria)
    def InitialCriteria_=(value: JsonElement) {
        if (InitialCriteria == value) return
        json("initialCriteria") = value
    }

    private[this] var _initialSort: ArrayDyn[SortSpecifierDyn] = initialSort
    def InitialSort = _initialSort
    def InitialSort_=(value: ArrayDyn[SortSpecifierDyn]) {
        if (_initialSort == value) return
        json("initialSort") = value
        _initialSort = value
    }

    def InvalidateCache = json.getFunctionExpressionOpt("invalidateCache").getOrElse(invalidateCache)
    def InvalidateCache_=(value: FunctionExpression) {
        if (InvalidateCache == value) return
        json("invalidateCache") = value
    }

    private[this] var _instantScrollTrackRedraw: Bool = instantScrollTrackRedraw

    def InstantScrollTrackRedraw = _instantScrollTrackRedraw

    def InstantScrollTrackRedraw_=(value: Bool) {
        if (_instantScrollTrackRedraw == value) return
        json("instantScrollTrackRedraw") = value
        _instantScrollTrackRedraw = value
    }

    private[this] var _invalidSummaryValue: String = invalidSummaryValue

    def InvalidSummaryValue = _invalidSummaryValue

    def InvalidSummaryValue_=(value: String) {
        if (_invalidSummaryValue == value) return
        json("invalidSummaryValue") = value
        _invalidSummaryValue = value
    }

    private[this] var _isGrouped: Bool = isGrouped

    def IsGrouped = _isGrouped

    def IsGrouped_=(value: Bool) {
        if (_isGrouped == value) return
        json("isGrouped") = value
        _isGrouped = value
    }

    private[this] var _isSeparatorProperty: String = isSeparatorProperty

    def IsSeparatorProperty = _isSeparatorProperty

    def IsSeparatorProperty_=(value: String) {
        if (_isSeparatorProperty == value) return
        json("isSeparatorProperty") = value
        _isSeparatorProperty = value
    }

    private[this] var _leaveHeaderMenuButtonSpace: Bool = leaveHeaderMenuButtonSpace

    def LeaveHeaderMenuButtonSpace = _leaveHeaderMenuButtonSpace

    def LeaveHeaderMenuButtonSpace_=(value: Bool) {
        if (_leaveHeaderMenuButtonSpace == value) return
        json("leaveHeaderMenuButtonSpace") = value
        _leaveHeaderMenuButtonSpace = value
    }

    private[this] var _linkTextProperty: String = linkTextProperty

    def LinkTextProperty = _linkTextProperty

    def LinkTextProperty_=(value: String) {
        if (_linkTextProperty == value) return
        json("linkTextProperty") = value
        _linkTextProperty = value
    }

    private[this] var _listEndEditAction: RowEndEditAction = listEndEditAction

    def ListEndEditAction = _listEndEditAction

    def ListEndEditAction_=(value: RowEndEditAction) {
        if (_listEndEditAction == value) return
        json("listEndEditAction") = value
        _listEndEditAction = value
    }

    private[this] var _loadingDataMessage: HTMLString = loadingDataMessage

    def LoadingDataMessage = _loadingDataMessage

    def LoadingDataMessage_=(value: HTMLString) {
        if (_loadingDataMessage == value) return
        json("loadingDataMessage") = value
        _loadingDataMessage = value
    }

    private[this] var _loadingDataMessageStyle: CSSStyleName = loadingDataMessageStyle

    def LoadingDataMessageStyle = _loadingDataMessageStyle

    def LoadingDataMessageStyle_=(value: CSSStyleName) {
        if (_loadingDataMessageStyle == value) return
        json("loadingDataMessageStyle") = value
        _loadingDataMessageStyle = value
    }

    private[this] var _loadingMessage: String = loadingMessage

    def LoadingMessage = _loadingMessage

    def LoadingMessage_=(value: String) {
        if (_loadingMessage == value) return
        json("loadingMessage") = value
        _loadingMessage = value
    }

    private[this] var _locateColumnsBy: String = locateColumnsBy

    def LocateColumnsBy = _locateColumnsBy

    def LocateColumnsBy_=(value: String) {
        if (_locateColumnsBy == value) return
        json("locateColumnsBy") = value
        _locateColumnsBy = value
    }

    private[this] var _locateRowsBy: String = locateRowsBy

    def LocateRowsBy = _locateRowsBy

    def LocateRowsBy_=(value: String) {
        if (_locateRowsBy == value) return
        json("locateRowsBy") = value
        _locateRowsBy = value
    }

    private[this] var _longTextEditorThreshold: Number = longTextEditorThreshold

    def LongTextEditorThreshold = _longTextEditorThreshold

    def LongTextEditorThreshold_=(value: Number) {
        if (_longTextEditorThreshold == value) return
        json("longTextEditorThreshold") = value
        _longTextEditorThreshold = value
    }

    private[this] var _longTextEditorType: String = longTextEditorType

    def LongTextEditorType = _longTextEditorType

    def LongTextEditorType_=(value: String) {
        if (_longTextEditorType == value) return
        json("longTextEditorType") = value
        _longTextEditorType = value
    }

    private[this] var _maxExpandedRecords: Number = maxExpandedRecords

    def MaxExpandedRecords = _maxExpandedRecords

    def MaxExpandedRecords_=(value: Number) {
        if (_maxExpandedRecords == value) return
        json("maxExpandedRecords") = value
        _maxExpandedRecords = value
    }

    private[this] var _maxExpandedRecordsPrompt: String = maxExpandedRecordsPrompt

    def MaxExpandedRecordsPrompt = _maxExpandedRecordsPrompt

    def MaxExpandedRecordsPrompt_=(value: String) {
        if (_maxExpandedRecordsPrompt == value) return
        json("maxExpandedRecordsPrompt") = value
        _maxExpandedRecordsPrompt = value
    }

    private[this] var _minFieldWidth: Number = minFieldWidth

    def MinFieldWidth = _minFieldWidth

    def MinFieldWidth_=(value: Number) {
        if (_minFieldWidth == value) return
        json("minFieldWidth") = value
        _minFieldWidth = value
    }

    private[this] var _modalEditing: Bool = modalEditing
    def ModalEditing = _modalEditing
    def ModalEditing_=(value: Bool) {
        if (_modalEditing == value) return
        json("modalEditing") = value
        _modalEditing = value
    }

    private[this] var _neverValidate: Bool = neverValidate

    def NeverValidate = _neverValidate

    def NeverValidate_=(value: Bool) {
        if (_neverValidate == value) return
        json("neverValidate") = value
        _neverValidate = value
    }

    private[this] var _normalBaseStyle: CSSStyleName = normalBaseStyle

    def NormalBaseStyle = _normalBaseStyle

    def NormalBaseStyle_=(value: CSSStyleName) {
        if (_normalBaseStyle == value) return
        json("normalBaseStyle") = value
        _normalBaseStyle = value
    }

    private[this] var _normalCellHeight: Number = normalCellHeight

    def NormalCellHeight = _normalCellHeight

    def NormalCellHeight_=(value: Number) {
        if (_normalCellHeight == value) return
        json("normalCellHeight") = value
        _normalCellHeight = value
    }

    private[this] var _nullGroupTitle: String = nullGroupTitle

    def NullGroupTitle = _nullGroupTitle

    def NullGroupTitle_=(value: String) {
        if (_nullGroupTitle == value) return
        json("nullGroupTitle") = value
        _nullGroupTitle = value
    }

    private[this] var _offlineMessageStyle: CSSStyleName = offlineMessageStyle

    def OfflineMessageStyle = _offlineMessageStyle

    def OfflineMessageStyle_=(value: CSSStyleName) {
        if (_offlineMessageStyle == value) return
        json("offlineMessageStyle") = value
        _offlineMessageStyle = value
    }

    private[this] var _originalData: JsonObject = originalData

    def OriginalData = _originalData

    def OriginalData_=(value: JsonObject) {
        json("originalData") = value
        _originalData = value
    }

    private[this] var _poolComponentsPerColumn: Bool = poolComponentsPerColumn

    def PoolComponentsPerColumn = _poolComponentsPerColumn

    def PoolComponentsPerColumn_=(value: Bool) {
        if (_poolComponentsPerColumn == value) return
        json("poolComponentsPerColumn") = value
        _poolComponentsPerColumn = value
    }

    private[this] var _printAutoFit: Bool = printAutoFit

    def PrintAutoFit = _printAutoFit

    def PrintAutoFit_=(value: Bool) {
        if (_printAutoFit == value) return
        json("printAutoFit") = value
        _printAutoFit = value
    }

    private[this] var _printBaseStyle: CSSStyleName = printBaseStyle

    def PrintBaseStyle = _printBaseStyle

    def PrintBaseStyle_=(value: CSSStyleName) {
        if (_printBaseStyle == value) return
        json("printBaseStyle") = value
        _printBaseStyle = value
    }

    private[this] var _printHeaderStyle: CSSStyleName = printHeaderStyle

    def PrintHeaderStyle = _printHeaderStyle

    def PrintHeaderStyle_=(value: CSSStyleName) {
        if (_printHeaderStyle == value) return
        json("printHeaderStyle") = value
        _printHeaderStyle = value
    }

    private[this] var _printMaxRows: Number = printMaxRows

    def PrintMaxRows = _printMaxRows

    def PrintMaxRows_=(value: Number) {
        if (_printMaxRows == value) return
        json("printMaxRows") = value
        _printMaxRows = value
    }

    private[this] var _printWrapCells: Bool = printWrapCells

    def PrintWrapCells = _printWrapCells

    def PrintWrapCells_=(value: Bool) {
        if (_printWrapCells == value) return
        json("printWrapCells") = value
        _printWrapCells = value
    }

    private[this] var _quickDrawAheadRatio: Number = quickDrawAheadRatio

    def QuickDrawAheadRatio = _quickDrawAheadRatio

    def QuickDrawAheadRatio_=(value: Number) {
        if (_quickDrawAheadRatio == value) return
        json("quickDrawAheadRatio") = value
        _quickDrawAheadRatio = value
    }

    private[this] var _recordBaseStyleProperty: String = recordBaseStyleProperty

    def RecordBaseStyleProperty = _recordBaseStyleProperty

    def RecordBaseStyleProperty_=(value: String) {
        if (_recordBaseStyleProperty == value) return
        json("recordBaseStyleProperty") = value
        _recordBaseStyleProperty = value
    }

    private[this] var _recordCanSelectProperty: String = recordCanSelectProperty

    def RecordCanSelectProperty = _recordCanSelectProperty

    def RecordCanSelectProperty_=(value: String) {
        if (_recordCanSelectProperty == value) return
        json("recordCanSelectProperty") = value
        _recordCanSelectProperty = value
    }

    private[this] var _recordClick: FunctionExpression = recordClick

    def RecordClick = _recordClick

    def RecordClick_=(value: FunctionExpression) {
        json("recordClick") = value
        _recordClick = value
    }

    private[this] var _recordComponentHeight: Number = recordComponentHeight

    def RecordComponentHeight = _recordComponentHeight

    def RecordComponentHeight_=(value: Number) {
        if (_recordComponentHeight == value) return
        json("recordComponentHeight") = value
        _recordComponentHeight = value
    }

    def RecordComponentPoolingMode = json.getValue2[JsonString, RecordComponentPoolingMode]("recordComponentPoolingMode").getOrElse(recordComponentPoolingMode)
    def RecordComponentPoolingMode_=(value: RecordComponentPoolingMode) {
        if (RecordComponentPoolingMode == value) return
        json("recordComponentPoolingMode") = value
    }

    private[this] var _recordComponentPosition: EmbeddedPosition = recordComponentPosition
    def RecordComponentPosition = _recordComponentPosition
    def RecordComponentPosition_=(value: EmbeddedPosition) {
        if (_recordComponentPosition == value) return
        json("recordComponentPosition") = value
        _recordComponentPosition = value
    }

    private[this] var _recordCustomStyleProperty: String = recordCustomStyleProperty

    def RecordCustomStyleProperty = _recordCustomStyleProperty

    def RecordCustomStyleProperty_=(value: String) {
        if (_recordCustomStyleProperty == value) return
        json("recordCustomStyleProperty") = value
        _recordCustomStyleProperty = value
    }

    private[this] var _recordDetailDSProperty: String = recordDetailDSProperty

    def RecordDetailDSProperty = _recordDetailDSProperty

    def RecordDetailDSProperty_=(value: String) {
        if (_recordDetailDSProperty == value) return
        json("recordDetailDSProperty") = value
        _recordDetailDSProperty = value
    }

    private[this] var _recordEditProperty: String = recordEditProperty

    def RecordEditProperty = _recordEditProperty

    def RecordEditProperty_=(value: String) {
        if (_recordEditProperty == value) return
        json("recordEditProperty") = value
        _recordEditProperty = value
    }

    private[this] var _recordEnabledProperty: String = recordEnabledProperty

    def RecordEnabledProperty = _recordEnabledProperty

    def RecordEnabledProperty_=(value: String) {
        if (_recordEnabledProperty == value) return
        json("recordEnabledProperty") = value
        _recordEnabledProperty = value
    }

    private[this] var _recordSummaryBaseStyle: CSSStyleName = recordSummaryBaseStyle

    def RecordSummaryBaseStyle = _recordSummaryBaseStyle

    def RecordSummaryBaseStyle_=(value: CSSStyleName) {
        if (_recordSummaryBaseStyle == value) return
        json("recordSummaryBaseStyle") = value
        _recordSummaryBaseStyle = value
    }

    private[this] var _removedCSSText: String = removedCSSText

    def RemovedCSSText = _removedCSSText

    def RemovedCSSText_=(value: String) {
        if (_removedCSSText == value) return
        json("removedCSSText") = value
        _removedCSSText = value
    }

    private[this] var _removeFieldDefaults: ListGridFieldDyn = removeFieldDefaults

    def RemoveFieldDefaults = _removeFieldDefaults

    def RemoveFieldDefaults_=(value: ListGridFieldDyn) {
        if (_removeFieldDefaults == value) return
        json("removeFieldDefaults") = value
        _removeFieldDefaults = value
    }

    private[this] var _removeFieldProperties: ListGridFieldDyn = removeFieldProperties

    def RemoveFieldProperties = _removeFieldProperties

    def RemoveFieldProperties_=(value: ListGridFieldDyn) {
        if (_removeFieldProperties == value) return
        json("removeFieldProperties") = value
        _removeFieldProperties = value
    }

    private[this] var _removeFieldTitle: String = removeFieldTitle

    def RemoveFieldTitle = _removeFieldTitle

    def RemoveFieldTitle_=(value: String) {
        if (_removeFieldTitle == value) return
        json("removeFieldTitle") = value
        _removeFieldTitle = value
    }

    private[this] var _removeIcon: SCImgURL = removeIcon

    def RemoveIcon = _removeIcon

    def RemoveIcon_=(value: SCImgURL) {
        if (_removeIcon == value) return
        json("removeIcon") = value
        _removeIcon = value
    }

    private[this] var _removeIconSize: Number = removeIconSize

    def RemoveIconSize = _removeIconSize

    def RemoveIconSize_=(value: Number) {
        if (_removeIconSize == value) return
        json("removeIconSize") = value
        _removeIconSize = value
    }

    private[this] var _resizeFieldsInRealTime: FunctionExpression = resizeFieldsInRealTime

    def ResizeFieldsInRealTime = _resizeFieldsInRealTime

    def ResizeFieldsInRealTime_=(value: FunctionExpression) {
        if (_resizeFieldsInRealTime == value) return
        json("resizeFieldsInRealTime") = value
        _resizeFieldsInRealTime = value
    }

    private[this] var _rollOverCanvas: AutoChild = rollOverCanvas

    def RollOverCanvas = _rollOverCanvas

    def RollOverCanvas_=(value: AutoChild) {
        if (_rollOverCanvas == value) return
        json("rollOverCanvas") = value
        _rollOverCanvas = value
    }

    private[this] var _rollUnderCanvas: AutoChild = rollUnderCanvas

    def RollUnderCanvas = _rollUnderCanvas

    def RollUnderCanvas_=(value: AutoChild) {
        if (_rollUnderCanvas == value) return
        json("rollUnderCanvas") = value
        _rollUnderCanvas = value
    }

    private[this] var _rowEndEditAction: RowEndEditAction = rowEndEditAction
    def RowEndEditAction = _rowEndEditAction
    def RowEndEditAction_=(value: RowEndEditAction) {
        if (_rowEndEditAction == value) return
        json("rowEndEditAction") = value
        _rowEndEditAction = value
    }

    private[this] var _rowNumberField: ListGridFieldDyn = rowNumberField

    def RowNumberField = _rowNumberField

    def RowNumberField_=(value: ListGridFieldDyn) {
        json("rowNumberField") = value
        _rowNumberField = value
    }

    private[this] var _rowNumberStart: Number = rowNumberStart

    def RowNumberStart = _rowNumberStart

    def RowNumberStart_=(value: Number) {
        if (_rowNumberStart == value) return
        json("rowNumberStart") = value
        _rowNumberStart = value
    }

    private[this] var _rowNumberStyle: CSSStyleName = rowNumberStyle

    def RowNumberStyle = _rowNumberStyle

    def RowNumberStyle_=(value: CSSStyleName) {
        if (_rowNumberStyle == value) return
        json("rowNumberStyle") = value
        _rowNumberStyle = value
    }

    private[this] var _saveByCell: Bool = saveByCell

    def SaveByCell = _saveByCell

    def SaveByCell_=(value: Bool) {
        if (_saveByCell == value) return
        json("saveByCell") = value
        _saveByCell = value
    }

    private[this] var _saveLocally: Bool = saveLocally

    def SaveLocally = _saveLocally

    def SaveLocally_=(value: Bool) {
        if (_saveLocally == value) return
        json("saveLocally") = value
        _saveLocally = value
    }

    private[this] var _saveRequestProperties: DSRequestDyn = saveRequestProperties

    def SaveRequestProperties = _saveRequestProperties

    def SaveRequestProperties_=(value: DSRequestDyn) {
        if (_saveRequestProperties == value) return
        json("saveRequestProperties") = value
        _saveRequestProperties = value
    }

    private[this] var _scrollRedrawDelay: Number = scrollRedrawDelay

    def ScrollRedrawDelay = _scrollRedrawDelay

    def ScrollRedrawDelay_=(value: Number) {
        if (_scrollRedrawDelay == value) return
        json("scrollRedrawDelay") = value
        _scrollRedrawDelay = value
    }

    private[this] var _selection: com.simplesys.isc.system.SelectionDyn = null

    def Selection = _selection

    def Selection_=(value: com.simplesys.isc.system.SelectionDyn) {
        if (_selection == value) return
        json("selection") = value
        _selection = value
    }

    def SelectionAppearance = json.getValue2[JsonString, SelectionAppearance]("selectionAppearance").getOrElse(selectionAppearance)
    def SelectionAppearance_=(value: SelectionAppearance) {
        if (SelectionAppearance == value) return
        json("selectionAppearance") = value
    }

    private[this] var _selectionCanvas: AutoChild = selectionCanvas
    def SelectionCanvas = _selectionCanvas
    def SelectionCanvas_=(value: AutoChild) {
        if (_selectionCanvas == value) return
        json("selectionCanvas") = value
        _selectionCanvas = value
    }

    def SelectionChanged = json.getFunctionExpressionOpt("selectionChanged").getOrElse(selectionChanged)

    def SelectionChanged_=(value: FunctionExpression) {
        if (SelectionChanged == value) return
        json("selectionChanged") = value
    }

    private[this] var _selectionProperty: String = selectionProperty

    def SelectionProperty = _selectionProperty

    def SelectionProperty_=(value: String) {
        if (_selectionProperty == value) return
        json("selectionProperty") = value
        _selectionProperty = value
    }

    private[this] var _selectionType: SelectionStyle = selectionType
    def SelectionType = _selectionType
    def SelectionType_=(value: SelectionStyle) {
        if (_selectionType == value) return
        json("selectionType") = value
        _selectionType = value
    }

    private[this] var _selectionUnderCanvas: AutoChild = selectionUnderCanvas

    def SelectionUnderCanvas = _selectionUnderCanvas

    def SelectionUnderCanvas_=(value: AutoChild) {
        if (_selectionUnderCanvas == value) return
        json("selectionUnderCanvas") = value
        _selectionUnderCanvas = value
    }

    private[this] var _selectOnEdit: Bool = selectOnEdit

    def SelectOnEdit = _selectOnEdit

    def SelectOnEdit_=(value: Bool) {
        if (_selectOnEdit == value) return
        json("selectOnEdit") = value
        _selectOnEdit = value
    }

    def SelectRecord = json.getFunctionExpressionOpt("selectRecord").getOrElse(selectRecord)

    def SelectRecord_=(value: FunctionExpression) {
        if (SelectRecord == value) return
        json("selectRecord") = value
    }

    private[this] var _showAllColumns: Bool = showAllColumns

    def ShowAllColumns = _showAllColumns

    def ShowAllColumns_=(value: Bool) {
        if (_showAllColumns == value) return
        json("showAllColumns") = value
        _showAllColumns = value
    }

    private[this] var _showAllRecords: Bool = showAllRecords

    def ShowAllRecords = _showAllRecords

    def ShowAllRecords_=(value: Bool) {
        if (_showAllRecords == value) return
        json("showAllRecords") = value
        _showAllRecords = value
    }

    private[this] var _showBackgroundComponent: Bool = showBackgroundComponent

    def ShowBackgroundComponent = _showBackgroundComponent

    def ShowBackgroundComponent_=(value: Bool) {
        if (_showBackgroundComponent == value) return
        json("showBackgroundComponent") = value
        _showBackgroundComponent = value
    }

    private[this] var _showCellContextMenus: Bool = showCellContextMenus

    def ShowCellContextMenus = _showCellContextMenus

    def ShowCellContextMenus_=(value: Bool) {
        if (_showCellContextMenus == value) return
        json("showCellContextMenus") = value
        _showCellContextMenus = value
    }

    private[this] var _showEmptyMessage: Bool = showEmptyMessage

    def ShowEmptyMessage = _showEmptyMessage

    def ShowEmptyMessage_=(value: Bool) {
        if (_showEmptyMessage == value) return
        json("showEmptyMessage") = value
        _showEmptyMessage = value
    }

    private[this] var _showFilterEditor: Bool = showFilterEditor
    def ShowFilterEditor = _showFilterEditor
    def ShowFilterEditor_=(value: Bool) {
        if (_showFilterEditor == value) return
        json("showFilterEditor") = value
        _showFilterEditor = value
    }

    private[this] var _showGridSummary: Bool = showGridSummary

    def ShowGridSummary = _showGridSummary

    def ShowGridSummary_=(value: Bool) {
        if (_showGridSummary == value) return
        json("showGridSummary") = value
        _showGridSummary = value
    }

    private[this] var _showGroupSummary: Bool = showGroupSummary

    def ShowGroupSummary = _showGroupSummary

    def ShowGroupSummary_=(value: Bool) {
        if (_showGroupSummary == value) return
        json("showGroupSummary") = value
        _showGroupSummary = value
    }

    private[this] var _showGroupSummaryInHeader: Bool = showGroupSummaryInHeader

    def ShowGroupSummaryInHeader = _showGroupSummaryInHeader

    def ShowGroupSummaryInHeader_=(value: Bool) {
        if (_showGroupSummaryInHeader == value) return
        json("showGroupSummaryInHeader") = value
        _showGroupSummaryInHeader = value
    }

    private[this] var _showGroupTitleColumn: Bool = showGroupTitleColumn

    def ShowGroupTitleColumn = _showGroupTitleColumn

    def ShowGroupTitleColumn_=(value: Bool) {
        if (_showGroupTitleColumn == value) return
        json("showGroupTitleColumn") = value
        _showGroupTitleColumn = value
    }

    private[this] var _showHeader: Bool = showHeader

    def ShowHeader = _showHeader

    def ShowHeader_=(value: Bool) {
        if (_showHeader == value) return
        json("showHeader") = value
        _showHeader = value
    }

    private[this] var _showHeaderContextMenu: Bool = showHeaderContextMenu

    def ShowHeaderContextMenu = _showHeaderContextMenu

    def ShowHeaderContextMenu_=(value: Bool) {
        if (_showHeaderContextMenu == value) return
        json("showHeaderContextMenu") = value
        _showHeaderContextMenu = value
    }

    private[this] var _showHeaderMenuButton: Bool = showHeaderMenuButton

    def ShowHeaderMenuButton = _showHeaderMenuButton

    def ShowHeaderMenuButton_=(value: Bool) {
        if (_showHeaderMenuButton == value) return
        json("showHeaderMenuButton") = value
        _showHeaderMenuButton = value
    }

    private[this] var _showRecordComponents: Bool = showRecordComponents
    def ShowRecordComponents = _showRecordComponents
    def ShowRecordComponents_=(value: Bool) {
        if (_showRecordComponents == value) return
        json("showRecordComponents") = value
        _showRecordComponents = value
    }

    private[this] var _showRecordComponentsByCell: Bool = showRecordComponentsByCell
    def ShowRecordComponentsByCell = _showRecordComponentsByCell
    def ShowRecordComponentsByCell_=(value: Bool) {
        if (_showRecordComponentsByCell == value) return
        json("showRecordComponentsByCell") = value
        _showRecordComponentsByCell = value
    }

    private[this] var _showRollOver: Bool = showRollOver
    def ShowRollOver = _showRollOver
    def ShowRollOver_=(value: Bool) {
        if (_showRollOver == value) return
        json("showRollOver") = value
        _showRollOver = value
    }

    private[this] var _showRollOverCanvas: Bool = showRollOverCanvas

    def ShowRollOverCanvas = _showRollOverCanvas

    def ShowRollOverCanvas_=(value: Bool) {
        if (_showRollOverCanvas == value) return
        json("showRollOverCanvas") = value
        _showRollOverCanvas = value
    }

    private[this] var _showRowNumbers: Bool = showRowNumbers

    def ShowRowNumbers = _showRowNumbers
    def ShowRowNumbers_=(value: Bool) {
        if (_showRowNumbers == value) return
        json("showRowNumbers") = value
        _showRowNumbers = value
    }

    def ShowSelectedStyle = json.getJsonElement("showSelectedStyle").getOrElse(showSelectedStyle)
    def ShowSelectedStyle_=(value: JsonElement) {
        if (ShowSelectedStyle == value) return
        json("showSelectedStyle") = value
    }

    private[this] var _showSelectionCanvas: Bool = showSelectionCanvas

    def ShowSelectionCanvas = _showSelectionCanvas

    def ShowSelectionCanvas_=(value: Bool) {
        if (_showSelectionCanvas == value) return
        json("showSelectionCanvas") = value
        _showSelectionCanvas = value
    }

    private[this] var _showSortArrow: SortArrow = showSortArrow
    def ShowSortArrow = _showSortArrow
    def ShowSortArrow_=(value: SortArrow) {
        if (_showSortArrow == value) return
        json("showSortArrow") = value
        _showSortArrow = value
    }

    private[this] var _showSortNumerals: Bool = showSortNumerals

    def ShowSortNumerals = _showSortNumerals

    def ShowSortNumerals_=(value: Bool) {
        if (_showSortNumerals == value) return
        json("showSortNumerals") = value
        _showSortNumerals = value
    }

    private[this] var _showTreeColumnPicker: Bool = showTreeColumnPicker

    def ShowTreeColumnPicker = _showTreeColumnPicker

    def ShowTreeColumnPicker_=(value: Bool) {
        if (_showTreeColumnPicker == value) return
        json("showTreeColumnPicker") = value
        _showTreeColumnPicker = value
    }

    private[this] var _shrinkForFreeze: Bool = shrinkForFreeze

    def ShrinkForFreeze = _shrinkForFreeze

    def ShrinkForFreeze_=(value: Bool) {
        if (_shrinkForFreeze == value) return
        json("shrinkForFreeze") = value
        _shrinkForFreeze = value
    }

    private[this] var _singleCellValueProperty: String = singleCellValueProperty

    def SingleCellValueProperty = _singleCellValueProperty

    def SingleCellValueProperty_=(value: String) {
        if (_singleCellValueProperty == value) return
        json("singleCellValueProperty") = value
        _singleCellValueProperty = value
    }

    private[this] var _sortAscendingImage: ImgPropertiesDyn = sortAscendingImage

    def SortAscendingImage = _sortAscendingImage

    def SortAscendingImage_=(value: ImgPropertiesDyn) {
        if (_sortAscendingImage == value) return
        json("sortAscendingImage") = value
        _sortAscendingImage = value
    }

    private[this] var _sortDescendingImage: ImgPropertiesDyn = sortDescendingImage

    def SortDescendingImage = _sortDescendingImage

    def SortDescendingImage_=(value: ImgPropertiesDyn) {
        if (_sortDescendingImage == value) return
        json("sortDescendingImage") = value
        _sortDescendingImage = value
    }

    private[this] var _sortDirection: SortDirection = sortDirection

    def SortDirection = _sortDirection

    def SortDirection_=(value: SortDirection) {
        if (_sortDirection == value) return
        json("sortDirection") = value
        _sortDirection = value
    }

    private[this] var _sorterConstructor: SCClassName = sorterConstructor

    def SorterConstructor = _sorterConstructor

    def SorterConstructor_=(value: SCClassName) {
        if (_sorterConstructor == value) return
        json("sorterConstructor") = value
        _sorterConstructor = value
    }

    private[this] var _sorterDefaults: JsonObject = sorterDefaults

    def SorterDefaults = _sorterDefaults

    def SorterDefaults_=(value: JsonObject) {
        json("sorterDefaults") = value
        _sorterDefaults = value
    }

    private[this] var _sorterProperties: ButtonDyn = sorterProperties

    def SorterProperties = _sorterProperties

    def SorterProperties_=(value: ButtonDyn) {
        if (_sorterProperties == value) return
        json("sorterProperties") = value
        _sorterProperties = value
    }

    private[this] var _sortField: Number = sortField

    def SortField = _sortField

    def SortField_=(value: Number) {
        if (_sortField == value) return
        json("sortField") = value
        _sortField = value
    }

    private[this] var _sortFieldAscendingText: String = sortFieldAscendingText

    def SortFieldAscendingText = _sortFieldAscendingText

    def SortFieldAscendingText_=(value: String) {
        if (_sortFieldAscendingText == value) return
        json("sortFieldAscendingText") = value
        _sortFieldAscendingText = value
    }

    private[this] var _sortFieldDescendingText: String = sortFieldDescendingText

    def SortFieldDescendingText = _sortFieldDescendingText

    def SortFieldDescendingText_=(value: String) {
        if (_sortFieldDescendingText == value) return
        json("sortFieldDescendingText") = value
        _sortFieldDescendingText = value
    }

    private[this] var _sortFieldNum: Number = sortFieldNum

    def SortFieldNum = _sortFieldNum

    def SortFieldNum_=(value: Number) {
        if (_sortFieldNum == value) return
        json("sortFieldNum") = value
        _sortFieldNum = value
    }

    private[this] var _sortNumeralStyle: CSSStyleName = sortNumeralStyle

    def SortNumeralStyle = _sortNumeralStyle

    def SortNumeralStyle_=(value: CSSStyleName) {
        if (_sortNumeralStyle == value) return
        json("sortNumeralStyle") = value
        _sortNumeralStyle = value
    }

    private[this] var _stopOnErrors: Bool = stopOnErrors

    def StopOnErrors = _stopOnErrors

    def StopOnErrors_=(value: Bool) {
        if (_stopOnErrors == value) return
        json("stopOnErrors") = value
        _stopOnErrors = value
    }

    private[this] var _summaryRow: AutoChild = summaryRow

    def SummaryRow = _summaryRow

    def SummaryRow_=(value: AutoChild) {
        if (_summaryRow == value) return
        json("summaryRow") = value
        _summaryRow = value
    }

    private[this] var _summaryRowCriteria: CriteriaDyn = summaryRowCriteria

    def SummaryRowCriteria = _summaryRowCriteria

    def SummaryRowCriteria_=(value: CriteriaDyn) {
        if (_summaryRowCriteria == value) return
        json("summaryRowCriteria") = value
        _summaryRowCriteria = value
    }

    private[this] var _summaryRowDataSource: com.simplesys.isc.dataBinging.DataSourceDyn = null

    def SummaryRowDataSource = _summaryRowDataSource

    def SummaryRowDataSource_=(value: com.simplesys.isc.dataBinging.DataSourceDyn) {
        if (_summaryRowDataSource == value) return
        json("summaryRowDataSource") = value
        _summaryRowDataSource = value
    }

    private[this] var _summaryRowFetchRequestProperties: DSRequestDyn = summaryRowFetchRequestProperties

    def SummaryRowFetchRequestProperties = _summaryRowFetchRequestProperties

    def SummaryRowFetchRequestProperties_=(value: DSRequestDyn) {
        if (_summaryRowFetchRequestProperties == value) return
        json("summaryRowFetchRequestProperties") = value
        _summaryRowFetchRequestProperties = value
    }

    private[this] var _summaryRowHeight: Number = summaryRowHeight

    def SummaryRowHeight = _summaryRowHeight

    def SummaryRowHeight_=(value: Number) {
        if (_summaryRowHeight == value) return
        json("summaryRowHeight") = value
        _summaryRowHeight = value
    }

    private[this] var _summaryRowStyle: CSSStyleName = summaryRowStyle

    def SummaryRowStyle = _summaryRowStyle

    def SummaryRowStyle_=(value: CSSStyleName) {
        if (_summaryRowStyle == value) return
        json("summaryRowStyle") = value
        _summaryRowStyle = value
    }

    private[this] var _tallBaseStyle: CSSStyleName = tallBaseStyle

    def TallBaseStyle = _tallBaseStyle

    def TallBaseStyle_=(value: CSSStyleName) {
        if (_tallBaseStyle == value) return
        json("tallBaseStyle") = value
        _tallBaseStyle = value
    }

    private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter

    def TimeFormatter = _timeFormatter

    def TimeFormatter_=(value: TimeDisplayFormat) {
        if (_timeFormatter == value) return
        json("timeFormatter") = value
        _timeFormatter = value
    }

    private[this] var _trackerImage: ImgPropertiesDyn = trackerImage

    def TrackerImage = _trackerImage

    def TrackerImage_=(value: ImgPropertiesDyn) {
        if (_trackerImage == value) return
        json("trackerImage") = ImgPropertiesDyn ImgPropertiestoJsonObject value
        _trackerImage = value
    }

    private[this] var _unfreezeFieldText: String = unfreezeFieldText

    def UnfreezeFieldText = _unfreezeFieldText

    def UnfreezeFieldText_=(value: String) {
        if (_unfreezeFieldText == value) return
        json("unfreezeFieldText") = value
        _unfreezeFieldText = value
    }

    private[this] var _ungroupText: String = ungroupText

    def UngroupText = _ungroupText

    def UngroupText_=(value: String) {
        if (_ungroupText == value) return
        json("ungroupText") = value
        _ungroupText = value
    }

    private[this] var _unremoveIcon: SCImgURL = unremoveIcon

    def UnremoveIcon = _unremoveIcon

    def UnremoveIcon_=(value: SCImgURL) {
        if (_unremoveIcon == value) return
        json("unremoveIcon") = value
        _unremoveIcon = value
    }

    private[this] var _unspannedHeaderVAlign: AlignmentDyn = unspannedHeaderVAlign

    def UnspannedHeaderVAlign = _unspannedHeaderVAlign

    def UnspannedHeaderVAlign_=(value: AlignmentDyn) {
        if (_unspannedHeaderVAlign == value) return
        json("unspannedHeaderVAlign") = value
        _unspannedHeaderVAlign = value
    }

    def UpdateRecordComponent = json.getValue2[JsonString, FunctionExpression]("updateRecordComponent").getOrElse(updateRecordComponent)
    def UpdateRecordComponent_=(value: FunctionExpression) {
        if (UpdateRecordComponent == value) return
        json("updateRecordComponent") = value
    }

    def UpdateData = json.getFunctionExpressionOpt("updateData").getOrElse(updateData)
    def UpdateData_=(value: FunctionExpression) {
        if (UpdateData == value) return
        json("updateData") = value
    }

    private[this] var _useCellRollOvers: Bool = useCellRollOvers
    def UseCellRollOvers = _useCellRollOvers
    def UseCellRollOvers_=(value: Bool) {
        if (_useCellRollOvers == value) return
        json("useCellRollOvers") = value
        _useCellRollOvers = value
    }

    private[this] var _useRemoteValidators: Bool = useRemoteValidators

    def UseRemoteValidators = _useRemoteValidators

    def UseRemoteValidators_=(value: Bool) {
        if (_useRemoteValidators == value) return
        json("useRemoteValidators") = value
        _useRemoteValidators = value
    }

    private[this] var _validateByCell: Bool = validateByCell

    def ValidateByCell = _validateByCell

    def ValidateByCell_=(value: Bool) {
        if (_validateByCell == value) return
        json("validateByCell") = value
        _validateByCell = value
    }

    private[this] var _validateOnChange: Bool = validateOnChange

    def ValidateOnChange = _validateOnChange

    def ValidateOnChange_=(value: Bool) {
        if (_validateOnChange == value) return
        json("validateOnChange") = value
        _validateOnChange = value
    }

    private[this] var _valueIconHeight: Number = valueIconHeight

    def ValueIconHeight = _valueIconHeight

    def ValueIconHeight_=(value: Number) {
        if (_valueIconHeight == value) return
        json("valueIconHeight") = value
        _valueIconHeight = value
    }

    private[this] var _valueIconLeftPadding: Number = valueIconLeftPadding

    def ValueIconLeftPadding = _valueIconLeftPadding

    def ValueIconLeftPadding_=(value: Number) {
        if (_valueIconLeftPadding == value) return
        json("valueIconLeftPadding") = value
        _valueIconLeftPadding = value
    }

    private[this] var _valueIconRightPadding: Number = valueIconRightPadding

    def ValueIconRightPadding = _valueIconRightPadding

    def ValueIconRightPadding_=(value: Number) {
        if (_valueIconRightPadding == value) return
        json("valueIconRightPadding") = value
        _valueIconRightPadding = value
    }

    private[this] var _valueIconSize: Number = valueIconSize

    def ValueIconSize = _valueIconSize

    def ValueIconSize_=(value: Number) {
        if (_valueIconSize == value) return
        json("valueIconSize") = value
        _valueIconSize = value
    }

    private[this] var _valueIconWidth: Number = valueIconWidth

    def ValueIconWidth = _valueIconWidth

    def ValueIconWidth_=(value: Number) {
        if (_valueIconWidth == value) return
        json("valueIconWidth") = value
        _valueIconWidth = value
    }

    private[this] var _virtualScrolling: Bool = virtualScrolling

    def VirtualScrolling = _virtualScrolling

    def VirtualScrolling_=(value: Bool) {
        if (_virtualScrolling == value) return
        json("virtualScrolling") = value
        _virtualScrolling = value
    }

    private[this] var _waitForSave: Bool = waitForSave

    def WaitForSave = _waitForSave

    def WaitForSave_=(value: Bool) {
        if (_waitForSave == value) return
        json("waitForSave") = value
        _waitForSave = value
    }

    private[this] var _warnOnRemoval: Bool = warnOnRemoval

    def WarnOnRemoval = _warnOnRemoval

    def WarnOnRemoval_=(value: Bool) {
        if (_warnOnRemoval == value) return
        json("warnOnRemoval") = value
        _warnOnRemoval = value
    }

    private[this] var _warnOnRemovalMessage: String = warnOnRemovalMessage

    def WarnOnRemovalMessage = _warnOnRemovalMessage

    def WarnOnRemovalMessage_=(value: String) {
        if (_warnOnRemovalMessage == value) return
        json("warnOnRemovalMessage") = value
        _warnOnRemovalMessage = value
    }

    private[this] var _warnOnUnmappedValueFieldChange: Bool = warnOnUnmappedValueFieldChange
    def WarnOnUnmappedValueFieldChange = _warnOnUnmappedValueFieldChange
    def WarnOnUnmappedValueFieldChange_=(value: Bool) {
        if (_warnOnUnmappedValueFieldChange == value) return
        json("warnOnUnmappedValueFieldChange") = value
        _warnOnUnmappedValueFieldChange = value
    }

    private[this] var _wrapCells: Bool = wrapCells
    def WrapCells = _wrapCells
    def WrapCells_=(value: Bool) {
        if (_wrapCells == value) return
        json("wrapCells") = value
        _wrapCells = value
    }


    def ExpansionDetailFieldProperties = json.getMultiAutoChildOpt("expansionDetailFieldProperties")
    def ExpansionDetailFieldProperties_=(value: MultiAutoChild) {
        //if (ExpansionDetailFieldProperties === value) return
        json("expansionDetailFieldProperties") = value
    }

    def CanSelectTextExpandedField = json.getBoolOpt("canSelectTextExpandedField").getOrElse(canSelectTextExpandedField)
    def CanSelectTextExpandedField_=(value: Bool) {
        if (CanSelectTextExpandedField == value) return
        ExpansionDetailFieldProperties match {
            case None =>
                val json = MultiAutoChild()
                json("canSelectText") = value
                ExpansionDetailFieldProperties = json
            case Some(json) =>
                json("canSelectText") = value
        }
    }

    def GetExpansionComponent = json.getFunctionExpressionOpt("getExpansionComponent").getOrElse(getExpansionComponent)
    def GetExpansionComponent_=(value: FunctionExpression) {
        if (GetExpansionComponent == value) return
        json("getExpansionComponent") = value
    }

    def GetBaseStyle = json.getFunctionExpressionOpt("getBaseStyle").getOrElse(getBaseStyle)
    def GetBaseStyle_=(value: FunctionExpression) {
        if (GetBaseStyle == value) return
        json("getBaseStyle") = value
    }

    def CollapseRecord = json.getFunctionExpressionOpt("collapseRecord").getOrElse(collapseRecord)
    def CollapseRecord_=(value: FunctionExpression) {
        if (CollapseRecord == value) return
        json("collapseRecord") = value
    }

    def FocusChanged = json.getFunctionExpressionOpt("focusChanged").getOrElse(focusChanged)
    def FocusChanged_=(value: FunctionExpression) {
        if (FocusChanged == value) return
        json("focusChanged") = value
    }

    def ClientOnly = json.getJsonElement("clientOnly").getOrElse(clientOnly)
    def ClientOnly_=(value: JsonElement) {
        if (ClientOnly == value) return
        json("clientOnly") = value
    }

    def CellClick = json.getFunctionExpressionOpt("cellClick").getOrElse(cellClick)
    def CellClick_=(value: FunctionExpression) {
        if (CellClick == value) return
        json("cellClick") = value
    }

    def MasterGrid = json.getJsonElement("masterGrid").getOrElse(masterGrid)
    def MasterGrid_=(value: JsonElement) {
        if (MasterGrid == value) return
        json("masterGrid") = value
    }

    def RowClick = json.getJsonElement("rowClick").getOrElse(rowClick)
    def RowClick_=(value: JsonElement) {
        if (RowClick == value) return
        json("rowClick") = value
    }

    def RowContextClick = json.getJsonElement("rowContextClick").getOrElse(rowContextClick)
    def RowContextClick_=(value: JsonElement) {
        if (RowContextClick == value) return
        json("rowContextClick") = value
    }
}

