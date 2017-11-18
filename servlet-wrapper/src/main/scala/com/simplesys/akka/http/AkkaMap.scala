package com.simplesys.akka.http

import akka.actor.{ActorRef, ActorSystem}
import com.simplesys.log.{Logger, Logging}
import com.simplesys.servlet.{ServletContext, ServletRequest, ServletResponse}

trait AkkaMap {
    protected val servletContext: ServletContext

    protected var _httpSystem: Option[Tuple2[ActorSystem, EndpointsAgentMap]] = None
    protected var _supervisor: ActorRef = _
    protected var actorSystem: ActorSystem = _

    protected def initAkkaSystem(implicit system: ActorSystem) {

        actorSystem = system
        val endpoints = new EndpointsAgentMap(system.dispatcher)

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
                system.terminate()
        }
        _httpSystem = None
    }

    def onSystemInit(system: ActorSystem, endpoints: EndpointsAgentMap) {}
    def onSystemDestroy(system: ActorSystem, endpoints: EndpointsAgentMap) {}

    protected def doActor[SRQ <: ServletRequest, SRS <: ServletResponse](request: SRQ, response: SRS, timeout: Long = 0L) {
        _httpSystem.foreach {
            case (system, _) =>
                //request LogAll
                val asyncContext = request.StartAsync(request, response)
                if (timeout == 0L) {
                    val extension = HttpExtension(system)
                    asyncContext.Timeout = extension.AsyncTimeout
                } else
                    asyncContext.Timeout = timeout
                _supervisor ! asyncContext
        }
    }
}
