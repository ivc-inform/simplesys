package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.global.RuntimeIscException
import com.simplesys.jdbc.control.{ValidationEx, ValidationResult}
import com.simplesys.log.Logging
import io.circe.Json
import io.circe.JsonObject
import io.circe.Json._

trait DSResponseBase {
    val data: Json
    val status: Int
    val totalRows: Option[Int]
}
case class DSResponse(data: Json, status: Int, totalRows: Option[Int] = None) extends DSResponseBase
case class DSResponseFailureEx(result: ValidationEx[_]) extends DSResponseBase with Logging {


    override val totalRows = None

    override val status = RPCResponse.statusFailure
    
    override val data = if (result.printException.isEmpty)
        Json.Null
    else
        JsonObject.singleton("error", fromJsonObject(JsonObject.fromIterable(Seq("message" → fromString(result.printException.get.message), "stackTrace" → fromString(result.printException.get.stackTrace)))))

    result printException match {
        case None =>
            throw RuntimeIscException("Invalid branch")

        case Some(ValidationResult(message, stackTrace)) =>

            logger error s"message: $message"
            logger error s"stackTrace: $stackTrace"

    }
}
