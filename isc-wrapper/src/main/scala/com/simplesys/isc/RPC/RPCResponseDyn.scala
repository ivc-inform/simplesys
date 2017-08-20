package com.simplesys.isc.dataBinging.RPC

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.misc.Number

object RPCResponseDyn {

  implicit def RPCResponse1toJsonObject(in: RPCResponseDyn): JsonObject = in json

  val statusSuccess = 0
  val statusOffline = 1
  val statusFailure = -1
  val statusValidationError = -4
  val statusLoginIncorrect = -5
  val statusMaxLogginAttemptsExceeded = -6
  val statusLoginRequired = -7
  val statusLoginSuccess = -8
  val statusUpdateWithoutPkError = -9
  val statusTransactionFailed = -10
  val statusTransportError = -90
  val statusUnknownHostError = -91
  val statusConnetionResetError = -92
  val statusServerTimeout = -100
}

class RPCResponseDyn(override val inJson: JsonObject = null,
                     override val useSelfName: Boolean = false) extends ClassDyn with RPCResponseDynInit {
  override val selfName = "RPCResponse"

  private[this] var _clientContext: JsonObject = clientContext
  def ClientContext = _clientContext
  def ClientContext_=(value: JsonObject) {
    json("clientContext") = value
    _clientContext = value
  }

  def Data = json.getJsonElement("data").getOrElse(data)
  def Data_=(value: JsonElement) {
    if (Data == value) return
    json("data") = value
  }

  def HttpHeaders = json.getJsonListOpt("httpHeaders").getOrElse(httpHeaders)
  def HttpHeaders_=(value: JsonList) {
    if (HttpHeaders == value) return
    json("httpHeaders") = value
  }

  private[this] var _httpResponseCode: Number = httpResponseCode
  def HttpResponseCode = _httpResponseCode
  def HttpResponseCode_=(value: Number) {
    if (_httpResponseCode == value) return
    json("httpResponseCode") = value
    _httpResponseCode = value
  }

  private[this] var _httpResponseText: String = httpResponseText
  def HttpResponseText = _httpResponseText
  def HttpResponseText_=(value: String) {
    if (_httpResponseText == value) return
    json("httpResponseText") = value
    _httpResponseText = value
  }

  private[this] var _status: Number = status
  def Status = _status
  def Status_=(value: Number) {
    if (_status == value) return
    json("status") = value
    _status = value
  }

  private[this] var _transactionNum: Number = transactionNum
  def TransactionNum = _transactionNum
  def TransactionNum_=(value: Number) {
    if (_transactionNum == value) return
    json("transactionNum") = value
    _transactionNum = value
  }
}

