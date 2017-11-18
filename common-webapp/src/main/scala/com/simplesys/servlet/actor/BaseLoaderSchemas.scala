package com.simplesys.servlet.actor

import com.simplesys.servlet._
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import io.circe.Json

//@RSTransfer(urlPattern = "/isomorphic/LoadSchemas")
class BaseLoaderSchemas(val request: HttpServletRequest, val response: HttpServletResponse, val servletContext: ServletContext) extends ServletActor {
    def receive = {
        case GetData => {
            servletContext.Attribute("schemaList") match {
                case Some(schemaList: Json) =>
                    Out(schemaList)

                case Some(_) =>
                    Out("")

                case None =>
                    Out("")
            }

            selfStop()
        }
        case x =>
            throw new RuntimeException(s"Bad branch $x")
    }
}




