package com.simplesys.filter

import akka.actor.ActorSystem
import com.simplesys.log.Logging
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.smartClient.RPCResponse._
import com.simplesys.smartClient.{RPCResponse, RPCResponseData}
import io.circe.Json
import io.circe.syntax._
import io.circe.generic.auto._

trait Log extends Logging {
    implicit def toOpt[T](x: T): Option[T] = Some(x)
    def logJSActor(json: Json): Json = {
        logger debug json.spaces4
        json
    }
}

object SuccesAuthentication extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse, login: String, id: Long, captionUser: String, codeGroup: String)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()

        response Print (logJSActor(RPCResponse(data = RPCResponseData(status = statusSuccess, login = login, userId = id, captionUser = captionUser, codeGroup = codeGroup, simpleSysContextPath = request.ContextPath).asJson).asJson))
    }
}

object FailureAuthentication extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse, errorMessage: String)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()

        response Print (logJSActor(RPCResponse(data = RPCResponseData(status = statusLoginIncorrect, errorMessage = errorMessage).asJson).asJson))
    }
}

object LoginRequiredResponse  extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()
        
        response Print (logJSActor(RPCResponse(data = RPCResponseData(status = statusLoginIncorrect, errorMessage = "Требуется аутентификация !").asJson).asJson))
    }
}
