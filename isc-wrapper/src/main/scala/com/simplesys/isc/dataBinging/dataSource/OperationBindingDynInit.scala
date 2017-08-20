package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.dataBinging.RPC.ServerObjectDyn
import com.simplesys.isc.dataBinging.{DataSourceDyn, DSRequestDyn}
import com.simplesys.json.{JsonObject, UnquotedString, JsonList}
import com.simplesys.isc.system.ArrayDyn

trait OperationBindingDynInit {
  protected val allowMultiUpdate: Bool = false
  protected val autoJoinTransactions: Bool = false
  protected val cacheSyncOperation: String = ""
  protected val callbackParam: String = "callback"
  protected val canSyncCache: Bool = false
  protected val creatorOverrides: Bool = false
  protected val criteria: ArrayDyn[DSRequestModifierDyn] = null
  protected val customCriteriaFields: JsonList = JsonList()
  protected val customFields: JsonList = JsonList()
  protected val customHQL: String = ""
  protected val customSQL: String = ""
  protected val customValueFields: JsonList = JsonList()
  protected val dataFormat: DSDataFormat = dtftIscServer
  protected val dataProtocol: DSProtocol = dsprtGetParams
  protected val dataTransport: RPCTransport = rpctransportXmlHttpRequest
  protected val dataURL: UnquotedString = null
  protected val defaultParams: JsonObject = JsonObject()
  protected val excludeCriteriaFields: JsonList = JsonList()
  protected val exportAs: ExportFormat = noneFmt
  protected val exportFields: JsonList = JsonList()
  protected val exportFilename: String = ""
  protected val exportResults: Bool = false
  protected val groupClause: String = ""
  protected val invalidateCache: Bool = false
  protected val lineBreakStyle: String = ""
  protected val mail: MailDyn = null
  protected val methodArguments: String = ""
  protected val operationId: String = ""
  protected val operationType: DSOperationType = dsOptTypeNull
  protected val orderClause: String = ""
  protected val outputs: String = ""
  protected val preventHTTPCaching: Bool = false
  protected val qualifyColumnNames: Bool = true
  protected val recordName: String = ""
  protected val recordXPath: XPathExpression = ""
  protected val requestProperties: DSRequestDyn = null
  protected val requiresAuthentication: Bool = false
  protected val requiresRole: String = ""
  protected val responseDataSchema: DataSourceDyn = null
  protected val selectClause: String = ""
  protected val serverMethod: String = ""
  protected val serverObject: ServerObjectDyn = null
  protected val skipRowCount: Bool = false
  protected val spoofResponses: Bool = false
  protected val sqlPaging: SQLPagingStrategy = sqlPgStrgNull
  protected val sqlType: SQLType = sqlTpNull
  protected val tableClause: String = ""
  protected val useFlatFields: Bool = false
  protected val useForCacheSync: Bool = true
  protected val useHttpProxy: Bool = false
  protected val values: ArrayDyn[DSRequestModifierDyn] = null
  protected val valuesClause: String = ""
  protected val whereClause: String = ""
  protected val wsOperation: String = ""
  protected val xmlNamespaces: Strings = null
}
