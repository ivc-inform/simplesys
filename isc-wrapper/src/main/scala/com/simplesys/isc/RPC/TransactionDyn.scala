package com.simplesys.isc.RPC

import com.simplesys.json.{JsonString, JsonList, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.dataBinging.DSRequestDyn

object TransactionDyn extends TransactionDynInit {

  implicit def TransactionDyn2JsonObject(in: TransactionDyn): JsonObject = in json
  implicit def JsonObject2TransactionDyn(in: JsonObject): TransactionDyn = new TransactionDyn(in)
}

class TransactionDyn(override val inJson: JsonObject = null) extends ClassDyn with TransactionDynInit {
  override val selfName = "TransactionDyn"

  //ReadOnly !!!
  def TransactionNum = json.getNumberOpt("transactionNum").getOrElse(transactionNum)

  //ReadOnly !!!
  def Operations: ArrayDyn[DSRequestDyn] = json.getJsonListOpt("operations").headOption match {
    case Some(list) => list
    case None => ArrayDyn.empty[DSRequestDyn]
  }
}
