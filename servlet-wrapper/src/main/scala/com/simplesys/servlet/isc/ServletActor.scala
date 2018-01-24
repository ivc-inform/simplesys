package com.simplesys.servlet.isc


import akka.actor.{Actor, PoisonPill}
import com.simplesys.config.Config
import com.simplesys.isc.dataBinging.{DSResponse, Response}
import com.simplesys.isc.dataBinging.DSResponse._
import com.simplesys.log.Logging
import com.simplesys.servlet.ServletContext
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.xml.Elem
import com.simplesys.circe.Circe._
import io.circe.Json
import io.circe.Json._
import io.circe.generic.auto._
import io.circe.syntax._

import scala.compat.Platform.EOL

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
        val _out = Response(out).asJson
        logger trace s"out: ${_out.spaces41}"
        response PrintAndFlush _out
        request.AsyncContext.Complete()
    }

    def OutOk: Unit = {
        val _out = Response(DSResponseOk).asJson
        logger trace s"out: ${_out.spaces41}"
        response PrintAndFlush _out
        request.AsyncContext.Complete()
    }

    def OutFailure(e: Throwable): Unit = {
        val _out = Response(DSResponseFailureEx(message = e.getMessage, stackTrace = e.getStackTrace().mkString("", EOL, EOL))).asJson
        logger trace s"out: ${_out.spaces41}"
        response PrintAndFlush _out
        request.AsyncContext.Complete()
    }

    def OutFailure(text: String): Unit = OutFailure(new RuntimeException(text))

    def Out(out: Response): Unit = {
        val _out = out.asJson
        logger trace s"out: ${_out.spaces41}"
        response PrintAndFlush _out
        request.AsyncContext.Complete()
    }

    def Out(out: Json): Unit = {
        logger trace s"out: ${out.spaces41}"
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
