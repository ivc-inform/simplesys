package com.simplesys.isc.RPC

import com.simplesys.isc.system.ClassDynInit
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn.{PromptStyle, psDialog, RPCTransport, rpctransportXmlHttpRequest}

trait RPCManagerDynInit extends ClassDynInit {
  private[RPC] val actionURL: URL = "[ISOMORPHIC]/IDACall"
  private[RPC] val allGlobals: String = "-ALL_GLOBALS"
  private[RPC] val allowCrossDomainCalls: Bool = false
  private[RPC] val allowIE9Leak: Bool = true
  private[RPC] val cancelQueue: FunctionExpression = null
  private[RPC] val clearTransaction: FunctionExpression = null
  private[RPC] val credentialsURL: URL = "http://localhost:8081/isomorphic/login/loginSuccessMarker.html"
  // 4 minutes
  private[RPC] val defaultTimeout: Number = 240000
  private[RPC] val defaultTransport: RPCTransport = rpctransportXmlHttpRequest
  private[RPC] val exportContent: FunctionExpression = null
  private[RPC] val fetchDataPrompt: String = "Finding Records that match your criteria..."
  private[RPC] val getCurrentTransactionId: FunctionExpression = null
  private[RPC] val handleError: FunctionExpression = null
  private[RPC] val handleTransportError: FunctionExpression = null
  private[RPC] val loadScreen: FunctionExpression = null
  private[RPC] val loginRequired: FunctionExpression = null
  private[RPC] val promptCursor: String = "browser-dependent"
  private[RPC] val promptStyle: PromptStyle = psDialog
  private[RPC] val queueSent: FunctionExpression = null
  private[RPC] val requestsArePending: FunctionExpression = null
  private[RPC] val resendTransaction: FunctionExpression = null
  private[RPC] val screenLoaderURL: URL = "[ISOMORPHIC]/screenLoader"
  private[RPC] val send: FunctionExpression = null
  private[RPC] val sendProxied: FunctionExpression = null
  private[RPC] val sendQueue: FunctionExpression = null
  private[RPC] val showPrompt: Bool = false
  private[RPC] val startQueue: FunctionExpression = null
  private[RPC] val suspendTransaction: FunctionExpression = null
  private[RPC] val useCursorTracker: Bool = false
  private[RPC] val xmlHttpRequestAvailable: FunctionExpression = null
  private[RPC] val maxErrorMessageLength: Number = 1000
}   