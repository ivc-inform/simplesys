package com.simplesys.isc.forms

import com.simplesys.isc.dataBinging.DataBoundComponentDynInit
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{UnquotedString, JsonObject, JsonList}
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.foundation.CanvasDynInit
import com.simplesys.isc.system.ArrayDyn
import formItems.FormItemDyn


trait DynamicFormDynInit extends CanvasDynInit with DataBoundComponentDynInit {
    protected val action: String = "#"
    protected val allowExpressions: Bool = null
    protected val autoFetchData: Bool = false
    protected val autoFetchTextMatchStyle: TextMatchStyle = txtMchStyleNull
    protected val autoFocus: Bool = false
    protected val browserSpellCheck: Bool = true
    protected val cancelParamName: String = "org.apache.struts.taglib.html.CANCEL"
    protected val cancelParamValue: String = "cancel"
    protected val canEdit: Bool = null
    override protected val canFocus: Bool = true
    protected val canSubmit: Bool = false
    protected val canTabToSectionHeaders: Bool = null
    protected val cellBorder: Number = 0
    protected val cellPadding: Number = 2
    protected val itemChanged: FunctionExpression = null
    protected val colWidths: JsonList = null
    protected val dateFormatter: DateDisplayFormat = ddfNull
    protected val datetimeFormatter: DateDisplayFormat = ddfNull
    protected val disableValidation: Bool = null
    protected val encoding: Encoding = encdNormal
    protected val errorItemCellStyle: String = "formCellError"
    protected val errorItemProperties: JsonObject = JsonObject()
    protected val errorOrientation: AlignmentDyn = AlLeft
    protected val errors: JsonList = JsonList()
    protected val errorsPreamble: String = "The following errors were found"
    protected val fixedColWidths: Bool = false
    protected val formSubmitFailedWarning: String = "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
    protected val hiliteRequiredFields: Bool = true
    protected val implicitSave: Bool = false
    protected val implicitSaveDelay: Number = 2000
    protected val implicitSaveOnBlur: Bool = false
    protected val initialCriteria: CriteriaDyn = null
    protected val itemHoverAlign: AlignmentDyn = AlNull
    protected val itemHoverDelay: Number = 500
    protected val itemHoverHeight: Number = null
    protected val itemHoverOpacity: Number = null
    protected val itemHoverStyle: CSSStyleName = "formHover"
    protected val itemHoverVAlign: Number = null
    protected val itemHoverWidth: Number = null
    protected val itemLayout: FormLayoutType = frmLtTable
    protected val items: ArrayDyn[FormItemDyn] = null
    protected val longTextEditorThreshold: Number = 255
    protected val longTextEditorType: String = "textArea"
    protected val method: FormMethod = frmMthPOST
    protected val minColWidth: Number = 20
    protected val nestedEditorType: String = "NestedEditorItem"
    protected val nestedListEditorType: String = "NestedListEditorItem"
    protected val numCols: Number = 2
    protected val operator: OperatorId = opIdAnd
    protected val rejectInvalidValueOnChange: Bool = null
    protected val requiredMessage: HTMLString = ""
    protected val requiredRightTitlePrefix: HTMLString = "<b>: "
    protected val requiredTitlePrefix: HTMLString = "<b>"
    protected val requiredTitleSuffix: HTMLString = " :</b>"
    protected val rightTitlePrefix: HTMLString = ": "
    protected val rightTitleSuffix: HTMLString = ""
    protected val saveOnEnter: Bool = false
    protected val saveOperationType: DSOperationType = dsOptTypeNull
    protected val sectionVisibilityMode: VisibilityMode = vsbMdMultiple
    protected val selectOnFocus: Bool = false
    protected val showComplexFieldsRecursively: Bool = null
    override protected val showDetailFields: Bool = true
    protected val showErrorIcons: Bool = true
    protected val showErrorStyle: Bool = true
    protected val showErrorText: Bool = false
    protected val showInlineErrors: Bool = true
    protected val showTitlesWithErrorMessages: Bool = false
    protected val stopOnError: Bool = null
    protected val suppressValidationErrorCallback: Bool = false
    protected val synchronousValidation: Bool = false
    protected val target: String = ""
    protected val timeFormatter: TimeDisplayFormat = tmDspFmtNull
    protected val titleAlign: AlignmentDyn = AlNull
    protected val titleOrientation: TitleOrientation = ttlOrntLeft
    protected val titlePrefix: HTMLString = ""
    protected val titleSuffix: HTMLString = " :"
    protected val titleWidth: Number = 100
    protected val validateOnChange: Bool = false
    protected val validateOnExit: Bool = false
    protected val validationURL: UnquotedString = null
    private[forms] val values: JsonObject = JsonObject()
    protected val wrapItemTitles: Bool = null
    private[forms] val numRows: Number = 0
}