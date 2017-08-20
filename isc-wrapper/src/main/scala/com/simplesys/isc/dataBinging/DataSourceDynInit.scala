package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.RecordsDynList
import com.simplesys.isc.config.StoredData
import com.simplesys.common.Strings._
import dataSource.OperationBindingDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.{JsonElement, JsonNull, JsonObject}

trait DataSourceDynInit extends StoredData {
    protected val addGlobalId: Bool = true
    protected val autoCacheAllData: Bool = false
    protected val autoConvertRelativeDates: Bool = true
    protected val autoDeriveSchema: Bool = false
    protected val autoDeriveTitles: Bool = true
    protected val autoJoinTransactions: Bool = null
    protected val beanClassName: String = ""
    protected val cacheAllData: Bool = false
    private[dataBinging] val cacheData: JsonElement = JsonNull
    protected val cacheMaxAge: Number = 60
    protected val callbackParam: String = ""
    protected val canMultiSort: Bool = false
    protected val childrenField: String = ""
    protected val clientOnly: Bool = false
    protected val configBean: String = ""
    protected val creatorOverrides: Bool = false
    protected val criteriaPolicy: CriteriaPolicy = crtPlcDropOnShortening
    protected val dataField: String = ""
    protected val dataFormat: DSDataFormat = dtftIscServer
    protected val dataProtocol: DSProtocol = dsprtNull
    protected val dataTransport: RPCTransport = rpctransportXmlHttpRequest
    protected val dataURL: URL = null
    protected val dbImportFileName: String = ""
    protected val dbName: String = ""
    protected val descriptionField: String = ""
    protected val dropExtraFields: Bool = false
    protected val dropUnknownCriteria: Bool = true
    protected val enumConstantProperty: Bool = false
    protected val enumOrdinalProperty: Bool = false
    protected val enumTranslateStrategy: EnumTranslateStrategy = enTrlsStrgNull
    protected val fields: ArrayDyn[DataSourceFieldDyn] = null
    protected val globalNamespaces: String = null
    protected val iconField: String = ""
    protected val id: String = ""
    protected val infoField: String = ""
    protected val inheritsFrom: JsonObject = JsonObject()
    protected val jsonPrefix: String = ""
    protected val jsonSuffix: String = ""
    protected val noNullUpdates: Bool = false
    protected val nullBooleanValue: Bool = false
    protected val nullDateValue: Date = ""
    protected val nullFloatValue: Double = 0
    protected val nullIntegerValue: Int = 0
    protected val nullStringValue: String = ""
    protected val omitNullDefaultsOnAdd: Bool = false
    private[dataBinging] val operationBindings: ArrayDyn[OperationBindingDyn] = null
    protected val pluralTitle: String = ""
    protected val preventHTTPCaching: Bool = true
    protected val qualifyColumnNames: Bool = true
    protected val quoteColumnNames: Bool = false
    protected val recordName: String = ""
    protected val recordXPath: XPathExpression = ""
    protected val requestProperties: DSRequestDyn = null
    protected val requiredMessage: String = ""
    protected val requiresAuthentication: Bool = false
    protected val requiresRole: String = ""
    protected val resultBatchSize: Int = 150
    protected val resultSetClass: ResultSetDyn = null
    protected val resultTreeClass: ResultTreeDyn = null
    protected val schemaBean: String = ""
    protected val schemaNamespace: URN = ""
    protected val sendExtraFields: Bool = true
    protected val serverConstructor: String = ""
    protected val serverObject: JsonObject = JsonObject()
    protected val serverType: DSServerType = null
    protected val serviceNamespace: URN = ""
    protected val showLocalFieldsOnly: Bool = false
    protected val showPrompt: Bool = true
    protected val sparseUpdates: Bool = false
    protected val sqlPaging: SQLPagingStrategy = sqlPgStrgNull
    protected val strictSQLFiltering: Bool = false
    protected val tableName: String = ""
    protected val tagName: String = ""
    protected val testFileName: String = getStoredData("testFileName", "")
    private[dataBinging] val testData: JsonElement = JsonNull
    protected val title: String = ""
    protected val titleField: String = ""
    private[dataBinging] val transformRequest: FunctionExpression = strEmpty
    protected val useFlatFields: Bool = false
    protected val useHttpProxy: Bool = false
    protected val useLocalValidators: Bool = false
    protected val useOfflineStorage: Bool = false
    protected val useParentFieldOrder: Bool = false
    protected val useStrictJSON: Bool = null
    protected val useTestDataFetch: Bool = false
    protected val validateRelatedRecords: Bool = false
    protected val willHandleAdvancedCriteria: Bool = false
    private[dataBinging] val wildRecord: ArrayDyn[WildRecordColumnDyn] = ArrayDyn.empty[WildRecordColumnDyn]
}