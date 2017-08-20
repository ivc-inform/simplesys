package com.simplesys.akka.http

import akka.actor.ActorSystem
import com.simplesys.akka.http.Endpoints.{Endpoint, ProviderMap, ProviderPartial}

trait StaticEndpoints {
    self: AkkaPartial =>

    override def onSystemInit(system: ActorSystem, endpoints: EndpointsAgentPartial) {
        endpoints.attach("static", providersPartial)
    }

    def providersPartial: ProviderPartial
}
