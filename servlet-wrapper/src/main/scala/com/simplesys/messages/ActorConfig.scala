package com.simplesys.messages

import akka.actor.ActorSystem
import com.simplesys.config.ActorConfigTrait

object ActorConfig extends ActorConfigTrait {
    def commonPrefix = "user"

    private[this] val messageDispatcherName = "messageDicpatcher"

    private[this] val actorMessageDispatcherPath = buildSimplePath(messageDispatcherName)
    private[this] var sseMessageDispatcher: SSEMessageDispatcher = _

    def SendMessage(message: Message) = sseMessageDispatcher ! message
    def SendSibscribe(subscribe: Subscribe) = sseMessageDispatcher ! subscribe

    override def initSingletonActors(system: ActorSystem): Unit = {
        system.actorOf(DispatcherActor.props, messageDispatcherName)
        sseMessageDispatcher = new SSEMessageDispatcher(system.actorSelection(actorMessageDispatcherPath))
    }
}
