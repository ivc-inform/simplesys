package com.simplesys.components.Dyn

import com.simplesys.json._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HLayoutDynInit
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.dataBinging.SortSpecifierDyn
import com.simplesys.components._

trait TreeListGridEditorDynInit extends HLayoutDynInit {

    private[Dyn] val autoFetchData: Bool = true
    private[Dyn] val drawAheadRatio: Number = 1.3
    private[Dyn] val dataSourceTree: JsonElement = JsonNull
    private[Dyn] val fieldsTree: JsonElement = JsonNull
    private[Dyn] val cancelEditingConfirmationMessageTree: String = _cancelEditingConfirmationMessage
    private[Dyn] val emptyMessageTree: HTMLString = "<h1>Данных нет.</h1>"
    private[Dyn] val initialSortList = ArrayDyn.empty[SortSpecifierDyn]
    private[Dyn] val initialSortTree = ArrayDyn.empty[SortSpecifierDyn]
    private[Dyn] val showOpenIconsTree: JsonElement = false
    private[Dyn] val nodeIconTree: SCImgURL = "node.png"
    private[Dyn] val folderIconTree: SCImgURL = "group.png"
    private[Dyn] val selectionTypeTree: SelectionStyle = slStlNull
    private[Dyn] val loadDataOnDemandTree: Bool = false
    private[Dyn] val canAcceptDroppedRecordsTree: Bool = false
    private[Dyn] val canSelectCellsTree: Bool = false
    private[Dyn] val canEdiTree: Bool = null
    private[Dyn] val canReparentNodesTree: Bool = false
    private[Dyn] val editByCellTree: Bool = false
    private[Dyn] val folderDrop: FunctionExpression = null
    private[Dyn] val dataSourceList: JsonElement = JsonNull
    private[Dyn] val fieldsList: JsonElement = JsonNull
    private[Dyn] val defaultFieldsList: JsonElement = JsonNull
    private[Dyn] val defaultFieldsTree: JsonElement = JsonNull
    private[Dyn] val heightTree: JsonElement = "100".%
    private[Dyn] val widthTree: JsonElement = "10".%
    private[Dyn] val heightList: Number = "100".%
    private[Dyn] val widthList: Number = "*"
    private[Dyn] val emptyMessageList: HTMLString = "<h1>Данных нет.</h1>"
    private[Dyn] val cancelEditingConfirmationMessageList: String = _cancelEditingConfirmationMessage
    private[Dyn] val canEditList: Bool = null
    private[Dyn] val canEditTree: Bool = false
    private[Dyn] val canSelectCellsList: Bool = true
    private[Dyn] val editByCellList: Bool = false
    private[Dyn] val selectionTypeList: SelectionStyle = slStlNull
    private[Dyn] val funcMenu: JsonElement = JsonNull
    private[Dyn] val createListRecordComponent: JsonElement = JsonNull
    private[Dyn] val resizedTree: FunctionExpression = null
    private[Dyn] val treeIdentifier: JsonElement = JsonNull
    private[Dyn] val autoFetchTreeData: Bool = false
    private[Dyn] val autoFetchListData: Bool = false
    private[Dyn] val enableChangeSelectionTree: Bool = true
    private[Dyn] val dataPageSizeTree: JsonElement = 50
    private[Dyn] val dataPageSizeList: JsonElement = 50
    private[Dyn] val drawAheadRatioList: JsonElement = 1.3
    private[Dyn] val drawAheadRatioTree: JsonElement = 1.3
    private[Dyn] val showListFilterEditor: Bool = true
    private[Dyn] val showTreeFilterEditor: Bool = true
    private[Dyn] val fetchListDelay: Number = 500
    private[Dyn] val fetchTreeDelay: Number = 500
    private[Dyn] val filterListOnKeypress: Bool = true
    private[Dyn] val filterTreeOnKeypress: Bool = true
    private[Dyn] val autoFetchTextMatchStyleList: TextMatchStyle = txtMchStyleSubstring
    private[Dyn] val showListAdvancedFilter: JsonElement = false
    private[Dyn] val showListRecordComponents: Boolean = false
    private[Dyn] val showListRecordComponentsByCell: Boolean = false
    private[Dyn] val showTreeRecordComponents: Boolean = false
    private[Dyn] val showTreeRecordComponentsByCell: Boolean = false
    private[Dyn] val autoSaveListEdits: Boolean = true
    private[Dyn] val autoSaveTreeEdits: Boolean = true
    private[Dyn] val contextMenuListGridEditor: JsonElement = JsonNull
    private[Dyn] val contextMenuTreeGridEditor: JsonElement = JsonNull
    private[Dyn] val wrapListCells: JsonElement = false
    private[Dyn] val wrapTreeCells: JsonElement = false
}