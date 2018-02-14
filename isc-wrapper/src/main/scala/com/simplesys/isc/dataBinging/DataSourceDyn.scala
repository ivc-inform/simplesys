package com.simplesys.isc.dataBinging

import java.sql.Connection

import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.isc.dataBinging.dataSource.OperationBindingDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.json._

object DataSourceDyn {
    implicit def DataSource1toJsonObject(in: DataSourceDyn): JsonObject = in json

    implicit def JSonObjToClassDyn(jsonObject: JsonObject): DataSourceDyn = new DataSourceDyn(jsonObject)
}

class DataSourceDyn(override val inJson: JsonObject = null,
                    override val useSelfName: Boolean = false) extends ClassDyn with DataSourceDynInit {
    override val selfName = "DataSource"

    private[this] var _serverType: DSServerType = serverType
    def ServerType = _serverType
    def ServerType_=(value: DSServerType) {
        if (_serverType == value) return
        json("serverType") = value
        _serverType = value
    }

    private[this] var _tableName: String = tableName
    def TableName = _tableName
    def TableName_=(value: String) {
        if (_tableName == value) return
        json("tableName") = value
        _tableName = value
    }

    def MakeFields(tableName: String)(implicit connection: Connection, dataSource: BoneCPDataSource): ArrayDyn[DataSourceFieldDyn] = {
        Fields
    }

    def Fields = json.getValue2[JsonList, ArrayDyn[DataSourceFieldDyn]]("fields").getOrElse(fields)
    def Fields_=(value: ArrayDyn[DataSourceFieldDyn]) {
        if (Fields == value) return
        json("fields") = value
    }

    private[this] var _clientOnly: Bool = clientOnly
    def ClientOnly = _clientOnly
    def ClientOnly_=(value: Bool) {
        if (_clientOnly == value) return
        json("clientOnly") = value
        _clientOnly = value
    }

    def TestData = json.getJsonElement("testData").getOrElse(testData)
    def TestData_=(value: JsonElement) {
        if (TestData == value) return
        json("testData") = value
    }

    private[this] var _dataURL: URL = dataURL
    def DataURL = _dataURL
    def DataURL_=(value: URL) {
        if (_dataURL == value) return
        json("dataURL") = value
        _dataURL = value
    }

    private[this] var _dataFormat: DSDataFormat = dataFormat
    def DataFormat = _dataFormat
    def DataFormat_=(value: DSDataFormat) {
        if (_dataFormat == value) return
        json("dataFormat") = value
        _dataFormat = value
    }

    private[this] var _recordXPath: XPathExpression = recordXPath
    def RecordXPath = _recordXPath
    def RecordXPath_=(value: XPathExpression) {
        if (_recordXPath == value) return
        json("recordXPath") = value
        _recordXPath = value
    }

    private[this] var _addGlobalId: Bool = addGlobalId
    def AddGlobalId = _addGlobalId
    def AddGlobalId_=(value: Bool) {
        if (_addGlobalId == value) return
        json("addGlobalId") = value
        _addGlobalId = value
    }

    private[this] var _autoCacheAllData: Bool = autoCacheAllData
    def AutoCacheAllData = _autoCacheAllData
    def AutoCacheAllData_=(value: Bool) {
        if (_autoCacheAllData == value) return
        json("autoCacheAllData") = value
        _autoCacheAllData = value
    }

    private[this] var _autoConvertRelativeDates: Bool = autoConvertRelativeDates
    def AutoConvertRelativeDates = _autoConvertRelativeDates
    def AutoConvertRelativeDates_=(value: Bool) {
        if (_autoConvertRelativeDates == value) return
        json("autoConvertRelativeDates") = value
        _autoConvertRelativeDates = value
    }

    private[this] var _autoDeriveSchema: Bool = autoDeriveSchema
    def AutoDeriveSchema = _autoDeriveSchema
    def AutoDeriveSchema_=(value: Bool) {
        if (_autoDeriveSchema == value) return
        json("autoDeriveSchema") = value
        _autoDeriveSchema = value
    }

    private[this] var _autoDeriveTitles: Bool = autoDeriveTitles
    def AutoDeriveTitles = _autoDeriveTitles
    def AutoDeriveTitles_=(value: Bool) {
        if (_autoDeriveTitles == value) return
        json("autoDeriveTitles") = value
        _autoDeriveTitles = value
    }

    private[this] var _autoJoinTransactions: Bool = autoJoinTransactions
    def AutoJoinTransactions = _autoJoinTransactions
    def AutoJoinTransactions_=(value: Bool) {
        if (_autoJoinTransactions == value) return
        json("autoJoinTransactions") = value
        _autoJoinTransactions = value
    }

    private[this] var _beanClassName: String = beanClassName
    def BeanClassName = _beanClassName
    def BeanClassName_=(value: String) {
        if (_beanClassName == value) return
        json("beanClassName") = value
        _beanClassName = value
    }

    private[this] var _cacheAllData: Bool = cacheAllData
    def CacheAllData = _cacheAllData
    def CacheAllData_=(value: Bool) {
        if (_cacheAllData == value) return
        json("cacheAllData") = value
        _cacheAllData = value
    }

    def CacheData = json.getJsonElement("cacheData").getOrElse(cacheData)
    def CacheData_=(value: JsonElement) {
        if (CacheData == value) return
        json("cacheData") = value
    }

    private[this] var _cacheMaxAge: Number = cacheMaxAge
    def CacheMaxAge = _cacheMaxAge
    def CacheMaxAge_=(value: Number) {
        if (_cacheMaxAge == value) return
        json("cacheMaxAge") = value
        _cacheMaxAge = value
    }

    private[this] var _callbackParam: String = callbackParam
    def CallbackParam = _callbackParam
    def CallbackParam_=(value: String) {
        if (_callbackParam == value) return
        json("callbackParam") = value
        _callbackParam = value
    }

    private[this] var _canMultiSort: Bool = canMultiSort
    def CanMultiSort = _canMultiSort
    def CanMultiSort_=(value: Bool) {
        if (_canMultiSort == value) return
        json("canMultiSort") = value
        _canMultiSort = value
    }

    private[this] var _childrenField: String = childrenField
    def ChildrenField = _childrenField
    def ChildrenField_=(value: String) {
        if (_childrenField == value) return
        json("childrenField") = value
        _childrenField = value
    }

    private[this] var _configBean: String = configBean
    def ConfigBean = _configBean
    def ConfigBean_=(value: String) {
        if (_configBean == value) return
        json("configBean") = value
        _configBean = value
    }

    private[this] var _creatorOverrides: Bool = creatorOverrides
    def CreatorOverrides = _creatorOverrides
    def CreatorOverrides_=(value: Bool) {
        if (_creatorOverrides == value) return
        json("creatorOverrides") = value
        _creatorOverrides = value
    }

    private[this] var _criteriaPolicy: CriteriaPolicy = criteriaPolicy
    def CriteriaPolicy = _criteriaPolicy
    def CriteriaPolicy_=(value: CriteriaPolicy) {
        if (_criteriaPolicy == value) return
        json("criteriaPolicy") = value
        _criteriaPolicy = value
    }

    private[this] var _dataField: String = dataField
    def DataField = _dataField
    def DataField_=(value: String) {
        if (_dataField == value) return
        json("dataField") = value
        _dataField = value
    }

    private[this] var _dataProtocol: DSProtocol = dataProtocol
    def DataProtocol = _dataProtocol
    def DataProtocol_=(value: DSProtocol) {
        if (_dataProtocol == value) return
        json("dataProtocol") = value
        _dataProtocol = value
    }

    private[this] var _dataTransport: RPCTransport = dataTransport
    def DataTransport = _dataTransport
    def DataTransport_=(value: RPCTransport) {
        if (_dataTransport == value) return
        json("dataTransport") = value
        _dataTransport = value
    }

    private[this] var _dbImportFileName: String = dbImportFileName
    def DbImportFileName = _dbImportFileName
    def DbImportFileName_=(value: String) {
        json("dbImportFileName") = value
        _dbImportFileName = value
    }

    private[this] var _dbName: String = dbName
    def DbName = _dbName
    def DbName_=(value: String) {
        if (_dbName == value) return
        json("dbName") = value
        _dbName = value
    }

    private[this] var _descriptionField: String = descriptionField
    def DescriptionField = _descriptionField
    def DescriptionField_=(value: String) {
        if (_descriptionField == value) return
        json("descriptionField") = value
        _descriptionField = value
    }

    private[this] var _dropExtraFields: Bool = dropExtraFields
    def DropExtraFields = _dropExtraFields
    def DropExtraFields_=(value: Bool) {
        if (_dropExtraFields == value) return
        json("dropExtraFields") = value
        _dropExtraFields = value
    }

    private[this] var _dropUnknownCriteria: Bool = dropUnknownCriteria
    def DropUnknownCriteria = _dropUnknownCriteria
    def DropUnknownCriteria_=(value: Bool) {
        if (_dropUnknownCriteria == value) return
        json("dropUnknownCriteria") = value
        _dropUnknownCriteria = value
    }

    private[this] var _enumConstantProperty: Bool = enumConstantProperty
    def EnumConstantProperty = _enumConstantProperty
    def EnumConstantProperty_=(value: Bool) {
        if (_enumConstantProperty == value) return
        json("enumConstantProperty") = value
        _enumConstantProperty = value
    }

    private[this] var _enumOrdinalProperty: Bool = enumOrdinalProperty
    def EnumOrdinalProperty = _enumOrdinalProperty
    def EnumOrdinalProperty_=(value: Bool) {
        if (_enumOrdinalProperty == value) return
        json("enumOrdinalProperty") = value
        _enumOrdinalProperty = value
    }

    private[this] var _enumTranslateStrategy: EnumTranslateStrategy = enumTranslateStrategy
    def EnumTranslateStrategy = _enumTranslateStrategy
    def EnumTranslateStrategy_=(value: EnumTranslateStrategy) {
        if (_enumTranslateStrategy == value) return
        json("enumTranslateStrategy") = value
        _enumTranslateStrategy = value
    }

    private[this] var _globalNamespaces: String = globalNamespaces
    def GlobalNamespaces = _globalNamespaces
    def GlobalNamespaces_=(value: String) {
        json("globalNamespaces") = value
        _globalNamespaces = value
    }

    private[this] var _iconField: String = iconField
    def IconField = _iconField
    def IconField_=(value: String) {
        if (_iconField == value) return
        json("iconField") = value
        _iconField = value
    }

    private[this] var _infoField: String = infoField
    def InfoField = _infoField
    def InfoField_=(value: String) {
        if (_infoField == value) return
        json("infoField") = value
        _infoField = value
    }

    private[this] var _inheritsFrom: JsonObject = inheritsFrom
    def InheritsFrom = _inheritsFrom
    def InheritsFrom_=(value: JsonObject) {
        json("inheritsFrom") = value
        _inheritsFrom = value
    }

    private[this] var _jsonPrefix: String = jsonPrefix
    def JsonPrefix = _jsonPrefix
    def JsonPrefix_=(value: String) {
        if (_jsonPrefix == value) return
        json("jsonPrefix") = value
        _jsonPrefix = value
    }

    private[this] var _jsonSuffix: String = jsonSuffix
    def JsonSuffix = _jsonSuffix
    def JsonSuffix_=(value: String) {
        if (_jsonSuffix == value) return
        json("jsonSuffix") = value
        _jsonSuffix = value
    }

    private[this] var _noNullUpdates: Bool = noNullUpdates
    def NoNullUpdates = _noNullUpdates
    def NoNullUpdates_=(value: Bool) {
        if (_noNullUpdates == value) return
        json("noNullUpdates") = value
        _noNullUpdates = value
    }

    private[this] var _nullBooleanValue: Bool = nullBooleanValue
    def NullBooleanValue = _nullBooleanValue
    def NullBooleanValue_=(value: Bool) {
        if (_nullBooleanValue == value) return
        json("nullBooleanValue") = value
        _nullBooleanValue = value
    }

    private[this] var _nullDateValue: Date = nullDateValue
    def NullDateValue = _nullDateValue
    def NullDateValue_=(value: Date) {
        if (_nullDateValue == value) return
        json("nullDateValue") = value
        _nullDateValue = value
    }

    private[this] var _nullFloatValue: Double = nullFloatValue
    def NullFloatValue = _nullFloatValue
    def NullFloatValue_=(value: Double) {
        if (_nullFloatValue == value) return
        json("nullFloatValue") = value
        _nullFloatValue = value
    }

    private[this] var _nullIntegerValue: Int = nullIntegerValue
    def NullIntegerValue = _nullIntegerValue
    def NullIntegerValue_=(value: Int) {
        if (_nullIntegerValue == value) return
        json("nullIntegerValue") = value
        _nullIntegerValue = value
    }

    private[this] var _nullStringValue: String = nullStringValue
    def NullStringValue = _nullStringValue
    def NullStringValue_=(value: String) {
        if (_nullStringValue == value) return
        json("nullStringValue") = value
        _nullStringValue = value
    }

    private[this] var _omitNullDefaultsOnAdd: Bool = omitNullDefaultsOnAdd
    def OmitNullDefaultsOnAdd = _omitNullDefaultsOnAdd
    def OmitNullDefaultsOnAdd_=(value: Bool) {
        if (_omitNullDefaultsOnAdd == value) return
        json("omitNullDefaultsOnAdd") = value
        _omitNullDefaultsOnAdd = value
    }

    private[this] var _pluralTitle: String = pluralTitle
    def PluralTitle = _pluralTitle
    def PluralTitle_=(value: String) {
        if (_pluralTitle == value) return
        json("pluralTitle") = value
        _pluralTitle = value
    }

    private[this] var _preventHTTPCaching: Bool = preventHTTPCaching
    def PreventHTTPCaching = _preventHTTPCaching
    def PreventHTTPCaching_=(value: Bool) {
        if (_preventHTTPCaching == value) return
        json("preventHTTPCaching") = value
        _preventHTTPCaching = value
    }

    private[this] var _qualifyColumnNames: Bool = qualifyColumnNames
    def QualifyColumnNames = _qualifyColumnNames
    def QualifyColumnNames_=(value: Bool) {
        if (_qualifyColumnNames == value) return
        json("qualifyColumnNames") = value
        _qualifyColumnNames = value
    }

    private[this] var _quoteColumnNames: Bool = quoteColumnNames
    def QuoteColumnNames = _quoteColumnNames
    def QuoteColumnNames_=(value: Bool) {
        if (_quoteColumnNames == value) return
        json("quoteColumnNames") = value
        _quoteColumnNames = value
    }

    private[this] var _recordName: String = recordName
    def RecordName = _recordName
    def RecordName_=(value: String) {
        json("recordeName") = value
        _recordName = value
    }

    def RequestProperties = requestProperties
    def RequestProperties_=(value: DSRequestDyn) {
        value match {
            case null =>
                this - "requestProperties"
            case _ => json("requestProperties") = value
        }
    }

    private[this] var _requiredMessage: String = requiredMessage
    def RequiredMessage = _requiredMessage
    def RequiredMessage_=(value: String) {
        if (_requiredMessage == value) return
        json("requiredMessage") = value
        _requiredMessage = value
    }

    private[this] var _requiresAuthentication: Bool = requiresAuthentication
    def RequiresAuthentication = _requiresAuthentication
    def RequiresAuthentication_=(value: Bool) {
        if (_requiresAuthentication == value) return
        json("requiresAuthentication") = value
        _requiresAuthentication = value
    }

    private[this] var _requiresRole: String = requiresRole
    def RequiresRole = _requiresRole
    def RequiresRole_=(value: String) {
        if (_requiresRole == value) return
        json("requiresRole") = value
        _requiresRole = value
    }

    private[this] var _resultBatchSize: Int = resultBatchSize
    def ResultBatchSize = _resultBatchSize
    def ResultBatchSize_=(value: Int) {
        if (_resultBatchSize == value) return
        json("resultBatchSize") = value
        _resultBatchSize = value
    }

    private[this] var _resultSetClass: ResultSetDyn = resultSetClass
    def ResultSetClass = _resultSetClass
    def ResultSetClass_=(value: ResultSetDyn) {
        value match {
            case null =>
                this - "resultSetClass"
            case _ => json("resultSetClass") = value
        }
    }

    private[this] var _resultTreeClass: ResultTreeDyn = resultTreeClass
    def ResultTreeClass = _resultTreeClass
    def ResultTreeClass_=(value: ResultTreeDyn) {
        value match {
            case null =>
                this - "resultTreeClass"
            case _ => json("resultTreeClass") = value
        }
    }

    private[this] var _schemaBean: String = schemaBean
    def SchemaBean = _schemaBean
    def SchemaBean_=(value: String) {
        if (_schemaBean == value) return
        json("schemaBean") = value
        _schemaBean = value
    }

    private[this] var _schemaNamespace: URN = schemaNamespace
    def SchemaNamespace = _schemaNamespace
    def SchemaNamespace_=(value: URN) {
        if (_schemaNamespace == value) return
        json("schemaNamespace") = value
        _schemaNamespace = value
    }

    private[this] var _sendExtraFields: Bool = sendExtraFields
    def SendExtraFields = _sendExtraFields
    def SendExtraFields_=(value: Bool) {
        if (_sendExtraFields == value) return
        json("sendExtraFields") = value
        _sendExtraFields = value
    }

    private[this] var _serverConstructor: String = serverConstructor
    def ServerConstructor = _serverConstructor
    def ServerConstructor_=(value: String) {
        if (_serverConstructor == value) return
        json("serverConstructor") = value
        _serverConstructor = value
    }

    private[this] var _serverObject: JsonObject = serverObject
    def ServerObject = _serverObject
    def ServerObject_=(value: JsonObject) {
        json("serverObject") = value
        _serverObject = value
    }

    private[this] var _serviceNamespace: URN = serviceNamespace
    def ServiceNamespace = _serviceNamespace
    def ServiceNamespace_=(value: URN) {
        if (_serviceNamespace == value) return
        json("serviceNamespace") = value
        _serviceNamespace = value
    }

    private[this] var _showLocalFieldsOnly: Bool = showLocalFieldsOnly
    def ShowLocalFieldsOnly = _showLocalFieldsOnly
    def ShowLocalFieldsOnly_=(value: Bool) {
        if (_showLocalFieldsOnly == value) return
        json("showLocalFieldsOnly") = value
        _showLocalFieldsOnly = value
    }

    private[this] var _showPrompt: Bool = showPrompt
    def ShowPrompt = _showPrompt
    def ShowPrompt_=(value: Bool) {
        if (_showPrompt == value) return
        json("showPrompt") = value
        _showPrompt = value
    }

    private[this] var _sparseUpdates: Bool = sparseUpdates
    def SparseUpdates = _sparseUpdates
    def SparseUpdates_=(value: Bool) {
        if (_sparseUpdates == value) return
        json("sparseUpdates") = value
        _sparseUpdates = value
    }

    private[this] var _sqlPaging: SQLPagingStrategy = sqlPaging
    def SqlPaging = _sqlPaging
    def SqlPaging_=(value: SQLPagingStrategy) {
        if (_sqlPaging == value) return
        json("sqlPaging") = value
        _sqlPaging = value
    }

    private[this] var _strictSQLFiltering: Bool = strictSQLFiltering
    def StrictSQLFiltering = _strictSQLFiltering
    def StrictSQLFiltering_=(value: Bool) {
        if (_strictSQLFiltering == value) return
        json("strictSQLFiltering") = value
        _strictSQLFiltering = value
    }

    private[this] var _tagName: String = tagName
    def TagName = _tagName
    def TagName_=(value: String) {
        if (_tagName == value) return
        json("tagName") = value
        _tagName = value
    }

    private[this] var _title: String = title
    def Title = _title
    def Title_=(value: String) {
        if (_title == value) return
        json("title") = value
        _title = value
    }

    private[this] var _titleField: String = titleField
    def TitleField = _titleField
    def TitleField_=(value: String) {
        if (_titleField == value) return
        json("titleField") = value
        _titleField = value
    }

    def TransformRequest = json.getFunctionExpressionOpt("transformRequest").getOrElse(transformRequest)
    def TransformRequest_=(value: FunctionExpression) {
        if (TransformRequest == value) return
        json("transformRequest") = value
    }

    private[this] var _useFlatFields: Bool = useFlatFields
    def UseFlatFields = _useFlatFields
    def UseFlatFields_=(value: Bool) {
        if (_useFlatFields == value) return
        json("useFlatFields") = value
        _useFlatFields = value
    }

    private[this] var _useHttpProxy: Bool = useHttpProxy
    def UseHttpProxy = _useHttpProxy
    def UseHttpProxy_=(value: Bool) {
        if (_useHttpProxy == value) return
        json("useHttpProxy") = value
        _useHttpProxy = value
    }

    private[this] var _useLocalValidators: Bool = useLocalValidators
    def UseLocalValidators = _useLocalValidators
    def UseLocalValidators_=(value: Bool) {
        if (_useLocalValidators == value) return
        json("useLocalValidators") = value
        _useLocalValidators = value
    }

    private[this] var _useOfflineStorage: Bool = useOfflineStorage
    def UseOfflineStorage = _useOfflineStorage
    def UseOfflineStorage_=(value: Bool) {
        if (_useOfflineStorage == value) return
        json("useOfflineStorage") = value
        _useOfflineStorage = value
    }

    private[this] var _useParentFieldOrder: Bool = useParentFieldOrder
    def UseParentFieldOrder = _useParentFieldOrder
    def UseParentFieldOrder_=(value: Bool) {
        if (_useParentFieldOrder == value) return
        json("useParentFieldOrder") = value
        _useParentFieldOrder = value
    }

    private[this] var _useStrictJSON: Bool = useStrictJSON
    def UseStrictJSON = _useStrictJSON
    def UseStrictJSON_=(value: Bool) {
        json("useStrictJSON") = value
        _useStrictJSON = value
    }

    private[this] var _useTestDataFetch: Bool = useTestDataFetch
    def UseTestDataFetch = _useTestDataFetch
    def UseTestDataFetch_=(value: Bool) {
        if (_useTestDataFetch == value) return
        json("useTestDataFetch") = value
        _useTestDataFetch = value
    }

    private[this] var _validateRelatedRecords: Bool = validateRelatedRecords
    def ValidateRelatedRecords = _validateRelatedRecords
    def ValidateRelatedRecords_=(value: Bool) {
        if (_validateRelatedRecords == value) return
        json("validateRelatedRecords") = value
        _validateRelatedRecords = value
    }

    private[this] var _willHandleAdvancedCriteria: Bool = willHandleAdvancedCriteria
    def WillHandleAdvancedCriteria = _willHandleAdvancedCriteria
    def WillHandleAdvancedCriteria_=(value: Bool) {
        if (_willHandleAdvancedCriteria == value) return
        json("willHandleAdvancedCriteria") = value
        _willHandleAdvancedCriteria = value
    }

    def OperationBindings = json.getValue2[JsonList, ArrayDyn[OperationBindingDyn]]("operationBindings").getOrElse(operationBindings)
    def OperationBindings_=(value: ArrayDyn[OperationBindingDyn]) {
        if (OperationBindings == value) return
        json("operationBindings") = value
    }

    private[this] var _testFileName: String = testFileName
    def TestFileName = _testFileName
    def TestFileName_=(value: String) {
        if (_testFileName == value) return
        json("testFileName") = value
        _testFileName = value
    }

    def WildRecord = json.getValue2[JsonList, ArrayDyn[WildRecordColumnDyn]]("wildRecord").getOrElse(wildRecord)
    def WildRecord_=(value: ArrayDyn[WildRecordColumnDyn]) {
        if (WildRecord == value) return
        json("wildRecord") = value
        json("wildRecordJS") = {
            val res = JsonObject()

            value foreach {
                case item: JsonObject =>
                    val x = new WildRecordColumnDyn(item)
                    res += (x.Name -> x.Value)
                case _ =>
            }

            res
        }
    }

}
