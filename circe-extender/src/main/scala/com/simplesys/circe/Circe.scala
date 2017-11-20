package com.simplesys.circe

import io.circe.{HCursor, Json}

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
}
