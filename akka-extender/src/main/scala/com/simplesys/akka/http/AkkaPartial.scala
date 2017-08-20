package com.simplesys.akka.http

import akka.actor.{ActorRef, ActorSystem}
import com.simplesys.servlet.{ServletContext, ServletRequest, ServletResponse}

trait AkkaPartial {
    protected val servletContext: ServletContext

    protected var _httpSystem: Option[Tuple2[ActorSystem, EndpointsAgentPartial]] = None
    protected var _supervisor: ActorRef = _

    protected def initAkkaSystem(implicit system: ActorSystem) {

        val endpoints = new EndpointsAgentPartial(system.dispatcher)

        _supervisor = system.actorOf(AsyncSupervisor.props(endpoints, servletContext))

        _httpSystem = Some(system -> endpoints)
        onSystemInit(system, endpoints)

        logConfigOnInit()
    }

    protected[http] def logConfigOnInit() {
        _httpSystem.foreach {
            case (system, _) =>
                val ext = HttpExtension(system)
                if (ext.LogConfigOnInit)
                    ext.logConfiguration()
        }
    }

    protected def destroyAkkaSystem() {
        _httpSystem.foreach {
            case (system, endpoints) =>
                onSystemDestroy(system, endpoints)
                //endpoints.close()
                //system.terminate()
                system.awaitTermination()
        }
        _httpSystem = None
    }

    def onSystemInit(system: ActorSystem, endpoints: EndpointsAgentPartial) {}
    def onSystemDestroy(system: ActorSystem, endpoints: EndpointsAgentPartial) {}

    protected def doActor[SRQ <: ServletRequest, SRS <: ServletResponse](request: SRQ, response: SRS) {
        _httpSystem.foreach {
            case (system, _) =>
                //request LogAll
                val asyncContext = request.StartAsync(request, response)
                val extension = HttpExtension(system)
                asyncContext.Timeout = extension.AsyncTimeout
                _supervisor ! asyncContext
        }
    }
}
