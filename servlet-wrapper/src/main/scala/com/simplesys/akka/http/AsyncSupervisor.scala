package com.simplesys.akka.http

import akka.actor.{Props, OneForOneStrategy, Actor}
import akka.actor.SupervisorStrategy.Stop
import com.simplesys.servlet.{ServletContext, AsyncContext}

object AsyncSupervisor {
    def props(endpoints: EndpointFinder, servletContext: ServletContext): Props = Props(new AsyncSupervisor(endpoints, servletContext))
}

class AsyncSupervisor(val endpoints: EndpointFinder, val servletContext: ServletContext) extends Actor {

    override def supervisorStrategy() = OneForOneStrategy() {
        case _: Exception => Stop
    }

    def receive = {
        case asyncContext: AsyncContext =>
            context.actorOf(AsyncActor.props(endpoints, servletContext)) ! asyncContext
    }
}