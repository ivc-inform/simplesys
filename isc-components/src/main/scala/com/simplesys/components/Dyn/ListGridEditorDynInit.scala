package com.simplesys.components.Dyn

import com.simplesys.json.{JsonObject, JsonElement, JsonNull}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.ListGridDynInit
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.VLayoutDynInit
import com.simplesys.isc.dataBinging.SortSpecifierDyn
import com.simplesys.isc.system.{MultiAutoChild, ArrayDyn}
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.Number
import com.simplesys.components._

trait ListGridEditorDynInit extends VLayoutDynInit {
    override protected[Dyn] val autoDraw: Bool = false
    protected val emptyMessage: JsonElement = "<h1>Данных нет.</h1>"
    protected val cancelEditingConfirmationMessage: JsonElement = _cancelEditingConfirmationMessage
    protected val canEdit: JsonElement = JsonNull
    protected val editByCell: JsonElement = false
    protected val fields: JsonElement = JsonNull
    protected val defaultFields: JsonElement = JsonNull
    protected val dataSource: JsonElement = JsonNull
    protected val autoFetchData: Bool = true
    private[Dyn] val autoFitFieldWidths: Bool = true
    private[Dyn] val autoFitWidthApproach: AutoFitWidthApproach = aftWdAprchTitle
    private[Dyn] val autoSaveEdits: Boolean = true
    private[Dyn] val funcMenu: JsonElement = JsonNull
    private[Dyn] val showAdvancedFilter: Bool = false
    protected val editEvent: ListGridEditEvent = lstGrdEvntDoubleClick
    protected val showRowNumbers: Bool = true
    protected val modalEditing: Bool = true
    protected val canSelectCells: JsonElement = false
    private[Dyn] val data: JsonElement = JsonNull
    protected val dataPageSize: JsonElement = 75
    protected val drawAheadRatio: Number = 1.3
    protected val selectionType: SelectionStyle = slStlNull
    protected val createRecordComponent: FunctionExpression = null
    protected val showRecordComponents: Bool = false
    protected val showRecordComponentsByCell: Bool = false
    protected val initialSort: ArrayDyn[SortSpecifierDyn] = ArrayDyn.empty[SortSpecifierDyn]
    protected val showFilterEditor: Bool = true
    protected val fetchDelay: Number = 500
    protected val filterOnKeypress: Bool = true
    protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleSubstring
    private[Dyn] val wrapCells: JsonElement = false
    private[Dyn] val canDragSelectText: JsonElement = false
    private[Dyn] val expansionDetailFieldProperties: MultiAutoChild = MultiAutoChild()
    private[Dyn] val canSelectTextExpandedField: Bool = false
    private[Dyn] val fixedRecordHeights: JsonElement = false
    private[Dyn] val getExpansionComponent: FunctionExpression = null
    private[Dyn] val collapseRecord: FunctionExpression = null
    private[Dyn] val initialCriteria: JsonElement = JsonNull
    private[Dyn] val selectionAppearance: SelectionAppearance = slAppearRowStyle
    private[Dyn] val getBaseStyle: FunctionExpression = null
    private[Dyn] val cellClick: FunctionExpression = null
    private[Dyn] val recordComponentPoolingMode: RecordComponentPoolingMode = rcCmpPlMdViewport
    private[Dyn] val masterGrid: JsonElement = JsonNull
    private[Dyn] val canReorderRecords: Bool = false
}