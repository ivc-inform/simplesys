package com.simplesys.servlet.actor

import com.simplesys.akka.event.Logging
import com.simplesys.config.Config
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.{GetData, ServletActor, ServletContext}

//@SseTransfer(urlPattern = "/Message/Subscribe")
class BaseMessagingActor(val request: SseServletRequest, val response: SseServletResponse, val servletContext: ServletContext) extends ServletActor with Config with Logging {

    override def receive = {
        case GetData =>
            response.SetConnectionTimeout(getInt("messaging.connectTimeout"))

            SendSibscribe(Subscribe(request, response))
    }
}



