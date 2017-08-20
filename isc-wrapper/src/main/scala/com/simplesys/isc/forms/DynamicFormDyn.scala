package com.simplesys.isc.forms

import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.dataBinging.DataBoundComponentDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{UnquotedString, JsonObject, JsonList}
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.misc.{FunctionExpression, Number, Bool, CSSStyleName}
import com.simplesys.isc.system.ArrayDyn

object DynamicFormDyn {

    implicit def DynamicForm2JsonObject(in: DynamicFormDyn): JsonObject = in json
}

class DynamicFormDyn(override val useSelfName: Boolean = false) extends CanvasDyn with DataBoundComponentDyn with DynamicFormDynInit {
    override val selfName = "DynamicForm"


    private[this] var _action: String = action
    def Action = _action
    def Action_=(value: String) {
        if (_action == value) return
        json("action") = value
        _action = value
    }

    private[this] var _allowExpressions: Bool = allowExpressions

    def AllowExpressions = _allowExpressions

    def AllowExpressions_=(value: Bool) {
        if (_allowExpressions == value) return
        json("allowExpressions") = value
        _allowExpressions = value
    }

    private[this] var _autoFetchData: Bool = autoFetchData

    def AutoFetchData = _autoFetchData

    def AutoFetchData_=(value: Bool) {
        if (_autoFetchData == value) return
        json("autoFetchData") = value
        _autoFetchData = value
    }

    private[this] var _autoFetchTextMatchStyle: TextMatchStyle = autoFetchTextMatchStyle

    def AutoFetchTextMatchStyle = _autoFetchTextMatchStyle

    def AutoFetchTextMatchStyle_=(value: TextMatchStyle) {
        if (_autoFetchTextMatchStyle == value) return
        json("autoFetchTextMatchStyle") = value
        _autoFetchTextMatchStyle = value
    }

    private[this] var _autoFocus: Bool = autoFocus

    def AutoFocus = _autoFocus

    def AutoFocus_=(value: Bool) {
        if (_autoFocus == value) return
        json("autoFocus") = value
        _autoFocus = value
    }

    private[this] var _browserSpellCheck: Bool = browserSpellCheck

    def BrowserSpellCheck = _browserSpellCheck

    def BrowserSpellCheck_=(value: Bool) {
        if (_browserSpellCheck == value) return
        json("browserSpellCheck") = value
        _browserSpellCheck = value
    }

    private[this] var _cancelParamName: String = cancelParamName

    def CancelParamName = _cancelParamName

    def CancelParamName_=(value: String) {
        if (_cancelParamName == value) return
        json("cancelParamName") = value
        _cancelParamName = value
    }

    private[this] var _cancelParamValue: String = cancelParamValue

    def CancelParamValue = _cancelParamValue

    def CancelParamValue_=(value: String) {
        if (_cancelParamValue == value) return
        json("cancelParamValue") = value
        _cancelParamValue = value
    }

    private[this] var _canEdit: Bool = canEdit

    def CanEdit = _canEdit

    def CanEdit_=(value: Bool) {
        if (_canEdit == value) return
        json("canEdit") = value
        _canEdit = value
    }

    private[this] var _canSubmit: Bool = canSubmit

    def CanSubmit = _canSubmit

    def CanSubmit_=(value: Bool) {
        if (_canSubmit == value) return
        json("canSubmit") = value
        _canSubmit = value
    }

    private[this] var _canTabToSectionHeaders: Bool = canTabToSectionHeaders

    def CanTabToSectionHeaders = _canTabToSectionHeaders

    def CanTabToSectionHeaders_=(value: Bool) {
        if (_canTabToSectionHeaders == value) return
        json("canTabToSectionHeaders") = value
        _canTabToSectionHeaders = value
    }

    private[this] var _cellBorder: Number = cellBorder

    def CellBorder = _cellBorder

    def CellBorder_=(value: Number) {
        if (_cellBorder == value) return
        json("cellBorder") = value
        _cellBorder = value
    }

    private[this] var _cellPadding: Number = cellPadding

    def CellPadding = _cellPadding

    def CellPadding_=(value: Number) {
        if (_cellPadding == value) return
        json("cellPadding") = value
        _cellPadding = value
    }

    def ItemChanged = json.getFunctionExpressionOpt("itemChanged").getOrElse(itemChanged)

    def ItemChanged_=(value: FunctionExpression) {
        if (ItemChanged == value) return
        json("itemChanged") = value
    }


    def ColWidths = json.getJsonListOpt("colWidths").getOrElse(colWidths)
    def ColWidths_=(value: JsonList) {
        if (ColWidths == value) return
        json("colWidths") = value
    }

    private[this] var _dateFormatter: DateDisplayFormat = dateFormatter
    def DateFormatter = _dateFormatter
    def DateFormatter_=(value: DateDisplayFormat) {
        if (_dateFormatter == value) return
        json("dateFormatter") = value
        _dateFormatter = value
    }

    private[this] var _datetimeFormatter: DateDisplayFormat = datetimeFormatter

    def DatetimeFormatter = _datetimeFormatter

    def DatetimeFormatter_=(value: DateDisplayFormat) {
        if (_datetimeFormatter == value) return
        json("datetimeFormatter") = value
        _datetimeFormatter = value
    }

    private[this] var _disableValidation: Bool = disableValidation

    def DisableValidation = _disableValidation

    def DisableValidation_=(value: Bool) {
        if (_disableValidation == value) return
        json("disableValidation") = value
        _disableValidation = value
    }

    private[this] var _encoding: Encoding = encoding
    def Encoding = _encoding
    def Encoding_=(value: Encoding) {
        if (_encoding == value) return
        json("encoding") = value
        _encoding = value
    }

    private[this] var _errorItemCellStyle: String = errorItemCellStyle

    def ErrorItemCellStyle = _errorItemCellStyle

    def ErrorItemCellStyle_=(value: String) {
        if (_errorItemCellStyle == value) return
        json("errorItemCellStyle") = value
        _errorItemCellStyle = value
    }

    private[this] var _errorItemProperties: JsonObject = errorItemProperties

    def ErrorItemProperties = _errorItemProperties

    def ErrorItemProperties_=(value: JsonObject) {
        if (_errorItemProperties == value) return
        json("errorItemProperties") = value
        _errorItemProperties = value
    }

    private[this] var _errorOrientation: AlignmentDyn = errorOrientation

    def ErrorOrientation = _errorOrientation

    def ErrorOrientation_=(value: AlignmentDyn) {
        if (_errorOrientation == value) return
        json("errorOrientation") = value
        _errorOrientation = value
    }

    private[this] var _errors: JsonList = errors

    def Errors = _errors

    def Errors_=(value: JsonList) {
        if (_errors == value) return
        json("errors") = value
        _errors = value
    }

    private[this] var _errorsPreamble: String = errorsPreamble

    def ErrorsPreamble = _errorsPreamble

    def ErrorsPreamble_=(value: String) {
        if (_errorsPreamble == value) return
        json("errorsPreamble") = value
        _errorsPreamble = value
    }

    private[this] var _fixedColWidths: Bool = fixedColWidths

    def FixedColWidths = _fixedColWidths

    def FixedColWidths_=(value: Bool) {
        if (_fixedColWidths == value) return
        json("fixedColWidths") = value
        _fixedColWidths = value
    }

    private[this] var _formSubmitFailedWarning: String = formSubmitFailedWarning

    def FormSubmitFailedWarning = _formSubmitFailedWarning

    def FormSubmitFailedWarning_=(value: String) {
        if (_formSubmitFailedWarning == value) return
        json("formSubmitFailedWarning") = value
        _formSubmitFailedWarning = value
    }

    private[this] var _hiliteRequiredFields: Bool = hiliteRequiredFields

    def HiliteRequiredFields = _hiliteRequiredFields

    def HiliteRequiredFields_=(value: Bool) {
        if (_hiliteRequiredFields == value) return
        json("hiliteRequiredFields") = value
        _hiliteRequiredFields = value
    }

    private[this] var _implicitSave: Bool = implicitSave

    def ImplicitSave = _implicitSave

    def ImplicitSave_=(value: Bool) {
        if (_implicitSave == value) return
        json("implicitSave") = value
        _implicitSave = value
    }

    private[this] var _implicitSaveDelay: Number = implicitSaveDelay

    def ImplicitSaveDelay = _implicitSaveDelay

    def ImplicitSaveDelay_=(value: Number) {
        if (_implicitSaveDelay == value) return
        json("implicitSaveDelay") = value
        _implicitSaveDelay = value
    }

    private[this] var _implicitSaveOnBlur: Bool = implicitSaveOnBlur

    def ImplicitSaveOnBlur = _implicitSaveOnBlur

    def ImplicitSaveOnBlur_=(value: Bool) {
        if (_implicitSaveOnBlur == value) return
        json("implicitSaveOnBlur") = value
        _implicitSaveOnBlur = value
    }

    private[this] var _initialCriteria: CriteriaDyn = initialCriteria

    def InitialCriteria = _initialCriteria

    def InitialCriteria_=(value: CriteriaDyn) {
        if (_initialCriteria == value) return
        json("initialCriteria") = value
        _initialCriteria = value
    }

    private[this] var _itemHoverAlign: AlignmentDyn = itemHoverAlign

    def ItemHoverAlign = _itemHoverAlign

    def ItemHoverAlign_=(value: AlignmentDyn) {
        if (_itemHoverAlign == value) return
        json("itemHoverAlign") = value
        _itemHoverAlign = value
    }

    private[this] var _itemHoverDelay: Number = itemHoverDelay

    def ItemHoverDelay = _itemHoverDelay

    def ItemHoverDelay_=(value: Number) {
        if (_itemHoverDelay == value) return
        json("itemHoverDelay") = value
        _itemHoverDelay = value
    }

    private[this] var _itemHoverHeight: Number = itemHoverHeight

    def ItemHoverHeight = _itemHoverHeight

    def ItemHoverHeight_=(value: Number) {
        if (_itemHoverHeight == value) return
        json("itemHoverHeight") = value
        _itemHoverHeight = value
    }

    private[this] var _itemHoverOpacity: Number = itemHoverOpacity

    def ItemHoverOpacity = _itemHoverOpacity

    def ItemHoverOpacity_=(value: Number) {
        if (_itemHoverOpacity == value) return
        json("itemHoverOpacity") = value
        _itemHoverOpacity = value
    }

    private[this] var _itemHoverStyle: CSSStyleName = itemHoverStyle

    def ItemHoverStyle = _itemHoverStyle

    def ItemHoverStyle_=(value: CSSStyleName) {
        if (_itemHoverStyle == value) return
        json("itemHoverStyle") = value
        _itemHoverStyle = value
    }

    private[this] var _itemHoverVAlign: Number = itemHoverVAlign

    def ItemHoverVAlign = _itemHoverVAlign

    def ItemHoverVAlign_=(value: Number) {
        if (_itemHoverVAlign == value) return
        json("itemHoverVAlign") = value
        _itemHoverVAlign = value
    }

    private[this] var _itemHoverWidth: Number = itemHoverWidth

    def ItemHoverWidth = _itemHoverWidth

    def ItemHoverWidth_=(value: Number) {
        if (_itemHoverWidth == value) return
        json("itemHoverWidth") = value
        _itemHoverWidth = value
    }

    private[this] var _itemLayout: FormLayoutType = itemLayout
    def ItemLayout = _itemLayout
    def ItemLayout_=(value: FormLayoutType) {
        if (_itemLayout == value) return
        json("itemLayout") = value
        _itemLayout = value
    }

    private[this] var _longTextEditorThreshold: Number = longTextEditorThreshold

    def LongTextEditorThreshold = _longTextEditorThreshold

    def LongTextEditorThreshold_=(value: Number) {
        if (_longTextEditorThreshold == value) return
        json("longTextEditorThreshold") = value
        _longTextEditorThreshold = value
    }

    private[this] var _longTextEditorType: String = longTextEditorType

    def LongTextEditorType = _longTextEditorType

    def LongTextEditorType_=(value: String) {
        if (_longTextEditorType == value) return
        json("longTextEditorType") = value
        _longTextEditorType = value
    }

    private[this] var _method: FormMethod = method
    def Method = _method
    def Method_=(value: FormMethod) {
        if (_method == value) return
        json("method") = value
        _method = value
    }

    private[this] var _minColWidth: Number = minColWidth

    def MinColWidth = _minColWidth

    def MinColWidth_=(value: Number) {
        if (_minColWidth == value) return
        json("minColWidth") = value
        _minColWidth = value
    }

    private[this] var _nestedEditorType: String = nestedEditorType

    def NestedEditorType = _nestedEditorType

    def NestedEditorType_=(value: String) {
        if (_nestedEditorType == value) return
        json("nestedEditorType") = value
        _nestedEditorType = value
    }

    private[this] var _nestedListEditorType: String = nestedListEditorType

    def NestedListEditorType = _nestedListEditorType

    def NestedListEditorType_=(value: String) {
        if (_nestedListEditorType == value) return
        json("nestedListEditorType") = value
        _nestedListEditorType = value
    }

    private[this] var _numCols: Number = numCols

    def NumCols = _numCols

    def NumCols_=(value: Number) {
        if (_numCols == value) return
        json("numCols") = value
        _numCols = value
    }

    private[this] var _operator: OperatorId = operator

    def Operator = _operator

    def Operator_=(value: OperatorId) {
        if (_operator == value) return
        json("operator") = value
        _operator = value
    }

    private[this] var _rejectInvalidValueOnChange: Bool = rejectInvalidValueOnChange

    def RejectInvalidValueOnChange = _rejectInvalidValueOnChange

    def RejectInvalidValueOnChange_=(value: Bool) {
        if (_rejectInvalidValueOnChange == value) return
        json("rejectInvalidValueOnChange") = value
        _rejectInvalidValueOnChange = value
    }

    private[this] var _requiredMessage: HTMLString = requiredMessage

    def RequiredMessage = _requiredMessage

    def RequiredMessage_=(value: HTMLString) {
        if (_requiredMessage == value) return
        json("requiredMessage") = value
        _requiredMessage = value
    }

    private[this] var _requiredRightTitlePrefix: HTMLString = requiredRightTitlePrefix

    def RequiredRightTitlePrefix = _requiredRightTitlePrefix

    def RequiredRightTitlePrefix_=(value: HTMLString) {
        if (_requiredRightTitlePrefix == value) return
        json("requiredRightTitlePrefix") = value
        _requiredRightTitlePrefix = value
    }

    private[this] var _requiredTitlePrefix: HTMLString = requiredTitlePrefix

    def RequiredTitlePrefix = _requiredTitlePrefix

    def RequiredTitlePrefix_=(value: HTMLString) {
        if (_requiredTitlePrefix == value) return
        json("requiredTitlePrefix") = value
        _requiredTitlePrefix = value
    }

    private[this] var _requiredTitleSuffix: HTMLString = requiredTitleSuffix

    def RequiredTitleSuffix = _requiredTitleSuffix

    def RequiredTitleSuffix_=(value: HTMLString) {
        if (_requiredTitleSuffix == value) return
        json("requiredTitleSuffix") = value
        _requiredTitleSuffix = value
    }

    private[this] var _rightTitlePrefix: HTMLString = rightTitlePrefix

    def RightTitlePrefix = _rightTitlePrefix

    def RightTitlePrefix_=(value: HTMLString) {
        if (_rightTitlePrefix == value) return
        json("rightTitlePrefix") = value
        _rightTitlePrefix = value
    }

    private[this] var _rightTitleSuffix: HTMLString = rightTitleSuffix

    def RightTitleSuffix = _rightTitleSuffix

    def RightTitleSuffix_=(value: HTMLString) {
        if (_rightTitleSuffix == value) return
        json("rightTitleSuffix") = value
        _rightTitleSuffix = value
    }

    private[this] var _saveOnEnter: Bool = saveOnEnter

    def SaveOnEnter = _saveOnEnter

    def SaveOnEnter_=(value: Bool) {
        if (_saveOnEnter == value) return
        json("saveOnEnter") = value
        _saveOnEnter = value
    }

    private[this] var _saveOperationType: DSOperationType = saveOperationType
    def SaveOperationType = _saveOperationType
    def SaveOperationType_=(value: DSOperationType) {
        if (_saveOperationType == value) return
        json("saveOperationType") = value
        _saveOperationType = value
    }

    private[this] var _sectionVisibilityMode: VisibilityMode = sectionVisibilityMode
    def SectionVisibilityMode = _sectionVisibilityMode
    def SectionVisibilityMode_=(value: VisibilityMode) {
        if (_sectionVisibilityMode == value) return
        json("sectionVisibilityMode") = value
        _sectionVisibilityMode = value
    }

    private[this] var _selectOnFocus: Bool = selectOnFocus

    def SelectOnFocus = _selectOnFocus

    def SelectOnFocus_=(value: Bool) {
        if (_selectOnFocus == value) return
        json("selectOnFocus") = value
        _selectOnFocus = value
    }

    private[this] var _showComplexFieldsRecursively: Bool = showComplexFieldsRecursively

    def ShowComplexFieldsRecursively = _showComplexFieldsRecursively

    def ShowComplexFieldsRecursively_=(value: Bool) {
        if (_showComplexFieldsRecursively == value) return
        json("showComplexFieldsRecursively") = value
        _showComplexFieldsRecursively = value
    }

    private[this] var _showErrorIcons: Bool = showErrorIcons

    def ShowErrorIcons = _showErrorIcons

    def ShowErrorIcons_=(value: Bool) {
        if (_showErrorIcons == value) return
        json("showErrorIcons") = value
        _showErrorIcons = value
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

    private[this] var _showInlineErrors: Bool = showInlineErrors

    def ShowInlineErrors = _showInlineErrors

    def ShowInlineErrors_=(value: Bool) {
        if (_showInlineErrors == value) return
        json("showInlineErrors") = value
        _showInlineErrors = value
    }

    private[this] var _showTitlesWithErrorMessages: Bool = showTitlesWithErrorMessages

    def ShowTitlesWithErrorMessages = _showTitlesWithErrorMessages

    def ShowTitlesWithErrorMessages_=(value: Bool) {
        if (_showTitlesWithErrorMessages == value) return
        json("showTitlesWithErrorMessages") = value
        _showTitlesWithErrorMessages = value
    }

    private[this] var _stopOnError: Bool = stopOnError

    def StopOnError = _stopOnError

    def StopOnError_=(value: Bool) {
        if (_stopOnError == value) return
        json("stopOnError") = value
        _stopOnError = value
    }

    private[this] var _suppressValidationErrorCallback: Bool = suppressValidationErrorCallback

    def SuppressValidationErrorCallback = _suppressValidationErrorCallback

    def SuppressValidationErrorCallback_=(value: Bool) {
        if (_suppressValidationErrorCallback == value) return
        json("suppressValidationErrorCallback") = value
        _suppressValidationErrorCallback = value
    }

    private[this] var _synchronousValidation: Bool = synchronousValidation

    def SynchronousValidation = _synchronousValidation

    def SynchronousValidation_=(value: Bool) {
        if (_synchronousValidation == value) return
        json("synchronousValidation") = value
        _synchronousValidation = value
    }

    private[this] var _target: String = target

    def Target = _target

    def Target_=(value: String) {
        if (_target == value) return
        json("target") = value
        _target = value
    }

    private[this] var _timeFormatter: TimeDisplayFormat = timeFormatter

    def TimeFormatter = _timeFormatter

    def TimeFormatter_=(value: TimeDisplayFormat) {
        if (_timeFormatter == value) return
        json("timeFormatter") = value
        _timeFormatter = value
    }

    private[this] var _titleAlign: AlignmentDyn = titleAlign
    def TitleAlign = _titleAlign
    def TitleAlign_=(value: AlignmentDyn) {
        if (_titleAlign == value) return
        json("titleAlign") = value
        _titleAlign = value
    }

    private[this] var _titleOrientation: TitleOrientation = titleOrientation

    def TitleOrientation = _titleOrientation

    def TitleOrientation_=(value: TitleOrientation) {
        if (_titleOrientation == value) return
        json("titleOrientation") = value
        _titleOrientation = value
    }

    private[this] var _titlePrefix: HTMLString = titlePrefix

    def TitlePrefix = _titlePrefix

    def TitlePrefix_=(value: HTMLString) {
        if (_titlePrefix == value) return
        json("titlePrefix") = value
        _titlePrefix = value
    }

    private[this] var _titleSuffix: HTMLString = titleSuffix

    def TitleSuffix = _titleSuffix

    def TitleSuffix_=(value: HTMLString) {
        if (_titleSuffix == value) return
        json("titleSuffix") = value
        _titleSuffix = value
    }

    private[this] var _titleWidth: Number = titleWidth

    def TitleWidth = _titleWidth

    def TitleWidth_=(value: Number) {
        if (_titleWidth == value) return
        json("titleWidth") = value
        _titleWidth = value
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

    private[this] var _validationURL: UnquotedString = validationURL

    def ValidationURL = _validationURL

    def ValidationURL_=(value: UnquotedString) {
        if (_validationURL == value) return
        json("validationURL") = value
        _validationURL = value
    }

    def Values = json.getJsonObjectOpt("values").getOrElse(values)
    def Values_=(value: JsonObject) {
        if (Values == value) return
        json("values") = value
    }

    private[this] var _wrapItemTitles: Bool = wrapItemTitles
    def WrapItemTitles = _wrapItemTitles
    def WrapItemTitles_=(value: Bool) {
        if (_wrapItemTitles == value) return
        json("wrapItemTitles") = value
        _wrapItemTitles = value
    }

    def NumRows = json.getNumberOpt("numRows").getOrElse(numRows)
    def NumRows_=(value: Number) {
        if (NumRows == value) return
        json("numRows") = value
    }
}
