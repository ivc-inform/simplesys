package com.simplesys.akka.http

import akka.actor.ActorRef
import akka.agent.Agent
import com.simplesys.akka.http.sse.SseFutureResponse
import com.simplesys.servlet.http.HttpServletResponse.ScNotFound
import com.simplesys.servlet.http._
import com.simplesys.servlet.http.sse.SseServletRequest

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.concurrent.ExecutionContext

sealed abstract class Endpoint

object Endpoints {

    type Request2FutureResponse = (HttpServletRequest => FutureResponse)
    type Request2SseFutureResponse = (SseServletRequest => SseFutureResponse)

    object RequestResponse {
        def apply(func: Request2FutureResponse): Request2FutureResponse = func
        def apply(future: FutureResponse): Request2FutureResponse = apply(req => future)
    }

    object SseRequestResponse {
        def apply(func: Request2SseFutureResponse): Request2SseFutureResponse = func
        def apply(future: SseFutureResponse): Request2SseFutureResponse = apply(req => future)
    }

    def NotFound(uri: String): Endpoint = RequestResponse(request => FutureResponse(
        ScNotFound,
        "No endpoint available for [" + uri + "] (Error: " + ScNotFound + ")"
    ))

    def SseNotFound(uri: String): Endpoint = SseRequestResponse(request => SseFutureResponse(
        ScNotFound,
        "No endpoint available for [" + uri + "] (Error: " + ScNotFound + ")"
    ))

    type ProviderPartial = PartialFunction[String, Endpoint]
    type ProviderMap = mutable.Map[String, Endpoint]

    case class EndpointFunc(func: Request2FutureResponse) extends Endpoint
    case class SseEndpointFunc(func: Request2SseFutureResponse) extends Endpoint
    case class EndpointActor(a: ActorRef) extends Endpoint

    object Endpoint {
        def apply(a: ActorRef) = EndpointActor(a)
        def apply(func: Request2FutureResponse) = EndpointFunc(func)
        def apply(func: Request2SseFutureResponse) = SseEndpointFunc(func)
    }
}

trait EndpointFinder {
    def find(uri: String): Option[Endpoint]
}

import com.simplesys.akka.http.Endpoints._

class EndpointsAgentPartial(context: ExecutionContext) extends EndpointFinder {
    private val agent = Agent(HashMap.empty[String, ProviderPartial])(context)

    def attach(name: String, p: ProviderPartial) {
        agent.send(_ + (name -> p))
    }

    def detach(name: String) {
        agent.send(_ - name)
    }

    def find(uri: String): Option[Endpoint] = agent.get().values.collectFirst {
        case provider if provider.isDefinedAt(uri) =>
            provider(uri)
    }
}

class EndpointsAgentMap(context: ExecutionContext) extends EndpointFinder {
    private val agent = Agent(HashMap.empty[String, ProviderMap])(context)

    def attach(name: String, p: ProviderMap) {
        agent.send(_ + (name -> p))
    }

    def detach(name: String) {
        agent.send(_ - name)
    }

    def find(uri: String): Option[Endpoint] = {
        agent.get().values.collectFirst {
            case provider if provider.isDefinedAt(uri) =>
                provider(uri)
        }
    }

}