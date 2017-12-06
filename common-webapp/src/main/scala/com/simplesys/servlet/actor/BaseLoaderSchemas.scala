package com.simplesys.servlet.actor

import com.simplesys.isc.dataBinging.DSResponse
import com.simplesys.servlet._
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.servlet.isc.{GetData, ServletActor}
import io.circe.Json

//@RSTransfer(urlPattern = "/isomorphic/LoadSchemas")
class BaseLoaderSchemas(val request: HttpServletRequest, val response: HttpServletResponse, val servletContext: ServletContext) extends ServletActor {
    def receive = {
        case GetData => {
            servletContext.Attribute("schemaList") match {
                case Some(schemaList: DSResponse) =>
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




