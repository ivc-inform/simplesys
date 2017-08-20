package com.simplesys.isc.foundation

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.dataBinging.RPC.RPCRequestDyn

object ViewLoaderDyn {

  implicit def ViewLoader2JsonObject(in: ViewLoaderDyn): JsonObject = in json
}

class ViewLoaderDyn(override val useSelfName: Boolean = false) extends LabelDyn with ViewLoaderDynInit {
  override val selfName = "ViewLoader"

  def setViewURL(UnquotedString: URL = null, params: JsonObject = null, rpcProperties: RPCRequestDyn = null) {
    setInstanceCommandEnqueue("setViewURL(%s, %s, %s)" format(UnquotedString, params, rpcProperties));
  }

  private[this] var _allowCaching: Bool = allowCaching
  def AllowCaching = _allowCaching
  def AllowCaching_=(value: Bool) {
    if (_allowCaching == value) return
    json("allowCaching") = value
    _allowCaching = value
  }

  private[this] var _handleError: UnquotedString = handleError
  def HandleError = _handleError
  def HandleError_=(value: UnquotedString) {
    if (_handleError == value) return
    json("handleError") = value
    _handleError = value
  }

  private[this] var _httpMethod: SendMethod = httpMethod
  def HttpMethod = _httpMethod
  def HttpMethod_=(value: SendMethod) {
    if (_httpMethod == value) return
    json("httpMethod") = value
    _httpMethod = value
  }

  private[this] var _loadingMessage: HTMLString = loadingMessage
  def LoadingMessage = _loadingMessage
  def LoadingMessage_=(value: HTMLString) {
    if (_loadingMessage == value) return
    json("loadingMessage") = value
    _loadingMessage = value
  }

  private[this] var _viewRPCProperties: RPCRequestDyn = viewRPCProperties
  def ViewRPCProperties = _viewRPCProperties
  def ViewRPCProperties_=(value: RPCRequestDyn) {
    if (_viewRPCProperties == value) return
    json("viewRPCProperties") = value
    _viewRPCProperties = value
  }

  private[this] var _viewURL: URL = viewURL
  def ViewURL = _viewURL
  def ViewURL_=(value: URL) {
    if (_viewURL == value) return
    json("viewURL") = value
    _viewURL = value
  }

  private[this] var _viewURLParams: ClassDyn = viewURLParams
  def ViewURLParams = _viewURLParams
  def ViewURLParams_=(value: ClassDyn) {
    if (_viewURLParams == value) return
    json("viewURLParams") = value
    _viewURLParams = value
  }
}