package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.forms.{ValidatorDyn, DynamicFormDyn}
import com.simplesys.isc.foundation.CanvasDyn
import formItem.FormItemIconDyn
import com.simplesys.isc.dataBinging.RPC.RPCRequestDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.config.StoredData
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json._
import com.simplesys.isc.system.misc.XPathExpression
import com.simplesys.isc.system.misc.SCClassName
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName
import DateDisplayFormat._

trait FormItemDynInit extends StoredData {
    protected val accessKey: String = ""
    protected val align: AlignmentDyn = AlLeft
    protected val allowExpressions: Bool = false
    protected val alwaysFetchMissingValues: Bool = false
    protected val ariaRole: String = null
    protected val ariaState: JsonObject = JsonObject()
    protected val browserSpellCheck: Bool = false
    protected val canEdit: Bool = true
    protected val canFocus: Bool = false
    protected val cellClassName: CSSStyleName = "formCell"
    protected val cellHeight: Number = null
    protected val cellStyle: FormItemBaseStyle = ""
    private[formItems] val changed: FunctionExpression = null
    private[formItems] val click: FunctionExpression = null
    protected val colSpan: JsonElement = 1
    protected val containerWidget: CanvasDyn = null
    protected val criteriaField: String = ""
    protected val dataPath: XPathExpression = ""
    protected val dateFormatter: DateDisplayFormat = ddfNull
    protected val decimalPad: Number = null
    protected val decimalPrecision: Number = null
    protected val defaultIconSrc: SCImgURL = JsonNull
    protected val defaultValue: JsonElement = JsonNull
    protected val disabled: Bool = false
    protected val disableIconsOnReadOnly: Bool = true
    protected val displayField: String = ""
    protected val displayFormat: DateDisplayFormat = getObject(ddfNull.toString)
    protected[formItems] val editorType: FormItemType = frmitmtpText
    protected val editPendingCSSText: Color = "#0066cc".clr
    protected val emptyDisplayValue: String = ""
    protected val emptyValueIcon: String = ""
    protected val endRow: Bool = false
    protected val errorCellClassName: CSSStyleName = "formError"
    protected val errorIconHeight: Number = 16
    protected val errorIconSrc: SCImgURL = "[SKIN]/DynamicForm/validation_error_icon.png"
    protected val errorIconWidth: Number = 16
    protected val errorMessageWidth: Number = 80
    protected val errorOrientation: AlignmentDyn = AlNull
    protected val fetchMissingValues: Bool = true
    protected val filterLocally: Bool = false
    protected val form: DynamicFormDyn = null
    protected val globalTabIndex: Number = null
    protected val height: Number = 20
    protected val hint: HTMLString = ""
    protected val hintClassName: CSSStyleName = "formHint"
    protected val hintStyle: String = "formHint"
    protected val hoverAlign: AlignmentDyn = AlNull
    protected val hoverDelay: Number = null
    protected val hoverHeight: Number = null
    protected val hoverOpacity: Number = null
    protected val hoverStyle: CSSStyleName = ""
    protected val hoverVAlign: AlignmentDyn = ValAll
    protected val hoverWidth: Number = null
    protected val iconHeight: Number = 20
    protected val iconPrompt: String = ""
    protected val icons: ArrayDyn[FormItemIconDyn] = null
    protected val iconVAlign: AlignmentDyn = ValBottom
    protected val iconWidth: Number = 20
    protected val id: String = ""
    protected val imageURLPrefix: String = ""
    protected val imageURLSuffix: String = ""
    protected val implicitSave: Bool = false
    protected val implicitSaveOnBlur: Bool = false
    protected val inputFormat: DateInputFormat = ""
    protected val left: Number = 0
    protected val locateItemBy: String = ""
    private[formItems] val keyPress: FunctionExpression = null
    private[formItems] val keyDown: FunctionExpression = null
    private[formItems] val keyUp: FunctionExpression = null
    protected val multipleValueSeparator: String = ", "
    protected val name: String = ""
    protected val operator: OperatorId = opIdNull
    protected val optionCriteria: CriteriaDyn = null
    protected val optionDataSource: JsonElement = JsonNull
    protected val optionFilterContext: RPCRequestDyn = null
    protected val optionOperationId: String = ""
    protected val picker: AutoChild = null
    protected val pickerConstructor: SCClassName = ""
    protected val pickerIconDefaults: FormItemIconDyn = null
    protected val pickerIconHeight: Number = null
    protected val pickerIconName: String = "picker"
    protected val pickerIconPrompt: String = null
    protected val pickerIconProperties: FormItemIconDyn = null
    protected val pickerIconSrc: SCImgURL = JsonNull
    protected val pickerIconWidth: Number = null
    protected val pickerProperties: CanvasDyn = null
    protected val printTextBoxStyle: FormItemBaseStyle = ""
    protected val printTitleStyle: FormItemBaseStyle = ""
    protected val prompt: String = ""
    protected val redrawOnChange: Bool = false
    protected val rejectInvalidValueOnChange: Bool = false
    protected val required: Bool = null
    protected val requiredMessage: String = ""
    protected val rowSpan: Number = 1
    protected val saveOnEnter: Bool = false
    protected val selectOnFocus: Bool = false
    protected val shouldSaveValue: Bool = true
    protected val showDisabled: Bool = true
    protected val showErrorIcon: Bool = true
    protected val showErrorStyle: Bool = false
    protected val showErrorText: Bool = false
    protected val showFocused: Bool = false
    protected val showFocusedIcons: Bool = false
    protected val showFocusedPickerIcon: Bool = false
    protected val showHint: Bool = true
    protected val showIcons: Bool = true
    protected val showOverIcons: Bool = false
    protected val showPickerIcon: Bool = false
    protected val showTitle: Bool = true
    protected val showValueIconOnly: Bool = null
    protected val startRow: Bool = false
    protected val stopOnError: Bool = false
    protected val suppressValueIcon: Bool = null
    protected val synchronousValidation: Bool = false
    protected val tabIndex: Number = null
    protected val textAlign: AlignmentDyn = AlLeft
    protected val textBoxStyle: FormItemBaseStyle = ""
    protected val timeFormatter: TimeDisplayFormat = tmDspFmtNull
    protected val title: String = ""
    protected val titleAlign: AlignmentDyn = AlNull
    protected val titleClassName: CSSStyleName = "formTitle"
    protected val titleColSpan: Number = 1
    protected val titleErrorClassName: CSSStyleName = "formTitleError"
    protected val titleOrientation: TitleOrientation = ttlOrntLeft
    protected val titleStyle: FormItemBaseStyle = "formTitle"
    protected val titleVAlign: AlignmentDyn = AlCenter
    protected val top: Number = 0
    protected val __type: FormItemType = frmitmtpText
    protected val fieldType: FormItemType = frmitmtpText
    protected val validateOnChange: Bool = false
    protected val validateOnExit: Bool = false
    protected val validators: ArrayDyn[ValidatorDyn] = null
    protected val validOperators: JsonList = null
    protected val vAlign: AlignmentDyn = AlCenter
    protected val value: JsonElement = null
    protected val valueField: String = null
    protected val valueIconHeight: Number = null
    protected val valueIconLeftPadding: Number = 0
    protected val valueIconRightPadding: Number = 3
    protected val valueIcons: JsonObject = JsonObject()
    protected val valueIconSize: Number = 16
    protected val valueIconWidth: Number = null
    private[formItems] val valueMap: JsonElement = JsonNull
    protected val visible: Bool = true
    protected val width: Number = null
    protected val wrapTitle: Bool = false
}