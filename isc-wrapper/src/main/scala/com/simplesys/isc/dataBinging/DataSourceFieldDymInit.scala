package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.forms.formItems.FormItemDyn
import com.simplesys.json.{JsonElement, JsonNull, JsonList, JsonObject}
import com.simplesys.isc.system.{ArrayDyn, ClassDynInit}
import com.simplesys.isc.forms.ValidatorDyn
import com.simplesys.common.Strings._

trait DataSourceFieldDymInit extends ClassDynInit {
    protected val autoQuoteCustomExpressions: Bool = true
    protected val autoGenerated: Bool = null
    protected val canEdit: Bool = null
    protected val canExport: Bool = null
    protected val canFilter: Bool = null
    protected val canSave: Bool = null
    protected val canSortClientOnly: Bool = false
    protected val canView: Bool = null
    protected val childrenProperty: Bool = false
    protected val childTagName: String = ""
    protected val creatorOverrides: Bool = null
    protected val customCriteriaExpression: String = ""
    protected val customInsertExpression: String = ""
    protected val customSelectExpression: String = ""
    protected val customSQL: Bool = null
    protected val customUpdateExpression: String = ""
    protected val dateFormatter: DateDisplayFormat = ddfNull
    protected val decimalPad: Number = null
    protected val decimalPrecision: Number = null
    protected val detail: Bool = false
    protected val displayField: String = strEmpty
    private[dataBinging] val valueField: String = strEmpty
    protected val displayFormat: String = null
    protected val editorType: FormItemDyn = null
    protected val editRequiresAuthentication: Bool = null
    protected val editRequiresRole: String = ""
    protected val encodeInResponse: Bool = null
    protected val escapeHTML: Bool = null
    protected val exportTitle: String = ""
    protected val fkColumnCode: String = null
    protected val fkTableCode: String = null
    protected val foreignKey: String = ""
    protected val hidden: Bool = false
    protected val ignore: Bool = false
    protected val imageHeight: Number = 16
    protected val imageSize: Number = 16
    protected val imageWidth: Number = 16
    protected val inapplicable: Bool = null
    protected val includeFrom: String = ""
    protected val initRequiresAuthentication: Bool = null
    protected val initRequiresRole: String = ""
    protected val javaClass: String = ""
    protected val joinType: JoinType = jtNull
    protected val javaCollectionClass: String = ""
    protected val javaKeyClass: String = ""
    protected val length: Number = null
    protected val maxFileSize: Number = null
    protected val multiple: Bool = null
    protected val name: String = null
    protected val nativeName: String = ""
    protected val nillable: Bool = null
    protected val nullReplacementValue: JsonObject = JsonObject()
    protected val primaryKey: Bool = false
    protected val propertiesOnly: Bool = null
    protected val readOnlyEditorType: FormItemDyn = null
    private[dataBinging] val format: String = ""
    protected val required: Bool = null
    protected val rootValue: String = null
    protected val sequenceName: String = ""
    protected val showFileInline: Bool = null
    protected val sqlDateFormat: String = ""
    protected val sqlFalseValue: String = ""
    protected val sqlStorageStrategy: String = ""
    protected val sqlTrueValue: String = ""
    protected val storeWithHash: HashAlgorithm = halgNull
    protected val summaryFunction: SummaryFunction = smfNull
    protected val summaryValueTitle: String = ""
    protected val tableName: String = ""
    protected val timeFormatter: TimeDisplayFormat = tmDspFmtNull
    protected val title: String = null
    private[dataBinging] val `type`: JsonElement = JsonNull
    protected val updateRequiresRole: String = ""
    protected val updateRequiresAuthentication: Bool = null
    protected val uploadFieldName: String = ""
    protected val validators: ArrayDyn[ValidatorDyn] = null
    protected val validOperators: JsonList = null
    private[dataBinging] val valueMap: JsonElement = JsonNull
    protected val valueMapEnum: String = null
    protected val valueWriteXPath: XPathExpression = ""
    protected val valueXPath: XPathExpression = ""
    protected val viewRequiresAuthentication: Bool = false
    protected val viewRequiresRole: String = ""
    private[dataBinging] val width: Number = null
    protected val xmlAttribute: Bool = null
    private[dataBinging] val lookup: Boolean = false
    private[dataBinging] val foreignField: String = strEmpty
    private[dataBinging] val captionClassLookup: String = strEmpty
    protected val optionDataSource: DataSourceDyn = null
    private[dataBinging] val optionDataSource1: JsonElement = JsonNull
}