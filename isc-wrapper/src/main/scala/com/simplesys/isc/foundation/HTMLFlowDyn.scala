package com.simplesys.isc.foundation

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.typesDyn.SendMethod

object HTMLFlowDyn {

  implicit def HTMLFlowtoJsonObject(in: HTMLFlowDyn): JsonObject = in json
}

class HTMLFlowDyn(override val useSelfName: Boolean = false) extends CanvasDyn with HTMLFlowDynInit {
  override val selfName = "HTMLFlow"

  private[this] var _allowCaching: Bool = allowCaching
  def AllowCaching = _allowCaching
  def AllowCaching_=(value: Bool) {
    if (_allowCaching == value) return
    json("allowCaching") = value
    _allowCaching = value
  }

  private[this] var _captureSCComponents: Bool = captureSCComponents
  def CaptureSCComponents = _captureSCComponents
  def CaptureSCComponents_=(value: Bool) {
    if (_captureSCComponents == value) return
    json("captureSCComponents") = value
    _captureSCComponents = value
  }

  private[this] var _contentsType: String = contentsType
  def ContentsType = _contentsType
  def ContentsType_=(value: String) {
    if (_contentsType == value) return
    json("contentsType") = value
    _contentsType = value
  }

  private[this] var _contentsURL: URL = contentsURL
  def ContentsURL = _contentsURL
  def ContentsURL_=(value: URL) {
    if (_contentsURL == value) return
    json("contentsURL") = value
    _contentsURL = value
  }

  private[this] var _contentsURLParams: JsonObject = contentsURLParams
  def ContentsURLParams = _contentsURLParams
  def ContentsURLParams_=(value: JsonObject) {
    if (_contentsURLParams == value) return
    json("contentsURLParams") = value
    _contentsURLParams = value
  }

  private[this] var _evalScriptBlocks: Bool = evalScriptBlocks
  def EvalScriptBlocks = _evalScriptBlocks
  def EvalScriptBlocks_=(value: Bool) {
    if (_evalScriptBlocks == value) return
    json("evalScriptBlocks") = value
    _evalScriptBlocks = value
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

  private[this] var _prefix: HTMLString = prefix
  def Prefix = _prefix
  def Prefix_=(value: HTMLString) {
    if (_prefix == value) return
    json("prefix") = value
    _prefix = value
  }
}