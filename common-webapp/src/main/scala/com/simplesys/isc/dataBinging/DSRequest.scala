package com.simplesys.isc.dataBinging

import java.time.LocalDateTime

import com.simplesys.circe.Circe._
import io.circe.{Json, JsonObject}
import io.circe.Json._

case class Transaction(transactionNum: Option[String] = None, operations: Seq[Json] = Seq.empty)

case class DSRequest(data: JsonObject, startRow: Option[Int] = None, endRow: Option[Int] = None, textMatchStyle: Option[String] = None, sortBy: Vector[Json] = Vector(fromString("exact")), transaction: Option[Transaction] = None, oldValues: Option[Json] = None) {

    def toPrettyString = data.toPrettyString

    def getString(key: String): String = data getString key

    def getStringOpt(key: String): Option[String] = data getStringOpt key

    def getLong(key: String): Long = data getLong key

    def getLongOpt(key: String): Option[Long] = data getLongOpt key

    def getDouble(key: String): Double = data getDouble key

    def getDoubleOpt(key: String): Option[Double] = data getDoubleOpt key

    def getLocalDateTime(key: String): LocalDateTime = data getLocalDateTime key

    def getLocalDateTimeOpt(key: String): Option[LocalDateTime] = data getLocalDateTimeOpt key

    def getJsonObject(key: String): Json = data getJsonObject key

    def getJsonObjectOpt(key: String): Option[Json] = data getJsonObjectOpt key

    def getBoolean(key: String): Boolean = data getBoolean key

    def getBooleanOpt(key: String): Option[Boolean] = data getBooleanOpt key

    def getJsonList(key: String): Vector[Json] = data getJsonList  key

    def getJsonListOpt(key: String): Option[Vector[Json]] = data getJsonListOpt  key

    def getProxyObject: Map[String, Json] = data.getProxyObject

    def getJsonElement(key: String): Option[Json] = data getJsonElement key
}
