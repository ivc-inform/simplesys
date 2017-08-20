package com.simplesys.isc.dataBinging

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.HiliteDyn
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.CSSStyleName


trait DataBoundComponentDyn extends DataBoundComponentDynInit {
    iscClass: ClassDyn =>

    private[this] var _addDropValues: Bool = addDropValues
    def AddDropValues = _addDropValues
    def AddDropValues_=(value: Bool) {
        if (_addDropValues == value) return
        json("addDropValues") = value
        _addDropValues = value
    }

    private[this] var _addFormulaFieldText: String = addFormulaFieldText
    def AddFormulaFieldText = _addFormulaFieldText
    def AddFormulaFieldText_=(value: String) {
        if (_addFormulaFieldText == value) return
        json("addFormulaFieldText") = value
        _addFormulaFieldText = value
    }

    private[this] var _addOperation: String = addOperation
    def AddOperation = _addOperation
    def AddOperation_=(value: String) {
        if (_addOperation == value) return
        json("addOperation") = value
        _addOperation = value
    }

    private[this] var _addSummaryFieldText: String = addSummaryFieldText
    def AddSummaryFieldText = _addSummaryFieldText
    def AddSummaryFieldText_=(value: String) {
        if (_addSummaryFieldText == value) return
        json("addSummaryFieldText") = value
        _addSummaryFieldText = value
    }

    private[this] var _autoTrackSelection: Bool = autoTrackSelection
    def AutoTrackSelection = _autoTrackSelection
    def AutoTrackSelection_=(value: Bool) {
        if (_autoTrackSelection == value) return
        json("autoTrackSelection") = value
        _autoTrackSelection = value
    }

    private[this] var _badFormulaResultValue: String = badFormulaResultValue
    def BadFormulaResultValue = _badFormulaResultValue
    def BadFormulaResultValue_=(value: String) {
        if (_badFormulaResultValue == value) return
        json("badFormulaResultValue") = value
        _badFormulaResultValue = value
    }

    private[this] var _canAddFormulaFields: Bool = canAddFormulaFields
    def CanAddFormulaFields = _canAddFormulaFields
    def CanAddFormulaFields_=(value: Bool) {
        if (_canAddFormulaFields == value) return
        json("canAddFormulaFields") = value
        _canAddFormulaFields = value
    }

    private[this] var _canAddSummaryFields: Bool = canAddSummaryFields
    def CanAddSummaryFields = _canAddSummaryFields
    def CanAddSummaryFields_=(value: Bool) {
        if (_canAddSummaryFields == value) return
        json("canAddSummaryFields") = value
        _canAddSummaryFields = value
    }

    private[this] var _canEditFieldAttribute: String = canEditFieldAttribute
    def CanEditFieldAttribute = _canEditFieldAttribute
    def CanEditFieldAttribute_=(value: String) {
        if (_canEditFieldAttribute == value) return
        json("canEditFieldAttribute") = value
        _canEditFieldAttribute = value
    }

    private[this] var _dataArity: String = dataArity
    def DataArity = _dataArity
    def DataArity_=(value: String) {
        if (_dataArity == value) return
        json("dataArity") = value
        _dataArity = value
    }

    def DataFetchMode = json.getValue2[JsonString, FetchMode]("dataFetchMode").getOrElse(dataFetchMode)
    def DataFetchMode_=(value: FetchMode) {
        if (DataFetchMode == value) return
        json("dataFetchMode") = value
    }

    private[this] var _dataField: String = dataField
    def DataField = _dataField
    def DataField_=(value: String) {
        if (_dataField == value) return
        json("dataField") = value
        _dataField = value
    }

    def DataPageSize = json.getJsonElement("dataPageSize").getOrElse(dataPageSize)
    def DataPageSize_=(value: JsonElement) {
        if (DataPageSize == value) return
        json("dataPageSize") = value
    }

    def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
    def DataSource_=(value: JsonElement) {
        if (DataSource == value) return
        json("dataSource") = value
    }

    private[this] var _descriptionField: String = descriptionField
    def DescriptionField = _descriptionField
    def DescriptionField_=(value: String) {
        if (_descriptionField == value) return
        json("descriptionField") = value
        _descriptionField = value
    }

    private[this] var _dragDataAction: DragDataAction = dragDataAction
    def DragDataAction = _dragDataAction
    def DragDataAction_=(value: DragDataAction) {
        if (_dragDataAction == value) return
        json("dragDataAction") = value
        _dragDataAction = value
    }

    private[this] var _dragTrackerStyle: CSSStyleName = dragTrackerStyle
    def DragTrackerStyle = _dragTrackerStyle
    def DragTrackerStyle_=(value: CSSStyleName) {
        if (_dragTrackerStyle == value) return
        json("dragTrackerStyle") = value
        _dragTrackerStyle = value
    }

    private[this] var _dropValues: JsonObject = dropValues
    def DropValues = _dropValues
    def DropValues_=(value: JsonObject) {
        if (_dropValues == value) return
        json("dropValues") = value
        _dropValues = value
    }

    private[this] var _duplicateDragMessage: String = duplicateDragMessage
    def DuplicateDragMessage = _duplicateDragMessage
    def DuplicateDragMessage_=(value: String) {
        if (_duplicateDragMessage == value) return
        json("duplicateDragMessage") = value
        _duplicateDragMessage = value
    }

    private[this] var _editFormulaFieldText: String = editFormulaFieldText
    def EditFormulaFieldText = _editFormulaFieldText
    def EditFormulaFieldText_=(value: String) {
        if (_editFormulaFieldText == value) return
        json("editFormulaFieldText") = value
        _editFormulaFieldText = value
    }

    private[this] var _editSummaryFieldText: String = editSummaryFieldText
    def EditSummaryFieldText = _editSummaryFieldText
    def EditSummaryFieldText_=(value: String) {
        if (_editSummaryFieldText == value) return
        json("editSummaryFieldText") = value
        _editSummaryFieldText = value
    }

    private[this] var _emptyExportMessage: String = emptyExportMessage
    def EmptyExportMessage = _emptyExportMessage
    def EmptyExportMessage_=(value: String) {
        if (_emptyExportMessage == value) return
        json("emptyExportMessage") = value
        _emptyExportMessage = value
    }

    private[this] var _exportAll: Bool = exportAll
    def ExportAll = _exportAll
    def ExportAll_=(value: Bool) {
        if (_exportAll == value) return
        json("exportAll") = value
        _exportAll = value
    }

    private[this] var _exportFields: JsonList = exportFields
    def ExportFields = _exportFields
    def ExportFields_=(value: JsonList) {
        if (_exportFields == value) return
        json("exportFields") = value
        _exportFields = value
    }

    private[this] var _exportIncludeSummaries: Bool = exportIncludeSummaries
    def ExportIncludeSummaries = _exportIncludeSummaries
    def ExportIncludeSummaries_=(value: Bool) {
        if (_exportIncludeSummaries == value) return
        json("exportIncludeSummaries") = value
        _exportIncludeSummaries = value
    }

    private[this] var _fetchOperation: String = fetchOperation
    def FetchOperation = _fetchOperation
    def FetchOperation_=(value: String) {
        if (_fetchOperation == value) return
        json("fetchOperation") = value
        _fetchOperation = value
    }

    def Fields = json.getJsonElement("fields").getOrElse(fields)
    def Fields_=(value: JsonElement) {
        if (Fields == value) return
        json("fields") = value
    }

    private[this] var _hiliteProperty: String = hiliteProperty
    def HiliteProperty = _hiliteProperty
    def HiliteProperty_=(value: String) {
        if (_hiliteProperty == value) return
        json("hiliteProperty") = value
        _hiliteProperty = value
    }

    private[this] var _hilites: ArrayDyn[HiliteDyn] = hilites
    def Hilites = _hilites
    def Hilites_=(value: ArrayDyn[HiliteDyn]) {
        if (_hilites == value) return
        json("hilites") = value
        _hilites = value
    }

    private[this] var _iconField: String = iconField
    def IconField = _iconField
    def IconField_=(value: String) {
        if (_iconField == value) return
        json("iconField") = value
        _iconField = value
    }

    private[this] var _infoField: String = infoField
    def InfoField = _infoField
    def InfoField_=(value: String) {
        if (_infoField == value) return
        json("infoField") = value
        _infoField = value
    }

    private[this] var _missingSummaryFieldValue: String = missingSummaryFieldValue
    def MissingSummaryFieldValue = _missingSummaryFieldValue
    def MissingSummaryFieldValue_=(value: String) {
        if (_missingSummaryFieldValue == value) return
        json("missingSummaryFieldValue") = value
        _missingSummaryFieldValue = value
    }

    private[this] var _offlineMessage: String = offlineMessage
    def OfflineMessage = _offlineMessage
    def OfflineMessage_=(value: String) {
        if (_offlineMessage == value) return
        json("offlineMessage") = value
        _offlineMessage = value
    }

    private[this] var _offlineSaveMessage: String = offlineSaveMessage
    def OfflineSaveMessage = _offlineSaveMessage
    def OfflineSaveMessage_=(value: String) {
        if (_offlineSaveMessage == value) return
        json("offlineSaveMessage") = value
        _offlineSaveMessage = value
    }

    private[this] var _preventDuplicates: Bool = preventDuplicates
    def PreventDuplicates = _preventDuplicates
    def PreventDuplicates_=(value: Bool) {
        if (_preventDuplicates == value) return
        json("preventDuplicates") = value
        _preventDuplicates = value
    }

    private[this] var _removeFormulaFieldText: String = removeFormulaFieldText
    def RemoveFormulaFieldText = _removeFormulaFieldText
    def RemoveFormulaFieldText_=(value: String) {
        if (_removeFormulaFieldText == value) return
        json("removeFormulaFieldText") = value
        _removeFormulaFieldText = value
    }

    private[this] var _removeOperation: String = removeOperation
    def RemoveOperation = _removeOperation
    def RemoveOperation_=(value: String) {
        if (_removeOperation == value) return
        json("removeOperation") = value
        _removeOperation = value
    }

    private[this] var _removeSummaryFieldText: String = removeSummaryFieldText
    def RemoveSummaryFieldText = _removeSummaryFieldText
    def RemoveSummaryFieldText_=(value: String) {
        if (_removeSummaryFieldText == value) return
        json("removeSummaryFieldText") = value
        _removeSummaryFieldText = value
    }

    private[this] var _selectionUpdated: FunctionExpression = selectionUpdated
    def SelectionUpdated = _selectionUpdated
    def SelectionUpdated_=(value: FunctionExpression) {
        json("selectionUpdated") = value
        _selectionUpdated = value
    }

    private[this] var _showComplexFields: Bool = showComplexFields
    def ShowComplexFields = _showComplexFields
    def ShowComplexFields_=(value: Bool) {
        if (_showComplexFields == value) return
        json("showComplexFields") = value
        _showComplexFields = value
    }

    private[this] var _showDetailFields: Bool = showDetailFields
    def ShowDetailFields = _showDetailFields
    def ShowDetailFields_=(value: Bool) {
        if (_showDetailFields == value) return
        json("showDetailFields") = value
        _showDetailFields = value
    }

    private[this] var _showHiddenFields: Bool = showHiddenFields
    def ShowHiddenFields = _showHiddenFields
    def ShowHiddenFields_=(value: Bool) {
        if (_showHiddenFields == value) return
        json("showHiddenFields") = value
        _showHiddenFields = value
    }

    private[this] var _showOfflineMessage: Bool = showOfflineMessage
    def ShowOfflineMessage = _showOfflineMessage
    def ShowOfflineMessage_=(value: Bool) {
        if (_showOfflineMessage == value) return
        json("showOfflineMessage") = value
        _showOfflineMessage = value
    }

    private[this] var _titleField: String = titleField
    def TitleField = _titleField
    def TitleField_=(value: String) {
        if (_titleField == value) return
        json("titleField") = value
        _titleField = value
    }

    private[this] var _unknownErrorMessage: HTMLString = unknownErrorMessage
    def UnknownErrorMessage = _unknownErrorMessage
    def UnknownErrorMessage_=(value: HTMLString) {
        if (_unknownErrorMessage == value) return
        json("unknownErrorMessage") = value
        _unknownErrorMessage = value
    }

    private[this] var _updateOperation: String = updateOperation
    def UpdateOperation = _updateOperation
    def UpdateOperation_=(value: String) {
        if (_updateOperation == value) return
        json("updateOperation") = value
        _updateOperation = value
    }

    private[this] var _useAllDataSourceFields: Bool = useAllDataSourceFields
    def UseAllDataSourceFields = _useAllDataSourceFields
    def UseAllDataSourceFields_=(value: Bool) {
        if (_useAllDataSourceFields == value) return
        json("useAllDataSourceFields") = value
        _useAllDataSourceFields = value
    }

    private[this] var _useFlatFields: Bool = useFlatFields
    def UseFlatFields = _useFlatFields
    def UseFlatFields_=(value: Bool) {
        if (_useFlatFields == value) return
        json("useFlatFields") = value
        _useFlatFields = value
    }
}