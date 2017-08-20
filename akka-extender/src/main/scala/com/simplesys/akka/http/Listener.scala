package com.simplesys.akka.http

import akka.actor.{ActorSystem, ActorRef}
import com.simplesys.servlet.http.sse.SseServletResponse
import com.simplesys.servlet.http.{HttpServletResponse, HeaderString}
import com.simplesys.servlet.{AsyncEvent, AsyncListener}

class Listener(actor: ActorRef)(implicit system: ActorSystem) extends AsyncListener {

    import Listener._

    def onComplete(event: AsyncEvent) {
        tell(event, On_Complete)
    }

    def onError(event: AsyncEvent) {
        tell(event, On_Error)
    }

    def onStartAsync(event: AsyncEvent) {
        tell(event, On_StartAsync)
    }

    def onTimeout(event: AsyncEvent) {
        tell(event, On_Timeout)
        val asyncContext = event.AsyncContext

        asyncContext.Response match {
            case response: SseServletResponse =>
                val (name, value) = HttpExtension(system).ExpiredHeader
                response += HeaderString(name, value)

            case response: HttpServletResponse =>
                val (name, value) = HttpExtension(system).ExpiredHeader
                response += HeaderString(name, value)
        }

        asyncContext.Complete()
    }

    private def tell(event: AsyncEvent, on: On_Event) {
        actor ! AsyncEventMessage(event, on)
    }
}

object Listener {
    abstract sealed class On_Event
    case object On_StartAsync extends On_Event

    abstract sealed class On_EndAsync extends On_Event
    case object On_Error extends On_EndAsync
    case object On_Complete extends On_EndAsync
    case object On_Timeout extends On_EndAsync

    case class AsyncEventMessage(event: AsyncEvent, on: On_Event)
}