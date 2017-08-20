package com.simplesys.akka.event

import akka.actor.Actor
import akka.event.Logging._


trait Logging {
    actor: Actor =>

    protected lazy val logger = akka.event.Logging(context.system, this)

    implicit class levelFor(s: String) {
        def toLogLevel: LogLevel = s.toLowerCase match {
            case "error" ⇒ ErrorLevel
            case "warning" ⇒ WarningLevel
            case "info" ⇒ InfoLevel
            case "debug" ⇒ DebugLevel
            case unknown ⇒ DebugLevel
        }
    }
}