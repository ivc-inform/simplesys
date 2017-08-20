package com.simplesys.isc.grids

import com.simplesys.json._
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import treeGrid.TreeNodeDyn
import com.simplesys.json.JsonString
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool

object TreeGridDyn {
    implicit def TreeGrid1toJsonObject(in: TreeGridDyn): JsonObject = in json

    implicit def JSonObjToClassDyn(jsonObject: JsonObject): TreeGridDyn = new TreeGridDyn(jsonObject)
}

class TreeGridDyn(override val inJson: JsonObject = null,
                  override val useSelfName: Boolean = false) extends ListGridDyn with TreeGridDynInit {
    override val selfName = "TreeGrid"

    def AutoPreserveOpenState = json.getValue2[JsonString, PreserveOpenState]("autoPreserveOpenState").getOrElse(autoPreserveOpenState)
    def AutoPreserveOpenState_=(value: PreserveOpenState) {
        if (AutoPreserveOpenState == value) return
        json("autoPreserveOpenState") = value
    }

    private[this] var _nodeIcon: SCImgURL = nodeIcon
    def NodeIcon = _nodeIcon
    def NodeIcon_=(value: SCImgURL) {
        if (_nodeIcon == value) return
        json("nodeIcon") = value
        _nodeIcon = value
    }

    private[this] var _folderIcon: SCImgURL = folderIcon
    def FolderIcon = _folderIcon
    def FolderIcon_=(value: SCImgURL) {
        if (_folderIcon == value) return
        json("folderIcon") = value
        _folderIcon = value
    }

    private[this] var _showOpenIcons: Bool = showOpenIcons
    def ShowOpenIcons = _showOpenIcons
    def ShowOpenIcons_=(value: Bool) {
        if (_showOpenIcons == value) return
        json("showOpenIcons") = value
        _showOpenIcons = value
    }

    def ShowDropIcons = json.getJsonElement("showDropIcons").getOrElse(showDropIcons)
    def ShowDropIcons_=(value: JsonElement) {
        if (ShowDropIcons == value) return
        json("showDropIcons") = value
    }

    private[this] var _closedIconSuffix: String = closedIconSuffix

    def ClosedIconSuffix = _closedIconSuffix

    def ClosedIconSuffix_=(value: String) {
        if (_closedIconSuffix == value) return
        json("closedIconSuffix") = value
        _closedIconSuffix = value
    }

    private[this] var _loadDataOnDemand: Bool = loadDataOnDemand
    def LoadDataOnDemand = _loadDataOnDemand
    def LoadDataOnDemand_=(value: Bool) {
        if (_loadDataOnDemand == value) return
        json("loadDataOnDemand") = value
        _loadDataOnDemand = value
    }

    private[this] var _canDropOnLeaves: Bool = canDropOnLeaves

    def CanDropOnLeaves = _canDropOnLeaves

    def CanDropOnLeaves_=(value: Bool) {
        if (_canDropOnLeaves == value) return
        json("canDropOnLeaves") = value
        _canDropOnLeaves = value
    }

    private[this] var _canReparentNodes: Bool = canReparentNodes
    def CanReparentNodes = _canReparentNodes
    def CanReparentNodes_=(value: Bool) {
        if (_canReparentNodes == value) return
        json("canReparentNodes") = value
        _canReparentNodes = value
    }

    private[this] var _cantDragIntoChildMessage: String = cantDragIntoChildMessage

    def CantDragIntoChildMessage = _cantDragIntoChildMessage

    def CantDragIntoChildMessage_=(value: String) {
        if (_cantDragIntoChildMessage == value) return
        json("cantDragIntoChildMessage") = value
        _cantDragIntoChildMessage = value
    }

    private[this] var _cantDragIntoSelfMessage: String = cantDragIntoSelfMessage

    def CantDragIntoSelfMessage = _cantDragIntoSelfMessage

    def CantDragIntoSelfMessage_=(value: String) {
        if (_cantDragIntoSelfMessage == value) return
        json("cantDragIntoSelfMessage") = value
        _cantDragIntoSelfMessage = value
    }

    def CascadeSelection = json.getJsonElement("cascadeSelection").getOrElse(cascadeSelection)
    def CascadeSelection_=(value: JsonElement) {
        if (CascadeSelection == value) return
        json("cascadeSelection") = value
    }

    private[this] var _connectorImage: SCImgURL = connectorImage

    def ConnectorImage = _connectorImage

    def ConnectorImage_=(value: SCImgURL) {
        if (_connectorImage == value) return
        json("connectorImage") = value
        _connectorImage = value
    }

    private[this] var _customIconDropProperty: String = customIconDropProperty

    def CustomIconDropProperty = _customIconDropProperty

    def CustomIconDropProperty_=(value: String) {
        if (_customIconDropProperty == value) return
        json("customIconDropProperty") = value
        _customIconDropProperty = value
    }

    private[this] var _customIconOpenProperty: String = customIconOpenProperty

    def CustomIconOpenProperty = _customIconOpenProperty

    def CustomIconOpenProperty_=(value: String) {
        if (_customIconOpenProperty == value) return
        json("customIconOpenProperty") = value
        _customIconOpenProperty = value
    }

    private[this] var _customIconProperty: String = customIconProperty
    def CustomIconProperty = _customIconProperty
    def CustomIconProperty_=(value: String) {
        if (_customIconProperty == value) return
        json("customIconProperty") = value
        _customIconProperty = value
    }

    def DataArrived = json.getFunctionExpressionOpt("dataArrived").getOrElse(dataArrived)
    def DataArrived_=(value: FunctionExpression) {
        if (DataArrived == value) return
        json("dataArrived") = value
    }

    private[this] var _displayNodeType: DisplayNodeType = displayNodeType
    def DisplayNodeType = _displayNodeType
    def DisplayNodeType_=(value: DisplayNodeType) {
        if (_displayNodeType == value) return
        json("displayNodeType") = value
        _displayNodeType = value
    }

    private[this] var _dropIconSuffix: String = dropIconSuffix

    def DropIconSuffix = _dropIconSuffix

    def DropIconSuffix_=(value: String) {
        if (_dropIconSuffix == value) return
        json("dropIconSuffix") = value
        _dropIconSuffix = value
    }

    private[this] var _extraIconGap: Number = extraIconGap

    def ExtraIconGap = _extraIconGap

    def ExtraIconGap_=(value: Number) {
        if (_extraIconGap == value) return
        json("extraIconGap") = value
        _extraIconGap = value
    }

    private[this] var _fileImage: SCImgURL = fileImage
    def FileImage = _fileImage

    def FileImage_=(value: SCImgURL) {
        if (_fileImage == value) return
        json("fileImage") = value
        _fileImage = value
    }

    private[this] var _folderClosedImage: String = folderClosedImage

    def FolderClosedImage = _folderClosedImage

    def FolderClosedImage_=(value: String) {
        if (_folderClosedImage == value) return
        json("folderClosedImage") = value
        _folderClosedImage = value
    }

    def FolderDrop = json.getValue2[JsonString, FunctionExpression]("folderDrop").getOrElse(folderDrop)
    def FolderDrop_=(value: FunctionExpression) {
        if (FolderDrop == value) return
        json("folderDrop") = value
    }

    private[this] var _folderDropImage: SCImgURL = folderDropImage
    def FolderDropImage = _folderDropImage
    def FolderDropImage_=(value: SCImgURL) {
        if (_folderDropImage == value) return
        json("folderDropImage") = value
        _folderDropImage = value
    }

    private[this] var _folderOpenImage: String = folderOpenImage
    def FolderOpenImage = _folderOpenImage
    def FolderOpenImage_=(value: String) {
        if (_folderOpenImage == value) return
        json("folderOpenImage") = value
        _folderOpenImage = value
    }

    private[this] var _iconSize: Number = iconSize

    def IconSize = _iconSize

    def IconSize_=(value: Number) {
        if (_iconSize == value) return
        json("iconSize") = value
        _iconSize = value
    }

    private[this] var _indentRecordComponents: Bool = indentRecordComponents

    def IndentRecordComponents = _indentRecordComponents

    def IndentRecordComponents_=(value: Bool) {
        if (_indentRecordComponents == value) return
        json("indentRecordComponents") = value
        _indentRecordComponents = value
    }

    private[this] var _indentSize: Number = indentSize

    def IndentSize = _indentSize

    def IndentSize_=(value: Number) {
        if (_indentSize == value) return
        json("indentSize") = value
        _indentSize = value
    }

    private[this] var _initialData: ArrayDyn[TreeNodeDyn] = initialData

    def InitialData = _initialData

    def InitialData_=(value: ArrayDyn[TreeNodeDyn]) {
        if (_initialData == value) return
        json("initialData") = value
        _initialData = value
    }

    private[this] var _keepParentsOnFilter: Bool = keepParentsOnFilter

    def KeepParentsOnFilter = _keepParentsOnFilter

    def KeepParentsOnFilter_=(value: Bool) {
        if (_keepParentsOnFilter == value) return
        json("keepParentsOnFilter") = value
        _keepParentsOnFilter = value
    }

    private[this] var _manyItemsImage: SCImgURL = manyItemsImage

    def ManyItemsImage = _manyItemsImage

    def ManyItemsImage_=(value: SCImgURL) {
        if (_manyItemsImage == value) return
        json("manyItemsImage") = value
        _manyItemsImage = value
    }

    def NodeClick = json.getFunctionExpressionOpt("nodeClick").getOrElse(nodeClick)

    def NodeClick_=(value: FunctionExpression) {
        if (NodeClick == value) return
        json("nodeClick") = value
    }

    private[this] var _offlineNodeMessage: String = offlineNodeMessage

    def OfflineNodeMessage = _offlineNodeMessage

    def OfflineNodeMessage_=(value: String) {
        if (_offlineNodeMessage == value) return
        json("offlineNodeMessage") = value
        _offlineNodeMessage = value
    }

    private[this] var _openerIconSize: Number = openerIconSize

    def OpenerIconSize = _openerIconSize

    def OpenerIconSize_=(value: Number) {
        if (_openerIconSize == value) return
        json("openerIconSize") = value
        _openerIconSize = value
    }

    private[this] var _openerImage: SCImgURL = openerImage

    def OpenerImage = _openerImage

    def OpenerImage_=(value: SCImgURL) {
        if (_openerImage == value) return
        json("openerImage") = value
        _openerImage = value
    }

    private[this] var _openIconSuffix: String = openIconSuffix

    def OpenIconSuffix = _openIconSuffix

    def OpenIconSuffix_=(value: String) {
        if (_openIconSuffix == value) return
        json("openIconSuffix") = value
        _openIconSuffix = value
    }

    private[this] var _parentAlreadyContainsChildMessage: String = parentAlreadyContainsChildMessage

    def ParentAlreadyContainsChildMessage = _parentAlreadyContainsChildMessage

    def ParentAlreadyContainsChildMessage_=(value: String) {
        if (_parentAlreadyContainsChildMessage == value) return
        json("parentAlreadyContainsChildMessage") = value
        _parentAlreadyContainsChildMessage = value
    }

    private[this] var _separateFolders: Bool = separateFolders

    def SeparateFolders = _separateFolders

    def SeparateFolders_=(value: Bool) {
        if (_separateFolders == value) return
        json("separateFolders") = value
        _separateFolders = value
    }

    private[this] var _serverFilterFields: JsonList = serverFilterFields

    def ServerFilterFields = _serverFilterFields

    def ServerFilterFields_=(value: JsonList) {
        if (_serverFilterFields == value) return
        json("serverFilterFields") = value
        _serverFilterFields = value
    }

    private[this] var _showConnectors: Bool = showConnectors

    def ShowConnectors = _showConnectors

    def ShowConnectors_=(value: Bool) {
        if (_showConnectors == value) return
        json("showConnectors") = value
        _showConnectors = value
    }

    private[this] var _showCustomIconDrop: Bool = showCustomIconDrop

    def ShowCustomIconDrop = _showCustomIconDrop

    def ShowCustomIconDrop_=(value: Bool) {
        if (_showCustomIconDrop == value) return
        json("showCustomIconDrop") = value
        _showCustomIconDrop = value
    }

    private[this] var _showCustomIconOpen: Bool = showCustomIconOpen

    def ShowCustomIconOpen = _showCustomIconOpen

    def ShowCustomIconOpen_=(value: Bool) {
        if (_showCustomIconOpen == value) return
        json("showCustomIconOpen") = value
        _showCustomIconOpen = value
    }

    private[this] var _showDisabledSelectionCheckbox: Bool = showDisabledSelectionCheckbox

    def ShowDisabledSelectionCheckbox = _showDisabledSelectionCheckbox

    def ShowDisabledSelectionCheckbox_=(value: Bool) {
        if (_showDisabledSelectionCheckbox == value) return
        json("showDisabledSelectionCheckbox") = value
        _showDisabledSelectionCheckbox = value
    }

    private[this] var _showFullConnectors: Bool = showFullConnectors

    def ShowFullConnectors = _showFullConnectors

    def ShowFullConnectors_=(value: Bool) {
        if (_showFullConnectors == value) return
        json("showFullConnectors") = value
        _showFullConnectors = value
    }

    private[this] var _showOpener: Bool = showOpener

    def ShowOpener = _showOpener

    def ShowOpener_=(value: Bool) {
        if (_showOpener == value) return
        json("showOpener") = value
        _showOpener = value
    }

    def ShowPartialSelection = json.getJsonElement("showPartialSelection").getOrElse(showPartialSelection)
    def ShowPartialSelection_=(value: JsonElement) {
        if (ShowPartialSelection == value) return
        json("showPartialSelection") = value
    }

    private[this] var _showRoot: Bool = showRoot

    def ShowRoot = _showRoot

    def ShowRoot_=(value: Bool) {
        if (_showRoot == value) return
        json("showRoot") = value
        _showRoot = value
    }

    private[this] var _sortFoldersBeforeLeaves: Bool = sortFoldersBeforeLeaves
    def SortFoldersBeforeLeaves = _sortFoldersBeforeLeaves
    def SortFoldersBeforeLeaves_=(value: Bool) {
        if (_sortFoldersBeforeLeaves == value) return
        json("sortFoldersBeforeLeaves") = value
        _sortFoldersBeforeLeaves = value
    }

    def StartEditingNew = json.getFunctionExpressionOpt("startEditingNew").getOrElse(startEditingNew)
    def StartEditingNew_=(value: FunctionExpression) {
        if (StartEditingNew == value) return
        json("startEditingNew") = value
    }

    private[this] var _treeFieldTitle: String = treeFieldTitle

    def TreeFieldTitle = _treeFieldTitle

    def TreeFieldTitle_=(value: String) {
        if (_treeFieldTitle == value) return
        json("treeFieldTitle") = value
        _treeFieldTitle = value
    }

    private[this] var _treeRootValue: JsonObject = treeRootValue
    def TreeRootValue = _treeRootValue
    def TreeRootValue_=(value: JsonObject) {
        json("treeRootValue") = value
        _treeRootValue = value
    }

    def WillAcceptDrop = json.getFunctionExpressionOpt("willAcceptDrop").getOrElse(willAcceptDrop)
    def WillAcceptDrop_=(value: FunctionExpression) {
        if (WillAcceptDrop == value) return
        json("willAcceptDrop") = value
    }

}


