package com.simplesys.isc.dataBinging

import ch.qos.logback.core.db.dialect.SQLDialect
import com.simplesys.sql.SQLDialect
import io.circe.Decoder.Result
import io.circe.{HCursor, Json}

case class DSRequest(data: Json, startRow: Int, endRow: Int, sqlDialect: SQLDialect, sortBy : Json, textMatchStyle:  TextMatchStyle) extends CirceHelper {
    private val cursor: HCursor = data.hcursor
    def getString(key: String): String = cursor.downField(key).as[String] match {
        case Right(x) ⇒ x
        case Left(failure) ⇒ throw failure
    }
    def getStringOpt(key: String): Option[String] = cursor.downField(key).as[String] match {
        case Right(x) ⇒ Some(x)
        case Left(failure) ⇒ None
    }
}
