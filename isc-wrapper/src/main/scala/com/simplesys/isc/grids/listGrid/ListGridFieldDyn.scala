package com.simplesys.isc.grids.listGrid

import com.simplesys.json.{JsonElement, JsonString, JsonList, JsonObject}
import com.simplesys.isc.system.{ClassDyn, ArrayDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.forms.formItems.FormItemDyn
import com.simplesys.isc.forms.formItems.formItem.FormItemIconDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.{DSRequestDyn, DataSourceDyn}
import com.simplesys.isc.forms.ValidatorDyn

object ListGridFieldDyn {

    implicit def ListGridFieldtoJsonObject(in: ListGridFieldDyn): JsonObject = in json
}

class ListGridFieldDyn extends ClassDyn with ListGridFieldDynInit {

    def Align = json.getValue2[JsonString, AlignmentDyn]("align").getOrElse(align)
    def Align_=(value: AlignmentDyn) {
        if (Align == value) return
        json("align") = value
    }

    private[this] var _formatCellValue: FunctionExpression = formatCellValue
    def FormatCellValue = _formatCellValue
    def FormatCellValue_=(value: FunctionExpression) {
        if (_formatCellValue == value) return
        json("formatCellValue") = value
        _formatCellValue = value
    }

    private[this] var _autoFetchDisplayMap: Bool = autoFetchDisplayMap
    def AutoFetchDisplayMap = _autoFetchDisplayMap
    def AutoFetchDisplayMap_=(value: Bool) {
        if (_autoFetchDisplayMap == value) return
        json("autoFetchDisplayMap") = value
        _autoFetchDisplayMap = value
    }

    private[this] var _autoFitWidth: Bool = autoFitWidth
    def AutoFitWidth = _autoFitWidth
    def AutoFitWidth_=(value: Bool) {
        if (_autoFitWidth == value) return
        json("autoFitWidth") = value
        _autoFitWidth = value
    }

    private[this] var _autoFitWidthApproach: AutoFitWidthApproach = autoFitWidthApproach
    def AutoFitWidthApproach = _autoFitWidthApproach
    def AutoFitWidthApproach_=(value: AutoFitWidthApproach) {
        if (_autoFitWidthApproach == value) return
        json("autoFitWidthApproach") = value
        _autoFitWidthApproach = value
    }

    private[this] var _autoFreeze: Bool = autoFreeze
    def AutoFreeze = _autoFreeze
    def AutoFreeze_=(value: Bool) {
        if (_autoFreeze == value) return
        json("autoFreeze") = value
        _autoFreeze = value
    }

    private[this] var _baseStyle: SCClassName = baseStyle
    def BaseStyle = _baseStyle
    def BaseStyle_=(value: SCClassName) {
        if (_baseStyle == value) return
        json("baseStyle") = value
        _baseStyle = value
    }

    private[this] var _canDragResize: Bool = canDragResize
    def CanDragResize = _canDragResize
    def CanDragResize_=(value: Bool) {
        if (_canDragResize == value) return
        json("canDragResize") = value
        _canDragResize = value
    }

    def CanEdit = json.getBoolOpt("canEdit").getOrElse(canEdit)
    def CanEdit_=(value: Bool) {
        if (CanEdit == value) return
        json("canEdit") = value
    }

    def CanExport = json.getBoolOpt("canExport").getOrElse(canExport)
    def CanExport_=(value: Bool) {
        if (CanExport == value) return
        json("canExport") = value
    }

    def CanFilter = json.getBoolOpt("canFilter").getOrElse(canFilter)
    def CanFilter_=(value: Bool) {
        if (CanFilter == value) return
        json("canFilter") = value
    }

    private[this] var _canFreeze: Bool = canFreeze
    def CanFreeze = _canFreeze
    def CanFreeze_=(value: Bool) {
        if (_canFreeze == value) return
        json("canFreeze") = value
        _canFreeze = value
    }

    private[this] var _canGroupBy: Bool = canGroupBy
    def CanGroupBy = _canGroupBy
    def CanGroupBy_=(value: Bool) {
        if (_canGroupBy == value) return
        json("canGroupBy") = value
        _canGroupBy = value
    }

    private[this] var _canHide: Bool = canHide
    def CanHide = _canHide
    def CanHide_=(value: Bool) {
        if (_canHide == value) return
        json("canHide") = value
        _canHide = value
    }

    private[this] var _canHilite: Bool = canHilite
    def CanHilite = _canHilite
    def CanHilite_=(value: Bool) {
        if (_canHilite == value) return
        json("canHilite") = value
        _canHilite = value
    }

    def CellChanged = json.getFunctionExpressionOpt("cellChanged").getOrElse(cellChanged)
    def CellChanged_=(value: FunctionExpression) {
        if (CellChanged == value) return
        json("cellChanged") = value
    }

    def Changed = json.getFunctionExpressionOpt("changed").getOrElse(changed)
    def Changed_=(value: FunctionExpression) {
        if (Changed == value) return
        json("changed") = value
    }

    private[this] var _canReorder: Bool = canReorder
    def CanReorder = _canReorder
    def CanReorder_=(value: Bool) {
        if (_canReorder == value) return
        json("canReorder") = value
        _canReorder = value
    }

    private[this] var _canSort: Bool = canSort
    def CanSort = _canSort
    def CanSort_=(value: Bool) {
        if (_canSort == value) return
        json("canSort") = value
        _canSort = value
    }

    def CanSortClientOnly = json.getBoolOpt("canSortClientOnly").getOrElse(canSortClientOnly)
    def CanSortClientOnly_=(value: Bool) {
        if (CanSortClientOnly == value) return
        json("canSortClientOnly") = value
    }

    private[this] var _canToggle: Bool = canToggle
    def CanToggle = _canToggle
    def CanToggle_=(value: Bool) {
        if (_canToggle == value) return
        json("canToggle") = value
        _canToggle = value
    }

    private[this] var _cellAlign: AlignmentDyn = cellAlign
    def CellAlign = _cellAlign
    def CellAlign_=(value: AlignmentDyn) {
        if (_cellAlign == value) return
        json("cellAlign") = value
        _cellAlign = value
    }

    private[this] var _cellIcon: SCImgURL = cellIcon
    def CellIcon = _cellIcon
    def CellIcon_=(value: SCImgURL) {
        if (_cellIcon == value) return
        json("cellIcon") = value
        _cellIcon = value
    }

    def DataPath = json.getStringOpt("dataPath").getOrElse(dataPath)
    def DataPath_=(value: String) {
        if (DataPath == value) return
        json("dataPath") = value
    }

    def DateFormatter = json.getValue2[JsonString, DateDisplayFormat]("dateFormatter").getOrElse(dateFormatter)
    def DateFormatter_=(value: DateDisplayFormat) {
        if (DateFormatter == value) return
        json("dateFormatter") = value
    }

    def DecimalPad = json.getNumberOpt("decimalPad").getOrElse(decimalPad)
    def DecimalPad_=(value: Number) {
        if (DecimalPad == value) return
        json("decimalPad") = value
    }

    def DecimalPrecision = json.getNumberOpt("decimalPrecision").getOrElse(decimalPrecision)
    def DecimalPrecision_=(value: Number) {
        if (DecimalPrecision == value) return
        json("decimalPrecision") = value
    }

    private[this] var _defaultFilterValue: JsonObject = defaultFilterValue
    def DefaultFilterValue = _defaultFilterValue
    def DefaultFilterValue_=(value: JsonObject) {
        json("defaultFilterValue") = value
        _defaultFilterValue = value
    }

    private[this] var _defaultGroupingMode: String = defaultGroupingMode
    def DefaultGroupingMode = _defaultGroupingMode
    def DefaultGroupingMode_=(value: String) {
        if (_defaultGroupingMode == value) return
        json("defaultGroupingMode") = value
        _defaultGroupingMode = value
    }

    def DefaultIconSrc = json.getStringOpt("defaultIconSrc").getOrElse(defaultIconSrc)
    def DefaultIconSrc_=(value: String) {
        if (DefaultIconSrc == value) return
        json("defaultIconSrc") = value
    }

    def DefaultValue = json.getStringOpt("defaultValue").getOrElse(defaultValue)
    def DefaultValue_=(value: String) {
        if (DefaultValue == value) return
        json("defaultValue") = value
    }

    def DisplayField = json.getStringOpt("displayField").getOrElse(displayField)
    def DisplayField_=(value: String) {
        if (DisplayField == value) return
        json("displayField") = value
    }

    private[this] var _displayValueFromRecord: Bool = displayValueFromRecord
    def DisplayValueFromRecord = _displayValueFromRecord
    def DisplayValueFromRecord_=(value: Bool) {
        if (_displayValueFromRecord == value) return
        json("displayValueFromRecord") = value
        _displayValueFromRecord = value
    }

    private[this] var _editorIconHeight: Number = editorIconHeight
    def EditorIconHeight = _editorIconHeight
    def EditorIconHeight_=(value: Number) {
        if (_editorIconHeight == value) return
        json("editorIconHeight") = value
        _editorIconHeight = value
    }

    private[this] var _editorIconWidth: Number = editorIconWidth
    def EditorIconWidth = _editorIconWidth
    def EditorIconWidth_=(value: Number) {
        if (_editorIconWidth == value) return
        json("editorIconWidth") = value
        _editorIconWidth = value
    }

    private[this] var _editorImageURLPrefix: String = editorImageURLPrefix
    def EditorImageURLPrefix = _editorImageURLPrefix
    def EditorImageURLPrefix_=(value: String) {
        if (_editorImageURLPrefix == value) return
        json("editorImageURLPrefix") = value
        _editorImageURLPrefix = value
    }

    private[this] var _editorImageURLSuffix: String = editorImageURLSuffix
    def EditorImageURLSuffix = _editorImageURLSuffix
    def EditorImageURLSuffix_=(value: String) {
        if (_editorImageURLSuffix == value) return
        json("editorImageURLSuffix") = value
        _editorImageURLSuffix = value
    }

    private[this] var _editorProperties: FormItemDyn = editorProperties
    def EditorProperties = _editorProperties
    def EditorProperties_=(value: FormItemDyn) {
        if (_editorProperties == value) return
        json("editorProperties") = value
        _editorProperties = value
    }

    def EditorType = json.getStringOpt("editorType").getOrElse(editorType)
    def EditorType_=(value: String) {
        if (EditorType == value) return
        json("editorType") = value
    }

    private[this] var _editorValueIconHeight: Number = editorValueIconHeight
    def EditorValueIconHeight = _editorValueIconHeight
    def EditorValueIconHeight_=(value: Number) {
        if (_editorValueIconHeight == value) return
        json("editorValueIconHeight") = value
        _editorValueIconHeight = value
    }

    private[this] var _editorValueIcons: JsonObject = editorValueIcons
    def EditorValueIcons = _editorValueIcons
    def EditorValueIcons_=(value: JsonObject) {
        json("editorValueIcons") = value
        _editorValueIcons = value
    }

    private[this] var _editorValueIconWidth: Number = editorValueIconWidth
    def EditorValueIconWidth = _editorValueIconWidth
    def EditorValueIconWidth_=(value: Number) {
        if (_editorValueIconWidth == value) return
        json("editorValueIconWidth") = value
        _editorValueIconWidth = value
    }

    private[this] var _editorValueMap: JsonList = editorValueMap
    def EditorValueMap = _editorValueMap
    def EditorValueMap_=(value: JsonList) {
        if (_editorValueMap == value) return
        json("editorValueMap") = value
        _editorValueMap = value
    }

    private[this] var _emptyCellValue: HTMLString = emptyCellValue
    def EmptyCellValue = _emptyCellValue
    def EmptyCellValue_=(value: HTMLString) {
        if (_emptyCellValue == value) return
        json("emptyCellValue") = value
        _emptyCellValue = value
    }

    private[this] var _enterKeyEditAction: EnterKeyEditAction = enterKeyEditAction
    def EnterKeyEditAction = _enterKeyEditAction
    def EnterKeyEditAction_=(value: EnterKeyEditAction) {
        if (_enterKeyEditAction == value) return
        json("enterKeyEditAction") = value
        _enterKeyEditAction = value
    }

    def EscapeHTML = json.getBoolOpt("escapeHTML").getOrElse(escapeHTML)
    def EscapeHTML_=(value: Bool) {
        if (EscapeHTML == value) return
        json("escapeHTML") = value
    }

    private[this] var _escapeKeyEditAction: EscapeKeyEditAction = escapeKeyEditAction
    def EscapeKeyEditAction = _escapeKeyEditAction
    def EscapeKeyEditAction_=(value: EscapeKeyEditAction) {
        if (_escapeKeyEditAction == value) return
        json("escapeKeyEditAction") = value
        _escapeKeyEditAction = value
    }

    private[this] var _exportRawValues: Bool = exportRawValues
    def ExportRawValues = _exportRawValues
    def ExportRawValues_=(value: Bool) {
        if (_exportRawValues == value) return
        json("exportRawValues") = value
        _exportRawValues = value
    }

    private[this] var _filterEditorProperties: FormItemDyn = filterEditorProperties
    def FilterEditorProperties = _filterEditorProperties
    def FilterEditorProperties_=(value: FormItemDyn) {
        if (_filterEditorProperties == value) return
        json("filterEditorProperties") = value
        _filterEditorProperties = value
    }

    def FilterEditorType = json.getValue2[JsonObject, FormItemDyn]("filterEditorType").getOrElse(filterEditorType)
    def FilterEditorType_=(value: FormItemDyn) {
        if (FilterEditorType == value) return
        json("filterEditorType") = value
    }

    private[this] var _filterEditorValueMap: JsonObject = filterEditorValueMap
    def FilterEditorValueMap = _filterEditorValueMap
    def FilterEditorValueMap_=(value: JsonObject) {
        json("filterEditorValueMap") = value
        _filterEditorValueMap = value
    }

    private[this] var _filterOnKeypress: Bool = filterOnKeypress
    def FilterOnKeypress = _filterOnKeypress
    def FilterOnKeypress_=(value: Bool) {
        if (_filterOnKeypress == value) return
        json("filterOnKeypress") = value
        _filterOnKeypress = value
    }

    private[this] var _filterOperator: OperatorId = filterOperator
    def FilterOperator = _filterOperator
    def FilterOperator_=(value: OperatorId) {
        if (_filterOperator == value) return
        json("filterOperator") = value
        _filterOperator = value
    }

    private[this] var _formatGridSummary: FunctionExpression = formatGridSummary
    def FormatGridSummary = _formatGridSummary
    def FormatGridSummary_=(value: FunctionExpression) {
        if (_formatGridSummary == value) return
        json("formatGridSummary") = value
        _formatGridSummary = value
    }

    private[this] var _formatGroupSummary: FunctionExpression = formatGroupSummary
    def FormatGroupSummary = _formatGroupSummary
    def FormatGroupSummary_=(value: FunctionExpression) {
        if (_formatGroupSummary == value) return
        json("formatGroupSummary") = value
        _formatGroupSummary = value
    }

    private[this] var _frozen: Bool = frozen
    def Frozen = _frozen
    def Frozen_=(value: Bool) {
        if (_frozen == value) return
        json("frozen") = value
        _frozen = value
    }

    def Hidden = json.getBoolOpt("hidden").getOrElse(hidden)
    def Hidden_=(value: Bool) {
        if (Hidden == value) return
        json("hidden") = value
    }

    private[this] var _groupGranularity: Number = groupGranularity
    def GroupGranularity = _groupGranularity
    def GroupGranularity_=(value: Number) {
        if (_groupGranularity == value) return
        json("groupGranularity") = value
        _groupGranularity = value
    }

    private[this] var _groupingMode: String = groupingMode
    def GroupingMode = _groupingMode
    def GroupingMode_=(value: String) {
        if (_groupingMode == value) return
        json("groupingMode") = value
        _groupingMode = value
    }

    private[this] var _groupingModes: JsonList = groupingModes
    def GroupingModes = _groupingModes
    def GroupingModes_=(value: JsonList) {
        if (_groupingModes == value) return
        json("groupingModes") = value
        _groupingModes = value
    }

    private[this] var _groupPrecision: Number = groupPrecision
    def GroupPrecision = _groupPrecision
    def GroupPrecision_=(value: Number) {
        if (_groupPrecision == value) return
        json("groupPrecision") = value
        _groupPrecision = value
    }

    private[this] var _headerBaseStyle: CSSStyleName = headerBaseStyle
    def HeaderBaseStyle = _headerBaseStyle
    def HeaderBaseStyle_=(value: CSSStyleName) {
        if (_headerBaseStyle == value) return
        json("headerBaseStyle") = value
        _headerBaseStyle = value
    }

    private[this] var _headerTitleStyle: CSSStyleName = headerTitleStyle
    def HeaderTitleStyle = _headerTitleStyle
    def HeaderTitleStyle_=(value: CSSStyleName) {
        if (_headerTitleStyle == value) return
        json("headerTitleStyle") = value
        _headerTitleStyle = value
    }

    def HiliteIconHeight = json.getNumberOpt("hiliteIconHeight").getOrElse(hiliteIconHeight)
    def HiliteIconHeight_=(value: Number) {
        if (HiliteIconHeight == value) return
        json("hiliteIconHeight") = value
    }

    def HiliteIconLeftPadding = json.getNumberOpt("hiliteIconLeftPadding").getOrElse(hiliteIconLeftPadding)
    def HiliteIconLeftPadding_=(value: Number) {
        if (HiliteIconLeftPadding == value) return
        json("hiliteIconLeftPadding") = value
    }

    def HiliteIconPosition = json.getValue2[JsonString, HiliteIconPosition]("hiliteIconPosition").getOrElse(hiliteIconPosition)
    def HiliteIconPosition_=(value: HiliteIconPosition) {
        if (HiliteIconPosition == value) return
        json("hiliteIconPosition") = value
    }

    def HiliteIconRightPadding = json.getNumberOpt("hiliteIconRightPadding").getOrElse(hiliteIconRightPadding)
    def HiliteIconRightPadding_=(value: Number) {
        if (HiliteIconRightPadding == value) return
        json("hiliteIconRightPadding") = value
    }

    def HiliteIconSize = json.getNumberOpt("hiliteIconSize").getOrElse(hiliteIconSize)
    def HiliteIconSize_=(value: Number) {
        if (HiliteIconSize == value) return
        json("hiliteIconSize") = value
    }

    def HiliteIconWidth = json.getNumberOpt("hiliteIconWidth").getOrElse(hiliteIconWidth)
    def HiliteIconWidth_=(value: Number) {
        if (HiliteIconWidth == value) return
        json("hiliteIconWidth") = value
    }

    private[this] var _icon: SCImgURL = icon
    def Icon = _icon
    def Icon_=(value: SCImgURL) {
        if (_icon == value) return
        json("icon") = value
        _icon = value
    }

    private[this] var _iconOrientation: IconOrientation = iconOrientation
    def IconOrientation = _iconOrientation
    def IconOrientation_=(value: IconOrientation) {
        if (_iconOrientation == value) return
        json("iconOrientation") = value
        _iconOrientation = value
    }

    def Icons = json.getValue2[JsonList, ArrayDyn[FormItemIconDyn]]("icons").getOrElse(icons)
    def Icons_=(value: ArrayDyn[FormItemIconDyn]) {
        if (Icons == value) return
        json("icons") = value
    }

    private[this] var _iconSize: Number = iconSize
    def IconSize = _iconSize
    def IconSize_=(value: Number) {
        if (_iconSize == value) return
        json("iconSize") = value
        _iconSize = value
    }

    private[this] var _iconSpacing: Number = iconSpacing
    def IconSpacing = _iconSpacing
    def IconSpacing_=(value: Number) {
        if (_iconSpacing == value) return
        json("iconSpacing") = value
        _iconSpacing = value
    }

    def IconVAlign = json.getStringOpt("iconVAlign").getOrElse(iconVAlign)
    def IconVAlign_=(value: String) {
        if (IconVAlign == value) return
        json("iconVAlign") = value
    }

    def IconWidth = json.getNumberOpt("iconWidth").getOrElse(iconWidth)
    def IconWidth_=(value: Number) {
        if (IconWidth == value) return
        json("iconWidth") = value
    }

    def IgnoreKeyboardClicks = json.getBoolOpt("ignoreKeyboardClicks").getOrElse(ignoreKeyboardClicks)
    def IgnoreKeyboardClicks_=(value: Bool) {
        if (IgnoreKeyboardClicks == value) return
        json("ignoreKeyboardClicks") = value
    }

    def ImageHeight = json.getNumberOpt("imageHeight").getOrElse(imageHeight)
    def ImageHeight_=(value: Number) {
        if (ImageHeight == value) return
        json("imageHeight") = value
    }

    def ImageSize = json.getNumberOpt("imageSize").getOrElse(imageSize)
    def ImageSize_=(value: Number) {
        if (ImageSize == value) return
        json("imageSize") = value
    }

    def ImageURLPrefix = json.getStringOpt("imageURLPrefix").getOrElse(imageURLPrefix)
    def ImageURLPrefix_=(value: String) {
        if (ImageURLPrefix == value) return
        json("imageURLPrefix") = value
    }

    def ImageURLSuffix = json.getStringOpt("imageURLSuffix").getOrElse(imageURLSuffix)
    def ImageURLSuffix_=(value: String) {
        if (ImageURLSuffix == value) return
        json("imageURLSuffix") = value
    }

    def ImageWidth = json.getNumberOpt("imageWidth").getOrElse(imageWidth)
    def ImageWidth_=(value: Number) {
        if (ImageWidth == value) return
        json("imageWidth") = value
    }

    def IncludeFrom = json.getStringOpt("includeFrom").getOrElse(includeFrom)
    def IncludeFrom_=(value: String) {
        if (IncludeFrom == value) return
        json("includeFrom") = value
    }

    private[this] var _includeInRecordSummary: Bool = includeInRecordSummary
    def IncludeInRecordSummary = _includeInRecordSummary
    def IncludeInRecordSummary_=(value: Bool) {
        if (_includeInRecordSummary == value) return
        json("includeInRecordSummary") = value
        _includeInRecordSummary = value
    }

    private[this] var _includeInRecordSummaryFields: JsonList = includeInRecordSummaryFields
    def IncludeInRecordSummaryFields = _includeInRecordSummaryFields
    def IncludeInRecordSummaryFields_=(value: JsonList) {
        if (_includeInRecordSummaryFields == value) return
        json("includeInRecordSummaryFields") = value
        _includeInRecordSummaryFields = value
    }

    def InputFormat = json.getStringOpt("inputFormat").getOrElse(inputFormat)
    def InputFormat_=(value: DateInputFormat) {
        if (InputFormat == value) return
        json("inputFormat") = value
    }

    private[this] var _isRemoveField: Bool = isRemoveField
    def IsRemoveField = _isRemoveField
    def IsRemoveField_=(value: Bool) {
        if (_isRemoveField == value) return
        json("isRemoveField") = value
        _isRemoveField = value
    }

    def LeaveHeaderMenuButtonSpace = json.getBoolOpt("leaveHeaderMenuButtonSpace").getOrElse(leaveHeaderMenuButtonSpace)
    def LeaveHeaderMenuButtonSpace_=(value: Bool) {
        if (LeaveHeaderMenuButtonSpace == value) return
        json("leaveHeaderMenuButtonSpace") = value
    }

    private[this] var _linkText: String = linkText
    def LinkText = _linkText
    def LinkText_=(value: String) {
        if (_linkText == value) return
        json("linkText") = value
        _linkText = value
    }

    private[this] var _linkTextProperty: String = linkTextProperty
    def LinkTextProperty = _linkTextProperty
    def LinkTextProperty_=(value: String) {
        if (_linkTextProperty == value) return
        json("linkTextProperty") = value
        _linkTextProperty = value
    }

    private[this] var _linkURLPrefix: String = linkURLPrefix
    def LinkURLPrefix = _linkURLPrefix
    def LinkURLPrefix_=(value: String) {
        if (_linkURLPrefix == value) return
        json("linkURLPrefix") = value
        _linkURLPrefix = value
    }

    private[this] var _linkURLSuffix: String = linkURLSuffix
    def LinkURLSuffix = _linkURLSuffix
    def LinkURLSuffix_=(value: String) {
        if (_linkURLSuffix == value) return
        json("linkURLSuffix") = value
        _linkURLSuffix = value
    }

    def Multiple = json.getBoolOpt("multiple").getOrElse(multiple)
    def Multiple_=(value: Bool) {
        if (Multiple == value) return
        json("multiple") = value
    }

    def Name = json.getStringOpt("name").getOrElse(name)
    def Name_=(value: String) {
        if (Name == value) return
        json("name") = value
    }

    def OptionCriteria = json.getValue2[JsonObject, CriteriaDyn]("optionCriteria").getOrElse(optionCriteria)
    def OptionCriteria_=(value: CriteriaDyn) {
        if (OptionCriteria == value) return
        json("optionCriteria") = value
    }

    def OptionDataSource = json.getValue2[JsonObject, DataSourceDyn]("optionDataSource").getOrElse(optionDataSource)
    def OptionDataSource_=(value: DataSourceDyn) {
        if (OptionDataSource == value) return
        json("optionDataSource") = value
    }

    def OptionDataSource1 = json.getJsonElement("optionDataSource1").getOrElse(optionDataSource1)
    def OptionDataSource1_=(value: JsonElement) {
        if (OptionDataSource1 == value) return
        json("optionDataSource") = value
    }

    def OptionFilterContext = json.getValue2[JsonObject, DSRequestDyn]("optionFilterContext").getOrElse(optionFilterContext)
    def OptionFilterContext_=(value: DSRequestDyn) {
        if (OptionFilterContext == value) return
        json("optionFilterContext") = value
    }

    def OptionOperationId = json.getStringOpt("optionOperationId").getOrElse(optionOperationId)
    def OptionOperationId_=(value: String) {
        if (OptionOperationId == value) return
        json("optionOperationId") = value
    }

    private[this] var _optionTextMatchStyle: TextMatchStyle = optionTextMatchStyle
    def OptionTextMatchStyle = _optionTextMatchStyle
    def OptionTextMatchStyle_=(value: TextMatchStyle) {
        if (_optionTextMatchStyle == value) return
        json("optionTextMatchStyle") = value
        _optionTextMatchStyle = value
    }

    private[this] var _partialSummary: Bool = partialSummary
    def PartialSummary = _partialSummary
    def PartialSummary_=(value: Bool) {
        if (_partialSummary == value) return
        json("partialSummary") = value
        _partialSummary = value
    }

    def Prompt = json.getBoolOpt("prompt").getOrElse(prompt)
    def Prompt_=(value: Bool) {
        if (Prompt == value) return
        json("prompt") = value
    }

    private[this] var _recordSummaryFunction: RecordSummaryFunction = recordSummaryFunction
    def RecordSummaryFunction = _recordSummaryFunction
    def RecordSummaryFunction_=(value: RecordSummaryFunction) {
        if (_recordSummaryFunction == value) return
        json(" recordSummaryFunction") = value
        _recordSummaryFunction = value
    }

    private[this] var _shouldPrint: Bool = shouldPrint
    def ShouldPrint = _shouldPrint
    def ShouldPrint_=(value: Bool) {
        if (_shouldPrint == value) return
        json("shouldPrint") = value
        _shouldPrint = value
    }

    private[this] var _showAlternateStyle: Bool = showAlternateStyle
    def ShowAlternateStyle = _showAlternateStyle
    def ShowAlternateStyle_=(value: Bool) {
        if (_showAlternateStyle == value) return
        json("showAlternateStyle") = value
        _showAlternateStyle = value
    }

    private[this] var _showDefaultContextMenu: Bool = showDefaultContextMenu
    def ShowDefaultContextMenu = _showDefaultContextMenu
    def ShowDefaultContextMenu_=(value: Bool) {
        if (_showDefaultContextMenu == value) return
        json("showDefaultContextMenu") = value
        _showDefaultContextMenu = value
    }

    private[this] var _showDisabledIcon: Bool = showDisabledIcon
    def ShowDisabledIcon = _showDisabledIcon
    def ShowDisabledIcon_=(value: Bool) {
        if (_showDisabledIcon == value) return
        json("showDisabledIcon") = value
        _showDisabledIcon = value
    }

    private[this] var _showDownIcon: Bool = showDownIcon
    def ShowDownIcon = _showDownIcon
    def ShowDownIcon_=(value: Bool) {
        if (_showDownIcon == value) return
        json("showDownIcon") = value
        _showDownIcon = value
    }

    def ShowFileInline = json.getBoolOpt("showFileInline").getOrElse(showFileInline)
    def ShowFileInline_=(value: Bool) {
        if (ShowFileInline == value) return
        json("showFileInline") = value
    }

    private[this] var _showFocusedIcon: Bool = showFocusedIcon
    def ShowFocusedIcon = _showFocusedIcon
    def ShowFocusedIcon_=(value: Bool) {
        if (_showFocusedIcon == value) return
        json("showFocusedIcon") = value
        _showFocusedIcon = value
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

    private[this] var _showHover: Bool = showHover
    def ShowHover = _showHover
    def ShowHover_=(value: Bool) {
        if (_showHover == value) return
        json("showHover") = value
        _showHover = value
    }

    private[this] var _showRollOverIcon: Bool = showRollOverIcon
    def ShowRollOverIcon = _showRollOverIcon
    def ShowRollOverIcon_=(value: Bool) {
        if (_showRollOverIcon == value) return
        json("showRollOverIcon") = value
        _showRollOverIcon = value
    }

    private[this] var _showSelectedIcon: Bool = showSelectedIcon
    def ShowSelectedIcon = _showSelectedIcon
    def ShowSelectedIcon_=(value: Bool) {
        if (_showSelectedIcon == value) return
        json("showSelectedIcon") = value
        _showSelectedIcon = value
    }

    def ShowTitle = json.getBoolOpt("showTitle").getOrElse(showTitle)
    def ShowTitle_=(value: Bool) {
        if (ShowTitle == value) return
        json("showTitle") = value
    }

    def ShowValueIconOnly = json.getBoolOpt("showValueIconOnly").getOrElse(showValueIconOnly)
    def ShowValueIconOnly_=(value: Bool) {
        if (ShowValueIconOnly == value) return
        json("showValueIconOnly") = value
    }

    private[this] var _sortByDisplayField: Bool = sortByDisplayField
    def SortByDisplayField = _sortByDisplayField
    def SortByDisplayField_=(value: Bool) {
        if (_sortByDisplayField == value) return
        json("sortByDisplayField") = value
        _sortByDisplayField = value
    }

    def SortByMappedValue = json.getBoolOpt("sortByMappedValue").getOrElse(sortByMappedValue)
    def SortByMappedValue_=(value: Bool) {
        if (SortByMappedValue == value) return
        json("sortByMappedValue") = value
    }

    private[this] var _sortDirection: SortDirection = sortDirection
    def SortDirection = _sortDirection
    def SortDirection_=(value: SortDirection) {
        if (_sortDirection == value) return
        json("sortDirection") = value
        _sortDirection = value
    }

    def SummaryFunction = json.getJsonListOpt("summaryFunction").getOrElse(summaryFunction)
    def SummaryFunction_=(value: JsonList) {
        if (SummaryFunction == value) return
        json("summaryFunction") = value
    }

    private[this] var _summaryTitle: String = summaryTitle
    def SummaryTitle = _summaryTitle
    def SummaryTitle_=(value: String) {
        if (_summaryTitle == value) return
        json("summaryTitle") = value
        _summaryTitle = value
    }

    private[this] var _summaryValue: HTMLString = summaryValue
    def SummaryValue = _summaryValue
    def SummaryValue_=(value: HTMLString) {
        if (_summaryValue == value) return
        json("summaryValue") = value
        _summaryValue = value
    }

    def SummaryValueTitle = json.getStringOpt("summaryValueTitle").getOrElse(summaryValueTitle)
    def SummaryValueTitle_=(value: String) {
        if (SummaryValueTitle == value) return
        json("summaryValueTitle") = value
    }

    def SuppressValueIcon = json.getBoolOpt("suppressValueIcon").getOrElse(suppressValueIcon)
    def SuppressValueIcon_=(value: Bool) {
        if (SuppressValueIcon == value) return
        json("suppressValueIcon") = value
    }

    private[this] var _target: String = target
    def Target = _target
    def Target_=(value: String) {
        if (_target == value) return
        json("target") = value
        _target = value
    }

    def TimeFormatter = json.getValue2[JsonString, TimeDisplayFormat]("timeFormatter").getOrElse(timeFormatter)
    def TimeFormatter_=(value: TimeDisplayFormat) {
        if (TimeFormatter == value) return
        json("timeFormatter") = value
    }

    def Title = json.getStringOpt("title").getOrElse(title)
    def Title_=(value: String) {
        if (Title == value) return
        json("title") = value
    }

    def Type = json.getValue2[JsonString, ListGridFieldType]("type").getOrElse(`type`)
    def Type_=(value: ListGridFieldType) {
        if (Type == value) return
        json("type") = value
    }

    def UserFormula = json.getStringOpt("userFormula").getOrElse(userFormula)
    def UserFormula_=(value: UserFormula) {
        if (UserFormula == value) return
        json("userFormula") = value
    }

    def ValidateOnChange = json.getBoolOpt("validateOnChange").getOrElse(validateOnChange)
    def ValidateOnChange_=(value: Bool) {
        if (ValidateOnChange == value) return
        json("validateOnChange") = value
    }

    def Validators = json.getValue2[JsonList, ArrayDyn[ValidatorDyn]]("validators").getOrElse(validators)
    def Validators_=(value: ArrayDyn[ValidatorDyn]) {
        if (Validators == value) return
        json("validators") = value
    }

    def ValueField = json.getStringOpt("valueField").getOrElse(valueField)
    def ValueField_=(value: String) {
        if (ValueField == value) return
        json("valueField") = value
    }

    def ValueIconHeight = json.getNumberOpt("valueIconHeight").getOrElse(valueIconHeight)
    def ValueIconHeight_=(value: Number) {
        if (ValueIconHeight == value) return
        json("valueIconHeight") = value
    }

    def ValueIconLeftPadding = json.getNumberOpt("valueIconLeftPadding").getOrElse(valueIconLeftPadding)
    def ValueIconLeftPadding_=(value: Number) {
        if (ValueIconLeftPadding == value) return
        json("valueIconLeftPadding") = value
    }

    private[this] var _valueIconOrientation: String = valueIconOrientation
    def ValueIconOrientation = _valueIconOrientation
    def ValueIconOrientation_=(value: String) {
        if (_valueIconOrientation == value) return
        json("valueIconOrientation") = value
        _valueIconOrientation = value
    }


    def ValueIconRightPadding = json.getNumberOpt("valueIconRightPadding").getOrElse(valueIconRightPadding)
    def ValueIconRightPadding_=(value: Number) {
        if (ValueIconRightPadding == value) return
        json("valueIconRightPadding") = value
    }

    def ValueIcons = json.getJsonObjectOpt("valueIcons").getOrElse(valueIcons)
    def ValueIcons_=(value: JsonObject) {
        if (ValueIcons == value) return
        json("valueIcons") = value
    }

    def ValueIconSize = json.getNumberOpt("valueIconSize").getOrElse(valueIconSize)
    def ValueIconSize_=(value: Number) {
        if (ValueIconSize == value) return
        json("valueIconSize") = value
    }

    def ValueIconWidth = json.getNumberOpt("valueIconWidth").getOrElse(valueIconWidth)
    def ValueIconWidth_=(value: Number) {
        if (ValueIconWidth == value) return
        json("valueIconWidth") = value
    }

    def ValueMap = json.getJsonObjectOpt("valueMap").getOrElse(valueMap)
    def ValueMap_=(value: JsonObject) {
        if (ValueMap == value) return
        json("valueMap") = value
    }

    def Width = json.getNumberOpt("width").getOrElse(width)
    def Width_=(value: Number) {
        if (Width == value) return
        json("width") = value
    }
}

