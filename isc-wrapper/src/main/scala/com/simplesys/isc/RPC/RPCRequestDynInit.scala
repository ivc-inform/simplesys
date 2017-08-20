package com.simplesys.isc.dataBinging.RPC

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json._
import com.simplesys.isc.system.misc.URL
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool

trait RPCRequestDynInit {
    protected val actionURL: URL = "[ISOMORPHIC]/IDACall".url
    protected val bypassCache: Bool = false
    protected val callback: RPCCallback = ""
    protected val callbackParam: String = "callback"
    private[RPC] val channels: JsonList = JsonList()
    protected val clientContext: JsonElement = JsonNull
    protected val containsCredentials: Bool = false
    protected val contentType: String = "application/x-www-form-urlencoded"
    private[RPC] val data: JsonObject = JsonObject()
    private[RPC] val dataList: JsonList = JsonList()
    protected val dataSerriallized: JsonObject = JsonObject()
    protected val downloadResult: Bool = false
    private[RPC] val dataSources: JsonList = JsonList()
    protected val downloadToNewWindow: Bool = false
    protected val evalResult: Bool = false
    protected val evalVars: JsonList = null
    protected val httpHeaders: JsonList = null
    protected val httpMethod: String = "POST"
    protected val ignoreTimeout: Bool = false
    protected val omitNullMapValuesInResponse: Bool = false
    private[RPC] val params: JsonObject = null
    protected val paramsOnly: Bool = false
    protected val prompt: String = "Contacting server..."
    protected val promptCursor: String = "browser-dependent"
    protected val promptStyle: PromptStyle = psCursor
    protected val sendNoQueue: Bool = false
    protected val serverOutputAsString: Bool = false
    protected val showPrompt: Bool = false
    protected val timeout: Number = 240000
    protected val transport: RPCTransport = rpctransportXmlHttpRequest
    protected val useSimpleHttp: Bool = false
    protected val useXmlHttpRequest: Bool = false
    protected val willHandleError: Bool = false
    protected val status: Number = null
}