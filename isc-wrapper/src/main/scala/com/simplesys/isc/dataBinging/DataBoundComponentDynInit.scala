package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{JsonNull, JsonElement, JsonList, JsonObject}
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.grids.HiliteDyn


trait DataBoundComponentDynInit {
    protected val addDropValues: Bool = true
    protected val addFormulaFieldText: String = "Add formula column..."
    protected val addOperation: String = ""
    protected val addSummaryFieldText: String = "Add summary column..."
    protected val autoTrackSelection: Bool = true
    protected val badFormulaResultValue: String = "."
    protected val canAddFormulaFields: Bool = false
    protected val canAddSummaryFields: Bool = false
    protected val canEditFieldAttribute: String = "canEdit"
    protected val dataArity: String = "multiple"
    protected val dataFetchMode: FetchMode = ftchMdBasic
    protected val dataField: String = ""
    protected val dataSource: JsonElement = JsonNull
    protected val dataPageSize: JsonElement = 75
    protected val descriptionField: String = ""
    protected val dragDataAction: DragDataAction = drgDtActMove
    protected val dragTrackerStyle: CSSStyleName = "gridDragTracker"
    protected val dropValues: JsonObject = JsonObject()
    protected val duplicateDragMessage: String = "Duplicates not allowed"
    protected val editFormulaFieldText: String = "Edit formula..."
    protected val editSummaryFieldText: String = "Edit summary format..."
    protected val emptyExportMessage: String = "You are attempting to export an empty dataset"
    protected val exportAll: Bool = false
    protected val exportFields: JsonList = JsonList()
    protected val exportIncludeSummaries: Bool = true
    protected val fetchOperation: String = ""
    protected val fields: JsonElement = JsonNull
    protected val hiliteProperty: String = "_hilite"
    protected val hilites: ArrayDyn[HiliteDyn] = null
    protected val iconField: String = ""
    protected val infoField: String = ""
    protected val missingSummaryFieldValue: String = "-"
    protected val offlineMessage: String = "This data not available while offline"
    protected val offlineSaveMessage: String = "Data cannot be saved because you are not online"
    protected val preventDuplicates: Bool = null
    protected val removeFormulaFieldText: String = "Remove formula"
    protected val removeOperation: String = ""
    protected val removeSummaryFieldText: String = "Remove summary format..."
    protected val selectionUpdated: FunctionExpression = null
    protected val showComplexFields: Bool = true
    protected val showDetailFields: Bool = false
    protected val showHiddenFields: Bool = false
    protected val showOfflineMessage: Bool = true
    protected val titleField: String = ""
    protected val unknownErrorMessage: HTMLString = "Invalid value"
    protected val updateOperation: String = ""
    protected val useAllDataSourceFields: Bool = false
    protected val useFlatFields: Bool = null
}