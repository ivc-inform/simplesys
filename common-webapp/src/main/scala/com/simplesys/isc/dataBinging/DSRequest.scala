package com.simplesys.isc.dataBinging

import com.simplesys.circe.Circe._
import io.circe.Json
import io.circe.Json._

case class Transaction(transactionNum: String)

case class DSRequest(data: Json, startRow: Option[Int] = None, endRow: Option[Int] = None, textMatchStyle: Option[String] = None, sortBy: Option[Json] = Some(fromString("exact")), transaction: Option[Transaction] = None) extends CirceHelper {

    def getString(key: String): String = data getString key

    def getStringOpt(key: String): Option[String] = data getStringOpt key
}
