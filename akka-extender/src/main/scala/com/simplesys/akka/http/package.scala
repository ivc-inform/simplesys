package com.simplesys.akka

import akka.actor.ActorRef
import com.simplesys.akka.http.Endpoints.{Request2SseFutureResponse, Endpoint, Request2FutureResponse}

package object http {
    implicit def func2Endpoint(func: Request2FutureResponse) = Endpoint(func)
    implicit def sSefunc2Endpoint(func: Request2SseFutureResponse) = Endpoint(func)
    implicit def actor2Endpoint(a: ActorRef) = Endpoint(a)
}
