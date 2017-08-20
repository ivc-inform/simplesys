package com.simplesys.messages

import java.io.IOException

import akka.actor.{Actor, PoisonPill, Props}
import com.simplesys.akka.event.Logging
import com.simplesys.json.{JsonList, JsonString}
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.{AsyncEvent, AsyncListener}

object SubscriberActor {
    def props(request: SseServletRequest, response: SseServletResponse) = Props(new SubscriberActor(request, response))
}

class SubscriberActor(val request: SseServletRequest, val response: SseServletResponse) extends Actor with Logging{

    private[this] lazy val channels: Set[String] = request.SubscribedChannels

    request.AsyncContext.AddListener(new AsyncListener {
        @throws[IOException](classOf[IOException])
        override def OnError(event: AsyncEvent): Unit = {
            event.AsyncContext.Complete()
            logger debug "OnError"
        }

        @throws[IOException](classOf[IOException])
        override def OnComplete(event: AsyncEvent): Unit = {
            self ! PoisonPill
            logger debug "OnComplete"
        }
        @throws[IOException](classOf[IOException])
        override def OnTimeout(event: AsyncEvent): Unit = {
            request.AsyncContext.Complete()
            logger debug "OnTimeout"
        }

    })

    override def receive: Receive = {
        case Message(id, data, channels, event) =>
            logger debug s"this.channels: ${this.channels.map(x => x).mkString("[",", ","]")}"
            logger debug s"arrived channels: ${channels.map(x => x).mkString("[",", ","]")}"
            val _channels = this.channels intersect channels

            if (_channels.size > 0) {
                logger debug s"intersect channels: ${_channels.map(x => x).mkString("[",", ","]")}"
                val __channels = Some(JsonList(_channels.map(JsonString(_)).toSeq:_*))
                response.SendMessage(data = data, event = event, id = Some(id), channels = __channels)
            }
    }
}