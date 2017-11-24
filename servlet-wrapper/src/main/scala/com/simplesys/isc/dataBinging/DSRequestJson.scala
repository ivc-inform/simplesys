package com.simplesys.isc.dataBinging

import java.time.LocalDateTime

import com.simplesys.circe.Circe._
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._

case class Transaction(transactionNum: Option[String] = None, operations: Seq[Json] = Seq.empty)

case class DSRequest(startRow: Option[Int] = None, endRow: Option[Int] = None, textMatchStyle: Option[String] = None, sortBy: Vector[Json] = Vector.empty, transaction: Option[Transaction] = None, oldValues: Option[Json] = None)

case class DSRequestJson(dsRequest: DSRequest) {

    private val json = dsRequest.asJson

    def toPrettyString = json.toPrettyString

    def getString(key: String): String = json getString key

    def getStringOpt(key: String): Option[String] = json getStringOpt key

    def getLong(key: String): Long = json getLong key

    def getLongOpt(key: String): Option[Long] = json getLongOpt key

    def getInt(key: String): Int = json getInt key

    def getIntOpt(key: String): Option[Int] = json getIntOpt key

    def getDouble(key: String): Double = json getDouble key

    def getDoubleOpt(key: String): Option[Double] = json getDoubleOpt key

    def getLocalDateTime(key: String): LocalDateTime = json getLocalDateTime key

    def getLocalDateTimeOpt(key: String): Option[LocalDateTime] = json getLocalDateTimeOpt key

    def getJsonObject(key: String): Json = json getJsonObject key

    def getJsonObjectOpt(key: String): Option[Json] = json getJsonObjectOpt key

    def getBoolean(key: String): Boolean = json getBoolean key

    def getBooleanOpt(key: String): Option[Boolean] = json getBooleanOpt key

    def getJsonList(key: String): Vector[Json] = json getJsonList key

    def getJsonListOpt(key: String): Option[Vector[Json]] = json getJsonListOpt key

    def getJsonElement(key: String): Option[Json] = json getJsonElement key
}
