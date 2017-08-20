package com.simplesys.akka.http.filter

import java.io.IOException
import javax.servlet.ServletException

import akka.actor.ActorSystem
import com.simplesys.akka.http.{AkkaPartial, EndpointsAgentPartial}
import com.simplesys.servlet._
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}


class AkkaPartialFilter extends Filter with AkkaPartial {

    implicit protected var actorSystem: ActorSystem = _

    override def onSystemInit(system: ActorSystem, endpoints: EndpointsAgentPartial) {
        super.onSystemInit(system, endpoints)
        actorSystem = system
    }

    protected lazy val servletContext = FilterContext

    override def Init {
        initAkkaSystem(servletContext.Attribute("actorSystem").get.asInstanceOf[ActorSystem])
    }

    override def Destroy() {
        destroyAkkaSystem()
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override protected def DoFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        doActor(HttpServletRequest(request), HttpServletResponse(response))
        chain.DoFilter(request, response)
    }
}