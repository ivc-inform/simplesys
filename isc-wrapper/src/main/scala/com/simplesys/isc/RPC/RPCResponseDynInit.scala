package com.simplesys.isc.dataBinging.RPC

import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonList, JsonNull, JsonObject}
import com.simplesys.log.Logging

trait RPCResponseDynInit extends Logging{
  protected val clientContext: JsonObject = JsonObject()
  private[RPC] val data: JsonElement = JsonNull
  protected val httpHeaders: JsonList = null
  protected val httpResponseCode: Number = null
  protected val httpResponseText: String = ""
  private[dataBinging] val status: Number = null
  protected val transactionNum: Number = null
}
