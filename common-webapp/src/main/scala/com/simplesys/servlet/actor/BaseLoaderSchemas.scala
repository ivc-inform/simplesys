package com.simplesys.servlet.actor

import com.simplesys.common.Strings._
import com.simplesys.isc.dataBinging.{DSRequestDyn, DSResponseDyn}
import com.simplesys.isc.system.ServletActorDyn
import com.simplesys.servlet._
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}

//@RSTransfer(urlPattern = "/isomorphic/LoadSchemas")
class BaseLoaderSchemas(val request: HttpServletRequest, val response: HttpServletResponse, val servletContext: ServletContext) extends ServletActorDyn {
    val requestData = new DSRequestDyn(request)

    def receive = {
        case GetData => {
            val data = requestData.Data

            logger debug s"data: ${newLine + data.toPrettyString}"

            servletContext.Attribute("schemaList") match {
                case Some(schemaList: DSResponseDyn) =>
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




