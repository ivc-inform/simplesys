package com.simplesys.isc.dataBinging

import java.io.{PrintWriter, StringWriter}

import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn
import com.simplesys.isc.system.global.RuntimeIscException
import com.simplesys.jdbc.control.{ValidationEx, ValidationNelEx, ValidationResult}
import com.simplesys.json.{JsonList, JsonObject, string2JsonElement}

class DSResponseFailureDyn(error: Throwable, status: Int = RPCResponseDyn.statusFailure) extends DSResponseDyn {
    override val useSelfName = true

    Status = status

    val stackTrace = new StringWriter()
    error.printStackTrace(new PrintWriter(stackTrace))

    logger error s"message: ${error.getMessage}"
    logger error s"stackTrace: ${stackTrace.toString}"

    Data = JsonObject("error" ->
      JsonObject(
          ("message" -> error.getMessage),
          ("stackTrace" -> stackTrace.toString)))
}

class DSResponseFailureExDyn(result: ValidationEx[_], _status: Int = RPCResponseDyn.statusFailure) extends DSResponseDyn {
    override val useSelfName = true

    result printException match {
        case None =>
            throw RuntimeIscException("Invalid branch")

        case Some(ValidationResult(message, stackTrace)) =>
            Status = _status

            logger error s"message: $message"
            logger error s"stackTrace: $stackTrace"

            Data = JsonObject("error" ->
              JsonObject(
                  ("message" -> message),
                  ("stackTrace" -> stackTrace)))
    }
}

class DSResponseFailureNelExDyn(result: ValidationNelEx[_], status: Int = RPCResponseDyn.statusFailure) extends DSResponseDyn {
    override val useSelfName = true

    result printException match {
        case None =>
            throw RuntimeIscException("Invalid branch")

        case Some(list) =>
            Status = status

            Data = JsonObject("error" -> JsonList(list.list.map {
                case ValidationResult(message, stackTrace) =>
                    logger error s"message: $message"
                    logger error s"stackTrace: $stackTrace"

                    JsonObject(
                        ("message" -> message),
                        ("stackTrace" -> stackTrace))
            }.toList: _*))
    }
}
