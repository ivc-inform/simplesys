package com.simplesys.servlet

import akka.actor.{Actor, PoisonPill}
import com.simplesys.akka.event.Logging
import com.simplesys.config.Config
import com.simplesys.json.JsonElement
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.xml.Elem
import scala.concurrent.duration._

case object GetData

trait ServletActor extends Actor with Config with Logging {

    val request: HttpServletRequest
    val response: HttpServletResponse
    val servletContext: ServletContext

    def connectionTimeOut = getInt("messaging.connectTimeout")
    def connectionTTL = getInt("messaging.connectionTTL")

    implicit val executionContext = context.dispatcher

    implicit protected val system = context.system

    def Out(out: JsonElement): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
        //system.scheduler.scheduleOnce(getDuration("app.timeOutAsyncContextComplete"))(request.AsyncContext.Complete())
    }

    def Out(out: Elem): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
        //system.scheduler.scheduleOnce(getDuration("app.timeOutAsyncContextComplete"))(request.AsyncContext.Complete())
    }

    def Out(out: String): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
        //system.scheduler.scheduleOnce(getDuration("app.timeOutAsyncContextComplete"))(request.AsyncContext.Complete())
    }

    def selfStop(): Unit = {
        self ! PoisonPill
    }
}
