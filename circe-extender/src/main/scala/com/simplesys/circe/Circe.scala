package com.simplesys.circe

import java.time.LocalDateTime

import io.circe.{HCursor, Json}
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
    }

    implicit def impString(str: String): Json = fromString(str)
    implicit def impStringopt(str: Option[String]): Json = if (str.isEmpty) Json.Null else fromString(str.get)
    implicit def impStringarr(str: Array[String]): Json = if (str.isEmpty) Json.Null else fromString(str.head)

    implicit def impLong(long: Long): Json = fromLong(long)
    implicit def impLongopt(long: Option[Long]): Json = if (long.isEmpty) Json.Null else fromLong(long.get)
    implicit def impLongarr(long: Array[Long]): Json = if (long.isEmpty) Json.Null else fromLong(long.head)

    implicit def impDouble(double: Double): Json = fromDouble(double)getOrElse(Json.Null)
    implicit def impDoubleopt(double: Option[Double]): Json = if (double.isEmpty) Json.Null else fromDouble(double.get).getOrElse(Json.Null)
    implicit def impDoublearr(double: Array[Double]): Json = if (double.isEmpty) Json.Null else fromDouble(double.head).getOrElse(Json.Null)

    implicit def impLocalDateTime(localDateTime: LocalDateTime): Json = fromString(localDateTime.asString())
    implicit def impLocalDateTime(localDateTime: Option[LocalDateTime]): Json = if (localDateTime.isEmpty) Json.Null else  fromString(localDateTime.get.asString())
    implicit def impLocalDateTime(localDateTime: Array[LocalDateTime]): Json = if (localDateTime.isEmpty) Json.Null else  fromString(localDateTime.head.asString())
}
