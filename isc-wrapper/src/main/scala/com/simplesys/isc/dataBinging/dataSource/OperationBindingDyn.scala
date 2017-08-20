package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.json.{UnquotedString, JsonList, JsonObject}
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging.RPC.ServerObjectDyn
import com.simplesys.isc.dataBinging.{DataSourceDyn, DSRequestDyn}

object OperationBindingDyn {
  implicit def OperationBindingtoJsonObject(in: OperationBindingDyn): JsonObject = in json
  implicit def JSonObjToOperationBinding(jsonObject: JsonObject): OperationBindingDyn = new OperationBindingDyn(jsonObject)
}

class OperationBindingDyn(override val inJson: JsonObject = null) extends ClassDyn with OperationBindingDynInit {
  override val selfName: String = "OperationBinding\t"

  private[this] var _allowMultiUpdate: Bool = allowMultiUpdate
  def AllowMultiUpdate = _allowMultiUpdate
  def AllowMultiUpdate_=(value: Bool) {
    if (_allowMultiUpdate == value) return
    json("allowMultiUpdate") = value
    _allowMultiUpdate = value
  }

  private[this] var _autoJoinTransactions: Bool = autoJoinTransactions
  def AutoJoinTransactions = _autoJoinTransactions
  def AutoJoinTransactions_=(value: Bool) {
    if (_autoJoinTransactions == value) return
    json("autoJoinTransactions") = value
    _autoJoinTransactions = value
  }

  private[this] var _cacheSyncOperation: String = cacheSyncOperation
  def CacheSyncOperation = _cacheSyncOperation
  def CacheSyncOperation_=(value: String) {
    if (_cacheSyncOperation == value) return
    json("cacheSyncOperation") = value
    _cacheSyncOperation = value
  }

  private[this] var _callbackParam: String = callbackParam
  def CallbackParam = _callbackParam
  def CallbackParam_=(value: String) {
    if (_callbackParam == value) return
    json("callbackParam") = value
    _callbackParam = value
  }

  private[this] var _canSyncCache: Bool = canSyncCache
  def CanSyncCache = _canSyncCache
  def CanSyncCache_=(value: Bool) {
    if (_canSyncCache == value) return
    json("canSyncCache") = value
    _canSyncCache = value
  }

  private[this] var _creatorOverrides: Bool = creatorOverrides
  def CreatorOverrides = _creatorOverrides
  def CreatorOverrides_=(value: Bool) {
    if (_creatorOverrides == value) return
    json("creatorOverrides") = value
    _creatorOverrides = value
  }

  private[this] var _criteria: ArrayDyn[DSRequestModifierDyn] = criteria
  def Criteria = _criteria
  def Criteria_=(value: ArrayDyn[DSRequestModifierDyn]) {
    if (_criteria == value) return
    json("criteria") = value
    _criteria = value
  }

  private[this] var _customCriteriaFields: JsonList = customCriteriaFields
  def CustomCriteriaFields = _customCriteriaFields
  def CustomCriteriaFields_=(value: JsonList) {
    if (_customCriteriaFields == value) return
    json("customCriteriaFields") = value
    _customCriteriaFields = value
  }

  private[this] var _customFields: JsonList = customFields
  def CustomFields = _customFields
  def CustomFields_=(value: JsonList) {
    if (_customFields == value) return
    json("customFields") = value
    _customFields = value
  }

  private[this] var _customHQL: String = customHQL
  def CustomHQL = _customHQL
  def CustomHQL_=(value: String) {
    if (_customHQL == value) return
    json("customHQL") = value
    _customHQL = value
  }

  private[this] var _customSQL: String = customSQL
  def CustomSQL = _customSQL
  def CustomSQL_=(value: String) {
    if (_customSQL == value) return
    json("customSQL") = value
    _customSQL = value
  }

  private[this] var _customValueFields: JsonList = customValueFields
  def CustomValueFields = _customValueFields
  def CustomValueFields_=(value: JsonList) {
    if (_customValueFields == value) return
    json("customValueFields") = value
    _customValueFields = value
  }

  private[this] var _dataFormat: DSDataFormat = dataFormat
  def DataFormat = _dataFormat
  def DataFormat_=(value: DSDataFormat) {
    if (_dataFormat == value) return
    json("dataFormat") = value
    _dataFormat = value
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

  private[this] var _dataURL: UnquotedString = dataURL
  def DataURL = _dataURL
  def DataURL_=(value: UnquotedString) {
    if (_dataURL == value) return
    json("dataURL") = value
    _dataURL = value
  }

  private[this] var _defaultParams: JsonObject = defaultParams
  def DefaultParams = _defaultParams
  def DefaultParams_=(value: JsonObject) {
    json("defaultParams") = value
    _defaultParams = value
  }

  private[this] var _excludeCriteriaFields: JsonList = excludeCriteriaFields
  def ExcludeCriteriaFields = _excludeCriteriaFields
  def ExcludeCriteriaFields_=(value: JsonList) {
    if (_excludeCriteriaFields == value) return
    json("excludeCriteriaFields") = value
    _excludeCriteriaFields = value
  }

  private[this] var _exportAs: ExportFormat = exportAs
  def ExportAs = _exportAs
  def ExportAs_=(value: ExportFormat) {
    if (_exportAs == value) return
    json("exportAs") = value
    _exportAs = value
  }

  private[this] var _exportFields: JsonList = exportFields
  def ExportFields = _exportFields
  def ExportFields_=(value: JsonList) {
    if (_exportFields == value) return
    json("exportFields") = value
    _exportFields = value
  }

  private[this] var _exportFilename: String = exportFilename
  def ExportFilename = _exportFilename
  def ExportFilename_=(value: String) {
    if (_exportFilename == value) return
    json("exportFilename") = value
    _exportFilename = value
  }

  private[this] var _exportResults: Bool = exportResults
  def ExportResults = _exportResults
  def ExportResults_=(value: Bool) {
    if (_exportResults == value) return
    json("exportResults") = value
    _exportResults = value
  }

  private[this] var _groupClause: String = groupClause
  def GroupClause = _groupClause
  def GroupClause_=(value: String) {
    if (_groupClause == value) return
    json("groupClause") = value
    _groupClause = value
  }

  private[this] var _invalidateCache: Bool = invalidateCache
  def InvalidateCache = _invalidateCache
  def InvalidateCache_=(value: Bool) {
    if (_invalidateCache == value) return
    json("invalidateCache") = value
    _invalidateCache = value
  }

  private[this] var _lineBreakStyle: String = lineBreakStyle
  def LineBreakStyle = _lineBreakStyle
  def LineBreakStyle_=(value: String) {
    if (_lineBreakStyle == value) return
    json("lineBreakStyle") = value
    _lineBreakStyle = value
  }

  private[this] var _mail: MailDyn = mail
  def Mail = _mail
  def Mail_=(value: MailDyn) {
    if (_mail == value) return
    json("mail") = value
    _mail = value
  }

  private[this] var _methodArguments: String = methodArguments
  def MethodArguments = _methodArguments
  def MethodArguments_=(value: String) {
    if (_methodArguments == value) return
    json("methodArguments") = value
    _methodArguments = value
  }

  private[this] var _operationId: String = operationId
  def OperationId = _operationId
  def OperationId_=(value: String) {
    if (_operationId == value) return
    json("operationId") = value
    _operationId = value
  }

  private[this] var _operationType: DSOperationType = operationType
  def OperationType = _operationType
  def OperationType_=(value: DSOperationType) {
    if (_operationType == value) return
    json("operationType") = value
    _operationType = value
  }

  private[this] var _orderClause: String = orderClause
  def OrderClause = _orderClause
  def OrderClause_=(value: String) {
    if (_orderClause == value) return
    json("orderClause") = value
    _orderClause = value
  }

  private[this] var _outputs: String = outputs
  def Outputs = _outputs
  def Outputs_=(value: String) {
    if (_outputs == value) return
    json("outputs") = value
    _outputs = value
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

  private[this] var _recordName: String = recordName
  def RecordName = _recordName
  def RecordName_=(value: String) {
    if (_recordName == value) return
    json("recordName") = value
    _recordName = value
  }

  private[this] var _recordXPath: XPathExpression = recordXPath
  def RecordXPath = _recordXPath
  def RecordXPath_=(value: XPathExpression) {
    if (_recordXPath == value) return
    json("recordXPath") = value
    _recordXPath = value
  }

  private[this] var _requestProperties: DSRequestDyn = requestProperties
  def RequestProperties = _requestProperties
  def RequestProperties_=(value: DSRequestDyn) {
    if (_requestProperties == value) return

    if (value.Enqueued)
      json("requestProperties") = value.ID.toString.unq
    else
      json("requestProperties") = value: JsonObject

    _requestProperties = value
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

  private[this] var _responseDataSchema: DataSourceDyn = responseDataSchema
  def ResponseDataSchema = _responseDataSchema
  def ResponseDataSchema_=(value: DataSourceDyn) {
    if (_responseDataSchema == value) return
    json("responseDataSchema") = value
    _responseDataSchema = value
  }

  private[this] var _selectClause: String = selectClause
  def SelectClause = _selectClause
  def SelectClause_=(value: String) {
    if (_selectClause == value) return
    json("selectClause") = value
    _selectClause = value
  }

  private[this] var _serverMethod: String = serverMethod
  def ServerMethod = _serverMethod
  def ServerMethod_=(value: String) {
    if (_serverMethod == value) return
    json("serverMethod") = value
    _serverMethod = value
  }

  private[this] var _serverObject: ServerObjectDyn = serverObject
  def ServerObject = _serverObject
  def ServerObject_=(value: ServerObjectDyn) {
    if (_serverObject == value) return
    json("serverObject") = value
    _serverObject = value
  }

  private[this] var _skipRowCount: Bool = skipRowCount
  def SkipRowCount = _skipRowCount
  def SkipRowCount_=(value: Bool) {
    if (_skipRowCount == value) return
    json("skipRowCount") = value
    _skipRowCount = value
  }

  private[this] var _spoofResponses: Bool = spoofResponses
  def SpoofResponses = _spoofResponses
  def SpoofResponses_=(value: Bool) {
    if (_spoofResponses == value) return
    json("spoofResponses") = value
    _spoofResponses = value
  }

  private[this] var _sqlPaging: SQLPagingStrategy = sqlPaging
  def SqlPaging = _sqlPaging
  def SqlPaging_=(value: SQLPagingStrategy) {
    if (_sqlPaging == value) return
    json("sqlPaging") = value
    _sqlPaging = value
  }

  private[this] var _sqlType: SQLType = sqlType
  def SqlType = _sqlType
  def SqlType_=(value: SQLType) {
    if (_sqlType == value) return
    json("sqlType") = value
    _sqlType = value
  }

  private[this] var _tableClause: String = tableClause
  def TableClause = _tableClause
  def TableClause_=(value: String) {
    if (_tableClause == value) return
    json("tableClause") = value
    _tableClause = value
  }

  private[this] var _useFlatFields: Bool = useFlatFields
  def UseFlatFields = _useFlatFields
  def UseFlatFields_=(value: Bool) {
    if (_useFlatFields == value) return
    json("useFlatFields") = value
    _useFlatFields = value
  }

  private[this] var _useForCacheSync: Bool = useForCacheSync
  def UseForCacheSync = _useForCacheSync
  def UseForCacheSync_=(value: Bool) {
    if (_useForCacheSync == value) return
    json("useForCacheSync") = value
    _useForCacheSync = value
  }

  private[this] var _useHttpProxy: Bool = useHttpProxy
  def UseHttpProxy = _useHttpProxy
  def UseHttpProxy_=(value: Bool) {
    if (_useHttpProxy == value) return
    json("useHttpProxy") = value
    _useHttpProxy = value
  }

  private[this] var _values: ArrayDyn[DSRequestModifierDyn] = values
  def Values = _values
  def Values_=(value: ArrayDyn[DSRequestModifierDyn]) {
    if (_values == value) return
    json("values") = value
    _values = value
  }

  private[this] var _valuesClause: String = valuesClause
  def ValuesClause = _valuesClause
  def ValuesClause_=(value: String) {
    if (_valuesClause == value) return
    json("valuesClause") = value
    _valuesClause = value
  }

  private[this] var _whereClause: String = whereClause
  def WhereClause = _whereClause
  def WhereClause_=(value: String) {
    if (_whereClause == value) return
    json("whereClause") = value
    _whereClause = value
  }

  private[this] var _wsOperation: String = wsOperation
  def WsOperation = _wsOperation
  def WsOperation_=(value: String) {
    if (_wsOperation == value) return
    json("wsOperation") = value
    _wsOperation = value
  }

  private[this] var _xmlNamespaces: Strings = xmlNamespaces
  def XmlNamespaces = _xmlNamespaces
  def XmlNamespaces_=(value: Strings) {
    json("xmlNamespaces") = value
    _xmlNamespaces = value
  }
}