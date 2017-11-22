package com.simplesys.servlet.isc

import akka.actor.{Actor, PoisonPill}
import com.simplesys.config.Config
import com.simplesys.isc.dataBinging.{DSResponse, DSResponseFailureEx}
import com.simplesys.log.Logging
import com.simplesys.servlet.ServletContext
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.xml.Elem
import io.circe.Json
import io.circe.Json._
import io.circe.generic.auto._
import io.circe.syntax._

case object GetData

trait ServletActor extends Actor with Config with Logging {

    val request: HttpServletRequest
    val response: HttpServletResponse
    val servletContext: ServletContext

    def connectionTimeOut = getInt("messaging.connectTimeout")
    def connectionTTL = getInt("messaging.connectionTTL")

    implicit val executionContext = context.dispatcher

    implicit protected val system = context.system

    def Out(out: DSResponse): Unit = {
        response PrintAndFlush obj("response" → out.asJson)
        request.AsyncContext.Complete()
    }

    def Out(out: DSResponseFailureEx): Unit = {
            response PrintAndFlush obj("response" → out.asJson)
            request.AsyncContext.Complete()
        }

    def Out(out: Json): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
    }

    def Out(out: Elem): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
    }

    def Out(out: String): Unit = {
        response PrintAndFlush out
        request.AsyncContext.Complete()
    }

    def selfStop(): Unit = {
        self ! PoisonPill
    }
}
