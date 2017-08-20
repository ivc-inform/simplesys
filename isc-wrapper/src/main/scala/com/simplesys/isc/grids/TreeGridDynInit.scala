package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonNull, JsonObject, JsonList}
import com.simplesys.isc.system.ArrayDyn
import treeGrid.TreeNodeDyn


trait TreeGridDynInit extends ListGridDynInit {
    override protected val animateFolderEffect: AnimationAcceleration = anAcsNull
    override protected val animateFolderMaxRows: Number = null
    override protected val animateFolders: Bool = true
    override protected val animateFolderSpeed: Number = 3000
    override protected val animateFolderTime: Number = 100
    protected val autoPreserveOpenState: PreserveOpenState = prsrvNull
    override protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleExact
    override protected val canAcceptDroppedRecords: Bool = false
    override protected val canDragRecordsOut: Bool = false
    protected val canDropOnLeaves: Bool = false
    override protected val canReorderRecords: Bool = false
    protected val canReparentNodes: Bool = null
    protected val cantDragIntoChildMessage: String = "You can't drag an item into one of it's children."
    protected val cantDragIntoSelfMessage: String = "You can't drag an item into itself."
    private[grids] val cascadeSelection: JsonElement = false
    protected val closedIconSuffix: String = "closed"
    protected val connectorImage: SCImgURL = "[SKIN]connector.gif"
    protected val customIconDropProperty: String = "showDropIcon"
    protected val customIconOpenProperty: String = "showOpenIcon"
    protected val customIconProperty: String = "icon"
    override protected val dataFetchMode: FetchMode = ftchMdBasic
    private[grids] val dataArrived: FunctionExpression = null
    protected val displayNodeType: DisplayNodeType = dspNdTpNull
    override protected val dragDataAction: DragDataAction = drgDtActMove
    protected val dropIconSuffix: String = "drop"
    protected val extraIconGap: Number = 2
    protected val fileImage: SCImgURL = "[SKIN]file.gif"
    protected val folderClosedImage: String = ""
    protected val folderDrop: FunctionExpression = null
    protected val folderDropImage: SCImgURL = JsonNull
    protected val folderIcon: SCImgURL = "[SKIN]folder.gif"
    protected val folderOpenImage: String = ""
    protected val iconSize: Number = 16
    protected val indentRecordComponents: Bool = true
    protected val indentSize: Number = 20
    protected val initialData: ArrayDyn[TreeNodeDyn] = null
    protected val keepParentsOnFilter: Bool = false
    protected val loadDataOnDemand: Bool = null
    protected val manyItemsImage: SCImgURL = "[SKIN]folder_file.gif"
    protected val nodeClick: FunctionExpression = null
    protected val nodeIcon: SCImgURL = "[SKIN]file.gif"
    protected val offlineNodeMessage: String = "This data not available while offline"
    protected val openerIconSize: Number = null
    protected val openerImage: SCImgURL = "[SKIN]opener.gif"
    protected val openIconSuffix: String = "open"
    protected val parentAlreadyContainsChildMessage: String = "This item already contains a child item with that name."
    override protected val selectionProperty: String = ""
    protected val separateFolders: Bool = false
    protected val serverFilterFields: JsonList = JsonList()
    protected val showConnectors: Bool = false
    protected val showCustomIconDrop: Bool = false
    protected val showCustomIconOpen: Bool = false
    protected val showDisabledSelectionCheckbox: Bool = false
    private[grids] val showDropIcons: JsonElement = true
    protected val showFullConnectors: Bool = true
    protected val showOpener: Bool = true
    protected val showOpenIcons: Bool = true
    private[grids] val showPartialSelection: JsonElement = false
    protected val showRoot: Bool = false
    protected val sortFoldersBeforeLeaves: Bool = false
    private[grids] val startEditingNew: FunctionExpression = null
    protected val treeFieldTitle: String = "Name"
    protected val treeRootValue: JsonObject = JsonObject()
    protected val willAcceptDrop: FunctionExpression = null
}