package com.simplesys.isc.RPC

import com.simplesys.json.{JsonURL, JsonString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.typesDyn.{PromptStyle, RPCTransport}
import com.simplesys.isc._
import com.simplesys.isc.dataBinging.RPC.RPCRequestDyn

object RPCManagerDyn extends RPCManagerDynInit {

  implicit def RPCManagerDyn2JsonObject(in: RPCManagerDyn): JsonObject = in json
  def apply() = new RPCManagerDyn {}
}

trait RPCManagerDyn extends ClassDyn with RPCManagerDynInit {
  override val selfName = "RPCManager"

  def ActionURL = json.getValue2[JsonURL, URL]("actionURL").getOrElse(actionURL)
  def ActionURL_=(value: URL) {
    if (ActionURL == value) return
    json("actionURL") = value
  }

  def AllGlobals = json.getStringOpt("allGlobals").getOrElse(allGlobals)
  def AllGlobals_=(value: String) {
    if (AllGlobals == value) return
    json("allGlobals") = value
  }

  def AllowCrossDomainCalls = json.getBoolOpt("allowCrossDomainCalls").getOrElse(allowCrossDomainCalls)
  def AllowCrossDomainCalls_=(value: Bool) {
    if (AllowCrossDomainCalls == value) return
    json("allowCrossDomainCalls") = value
  }

  def AllowIE9Leak = json.getBoolOpt("allowIE9Leak").getOrElse(allowIE9Leak)
  def AllowIE9Leak_=(value: Bool) {
    if (AllowIE9Leak == value) return
    json("allowIE9Leak") = value
  }

  def CancelQueue = json.getFunctionExpressionOpt("cancelQueue").getOrElse(cancelQueue)
  def CancelQueue_=(value: FunctionExpression) {
    if (CancelQueue == value) return
    json("cancelQueue") = value
  }

  def ClearTransaction = json.getFunctionExpressionOpt("clearTransaction").getOrElse(clearTransaction)
  def ClearTransaction_=(value: FunctionExpression) {
    if (ClearTransaction == value) return
    json("clearTransaction") = value
  }

  def CredentialsURL = json.getValue2[JsonURL, URL]("credentialsURL").getOrElse(credentialsURL)
  def CredentialsURL_=(value: URL) {
    if (CredentialsURL == value) return
    json("credentialsURL") = value
  }

  private[RPC] val defaultPrompt: String = "Contacting Server..."
  def DefaultPrompt = json.getStringOpt("defaultPrompt").getOrElse(defaultPrompt)
  def DefaultPrompt_=(value: String) {
    if (DefaultPrompt == value) return
    json("defaultPrompt") = value
  }

  def DefaultTimeout = json.getNumberOpt("defaultTimeout").getOrElse(defaultTimeout)
  def DefaultTimeout_=(value: Number) {
    if (DefaultTimeout == value) return
    json("defaultTimeout") = value
  }

  def DefaultTransport = json.getValue2[JsonString, RPCTransport]("defaultTransport").getOrElse(defaultTransport)
  def DefaultTransport_=(value: RPCTransport) {
    if (DefaultTransport == value) return
    json("defaultTransport") = value
  }

  def ExportContent = json.getFunctionExpressionOpt("exportContent").getOrElse(exportContent)
  def ExportContent_=(value: FunctionExpression) {
    if (ExportContent == value) return
    json("exportContent") = value
  }

  def FetchDataPrompt = json.getStringOpt("fetchDataPrompt").getOrElse(fetchDataPrompt)
  def FetchDataPrompt_=(value: String) {
    if (FetchDataPrompt == value) return
    json("fetchDataPrompt") = value
  }

  def GetCurrentTransactionId = json.getFunctionExpressionOpt("getCurrentTransactionId").getOrElse(getCurrentTransactionId)
  def GetCurrentTransactionId_=(value: FunctionExpression) {
    if (GetCurrentTransactionId == value) return
    json("getCurrentTransactionId") = value
  }

  def HandleError = json.getFunctionExpressionOpt("handleError").getOrElse(handleError)
  def HandleError_=(value: FunctionExpression) {
    if (HandleError == value) return
    json("handleError") = value
  }

  def HandleTransportError = json.getFunctionExpressionOpt("handleTransportError").getOrElse(handleTransportError)
  def HandleTransportError_=(value: FunctionExpression) {
    if (HandleTransportError == value) return
    json("handleTransportError") = value
  }

  def LoadScreen = json.getFunctionExpressionOpt("loadScreen").getOrElse(loadScreen)
  def LoadScreen_=(value: FunctionExpression) {
    if (LoadScreen == value) return
    json("loadScreen") = value
  }

  def LoginRequired = json.getFunctionExpressionOpt("loginRequired").getOrElse(loginRequired)
  def LoginRequired_=(value: FunctionExpression) {
    if (LoginRequired == value) return
    json("loginRequired") = value
  }

  def PromptCursor = json.getStringOpt("promptCursor").getOrElse(promptCursor)
  def PromptCursor_=(value: String) {
    if (PromptCursor == value) return
    json("promptCursor") = value
  }

  def MaxErrorMessageLength = json.getNumberOpt("maxErrorMessageLength").getOrElse(maxErrorMessageLength)
  def MaxErrorMessageLength_=(value: Number) {
    if (MaxErrorMessageLength == value) return
    json("maxErrorMessageLength") = value
  }

  def PromptStyle = json.getValue2[JsonString, PromptStyle]("promptStyle").getOrElse(promptStyle)
  def PromptStyle_=(value: PromptStyle) {
    if (PromptStyle == value) return
    json("promptStyle") = value
  }

  def QueueSent = json.getFunctionExpressionOpt("queueSent").getOrElse(queueSent)
  def QueueSent_=(value: FunctionExpression) {
    if (QueueSent == value) return
    json("queueSent") = value
  }

  private[RPC] val removeDataPrompt: String = "Deleting Record(s)..."
  def RemoveDataPrompt = json.getStringOpt("removeDataPrompt").getOrElse(removeDataPrompt)
  def RemoveDataPrompt_=(value: String) {
    if (RemoveDataPrompt == value) return
    json("removeDataPrompt") = value
  }

  def RequestsArePending = json.getFunctionExpressionOpt("requestsArePending").getOrElse(requestsArePending)
  def RequestsArePending_=(value: FunctionExpression) {
    if (RequestsArePending == value) return
    json("requestsArePending") = value
  }

  def ResendTransaction = json.getFunctionExpressionOpt("resendTransaction").getOrElse(resendTransaction)
  def ResendTransaction_=(value: FunctionExpression) {
    if (ResendTransaction == value) return
    json("resendTransaction") = value
  }

  private[RPC] val saveDataPrompt: String = "Saving form..."
  def SaveDataPrompt = json.getStringOpt("saveDataPrompt").getOrElse(saveDataPrompt)
  def SaveDataPrompt_=(value: String) {
    if (SaveDataPrompt == value) return
    json("saveDataPrompt") = value
  }

  def ScreenLoaderURL = json.getValue2[JsonURL, URL]("screenLoaderURL").getOrElse(screenLoaderURL)
  def ScreenLoaderURL_=(value: URL) {
    if (ScreenLoaderURL == value) return
    json("screenLoaderURL") = value
  }

  def Send = json.getFunctionExpressionOpt("send").getOrElse(send)
  def Send_=(value: FunctionExpression) {
    if (Send == value) return
    json("send") = value
  }

  def SendProxied = json.getFunctionExpressionOpt("sendProxied").getOrElse(sendProxied)
  def SendProxied_=(value: FunctionExpression) {
    if (SendProxied == value) return
    json("sendProxied") = value
  }

  def SendQueue = json.getFunctionExpressionOpt("sendQueue").getOrElse(sendQueue)
  def SendQueue_=(value: FunctionExpression) {
    if (SendQueue == value) return
    json("sendQueue") = value
  }

  def ShowPrompt = json.getBoolOpt("showPrompt").getOrElse(showPrompt)
  def ShowPrompt_=(value: Bool) {
    if (ShowPrompt == value) return
    json("showPrompt") = value
  }

  def StartQueue = json.getFunctionExpressionOpt("startQueue").getOrElse(startQueue)
  def StartQueue_=(value: FunctionExpression) {
    if (StartQueue == value) return
    json("startQueue") = value
  }

  def SuspendTransaction = json.getFunctionExpressionOpt("suspendTransaction").getOrElse(suspendTransaction)
  def SuspendTransaction_=(value: FunctionExpression) {
    if (SuspendTransaction == value) return
    json("suspendTransaction") = value
  }

  private[RPC] val timeoutErrorMessage: String = "Operation timed out"
  def TimeoutErrorMessage = json.getStringOpt("timeoutErrorMessage").getOrElse(timeoutErrorMessage)
  def TimeoutErrorMessage_=(value: String) {
    if (TimeoutErrorMessage == value) return
    json("timeoutErrorMessage") = value
  }

  def UseCursorTracker = json.getBoolOpt("useCursorTracker").getOrElse(useCursorTracker)
  def UseCursorTracker_=(value: Bool) {
    if (UseCursorTracker == value) return
    json("useCursorTracker") = value
  }

  private[RPC] val validateDataPrompt: String = "Validating..."
  def ValidateDataPrompt = json.getStringOpt("validateDataPrompt").getOrElse(validateDataPrompt)
  def ValidateDataPrompt_=(value: String) {
    if (ValidateDataPrompt == value) return
    json("validateDataPrompt") = value
  }

  def XmlHttpRequestAvailable = json.getFunctionExpressionOpt("xmlHttpRequestAvailable").getOrElse(xmlHttpRequestAvailable)
  def XmlHttpRequestAvailable_=(value: FunctionExpression) {
    if (XmlHttpRequestAvailable == value) return
    json("xmlHttpRequestAvailable") = value
  }

  def sendRequest(properties: RPCRequestDyn) {
    add(what = "sendRequest", properties = properties)
  }
}