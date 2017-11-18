package com.simplesys.akka.http.sse

import akka.actor.ActorSystem
import com.simplesys.akka.http.AkkaMap
import com.simplesys.config.Config
import com.simplesys.servlet.http.sse.{SseServlet, SseServletRequest, SseServletResponse}

class AkkaSseMapServlet extends SseServlet with AkkaMap with Config{

    protected lazy val servletContext = ServletContext
    protected lazy val servletConfig = ServletConfig

    override def Init() {
        initAkkaSystem(servletContext.Attribute("actorSystem").get.asInstanceOf[ActorSystem])
    }

    override def Destroy() {
        destroyAkkaSystem()
    }

    override protected def SseService(request: SseServletRequest, response: SseServletResponse): Unit = {
        doActor(request, response, getLong("messaging.connectionTTL"))
    }
}