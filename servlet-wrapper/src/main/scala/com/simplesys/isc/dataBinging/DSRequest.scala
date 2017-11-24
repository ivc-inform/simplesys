package com.simplesys.isc.dataBinging

import java.time.LocalDateTime

import com.simplesys.circe.Circe._
import io.circe.Json

case class Transaction(transactionNum: Option[String] = None, operations: Seq[Json] = Seq.empty)

case class DSRequest(request: Json, startRow: Option[Int] = None, endRow: Option[Int] = None, textMatchStyle: Option[String] = None, sortBy: Vector[Json] = Vector.empty, transaction: Option[Transaction] = None, oldValues: Option[Json] = None) {

    def toPrettyString = request.toPrettyString

    def getString(key: String): String = request getString key

    def getStringOpt(key: String): Option[String] = request getStringOpt key

    def getLong(key: String): Long = request getLong key

    def getLongOpt(key: String): Option[Long] = request getLongOpt key

    def getInt(key: String): Int = request getInt key

    def getIntOpt(key: String): Option[Int] = request getIntOpt key

    def getDouble(key: String): Double = request getDouble key

    def getDoubleOpt(key: String): Option[Double] = request getDoubleOpt key

    def getLocalDateTime(key: String): LocalDateTime = request getLocalDateTime key

    def getLocalDateTimeOpt(key: String): Option[LocalDateTime] = request getLocalDateTimeOpt key

    def getJsonObject(key: String): Json = request getJsonObject key

    def getJsonObjectOpt(key: String): Option[Json] = request getJsonObjectOpt key

    def getBoolean(key: String): Boolean = request getBoolean key

    def getBooleanOpt(key: String): Option[Boolean] = request getBooleanOpt key

    def getJsonList(key: String): Vector[Json] = request getJsonList key

    def getJsonListOpt(key: String): Option[Vector[Json]] = request getJsonListOpt key

    def getJsonElement(key: String): Option[Json] = request getJsonElement key
}
