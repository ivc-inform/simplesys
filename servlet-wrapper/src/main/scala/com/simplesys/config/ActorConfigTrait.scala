package com.simplesys.config

import akka.actor.ActorSystem

trait ActorConfigTrait extends Config {
    def commonPrefix:String

    def initSingletonActors(system: ActorSystem): Unit

    def buildSimplePath(actorName: String): String = s"/${commonPrefix}/${actorName}"
}