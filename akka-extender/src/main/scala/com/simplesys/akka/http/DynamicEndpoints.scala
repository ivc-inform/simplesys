package com.simplesys.akka.http

import akka.actor.ActorSystem
import com.simplesys.akka.http.Endpoints._

trait DynamicEndpoints {
    self: AkkaMap =>

    override def onSystemInit(system: ActorSystem, endpoints: EndpointsAgentMap) {
        endpoints.attach("dynamic", providerMap)
    }

    protected def providerMap: ProviderMap
}


