package com.simplesys.circe

import java.time.LocalDateTime

import io.circe.{HCursor, Json, JsonObject}
import io.circe.Json._
import com.simplesys.common.Strings._

object Circe {
    implicit class CirceOpt(json: Json) {
        def toPrettyString = json.spaces4

        val cursor: HCursor = json.hcursor

        def getString(key: String): String = cursor.downField(key).as[String] match {
            case Right(x) ⇒ x
            case Left(failure) ⇒ throw failure
        }

        def getStringOpt(key: String): Option[String] = cursor.downField(key).as[String] match {
            case Right(x) ⇒ Some(x)
            case Left(_) ⇒ None
        }

        def getLong(key: String): Long = cursor.downField(key).as[Long] match {
            case Right(x) ⇒ x
            case Left(failure) ⇒ throw failure
        }

        def getLongOpt(key: String): Option[Long] = cursor.downField(key).as[Long] match {
            case Right(x) ⇒ Some(x)
            case Left(_) ⇒ None
        }

        def getDouble(key: String): Double = cursor.downField(key).as[Double] match {
            case Right(x) ⇒ x
            case Left(failure) ⇒ throw failure
        }

        def getDoubleOpt(key: String): Option[Double] = cursor.downField(key).as[Double] match {
            case Right(x) ⇒ Some(x)
            case Left(_) ⇒ None
        }

        def getLocalDateTime(key: String): LocalDateTime = cursor.downField(key).as[String] match {
            case Right(x) ⇒ x.toLocalDateTime()
            case Left(failure) ⇒ throw failure
        }

        def getLocalDateTimeOpt(key: String): Option[LocalDateTime] = cursor.downField(key).as[String] match {
            case Right(x) ⇒ Some(x.toLocalDateTime())
            case Left(_) ⇒ None
        }

        def getJsonObject(key: String): Json = cursor.downField(key).as[Json] match {
            case Right(x) ⇒ x
            case Left(failure) ⇒ throw failure
        }

        def getJsonObjectOpt(key: String): Option[Json] = cursor.downField(key).as[Json] match {
            case Right(x) ⇒ Some(x)
            case Left(_) ⇒ None
        }

        def getBoolean(key: String): Boolean = cursor.downField(key).as[Boolean] match {
            case Right(x) ⇒ x
            case Left(failure) ⇒ throw failure
        }

        def getBooleanOpt(key: String): Option[Boolean] = cursor.downField(key).as[Boolean] match {
            case Right(x) ⇒ Some(x)
            case Left(_) ⇒ None
        }

        def append(_json: Json): Json = json.asObject match {
            case None ⇒ _json
            case Some(jsonObject) ⇒
                _json.asObject match {
                    case None ⇒ json
                    case Some(_jsonObject) ⇒
                        fromFields(jsonObject.toMap ++ _jsonObject.toMap)
                }

        }

        def append(_json: Option[Json]): Json = json.asObject match {
            case None ⇒ _json.getOrElse(Json.Null)
            case Some(jsonObject) ⇒
                _json.getOrElse(Json.Null).asObject match {
                    case None ⇒ json
                    case Some(_jsonObject) ⇒
                        fromFields(jsonObject.toMap ++ _jsonObject.toMap)
                }

        }

        implicit class Circe1Opt(json: Option[Json]) {
            def toPrettyString = json.getOrElse(Json.Null).spaces4

            def append(_json: Json): Json = json.getOrElse(Json.Null).asObject match {
                case None ⇒ _json
                case Some(jsonObject) ⇒
                    _json.asObject match {
                        case None ⇒ json.getOrElse(Json.Null)
                        case Some(_jsonObject) ⇒
                            fromFields(jsonObject.toMap ++ _jsonObject.toMap)
                    }

            }

            def append(_json: Option[Json]): Json = json.getOrElse(Json.Null).asObject match {
                case None ⇒ _json.getOrElse(Json.Null)
                case Some(jsonObject) ⇒
                    _json.getOrElse(Json.Null).asObject match {
                        case None ⇒ json.getOrElse(Json.Null)
                        case Some(_jsonObject) ⇒
                            fromFields(jsonObject.toMap ++ _jsonObject.toMap)
                    }
            }
        }
    }

    implicit def impString(str: String): Json = fromString(str)
    implicit def impStringopt(str: Option[String]): Json = if (str.isEmpty) Json.Null else fromString(str.get)
    implicit def impStringarr(str: Array[String]): Json = if (str.isEmpty) Json.Null else fromString(str.head)

    implicit def impLong(long: Long): Json = fromLong(long)
    implicit def impLongopt(long: Option[Long]): Json = if (long.isEmpty) Json.Null else fromLong(long.get)
    implicit def impLongarr(long: Array[Long]): Json = if (long.isEmpty) Json.Null else fromLong(long.head)

    implicit def impBoolean(long: Boolean): Json = fromBoolean(long)
    implicit def impBooleanopt(long: Option[Boolean]): Json = if (long.isEmpty) Json.Null else fromBoolean(long.get)
    implicit def impBooleanarr(long: Array[Boolean]): Json = if (long.isEmpty) Json.Null else fromBoolean(long.head)

    implicit def impInt(long: Int): Json = fromInt(long)
    implicit def impIntopt(long: Option[Int]): Json = if (long.isEmpty) Json.Null else fromInt(long.get)
    implicit def impIntarr(long: Array[Int]): Json = if (long.isEmpty) Json.Null else fromInt(long.head)

    implicit def impDouble(double: Double): Json = fromDouble(double) getOrElse (Json.Null)
    implicit def impDoubleopt(double: Option[Double]): Json = if (double.isEmpty) Json.Null else fromDouble(double.get).getOrElse(Json.Null)
    implicit def impDoublearr(double: Array[Double]): Json = if (double.isEmpty) Json.Null else fromDouble(double.head).getOrElse(Json.Null)

    implicit def impLocalDateTime(localDateTime: LocalDateTime): Json = fromString(localDateTime2Str(localDateTime))
    implicit def impLocalDateTime(localDateTime: Option[LocalDateTime]): Json = if (localDateTime.isEmpty) Json.Null else fromString(localDateTime2Str(localDateTime.get))
    implicit def impLocalDateTime(localDateTime: Array[LocalDateTime]): Json = if (localDateTime.isEmpty) Json.Null else fromString(localDateTime2Str(localDateTime.head))

    implicit def seq2Json(seq: Seq[(String, Json)]): Json = fromJsonObject(JsonObject.fromIterable(seq))
}
