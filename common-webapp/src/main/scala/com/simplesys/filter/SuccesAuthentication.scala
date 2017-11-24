package com.simplesys.filter

import akka.actor.ActorSystem
import com.simplesys.circe.Circe._
import com.simplesys.isc.dataBinging.RPCResponse
import com.simplesys.isc.dataBinging.RPCResponse._
import com.simplesys.log.Logging
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax._

trait Log extends Logging {
    implicit def toOpt[T](x: T): Option[T] = Some(x)
    def logJSActor(response: RPCResponse): Json = {
        val json = response.asJson
        logger debug json.spaces41
        json
    }
}

object SuccesAuthentication extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse, login: String, id: Long, captionUser: String, codeGroup: String)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()

        response Print (logJSActor(RPCResponse(status = statusSuccess, login = login, userId = id, captionUser = captionUser, codeGroup = codeGroup, simpleSysContextPath = request.ContextPath)))
    }
}

object FailureAuthentication extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse, errorMessage: String)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()

        response Print (logJSActor(RPCResponse(status = statusLoginIncorrect, errorMessage = errorMessage)))
    }
}

object LoginRequiredResponse  extends Log {
    def apply(request: HttpServletRequest, response: HttpServletResponse)(implicit system: ActorSystem) {
        if (!response.IsCommitted)
            response.FlushBuffer()
        
        response Print (logJSActor(RPCResponse(status = statusLoginIncorrect, errorMessage = "Требуется аутентификация !")))
    }
}
