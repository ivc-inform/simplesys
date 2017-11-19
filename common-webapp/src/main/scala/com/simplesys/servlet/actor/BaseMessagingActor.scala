package com.simplesys.servlet.actor

import com.simplesys.messages.ActorConfig._
import com.simplesys.messages.Subscribe
import com.simplesys.servlet.ServletContext
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.isc.{GetData, ServletActor}

//@SseTransfer(urlPattern = "/Message/Subscribe")
class BaseMessagingActor(val request: SseServletRequest, val response: SseServletResponse, val servletContext: ServletContext) extends ServletActor{

    override def receive = {
        case GetData =>
            response.SetConnectionTimeout(getInt("messaging.connectTimeout"))

            SendSibscribe(Subscribe(request, response))
    }
}



