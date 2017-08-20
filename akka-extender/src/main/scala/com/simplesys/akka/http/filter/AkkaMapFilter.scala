package com.simplesys.akka.http.filter

import java.io.IOException
import javax.servlet.ServletException

import akka.actor.ActorSystem
import com.simplesys.akka.http.AkkaMap
import com.simplesys.servlet.{Filter, FilterChain, ServletRequest, ServletResponse}

class AkkaMapFilter extends Filter with AkkaMap {

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
        doActor(request, response)
        chain.DoFilter(request, response)
    }
}