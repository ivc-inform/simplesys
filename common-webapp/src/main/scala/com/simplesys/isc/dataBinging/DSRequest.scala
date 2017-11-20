package com.simplesys.isc.dataBinging

import ch.qos.logback.core.db.dialect.SQLDialect
import com.simplesys.sql.SQLDialect
import io.circe.Decoder.Result
import io.circe.{HCursor, Json}
import com.simplesys.circe.Circe._

case class DSRequest(data: Json, startRow: Option[Int] = None, endRow: Option[Int] = None) extends CirceHelper {

    def getString(key: String): String = data getString key

    def getStringOpt(key: String): Option[String] = data getStringOpt key
}
