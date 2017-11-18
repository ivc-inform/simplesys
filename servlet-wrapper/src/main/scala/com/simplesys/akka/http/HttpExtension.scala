package com.simplesys.akka.http

import akka.actor.{ActorSystem, ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}
import com.simplesys.config.Config

class HttpExtension(val system: ActorSystem) extends Extension with Config {
    override val pathBasename = "akka.http"

    val AsyncTimeout: Long = getLong("timeout")
    val LogConfigOnInit = getBoolean("log-http-config-on-init")
    val ExpiredHeader: (String, String) = getString("expired-header-name") -> getString("expired-header-value")

    def logConfiguration() {
        system.log.debug(configRender)
    }
}

object HttpExtension extends ExtensionId[HttpExtension] with ExtensionIdProvider {
    def lookup() = HttpExtension

    def createExtension(system: ExtendedActorSystem) = new HttpExtension(system)
}
