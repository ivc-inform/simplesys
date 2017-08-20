package com.simplesys.components.Dyn

import com.simplesys.isc.system.MultiAutoChild
import com.simplesys.json.{JsonNull, JsonString, JsonElement, JsonObject}
import com.simplesys.isc.layout.{VLayoutDynInit, VLayoutDyn}
import com.simplesys.components.Dyn.Layout.HLayoutSSDynInit
import com.simplesys.isc.system.misc.{FunctionExpression, Bool}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc._

object ListGridEditorDyn {

    implicit def GridEditorDyn2JsonObject(in: ListGridEditorDyn): JsonObject = in json
}

class ListGridEditorDyn(override val useSelfName: Boolean = false) extends VLayoutDyn with ListGridEditorDynInit {
    override val selfName = "ListGridEditor"

    def AutoFetchData = json.getJsonElement("autoFetchData").getOrElse(autoFetchData)
    def AutoFetchData_=(value: JsonElement) {
        if (AutoFetchData == value) return
        json("autoFetchData") = value
    }

    def AutoFitFieldWidths = json.getBoolOpt("autoFitFieldWidths").getOrElse(autoFitFieldWidths)
    def AutoFitFieldWidths_=(value: Bool) {
        if (AutoFitFieldWidths == value) return
        json("autoFitFieldWidths") = value
    }

    def AutoFitWidthApproach = json.getValue2[JsonString, AutoFitWidthApproach]("autoFitWidthApproach").getOrElse(autoFitWidthApproach)
    def AutoFitWidthApproach_=(value: AutoFitWidthApproach) {
        if (AutoFitWidthApproach == value) return
        json("autoFitWidthApproach") = value
    }

    def AutoSaveEdits = json.getBooleanOpt("autoSaveEdits").getOrElse(autoSaveEdits)
    def AutoSaveEdits_=(value: Boolean) {
        if (AutoSaveEdits == value) return
        json("autoSaveEdits") = value
    }

    def CanEdit = json.getJsonElement("canEdit").getOrElse(canEdit)
    def CanEdit_=(value: JsonElement) {
        if (CanEdit == value) return
        json("canEdit") = value
    }

    def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
    def DataSource_=(value: JsonElement) {
        if (DataSource == value) return
        json("dataSource") = value
    }

    def EditByCell = json.getJsonElement("editByCell").getOrElse(editByCell)
    def EditByCell_=(value: JsonElement) {
        if (EditByCell == value) return
        json("editByCell") = value
    }

    def Fields = json.getJsonElement("fields").getOrElse(fields)
    def Fields_=(value: JsonElement) {
        if (Fields == value) return
        json("fields") = value
    }

    def DefaultFields = json.getJsonElement("fields").getOrElse(defaultFields)
    def DefaultFields_=(value: JsonElement) {
        if (DefaultFields == value) return
        json("defaultFields") = value
    }

    def FuncMenu = json.getJsonElement("funcMenu").getOrElse(funcMenu)
    def FuncMenu_=(value: JsonElement) {
        if (FuncMenu == value) return
        json("funcMenu") = value
    }

    def EmptyMessage = json.getJsonElement("emptyMessage").getOrElse(emptyMessage)
    def EmptyMessage_=(value: JsonElement) {
        if (EmptyMessage == value) return
        json("emptyMessage") = value
    }

    def CancelEditingConfirmationMessage = json.getJsonElement("cancelEditingConfirmationMessage").getOrElse(cancelEditingConfirmationMessage)
    def CancelEditingConfirmationMessage_=(value: JsonElement) {
        if (CancelEditingConfirmationMessage == value) return
        json("cancelEditingConfirmationMessage") = value
    }

    def EditEvent = json.getValue2[JsonString, ListGridEditEvent]("editEvent").getOrElse(editEvent)
    def EditEvent_=(value: ListGridEditEvent) {
        if (EditEvent == value) return
        json("editEvent") = value
    }

    def ShowRowNumbers = json.getBoolOpt("showRowNumbers").getOrElse(showRowNumbers)
    def ShowRowNumbers_=(value: Bool) {
        if (ShowRowNumbers == value) return
        json("showRowNumbers") = value
    }

    def ModalEditing = json.getBoolOpt("modalEditing").getOrElse(modalEditing)
    def ModalEditing_=(value: Bool) {
        if (ModalEditing == value) return
        json("modalEditing") = value
    }

    def CanSelectCells = json.getJsonElement("canSelectCells").getOrElse(canSelectCells)
    def CanSelectCells_=(value: JsonElement) {
        if (CanSelectCells == value) return
        json("canSelectCells") = value
    }

    def Data = json.getJsonElement("data").getOrElse(data)
    def Data_=(value: JsonElement) {
        if (Data == value) return
        json("data") = value
    }

    def DataPageSize = json.getJsonElement("dataPageSize").getOrElse(dataPageSize)
    def DataPageSize_=(value: JsonElement) {
        if (DataPageSize == value) return
        json("dataPageSize") = value
    }

    def DrawAheadRatio = json.getJsonElement("drawAheadRatio").getOrElse(drawAheadRatio)
    def DrawAheadRatio_=(value: JsonElement) {
        if (DrawAheadRatio == value) return
        json("drawAheadRatio") = value
    }

    def ShowAdvancedFilter = json.getJsonElement("showAdvancedFilter").getOrElse(showAdvancedFilter)
    def ShowAdvancedFilter_=(value: JsonElement) {
        if (ShowAdvancedFilter == value) return
        json("showAdvancedFilter") = value
    }

    def SelectionType = json.getJsonElement("selectionType").getOrElse(selectionType)
    def SelectionType_=(value: JsonElement) {
        if (SelectionType == value) return
        json("selectionType") = value
    }

    def CreateRecordComponent = json.getJsonElement("createRecordComponent").getOrElse(createRecordComponent)
    def CreateRecordComponent_=(value: JsonElement) {
        if (CreateRecordComponent == value) return
        json("createRecordComponent") = value
    }

    def ShowRecordComponents = json.getJsonElement("showRecordComponents").getOrElse(showRecordComponents)
    def ShowRecordComponents_=(value: JsonElement) {
        if (ShowRecordComponents == value) return
        json("showRecordComponents") = value
    }

    def ShowRecordComponentsByCell = json.getJsonElement("showRecordComponentsByCell").getOrElse(showRecordComponentsByCell)
    def ShowRecordComponentsByCell_=(value: JsonElement) {
        if (ShowRecordComponentsByCell == value) return
        json("showRecordComponentsByCell") = value
    }

    def InitialSort = json.getJsonElement("initialSort").getOrElse(initialSort)
    def InitialSort_=(value: JsonElement) {
        if (InitialSort == value) return
        json("initialSort") = value
    }

    def ShowFilterEditor = json.getJsonElement("showFilterEditor").getOrElse(showFilterEditor)
    def ShowFilterEditor_=(value: JsonElement) {
        if (ShowFilterEditor == value) return
        json("showFilterEditor") = value
    }

    def FetchDelay = json.getJsonElement("fetchDelay").getOrElse(fetchDelay)
    def FetchDelay_=(value: JsonElement) {
        if (FetchDelay == value) return
        json("fetchDelay") = value
    }

    def FilterOnKeypress = json.getJsonElement("filterOnKeypress").getOrElse(filterOnKeypress)
    def FilterOnKeypress_=(value: JsonElement) {
        if (FilterOnKeypress == value) return
        json("filterOnKeypress") = value
    }

    def AutoFetchTextMatchStyle = json.getJsonElement("autoFetchTextMatchStyle").getOrElse(autoFetchTextMatchStyle)
    def AutoFetchTextMatchStyle_=(value: JsonElement) {
        if (AutoFetchTextMatchStyle == value) return
        json("autoFetchTextMatchStyle") = value
    }

    def WrapCells = json.getJsonElement("wrapCells").getOrElse(wrapCells)
    def WrapCells_=(value: JsonElement) {
        if (WrapCells == value) return
        json("wrapCells") = value
    }

    def CanDragSelectText = json.getJsonElement("canDragSelectText").getOrElse(canDragSelectText)
    def CanDragSelectText_=(value: JsonElement) {
        if (CanDragSelectText == value) return
        json("canDragSelectText") = value
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

    def FixedRecordHeights = json.getJsonElement("fixedRecordHeights").getOrElse(fixedRecordHeights)
    def FixedRecordHeights_=(value: JsonElement) {
        if (FixedRecordHeights == value) return
        json("fixedRecordHeights") = value
    }

    def GetExpansionComponent = json.getFunctionExpressionOpt("getExpansionComponent").getOrElse(getExpansionComponent)
    def GetExpansionComponent_=(value: FunctionExpression) {
        if (GetExpansionComponent == value) return
        json("getExpansionComponent") = value
    }

    def CollapseRecord = json.getFunctionExpressionOpt("collapseRecord").getOrElse(collapseRecord)
    def CollapseRecord_=(value: FunctionExpression) {
        if (CollapseRecord == value) return
        json("collapseRecord") = value
    }

    def InitialCriteria = json.getJsonElement("initialCriteria").getOrElse(initialCriteria)
    def InitialCriteria_=(value: JsonElement) {
        if (InitialCriteria == value) return
        json("initialCriteria") = value
    }

    def SelectionAppearance = json.getValue2[JsonString, SelectionAppearance]("selectionAppearance").getOrElse(selectionAppearance)
    def SelectionAppearance_=(value: SelectionAppearance) {
        if (SelectionAppearance == value) return
        json("selectionAppearance") = value
    }

    def GetBaseStyle = json.getFunctionExpressionOpt("getBaseStyle").getOrElse(getBaseStyle)
    def GetBaseStyle_=(value: FunctionExpression) {
        if (GetBaseStyle == value) return
        json("getBaseStyle") = value
    }

    def CellClick = json.getFunctionExpressionOpt("cellClick").getOrElse(cellClick)
    def CellClick_=(value: FunctionExpression) {
        if (CellClick == value) return
        json("cellClick") = value
    }

    def RecordComponentPoolingMode = json.getValue2[JsonString, RecordComponentPoolingMode]("recordComponentPoolingMode").getOrElse(recordComponentPoolingMode)
    def RecordComponentPoolingMode_=(value: RecordComponentPoolingMode) {
        if (RecordComponentPoolingMode == value) return
        json("recordComponentPoolingMode") = value
    }

    def MasterGrid = json.getJsonElement("masterGrid").getOrElse(masterGrid)
    def MasterGrid_=(value: JsonElement) {
        if (MasterGrid == value) return
        json("masterGrid") = value
    }

    def CanReorderRecords = json.getBoolOpt("canReorderRecords").getOrElse(canReorderRecords)
    def CanReorderRecords_=(value: Bool) {
        if (CanReorderRecords == value) return
        json("canReorderRecords") = value
    }
    
}