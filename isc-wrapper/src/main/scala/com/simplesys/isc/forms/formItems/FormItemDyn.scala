package com.simplesys.isc.forms.formItems

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.dataBinging.RPC.RPCRequestDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.forms.{ValidatorDyn, DynamicFormDyn}
import formItem.FormItemIconDyn
import com.simplesys.isc._
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName
import com.simplesys.isc.system.misc.SCClassName
import com.simplesys.isc.system.misc.XPathExpression
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool

object FormItemDyn {
    implicit def FormItemtoJsonObject(in: FormItemDyn): JsonObject = in json
}

class FormItemDyn(override val inJson: JsonObject = null,
                  override val useSelfName: Boolean = false) extends ClassDyn with FormItemDynInit {

    override val selfName: String = "FormItem"

    private[this] var _accessKey: String = accessKey
    def AccessKey = _accessKey
    def AccessKey_=(value: String) {
        if (_accessKey == value) return
        json("accessKey") = value
        _accessKey = value
    }

    private[this] var _align: AlignmentDyn = align
    def Align = _align
    def Align_=(value: AlignmentDyn) {
        if (_align == value) return
        json("align") = value
        _align = value
    }

    private[this] var _allowExpressions: Bool = allowExpressions
    def AllowExpressions = _allowExpressions
    def AllowExpressions_=(value: Bool) {
        if (_allowExpressions == value) return
        json("allowExpressions") = value
        _allowExpressions = value
    }

    private[this] var _alwaysFetchMissingValues: Bool = alwaysFetchMissingValues
    def AlwaysFetchMissingValues = _alwaysFetchMissingValues
    def AlwaysFetchMissingValues_=(value: Bool) {
        if (_alwaysFetchMissingValues == value) return
        json("alwaysFetchMissingValues") = value
        _alwaysFetchMissingValues = value
    }

    def AriaRole = json.getStringOpt("ariaRole").getOrElse(ariaRole)
    def AriaRole_=(value: String) {
        if (AriaRole == value) return
        json("ariaRole") = value
    }

    def AriaState = json.getJsonObjectOpt("ariaState").getOrElse(ariaState)
    def AriaState_=(value: JsonObject) {
        if (AriaState == value) return
        json("ariaState") = value
    }

    private[this] var _browserSpellCheck: Bool = browserSpellCheck
    def BrowserSpellCheck = _browserSpellCheck
    def BrowserSpellCheck_=(value: Bool) {
        if (_browserSpellCheck == value) return
        json("browserSpellCheck") = value
        _browserSpellCheck = value
    }

    private[this] var _canEdit: Bool = canEdit
    def CanEdit = _canEdit
    def CanEdit_=(value: Bool) {
        if (_canEdit == value) return
        json("canEdit") = value
        _canEdit = value
    }

    private[this] var _canFocus: Bool = canFocus
    def CanFocus = _canFocus
    def CanFocus_=(value: Bool) {
        if (_canFocus == value) return
        json("canFocus") = value
        _canFocus = value
    }

    private[this] var _cellClassName: CSSStyleName = cellClassName
    def CellClassName = _cellClassName
    def CellClassName_=(value: CSSStyleName) {
        if (_cellClassName == value) return
        json("cellClassName") = value
        _cellClassName = value
    }

    private[this] var _cellHeight: Number = cellHeight
    def CellHeight = _cellHeight
    def CellHeight_=(value: Number) {
        if (_cellHeight == value) return
        json("cellHeight") = value
        _cellHeight = value
    }

    private[this] var _cellStyle: FormItemBaseStyle = cellStyle
    def CellStyle = _cellStyle
    def CellStyle_=(value: FormItemBaseStyle) {
        if (_cellStyle == value) return
        json("cellStyle") = value
        _cellStyle = value
    }

    def ColSpan = json.getJsonElement("colSpan").getOrElse(colSpan)
    def ColSpan_=(value: JsonElement) {
        if (ColSpan == value) return
        json("colSpan") = value
    }

    def Click = json.getFunctionExpressionOpt("click").getOrElse(click)
    def Click_=(value: FunctionExpression) {
        if (Click == value) return
        json("click") = value
    }

    private[this] var _containerWidget: CanvasDyn = containerWidget
    def ContainerWidget = _containerWidget
    def ContainerWidget_=(value: CanvasDyn) {
        if (_containerWidget == value) return
        json("containerWidget") = value
        _containerWidget = value
    }

    private[this] var _criteriaField: String = criteriaField
    def CriteriaField = _criteriaField
    def CriteriaField_=(value: String) {
        if (_criteriaField == value) return
        json("criteriaField") = value
        _criteriaField = value
    }

    private[this] var _dataPath: XPathExpression = dataPath
    def DataPath = _dataPath
    def DataPath_=(value: XPathExpression) {
        if (_dataPath == value) return
        json("dataPath") = value
        _dataPath = value
    }

    private[this] var _dateFormatter: DateDisplayFormat = dateFormatter
    def DateFormatter = _dateFormatter
    def DateFormatter_=(value: DateDisplayFormat) {
        if (_dateFormatter == value) return
        json("dateFormatter") = value
        _dateFormatter = value
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

    private[this] var _defaultIconSrc: SCImgURL = defaultIconSrc
    def DefaultIconSrc = _defaultIconSrc
    def DefaultIconSrc_=(value: SCImgURL) {
        if (_defaultIconSrc == value) return
        json("defaultIconSrc") = value
        _defaultIconSrc = value
    }

    def DefaultValue = json.getJsonElement("defaultValue").getOrElse(defaultValue)
    def DefaultValue_=(value: JsonElement) {
        if (DefaultValue == value) return
        json("defaultValue") = value
    }

    private[this] var _disabled: Bool = disabled
    def Disabled = _disabled
    def Disabled_=(value: Bool) {
        if (_disabled == value) return
        json("disabled") = value
        _disabled = value
    }

    private[this] var _disableIconsOnReadOnly: Bool = disableIconsOnReadOnly
    def DisableIconsOnReadOnly = _disableIconsOnReadOnly
    def DisableIconsOnReadOnly_=(value: Bool) {
        if (_disableIconsOnReadOnly == value) return
        json("disableIconsOnReadOnly") = value
        _disableIconsOnReadOnly = value
    }

    private[this] var _displayField: String = displayField
    def DisplayField = _displayField
    def DisplayField_=(value: String) {
        if (_displayField == value) return
        json("displayField") = value
        _displayField = value
    }

    def DisplayFormat = json.getJsonElement("displayFormat").getOrElse(displayFormat)
    def DisplayFormat_=(value: JsonElement) {
        if (DisplayFormat == value) return
        json("displayFormat") = value
    }

    def EditorType = json.getValue2[JsonString, FormItemType]("editorType").getOrElse(editorType)
    protected def EditorType_=(value: FormItemType) {
        if (EditorType == value) return
        json("editorType") = value
    }

    def EditPendingCSSText = json.getValue2[JsonString, Color]("editPendingCSSText").getOrElse(editPendingCSSText)
    def EditPendingCSSText_=(value: Color) {
        if (EditPendingCSSText == value) return
        json("editPendingCSSText") = value
    }

    private[this] var _emptyDisplayValue: String = emptyDisplayValue
    def EmptyDisplayValue = _emptyDisplayValue
    def EmptyDisplayValue_=(value: String) {
        if (_emptyDisplayValue == value) return
        json("emptyDisplayValue") = value
        _emptyDisplayValue = value
    }

    private[this] var _emptyValueIcon: String = emptyValueIcon
    def EmptyValueIcon = _emptyValueIcon
    def EmptyValueIcon_=(value: String) {
        if (_emptyValueIcon == value) return
        json("emptyValueIcon") = value
        _emptyValueIcon = value
    }

    private[this] var _endRow: Bool = endRow
    def EndRow = _endRow
    def EndRow_=(value: Bool) {
        if (_endRow == value) return
        json("endRow") = value
        _endRow = value
    }

    private[this] var _errorCellClassName: CSSStyleName = errorCellClassName
    def ErrorCellClassName = _errorCellClassName
    def ErrorCellClassName_=(value: CSSStyleName) {
        if (_errorCellClassName == value) return
        json("errorCellClassName") = value
        _errorCellClassName = value
    }

    private[this] var _errorIconHeight: Number = errorIconHeight
    def ErrorIconHeight = _errorIconHeight
    def ErrorIconHeight_=(value: Number) {
        if (_errorIconHeight == value) return
        json("errorIconHeight") = value
        _errorIconHeight = value
    }

    private[this] var _errorIconSrc: SCImgURL = errorIconSrc
    def ErrorIconSrc = _errorIconSrc
    def ErrorIconSrc_=(value: SCImgURL) {
        if (_errorIconSrc == value) return
        json("errorIconSrc") = value
        _errorIconSrc = value
    }

    private[this] var _errorIconWidth: Number = errorIconWidth
    def ErrorIconWidth = _errorIconWidth
    def ErrorIconWidth_=(value: Number) {
        if (_errorIconWidth == value) return
        json("errorIconWidth") = value
        _errorIconWidth = value
    }

    private[this] var _errorMessageWidth: Number = errorMessageWidth
    def ErrorMessageWidth = _errorMessageWidth
    def ErrorMessageWidth_=(value: Number) {
        if (_errorMessageWidth == value) return
        json("errorMessageWidth") = value
        _errorMessageWidth = value
    }

    private[this] var _errorOrientation: AlignmentDyn = errorOrientation
    def ErrorOrientation = _errorOrientation
    def ErrorOrientation_=(value: AlignmentDyn) {
        if (_errorOrientation == value) return
        json("errorOrientation") = value
        _errorOrientation = value
    }

    private[this] var _fetchMissingValues: Bool = fetchMissingValues
    def FetchMissingValues = _fetchMissingValues
    def FetchMissingValues_=(value: Bool) {
        if (_fetchMissingValues == value) return
        json("fetchMissingValues") = value
        _fetchMissingValues = value
    }

    private[this] var _filterLocally: Bool = filterLocally
    def FilterLocally = _filterLocally
    def FilterLocally_=(value: Bool) {
        if (_filterLocally == value) return
        json("filterLocally") = value
        _filterLocally = value
    }

    private[this] var _form: DynamicFormDyn = form
    def Form = _form
    def Form_=(value: DynamicFormDyn) {
        if (_form == value) return
        json("form") = value
        _form = value
    }

    private[this] var _globalTabIndex: Number = globalTabIndex
    def GlobalTabIndex = _globalTabIndex
    def GlobalTabIndex_=(value: Number) {
        if (_globalTabIndex == value) return
        json("globalTabIndex") = value
        _globalTabIndex = value
    }

    private[this] var _height: Number = height
    def Height = _height
    def Height_=(value: Number) {
        if (_height == value) return
        json("height") = value
        _height = value
    }

    private[this] var _hint: HTMLString = hint
    def Hint = _hint
    def Hint_=(value: HTMLString) {
        if (_hint == value) return
        json("hint") = value
        _hint = value
    }

    private[this] var _hintClassName: CSSStyleName = hintClassName
    def HintClassName = _hintClassName
    def HintClassName_=(value: CSSStyleName) {
        if (_hintClassName == value) return
        json("hintClassName") = value
        _hintClassName = value
    }

    private[this] var _hintStyle: String = hintStyle
    def HintStyle = _hintStyle
    def HintStyle_=(value: String) {
        if (_hintStyle == value) return
        json("hintStyle") = value
        _hintStyle = value
    }

    private[this] var _hoverAlign: AlignmentDyn = hoverAlign
    def HoverAlign = _hoverAlign
    def HoverAlign_=(value: AlignmentDyn) {
        if (_hoverAlign == value) return
        json("hoverAlign") = value
        _hoverAlign = value
    }

    private[this] var _hoverDelay: Number = hoverDelay
    def HoverDelay = _hoverDelay
    def HoverDelay_=(value: Number) {
        if (_hoverDelay == value) return
        json("hoverDelay") = value
        _hoverDelay = value
    }

    private[this] var _hoverHeight: Number = hoverHeight
    def HoverHeight = _hoverHeight
    def HoverHeight_=(value: Number) {
        if (_hoverHeight == value) return
        json("hoverHeight") = value
        _hoverHeight = value
    }

    private[this] var _hoverOpacity: Number = hoverOpacity
    def HoverOpacity = _hoverOpacity
    def HoverOpacity_=(value: Number) {
        if (_hoverOpacity == value) return
        json("hoverOpacity") = value
        _hoverOpacity = value
    }

    private[this] var _hoverStyle: CSSStyleName = hoverStyle
    def HoverStyle = _hoverStyle
    def HoverStyle_=(value: CSSStyleName) {
        if (_hoverStyle == value) return
        json("hoverStyle") = value
        _hoverStyle = value
    }

    private[this] var _hoverVAlign: AlignmentDyn = hoverVAlign
    def HoverVAlign = _hoverVAlign
    def HoverVAlign_=(value: AlignmentDyn) {
        if (_hoverVAlign == value) return
        json("hoverVAlign") = value
        _hoverVAlign = value
    }

    private[this] var _hoverWidth: Number = hoverWidth
    def HoverWidth = _hoverWidth
    def HoverWidth_=(value: Number) {
        if (_hoverWidth == value) return
        json("hoverWidth") = value
        _hoverWidth = value
    }

    private[this] var _iconHeight: Number = iconHeight
    def IconHeight = _iconHeight
    def IconHeight_=(value: Number) {
        if (_iconHeight == value) return
        json("iconHeight") = value
        _iconHeight = value
    }

    private[this] var _iconPrompt: String = iconPrompt
    def IconPrompt = _iconPrompt
    def IconPrompt_=(value: String) {
        if (_iconPrompt == value) return
        json("iconPrompt") = value
        _iconPrompt = value
    }

    private[this] var _iconVAlign: AlignmentDyn = iconVAlign
    def IconVAlign = _iconVAlign
    def IconVAlign_=(value: AlignmentDyn) {
        if (_iconVAlign == value) return
        json("iconVAlign") = value
        _iconVAlign = value
    }

    private[this] var _iconWidth: Number = iconWidth
    def IconWidth = _iconWidth
    def IconWidth_=(value: Number) {
        if (_iconWidth == value) return
        json("iconWidth") = value
        _iconWidth = value
    }

    private[this] var _imageURLPrefix: String = imageURLPrefix
    def ImageURLPrefix = _imageURLPrefix
    def ImageURLPrefix_=(value: String) {
        if (_imageURLPrefix == value) return
        json("imageURLPrefix") = value
        _imageURLPrefix = value
    }

    private[this] var _imageURLSuffix: String = imageURLSuffix
    def ImageURLSuffix = _imageURLSuffix
    def ImageURLSuffix_=(value: String) {
        if (_imageURLSuffix == value) return
        json("imageURLSuffix") = value
        _imageURLSuffix = value
    }

    private[this] var _implicitSave: Bool = implicitSave
    def ImplicitSave = _implicitSave
    def ImplicitSave_=(value: Bool) {
        if (_implicitSave == value) return
        json("implicitSave") = value
        _implicitSave = value
    }

    private[this] var _implicitSaveOnBlur: Bool = implicitSaveOnBlur
    def ImplicitSaveOnBlur = _implicitSaveOnBlur
    def ImplicitSaveOnBlur_=(value: Bool) {
        if (_implicitSaveOnBlur == value) return
        json("implicitSaveOnBlur") = value
        _implicitSaveOnBlur = value
    }

    private[this] var _inputFormat: DateInputFormat = inputFormat
    def InputFormat = _inputFormat
    def InputFormat_=(value: DateInputFormat) {
        if (_inputFormat == value) return
        json("inputFormat") = value
        _inputFormat = value
    }

    private[this] var _left: Number = left
    def Left = _left
    def Left_=(value: Number) {
        if (_left == value) return
        json("left") = value
        _left = value
    }

    private[this] var _locateItemBy: String = locateItemBy
    def LocateItemBy = _locateItemBy
    def LocateItemBy_=(value: String) {
        if (_locateItemBy == value) return
        json("locateItemBy") = value
        _locateItemBy = value
    }

    def KeyDown = json.getFunctionExpressionOpt("keyDown").getOrElse(keyDown)
    def KeyDown_=(value: FunctionExpression) {
        if (KeyDown == value) return
        json("keyDown") = value
    }

    def KeyPress = json.getFunctionExpressionOpt("keyPress").getOrElse(keyPress)
    def KeyPress_=(value: FunctionExpression) {
        if (KeyPress == value) return
        json("keyPress") = value
    }

    def KeyUp = json.getFunctionExpressionOpt("keyUp").getOrElse(keyUp)
    def KeyUp_=(value: FunctionExpression) {
        if (KeyUp == value) return
        json("keyUp") = value
    }

    private[this] var _multipleValueSeparator: String = multipleValueSeparator
    def MultipleValueSeparator = _multipleValueSeparator
    def MultipleValueSeparator_=(value: String) {
        if (_multipleValueSeparator == value) return
        json("multipleValueSeparator") = value
        _multipleValueSeparator = value
    }

    private[this] var _name: String = name
    def Name = _name
    def Name_=(value: String) {
        if (_name == value) return
        json("name") = value
        _name = value
    }

    private[this] var _operator: OperatorId = operator
    def Operator = _operator
    def Operator_=(value: OperatorId) {
        if (_operator == value) return
        json("operator") = value
        _operator = value
    }

    private[this] var _optionCriteria: CriteriaDyn = optionCriteria
    def OptionCriteria = _optionCriteria
    def OptionCriteria_=(value: CriteriaDyn) {
        if (_optionCriteria == value) return
        json("optionCriteria") = value
        _optionCriteria = value
    }

    def OptionDataSource = json.getJsonElement("optionDataSource").getOrElse(optionDataSource)
    def OptionDataSource_=(value: JsonElement) {
        if (OptionDataSource == value) return
        json("optionDataSource") = value
    }

    private[this] var _optionFilterContext: RPCRequestDyn = optionFilterContext
    def OptionFilterContext = _optionFilterContext
    def OptionFilterContext_=(value: RPCRequestDyn) {
        if (_optionFilterContext == value) return
        json("optionFilterContext") = value
        _optionFilterContext = value
    }

    private[this] var _optionOperationId: String = optionOperationId
    def OptionOperationId = _optionOperationId
    def OptionOperationId_=(value: String) {
        if (_optionOperationId == value) return
        json("optionOperationId") = value
        _optionOperationId = value
    }

    private[this] var _picker: AutoChild = picker
    def Picker = _picker
    def Picker_=(value: AutoChild) {
        if (_picker == value) return
        json("picker") = value
        _picker = value
    }

    private[this] var _pickerConstructor: SCClassName = pickerConstructor
    def PickerConstructor = _pickerConstructor
    def PickerConstructor_=(value: SCClassName) {
        if (_pickerConstructor == value) return
        json("pickerConstructor") = value
        _pickerConstructor = value
    }

    private[this] var _pickerIconHeight: Number = pickerIconHeight
    def PickerIconHeight = _pickerIconHeight
    def PickerIconHeight_=(value: Number) {
        if (_pickerIconHeight == value) return
        json("pickerIconHeight") = value
        _pickerIconHeight = value
    }

    private[this] var _pickerIconName: String = pickerIconName
    def PickerIconName = _pickerIconName
    def PickerIconName_=(value: String) {
        if (_pickerIconName == value) return
        json("pickerIconName") = value
        _pickerIconName = value
    }

    private[this] var _pickerIconSrc: SCImgURL = pickerIconSrc
    def PickerIconSrc = _pickerIconSrc
    def PickerIconSrc_=(value: SCImgURL) {
        if (_pickerIconSrc == value) return
        json("pickerIconSrc") = value
        _pickerIconSrc = value
    }

    private[this] var _pickerIconWidth: Number = pickerIconWidth
    def PickerIconWidth = _pickerIconWidth
    def PickerIconWidth_=(value: Number) {
        if (_pickerIconWidth == value) return
        json("pickerIconWidth") = value
        _pickerIconWidth = value
    }

    private[this] var _pickerProperties: CanvasDyn = pickerProperties
    def PickerProperties = _pickerProperties
    def PickerProperties_=(value: CanvasDyn) {
        if (_pickerProperties == value) return
        json("pickerProperties") = value
        _pickerProperties = value
    }

    private[this] var _printTextBoxStyle: FormItemBaseStyle = printTextBoxStyle
    def PrintTextBoxStyle = _printTextBoxStyle
    def PrintTextBoxStyle_=(value: FormItemBaseStyle) {
        if (_printTextBoxStyle == value) return
        json("printTextBoxStyle") = value
        _printTextBoxStyle = value
    }

    private[this] var _printTitleStyle: FormItemBaseStyle = printTitleStyle
    def PrintTitleStyle = _printTitleStyle
    def PrintTitleStyle_=(value: FormItemBaseStyle) {
        if (_printTitleStyle == value) return
        json("printTitleStyle") = value
        _printTitleStyle = value
    }

    private[this] var _prompt: String = prompt
    def Prompt = _prompt
    def Prompt_=(value: String) {
        if (_prompt == value) return
        json("prompt") = value
        _prompt = value
    }

    def RedrawOnChange = json.getBoolOpt("redrawOnChange").getOrElse(redrawOnChange)
    def RedrawOnChange_=(value: Bool) {
        if (RedrawOnChange == value) return
        json("redrawOnChange") = value
    }

    private[this] var _rejectInvalidValueOnChange: Bool = rejectInvalidValueOnChange
    def RejectInvalidValueOnChange = _rejectInvalidValueOnChange
    def RejectInvalidValueOnChange_=(value: Bool) {
        if (_rejectInvalidValueOnChange == value) return
        json("rejectInvalidValueOnChange") = value
        _rejectInvalidValueOnChange = value
    }

    private[this] var _required: Bool = required
    def Required = _required
    def Required_=(value: Bool) {
        if (_required == value) return
        json("required") = value
        _required = value
    }

    private[this] var _requiredMessage: String = requiredMessage
    def RequiredMessage = _requiredMessage
    def RequiredMessage_=(value: String) {
        if (_requiredMessage == value) return
        json("requiredMessage") = value
        _requiredMessage = value
    }

    private[this] var _rowSpan: Number = rowSpan
    def RowSpan = _rowSpan
    def RowSpan_=(value: Number) {
        if (_rowSpan == value) return
        json("rowSpan") = value
        _rowSpan = value
    }

    private[this] var _saveOnEnter: Bool = saveOnEnter
    def SaveOnEnter = _saveOnEnter
    def SaveOnEnter_=(value: Bool) {
        if (_saveOnEnter == value) return
        json("saveOnEnter") = value
        _saveOnEnter = value
    }

    private[this] var _selectOnFocus: Bool = selectOnFocus
    def SelectOnFocus = _selectOnFocus
    def SelectOnFocus_=(value: Bool) {
        if (_selectOnFocus == value) return
        json("selectOnFocus") = value
        _selectOnFocus = value
    }

    private[this] var _shouldSaveValue: Bool = shouldSaveValue
    def ShouldSaveValue = _shouldSaveValue
    def ShouldSaveValue_=(value: Bool) {
        if (_shouldSaveValue == value) return
        json("shouldSaveValue") = value
        _shouldSaveValue = value
    }

    private[this] var _showDisabled: Bool = showDisabled
    def ShowDisabled = _showDisabled
    def ShowDisabled_=(value: Bool) {
        if (_showDisabled == value) return
        json("showDisabled") = value
        _showDisabled = value
    }

    private[this] var _showErrorIcon: Bool = showErrorIcon
    def ShowErrorIcon = _showErrorIcon
    def ShowErrorIcon_=(value: Bool) {
        if (_showErrorIcon == value) return
        json("showErrorIcon") = value
        _showErrorIcon = value
    }

    private[this] var _showErrorStyle: Bool = showErrorStyle
    def ShowErrorStyle = _showErrorStyle
    def ShowErrorStyle_=(value: Bool) {
        if (_showErrorStyle == value) return
        json("showErrorStyle") = value
        _showErrorStyle = value
    }

    private[this] var _showErrorText: Bool = showErrorText
    def ShowErrorText = _showErrorText
    def ShowErrorText_=(value: Bool) {
        if (_showErrorText == value) return
        json("showErrorText") = value
        _showErrorText = value
    }

    private[this] var _showFocused: Bool = showFocused
    def ShowFocused = _showFocused
    def ShowFocused_=(value: Bool) {
        if (_showFocused == value) return
        json("showFocused") = value
        _showFocused = value
    }

    private[this] var _showFocusedIcons: Bool = showFocusedIcons
    def ShowFocusedIcons = _showFocusedIcons
    def ShowFocusedIcons_=(value: Bool) {
        if (_showFocusedIcons == value) return
        json("showFocusedIcons") = value
        _showFocusedIcons = value
    }

    private[this] var _showFocusedPickerIcon: Bool = showFocusedPickerIcon
    def ShowFocusedPickerIcon = _showFocusedPickerIcon
    def ShowFocusedPickerIcon_=(value: Bool) {
        if (_showFocusedPickerIcon == value) return
        json("showFocusedPickerIcon") = value
        _showFocusedPickerIcon = value
    }

    private[this] var _showHint: Bool = showHint
    def ShowHint = _showHint
    def ShowHint_=(value: Bool) {
        if (_showHint == value) return
        json("showHint") = value
        _showHint = value
    }

    private[this] var _showIcons: Bool = showIcons
    def ShowIcons = _showIcons
    def ShowIcons_=(value: Bool) {
        if (_showIcons == value) return
        json("showIcons") = value
        _showIcons = value
    }

    private[this] var _showOverIcons: Bool = showOverIcons
    def ShowOverIcons = _showOverIcons
    def ShowOverIcons_=(value: Bool) {
        if (_showOverIcons == value) return
        json("showOverIcons") = value
        _showOverIcons = value
    }

    private[this] var _showPickerIcon: Bool = showPickerIcon
    def ShowPickerIcon = _showPickerIcon
    def ShowPickerIcon_=(value: Bool) {
        if (_showPickerIcon == value) return
        json("showPickerIcon") = value
        _showPickerIcon = value
    }

    private[this] var _showTitle: Bool = showTitle
    def ShowTitle = _showTitle
    def ShowTitle_=(value: Bool) {
        if (_showTitle == value) return
        json("showTitle") = value
        _showTitle = value
    }

    private[this] var _showValueIconOnly: Bool = showValueIconOnly
    def ShowValueIconOnly = _showValueIconOnly
    def ShowValueIconOnly_=(value: Bool) {
        if (_showValueIconOnly == value) return
        json("showValueIconOnly") = value
        _showValueIconOnly = value
    }

    private[this] var _startRow: Bool = startRow
    def StartRow = _startRow
    def StartRow_=(value: Bool) {
        if (_startRow == value) return
        json("startRow") = value
        _startRow = value
    }

    private[this] var _stopOnError: Bool = stopOnError
    def StopOnError = _stopOnError
    def StopOnError_=(value: Bool) {
        if (_stopOnError == value) return
        json("stopOnError") = value
        _stopOnError = value
    }

    private[this] var _suppressValueIcon: Bool = suppressValueIcon
    def SuppressValueIcon = _suppressValueIcon
    def SuppressValueIcon_=(value: Bool) {
        if (_suppressValueIcon == value) return
        json("suppressValueIcon") = value
        _suppressValueIcon = value
    }

    private[this] var _synchronousValidation: Bool = synchronousValidation
    def SynchronousValidation = _synchronousValidation
    def SynchronousValidation_=(value: Bool) {
        if (_synchronousValidation == value) return
        json("synchronousValidation") = value
        _synchronousValidation = value
    }

    private[this] var _tabIndex: Number = tabIndex
    def TabIndex = _tabIndex
    def TabIndex_=(value: Number) {
        if (_tabIndex == value) return
        json("tabIndex") = value
        _tabIndex = value
    }

    private[this] var _textAlign: AlignmentDyn = textAlign
    def TextAlign = _textAlign
    def TextAlign_=(value: AlignmentDyn) {
        if (_textAlign == value) return
        json("textAlign") = value
        _textAlign = value
    }

    private[this] var _textBoxStyle: FormItemBaseStyle = textBoxStyle
    def TextBoxStyle = _textBoxStyle
    def TextBoxStyle_=(value: FormItemBaseStyle) {
        if (_textBoxStyle == value) return
        json("textBoxStyle") = value
        _textBoxStyle = value
    }

    private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter
    def TimeFormatter = _timeFormatter
    def TimeFormatter_=(value: TimeDisplayFormat) {
        if (_timeFormatter == value) return
        json("timeFormatter") = value
        _timeFormatter = value
    }

    private[this] var _title: String = title
    def Title = _title
    def Title_=(value: String) {
        if (_title == value) return
        json("title") = value
        _title = value
    }

    private[this] var _titleAlign: AlignmentDyn = titleAlign
    def TitleAlign = _titleAlign
    def TitleAlign_=(value: AlignmentDyn) {
        if (_titleAlign == value) return
        json("titleAlign") = value
        _titleAlign = value
    }

    private[this] var _titleColSpan: Number = titleColSpan
    def TitleColSpan = _titleColSpan
    def TitleColSpan_=(value: Number) {
        if (_titleColSpan == value) return
        json("titleColSpan") = value
        _titleColSpan = value
    }

    private[this] var _titleErrorClassName: CSSStyleName = titleErrorClassName
    def TitleErrorClassName = _titleErrorClassName
    def TitleErrorClassName_=(value: CSSStyleName) {
        if (_titleErrorClassName == value) return
        json("titleErrorClassName") = value
        _titleErrorClassName = value
    }

    private[this] var _titleOrientation: TitleOrientation = titleOrientation
    def TitleOrientation = _titleOrientation
    def TitleOrientation_=(value: TitleOrientation) {
        if (_titleOrientation == value) return
        json("titleOrientation") = value
        _titleOrientation = value
    }

    private[this] var _titleStyle: FormItemBaseStyle = titleStyle
    def TitleStyle = _titleStyle
    def TitleStyle_=(value: FormItemBaseStyle) {
        if (_titleStyle == value) return
        json("titleStyle") = value
        _titleStyle = value
    }

    private[this] var _titleVAlign: AlignmentDyn = titleVAlign
    def TitleVAlign = _titleVAlign
    def TitleVAlign_=(value: AlignmentDyn) {
        if (_titleVAlign == value) return
        json("titleVAlign") = value
        _titleVAlign = value
    }

    private[this] var _top: Number = top
    def Top = _top
    def Top_=(value: Number) {
        if (_top == value) return
        json("top") = value
        _top = value
    }

    private[this] var _type: FormItemType = __type
    def Type = _type
    def Type_=(value: FormItemType) {
        if (_type == value) return
        json("type") = value
        _type = value
    }

    private[this] var _validateOnChange: Bool = validateOnChange
    def ValidateOnChange = _validateOnChange
    def ValidateOnChange_=(value: Bool) {
        if (_validateOnChange == value) return
        json("validateOnChange") = value
        _validateOnChange = value
    }

    private[this] var _validateOnExit: Bool = validateOnExit
    def ValidateOnExit = _validateOnExit
    def ValidateOnExit_=(value: Bool) {
        if (_validateOnExit == value) return
        json("validateOnExit") = value
        _validateOnExit = value
    }

    def ValidOperators = json.getJsonListOpt("validOperators").getOrElse(validOperators)
    def ValidOperators_=(value: JsonList) {
        if (ValidOperators == value) return
        json("validOperators") = value
    }

    private[this] var _vAlign: AlignmentDyn = vAlign
    def VAlign = _vAlign
    def VAlign_=(value: AlignmentDyn) {
        if (_vAlign == value) return
        json("vAlign") = value
        _vAlign = value
    }

    def Value = json.getJsonElement("value").getOrElse(value)
    def Value_=(value: JsonElement) {
        if (Value == value) return
        json("value") = value
    }

    private[this] var _valueField: String = valueField
    def ValueField = _valueField
    def ValueField_=(value: String) {
        json("valueField") = value
        _valueField = value
    }

    private[this] var _valueIconHeight: Number = valueIconHeight
    def ValueIconHeight = _valueIconHeight
    def ValueIconHeight_=(value: Number) {
        if (_valueIconHeight == value) return
        json("valueIconHeight") = value
        _valueIconHeight = value
    }

    private[this] var _valueIconLeftPadding: Number = valueIconLeftPadding
    def ValueIconLeftPadding = _valueIconLeftPadding
    def ValueIconLeftPadding_=(value: Number) {
        if (_valueIconLeftPadding == value) return
        json("valueIconLeftPadding") = value
        _valueIconLeftPadding = value
    }

    private[this] var _valueIconRightPadding: Number = valueIconRightPadding
    def ValueIconRightPadding = _valueIconRightPadding
    def ValueIconRightPadding_=(value: Number) {
        if (_valueIconRightPadding == value) return
        json("valueIconRightPadding") = value
        _valueIconRightPadding = value
    }

    private[this] var _valueIcons: JsonObject = valueIcons
    def ValueIcons = _valueIcons
    def ValueIcons_=(value: JsonObject) {
        json("valueIcons") = value
        _valueIcons = value
    }

    private[this] var _valueIconSize: Number = valueIconSize
    def ValueIconSize = _valueIconSize
    def ValueIconSize_=(value: Number) {
        if (_valueIconSize == value) return
        json("valueIconSize") = value
        _valueIconSize = value
    }

    private[this] var _valueIconWidth: Number = valueIconWidth
    def ValueIconWidth = _valueIconWidth
    def ValueIconWidth_=(value: Number) {
        if (_valueIconWidth == value) return
        json("valueIconWidth") = value
        _valueIconWidth = value
    }


    def ValueMap = json.getJsonElement("valueMap").getOrElse(valueMap)
    def ValueMap_=(value: JsonElement) {
        if (ValueMap == value) return
        json("valueMap") = value
    }

    private[this] var _visible: Bool = visible
    def Visible = _visible
    def Visible_=(value: Bool) {
        if (_visible == value) return
        json("visible") = value
        _visible = value
    }

    private[this] var _width: Number = width
    def Width = _width
    def Width_=(value: Number) {
        if (_width == value) return
        json("width") = value
        _width = value
    }

    private[this] var _wrapTitle: Bool = wrapTitle
    def WrapTitle = _wrapTitle
    def WrapTitle_=(value: Bool) {
        if (_wrapTitle == value) return
        json("wrapTitle") = value
        _wrapTitle = value
    }

    private[this] var _icons: ArrayDyn[FormItemIconDyn] = icons
    def Icons = _icons
    def Icons_=(value: ArrayDyn[FormItemIconDyn]) {
        if (_icons == value) return
        json("icons") = value
        _icons = value
    }

    private[this] var _pickerIconDefaults: FormItemIconDyn = pickerIconDefaults
    def PickerIconDefaults = _pickerIconDefaults
    def PickerIconDefaults_=(value: FormItemIconDyn) {
        if (_pickerIconDefaults == value) return
        json("pickerIconDefaults") = value
        _pickerIconDefaults = value
    }

    def PickerIconPrompt = json.getStringOpt("pickerIconPrompt").getOrElse(pickerIconPrompt)
    def PickerIconPrompt_=(value: String) {
        if (PickerIconPrompt == value) return
        json("pickerIconPrompt") = value
    }

    private[this] var _pickerIconProperties: FormItemIconDyn = pickerIconProperties
    def PickerIconProperties = _pickerIconProperties
    def PickerIconProperties_=(value: FormItemIconDyn) {
        if (_pickerIconProperties == value) return
        json("pickerIconProperties") = value
        _pickerIconProperties = value
    }

    private[this] var _validators: ArrayDyn[ValidatorDyn] = validators
    def Validators = _validators
    def Validators_=(value: ArrayDyn[ValidatorDyn]) {
        if (_validators == value) return
        json("validators") = value
        _validators = value
    }

    def Changed = json.getFunctionExpressionOpt("changed").getOrElse(changed)
    def Changed_=(value: FunctionExpression) {
        if (Changed == value) return
        json("changed") = value
    }


}

