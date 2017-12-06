package com.simplesys.messages

import akka.actor._
import com.simplesys.akka.event.Logging
import com.simplesys.common.Strings._
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}

case class Subscribe(request: SseServletRequest, response: SseServletResponse)

class SSEMessageDispatcher(val dispatcher: ActorSelection) {
    def !(msg: Any) = dispatcher ! msg
}

object DispatcherActor {
    def props = Props(new DispatcherActor)
}

class DispatcherActor extends Actor with Logging {

    override def receive: Receive = {

        case Subscribe(request, response) =>
            context.actorOf(SubscriberActor.props(request, response))
            val channels = request.SubscribedChannels
            logger debug s"Subscribe to channels: ${channels.map(x => x).mkString(newLine.newLine + "[", newLine , s"]:${channels.size}".newLine)}"

        case message@Message(id, data, channels, event) =>
            logger debug s"children: ${context.children.size}"
            context.children.foreach(_ ! message)
            logger debug s"Message: ${message} sended."

        case unknown =>
            logger error s"Unknown message: ${unknown}"

    }
}