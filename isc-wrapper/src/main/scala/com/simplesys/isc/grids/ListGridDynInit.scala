package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.canvas.ImgPropertiesDyn
import com.simplesys.isc.dataBinging.{SortSpecifierDyn, DataBoundComponentDynInit, DataSourceDyn, DSRequestDyn}
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.control.ButtonDyn
import com.simplesys.isc.system.{MultiAutoChild, ArrayDyn, SelectionDyn}
import listGrid.{HeaderSpanDyn, ListGridFieldDyn}
import com.simplesys.json.{JsonElement, JsonNull, JsonObject, JsonList}
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.common.Strings._
import com.simplesys.isc.layout.VLayoutDynInit

trait ListGridDynInit extends VLayoutDynInit with DataBoundComponentDynInit {
    protected val allowFilterExpressions: Bool = false
    protected val alternateBodyStyleName: CSSStyleName = ""
    protected val alternateRecordFrequency: Number = 1
    protected val alternateRecordStyles: Bool = false
    protected val alwaysShowEditors: Bool = false
    protected val animateFolderEffect: AnimationAcceleration = anAcsNull
    protected val animateFolderMaxRows: Number = null
    protected val animateFolders: Bool = true
    protected val animateFolderSpeed: Number = 3000
    protected val animateFolderTime: Number = 100
    protected val animateRemoveRecord: Bool = true
    protected val animateRemoveSpeed: Number = 200
    protected val animateRemoveTime: Number = 100
    protected val animateRollOver: Bool = false
    protected val animateRollUnder: Bool = false
    protected val animateSelection: Bool = false
    protected val animateSelectionUnder: Bool = false
    protected val arrowKeyAction: String = "select"
    protected val autoFetchData: Bool = false
    protected val autoFetchDisplayMap: Bool = true
    protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleSubstring
    protected val autoFitAllText: String = "Auto Fit All Columns"
    protected val autoFitClipFields: JsonList = JsonList()
    protected val autoFitData: Autofit = aftNull
    protected val autoFitExpandField: String = ""
    protected val autoFitExtraRecords: Number = null
    protected val autoFitFieldsFillViewport: Bool = true
    protected val autoFitFieldText: String = "Auto Fit"
    protected val autoFitFieldWidths: Bool = null
    protected val autoFitIconFields: AutoFitIconFieldType = aftIcnFldTpTitle
    protected val autoFitMaxColumns: Number = 50
    protected val autoFitMaxHeight: Number = null
    protected val autoFitMaxRecords: Number = 50
    protected val autoFitMaxWidth: Number = null
    protected val autoFitWidthApproach: AutoFitWidthApproach = aftWdAprchValue
    protected val autoSaveEdits: Bool = true
    protected val backgroundComponent: CanvasDyn = null
    protected val baseStyle: CSSStyleName = ""
    protected val body: AutoChild = null
    protected val bodyBackgroundColor: Color = "white"
    protected val bodyOverflow: Overflow = ovAuto
    protected val bodyStyleName: CSSStyleName = ""
    protected val booleanFalseImage: SCImgURL = JsonNull
    protected val booleanImageHeight: Number = 16
    protected val booleanImageWidth: Number = 16
    protected val booleanPartialImage: SCImgURL = JsonNull
    protected val booleanTrueImage: SCImgURL = JsonNull
    protected val canAcceptDroppedRecords: Bool = false
    protected val canAutoFitFields: Bool = true
    protected val cancelEditingConfirmationMessage: JsonElement = "Cancelling this edit will discard unsaved changes for this record. Continue?"
    protected val canCollapseGroup: Bool = true
    protected val canDragRecordsOut: Bool = false
    protected val canDragSelect: Bool = false
    private[grids] val canDragSelectText: JsonElement = JsonNull
    protected val canEdit: JsonElement = false
    protected val canExpandMultipleRecords: Bool = true
    protected val canExpandRecordProperty: String = "canExpand"
    protected val canExpandRecords: Bool = false
    protected val canFreezeFields: Bool = false
    protected val canGroupBy: Bool = true
    override protected val canHover: Bool = false
    protected val canMultiSort: Bool = true
    protected val canPickFields: Bool = true
    protected val canPickOmittedFields: Bool = false
    protected val canRemoveRecords: Bool = false
    protected val canReorderFields: Bool = true
    protected val canReorderRecords: Bool = false
    protected val canResizeFields: Bool = true
    protected val canSelectCells: JsonElement = JsonNull
    protected val canSelectAll: Bool = false
    protected val canSort: Bool = true
    protected val canTabToHeader: Bool = false
    protected val cellHeight: Number = 20
    protected val cellPadding: Number = 2
    protected val cellSelectionChanged: FunctionExpression = null
    protected val chartConstructor: SCClassName = "FacetChart"
    protected val chartType: ChartType = chrtTpColumn
    protected val checkboxField: AutoChild = null
    protected val checkboxFieldFalseImage: SCImgURL = JsonNull
    protected val checkboxFieldImageHeight: Number = null
    protected val checkboxFieldImageWidth: Number = null
    protected val checkboxFieldPartialImage: SCImgURL = JsonNull
    protected val checkboxFieldTrueImage: SCImgURL = JsonNull
    protected val childExpansionMode: ExpansionMode = expnsModeNull
    protected val clearAllSortingText: String = "Clear All Sorting"
    protected val clearFilterText: String = "Clear Filter"
    protected val clearSortFieldText: String = "Clear Sort"
    protected val configureSortText: String = "Configure Sort"
    protected val confirmCancelEditing: Bool = false
    protected val confirmDiscardEdits: Bool = true
    protected val confirmDiscardEditsMessage: String = "This action will discard unsaved changes for this list."
    private[grids] val createRecordComponent: FunctionExpression = null
    protected val data: JsonElement = JsonNull
    private[grids] val dataProperties: JsonElement = JsonNull
    protected val dateFormatter: DateDisplayFormat = ddfNull
    protected val dateInputFormat: String = ""
    protected val datetimeFormatter: DateDisplayFormat = ddfNull
    protected val defaultFields: ArrayDyn[ListGridFieldDyn] = null
    protected val deferRemoval: Bool = false
    protected val detailDS: String = ""
    private[grids] val detailField: JsonElement = strEmpty
    protected val discardEditsSaveButtonTitle: String = "Save"
    protected val dragTrackerMode: DragTrackerMode = drgTrcModeIcon
    protected val drawAheadRatio: Number = 1.3
    protected val drawAllMaxCells: Number = 250
    protected val editByCell: JsonElement = false
    protected val editComplete: FunctionExpression = null
    protected val editFailed: FunctionExpression = null
    protected val editEvent: ListGridEditEvent = lstGrdEvntDoubleClick
    protected val editFailedBaseStyle: CSSStyleName = ""
    protected val editFailedCSSText: String = "color:red;border:1px solid red;"
    protected val editOnF2Keypress: Bool = true
    protected val editOnFocus: Bool = false
    protected val editPendingBaseStyle: CSSStyleName = ""
    protected val editPendingCSSText: String = "color:#0066CC;"
    protected val emptyCellValue: HTMLString = " "
    protected val emptyMessage: JsonElement = "No items to show."
    protected val emptyMessageStyle: CSSStyleName = "emptyMessage"
    protected val enforceVClipping: Bool = false
    protected val enterKeyEditAction: EnterKeyEditAction = entrKeyEdActDone
    protected val enumCriteriaAsInitialValues: Bool = true
    protected val escapeKeyEditAction: EscapeKeyEditAction = escKeyEdActCancel
    protected val expansionCanEdit: Bool = false
    protected val expansionDetailField: AutoChild = null
    protected val expansionDetailRelated: AutoChild = null
    protected val expansionDetails: AutoChild = null
    protected val expansionEditor: AutoChild = null
    protected val expansionEditorSaveDialogPrompt: String = "You have unsaved changes - do you want to save them now?"
    protected val expansionField: JsonElement = JsonNull
    protected val expansionFieldFalseImage: SCImgURL = JsonNull
    protected val expansionFieldImageHeight: Number = null
    protected val expansionFieldImageWidth: Number = null
    protected val expansionFieldTrueImage: SCImgURL = JsonNull
    protected val expansionLayout: AutoChild = null
    protected val expansionMode: ExpansionMode = expnsModeNull
    protected val expansionRelated: AutoChild = null
    protected val exportRawValues: Bool = false
    protected val fastCellUpdates: Bool = true
    protected val fetchDelay: Number = 300
    protected val fieldVisibilitySubmenuTitle: String = "Columns"
    protected val filterButtonPrompt: String = "Filter"
    protected val filterButtonProperties: ButtonDyn = null
    protected val filterByCell: Bool = false
    protected val filterEditor: JsonElement = JsonNull
    protected val filterEditorHeight: Number = 22
    protected val filterOnKeypress: Bool = false
    protected val fixedFieldWidths: Bool = true
    protected val fixedRecordHeights: JsonElement = true
    protected val freezeFieldText: String = "Freeze ${title}"
    protected val freezeOnLeftText: String = "Freeze on left"
    protected val freezeOnRightText: String = "Freeze on right"
    protected val frozenBaseStyle: String = ""
    protected val frozenHeaderBaseStyle: CSSStyleName = ""
    protected val frozenHeaderTitleStyle: CSSStyleName = ""
    protected val generateClickOnEnter: Bool = false
    protected val generateClickOnSpace: Bool = true
    protected val generateDoubleClickOnEnter: Bool = true
    protected val generateDoubleClickOnSpace: Bool = false
    protected val gridComponents: ListGridComponent = lstGrdCompNull
    protected val gridSummaryRecordProperty: String = "isGridSummary"
    protected val groupByField: JsonElement = JsonNull
    protected val groupByFieldSummaries: JsonList = JsonList()
    protected val groupByMaxRecords: Number = 1000
    protected val groupByText: String = "Group by ${title}"
    protected val groupIcon: SCImgURL = "[SKINIMG]/TreeGrid/opener.gif"
    protected val groupIconSize: Number = 16
    protected val groupIndentSize: Number = 20
    protected val groupLeadingIndent: Number = 10
    protected val groupNodeStyle: String = "groupNode"
    protected val groupStartOpen: GroupStartOpen = grpStrtOpnNone
    protected val groupSummaryRecordProperty: String = "isGroupSummary"
    protected val groupSummaryStyle: CSSStyleName = "gridSummaryCell"
    protected val groupTitleColumnDefaults: ListGridFieldDyn = null
    protected val groupTitleColumnProperties: ListGridFieldDyn = null
    protected val groupTitleField: String = ""
    protected val groupTree: AutoChild = null
    protected val header: AutoChild = null
    protected val headerAutoFitEvent: AutoFitEvent = atFtEvntDoubleClick
    protected val headerBackgroundColor: Color = "#CCCCCC"
    protected val headerBarStyle: CSSStyleName = ""
    protected val headerBaseStyle: CSSStyleName = ""
    protected val headerButtonConstructor: SCClassName = ""
    protected val headerButtonDefaults: ButtonDyn = null
    protected val headerButtonProperties: ButtonDyn = null
    protected val headerHeight: Number = 22
    protected val headerMenuButton: AutoChild = null
    protected val headerMenuButtonConstructor: SCClassName = ""
    protected val headerMenuButtonHeight: Number = "100%"
    protected val headerMenuButtonIcon: URL = "[SKIN]/ListGrid/sort_descending.gif".url
    protected val headerMenuButtonIconHeight: Number = 7
    protected val headerMenuButtonIconWidth: Number = 7
    protected val headerMenuButtonWidth: Number = 16
    protected val headerSpan: AutoChild = null
    protected val headerSpanConstructor: SCClassName = ""
    protected val headerSpanHeight: Number = null
    protected val headerSpans: ArrayDyn[HeaderSpanDyn] = null
    protected val headerSpanVAlign: AlignmentDyn = AlCenter
    protected val headerTitleStyle: CSSStyleName = ""
    override protected val height: Number = null
    protected val hoverMode: HoverMode = hvrMdNull
    override protected val hoverStyle: CSSStyleName = "gridHover"
    protected val imageSize: Number = 16
    protected val includeInSummaryProperty: String = "includeInSummary"
    private[grids] val initialCriteria: JsonElement = JsonNull
    protected val initialSort: ArrayDyn[SortSpecifierDyn] = null
    private[grids] val invalidateCache: FunctionExpression = null
    protected val instantScrollTrackRedraw: Bool = true
    protected val invalidSummaryValue: String = "&nbsp;"
    protected val isGrouped: Bool = false
    protected val isSeparatorProperty: String = "isSeparator"
    protected val leaveHeaderMenuButtonSpace: Bool = false
    override protected val leaveScrollbarGap: Bool = true
    override protected val left: Number = null
    protected val linkTextProperty: String = "linkText"
    protected val listEndEditAction: RowEndEditAction = rwEndEdActNull
    protected val loadingDataMessage: HTMLString = "${loadingImage}&nbsp;Loading data..."
    protected val loadingDataMessageStyle: CSSStyleName = "loadingDataMessage"
    protected val loadingMessage: String = "&nbsp;"
    protected val locateColumnsBy: String = ""
    protected val locateRowsBy: String = ""
    protected val longTextEditorThreshold: Number = 255
    protected val longTextEditorType: String = "PopUpTextAreaItem"
    protected val maxExpandedRecords: Number = null
    protected val maxExpandedRecordsPrompt: String = "This grid is limited to ${count} simultaneously expanded records. Please collapse some expanded records and retry."
    protected val minFieldWidth: Number = 15
    protected val modalEditing: Bool = null
    protected val neverValidate: Bool = false
    protected val normalBaseStyle: CSSStyleName = "cell"
    protected val normalCellHeight: Number = 20
    protected val nullGroupTitle: String = "-none-"
    protected val offlineMessageStyle: CSSStyleName = "offlineMessage"
    protected val originalData: JsonObject = JsonObject()
    protected val poolComponentsPerColumn: Bool = true
    protected val printAutoFit: Bool = true
    protected val printBaseStyle: CSSStyleName = ""
    protected val printHeaderStyle: CSSStyleName = "printHeader"
    protected val printMaxRows: Number = 100
    protected val printWrapCells: Bool = true
    protected val quickDrawAheadRatio: Number = 1.0
    protected val recordBaseStyleProperty: String = "_baseStyle"
    protected val recordCanSelectProperty: String = "canSelect"
    protected val recordClick: FunctionExpression = null
    protected val recordComponentHeight: Number = null
    protected val recordComponentPoolingMode: RecordComponentPoolingMode = rcCmpPlMdViewport
    protected val recordComponentPosition: EmbeddedPosition = embPosNull
    protected val recordCustomStyleProperty: String = "customStyle"
    protected val recordDetailDSProperty: String = "detailDS"
    protected val recordEditProperty: String = "_canEdit"
    protected val recordEnabledProperty: String = "enabled"
    protected val recordSummaryBaseStyle: CSSStyleName = "recordSummaryCell"
    protected val removedCSSText: String = "text-decoration:line-through;"
    protected val removeFieldDefaults: ListGridFieldDyn = null
    protected val removeFieldProperties: ListGridFieldDyn = null
    protected val removeFieldTitle: String = "[Remove record]"
    protected val removeIcon: SCImgURL = "[SKIN]/actions/remove.png"
    protected val removeIconSize: Number = 16
    protected val resizeFieldsInRealTime: FunctionExpression = "Browser.isIE && isc.Browser.isWin"
    protected val rollOverCanvas: AutoChild = null
    protected val rollUnderCanvas: AutoChild = null
    protected val rowEndEditAction: RowEndEditAction = rwEndEdActNull
    protected val rowNumberField: ListGridFieldDyn = null
    protected val rowNumberStart: Number = 1
    protected val rowNumberStyle: CSSStyleName = "cellDark"
    protected val saveByCell: Bool = false
    protected val saveLocally: Bool = false
    protected val saveRequestProperties: DSRequestDyn = null
    protected val scrollRedrawDelay: Number = 75
    protected val selection: SelectionDyn = null
    protected val selectionAppearance: SelectionAppearance = slAppearRowStyle
    protected val selectionCanvas: AutoChild = null
    protected val selectionProperty: String = ""
    protected val selectionType: SelectionStyle = slStlNull
    protected val selectionUnderCanvas: AutoChild = null
    protected val selectOnEdit: Bool = true
    protected val selectionChanged: FunctionExpression = null
    protected val selectRecord: FunctionExpression = null
    protected val showAllColumns: Bool = false
    protected val showAllRecords: Bool = false
    protected val showBackgroundComponent: Bool = false
    protected val showCellContextMenus: Bool = false
    override protected val showDetailFields: Bool = true
    protected val showEmptyMessage: Bool = true
    protected val showFilterEditor: Bool = false
    protected val showGridSummary: Bool = false
    protected val showGroupSummary: Bool = false
    protected val showGroupSummaryInHeader: Bool = false
    protected val showGroupTitleColumn: Bool = true
    protected val showHeader: Bool = true
    protected val showHeaderContextMenu: Bool = true
    protected val showHeaderMenuButton: Bool = false
    override protected val showHover: Bool = true
    override protected val showHoverComponents: Bool = false
    protected val showRecordComponents: Bool = false
    protected val showRecordComponentsByCell: Bool = false
    protected val showRollOver: Bool = true
    protected val showRollOverCanvas: Bool = false
    protected val showRowNumbers: Bool = null
    private[grids] val showSelectedStyle: JsonElement = true
    protected val showSelectionCanvas: Bool = false
    protected val showSortArrow: SortArrow = srtArrNull
    protected val showSortNumerals: Bool = false
    protected val showTreeColumnPicker: Bool = true
    protected val shrinkForFreeze: Bool = false
    protected val singleCellValueProperty: String = "singleCellValue"
    override protected val skinImgDir: URL = "images/ListGrid/".url
    protected val sortAscendingImage: ImgPropertiesDyn = null
    protected val sortDescendingImage: ImgPropertiesDyn = null
    protected val sortDirection: SortDirection = srtDirAscending
    protected val sorterConstructor: SCClassName = "Button"
    protected val sorterDefaults: JsonObject = JsonObject()
    protected val sorterProperties: ButtonDyn = null
    protected val sortField: Number = null
    protected val sortFieldAscendingText: String = "Sort Ascending"
    protected val sortFieldDescendingText: String = "Sort Descending"
    protected val sortFieldNum: Number = null
    protected val sortNumeralStyle: CSSStyleName = "sortNumeral"
    protected val stopOnErrors: Bool = false
    override protected val styleName: CSSStyleName = "listGrid"
    protected val summaryRow: AutoChild = null
    protected val summaryRowCriteria: CriteriaDyn = null
    protected val summaryRowDataSource: DataSourceDyn = null
    protected val summaryRowFetchRequestProperties: DSRequestDyn = null
    protected val summaryRowHeight: Number = 20
    protected val summaryRowStyle: CSSStyleName = "gridSummaryCell"
    protected val tallBaseStyle: CSSStyleName = "cell"
    protected val timeFormatter: TimeDisplayFormat = tmDspFmtToShortPaddedTime
    protected val trackerImage: ImgPropertiesDyn = null
    protected val unfreezeFieldText: String = "Unfreeze \\$title}"
    protected val ungroupText: String = "Ungroup"
    protected val unremoveIcon: SCImgURL = "[SKIN]/actions/undo.png"
    protected val unspannedHeaderVAlign: AlignmentDyn = ValAll
    private[grids] val updateRecordComponent: FunctionExpression = null
    protected val updateData: FunctionExpression = null
    protected val useCellRollOvers: Bool = false
    protected val useRemoteValidators: Bool = false
    protected val validateByCell: Bool = false
    protected val validateOnChange: Bool = false
    protected val valueIconHeight: Number = null
    protected val valueIconLeftPadding: Number = 2
    protected val valueIconRightPadding: Number = 2
    protected val valueIconSize: Number = 16
    protected val valueIconWidth: Number = null
    protected val virtualScrolling: Bool = false
    protected val waitForSave: Bool = false
    protected val warnOnRemoval: Bool = false
    protected val warnOnRemovalMessage: String = "Are you sure you want to delete this record?"
    protected val warnOnUnmappedValueFieldChange: Bool = true
    protected val wrapCells: Bool = true
    protected val expansionDetailFieldProperties = MultiAutoChild()
    protected val canSelectTextExpandedField: Bool = false
    protected val getExpansionComponent: FunctionExpression = null
    private[grids] val getBaseStyle: FunctionExpression = null
    private[grids] val getExpansionComponent1: JsonElement = JsonNull
    private[grids] val collapseRecord: FunctionExpression = null
    private[grids] val focusChanged: FunctionExpression = null
    private[grids] val clientOnly: JsonElement = JsonNull
    private[grids] val cellClick: FunctionExpression = null
    private[grids] val masterGrid: JsonElement =  JsonNull
    private[grids] val rowClick: JsonElement = JsonNull
    private[grids] val rowContextClick: JsonElement = JsonNull
}