package com.simplesys.servlet

import akka.actor.{ActorSystem, PoisonPill}
import com.simplesys.akka.http.Endpoints._
import com.simplesys.akka.http.{AkkaHttpMapServlet, DynamicEndpoints, Endpoint, EndpointsAgentMap}
import com.simplesys.log.Logging

import scala.collection.mutable
import scala.collection.mutable.Map

class CommonHttpServlet extends AkkaHttpMapServlet with DynamicEndpoints with Logging {

    protected lazy val providerMap: ProviderMap = ServletContext.Attribute("ProviderMap" + ServletConfig.ServletName) match {
        case None =>
            Map.empty[String, Endpoint]
        case Some(providerMapSeq: mutable.Map[_, _]) =>
            providerMapSeq.asInstanceOf[ProviderMap]
        case any =>
            logger warn s"ProviderMap not exist type: $any"
            Map.empty[String, Endpoint]
    }

    def logProviderMap {
        logger trace s"providersMap.size: ${providerMap.size}"
        providerMap.foreach {
            case (path, endPoint) => logger debug s"path: $path, endpoint: $endPoint"
        }
    }

    override def onSystemDestroy(system: ActorSystem, endpoints: EndpointsAgentMap): Unit = {
        providerMap.foreach {
            case (path, endpont) =>
                endpont match {
                    case EndpointActor(actor) => actor ! PoisonPill
                    case _ =>
                }
        }

        super.onSystemDestroy(system, endpoints)
    }
}
