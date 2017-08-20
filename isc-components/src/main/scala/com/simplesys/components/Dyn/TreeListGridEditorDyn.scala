package com.simplesys.components.Dyn

import com.simplesys.json._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HLayoutDyn
import com.simplesys.isc.dataBinging.SortSpecifierDyn
import com.simplesys.isc.system.ArrayDyn

object TreeListGridEditorDyn extends TreeListGridEditorDynInit {

    implicit def TreeListGridEditorDyn2JsonObject(in: TreeListGridEditorDyn): JsonObject = in json
}

class TreeListGridEditorDyn(override val useSelfName: Boolean = false) extends HLayoutDyn with TreeListGridEditorDynInit {
    override val selfName = "TreeListGridEditor"

    def AutoFetchData = json.getJsonElement("autoFetchData").getOrElse(autoFetchData)
    def AutoFetchData_=(value: JsonElement) {
        if (AutoFetchData == value) return
        json("autoFetchData") = value
    }

    def DataSourceTree = json.getJsonElement("dataSourceTree").getOrElse(dataSourceTree)
    def DataSourceTree_=(value: JsonElement) {
        if (DataSourceTree == value) return
        json("dataSourceTree") = value
    }

    def CancelEditingConfirmationMessageTree = json.getJsonElement("cancelEditingConfirmationMessageList").getOrElse(cancelEditingConfirmationMessageTree)
    def CancelEditingConfirmationMessageTree_=(value: String) {
        if (CancelEditingConfirmationMessageTree == value) return
        json("cancelEditingConfirmationMessageTree") = value
    }

    def EmptyMessageTree = json.getStringOpt("emptyMessageTree").getOrElse(emptyMessageTree)
    def EmptyMessageTree_=(value: HTMLString) {
        if (EmptyMessageTree == value) return
        json("emptyMessageTree") = value
    }

    def InitialSortList = initialSortList
    def InitialSortList_=(value: ArrayDyn[SortSpecifierDyn]) {
        if (initialSortList == value) return
        json("initialSortList") = value
    }

    def InitialSortTree = initialSortTree
    def InitialSortTree_=(value: ArrayDyn[SortSpecifierDyn]) {
        if (initialSortTree == value) return
        json("initialSortTree") = value
    }

    def ShowOpenIconsTree = json.getJsonElement("showOpenIconsTree").getOrElse(showOpenIconsTree)
    def ShowOpenIconsTree_=(value: JsonElement) {
        if (ShowOpenIconsTree == value) return
        json("showOpenIconsTree") = value
    }

    def NodeIconTree = json.getJsonElement("nodeIconTree").getOrElse(nodeIconTree)
    def NodeIconTree_=(value: SCImgURL) {
        if (NodeIconTree == value) return
        json("nodeIconTree") = value
    }

    def FolderIconTree = json.getJsonElement("folderIconTree").getOrElse(folderIconTree)
    def FolderIconTree_=(value: SCImgURL) {
        if (FolderIconTree == value) return
        json("folderIconTree") = value
    }

    private[Dyn] val folderDropImageTree: SCImgURL = "folder_drop.png"
    def FolderDropImageTree = json.getSCImgURL("folderDropImageTree").getOrElse(folderDropImageTree)
    def FolderDropImageTree_=(value: SCImgURL) {
        if (FolderDropImageTree == value) return
        json("folderDropImageTree") = value
    }

    def SelectionTypeTree = json.getValue2[JsonString, SelectionStyle]("selectionTypeTree").getOrElse(selectionTypeTree)
    def SelectionTypeTree_=(value: SelectionStyle) {
        if (SelectionTypeTree == value) return
        json("selectionTypeTree") = value
    }

    def LoadDataOnDemandTree = json.getBoolOpt("loadDataOnDemandTree").getOrElse(loadDataOnDemandTree)
    def LoadDataOnDemandTree_=(value: Bool) {
        if (LoadDataOnDemandTree == value) return
        json("loadDataOnDemandTree") = value
    }

    def CanAcceptDroppedRecordsTree = json.getBoolOpt("canAcceptDroppedRecordsTree").getOrElse(canAcceptDroppedRecordsTree)
    def CanAcceptDroppedRecordsTree_=(value: Bool) {
        if (CanAcceptDroppedRecordsTree == value) return
        json("canAcceptDroppedRecordsTree") = value
    }

    def CanSelectCellsTree = json.getBoolOpt("canSelectCellsTree").getOrElse(canSelectCellsTree)
    def CanSelectCellsTree_=(value: Bool) {
        if (CanSelectCellsTree == value) return
        json("canSelectCellsTree") = value
    }

    def CanEdiTree = json.getBoolOpt("canEdiTreet").getOrElse(canEdiTree)
    def CanEdiTree_=(value: Bool) {
        if (CanEdiTree == value) return
        json("canEdiTree") = value
    }

    def CanReparentNodesTree = json.getBoolOpt("canReparentNodesTree").getOrElse(canReparentNodesTree)
    def CanReparentNodesTree_=(value: Bool) {
        if (CanReparentNodesTree == value) return
        json("canReparentNodesTree") = value
    }

    def EditByCellTree = json.getBoolOpt("editByCellTree").getOrElse(editByCellTree)
    def EditByCellTree_=(value: Bool) {
        if (EditByCellTree == value) return
        json("editByCellTree") = value
    }

    def FolderDrop = json.getFunctionExpressionOpt("folderDrop").getOrElse(folderDrop)
    def FolderDrop_=(value: FunctionExpression) {
        if (FolderDrop == value) return
        json("folderDrop") = value
    }

    def HeightTree = json.getJsonElement("heightTree").getOrElse(heightTree)
    def HeightTree_=(value: JsonElement) {
        if (HeightTree == value) return
        json("heightTree") = value
    }

    def WidthTree = json.getJsonElement("widthTree").getOrElse(widthTree)
    def WidthTree_=(value: JsonElement) {
        if (WidthTree == value) return
        json("widthTree") = value
    }

    def DataSourceList = json.getJsonElement("dataSourceList").getOrElse(dataSourceList)
    def DataSourceList_=(value: JsonElement) {
        if (DataSourceList == value) return
        json("dataSourceList") = value
    }

    def FieldsList = json.getJsonElement("fieldsList").getOrElse(fieldsList)
    def FieldsList_=(value: JsonElement) {
        if (FieldsList == value) return
        json("fieldsList") = value
    }

    def DefaultFieldsList = json.getJsonElement("defaultFieldsList").getOrElse(defaultFieldsList)
    def DefaultFieldsList_=(value: JsonElement) {
        if (DefaultFieldsList == value) return
        json("defaultFieldsList") = value
    }

    def HeightList = json.getNumberOpt("heightList").getOrElse(heightList)
    def HeightList_=(value: Number) {
        if (HeightList == value) return
        json("heightList") = value
    }

    def WidthList = json.getNumberOpt("widthList").getOrElse(widthList)
    def WidthList_=(value: Number) {
        if (WidthList == value) return
        json("widthList") = value
    }

    def EmptyMessageList = json.getStringOpt("emptyMessageList").getOrElse(emptyMessageList)
    def EmptyMessageList_=(value: HTMLString) {
        if (EmptyMessageList == value) return
        json("emptyMessageList") = value
    }

    def CancelEditingConfirmationMessageList = json.getStringOpt("cancelEditingConfirmationMessageList").getOrElse(cancelEditingConfirmationMessageList)
    def CancelEditingConfirmationMessageList_=(value: String) {
        if (CancelEditingConfirmationMessageList == value) return
        json("cancelEditingConfirmationMessageList") = value
    }

    def CanEditList = json.getBoolOpt("canEditList").getOrElse(canEditList)
    def CanEditList_=(value: Bool) {
        if (CanEditList == value) return
        json("canEditList") = value
    }

    def CanEditTree = json.getBoolOpt("canEditTree").getOrElse(canEditTree)
    def CanEditTree_=(value: Bool) {
        if (CanEditTree == value) return
        json("canEditTree") = value
    }

    def CanSelectCellsList = json.getBoolOpt("canSelectCellsList").getOrElse(canSelectCellsList)
    def CanSelectCellsList_=(value: Bool) {
        if (CanSelectCellsList == value) return
        json("canSelectCellsList") = value
    }

    def EditByCellList = json.getBoolOpt("editByCellList").getOrElse(editByCellList)
    def EditByCellList_=(value: Bool) {
        if (EditByCellList == value) return
        json("editByCellList") = value
    }

    def SelectionTypeList = json.getValue2[JsonString, SelectionStyle]("selectionTypeList").getOrElse(selectionTypeList)
    def SelectionTypeList_=(value: SelectionStyle) {
        if (SelectionTypeList == value) return
        json("selectionTypeList") = value
    }

    def FuncMenu = json.getJsonElement("funcMenu").getOrElse(funcMenu)
    def FuncMenu_=(value: JsonElement) {
        if (FuncMenu == value) return
        json("funcMenu") = value
    }

    def CreateListRecordComponent = json.getJsonElement("createListRecordComponent").getOrElse(createListRecordComponent)
    def CreateListRecordComponent_=(value: JsonElement) {
        if (CreateListRecordComponent == value) return
        json("createListRecordComponent") = value
    }

    def ResizedTree = json.getFunctionExpressionOpt("resizedTree").getOrElse(resizedTree)
    def ResizedTree_=(value: FunctionExpression) {
        if (ResizedTree == value) return
        json("resizedTree") = value
    }

    def TreeIdentifier = json.getJsonElement("treeIdentifier").getOrElse(treeIdentifier)
    def TreeIdentifier_=(value: JsonElement) {
        if (TreeIdentifier == value) return
        json("treeIdentifier") = value
    }

    def EnableChangeSelectionTree = json.getBoolOpt("enableChangeSelectionTree").getOrElse(enableChangeSelectionTree)
    def EnableChangeSelectionTree_=(value: Bool) {
        if (EnableChangeSelectionTree == value) return
        json("enableChangeSelectionTree") = value
    }

    def DataPageSizeList = json.getJsonElement("dataPageSizeList").getOrElse(dataPageSizeList)
    def DataPageSizeList_=(value: JsonElement) {
        if (DataPageSizeList == value) return
        json("dataPageSizeList") = value
    }

    def DataPageSizeTree = json.getJsonElement("dataPageSizeTree").getOrElse(dataPageSizeTree)
    def DataPageSizeTree_=(value: JsonElement) {
        if (DataPageSizeTree == value) return
        json("dataPageSizeTree") = value
    }

    def DrawAheadRatioList = json.getJsonElement("drawAheadRatioList").getOrElse(drawAheadRatioList)
    def DrawAheadRatioList_=(value: JsonElement) {
        if (DrawAheadRatioList == value) return
        json("drawAheadRatioList") = value
    }

    def DrawAheadRatioTree = json.getJsonElement("drawAheadRatioTree").getOrElse(drawAheadRatioTree)
    def DrawAheadRatioTree_=(value: JsonElement) {
        if (DrawAheadRatioTree == value) return
        json("drawAheadRatioTree") = value
    }

    def ShowListFilterEditor = json.getBoolOpt("showListFilterEditor").getOrElse(showListFilterEditor)
    def ShowListFilterEditor_=(value: Bool) {
        if (ShowListFilterEditor == value) return
        json("showListFilterEditor") = value
    }

    def ShowTreeFilterEditor = json.getBoolOpt("showTreeFilterEditor").getOrElse(showTreeFilterEditor)
    def ShowTreeFilterEditor_=(value: Bool) {
        if (ShowTreeFilterEditor == value) return
        json("showTreeFilterEditor") = value
    }

    def FetchListDelay = json.getNumberOpt("fetchListDelay").getOrElse(fetchListDelay)
    def FetchListDelay_=(value: Number) {
        if (FetchListDelay == value) return
        json("fetchListDelay") = value
    }

    def FetchTreeDelay = json.getNumberOpt("fetchTreeDelay").getOrElse(fetchTreeDelay)
    def FetchTreeDelay_=(value: Number) {
        if (FetchTreeDelay == value) return
        json("fetchTreeDelay") = value
    }

    def FilterListOnKeypress = json.getBoolOpt("filterListOnKeypress").getOrElse(filterListOnKeypress)
    def FilterListOnKeypress_=(value: Bool) {
        if (FilterListOnKeypress == value) return
        json("filterListOnKeypress") = value
    }

    def FilterTreeOnKeypress = json.getBoolOpt("filterTreeOnKeypress").getOrElse(filterTreeOnKeypress)
    def FilterTreeOnKeypress_=(value: Bool) {
        if (FilterTreeOnKeypress == value) return
        json("filterTreeOnKeypress") = value
    }

    def AutoFetchTextMatchStyleList = json.getValue2[JsonString, TextMatchStyle]("autoFetchTextMatchStyleList").getOrElse(autoFetchTextMatchStyleList)
    def AutoFetchTextMatchStyleList_=(value: TextMatchStyle) {
        if (AutoFetchTextMatchStyleList == value) return
        json("autoFetchTextMatchStyleList") = value
    }

    private[Dyn] val autoFetchTextMatchStyleTree: TextMatchStyle = txtMchStyleSubstring
    def AutoFetchTextMatchStyleTree = json.getValue2[JsonString, TextMatchStyle]("autoFetchTextMatchStyleTree").getOrElse(autoFetchTextMatchStyleTree)
    def AutoFetchTextMatchStyleTree_=(value: TextMatchStyle) {
        if (AutoFetchTextMatchStyleTree == value) return
        json("autoFetchTextMatchStyleTree") = value
    }

    def ShowListAdvancedFilter = json.getJsonElement("showListAdvancedFilter").getOrElse(showListAdvancedFilter)
    def ShowListAdvancedFilter_=(value: JsonElement) {
        if (ShowListAdvancedFilter == value) return
        json("showListAdvancedFilter") = value
    }

    def ShowListRecordComponents = json.getBooleanOpt("showListRecordComponents").getOrElse(showListRecordComponents)
    def ShowListRecordComponents_=(value: Boolean) {
        if (ShowListRecordComponents == value) return
        json("showListRecordComponents") = value
    }

    def ShowListRecordComponentsByCell = json.getBooleanOpt("showListRecordComponentsByCell").getOrElse(showListRecordComponentsByCell)
    def ShowListRecordComponentsByCell_=(value: Boolean) {
        if (ShowListRecordComponentsByCell == value) return
        json("showListRecordComponentsByCell") = value
    }

    def ShowTreeRecordComponents = json.getBooleanOpt("showTreeRecordComponents").getOrElse(showTreeRecordComponents)
    def ShowTreeRecordComponents_=(value: Boolean) {
        if (ShowTreeRecordComponents == value) return
        json("showTreeRecordComponents") = value
    }

    def ShowTreeRecordComponentsByCell = json.getBooleanOpt("showTreeRecordComponentsByCell").getOrElse(showTreeRecordComponentsByCell)
    def ShowTreeRecordComponentsByCell_=(value: Boolean) {
        if (ShowTreeRecordComponentsByCell == value) return
        json("showTreeRecordComponentsByCell") = value
    }

    def AutoSaveListEdits = json.getBooleanOpt("autoSaveListEdits").getOrElse(autoSaveListEdits)
    def AutoSaveListEdits_=(value: Boolean) {
        if (AutoSaveListEdits == value) return
        json("autoSaveListEdits") = value
    }

    def AutoSaveTreeEdits = json.getBooleanOpt("autoSaveTreeEdits").getOrElse(autoSaveTreeEdits)
    def AutoSaveTreeEdits_=(value: Boolean) {
        if (AutoSaveTreeEdits == value) return
        json("autoSaveTreeEdits") = value
    }

    def ContextMenuListGridEditor = json.getJsonElement("contextMenuListGridEditor").getOrElse(contextMenuListGridEditor)
    def ContextMenuListGridEditor_=(value: JsonElement) {
        if (ContextMenuListGridEditor == value) return
        json("contextMenuListGridEditor") = value
    }

    def ContextMenuTreeGridEditor = json.getJsonElement("contextMenuTreeGridEditor").getOrElse(contextMenuTreeGridEditor)
    def ContextMenuTreeGridEditor_=(value: JsonElement) {
        if (ContextMenuTreeGridEditor == value) return
        json("contextMenuTreeGridEditor") = value
    }

    def WrapListCells = json.getJsonElement("wrapListCells").getOrElse(wrapListCells)
    def WrapListCells_=(value: JsonElement) {
        if (WrapListCells == value) return
        json("wrapListCells") = value
    }

    def WrapTreeCells = json.getJsonElement("wrapTreeCells").getOrElse(wrapTreeCells)
    def WrapTreeCells_=(value: JsonElement) {
        if (WrapTreeCells == value) return
        json("wrapTreeCells") = value
    }

    def FieldsTree = json.getJsonElement("fieldsTree").getOrElse(fieldsTree)
    def FieldsTree_=(value: JsonElement) {
        if (FieldsTree == value) return
        json("fieldsTree") = value
    }

    def DefaultFieldsTree = json.getJsonElement("defaultFieldsTree").getOrElse(defaultFieldsTree)
    def DefaultFieldsTree_=(value: JsonElement) {
        if (DefaultFieldsTree == value) return
        json("defaultFieldsTree") = value
    }
}